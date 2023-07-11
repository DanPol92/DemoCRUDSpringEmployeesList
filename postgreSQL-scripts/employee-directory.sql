--create table--

CREATE TABLE employee (
                          id serial primary key ,
                          first_name varchar(50) DEFAULT NULL,
                          last_name varchar(50) DEFAULT NULL,
                          email varchar(50) DEFAULT NULL
);

--insert into db some predefined values--
INSERT INTO employee VALUES
                         (1,'Dan','Pol','dan@email.com'),
                         (2,'Ionut','Popescu','ionut@email.com'),
                         (3,'Maria','Ionescu','maria@email.com');