FROM maven:3.8.3-openjdk-17 as build-stage
LABEL version="1.0"
ADD . /src
WORKDIR /src
RUN mvn package -DskipTests
EXPOSE 8087
ENTRYPOINT ["java","-jar","target/profiles-service-2.5.7.jar"]