create table users (
  id SERIAL,
  firstname varchar,
  lastname varchar,
  email varchar ,
  password varchar,
  creation_date  timestamp default current_timestamp,
  role varchar default 'USER' );