# API de Estados Brasileiros

### Sprint 3 - Trilha Spring Boot - Compass.Uol

---

Esta API foi desenvolvida em [Spring Boot](https://spring.io/projects/spring-boot),
utilizando o [H2 Database Engine](https://www.h2database.com/html/main.html), para a trilha
de desenvolvimento em Spring Boot da Compass.Uol.

A interface permite ao usuário criar, recuperar, atualizar e remover dados de Estados
brasileiros em um banco de dados H2 local. A aplicação deve ser executada por meio do
arquivo `EstadoApplication.java`.

## Utilização da API

A aplicação pode ser utilizada localmente (em `localhost:8080`), com o
[Apache Tomcat](https://tomcat.apache.org/tomcat-9.0-doc/).


## Operações


### Listar todos os Estados

#### Requisição

`GET /api/states`

```curl
curl -X 'GET' 'http://localhost:8080/api/states' -H 'accept: application/json'
```

#### Resposta

```json
[
  {
    "id": 13,
    "nome": "Pernambuco",
    "regiao": "Nordeste",
    "populacao": 9674793,
    "capital": "Recife",
    "area": 98067.88
  }
]
```

#### Ordenação e filtragem

##### Filtrar por região

`localhost:8080/api/states?regiao={região}`

Exemplo:

```curl
curl -X 'GET' localhost:8080/api/states?regiao=Nordeste -H 'accept: application/json'
```

##### Ordenar por população (decrescente)

`localhost:8080/api/states?filtro=populacao,desc`

##### Ordenar por extensão territorial (decrescente)

`localhost:8080/api/states?filtro=area,desc`

### Recuperar Estado por ID

#### Requisição

`GET /api/states/{id}`

```curl
curl -X 'GET' 'https://localhost:8080/api/states/13' -H 'accept: application/json'
```

#### Resposta

##### 200: Sucesso

```json
{
  "id": 13,
  "nome": "Pernambuco",
  "regiao": "Nordeste",
  "populacao": 9674793,
  "capital": "Recife",
  "area": 98067.88
}
```

##### 404: ID não encontrado
```json
"Not Found"
```

### Cadastrar novo Estado

#### Requisição

`POST /api/states/{id}`

```curl
curl -X 'POST' \
  'http://localhost:8080/api/states' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Pernambuco",
  "regiao": "Nordeste",
  "populacao": 9674793,
  "capital": "Recife",
  "area": 98067.88
}'
```

#### Resposta

##### 201: Estado cadastrado

```json
{
  "id": 13,
  "nome": "Pernambuco",
  "regiao": "Nordeste",
  "populacao": 9674793,
  "capital": "Recife",
  "area": 98067.88
}
```

### Atualizar Estado

#### Requisição

`PUT /api/states/{id}`

```curl
curl -X 'PUT' \
  'http://localhost:8080/api/states/13' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Pernambuco",
  "regiao": "Nordeste",
  "populacao": 9674793,
  "capital": "Olinda",
  "area": 98149.12
}'
```

#### Resposta

##### 200: Estado atualizado

```json
{
  "id": 13,
  "nome": "Pernambuco",
  "regiao": "Nordeste",
  "populacao": 9674793,
  "capital": "Olinda",
  "area": 98149.12
}
```

##### 404: ID não encontrado

```json
"Not Found"
```

### Remover Estado

#### Requisição

`DELETE /api/states/{id}`

```curl
curl -X 'DELETE' 'http://localhost:8080/api/states/13' -H 'accept: application/json'
```

#### Resposta

##### 200: Estado removido

```json
{
  "id": 13,
  "nome": "Pernambuco",
  "regiao": "Nordeste",
  "populacao": 9674793,
  "capital": "Recife",
  "area": 98067.88
}
```

##### 404: ID não encontrado

```json
"Not Found"
```
