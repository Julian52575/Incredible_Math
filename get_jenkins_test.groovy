job( 'Get Jenkins Files' ) {
    environmentVariables(REPO: 'git@github.com:Julian52575/Jenkins.git')

    scm {
        git {
            remote {
                name('Jenkins Files')
                url( REPO )
            }
        }
    }
}

