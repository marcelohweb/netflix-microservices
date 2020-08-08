FROM openjdk:8-jre
VOLUME /tmp
COPY config/* /config/
COPY UnlimitedJCEPolicyJDK8/* /usr/lib/jvm/java-1.8-openjdk/jre/libsecurity/
COPY target/netflix-config-1.0.0.jar config.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","config.jar"]
