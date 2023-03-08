CREATE OR REPLACE FUNCTION trig_soldes() RETURNS TRIGGER AS $soldes$
   BEGIN
       IF (TG_OP = 'INSERT') THEN
           update soldes set solde= soldeAchat - soldeVente where id=new.id;
       END IF;
      RETURN NEW;
   END;
$soldes$ LANGUAGE plpgsql;
