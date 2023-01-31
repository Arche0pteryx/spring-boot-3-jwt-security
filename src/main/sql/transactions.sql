create table transactions (
  id SERIAL,
  id_user int,
  type varchar,
  cryptoIN varchar,
  cryptoINamount double precision ,
  cryptoOUT varchar,
  cryptoOUTamount double precision ,
  cryptoFEE varchar,
  cryptoFEEamount double precision ,
  date timestamp default current_timestamp
  );