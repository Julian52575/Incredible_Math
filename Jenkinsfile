@Library("CompilationLibrary") _
pipeline {
    agent any

    parameters {
        string(name: 'Author', defaultValue: 'Julian Bottiglione', description: 'he who started it all')
        string(name: 'Email', defaultValue: 'julian.bottiglione@epitech.eu', description: 'the email that will receive the log')
    }

    environment {
        projectName = "Incredible Maths"
        hasCompiled = 0
        logContent = "hi"
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
        always {
            logContent = sh (
                script: 'cat new_mouli_log.txt',
                returnStdout: true )

            //send file to eMail
            emailext body: '${environment.Logs}',
            subject: '[New Mouli] Logs for ${environment.projectName}',
            to: params.Email,
            attachmentsPattern: 'new_mouli_log.txt'
            
            // Clean after build
            cleanWs(cleanWhenNotBuilt: true,
                    deleteDirs: true,
                    disableDeferredWipeout: false)
        }
    }
}
