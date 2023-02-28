FROM openjdk:19
COPY target/TriviaDTO-0.0.1-SNAPSHOT.jar TriviaDTO.jar
ENTRYPOINT ["java","-jar","/TriviaDTO.jar"]