FROM maven:3.6.3-openjdk-8

WORKDIR /home/compiler

ADD entrypoint.sh entrypoint.sh
CMD [ "entrypoint.sh" ]
ENTRYPOINT ["sh"]
