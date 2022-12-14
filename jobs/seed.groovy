parameters {
    stringParam('myParameterName', 'my default stringParam value', 'my description')
    choiceParam('deployParam', ['dev (default)', 'test', 'prod'], 'Select deploy environment')
        booleanParam('Required', false)
}

pipelineJob('Hello-world') {
    definition {

        description("Hello world job") 
        
        cps {
            script(readFileFromWorkspace('jenkins-playground/pipelines/helloWorld/Jenkinsfile'))
            sandbox()
        }
    }
}
