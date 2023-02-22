create table wallets (
    id SERIAL,
    id_user int,
    name varchar,
    exchangeId varchar,
    blockchain varchar,
    publicKey varchar,
    date timestamp default current_timestamp);