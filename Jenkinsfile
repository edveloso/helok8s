

pipeline {
    
    agent any
    
    tools {
        maven "M3"
    }
    
    stages {
        
        stage('Build'){
            steps {
                git 'http://localhost:3000/edveloso/helok8s.git'
                //sh ' pwd && ls'
                sh 'mvn -Dmaven.test.failure.ignore=true clean package '
            }
            
            post {
                success {
                  junit '**/target/surefire-reports/TEST-*.xml'
                  archiveArtifacts 'target/*.jar'
                }
            }
        
        }
        
        stage('Docker build, push'){
            steps {
               withDockerRegistry(credentialsId: '07e8cea7-b637-42d5-a133-cd8b978d7085', url: 'https://index.docker.io/v1/') {
                    sh 'docker build -t edveloso/helok8s:${BUILD_NUMBER} .'
                    sh 'docker push edveloso/helok8s'
                } 
            }
        }
        
        stage('Deploy Kubernetes') {
            
            steps {
                
                sh 'kubectl apply -f k8s/deploy.yml'
                sh 'kubectl apply -f k8s/service.yml'
                sh 'kubectl apply -f k8s/ing.yml'
                
            }
            
        }
        
       
        
         
        
    }
    
    
}
