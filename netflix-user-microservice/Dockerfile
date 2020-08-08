FROM openjdk:8-jre
COPY target/netflix-user-microservice-1.0.0.jar user-microservice.jar
RUN apt-get update 
RUN apt-get install -y netcat
ADD entrypoint.sh entrypoint.sh
CMD [ "entrypoint.sh" ]
ENTRYPOINT ["sh"]