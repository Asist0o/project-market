FROM maven:3.8.3-openjdk-17 as build-stage
ADD . /src
WORKDIR /src
RUN mvn package -Dmaven.test.skip
EXPOSE 8761
ENTRYPOINT ["java","-jar","target/eureka-server.jar"]
