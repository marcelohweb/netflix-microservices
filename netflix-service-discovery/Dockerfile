FROM openjdk:8-jre
COPY target/netflix-service-discovery-1.0.0.jar service-discovery.jar
ADD entrypoint.sh entrypoint.sh
CMD [ "entrypoint.sh" ]
ENTRYPOINT ["sh"]