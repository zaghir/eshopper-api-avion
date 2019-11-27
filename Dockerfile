 FROM java:8
##FROM openjdk:8-jdk
  LABEL "com.zaghir.project.api-avion"="Api Avion"
  LABEL maintainer="zaghir.youssef@gmail.com"
  LABEL version="1.0"
  LABEL description="Image de l'api avion  \
        basé sur spring cloud pour le back ,mysql comme serveur de base de donnnees."
 

##-------------------------- creer le dossier de travail et faire un clone de projet
RUN mkdir /usr/depot_git  \
    mkdir /usr/depot_git/eshopper-api-avion \
    && cd /usr/depot_git/eshopper-api-avion

##-------------------------- Set working directory
WORKDIR /usr/depot_git/eshopper-api-avion


## On a utilisé maven local pour creer le jar si on on passe par une copie depuis le dossier le dossier target d'eclipse 
## ADD target/api-avion-0.0.1-SNAPSHOT.jar api-avion-0.0.1-SNAPSHOT.jar
#  COPY target/api-avion-0.0.1-SNAPSHOT.jar api-avion-0.0.1-SNAPSHOT.jar

COPY target/api-avion-0.0.1-SNAPSHOT.jar api-avion-0.0.1-SNAPSHOT.jar

##-------------------------- exposer l api sur le port 9200
EXPOSE 9200:9200
## CMD ["cd ","/usr/depot_git/eshopper-api-avion/target"]
## ENTRYPOINT ["java","-jar","/usr/depot_git/eshopper-api-avion/target/api-avion-0.0.1-SNAPSHOT.jar","-Dspring.datasource.url=${DATASOURCE_URL}" ,"-Dspring.datasource.username=${DATASOURCE_USERNAME}}","-Dspring.datasource.password=${DATASOURCE_password}"]
ENTRYPOINT ["java","-jar","/usr/depot_git/eshopper-api-avion/api-avion-0.0.1-SNAPSHOT.jar","-Dspring.profiles.active=container","-DDATABASE_HOST=mysql-container","-DDATABASE_PORT=3306","-DDATABASE_NAME=eshopper" ,"-DDATABASE_USER=root","-DDATABASE_PASSWORD="]



## pour builder  ==>  docker build . 
## docker image build -t eshopper-api-avion .     . c'est le fichier Dockerfile qui se trouve dans le dossier courant

## pour lancer un container mysql 
## docker container run --detach --publish 3306:3306 --name mysqlZ -e  MYSQL_RANDOM_ROOT_PASSWORD=yes mysql
## docker container run --detach --publish 3306:3306 --name mysqlZ -e  MYSQL_ROOT_PASSWORD=123 mysql
## docker container run --detach --publish 3306:3306 --name mysqlZ -e  MYSQL_ALLOW_EMPTY_PASSWORD=yes mysql
## docker exec -it mysql-container bash
## mysql -h localhost -u root -p
## show databases;    use eshopper ; show tables; 

## api eshopper-avion 
## docker container  run --detach --publish 9200:9200  --name api-avion eshopper-api-avion 
## [INFO] Installing /usr/depot_git/eshopper-api-avion/target/api-avion-0.0.1-SNAPSHOT.jar to /root/.m2/repository/com/bd/eshopper/api-avion/0.0.1-SNAPSHOT/api-avion-0.0.1-SNAPSHOT.jar
## [INFO] Installing /usr/depot_git/eshopper-api-avion/pom.xml to /root/.m2/repository/com/bd/eshopper/api-avion/0.0.1-SNAPSHOT/api-avion-0.0.1-SNAPSHOT.pom

## creer un reseau   sur windows 10 ca ne marche pas car il n y a pas le driver bridge
## docker network create --driver nat eshopper-network
## docker container run --detach --publish 3306:3306 --name mysqlZ --network eshopper-network -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=eshopper mysql
## docker container  run --detach --publish 9200:9200  --name api-avion --network eshopper-network eshopper-api-avion 

## on connete les container avec les link 
## docker container run --detach --publish 3306:3306 --name mysql-container -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=eshopper mysql
## docker container  run --detach --publish 9200:9200 -e DATASOURCE_URL =jdbc:mysql://mysql-container:3306/eshopper?verifyServerCertificate=false&allowPublicKeyRetrieval=true&useSSL=false  -e DATASOURCE_USERNAME=root -e DATASOURCE_password= --name api-avion --link mysql-container  eshopper-api-avion
## docker container  run --detach --publish 9200:9200 --name api-avion -t --link mysql-container:mysql  eshopper-api-avion
