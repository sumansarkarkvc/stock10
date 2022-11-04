# define base docker image
FROM openjdk:11
LABEL maintainer="stock"
ADD target/stock-0.0.1-SNAPSHOT.jar stock-docker-image.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","stock-docker-image.jar"]