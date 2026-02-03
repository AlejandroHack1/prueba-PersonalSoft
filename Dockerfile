FROM gradle:8.5-jdk17 as builder

WORKDIR /app

COPY settings.gradle build.gradle gradlew ./

COPY . .

RUN ./gradlew clean build

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=builder /app/applications/app-service/build/libs/app-service.jar /app/app.jar

EXPOSE 8787

ENTRYPOINT ["java", "-jar", "/app/app.jar"]