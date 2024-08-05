DROP PROCEDURE IF EXISTS GetSortClasses;
CREATE PROCEDURE GetSortClasses(IN sort_id INT)
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE class_list TEXT;
    DECLARE cur CURSOR FOR
        SELECT CONCAT(c.nom, ':', sc.niveau) AS class_info
        FROM sortclasse sc
                 JOIN classe c ON sc.id_classe = c.id
        WHERE sc.id_sort = sort_id;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    SET @class_list = '';

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO class_list;
        IF done THEN
            LEAVE read_loop;
        END IF;
        SET @class_list = CONCAT(@class_list, IF(@class_list = '', '', ';'), class_list);
    END LOOP;
    CLOSE cur;

    SELECT s.*, @class_list AS classes_niveaux
    FROM sort s
    WHERE s.id = sort_id;
END;

DROP PROCEDURE IF EXISTS GetSortDomaines;
CREATE PROCEDURE GetSortDomaines(IN sort_id INT)
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE domain_list TEXT;
    DECLARE cur CURSOR FOR
        SELECT CONCAT(d.domaine, ':', sd.niveau) AS domain_info
        FROM sortdomaine sd
                 JOIN domaine d ON sd.id_domaine = d.id
        WHERE sd.id_sort = sort_id;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    SET @domain_list = '';

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO domain_list;
        IF done THEN
            LEAVE read_loop;
        END IF;
        SET @domain_list = CONCAT(@domain_list, IF(@domain_list = '', '', ';'), domain_list);
    END LOOP;
    CLOSE cur;

    SELECT s.*, @domain_list AS domaines_niveaux
    FROM sort s
    WHERE s.id = sort_id;
END;

DROP PROCEDURE IF EXISTS GetSortDetails;
CREATE PROCEDURE GetSortDetails(IN sort_id INT)
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE class_list TEXT;
    DECLARE domain_list TEXT;
    DECLARE class_info TEXT;
    DECLARE domain_info TEXT;

    -- Curseur pour les classes
    DECLARE cur_classes CURSOR FOR
        SELECT CONCAT(c.nom, ':', sc.niveau) AS class_info
        FROM sortclasse sc
                 JOIN classe c ON sc.id_classe = c.id
        WHERE sc.id_sort = sort_id;

    -- Curseur pour les domaines
    DECLARE cur_domaines CURSOR FOR
        SELECT CONCAT(d.domaine, ':', sd.niveau) AS domain_info
        FROM sortdomaine sd
                 JOIN domaine d ON sd.id_domaine = d.id
        WHERE sd.id_sort = sort_id;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    SET @class_list = '';
    SET @domain_list = '';

    -- Récupération des classes
    OPEN cur_classes;
    read_classes: LOOP
        FETCH cur_classes INTO class_info;
        IF done THEN
            LEAVE read_classes;
        END IF;
        SET @class_list = CONCAT(@class_list, IF(@class_list = '', '', ';'), class_info);
    END LOOP;
    CLOSE cur_classes;

    -- Réinitialisation du handler
    SET done = FALSE;

    -- Récupération des domaines
    OPEN cur_domaines;
    read_domaines: LOOP
        FETCH cur_domaines INTO domain_info;
        IF done THEN
            LEAVE read_domaines;
        END IF;
        SET @domain_list = CONCAT(@domain_list, IF(@domain_list = '', '', ';'), domain_info);
    END LOOP;
    CLOSE cur_domaines;

    -- Sélection des informations du sort avec les listes concaténées
    SELECT s.*, @class_list AS classes_niveaux, @domain_list AS domaines_niveaux
    FROM sort s
    WHERE s.id = sort_id;
END;

CREATE VIEW vue_spell_details AS
SELECT
    s.id, s.nom, s.ecole, s.complement_ecole, s.description,
    s.sauvegarde, s.composantes, s.temps_incantation, s.portee,
    s.effet, s.duree, s.resistance_magie, s.cibles,
    (SELECT GROUP_CONCAT(CONCAT(c.nom, ':', sc.niveau) SEPARATOR ';')
     FROM sortclasse sc
              JOIN classe c ON sc.id_classe = c.id
     WHERE sc.id_sort = s.id) AS classes_niveaux,
    (SELECT GROUP_CONCAT(CONCAT(d.domaine, ':', sd.niveau) SEPARATOR ';')
     FROM sortdomaine sd
              JOIN domaine d ON sd.id_domaine = d.id
     WHERE sd.id_sort = s.id) AS domaines_niveaux
FROM sort s;