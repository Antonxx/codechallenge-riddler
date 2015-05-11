FROM ubuntu:trusty
RUN sudo apt-get update
RUN sudo apt-get install -y git maven default-jdk
RUN mkdir ~/riddler
WORKDIR ~/riddler
RUN git clone https://github.com/ehats/codechallenge-riddler.git
WORKDIR codechallenge-riddler/Riddler
RUN mvn install
EXPOSE 8080

# then run
# docker run -P IMAGE mvn org.eclipse.jetty:jetty-maven-plugin:9.3.0.M2:run