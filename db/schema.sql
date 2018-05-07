CREATE SEQUENCE users_seq START 1 INCREMENT 1;
CREATE TABLE users (
  id int PRIMARY key default nextval('users_seq'),
  login varchar(20),
  password varchar(100),
  email varchar(50)
);

CREATE SEQUENCE income_seq START 1 INCREMENT 1;
CREATE TABLE income (
  id int PRIMARY key default nextval ('income_seq'),
  idUser int REFERENCES users(id),
  categoryID int REFERENCES category(categoryID),
  incomeName varchar (20),
  incomeAmount int,
  addDate varchar(20)
);

CREATE SEQUENCE outgoings_seq START 1 INCREMENT 1;
CREATE TABLE outgoings(
outgoingsID int PRIMARY KEY default nextval('outgoings_seq'),
userID int REFERENCES users(id),
categoryID int REFERENCES category(categoryID),
outgoingsName varchar (20),
outgoingsAmount int ,
addDate varchar(20)
);


CREATE SEQUENCE category_seq START 1 INCREMENT 1;
CREATE TABLE category(
categoryID int PRIMARY KEY default nextval('category_seq'),
categoryName varchar (20),
categoryType varchar (20),
);





