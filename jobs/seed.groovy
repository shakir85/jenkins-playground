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
    
    parameters{
        stringParam('Tool', defaultValue='mvn', description='Version check tool')
        choiceParam('Args', ['--version (default)', '--help'])
    }

    wrappers {
        colorizeOutput()
        timestamps()
    }

    steps {
        shell """
        GREEN='\033[0;32m'; NC='\033[0m'
        printf '$GREEN Test DSL jobs! $NC'
        mvn --version
        """
    }
}