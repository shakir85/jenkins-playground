pipeline {
    agent any
    environment {
        TAG='0.01'
        IMG='imagename'
        NAME='containername'
        EXPORT="${WORKSPACE}/export"
        PROJECT='/path/to/project'
    }
    stages {
        stage('Build Docker Image') {
            steps {
                sh "docker build --no-cache -t ${env.IMG}:${env.TAG} ."
            }
        }
        stage('Run Container') {
            steps {
                sh "echo \"Working in: ${env.WORKSPACE}\""
                sh """
                docker run -d --rm --name ${env.NAME} \
                -v ${env.EXPORT}:/app \
                ${env.IMG}:${env.TAG}
                """
            }
        }        
    }
    post{
        success {
             echo "Job completed successfully! build num: ${BUILD_NUMBER}"
        }
    }
}