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
        systemGroovyCommand( '*.groovy' )
    }
}

