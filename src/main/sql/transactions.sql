create table transactions (
  id SERIAL,
  idUser int,
  idWallet int,
  type varchar,
  cryptoINid varchar,
  cryptoIN varchar,
  cryptoINamount double precision ,
  cryptoINprice double precision ,
  cryptoOUTid varchar,
  cryptoOUT varchar,
  cryptoOUTamount double precision ,
  cryptoOUTprice double precision ,
  cryptoFEE varchar,
  cryptoFEEid varchar,
  cryptoFEEamount double precision ,
  date timestamp default current_timestamp
  );