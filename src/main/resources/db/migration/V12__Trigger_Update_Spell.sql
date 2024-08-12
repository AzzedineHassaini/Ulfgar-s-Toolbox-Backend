
-- Suppression des triggers s'ils existent
DROP TRIGGER IF EXISTS sort_update_audit;
DROP TRIGGER IF EXISTS sortclasse_update_audit;
DROP TRIGGER IF EXISTS sortdomaine_update_audit;


-- Création du trigger pour les update
CREATE TRIGGER sort_update_audit
    AFTER UPDATE ON sort
    FOR EACH ROW
BEGIN
    IF OLD.nom != NEW.nom THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'nom', OLD.nom, NEW.nom, @current_user_id);
END IF;

IF OLD.ecole != NEW.ecole THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'ecole', OLD.ecole, NEW.ecole, @current_user_id);
END IF;

    IF (OLD.complement_ecole IS NULL AND NEW.complement_ecole IS NOT NULL)
        OR (OLD.complement_ecole IS NOT NULL AND NEW.complement_ecole IS NULL)
        OR (OLD.complement_ecole != NEW.complement_ecole) THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'complement_ecole', OLD.complement_ecole, NEW.complement_ecole, @current_user_id);
END IF;

    IF (OLD.description IS NULL AND NEW.description IS NOT NULL)
        OR (OLD.description IS NOT NULL AND NEW.description IS NULL)
        OR (OLD.description != NEW.description) THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'description', OLD.description, NEW.description, @current_user_id);
END IF;

    IF (OLD.sauvegarde IS NULL AND NEW.sauvegarde IS NOT NULL)
        OR (OLD.sauvegarde IS NOT NULL AND NEW.sauvegarde IS NULL)
        OR (OLD.sauvegarde != NEW.sauvegarde) THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'sauvegarde', OLD.sauvegarde, NEW.sauvegarde, @current_user_id);
END IF;

    IF (OLD.composantes IS NULL AND NEW.composantes IS NOT NULL)
        OR (OLD.composantes IS NOT NULL AND NEW.composantes IS NULL)
        OR (OLD.composantes != NEW.composantes) THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'composantes', OLD.composantes, NEW.composantes, @current_user_id);
END IF;

    IF (OLD.temps_incantation IS NULL AND NEW.temps_incantation IS NOT NULL)
        OR (OLD.temps_incantation IS NOT NULL AND NEW.temps_incantation IS NULL)
        OR (OLD.temps_incantation != NEW.temps_incantation) THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'temps_incantation', OLD.temps_incantation, NEW.temps_incantation, @current_user_id);
END IF;

    IF (OLD.portee IS NULL AND NEW.portee IS NOT NULL)
        OR (OLD.portee IS NOT NULL AND NEW.portee IS NULL)
        OR (OLD.portee != NEW.portee) THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'portee', OLD.portee, NEW.portee, @current_user_id);
END IF;

    IF (OLD.effet IS NULL AND NEW.effet IS NOT NULL)
        OR (OLD.effet IS NOT NULL AND NEW.effet IS NULL)
        OR (OLD.effet != NEW.effet) THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'effet', OLD.effet, NEW.effet, @current_user_id);
END IF;

    IF (OLD.duree IS NULL AND NEW.duree IS NOT NULL)
        OR (OLD.duree IS NOT NULL AND NEW.duree IS NULL)
        OR (OLD.duree != NEW.duree) THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'duree', OLD.duree, NEW.duree, @current_user_id);
END IF;

    IF (OLD.resistance_magie IS NULL AND NEW.resistance_magie IS NOT NULL)
        OR (OLD.resistance_magie IS NOT NULL AND NEW.resistance_magie IS NULL)
        OR (OLD.resistance_magie != NEW.resistance_magie) THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'resistance_magie', OLD.resistance_magie, NEW.resistance_magie, @current_user_id);
END IF;

    IF (OLD.cibles IS NULL AND NEW.cibles IS NOT NULL)
        OR (OLD.cibles IS NOT NULL AND NEW.cibles IS NULL)
        OR (OLD.cibles != NEW.cibles) THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'cibles', OLD.cibles, NEW.cibles, @current_user_id);
END IF;

    IF (OLD.id_bouquin IS NULL AND NEW.id_bouquin IS NOT NULL)
        OR (OLD.id_bouquin IS NOT NULL AND NEW.id_bouquin IS NULL)
        OR (OLD.id_bouquin != NEW.id_bouquin) THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'id_bouquin', OLD.id_bouquin, NEW.id_bouquin, @current_user_id);
END IF;

    IF (OLD.page IS NULL AND NEW.page IS NOT NULL)
        OR (OLD.page IS NOT NULL AND NEW.page IS NULL)
        OR (OLD.page != NEW.page) THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id, 'UPDATE', 'sort', 'page', OLD.page, NEW.page, @current_user_id);
END IF;
END;

-- UPDATE
CREATE TRIGGER sortclasse_update_audit
    AFTER UPDATE ON sortclasse
    FOR EACH ROW
BEGIN
    IF OLD.id_classe != NEW.id_classe OR OLD.niveau != NEW.niveau THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id_sort, 'UPDATE', 'sortclasse',
                CASE
                    WHEN OLD.id_classe != NEW.id_classe THEN 'id_classe'
                    ELSE 'niveau'
END,
CASE
WHEN OLD.id_classe != NEW.id_classe THEN OLD.id_classe
ELSE CONCAT_WS(',', OLD.id_classe, OLD.niveau)
END,
CASE
WHEN OLD.id_classe != NEW.id_classe THEN NEW.id_classe
ELSE CONCAT_WS(',', NEW.id_classe, NEW.niveau)
END,
@current_user_id);
END IF;
END;


-- UPDATE
CREATE TRIGGER sortdomaine_update_audit
    AFTER UPDATE ON sortdomaine
    FOR EACH ROW
BEGIN
    IF OLD.id_domaine != NEW.id_domaine OR OLD.niveau != NEW.niveau THEN
        INSERT INTO sort_audit (sort_id, action, table_modifiee, champ_modifie, ancienne_valeur, nouvelle_valeur, user_id)
        VALUES (NEW.id_sort, 'UPDATE', 'sortdomaine',
                CASE
                    WHEN OLD.id_domaine != NEW.id_domaine THEN 'id_domaine'
                    ELSE 'niveau'
END,
CASE
WHEN OLD.id_domaine != NEW.id_domaine THEN OLD.id_domaine
ELSE CONCAT_WS(',', OLD.id_domaine, OLD.niveau)
END,
CASE
WHEN OLD.id_domaine != NEW.id_domaine THEN NEW.id_domaine
ELSE CONCAT_WS(',', NEW.id_domaine, NEW.niveau)
END,
@current_user_id);
END IF;
END;
