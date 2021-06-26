
# ZUP PROJECT - DESAFIO 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/vcaselli/zup-project/blob/main/LICENSE) 

# About 
This is a project elaborated as part of the challenge proposed by ZUP. That project connects to a FIPE API for vehicle registration.

Java version required: 11 


# Dev and Prod
That project contains two branches: Development environment(Dev) and Production environment (Prod). In application.properties it is possible to change.

# API FEATURES
It was used Spring Security + OAuth2 to authentication and authorization. 
OpenFeign (Managed by Spring Cloud Dependencies) to request FIPE API and other features from Spring ecosystem like Spring Data JPA... 

# Production on Heroku
https://zup--project-prod.herokuapp.com/
This link will redirects you to REST API project  that contains Prod Environment. 
Here are the credentials to OAuth2
client_id: ProdClientId
client_secret: ProdClientSecret 

# Login Example with Postman
![Example](https://github.com/vcaselli/assets/blob/main/zup/login.png)



