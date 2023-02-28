create table soldes (
  id SERIAL,
  idUser int,
  idWallet int,
  idTransaction int,
  idAsset int,
  crypto varchar,
  cryptoid varchar,
  solde numeric,
  date timestamp default current_timestamp);