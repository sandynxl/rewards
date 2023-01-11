# Rewards Task

This is a Reward Calculator application providing a REST
API to a backed model.



## Install

    maven install

## Run the app

    run as spring boot 

## Run the tests

    mvn test

# REST API

The REST API to the example app is described below.

## Get the customer rewards by customer name

### Request

`GET /rewards/customername`

    curl -i -H 'Accept: application/json' http://localhost:8080/rewards/{customername}

### Response

    HTTP/1.1 200 OK
    Date: Wed, 11 Jan 2022 12:00:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 2

    


## Create  Reward Calculator Using Post Method
### Request

`POST /rewards/

    curl -i -H 'Accept: application/json' -d  http://localhost:8080/rewards
###Sample Request Body
  {
  "customerName":"Bob",
  "amount":"150",
  "date":"2019-09-12"  


 }
###Sample Response Body

    HTTP/1.1 201 Created
    Date: Wed, 11 Jan 2022 12:36:30 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /thing/1
    Content-Length: 36
    Connection: close
