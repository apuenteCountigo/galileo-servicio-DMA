FROM openjdk:17-alpine
VOLUME /tmp
ADD ./servicio-dma.jar servicio-dma.jar
ENTRYPOINT ["java","-jar","/servicio-dma.jar"]
