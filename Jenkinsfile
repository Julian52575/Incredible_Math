@Library("Compilation") _
pipeline {
    agent { label "linux" }
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
