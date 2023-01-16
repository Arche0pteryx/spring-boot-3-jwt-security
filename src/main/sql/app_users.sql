create table app_users (
  id SERIAL,
  firstname varchar,
  lastname varchar,
  email varchar ,
  password varchar,
  role varchar default 'USER' );