pipelineJob("simple-java-maven-app") {

        blockOn(['project-1']) { 
            blockLevel('GLOBAL') 
        }
        parameters {
            stringParam('VERSION')
        }
        environmentVariables {
            env('ONE', '1')
            env('TWO', '2')
        }

    definition {
        cpsScm {
            scm {
                git('https://github.com/shakir85/simple-java-maven-app.git', 'master', {node -> node / 'extensions' << '' })
            }
            scriptPath('jenkins/Jenkinsfile')
        }   
    }
}
