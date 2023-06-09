FROM jenkins/jenkins:lts
USER root
RUN apt-get update && apt-get --no-install-recommends install maven git -y
