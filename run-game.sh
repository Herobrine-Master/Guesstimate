#!/bin/bash
JAR_PATH=""
if [ -f "/home/user/app/guesstimate.jar" ]; then
    JAR_PATH="/home/user/app/guesstimate.jar"
elif [ -f "build/libs/guesstimate.jar" ]; then
    JAR_PATH="build/libs/guesstimate.jar"
elif [ -f "./guesstimate.jar" ]; then
    JAR_PATH="./guesstimate.jar"
fi

while true; do
    clear
    java -jar "$JAR_PATH"
    echo ""
    echo "===================================="
    echo "  Press Enter to play again..."
    echo "===================================="
    read -r
done
