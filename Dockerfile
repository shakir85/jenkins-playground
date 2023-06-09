FROM alpine:latest

COPY script.sh /usr/local/bin

WORKDIR /app/

RUN chmod +x /usr/local/bin/script.sh

ENTRYPOINT [ "script.sh" ]

# docker build --no-cache -t foo:latest .
# docker run -v ./output:/app --rm foo:latest 
