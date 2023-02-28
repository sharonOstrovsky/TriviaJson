# **Trivia** :medal_sports:


![](src/main/resources/img/logo.png)


## Descripción

La aplicación es una trivia con preguntas de diferentes categorías
entre las cuales se encuentra tecnología, conocimiento general, geografía, 
entretenimiento y matemática.

* Contiene diferentes categorías entre las cuales se encuentra tecnología, 
conocimiento general, geografía, entretenimiento y matemática.
* Se encuentra dividido por niveles según la edad del usuario.
* El usuario puede registrarse con sus datos que se guardan en la base de datos.
* Son cinco preguntas por usuario, ganando con un minimo de tres preguntas correctas.
* En la base de datos se encuentran más de 250 preguntas.


## Tecnologías Utilizadas

* Java
* Spring
* MySQL
* Postman
* React
* Figma
* Swagger

## Figma

```
https://www.figma.com/file/N2TUBjsXDa9IlLXYjuu2mu/Untitled?node-id=0%3A1&t=uSVnvvvXe9K1fyAI-1
```

## Instalación

Pasos a Seguir:

<ol>
<li>Clonar el Repositorio

```
git clone https://github.com/sharonOstrovsky/Trivia.git
```

</li>
<li>Crear una Base de Datos en MySQL con el nombre 

>trivia

</li>
<li>Cambiar usuario y contraseña en application.properties

```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/trivia
spring.datasource.username=nombreUsuario
spring.datasource.password=clave
spring.jpa.hibernate.ddl-auto=create

springdoc.swagger-ui.path=/swagger-ui.html

```

</li>

<li>
Importar a la base de datos el archivo 

 >trivia.sql

</li>

<li>
Importar a Postman el archivo

 > TRIVIA.postman_collection.json
</li>
</ol>

## Autores

* Sharon Ostrovsky
* Max Sauerbrey
* Marcos Aguero
* Facundo Aguirre
* Belen Oña
* Carla Marquez
* Damian Bettini
* Lautaro Montaño
* Jasbir Singh
* Mirna Diaz
* Dalma 
* Eliana
* Hector Sanchez

