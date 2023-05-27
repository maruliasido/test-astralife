# test-astralife (employee crud)

# requirement tools
- java
- gradle build tools

# how to run
Please overide database config when running the program and execute create table on your sql from "/src/main/resources/create-all-table.sql
command :
  - gradle clean build
  - gradle bootRun

I also put a postman documentation on file maruli-astralife-be-test.json as you can see sample of request/ response also list of an available API.

#a bit of suggestion
- I create class "Base Entity" contains created_by, created_date, version, modified_date, modified_by. When you need it just extend this class everytime you create an Entity class. In this code i didn't implement yet due to following test instruction.
- Don't force One-to-many relation (like https://dev.mysql.com/doc/employee/en/sakila-structure.html), you can use Zero-to-Many for better performence instead.

#Please use /src/main/resources/create-all-table.sql to create a table to make sure entity on this project equals to SQL table
