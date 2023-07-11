
job( 'Get Jenkins Files' ) {

    scm {
        github( 'Julian52575/Jenkins.git' )
    }

    steps {
        shell( 'git clone git@github.com:Julian52575/Jenkins.git a' )
        systemGroovyCommand( 'a/.groovy*' )
    }

}

