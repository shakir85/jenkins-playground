pipelineJob('Hello-world') {
    definition {   
        description("Hello world job") 
        parameters{
            stringParam('myParameterName', 'my default stringParam value', 'my description')
        }
        cps {
            script(readFileFromWorkspace('jenkins-playground/pipelines/helloWorld/Jenkinsfile'))
            sandbox()
        }
    }
}
