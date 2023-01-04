pipelineJob("simple-java-maven-app-${env.version}") {
    environmentVariables {
        env("foo", "bar")
        }

    folder = "myapps-/simple-mvn-app"
    folder(folder) { 
        displayName("gen-simple-mvn-app")
    }

    definition {
        cpsScm {
            scm {
                git('git@github.com:shakir85/simple-java-maven-app.git')
            }
        }   
        scriptPath('jenkins/Jenkinsfile')
    }
}
