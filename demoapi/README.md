# springfox-example
Example project implementing Swagger rest documentation using SpringFox.
https://www.vojtechruzicka.com/documenting-spring-boot-rest-api-swagger-springfox/

# in pom am adaugat biblioteca de logging
 <!-- =============== Custom HTTP log filter ============== -->
        <dependency>
            <groupId>sdxro.logging</groupId>
            <artifactId>api-starter-log</artifactId>
             <version>${api-starter-log.version}</version>            
        </dependency>

#swagger
http://localhost:8890/v2/api-docs
#swagger UI
http://localhost:8890/swagger-ui.html#/

http://10.40.15.8:9373/swagger-ui.html#/

#consume GET
localhost:8890/v2/persons/

copy .jar,docker-compose.yml and Dockerfile on docker host:

D:\Eclipse_projects\demoAPI\docker-compose.yml to /docker_images/spring_apps/demoapi
D:\Eclipse_projects\demoAPI\Dockerfile to /docker_images/spring_apps/demoapi
D:\Eclipse_projects\demoAPI\target\demoAPI.jar to /docker_images/spring_apps/demoapi/target/. 
	
## Docker Compose
	$putty 10.40.15.8
	$cd /docker_images/spring_apps/demoapi
    
	$docker-compose up -d --build && sleep 3