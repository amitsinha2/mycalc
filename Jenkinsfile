node {
    stage('Scm checkout') {
        git branch: 'main', credentialsId: 'GitHubUserNameCredentials', url: 'https://github.com/amitsinha2/mycalc.git'
    }
    stage('Maven Package') {
	    def mvnHome = tool name: 'localMaven', type: 'maven'
		def mvnCMD = "${mvnHome}/bin/mvn"
	    sh "${mvnCMD} clean package"
	}
	stage('Build Docker Image') {
	   sh "docker build -t m1048858/mycalc:${BUILD_NUMBER} ."
	}
	stage('Push Docker Image') {
	   withCredentials([string(credentialsId: 'docker_hub', variable: 'docker_hub_pwd')]) {
		    sh "docker login -u m1048858 -p ${docker_hub_pwd}"
			sh "docker push m1048858/mycalc:${BUILD_NUMBER}"
		  }
	}
	stage('Run Container on Dev Server - Docker pull Image') {
	try {
	   def processId = sh returnStdout: true, script: 'docker ps -aq'
	   sh "echo ${processId}"
	   if(processId != null) {
	    sh "docker stop my-calc-app"
	    sh "docker rm my-calc-app"
	   }
	 } catch (Exception ex) {
		println("Unable to remove container: ${ex}")
	   }
	   sh "echo ${BUILD_NUMBER}"
	   sh "docker run -p 8083:8083 -d --name my-calc-app m1048858/mycalc:${BUILD_NUMBER}"
	}
}
