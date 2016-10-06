# rest-cache-proxy

Simple Spring Boot dockerized application for REST query caching.

Project features:
- ehCache 3 persistent cache with recovery on application restart
- deployable as a docker container built with docker-maven-plugin
- multiple application profiles for dev/production usage

#### Building the application/container

- check if Docker is running
		`$docker ps`
	and current user has admin privileges
- inside project root run:

		`mvn package docker:build`

#### Running the container (Linux)

- again check if Docker is running and user has admin privileges
- enter the following command:

		`docker run -e "SPRING_PROFILES_ACTIVE=dev" -v <log_folder>:/log -v <cache_folder>:/cache -p 8080:8080 -it rest-cache-proxy`

- substitute log_folder and cache_folder with folder paths where to store log file and cache index and data
- if you are using <b>dev</b> spring profile please update /rest-cache-proxy/src/main/resources/config/application-dev.properties file and under <b>rest.api.host</b> enter local computer host name

#### Creating DEV environment

- under the project folder /rest-cache-proxy/support there is:

  1. REST-FEXCO-soapui-project.xml SoapUI project file that holds the REST service mock which acts as a backend.