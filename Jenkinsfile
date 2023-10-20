@Library("CompilationLibrary") _
pipeline {
    agent any

    parameters {
        string(name: 'Author', defaultValue: 'Julian Bottiglione', description: 'he who started it all')
    }

    environment {
        hasCompiled = 0
    }

    stages {
        
        stage("Hello world") {
            steps {
                sh( 'echo "Starting Jenkinsfile.."' )
            }
        }

        stage("Check Basics") {
            steps {
                checkBasics(
                    name:"math",
                    author:params.Author
                )
            }
        }

        stage("Check in-depth") {
            steps {
                sh "echo Starting Check in-depth"
                printTable() 
                runTest(
                    name:"1+1",
                    cmd:"./math + 1 1 ",
                    expOutput:"Your result is 2.",
                    expReturnValue:0
               )

                runTest(
                    name:"a+b",
                    cmd:"./math + a b ",
                    expOutput:"[Error] Invalid number 1.",
                    expReturnValue:84
                )


            }
        }
    }
    post {
        // Clean after build
        always {
            sh 'cat new_mouli_log.txt'
            sh 'ls -l'
            cleanWs(cleanWhenNotBuilt: false,
                    deleteDirs: true,
                    disableDeferredWipeout: false,
                    notFailBuild: true,
                    patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
                               [pattern: '.propsfile', type: 'EXCLUDE']])
            sh 'ls -l'
        }
    }
}
