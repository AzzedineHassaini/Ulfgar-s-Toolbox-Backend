FROM maven:3.9.7-amazoncorretto-21 AS build

WORKDIR /app

RUN mkdir -p /app/books /app/images

VOLUME ["/app/books", "/app/images"]

COPY pom.xml .

COPY src ./src

RUN mvn clean install -DskipTests


FROM amazoncorretto:21 AS deploy

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]