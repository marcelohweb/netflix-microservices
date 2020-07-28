FROM maven:3.6.3-openjdk-8

COPY pom.xml pom.xml
COPY netflix-config netflix-config
COPY netflix-api-gateway netflix-api-gateway
COPY netflix-data netflix-data
COPY netflix-service-discovery netflix-service-discovery
COPY netflix-category-microservice netflix-category-microservice
COPY netflix-movie-microservice netflix-movie-microservice
COPY netflix-user-microservice netflix-user-microservice

ADD entrypoint.sh entrypoint.sh
CMD [ "entrypoint.sh" ]
ENTRYPOINT ["sh"]
