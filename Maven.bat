set JAVA_HOME=C:/Program Files/Java/jdk1.8.0_211
--set JAVA_HOME=C:/Program Files/Java/jdk1.8.0_181
set MAVNE_HOME=C:/Users/user/Maven
set path=%JAVA_HOME%/bin;%MAVNE_HOME%/bin;path%;
cd bom
mvn clean install
