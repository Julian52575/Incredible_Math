@Library("CompilationLibrary") _
pipeline {
    agent any

    parameters {
        hasCompiled: 0
    }

    stages {
        
        stage("Hello world") {
            steps {
                sh( 'echo "Starting Jenkinsfile.."' )
                sh( 'ls -l' )
            }
        }

        stage("Check Basics") {
            steps {
                checkBasics( name:"math" )
                sh 'cat new_mouli_log.txt'
            }
        }

        stage("Check in-depth") {
            when { expression { params.hasCompiled == 0 } }
            steps {
                sh 'cat params.hasCompiled'
                runTest(
                    name:"1+1",
                    cmd:"./math + 1 1 ",
                    expOutput:"Your result is 2.",
                    expReturnValue:"0"
               )

                runTest(
                    name:"a+b",
                    cmd:"./math + a b ",
                    expOutput:"[Error] Invalid number 1.",
                    expReturnValue:"84"
                )
            }
        }

    }
    post {
        // Clean after build
        always {
            sh 'cat -e new_mouli_log.txt'
            cleanWs(cleanWhenNotBuilt: false,
                    deleteDirs: true,
                    disableDeferredWipeout: true,
                    notFailBuild: true,
                    patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
                               [pattern: '.propsfile', type: 'EXCLUDE']])
        }
    }
}
