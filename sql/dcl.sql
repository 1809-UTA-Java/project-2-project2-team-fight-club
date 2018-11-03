DROP USER fcadmin CASCADE;

/* Create database and user */
CREATE USER fcadmin
IDENTIFIED BY password
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

/* Grant permissions to user */
GRANT connect to fcadmin;
GRANT resource to fcadmin;
GRANT create session to fcadmin;
GRANT create table to fcadmin;
GRANT create view to fcadmin;