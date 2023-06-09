pipeline {
    agent any
    environment{
      TAG = 'latest'
    }
    stages {
        stage("Build Image"){
            steps{
                sh "docker build -t custome:$TAG ."
            }
        }
    }
}