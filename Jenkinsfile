@Library("CompilationLibrary") _
pipeline {

    agent any

    stages {
        stage("Hello world") {
            steps {
                sh( 'echo "Starting Jenkinsfile.."' )
                sh( 'ls -l' )
            }
        }
        stage("Compiling math") {
            steps {
                checkBasics( name:"math" )
                sh "cat new_mouli_log.txt"
            }
        }
    }
}
