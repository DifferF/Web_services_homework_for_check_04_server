use CarsShop;



drop table CarsShop.clients;
drop table CarsShop.cars;
CREATE TABLE clients
(
    id_clients INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(30),
    age INT,
    phone VARCHAR(15),
    PRIMARY KEY (id_clients)
);

create table cars(
id_cars INT NOT NULL auto_increment primary key,
mark  varchar(20) NOT NULL,
model varchar(20) NOT NULL,
price INT NOT NULL
);








