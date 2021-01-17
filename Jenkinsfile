def getDockerTag(){
	def tag = sh script: 'git rev-parse HEAD' , returnStdout:true
	return tag
}

pipeline {
  
  environment {
    Docker_tag = getDockerTag()
	JAVA_TOOL_OPTIONS = '-Duser.home=/var/maven'
  }
  
  agent {
       docker {
	      image 'maven'
		  label 'docker'
	      args '-v /tmp/maven:/var/maven/.m2 -e MAVEN_CONFIG=/var/maven/.m2'
	    }
      }

  stages {
    stage('Maven Stage') {
      steps {
	        sh 'mvn --version'
            sh 'mvn clean install'
		}
	 }
    
    stage('Docker Build') {
      steps {
        script {
          sh 'docker build . -t m1048858/mycalc:Docker_tag'
		  withCredentials([string(credentialsId: 'docker_hub', variable: 'docker_hub_credential')]) {
		    sh 'docker login -u m1048858 -p $docker_hub'
			sh 'docker push m1048858/mycalc:Docker_tag'
		  }
        }
      }
    }
  }
  post {
	  always {
	    cleanWs()
	  }
	}
}
