pipeline {
    agent any
    tools {maven "maven"}    
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package spring-boot:repackage'                
            }
        }    
        
        stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('sonar') {
                sh 'mvn clean sonar:sonar -Dsonar.sources=src/main/java/ -Dsonar.java.binaries=target/classes'
              }
            }
        }    
        
        stage('Run Application') {
            steps {                
                sh 'java -jar ./target/ecommerce-0.0.1-SNAPSHOT.jar &'
            }
        }       
    }
}
