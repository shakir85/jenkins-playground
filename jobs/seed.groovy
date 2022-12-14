pipelineJob('Hello-world') {
    definition {   
        description("Hello world job") 
        cps {
            script(readFileFromWorkspace('jenkins-playground/pipelines/helloWorld/Jenkinsfile'))
            sandbox()
        }
    }
}
