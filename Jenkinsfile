pipeline {
    agent any

    stages {
        // stage('Checkout') {
        //     steps {
        //         // Checkout your code from version control
        //         // For example, if using Git
        //         git 'https://github.com/shiva2devops/selenium-scripts.git'
        //     }
        // }
        stage('Build') {
            steps {
                // Build your Maven project
                bat 'mvn clean test'
            }
        }
    }

    // post {
    //     always {
    //         // Archive test results
    //         junit 'target/surefire-reports/*.xml'
    //     }
    // }
}
