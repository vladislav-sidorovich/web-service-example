# Description
Example of typical Java web service with the most popular technologies: Spring, JPA/Hibernate.
# Architecture
## Environment
Simplified production environment contains the following components:

![alt text](https://github.com/vladislav-sidorovich/web-service-example/blob/main/img/services-and-env.png?raw=true)

### The flow and responsobiliries
1. Actor does some action with web/mobile client
2. The client sends HTTP request to a server
3. Proxy routes request to a particular component
4. Static data server holds and serves static data like images, javascript, html and so on
5. Java Web service contains business logic and process business data
6. Database provide durable storage for business data

## Java web service
Typical Java web service has the following architecture

![alt text](https://github.com/vladislav-sidorovich/web-service-example/blob/main/img/service-components.png?raw=true)

# How to build
To build the service the following tools are required:
1. JDK 11+
2. Maven 3.6+

Execute `mvn install`

# How to run
To run the service a servlet container is required. The service works at leat in (Tomcat 9, Jetty 9.24, WildFly 25)
1. `mv target/web-service-example-1.0-SNAPSHOT.war {servletcontierhome}/webapps`
2. startup your servlet container

To check press http://localhost:8080
or execute `curl http://localhost:8080`
