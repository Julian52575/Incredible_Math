@Library("Compilation") _
pipeline {

    stages {
        stage('Hello world') {
            steps {
                sh( ' echo "Hello world"' )
            }
        }

        stage('Code Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://github.com/Julian52575/Incredible_Math.git']]
                ])
            }
        }

        stage('Compilation') {
            steps {
                checkCompilation(name:"math")
            }
        }
    }
}

