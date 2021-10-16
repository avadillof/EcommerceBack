pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package spring-boot:repackage'
                sh 'java -jar ./target/ ecommerce-0.0.1-SNAPSHOT.jar'
            }
        }        
    }
}
