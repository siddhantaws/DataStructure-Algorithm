set JAVA_HOME=C:/Program Files/Java\jdk1.8.0_91
set MAVNE_HOME=D:/Program Files/Apache Software Foundation/apache-maven-3.1.1
set path=%JAVA_HOME%/bin;%MAVNE_HOME%/bin;path%;
mvn clean install -Dmaven.test.skip=true
