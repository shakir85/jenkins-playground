pipelineJob('dsl-pipeline') {
    definition {
        cps {
            script(readFileFromWorkspace('jenkins-playground/jobs/freestyle.groovy'))
            sandbox()
        }
    }
}