CREATE TRIGGER or REPLACE trig_assets
 AFTER INSERT or DELETE ON assets
 FOR EACH ROW EXECUTE PROCEDURE trig_assets();