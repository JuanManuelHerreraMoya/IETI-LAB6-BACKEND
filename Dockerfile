FROM adoptopenjdk/openjdk11:alpine
EXPOSE 8080
ARG OUTPUT_FOLDER=build/libs/
COPY ${OUTPUT_FOLDER} /app/lib
WORKDIR /app/lib
ENTRYPOINT ["java","-jar","TaskPlanner-0.0.1-SNAPSHOT.jar"]