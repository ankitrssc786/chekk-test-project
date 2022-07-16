# Maven build container 

FROM maven:3.8.5-openjdk-11 AS maven_build

COPY pom.xml /tmp/

COPY src /tmp/src/

WORKDIR /tmp/

RUN mvn package

#pull base image

FROM openjdk

#maintainer 
MAINTAINER ankitrssc786@gmail.com
#expose port 8080
EXPOSE 8080

#default command
CMD java -jar /data/test-project-0.1.0.jar

#copy chekk test project to docker image from builder image

COPY --from=maven_build /tmp/target/test-project-0.1.0.jar /data/test-project-0.1.0.jar
