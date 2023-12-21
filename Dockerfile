FROM openjdk:17
ARG JAR_FILE=build/libs/travel-project-1.0.jar
COPY ${JAR_FILE} /home/travel-project-1.0.jar
ENTRYPOINT ["java","-jar","/home/travel-project-1.0.jar"]