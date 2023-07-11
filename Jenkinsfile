@Library("Compilation") _
pipeline {

    agent any

    stages {
        stage("Hello world") {
            steps {
                sh( 'echo "Hello World"' )
            }
        }
        stage("Compiling math") {
            steps {
                checkCompilation( name:"math" )
            }
        }
    }
}
