set JAVA_HOME=C:/Program Files/Java\jdk1.8.0_181
set MAVNE_HOME=F:/Apache-Maven-3.5.4
set path=%JAVA_HOME%/bin;%MAVNE_HOME%/bin;path%;
cd bom
mvn clean install
