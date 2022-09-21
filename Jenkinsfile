pipeline {
    agent any
    stages {
        stage("Clean Up"){
            steps {
                deleteDir() //Clean current working dir
            }
        }
        stage("Clone Repo"){
            steps{
                sh "git clone https://github.com/jenkins-docs/simple-java-maven-app.git"
            }
        }
        stage("Build"){
            steps{
                dir("simple-java-maven-app"){  // cd to repo dir
                    sh "mvn clean install"
                }
            }
        }
        stage("Test"){
            steps{
                dir("simple-java-maven-app"){
                    sh "mvn test"
                }
            }
        }
        stage("Complete"){
            steps{
                echo "Job completed"
            }
        }
    }
}
