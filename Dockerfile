FROM openjdk:15-jdk-alpine
EXPOSE 3000
WORKDIR /microservicios
#VOLUME ../conf /conf
ARG JAR_FILE=target/mss_afiglobal-0.1.jar
ADD ${JAR_FILE} mss_afiglobal.jar
ENTRYPOINT ["java","-jar","/microservicios/mss_afiglobal.jar"]
