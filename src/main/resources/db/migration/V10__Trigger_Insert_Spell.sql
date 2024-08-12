
-- Suppression des triggers s'ils existent
DROP TRIGGER IF EXISTS sort_insert_audit;
DROP TRIGGER IF EXISTS sortclasse_insert_audit;
DROP TRIGGER IF EXISTS sortdomaine_insert_audit;

-- Création du trigger pour les insertions
CREATE TRIGGER sort_insert_audit
    AFTER INSERT ON sort
    FOR EACH ROW
BEGIN
    INSERT INTO sort_audit (sort_id, action, nouvelle_valeur, user_id)
    VALUES (NEW.id, 'INSERT', NEW.nom, @current_user_id);
END;

-- Triggers pour sortclasse
-- INSERT
CREATE TRIGGER sortclasse_insert_audit
    AFTER INSERT ON sortclasse
    FOR EACH ROW
BEGIN
    INSERT INTO sort_audit (sort_id, action, table_modifiee, nouvelle_valeur, user_id)
    VALUES (NEW.id_sort, 'INSERT', 'sortclasse', CONCAT_WS(',', NEW.id_classe, NEW.niveau), @current_user_id);
END;

-- Triggers pour sortdomaine
-- INSERT
CREATE TRIGGER sortdomaine_insert_audit
    AFTER INSERT ON sortdomaine
    FOR EACH ROW
BEGIN
    INSERT INTO sort_audit (sort_id, action, table_modifiee, nouvelle_valeur, user_id)
    VALUES (NEW.id_sort, 'INSERT', 'sortdomaine', CONCAT_WS(',', NEW.id_domaine, NEW.niveau), @current_user_id);
END;