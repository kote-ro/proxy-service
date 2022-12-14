# Proxy service task 

Write Spring Boot application, which will be as a proxy against the following api:

https://restcountries.com/#api-endpoints-v3-code

There should be a single GET endpoint which will accept ALPHA-2 or ALPHA-3 country code 
And will return a json of the following format
```json
{
  "fullName":,
  "capital":,
  "continents":{"comma separated", "1", "2"},
  "currentTime":{"ISO format"}
}
```

