# angular-spring-boot-mvc
Okta's Spring Boot Starter will enable your Spring Boot application to work with Okta via OAuth 2.0/OIDC
# What you need
  - An Okta account (sign up for a forever-free developer account)
  - An OIDC application (typically a 'Web' application)
  - An access token
 
# Quickstart
  
  1. Create a Spring Boot application with [Spring initializer](https://start.spring.io/):\
        curl https://start.spring.io/starter.tgz -d dependencies=web,okta -d baseDir=<<yourProjectName>> | tar -xzvf -
          cd <<yourProjectName>>

  2. Configure it with [Okta CLI](https://github.com/okta/okta-cli/blob/master/README.md/):\
          okta apps create
  
  3. Run it:\
       ./mvnw spring-boot:run\
  
  
 # Include the dependency
   For Apache Maven:
  
    <dependency>
      <groupId>com.okta.spring</groupId>
      <artifactId>okta-spring-boot-starter</artifactId>
      <version>${okta.springboot.version}</version>
    </dependency>
  
