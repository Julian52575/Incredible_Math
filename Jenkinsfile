@Library("CompilationLibrary") _
pipeline {
    agent any

    parameters {
        hasCompiled: 0
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

        stage("Check in-depth") {
            when { expression { params.hasCompiled == 0 } }
            steps {
                sh( 'echo "Checking in-depth..."' )
            }
        }

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
