pipeline {
  agent any

  stages {
    stage('Compile Stage') {
      steps {
        withMaven(maven : 'localMaven') {
          sh 'mvn clean compile'
        }
      }
    }
    
    stage('Testing Stage') {
      steps {
        withMaven(maven : 'localMaven') {
          sh 'mvn test'
        }
      }
    }

    stage('Install stage') {
      steps {
        withMaven(maven : 'localMaven') {
          sh 'mvn install'
        }
      }
    } 
  }
}
