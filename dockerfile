FROM openjdk

WORKDIR /app
COPY build/libs/BIG-4-Static-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","/app/BIG-4-Static-0.0.1-SNAPSHOT.jar"]