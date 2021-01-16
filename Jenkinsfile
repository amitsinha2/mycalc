pipeline {
  environment {
    registry = "m1048858/mycalc"
    registryCredential = 'docker_hub'
  }
  agent any
  stages {
        stage('Building image') {
        steps{
            script {
            dockerImage = docker.build registry + ":$BUILD_NUMBER"
            }
        }
        }

        stage('Deploy Image') {
        steps{
            script {
            docker.withRegistry( '', 'docker_hub' ) {
                dockerImage.push()
            }
            }
        }
        }

        stage('Remove Image') {
        steps{
            sh "docker rmi $registry:$BUILD_NUMBER"
        }
        }
   }   
}

node {
    stage('Execute Image'){
        def customImage = docker.build("m1048858/mycalc:${env.BUILD_NUMBER}")
        customImage.inside {
            sh 'echo This Pipeline execution is inside the container.'
        }
    }
}
