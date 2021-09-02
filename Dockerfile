FROM hirokimatsumoto/alpine-openjdk-11
EXPOSE 8080
ARG JAR_FILE=target/TodoMS-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]