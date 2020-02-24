# QUERYING DATABASE FROM UI

----------------
### OBJECTIVES:

A program created with the motive of making people life easier when dealing with the database. It allows a user to insert or retrive values from the database without going the rigorous process of working with the DBMS(DataBase Management System).
REQUIREMENTS:

>1. Java IDE(ecllipse) for writing java code.
>
>2. DBMS (MySql).
>
>3. MySql connecter/j.

----------------------------------

### Java database connectivity with MySql:

To connect java application with MySql database, we need to follow 5 steps:

>1.Driver class: The driver class for the mysql database is com.mysql.jdbc.Driver.
>
>2.Connection URL: The connection URL for the mysql database is jdbc:mysql://localhost:3306/college where jdbc is the API, mysql is the >database, localhost is the server name on which mysql is running, we may also use IP address, 3306 is the port number and college is >the database name. We may use any database, in such case, we need to replace the college with our database name.
>
>3.Username: The default username for the mysql database is root.
>
>4.Password: It is the password given by the user at the time of installing the mysql database. In this example, we are going to use >"password" as the password.
>
>Let's first create a table in the mysql database, but before creating table, we need to create database first.
 
 ---------------------------------------
 
### Connect Java Application with mysql database:

To connect java application with the mysql database, mysqlconnector.jar file is required to be loaded.
download the jar file mysql-connector.jar

>After downloading the mySql-connecter.jar
>
>1. open your java ide and create a new java project.
>
>2. since mySql-connecter.jar is a external library that's why it is needed to added to the current libraries.
>To add connecter to library:
 > 1.Right click on JRE System library->build path->configure build path.
 
>3.Then select Add library->user library->new.
>Than give the name to your library In my case it is MYSQL JDBC Driver.
>
>4. select add external jar and then add the jar file that is downloaded .
> 
>5.apply and close it after that click on finish.
>
>Now the mysql-connecter-java is added to libraries;
>
>6. now we can write code to set up connection and start making queries with mysql database.
>
----------------
### Now the the environment is set for some serious coding.
