FROM openjdk:21

WORKDIR /usr/app/

COPY traget/Sb-app.jar /usr/app

ENTRYPOINT [ "java",".jar","Sb-app.jar" ]