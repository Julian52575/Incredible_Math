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
    fileOperations {
      filesMatching('**/*.groovy') {
        def groovyFile = it.path
        def groovyScript = readFile(groovyFile)
        def jobName = groovyFile.replace('.groovy', '')

        job(jobName) {
          steps {
            systemGroovyScript(groovyScript)
          }
        }
      }
    }
  }
}
