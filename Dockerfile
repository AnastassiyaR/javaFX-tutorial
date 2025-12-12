FROM maven:3.8-eclipse-temurin-11
RUN apt-get update && apt-get install -y \
    libgl1 \
    libgtk-3-0 \
    libxtst6 \
    libxrender1 \
    libxi6 \
    x11vnc \
    xvfb \
    fluxbox \
    git \
    python3 \
    python3-numpy \
    && rm -rf /var/lib/apt/lists/*
RUN git clone https://github.com/novnc/noVNC.git /opt/novnc && \
    git clone https://github.com/novnc/websockify /opt/novnc/utils/websockify && \
    ln -s /opt/novnc/vnc.html /opt/novnc/index.html
WORKDIR /app
COPY . .
RUN mvn dependency:go-offline -B || true
RUN echo '#!/bin/bash\n\
export DISPLAY=:99\n\
Xvfb :99 -screen 0 1280x720x24 &\n\
sleep 2\n\
fluxbox &\n\
x11vnc -display :99 -forever -shared -rfbport 5900 -nopw &\n\
sleep 1\n\
/opt/novnc/utils/novnc_proxy --vnc localhost:5900 --listen 6080 &\n\
sleep 2\n\
cd /app && mvn javafx:run' > /app/start.sh && chmod +x /app/start.sh
EXPOSE 5900 6080
CMD ["/app/start.sh"]