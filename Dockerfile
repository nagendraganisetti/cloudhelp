FROM openjdk:8

EXPOSE 8088

ADD target/helpdeskService-0.0.1-SNAPSHOT.jar helpdeskService-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","helpdeskService-0.0.1-SNAPSHOT.jar"]