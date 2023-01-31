create table assets (
  id SERIAL,
  id_user int,
  crypto varchar,
  cryptoamount double precision,
  date timestamp default current_timestamp);