import os
import platform
import stat
import subprocess
import urllib.request

# Ensure gradlew has execute permissions and build the JAR
jar_path = os.path.join("build", "libs", "guesstimate.jar")
if not os.path.exists(jar_path):
    if os.path.exists("gradlew"):
        os.chmod("gradlew", 0o755)
        print("Building Guesstimate JAR with Gradle...")
        subprocess.run(["./gradlew", "jar", "--no-daemon"], check=True)

# Ensure shell scripts have execute permissions
for script in ["run-game.sh", "entrypoint.sh"]:
    if os.path.exists(script):
        os.chmod(script, 0o755)

port = os.environ.get("PORT", "7860")
arch = platform.machine().lower()
ttyd_arch = "aarch64" if ("arm" in arch or "aarch64" in arch) else "x86_64"
ttyd_bin = "./ttyd"

if not os.path.exists(ttyd_bin):
    url = f"https://github.com/tsl0922/ttyd/releases/download/1.7.7/ttyd.{ttyd_arch}"
    print(f"Downloading ttyd from {url}...")
    urllib.request.urlretrieve(url, ttyd_bin)
    os.chmod(ttyd_bin, 0o755)

print(f"Starting Guesstimate web terminal on port {port}...")
os.execv(
    ttyd_bin,
    [
        ttyd_bin,
        "-W",
        "-p",
        str(port),
        "-t",
        "fontSize=18",
        "-t",
        'theme={"background":"#1a1b26","foreground":"#c0caf5"}',
        "bash",
        "run-game.sh",
    ],
)
