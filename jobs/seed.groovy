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

job('autopilot-dsl-job') {
    
    description('Testing DSL jobs')

    displayName('Auto-Pilot DSL Job')
    
    parameters{
        stringParam('Tool', defaultValue='mvn', description='Version check tool')
        choiceParam('Args', ['--version (default)', '--help'])
    }

    wrappers {
        colorizeOutput()
        timestamps()
    }

    steps {
        shell("echo 'Test DSL jobs!'")
        shell("mvn --version")
    }
}