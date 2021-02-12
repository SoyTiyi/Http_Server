# My Own HTTP Server

En este taller se creo un servidor HTTP utilizando unicamente Java, con el fin de poder aprender como funcionan las peticiones y como poder retornar archivos estaticos solicitados por el client.

Para realizar esto, utilizaremos herramientas como Heroku, GIT y GITHUB.

Y tecnologias como lo son html, css, JavaScript, JQuery y Java.

## Correr proyecto

Primero Clonaremos el repositorio, para eso desde nuestro navegador nos dirigiremos al siguiente link

```sh
https://github.com/SoyTiyi/Http_Server.git
```

Para clonar el repositorio debemos de correr el siguiente comando en cmd o en la terminal 

```sh
git clone https://github.com/SoyTiyi/Http_Server.git
 ```

 Y luego entraremos a la carperta Http_Server

```sh
$ cd Http_Server
 ```
Descargaremos y compilaremos el proyecto con el siguiente comando
Este comando nos descargara la dependencias necesarias (JUnit)

 ```sh
$ mvn package
 ```
 Y finalmente para ejecutar la aplicación.

 ```sh
$ mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.app.DemoServer"
 ```

### Prerequisitos

* Tener conocimientos básicos en la terminal o CMD
* Java SE Development Kit 8 -Java SE Runtime Environment 8 -Apache Maven.

## Integracion Continua

[![CircleCI](https://circleci.com/gh/SoyTiyi/Http_Server.svg?style=svg)](https://circleci.com/gh/SoyTiyi/Http_Server)

## Despliegue en Heroku

[![Heroku App](http://heroku-shields.herokuapp.com/hidden-savannah-75464)](https://hidden-savannah-75464.herokuapp.com/)

## Correr Pruebas

Para correr las pruebas, ejecutamos el siguiente comando

```sh
$ mvn test
 ```

### Generar Javadoc

Para generar el javadoc, corremos el siguiente comando

```sh
$ mvn javadoc:javadoc 
 ```

## Construido con

* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](https://mvnrepository.com/artifact/junit/junit) - Test framework
* [VIM](https://www.vim.org/download.php) - Editor de Texto VIM

## Author

 - Santiago Martínez Martínez 
 - Estudiante de la Escuela Colombiana De Ingeniería Julio Garavito 
 - Noveno Semestre

## License

Este proyecto está licenciado bajo la GNU v3.0 - ver el archivo LICENSE.md para más detalles
