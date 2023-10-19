@Library("CompilationLibrary") _
pipeline {
    agent any

    parameters {
        string(name: 'Author', defaultValue: 'Julian Bottiglione', description: 'he who started it all')
        string(name: 'hasCompiled', defaultValue: '0', description: 'has the binary compiled succesfully?')
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
            when { expression { params.hasCompiled == "0" } }
            steps {
                sh "echo params.hasCompiled"
                runTest(
                    name:"1+1",
                    cmd:"./math + 1 1 ",
                    expOutput:"Your result is 2.",
                    expReturnValue:"0"
               )

                runTest(
                    name:"a+b",
                    cmd:"./math + a b ",
                    expOutput:"[Error] Invalid number 1.",
                    expReturnValue:"84"
                )
            }
        }

    }
    post {
        // Clean after build
        always {
            sh 'cat -e new_mouli_log.txt'
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
