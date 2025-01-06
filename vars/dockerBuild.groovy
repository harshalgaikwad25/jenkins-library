// vars/dockerBuild.groovy

def buildAndTag(String imageName = 'boardgame', String tag = 'latest', String registry = 'harshalgaikwad') {
    // Ensure Docker is available in the pipeline
    if (!tool('docker')) {
        error "Docker tool is not available!"
    }

    // Perform the Docker build and tag operations
    withDockerRegistry(credentialsId: 'docker-hub', toolName: 'docker') {
        // Building the Docker image
        sh "docker build -t ${imageName} ."

        // Tagging the Docker image
        sh "docker tag ${imageName} ${registry}/${imageName}:${tag}"
    }
}


