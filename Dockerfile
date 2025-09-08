FROM openjdk:17
EXPOSE 8080
ADD target/hackathon-image.jar hackathon-image.jar
ENTRYPOINT ["java","-jar","/hackathon-image.jar"]
