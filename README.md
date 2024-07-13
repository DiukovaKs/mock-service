Mock-service

The service provides fake data about vacancies for the last N days in the format of a list of objects

[
    {
        "id": id,
        "title": "String",
        "description": "String",
        "company": "String",
        "location": "String",
        "workType": "String",
        "postedAt": "String (dd-MM-yyyy)"
    },
...
]

Example request: localhost:8080/jobs?jobsCount=12&pastDays=2

where 
    jobsCount - number of vacancies in the response list
    pastDays - time period used in the generated data