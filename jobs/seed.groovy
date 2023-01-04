pipelineJob("simple-java-maven-app") {
    definition {
        cpsScm {
            scm {
                git('https://github.com/shakir85/simple-java-maven-app.git', 'master', {node -> node / 'extensions' << '' })
            }
            scriptPath('jenkins/Jenkinsfile')
        }   
    }
}
