# Guide to setup Keycloak server

## Docker container
```
$ docker run --name=keycloak -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -p 8080:8080 -d jboss/keycloak
```
