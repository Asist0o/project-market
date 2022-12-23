FROM maven:3.8.3-openjdk-17 as build-stage
LABEL version="1.0"
ADD . /src
WORKDIR /src
RUN mvn package -DskipTests
EXPOSE 8088
ENTRYPOINT ["java","-jar","target/files-storage-service-0.0.1-SNAPSHOT.jar"]