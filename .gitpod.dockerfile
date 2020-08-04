FROM gitpod/workspace-full

RUN sudo apt-get update \
 && sudo apt-get install -y \
    p7zip-full \
 && sudo rm -rf /var/lib/apt/lists/*