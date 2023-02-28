CREATE OR REPLACE FUNCTION trig_transactions() RETURNS TRIGGER AS $transactions$
   DECLARE
   BEGIN
       IF (TG_OP = 'DELETE') THEN
            if (OLD.cryptoINid = OLD.cryptoFEEid) then
              update soldes set solde = solde - OLD.cryptoINamount + OLD.cryptoFEEamount where idWallet = OLD.idWallet and cryptoid=OLD.cryptoINid and date > OLD.date ;
              update soldes set solde = solde + OLD.cryptoOUTamount where idWallet = OLD.idWallet and cryptoid=OLD.cryptoOUTid and date > OLD.date ;
            elsif (OLD.cryptoOUTid = OLD.cryptoFEEid) then
                update soldes set solde = solde - OLD.cryptoINamount where idWallet = OLD.idWallet and cryptoid=OLD.cryptoINid and date > OLD.date ;
                update soldes set solde = solde + OLD.cryptoOUTamount + OLD.cryptoFEEamount where idWallet = OLD.idWallet and cryptoid=OLD.cryptoOUTid and date > OLD.date ;
            else
                update soldes set solde = solde - OLD.cryptoINamount where idWallet = OLD.idWallet and cryptoid=OLD.cryptoINid and date > OLD.date ;
                update soldes set solde = solde + OLD.cryptoOUTamount where idWallet = OLD.idWallet and cryptoid=OLD.cryptoOUTid and date > OLD.date ;
                update soldes set solde = solde + OLD.cryptoFEEamount where idWallet = OLD.idWallet and cryptoid=OLD.cryptoFEEid and date > OLD.date ;
            end if;
            DELETE FROM soldes WHERE idTransaction = OLD.id;
       ELSIF (TG_OP = 'INSERT') THEN
        if (new.cryptoINid = new.cryptoFEEid) then
         IF (new.cryptoINid is not null)  THEN
           update soldes set solde = solde + NEW.cryptoINamount - NEW.cryptoFEEamount  where idWallet = NEW.idWallet and cryptoid=NEW.cryptoINid and date > NEW.date ;
           INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,solde,date)
           VALUES (new.idUser, new.idWallet,new.id, new.cryptoIN, new.cryptoINid,
            coalesce((select solde from soldes where idWallet= new.idWallet and cryptoid=new.cryptoINid and date= (select max(date )
                             from soldes where idWallet= new.idWallet and cryptoid=new.cryptoINid and date < new.date)  ),0) + new.cryptoINamount - new.cryptoFEEamount
                           , new.date);
         END IF;
         IF (new.cryptoOUTid is not null)  THEN
                update soldes set solde = solde - NEW.cryptoOUTamount where idWallet = NEW.idWallet and cryptoid=NEW.cryptoOUTid and date > NEW.date ;
                INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,solde,date)
                VALUES (new.idUser, new.idWallet,new.id, new.cryptoOUT, new.cryptoOUTid,
                 (select solde from soldes where idWallet= new.idWallet and cryptoid=new.cryptoOUTid and date= (select max(date )
                                              from soldes where idWallet= new.idWallet and cryptoid=new.cryptoOUTid and date < new.date)  ) - new.cryptoOUTamount
                , new.date);
          END IF;
       elsif (new.cryptoOUTid = new.cryptoFEEid) then
         IF (new.cryptoINid is not null)  THEN
           update soldes set solde = solde + NEW.cryptoINamount where idWallet = NEW.idWallet and cryptoid=NEW.cryptoINid and date > NEW.date ;
           INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,solde,date)
           VALUES (new.idUser, new.idWallet,new.id, new.cryptoIN, new.cryptoINid,
            coalesce((select solde from soldes where idWallet= new.idWallet and cryptoid=new.cryptoINid and date= (select max(date )
                             from soldes where idWallet= new.idWallet and cryptoid=new.cryptoINid and date < new.date)  ),0) + new.cryptoINamount
                           , new.date);
            END IF;
            IF (new.cryptoOUTid is not null)  THEN
                update soldes set solde = solde - NEW.cryptoOUTamount - NEW.cryptoFEEamount  where idWallet = NEW.idWallet and cryptoid=NEW.cryptoOUTid and date > NEW.date ;
                INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,solde,date)
                VALUES (new.idUser, new.idWallet,new.id, new.cryptoOUT, new.cryptoOUTid,
                 (select solde from soldes where idWallet= new.idWallet and cryptoid=new.cryptoOUTid and date= (select max(date )
                                              from soldes where idWallet= new.idWallet and cryptoid=new.cryptoOUTid and date < new.date)  ) - new.cryptoOUTamount - new.cryptoFEEamount
                , new.date);
            END IF;
        else
         IF (new.cryptoINid is not null)  THEN
           update soldes set solde = solde + NEW.cryptoINamount where idWallet = NEW.idWallet and cryptoid=NEW.cryptoINid and date > NEW.date ;
           INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,solde,date)
           VALUES (new.idUser, new.idWallet,new.id, new.cryptoIN, new.cryptoINid,
            coalesce((select solde  from soldes where idWallet= new.idWallet and cryptoid=new.cryptoINid and date= (select max(date )
                             from soldes where idWallet= new.idWallet and cryptoid=new.cryptoINid and date < new.date)  ),0)+ new.cryptoINamount
                           , new.date);
            END IF;
            IF (new.cryptoOUTid is not null)  THEN
                update soldes set solde = solde - NEW.cryptoOUTamount where idWallet = NEW.idWallet and cryptoid=NEW.cryptoOUTid and date > NEW.date ;
                INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,solde,date)
                VALUES (new.idUser, new.idWallet,new.id, new.cryptoOUT, new.cryptoOUTid,
                 (select solde from soldes where idWallet= new.idWallet and cryptoid=new.cryptoOUTid and date= (select max(date )
                                              from soldes where idWallet= new.idWallet and cryptoid=new.cryptoOUTid and date < new.date)  ) - new.cryptoOUTamount
                , new.date);
            END IF;
            IF (new.cryptoFEEid is not null)   THEN
                update soldes set solde = solde - NEW.cryptoFEEamount where idWallet = NEW.idWallet and cryptoid=NEW.cryptoFEEid and date > NEW.date ;
                 INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,solde,date)
                 VALUES (new.idUser, new.idWallet,new.id, new.cryptoFEE, new.cryptoFEEid,
                  (select solde from soldes where idWallet= new.idWallet and cryptoid=new.cryptoFEEid and date= (select max(date )
                                               from soldes where idWallet= new.idWallet and cryptoid=new.cryptoFEEid and date < new.date)  ) - new.cryptoFEEamount
                 , new.date);
            END IF;
         end if;



         END IF;
      RETURN NEW;
   END;
$transactions$ LANGUAGE plpgsql;

