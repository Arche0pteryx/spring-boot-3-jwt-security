CREATE OR REPLACE FUNCTION trig_assets() RETURNS TRIGGER AS $assets$
   BEGIN
       IF (TG_OP = 'DELETE') THEN
            update soldes set solde = solde - OLD.cryptoamount where idWallet = OLD.idWallet and cryptoid=OLD.cryptoid and date > OLD.date ;
            DELETE FROM soldes WHERE idAsset = OLD.id;
       ELSIF (TG_OP = 'INSERT') THEN
           update soldes set solde = solde + NEW.cryptoamount where idWallet = NEW.idWallet and cryptoid=NEW.cryptoid and date > NEW.date ;
           INSERT INTO soldes( idUser,idWallet,idAsset,crypto,cryptoid,solde,date)
           VALUES (new.idUser, new.idWallet,new.id, new.crypto, new.cryptoid, new.cryptoamount, (select date from wallets where id=NEW.idWallet));
         END IF;
      RETURN NEW;
   END;
$assets$ LANGUAGE plpgsql;


