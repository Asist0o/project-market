FROM maven:3.8.3-openjdk-17 as build-stage
LABEL version="1.0"
ADD . /src
WORKDIR /src
RUN mvn clean package -Dmaven.test.skip
EXPOSE 8082
ENTRYPOINT ["java","-jar","target/market-authorization-service.jar"]
#ENTRYPOINT ["sh", "-c","java -jar -Dspring.profiles.active=dock target/market-authorization-service.jar"]
