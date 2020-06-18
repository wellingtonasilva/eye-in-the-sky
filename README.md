# eye-in-the-sky
Simple project to show how to consume Kiwi.com

## Requisitos
* Java
* Docker
* docker-compose
* Postgres
* Maven
* git


## Donwload do projeto
```
git clone https://github.com/wellingtonasilva/eye-in-the-sky.git
```

## Build 
```
mvn clean package
```

## Gerar image Docker
```
docker-compose build
```

## Iniciar projeto utilizando image docker
```
docker-compose up
```
A imagem gerada irá iniciar o banco de dados Postgres e a aplicação Java.

## Testar aplicação
Na janela do navegador copie e cole a URL abaixo:
```
http://localhost:8080/api/flght/avg?dest=LIS&dateFrom=17/06/2020&dateTo=25/06/2020&curr=GBP&dest=OPO
```
O retorno será algo como o exemplo abaixo
```
{
    "LIS": {
        "name": "Lisbon",
        "currency": "EUR",
        "priceAverage": 42.903866,
        "bagsPrice": {
            "1": 7.354475,
            "2": 68.02889
        }
    },
    "OPO": {
        "name": "Porto",
        "currency": "EUR",
        "priceAverage": 45.62075,
        "bagsPrice": {
            "1": 72.87915,
            "2": 145.76096
        }
    }
}
```

## Arquitetura da aplicação
O exemplo foi desenvolvido utilizando Spring Boot acessando uma base de dados Postgres.
As idéia central é que a partir da pesquisa solicitada, a apalicação vá a um servidor externo, 
faça uma consulta e depois salve na base local.

A base local servirá como "cache" e é utilizado para facilitar o agrupamento dos dados.

## Estrutura de pastas
```
    |-docker
    |-src
    |--main
    |---java
    |----config
    |----controller
    |----model
    |-----dto
    |-----entity
    |-----projection
    |----repository
    |----service
```

## Manutenção as tabelas da aplicaçáo
Copie e cole no navegador o endereço abaixo
```
http://localhost:8080/
```