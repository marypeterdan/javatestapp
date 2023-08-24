pipeline {
    agent any 
        tools {
            maven 'Maven_3.8.6'
        }
    stages{ 
        stage('compilation stage') { 
            steps {
                  bat "mvn clean compile"
  
            }
        }
        stage('testing stage') { 
            steps {
               bat "mvn test"
            }
        }
        
    }
}
