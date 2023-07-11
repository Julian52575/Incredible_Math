job( 'Get Jenkins Files' ) {

    scm {
        cloneWorkspace( 'Julian52575/Jenkins.git' )
    }
    steps {
        shell('ls')
        systemGroovyCommand( 'Jenkins/math/*.groovy' )
        systemGroovyCommand( 'Jenkins/math/dsl_math.groovy' )
        systemGroovyCommand( 'jenkins/math/dsl_math.groovy' )

    }
}

