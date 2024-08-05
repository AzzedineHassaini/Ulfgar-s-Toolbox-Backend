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