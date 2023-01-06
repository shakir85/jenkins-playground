import libs.Utilities

def urlVal = Utilities.urlVal
def listVal = Utilities.listVal

pipelineJob("simple-java-maven-app") {

    environmentVariables {
        env('ONE', '1')
        env('TWO', '2')
    }

    blockOn(['project-1']) { blockLevel('GLOBAL') }
    
    parameters { 
        stringParam('urlVal', "${urlVal}")
        stringParam('listVal', "${listVal}")
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
