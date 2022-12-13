// Seed scripts to generate Jenkins pipelines as code.
// This script is triggered by an upstream freestyle job: 'seed'
// and generates various downstream pipeline-jobs for each 'pipelineJob' block below.
pipelineJob('simple-java-maven-app') {
    definition {
        cps {
            // script this pipeline is going to use for builds (file relative to the seed workspace path).
            script(readFileFromWorkspace('jenkins-playground/pipelines/simple-java-maven-app/Jenkinsfile'))
            sandbox()
        }
    }
}

pipelineJob('Hello-world') {
    definition {
        cps {
            // script this pipeline is going to use for builds (file relative to the seed workspace path).
            script(readFileFromWorkspace('jenkins-playground/pipelines/helloWorld/Jenkinsfile'))
            sandbox()
        }
    }
}
