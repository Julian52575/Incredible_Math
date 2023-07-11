job( 'Get Jenkins Files' ) {

    scm {
        cloneWorkspace( 'Julian52575/Jenkins.git' )
    }
    steps {
        shell('ls')
        echo("hello world")
    }
}

job( 'TEST_JOB_SCRIPT' ) {
    steps {
        systemGroovyCommand( '*.groovy' )
    }
}

