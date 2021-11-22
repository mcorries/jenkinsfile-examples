pipeline {
  agent any
  stages {

    stage('Stage 1') {
      steps {
        script {
          RUN_STAGE_2 = true
          FLAG_A = true
          FLAG_B = false
          echo '***||||||Stage 1||||||||***'
        }
      }
    }

    stage('Stage 2') {
      when {
        expression { RUN_STAGE_2 }
        anyOf {
          expression { FLAG_A }
          expression { FLAG_B }
        }
        beforeAgent true
      }
      steps {
        script {
          echo '***|||||||Stage 2||||||||||****'
        }
      }
    }

  }
}
