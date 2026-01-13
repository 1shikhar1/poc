# ---------- build stage ----------
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
 
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline
 
COPY src ./src
RUN mvn -q -DskipTests package
 
# ---------- runtime stage ----------
FROM gcr.io/distroless/java21-debian12:nonroot
WORKDIR /app
 
COPY --from=build /app/target/*.jar app.jar
 
EXPOSE 8080
USER nonroot:nonroot
ENTRYPOINT ["java","-jar","app.jar"]