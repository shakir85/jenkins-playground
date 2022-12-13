FROM jenkins/jenkins:lts
# broken, need to switch to user root
RUN apt-get update && apt-get --no-install-recommends install maven git -y
