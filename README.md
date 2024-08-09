# Mock-service

## Install
```sh
make build-up
```

## Local run
```sh
make run
```

## Down containers
```sh
make down
```

The service provides fake data about vacancies for the last N days in the format of a list of objects

```json
[
    {
        "id": "string",
        "sourceId": "string",
        "sourceJobId": "string",
        "title": "string",
        "description": "string",
        "company": "string",
        "companyId": "string",
        "location": "string",
        "workType": "string",
        "postedAt": "string",
        "collectedAt": "2024-07-16T08:50:49.080Z",
        "link": "string",
        "extra": "string"
    },
]
```

See endpoints on http://localhost:8080/swagger-ui/index.html