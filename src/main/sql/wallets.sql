create table wallets (
    id SERIAL,
    idUser integer,
    name string,
    exchangeId string,
    blockchain string,
    publicKey string);