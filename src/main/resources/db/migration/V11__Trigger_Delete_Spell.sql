-- Suppression des triggers s'ils existent
DROP TRIGGER IF EXISTS sort_delete_audit;
DROP TRIGGER IF EXISTS sortclasse_delete_audit;
DROP TRIGGER IF EXISTS sortdomaine_delete_audit;

-- Création du trigger pour les suppressions
CREATE TRIGGER sort_delete_audit
    BEFORE DELETE ON sort
    FOR EACH ROW
BEGIN
    INSERT INTO sort_audit (sort_id, action, ancienne_valeur, user_id)
    VALUES (OLD.id, 'DELETE', OLD.nom, @current_user_id);
END;

-- DELETE
CREATE TRIGGER sortclasse_delete_audit
    BEFORE DELETE ON sortclasse
    FOR EACH ROW
BEGIN
    INSERT INTO sort_audit (sort_id, action, table_modifiee, ancienne_valeur, user_id)
    VALUES (OLD.id_sort, 'DELETE', 'sortclasse', CONCAT_WS(',', OLD.id_classe, OLD.niveau), @current_user_id);
END;

-- DELETE
CREATE TRIGGER sortdomaine_delete_audit
    BEFORE DELETE ON sortdomaine
    FOR EACH ROW
BEGIN
    INSERT INTO sort_audit (sort_id, action, table_modifiee, ancienne_valeur, user_id)
    VALUES (OLD.id_sort, 'DELETE', 'sortdomaine', CONCAT_WS(',', OLD.id_domaine, OLD.niveau), @current_user_id);
END;