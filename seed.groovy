import libs.Utilities

def mapVal = Utilities.mapVal

pipelineJob("simple-java-maven-app") {

    def urlVal = Utilities.urlVal

    environmentVariables {
        env('ONE', '1')
        env('TWO', '2')
    }

    blockOn(['project-1']) { blockLevel('GLOBAL') }
    
    parameters { 
        stringParam('VERSION')
        stringParam('urlVal', "${urlVal}")
        stringParam('urlVal', "${mapVal}")
    }

    definition {
        cpsScm {
            scm {
                // the 3rd attribute is a hack to disable Jenkins DSL git-tagging
                git('https://github.com/shakir85/simple-java-maven-app.git', 'master', {node -> node / 'extensions' << '' })
            }
            scriptPath('jenkins/Jenkinsfile')
        }   
    }
}
