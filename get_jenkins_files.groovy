job( 'Get Jenkins Files' ) {

    scm {
        cloneWorkspace( 'Julian52575/Jenkins.git' )
    }
    steps {
        shell('ls')
    }
}

job( 'TEST_JOB_SCRIPT' ) {
    steps {
        systemGroovyCommand( 'Jenkins/math/*.groovy' )

        systemGroovyCommand( 'Jenkins/math/dsl_math.groovy' )
    }
}

