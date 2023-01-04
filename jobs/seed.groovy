pipelineJob("simple-java-maven-app") {
    definition {
        cpsScm {
            scm {
                git('https://github.com/shakir85/simple-java-maven-app.git')
            }
            scriptPath('jenkins/Jenkinsfile')
        }   
    }
}

    // environmentVariables {
    //     env("foo", "bar")
    //     }

    // folder = "myapps-/simple-mvn-app"
    // folder(folder) { 
    //     displayName("gen-simple-mvn-app")
    // }