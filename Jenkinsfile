pipeline {
  agent any
  stages {
    stage('Echo Command') {
      steps {
        sh 'echo "This is build num: $BUILD_NUMBER for var: $DEMO"'
      }
    }

  }
  environment {
    DEMO = 'thisisdemoval'
  }
}