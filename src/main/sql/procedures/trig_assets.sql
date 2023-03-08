CREATE OR REPLACE FUNCTION trig_assets() RETURNS TRIGGER AS $assets$
DECLARE
 dateWallet timestamp ;
   BEGIN
       IF (TG_OP = 'DELETE') THEN
            update soldes set solde = solde - OLD.cryptoamount where idWallet = OLD.idWallet and cryptoid=OLD.cryptoid and dateff > OLD.date ;
            DELETE FROM soldes WHERE idAsset = OLD.id;
       ELSIF (TG_OP = 'INSERT') THEN
         select date into dateWallet from wallets where id=NEW.idwallet;
           update soldes set  avgBuyPrice=( avgBuyPrice*solde+ new.cryptoamount*new.avgBuyPrice) / (solde + NEW.cryptoamount) , solde = solde + NEW.cryptoamount  where idWallet = NEW.idWallet and cryptoid=NEW.cryptoid and dateff > (select dateff from wallets where id=NEW.idWallet) ;
           INSERT INTO soldes( idUser,idWallet,idAsset,crypto,cryptoid,soldeAchat,valeurAchat,soldeVente,valeurVente,avgBuyPrice,avgSellPrice,solde,dateff)
           VALUES (new.idUser, new.idWallet,new.id, new.crypto, new.cryptoid, new.cryptoamount,new.cryptoamount*new.avgBuyPrice,0,0, new.avgBuyPrice ,0,0,dateWallet);
         END IF;
      RETURN NEW;
   END;
$assets$ LANGUAGE plpgsql;
