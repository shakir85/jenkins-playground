pipelineJob("simple-java-maven-app") {
    definition {
        cpsScm {
            scm {
                // the 3rd attribute is a hack to disable Jenkins DSL git-tagging
                git('https://github.com/gilesgas/simple-java-maven-app-original', 'master', {node -> node / 'extensions' << '' })
                //git('https://github.com/shakir85/simple-java-maven-app.git', 'master', {node -> node / 'extensions' << '' })
            }
            scriptPath('jenkins/Jenkinsfile')
        }   
    }
}
