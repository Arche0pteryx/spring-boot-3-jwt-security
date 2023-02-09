create table wallets (
    id SERIAL,
    idUser integer,
    name varchar,
    exchangeId varchar,
    blockchain varchar,
    publicKey varchar);