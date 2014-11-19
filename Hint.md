## JDBC Sample Exercise

Write a program to read data from a given SQL table using JDBC. 

Given the table Employees, you need to connect to the DB, execute a select query, 
and print the results on the console. Use the commands below to connect to the DB
using your client and create the tables and populate with the data. Once ready, 
follow the steps as explained in the tutorial to connect to the DB, construct a 
`Statement` and extract data from the `ResultSet`.

```
CREATE TABLE Employees (
    emp_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    age INT,
    PRIMARY KEY ( emp_id )
);

insert into Employees (first_name, last_name, age) values ('Harry', 'Potter', 12);
insert into Employees (first_name, last_name, age) values ('Hermoine', 'Granger', 12);
insert into Employees (first_name, last_name, age) values ('Ronald', 'Weasley', 11);
insert into Employees (first_name, last_name, age) values ('Draco', 'Malfoy', 13);

commit;

select * from Employees;
```