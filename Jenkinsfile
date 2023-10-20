@Library("CompilationLibrary") _
pipeline {
    agent any

    parameters {
        string(name: 'Author', defaultValue: 'Julian Bottiglione', description: 'he who started it all')
    }

    environment {
        hasCompiled = "0"
    }

    stages {
        
        stage("Hello world") {
            steps {
                sh( 'echo "Starting Jenkinsfile.."' )
            }
        }

        stage("Check Basics") {
            steps {
                checkBasics( 
                    name:"math",
                    author:params.Author
                )
            }
        }

        stage("Check in-depth") {
            steps {
                sh "echo Starting Check in-depth"
                runTest( name:"1 + 1" )
            }
        }
    }
    post {
        // Clean after build
        always {
            sh 'cat new_mouli_log.txt'
            sh 'ls -l'
            //cleanWs(cleanWhenNotBuilt: false,
            //        deleteDirs: true,
            //        disableDeferredWipeout: true,
            //        notFailBuild: true,
            //        patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
            //                   [pattern: '.propsfile', type: 'EXCLUDE']])
        }
    }
}
