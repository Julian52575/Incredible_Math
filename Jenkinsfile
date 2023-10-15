@Library("CompilationLibrary") _
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
                def codingErrors = 0

                checkCompilation( name:"math" )
                checkMakefileClean( name:"math" )
                codingErrors = checkCodingStyle()
                echo "codingErrors"
            }
        }
    }
}
