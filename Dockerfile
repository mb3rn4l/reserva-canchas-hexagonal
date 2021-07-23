FROM openjdk:11

LABEL author="miguel angel bernal"

ENV APP_DIR /apps/adn
ENV PORT 8080
ENV JAVA_OPTIONS ""
ENV JAR_NAME app

# set argument with the jar file
ARG JAR_FILE=microservicio/build/libs/*.jar


# Create User java for
RUN adduser  --disabled-password  java

# Exposed Ports
EXPOSE $PORT

# All the remaining actions will be performed as user "java"
USER java

# set working directory
WORKDIR ${APP_DIR}

# Add generated binaries
COPY ${JAR_FILE} ${APP_DIR}/${JAR_NAME}.jar

# Command to execute
CMD java ${JAVA_OPTIONS} -jar ${APP_DIR}/${JAR_NAME}.jar