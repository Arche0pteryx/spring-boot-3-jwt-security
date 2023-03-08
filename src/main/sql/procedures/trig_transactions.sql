CREATE OR REPLACE FUNCTION trig_transactions() RETURNS TRIGGER AS $transactions$
   DECLARE
   INsoldeA numeric;
   INsoldeV numeric;
   INvaleurA numeric;
   INvaleurV numeric;
   OUTsoldeA numeric;
   OUTsoldeV numeric;
   OUTvaleurA numeric;
   OUTvaleurV numeric;
   FEEsoldeA numeric;
   FEEsoldeV numeric;
   FEEvaleurA numeric;
   FEEvaleurV numeric;


   INavgBuy numeric;
   INavgSell numeric;
   OUTavgBuy numeric;
   OUTavgSell numeric;

   NEWsoldeA numeric;
   NEWsoldeV numeric;
   NEWvaleurA numeric;
   NEWvaleurV numeric;
   NEWavgPrice numeric;
   BEGIN

       IF (TG_OP = 'DELETE') THEN
            if (OLD.cryptoINid = OLD.cryptoFEEid) then
                update soldes set soldeAchat = soldeAchat - OLD.cryptoINamount +  OLD.cryptoFEEamount  ,valeurAchat= valeurAchat- OLD.cryptoINprice
                 where idWallet = OLD.idWallet and cryptoid=OLD.cryptoINid and dateff > OLD.date ;
                update soldes set soldeVente = soldeVente - OLD.cryptoOUTamount ,valeurVente= valeurVente- OLD.cryptoOUTprice  where idWallet = OLD.idWallet and cryptoid=OLD.cryptoOUTid and dateff > OLD.date ;
            elsif (OLD.cryptoOUTid = OLD.cryptoFEEid) then
                update soldes set soldeAchat = soldeAchat - OLD.cryptoINamount  ,valeurAchat= valeurAchat- OLD.cryptoINprice where idWallet = OLD.idWallet and cryptoid=OLD.cryptoINid and dateff > OLD.date ;
                update soldes set soldeVente = soldeVente - OLD.cryptoOUTamount - OLD.cryptoFEEamount  ,valeurVente= valeurVente- OLD.cryptoOUTprice  where idWallet = OLD.idWallet and cryptoid=OLD.cryptoOUTid and dateff > OLD.date ;
            else
                update soldes set
                soldeAchat = soldeAchat - OLD.cryptoINamount  ,
                valeurAchat= valeurAchat- (OLD.cryptoINprice * OLD.cryptoINamount) ,
                avgBuyPrice= (valeurAchat - OLD.cryptoINprice * OLD.cryptoINamount ) / (soldeAchat - OLD.cryptoINamount )
                where idWallet = OLD.idWallet and cryptoid=OLD.cryptoINid and dateff > OLD.date ;

                update soldes set soldeVente = soldeVente - OLD.cryptoOUTamount ,valeurVente= valeurVente- OLD.cryptoOUTprice  where idWallet = OLD.idWallet and cryptoid=OLD.cryptoOUTid and dateff > OLD.date;
                update soldes set soldeVente = soldeVente - OLD.cryptoFEEamount where idWallet = OLD.idWallet and cryptoid=OLD.cryptoFEEid and dateff > OLD.date ;
            end if;
            DELETE FROM soldes WHERE idTransaction = OLD.id;



       ELSIF (TG_OP = 'INSERT') THEN

			select soldeAchat,valeurAchat,soldeVente,valeurVente,avgBuyPrice,avgSellPrice into INsoldeA,INvaleurA,INsoldeV,INvaleurV,INavgBuy,INavgSell  from soldes where idWallet= new.idWallet and cryptoid=new.cryptoINid and dateff= (select max(dateff )
                             from soldes where idWallet= new.idWallet and cryptoid=new.cryptoINid and dateff < new.date) ;

			select soldeAchat,valeurAchat,soldeVente,valeurVente,avgBuyPrice,avgSellPrice  into OUTsoldeA,OUTvaleurA,OUTsoldeV,OUTvaleurV,OUTavgBuy,OUTavgSell  from soldes where idWallet= new.idWallet and cryptoid=new.cryptoOUTid and dateff= (select max(dateff )
                             from soldes where idWallet= new.idWallet and cryptoid=new.cryptoOUTid and dateff < new.date) ;

			select soldeAchat,valeurAchat,soldeVente,valeurVente into FEEsoldeA,FEEvaleurA,FEEsoldeV,FEEvaleurV  from soldes where idWallet= new.idWallet and cryptoid=new.cryptoFEEid and dateff= (select max(dateff )
                             from soldes where idWallet= new.idWallet and cryptoid=new.cryptoFEEid and dateff < new.date) ;

		    if (INsoldeA is null) then
		     INsoldeA :=0;
		    end if;
		    if (INsoldeV is null) then
		     INsoldeV :=0;
		    end if;
		    if (INvaleurA is null) then
		     INvaleurA :=0;
		    end if;
		    if (INvaleurV is null) then
		     INvaleurV :=0;
		    end if;

		    if (OUTsoldeA is null) then
		     OUTsoldeA :=0;
		    end if;
		    if (OUTsoldeV is null) then
		     OUTsoldeV :=0;
		    end if;
		    if (OUTvaleurA is null) then
		     OUTvaleurA :=0;
		    end if;
		    if (OUTvaleurV is null) then
		     OUTvaleurV :=0;
		    end if;

		    if (FEEsoldeA is null) then
		     FEEsoldeA :=0;
		    end if;
		    if (FEEsoldeV is null) then
		     FEEsoldeV :=0;
		    end if;
		    if (FEEvaleurA is null) then
		     FEEvaleurA :=0;
		    end if;
		    if (FEEvaleurV is null) then
		     FEEvaleurV :=0;
		    end if;


		    if (INavgBuy is null) then
		     INavgBuy :=0;
		    end if;
		    if (INavgSell is null) then
		     INavgSell :=0;
		    end if;
		    if (OUTavgBuy is null) then
		     OUTavgBuy :=0;
		    end if;
		    if (OUTavgSell is null) then
		     OUTavgSell :=0;
		    end if;

		----------------------------------------------------------------------------------------
		   if (new.cryptoINid = new.cryptoFEEid) then
				IF (new.cryptoINid is not null)  THEN
				   update soldes set
				   soldeAchat = soldeAchat + NEW.cryptoINamount ,
				   valeurAchat = valeurAchat + ( NEW.cryptoINamount * NEW.cryptoINprice ),
				   soldeVente = soldeVente + new.cryptoFEEamount
				   where idWallet = NEW.idWallet and cryptoid=NEW.cryptoINid and dateff > NEW.date ;

				    NEWsoldeA :=INsoldeA + new.cryptoINamount ;
					NEWvaleurA :=INvaleurA + ( NEW.cryptoINamount * NEW.cryptoINprice );
					NEWsoldeV :=INsoldeV + new.cryptoFEEamount;
					NEWvaleurV :=INvaleurV 	;
					NEWavgPrice := ((INavgBuy * (INsoldeA - INsoldeV))  + ( NEW.cryptoINamount * NEW.cryptoINprice )) / (INsoldeA - INsoldeV + NEW.cryptoINamount);

				   INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,soldeAchat,valeurAchat,avgBuyPrice,soldeVente,valeurVente,avgSellPrice,dateff)
				   VALUES (new.idUser, new.idWallet,new.id, new.cryptoIN,  new.cryptoINid,NEWsoldeA , NEWvaleurA ,NEWavgPrice  ,NEWsoldeV ,NEWvaleurV,INavgSell ,new.date);
			    END IF;

				IF (new.cryptoOUTid is not null)  THEN
					update soldes set soldeVente = soldeVente + NEW.cryptoOUTamount,
					valeurVente = valeurVente + ( NEW.cryptoOUTamount * NEW.cryptoOUTprice )
					where idWallet = NEW.idWallet and cryptoid=NEW.cryptoOUTid and dateff > NEW.date ;

					NEWsoldeA :=OUTsoldeA ;
					NEWvaleurA :=OUTvaleurA ;
					NEWsoldeV :=OUTsoldeV + new.cryptoOUTamount;
					NEWvaleurV :=OUTvaleurV + ( NEW.cryptoOUTamount * NEW.cryptoOUTprice );
                    NEWavgPrice := ((OUTavgSell * OUTsoldeV)  + ( NEW.cryptoOUTamount * NEW.cryptoOUTprice )) / ( OUTsoldeV + NEW.cryptoOUTamount);


				   INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,soldeAchat,valeurAchat,avgBuyPrice,soldeVente,valeurVente,avgSellPrice,dateff)
				   VALUES (new.idUser, new.idWallet,new.id, new.cryptoOUT,  new.cryptoOUTid,NEWsoldeA , NEWvaleurA, OUTavgBuy  ,NEWsoldeV ,NEWvaleurV ,NEWavgPrice,new.date);

				END IF;

			-----------------------------------------------------------------------------------
		   elsif (new.cryptoOUTid = new.cryptoFEEid) then
				IF (new.cryptoINid is not null)  THEN
				   update soldes set
				   soldeAchat = soldeAchat + NEW.cryptoINamount ,
				   valeurAchat = valeurAchat + ( NEW.cryptoINamount * NEW.cryptoINprice )
				   where idWallet = NEW.idWallet and cryptoid=NEW.cryptoINid and dateff > NEW.date ;

				    NEWsoldeA :=INsoldeA + new.cryptoINamount;
					NEWvaleurA :=INvaleurA + ( NEW.cryptoINamount * NEW.cryptoINprice );
					NEWsoldeV :=INsoldeB;
					NEWvaleurV :=INvaleurV;
                    NEWavgPrice := ((INavgBuy * (INsoldeA - INsoldeV))  + ( NEW.cryptoINamount * NEW.cryptoINprice )) / (INsoldeA - INsoldeV + NEW.cryptoINamount);

				   INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,soldeAchat,valeurAchat,avgBuyPrice,soldeVente,valeurVente,avgSellPrice,dateff)
				   VALUES (new.idUser, new.idWallet,new.id, new.cryptoIN,  new.cryptoINid,NEWsoldeA , NEWvaleurA ,NEWavgPrice  ,NEWsoldeV ,NEWvaleurV,INavgSell ,new.date);
			    END IF;

				IF (new.cryptoOUTid is not null)  THEN
					update soldes set soldeVente = soldeVente + NEW.cryptoOUTamount +  new.cryptoFEEamount,
					valeurVente = valeurVente + ( NEW.cryptoOUTamount * NEW.cryptoOUTprice )
					where idWallet = NEW.idWallet and cryptoid=NEW.cryptoOUTid and dateff > NEW.date ;

					NEWsoldeA :=OUTsoldeA ;
					NEWvaleurA :=OUTvaleurA ;
					NEWsoldeV :=OUTsoldeV + new.cryptoOUTamount +  new.cryptoFEEamount;
					NEWvaleurV :=OUTvaleurV + ( NEW.cryptoOUTamount * NEW.cryptoOUTprice );


				   INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,soldeAchat,valeurAchat,soldeVente,valeurVente,dateff)
				   VALUES (new.idUser, new.idWallet,new.id, new.cryptoOUT,  new.cryptoOUTid,NEWsoldeA , NEWvaleurA   ,NEWsoldeV ,NEWvaleurV ,new.date);

				END IF;
			else
			----------------------------------------------------------------------------------------------------------

				IF (new.cryptoINid is not null)  THEN
				   update soldes set
				   soldeAchat = soldeAchat + NEW.cryptoINamount ,
				   valeurAchat = valeurAchat + ( NEW.cryptoINamount * NEW.cryptoINprice )
				   where idWallet = NEW.idWallet and cryptoid=NEW.cryptoINid and dateff > NEW.date ;

				    NEWsoldeA :=INsoldeA + new.cryptoINamount;
					NEWvaleurA :=INvaleurA + ( NEW.cryptoINamount * NEW.cryptoINprice );
					NEWsoldeV :=INsoldeV;
					NEWvaleurV :=INvaleurV;
					NEWavgPrice := ((INavgBuy * (INsoldeA - INsoldeV))  + ( NEW.cryptoINamount * NEW.cryptoINprice )) / (INsoldeA - INsoldeV + NEW.cryptoINamount);


				   INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,soldeAchat,valeurAchat,avgBuyPrice,soldeVente,valeurVente,avgSellPrice,dateff)
				   VALUES (new.idUser, new.idWallet,new.id, new.cryptoIN,  new.cryptoINid,NEWsoldeA , NEWvaleurA ,NEWavgPrice  ,NEWsoldeV ,NEWvaleurV,INavgSell ,new.date);
			    END IF;

				IF (new.cryptoOUTid is not null)  THEN
					update soldes set soldeVente = soldeVente + NEW.cryptoOUTamount,
					valeurVente = valeurVente + ( NEW.cryptoOUTamount * NEW.cryptoOUTprice )
					where idWallet = NEW.idWallet and cryptoid=NEW.cryptoOUTid and dateff > NEW.date ;

					NEWsoldeA :=OUTsoldeA ;
					NEWvaleurA :=OUTvaleurA ;
					NEWsoldeV :=OUTsoldeV + new.cryptoOUTamount;
					NEWvaleurV :=OUTvaleurV + ( NEW.cryptoOUTamount * NEW.cryptoOUTprice );
                    NEWavgPrice := ((OUTavgSell * OUTsoldeV)  + ( NEW.cryptoOUTamount * NEW.cryptoOUTprice )) / ( OUTsoldeV + NEW.cryptoOUTamount);


				   INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,soldeAchat,valeurAchat,avgBuyPrice,soldeVente,valeurVente,avgSellPrice,dateff)
				   VALUES (new.idUser, new.idWallet,new.id, new.cryptoOUT,  new.cryptoOUTid,NEWsoldeA , NEWvaleurA, OUTavgBuy  ,NEWsoldeV ,NEWvaleurV ,NEWavgPrice,new.date);

				END IF;
				IF (new.cryptoFEEid is not null)   THEN
					update soldes set
					soldeVente = soldeVente + NEW.cryptoFEEamount ,
					valeurVente = valeurVente + ( NEW.cryptoFEEamount * NEW.cryptoFEEprice )
					where idWallet = NEW.idWallet and cryptoid=NEW.cryptoFEEid and dateff > NEW.date ;

					NEWsoldeA :=FEEsoldeA ;
					NEWvaleurA :=FEEvaleurA ;
					NEWsoldeV :=FEEsoldeV + new.cryptoFEEamount;
					NEWvaleurV :=FEEvaleurV ;

				   INSERT INTO soldes( idUser,idWallet,idTransaction,crypto,cryptoid,soldeAchat,valeurAchat,soldeVente,valeurVente,dateff)
				   VALUES (new.idUser, new.idWallet,new.id, new.cryptoFEE,  new.cryptoFEEid,NEWsoldeA , NEWvaleurA   ,NEWsoldeV ,NEWvaleurV ,new.date);
				END IF;
         end if;



         END IF;
      RETURN NEW;
   END;
$transactions$ LANGUAGE plpgsql;

