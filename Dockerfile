# build from maven
FROM maven:latest as maven-build
# change to a seperate folder for building our project,
# keeps things neat
WORKDIR /build
# copy all project files in
COPY . . 
# build the project
RUN mvn clean package

# use the wildfly docker image
FROM jboss/wildfly:latest
# change the working directory to the deployments folder
WORKDIR /opt/jboss/wildfly/standalone/deployments
# here you would change 'my-project.war' to the 
# name of your war file that gets created
COPY --from=maven-build /build/target/SpeedMe_Backend.war .










