def getDockerTag(){
	def tag = sh script: 'git rev-parse HEAD' , returnStdout:true
	return tag
}

pipeline {
  agent any
  
  environment {
    Docker_tag = getDockerTag()
  }

  stages {
    stage('Maven Stage') 
	  agent {
        docker {
	      image 'maven'
	      args '-v $HOME/.m2:/root/.m2'
	    }
      }
      steps {
        script {
		  withMaven(maven : 'localMaven') {
            sh 'mvn clean install'
          }
		}
      }
    
    stage('Docker Build') {
      steps {
        script {
          sh 'docker build . -t m1048858\mycalc:Docker_tag'
		  withCredentials([string(credentialsId: 'docker_hub', variable: 'docker_hub_credential')]) {
		    sh 'docker login -u m1048858 -p $docker_hub'
			sh 'docker push m1048858\mycalc:Docker_tag'
		  }
        }
      }
    }
  }
}
