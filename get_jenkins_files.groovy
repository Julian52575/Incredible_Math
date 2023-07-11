
job( 'Get Jenkins Files' ) {

    scm {
        github( 'Julian52575/Jenkins.git' )
    }

    triggers {
        scm( 'H/2 * * * *' )
    }

    steps {
        shell( readFileFromWorkspace( 'Jenkins/dsl_math.groovy'  ) )
    }

    postBuildSteps( 'SUCCESS' ) {
        shell( "echo 'SUCCESS' " )
    }

}

