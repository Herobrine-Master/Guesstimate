#!/bin/bash
PORT="${PORT:-7860}"
exec ttyd -W -p "$PORT" -t fontSize=18 -t theme='{"background":"#1a1b26","foreground":"#c0caf5"}' /home/user/app/run-game.sh
