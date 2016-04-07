INSERT INTO country (country) values('Spain');
INSERT INTO country (country) values('Germany');
INSERT INTO country (country) values('Italy');

INSERT INTO users (name, password,email,dob,street,zipcode,city,country) values('Pepe', 'pass','pepe@anonymous.es','19800101','Sesame Street, 23','28001','Madrid',(select id from country where country='Spain'));
