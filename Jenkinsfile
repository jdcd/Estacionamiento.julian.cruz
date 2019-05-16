pipeline {
	agent{
		label 'Slave_Induccion'
	}
	
	options{
		buildDiscarder(logRotator(numToKeepStr: '3'))
		disableConcurrentBuilds()
	}
	
	tools{
		jdk 'JDK8_Centos'
		gradle 'Gradle4.5_Centos'
	}
	
	stages{
		stage('ChackOut'){
			steps{
				echo "------------>Checkout<------------"
				checkout([
					$class: 'GitSCM',
					branches: [[name: '*/master']],
					doGenerateSubmoduleConfigurations: false,
					extensions: [],
					gitTool: 'Git_Centos',
					submoduleCfg: [],
					userRemoteConfigs: [[
						credentialsId: 'GitHub_julian.cruz)',
						url: 'https://github.com/jdcd/Estacionamiento.julian.cruz.git'
					]]
				])
				sh 'gradle clean'
			}
		}
		
		stage('Build') {
			steps{
				echo "------------>Build<------------"
				sh 'gradle --b ./build.gradle clean'
                sh 'gradle --b ./build.gradle build'
			}
		}
		
		stage('Unit Tests') {
			steps{
				echo "------------>Unit Tests<------------"
				sh 'gradle --stacktrace test'
				junit '**/build/test-results/test/*.xml' //aggregate test results - JUnit
				step([$class: 'JacocoPublisher'])
			}
		}
		
		stage('Integration test'){
			steps{
				echo "------------>Integration test<------------"
			}
		}
		
		
		
		stage('Static Code Analysis'){
			steps{
				echo "------------>Static Code Analysis<------------"
				 withSonarQubeEnv('Sonar') {
				 	echo "------------>Impresion del contenido<------------"
				 	sh "ls -l"
				 	echo "------------>Fin Impresion del contenido<------------"
				 	sh "${tool name: 'SonarScanner',type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
			 	}
			}
		}
		
		
	}
		
	post {
		always {
			echo 'This will always run'
		}
		success {
			echo 'This will run only if successful'
		}
		failure {
			echo 'This will run only if failed'
		}
		unstable {
			echo 'This will always only if unstable'
		}
		changed {
			echo 'This will run only if the state of the Pipeline has changed'
			echo 'For example, if the Pipeline was previously failing but is now successful'
		}
	}
}