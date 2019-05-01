# WSO2 IS Setup Guide

### Prerequisites

##### Installation of JAVA

```
$ sudo yum install java-1.8.0-openjdk-devel
```


##### Installation of WSO2 IS with KM (key manager)

```
$ sudo su
$ cd /opt
$ wget http://product-dist.wso2.com/downloads/api-manager/2.1.0/identity-server/wso2is-km-5.3.0.zip
$ unzip wso2is-km-5.3.0.zip
```


### Start identity server

```
$  /opt/wso2is-km-5.3.0/bin/wso2server.sh start
```

### Service provider configuration

* Login into https://localhost:9443/carbon 

> Note: wso2 default credentials admin/admin.

* Click on add to create a new service provider and then click on register

   https://localhost:9443/carbon/application/add-service-provider.jsp?region=region1&item=add_service_providers_menu

* Click on Inbound Authentication configuration and then configure OAuth/OpenID configuration
to generate client credentials

![add_new_sp](images/add_new_sp.png)

* Configure callback uri as http://localhost:4200/callback and click on Add button

![add_new_app](images/add_new_app.png)

####  Start the angular app

```
$ cd angular2-oauth2-login
$ npm install
$ npm run start
```

### Using Docker

 WSO2 supports docker images 

 * start identity server as docker container
   
   ```
   $ docker run -d --name wso2-is -p 9443:9443 -t wso2/wso2is-km:5.6.0  
   ```
 
 
