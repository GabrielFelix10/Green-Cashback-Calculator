FROM openjdk:11
WORKDIR /usr/src/myapp
COPY /build/libs/greenCashbackCalculator-0.0.1-SNAPSHOT.jar /usr/src/myapp
EXPOSE 9095
CMD ["java", "-jar", "greenCashbackCalculator-0.0.1-SNAPSHOT.jar"]
