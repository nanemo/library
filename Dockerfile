FROM tomcat:9.0.65-jdk17
COPY target/root.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh", "run"]
