@Library("Compilation") _
pipeline {

    stages {

        stage('Cleanup Workspace') {
            steps {
                cleanWs()
                sh """
                echo "Cleaned Up Workspace for ${APP_NAME}"
                """
            }
        }

        stage('Code Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
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

