environmentVariables {
        env('version', '01')
    }

folder = "myapps-${env.version}/simple-mvn-app"
folder(folder) { 
        displayName("gen-simple-mvn-app")
    }

pipelineJob("simple-java-maven-app-${env.version}") {
    definition {
        cpsScm {
            scm {
                git('git@github.com:shakir85/simple-java-maven-app.git')
            }
        }
        scriptPath('jenkins/Jenkinsfile')
    }
}
