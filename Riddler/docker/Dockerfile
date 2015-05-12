FROM ubuntu:trusty
RUN sudo apt-get update
RUN sudo apt-get install -y default-jdk wget

RUN wget -O /opt/jetty.tar.gz "http://eclipse.org/downloads/download.php?file=/jetty/9.0.7.v20131107/dist/jetty-distribution-9.0.7.v20131107.tar.gz&r=1"
RUN tar -xvf /opt/jetty.tar.gz -C /opt/
RUN rm /opt/jetty.tar.gz
RUN mv /opt/jetty-distribution-9.0.7.v20131107 /opt/jetty
RUN rm -rf /opt/jetty/webapps.demo

ADD *.war /opt/jetty/webapps/

EXPOSE 8080
ENTRYPOINT java -Djetty.home=/opt/jetty -jar /opt/jetty/start.jar
