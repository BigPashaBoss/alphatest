FROM openjdk:11.0.7-jdk-slim

COPY build/libs/demo-0.0.1-SNAPSHOT.jar /testAlfaTask.jar

CMD ["java", "-jar", "/testAlfaTask.jar"]