FROM openjdk:8-jre
COPY target/netflix-api-gateway-1.0.0.jar gateway.jar
ADD entrypoint.sh entrypoint.sh
CMD [ "entrypoint.sh" ]
ENTRYPOINT ["sh"]