create table assets (
  id SERIAL,
  idUser int,
  idWallet int,
  crypto varchar,
  cryptoid varchar,
  cryptoamount double precision,
  avgBuyPrice double precision,
  date timestamp default current_timestamp);