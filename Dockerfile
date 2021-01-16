FROM openjdk:8-jre-alpine
WORKDIR mycalc
COPY target/mycalc-0.0.1-SNAPSHOT.jar .
CMD ["java -jar mycalc-0.0.1-SNAPSHOT.jar"]
