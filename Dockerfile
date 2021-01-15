FROM openjdk:8-jre-alpine
WORKDIR /mycalc
COPY --from=0 /mycalc/target/mycalc-0.0.1-SNAPSHOT.jar /app 
CMD ["java -jar mycalc-0.0.1-SNAPSHOT.jar"]


