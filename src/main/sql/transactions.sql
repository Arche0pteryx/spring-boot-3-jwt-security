create table transactions (
  id SERIAL,
  idUser int,
  idWallet int,
  type varchar,
  cryptoINid varchar,
  cryptoIN varchar,
  cryptoINamount numeric ,
  cryptoINprice numeric ,
  cryptoOUTid varchar,
  cryptoOUT varchar,
  cryptoOUTamount numeric ,
  cryptoOUTprice numeric ,
  cryptoFEE varchar,
  cryptoFEEid varchar,
  cryptoFEEamount numeric ,
  date timestamp default current_timestamp
  );