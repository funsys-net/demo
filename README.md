# Demo Application with Spring Boot and H2
 
This example app shows how to create a Spring Boot API and CRUD (create, read, update, and delete) its data with postman.

**Prerequisites:** [Java SE Development Kit 11](https://www.oracle.com/jp/java/technologies/javase-jdk11-downloads.html), [Maven](https://maven.apache.org/), [Postman](https://www.postman.com/downloads/)



## Get Started

To install this example application, run the following commands:

```bash
git clone https://github.com/baidujp/demo.git
cd demo
```

This will get a copy of the project installed locally. To install all of its dependencies and start app, follow the instructions below.

To run the server, run:
 
```bash
mvn spring-boot:run
```

After a while, sever should be started on port 8080.

## How to call APIs

Postman is used to call APIs

### Get all movies

GET http://localhost:8080/movies

A list of movies should be returned like this.
``` json
[
    {
        "id": 1,
        "name": "BLACK BOX",
        "director": "Emmanuel Osei-Kuffour",
        "lang": "en",
        "country": "USA"
    },
    {
        "id": 2,
        "name": "MULAN",
        "director": "Niki Caro",
        "lang": "cn",
        "country": "China"
    },
    {
        "id": 3,
        "name": "TOMMASO",
        "director": "Abel Ferrara",
        "lang": "en",
        "country": "USA"
    },
    {
        "id": 4,
        "name": "HIS HOUSE",
        "director": "Abel Ferrara",
        "lang": "en",
        "country": "USA"
    },
    {
        "id": 5,
        "name": "Your Name.",
        "director": "Shinkai Makoto",
        "lang": "ja",
        "country": "Japan"
    }
]
```

### Get detail of a given movie

GET http://localhost:8080/movies/1

Detail info should be returned as following.
``` json
{
    "id": 1,
    "name": "BLACK BOX",
    "director": "Emmanuel Osei-Kuffour",
    "lang": "en",
    "country": "USA"
}
```
### Search movies by name(Fuzzy Matching)

GET http://localhost:8080/movies?search=by-name-like&name=Your

Detail info should be returned as following.
``` json
[
    {
        "id": 5,
        "name": "Your Name.",
        "director": "Shinkai Makoto",
        "lang": "ja",
        "country": "Japan"
    }
]
```

### Search movies by country

GET http://localhost:8080/movies?search=by-country&country=USA

Detail info should be returned as following.
``` json
[
    {
        "id": 1,
        "name": "BLACK BOX",
        "director": "Emmanuel Osei-Kuffour",
        "lang": "en",
        "country": "USA"
    },
    {
        "id": 3,
        "name": "TOMMASO",
        "director": "Abel Ferrara",
        "lang": "en",
        "country": "USA"
    },
    {
        "id": 4,
        "name": "HIS HOUSE",
        "director": "Abel Ferrara",
        "lang": "en",
        "country": "USA"
    }
]
```

### Get all favorite movies

GET http://localhost:8080/favorites

A list of movies should be returned as following.
``` json
[
    {
        "id": 1,
        "name": "BLACK BOX",
        "director": "Emmanuel Osei-Kuffour",
        "lang": "en",
        "country": "USA"
    },
    {
        "id": 2,
        "name": "MULAN",
        "director": "Niki Caro",
        "lang": "cn",
        "country": "China"
    }
]
```

### Add a favorite movie

POST http://localhost:8080/favorites?id=4

Movie id should be returned as following.
``` json
{
    "id": 4
}
```

## How to access H2 console

* Access [h2 console](http://localhost:8080/h2)
* Set JDBC URL as jdbc:h2:~/temp/demo
* Keep other parameters as default.

Apache 2.0, see [LICENSE](LICENSE).
