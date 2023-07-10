job( 'Get Jenkins Files' ) {

    environmentVariables(REPO: 'Julian52575/Jenkins.git')

    scm {
        github( '${REPO}' )
    }

}
