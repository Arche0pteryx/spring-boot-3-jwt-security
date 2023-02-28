CREATE TRIGGER trig_transactions
 AFTER INSERT or DELETE ON transactions
 FOR EACH ROW EXECUTE PROCEDURE trig_transactions();