FROM ubuntu:trusty

# Install Java
RUN apt-get install -y software-properties-common
RUN add-apt-repository ppa:webupd8team/java -y
RUN apt-get update
RUN echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
RUN apt-get install -y oracle-java7-installer
RUN apt-get install -y oracle-java7-set-default

# Install wget
RUN apt-get install -y wget

# Install Jetty
RUN wget -O /opt/jetty.tar.gz "http://eclipse.org/downloads/download.php?file=/jetty/9.0.7.v20131107/dist/jetty-distribution-9.0.7.v20131107.tar.gz&r=1"
RUN tar -xvf /opt/jetty.tar.gz -C /opt/
RUN rm /opt/jetty.tar.gz
RUN mv /opt/jetty-distribution-9.0.7.v20131107 /opt/jetty
RUN rm -rf /opt/jetty/webapps.demo
RUN useradd jetty -U -s /bin/false
RUN chown -R jetty:jetty /opt/jetty

# Copy apps
ADD code-1.0.war /opt/jetty/webapps/root.war
RUN chown -R jetty:jetty /opt/jetty/webapps/root.war

# Postgresql
RUN sudo apt-get install -y postgresql postgresql-contrib
USER postgres
RUN /etc/init.d/postgresql start &&\
    psql --command "CREATE USER docker WITH SUPERUSER PASSWORD 'docker';" &&\
    createdb -O docker docker


EXPOSE 8080
EXPOSE 5432
RUN cd /opt/jetty

CMD /etc/init.d/postgresql start && java -Djetty.home=/opt/jetty -jar /opt/jetty/start.jar





