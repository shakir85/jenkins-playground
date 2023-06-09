pipeline {
  agent any
  stages {
    stage('echo variable') {
      steps {
        echo 'This is build num: $BUILD_NUMBER for var: $DEMO'
      }
    }

  }
  environment {
    DEMO = 'thisisdemoval'
  }
}