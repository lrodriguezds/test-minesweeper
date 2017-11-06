# Minesweeper

I've implemented a Restful API with Spring boot in order to speed up the development. Also, I used a in memory database to avoid the installation of any other db engine.
In the frontend side I'm consuming the API with jQuery ajax calls and render to html. It was my intention to leverage boostrap 3 but I hadn't so much time.


Technology stack involved:
- Restful API:
  - Java
  - Spring boot 1.5.6
  - Spring Data JPA
  - H2 (in memory database)

- Client API:
  - Jquery AJAX 
  
 the .html page is served by nginx

The application is running under an EC2 t2.micro AWS instance.
URL: http://ec2-54-233-187-191.sa-east-1.compute.amazonaws.com/minesweeper.html
