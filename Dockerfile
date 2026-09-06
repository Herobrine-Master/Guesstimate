# Stage 1: Build the JAR with Gradle
FROM eclipse-temurin:25-jdk AS builder
WORKDIR /app
COPY gradlew gradlew.bat settings.gradle.kts build.gradle.kts ./
COPY gradle gradle
COPY src src
RUN chmod +x gradlew && ./gradlew jar --no-daemon

# Stage 2: Runtime container with OpenJDK 25 and ttyd
FROM eclipse-temurin:25-jre

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        curl \
        ca-certificates \
    && rm -rf /var/lib/apt/lists/*

# Install ttyd web terminal
RUN ARCH=$(uname -m) && \
    if [ "$ARCH" = "x86_64" ]; then TTYD_ARCH="x86_64"; \
    elif [ "$ARCH" = "aarch64" ]; then TTYD_ARCH="aarch64"; \
    else TTYD_ARCH="x86_64"; fi && \
    curl -sLo /usr/local/bin/ttyd "https://github.com/tsl0922/ttyd/releases/download/1.7.7/ttyd.${TTYD_ARCH}" && \
    chmod +x /usr/local/bin/ttyd

# Run as non-root user (UID 1000 required for Hugging Face Spaces)
RUN if id -u 1000 >/dev/null 2>&1; then \
        userdel -f -r "$(id -un 1000)" 2>/dev/null || true; \
    fi && \
    if getent group 1000 >/dev/null 2>&1; then \
        groupdel "$(getent group 1000 | cut -d: -f1)" 2>/dev/null || true; \
    fi && \
    useradd -m -u 1000 user
WORKDIR /home/user/app

COPY --from=builder /app/build/libs/guesstimate.jar /home/user/app/guesstimate.jar
COPY run-game.sh /home/user/app/run-game.sh
COPY entrypoint.sh /home/user/app/entrypoint.sh

RUN chmod +x /home/user/app/run-game.sh /home/user/app/entrypoint.sh && \
    chown -R user:user /home/user

USER user
EXPOSE 7860

ENTRYPOINT ["/home/user/app/entrypoint.sh"]
