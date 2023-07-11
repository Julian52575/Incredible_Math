job('Fetch and Execute Groovy Files') {
  scm {
    git {
      remote {
        url( 'https://github.com/Julian52575/Jenkins.git' )
      }
      branch('main') // Specify the branch you want to fetch from
    }
  }

  steps {
    script {
      // Fetch the Groovy files from the repository
      def groovyFiles = findFiles(glob: '**/*.groovy')

      // Execute each Groovy file as a Jenkins job
      groovyFiles.each { groovyFile ->
        def groovyScript = readFile(groovyFile)
        def jobName = groovyFile.name.replace('.groovy', '')
        
        // Create a new Jenkins job dynamically using the Groovy script
        job(jobName) {
          steps {
            script {
              // Execute the Groovy script as a Jenkins job
              systemGroovyScript(groovyScript)
            }
          }
        }
      }
    }
  }
}
