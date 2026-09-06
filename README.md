---
title: Guesstimate
emoji: 🎯
colorFrom: blue
colorTo: indigo
sdk: gradio
sdk_version: 4.44.0
app_port: 7860
pinned: false
---

# Guesstimate

A multiplayer console trivia guessing game written in Java and playable directly in the browser via a web terminal (`ttyd`) running Java 25.

## Free Online Deployment Options

### Option 1: Hugging Face Spaces (100% Free Forever)
1. Go to [huggingface.co/new-space](https://huggingface.co/new-space).
2. Choose **Space name**: `Guesstimate`.
3. Under **Select the Space SDK**, select **Gradio** (Free 16GB RAM tier).
4. Select **Public**, then click **Create Space**.
5. Push this repository to your Space:
   ```bash
   git remote add space https://huggingface.co/spaces/<your-username>/Guesstimate
   git push space main
   ```
6. Your game is live at `https://huggingface.co/spaces/<your-username>/Guesstimate`!

### Option 2: Render.com (100% Free Web Service)
1. Go to [dashboard.render.com](https://dashboard.render.com) and click **New** > **Web Service**.
2. Connect your GitHub repository `Herobrine-Master/Guesstimate`.
3. Select **Docker** environment and the **Free** instance type.
4. Click **Create Web Service**. Render builds the Docker container and provides an instant `https://<app>.onrender.com` URL.

