#API spec

##User
###Login
Request :
 - Method : POST
 - Endpoint : '/api/v1/login'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
 - Body :
 
 ```json
{
    "email": "string, unique, email",
    "password": "string [6-12]"
}
```
 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": "string [token]"
}
```
###Register
Request :
 - Method : POST
 - Endpoint : '/api/v1/register'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
 - Body :
 
 ```json
{
    "name": "string",
    "email": "string, unique, email",
    "password": "string [6-12]"
    
}
```
 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": {
        "id": "integer",
        "email": "string",
        "name": "string"
    }
}
```
###Logout
Request :
 - Method : POST
 - Endpoint : '/api/v1/logout'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]
 - Body :
 
 ```json
{}
```
 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": {}
}
```
##Category
###Create Category
Request :
 - Method : POST
 - Endpoint : '/api/v1/category'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]

 - Body :
 
 ```json
{
    "name": "string"    
}
```
 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": {
        "id": "int,unique",
        "name": "string",
        "created_at": "date",
        "updated_at": "date",
        "skills": "array_skill"
    }
}
```
###Update Category
Request :
 - Method : PUT
 - Endpoint : '/api/v1/category/{category_id}'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]

 - Body :
 
 ```json
{
    "name": "string"    
}
```
 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": {
        "id": "int,unique",
        "name": "string",
        "created_at": "date",
        "updated_at": "date",
        "skills": "array_skill"
    }
}
```

###Delete Category
Request :
 - Method : DELETE
 - Endpoint : '/api/v1/category/{category_id}'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]

 
 Response :
 ```json
{
    "code": "number",
    "status" : "string"

}
```
###Get Category
Request :
 - Method : GET
 - Endpoint : '/api/v1/category/all'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]

 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": [
        {
            "id": "int,unique",
            "name": "string",
            "created_at": "date",
            "updated_at": "date",
            "skills": "array_skill"
        },
        {
            "id": "int,unique",
            "name": "string",
            "created_at": "date",
            "updated_at": "date",
            "skills": "array_skill"
        }
    ]

}
```

##Skill
###GetSkill
Request :
 - Method : GET
 - Endpoint : '/api/v1/skill/all'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]

 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": [
        {
            "id": "int,unique",
            "name": "string",
            "created_at": "date",
            "updated_at": "date",
            "skills": "array_skill"
        },
        {
            "id": "int,unique",
            "name": "string",
            "created_at": "date",
            "updated_at": "date",
            "skills": "array_skill"
        }
    ]

}
```
###CreateSkill
Request :
 - Method : POST
 - Endpoint : '/api/v1/skill/'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]

 
  Request :
  ```json
 {
     "name": "string",
     "category_id" : "integer"
     
 }
 ```
 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": {
          "created_at": "date",
          "updated_at": "date",
          "id": "integer",
          "name": "string"
        }
    

}
```
###UpdateSkill
Request :
 - Method : PUT
 - Endpoint : '/api/v1/skill/{category_id}'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]

 
  Request :
  ```json
 {
     "name": "string",
     "category_id" : "integer"
     
 }
 ```
 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": {
      "created_at": "date",
      "updated_at": "date",
      "id": "integer",
      "name": "string"
    }

}
```
###DeleteSkill
Request :
 - Method : DELETE
 - Endpoint : '/api/v1/skill/{category_id}'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]

 
  Request :
  ```json
 {
     "name": "string",
     "category_id" : "integer"
     
 }
 ```
 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    

}
```
##Gig
###CreateGig
Request :
 - Method : POST
 - Endpoint : '/api/v1/gig/'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]

 
  Request :
  ```json
 {
     "name": "string",
     "category_id" : "integer"
     
 }
 ```
 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": {
          "created_at": "date",
          "updated_at": "date",
          "id": "integer",
          "name": "string"
        }
    

}
```
###UpdateGig
Request :
 - Method : PUT
 - Endpoint : '/api/v1/gig/{gig_id}'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]

 
  Request :
  ```json
 {
     "name": "string",
     "category_id" : "integer"
     
 }
 ```
 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": {
          "created_at": "date",
          "updated_at": "date",
          "id": "integer",
          "name": "string"
        }
    

}
```
###CreateListGig
Request :
 - Method : POST
 - Endpoint : '/api/v1/listgig/'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]

 
  Request :
  ```json
 {
     "gig_id": "integer",
     "list_id" : "integer"
     
 }
 ```
 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": {
      "created_at": "date",
      "updated_at": "date",
      "id": "integer",
      "list": {
        "created_at": "date",
        "updated_at": "date",
        "id": "integer",
        "name": "string",
        "description": "text",
        "user_id": "integer"
      },
      "gig": {
        "created_at": "date",
        "updated_at": "date",
        "id": "string",
        "name": "string"
      }
    }
    

}
```


##Lists
###CreateSkill
Request :
 - Method : POST
 - Endpoint : '/api/v1/skill/'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]

 
  Request :
  ```json
 {
     "name": "string",
     "category_id" : "integer"
     
 }
 ```
 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": {
          "created_at": "date",
          "updated_at": "date",
          "id": "integer",
          "name": "string"
        }
    

}
```
###GetSkill
Request :
 - Method : GET
 - Endpoint : '/api/v1/skill/'
 - Header : 
    - Content-Type: application/json
    - Accept: application/json
    - Authorization : Bearer [token]


 
 Response :
 ```json
{
    "code": "number",
    "status" : "string",
    "data": [
          { 
              "created_at": "date",
              "updated_at": "date",
              "id": "integer",
              "name": "string"
            }
    ]
    

}
```