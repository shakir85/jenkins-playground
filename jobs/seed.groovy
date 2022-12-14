preBuildSteps {
            shell("echo 'this is a hello world step' >> file")
        }
pipelineJob('Hello-world') {
    definition {   
        description("Hello world job") 
        
        parameters {
            stringParam('myParameterName', 'my default stringParam value', 'my description')
            choiceParam('deployParam', ['dev (default)', 'test', 'prod'], 'Select deploy environment')
             booleanParam('Required', false)
        }

        cps {
            script(readFileFromWorkspace('jenkins-playground/pipelines/helloWorld/Jenkinsfile'))
            sandbox()
        }
    }
}
