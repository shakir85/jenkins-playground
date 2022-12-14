// Seed scripts to generate Jenkins pipelines as code.
// This script is triggered by an upstream freestyle job: 'seed'
// and generates various downstream pipeline-jobs for each 'pipelineJob' block below.
//
// Pipeline blocks are idempotent + removning a job doesn't delete it from Jenkins (no jobs state mgmt).
pipelineJob('simple-java-maven-app') {
    definition {
        cpsScm {
            scm {
                git('https://github.com/shakir85/simple-java-maven-app.git')
                branch('main')
                git {
                    extensions {
                        cloneOptions {
                            noTags(noTags = true)
                        }
                    }
                }
            }
        }
    }
}

pipelineJob('Hello-world') {
    definition {
        description("Hello world job")
        cps {
            // path to Jenkins file this pipeline is going to use for builds 
            // (path is relative to the seed workspace path).
            script(readFileFromWorkspace('jenkins-playground/pipelines/helloWorld/Jenkinsfile'))
            sandbox()
        }
    }
}
