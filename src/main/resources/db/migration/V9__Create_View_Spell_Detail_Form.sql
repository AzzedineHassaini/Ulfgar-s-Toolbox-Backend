-- Suppression de la vue existante
DROP VIEW IF EXISTS vue_spell_details_form;

-- Création de la vue mise à jour
CREATE VIEW vue_spell_details_form AS
SELECT
    s.id, s.nom, s.ecole, s.complement_ecole, s.description,
    s.sauvegarde, s.composantes, s.temps_incantation, s.portee,
    s.effet, s.duree, s.resistance_magie, s.cibles,
    s.id_bouquin, s.page,
    b.nom AS nom_bouquin, b.short_name AS short_name_bouquin,
    se.image AS ecole_image,
    (SELECT GROUP_CONCAT(CONCAT(c.id, ':', sc.niveau) SEPARATOR ';')
     FROM sortclasse sc
              JOIN classe c ON sc.id_classe = c.id
     WHERE sc.id_sort = s.id) AS classes_niveaux,
    (SELECT GROUP_CONCAT(CONCAT(d.id, ':', sd.niveau) SEPARATOR ';')
     FROM sortdomaine sd
              JOIN domaine d ON sd.id_domaine = d.id
     WHERE sd.id_sort = s.id) AS domaines_niveaux
FROM sort s
         LEFT JOIN bouquin b ON s.id_bouquin = b.id
         LEFT JOIN sortecoles se ON s.ecole = se.ecole;