@Library("Compilation") _
pipeline {

    stages {
        stage('Hello world') {
            steps {
                sh( ' echo "Hello world"' )
            }
        }


        stage('Compilation') {
            steps {
                checkCompilation(name:"math")
            }
        }
    }
}

