
}
    def dockerImage = "ghcr.io/epitech/coding-style-checker:latest"

    

        stage('Code Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://github.com/Julian52575/Incredible_Math.git']]
                ])
            }
        }