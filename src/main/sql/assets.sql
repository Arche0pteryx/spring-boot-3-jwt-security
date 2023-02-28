create table assets (
  id SERIAL,
  idUser int,
  idWallet int,
  crypto varchar,
  cryptoid varchar,
  cryptoamount numeric,
  avgBuyPrice numeric,
  date timestamp default current_timestamp);

