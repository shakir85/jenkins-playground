folder('maven-app-job') { displayName('simple-java-maven-app') }

pipelineJob("${folder}/simple-java-maven-app") {

        environmentVariables {
            env('ONE', '1')
            env('TWO', '2')
        }
        blockOn(['project-1']) { blockLevel('GLOBAL') }
        parameters { stringParam('VERSION') }

    definition {
        cpsScm {
            scm {
                git('https://github.com/shakir85/simple-java-maven-app.git', 'master', {node -> node / 'extensions' << '' })
            }
            scriptPath('jenkins/Jenkinsfile')
        }   
    }
}
