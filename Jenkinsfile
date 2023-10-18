@Library("CompilationLibrary") _
pipeline {
    agent any

    parameters {
        choice(
            hasCompiled: 0)
    }

    stages {
        stage("Hello world") {
            steps {
                sh( 'echo "Starting Jenkinsfile.."' )
                sh( 'ls -l' )
            }
        }
        stage("Check Basics") {
            steps {
                checkBasics( name:"math" )
                sh "cat new_mouli_log.txt"
            }
        }
        when {
            expression { params.hasCompiled == 0 }
        }
        stage("Check in-depth") {
            sh( 'echo "Checking in-depth..."' )
        }

    post {
        // Clean after build
        always {
            cleanWs(cleanWhenNotBuilt: false,
                    deleteDirs: true,
                    disableDeferredWipeout: true,
                    notFailBuild: true,
                    patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
                               [pattern: '.propsfile', type: 'EXCLUDE']])
        }
    }
    }
}
