@Library("CompilationLibrary") _
pipeline {
    agent any

    parameters {
        string(name: 'ProjectName', defaultValue: 'Incredible Math')
        string(name: 'Author', defaultValue: 'Julian Bottiglione', description: 'he who started it all')
        string(name: 'Email', defaultValue: 'julian.bottiglione@epitech.eu', description: 'the email that will receive the log')
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
                script {
                    env.hasCompiled = checkBasics(
                        name:"math",
                        author:params.Author
                    )
                }
            }
        }

        stage("Check in-depth") {
            //when {
            //    expression { return env.hasCompiled == 0 }
            //}
            steps {
                printTable()
                runTestFromCSV()
                printTableEnd()
            }
        }
    }
    post {
        always {
            sendEmailReport( projectName:params.ProjectName )
            
            // Clean after build
            cleanWs(cleanWhenNotBuilt: true,
                    deleteDirs: true,
                    disableDeferredWipeout: false)
        }
    }
}
