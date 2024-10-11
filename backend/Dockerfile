# Build stage
FROM eclipse-temurin:21-jdk as build

COPY . /app
WORKDIR /app

RUN chmod +x mvnw
RUN ./mvnw package -DskipTests
RUN mv -f target/*.jar app.jar

# Production stage
FROM eclipse-temurin:21-jre

ARG PORT
ENV PORT=${PORT}

COPY --from=build /app/app.jar .

ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL}
ENV SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME}
ENV SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}

RUN useradd runtime
USER runtime

ENTRYPOINT [ "java", "-Dserver.port=${PORT}", \
    "-Dspring.datasource.url=${SPRING_DATASOURCE_URL}", \
    "-Dspring.datasource.username=${SPRING_DATASOURCE_USERNAME}", \
    "-Dspring.datasource.password=${SPRING_DATASOURCE_PASSWORD}", \
    "-jar", "app.jar" ]
