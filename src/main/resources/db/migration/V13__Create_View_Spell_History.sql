
-- Création de la vue d'historique des sorts
CREATE OR REPLACE VIEW vue_historique_sorts AS
SELECT
    sa.id AS id_audit,
    s.nom AS nom_sort,
    sa.action,
    sa.table_modifiee,
    sa.champ_modifie,
    CASE
        WHEN sa.table_modifiee = 'sortclasse' THEN
            CONCAT('Classe: ', c.nom, ', Niveau: ', SUBSTRING_INDEX(sa.ancienne_valeur, ',', -1))
        WHEN sa.table_modifiee = 'sortdomaine' THEN
            CONCAT('Domaine: ', d.domaine, ', Niveau: ', SUBSTRING_INDEX(sa.ancienne_valeur, ',', -1))
        ELSE sa.ancienne_valeur
        END AS ancienne_valeur,
    CASE
        WHEN sa.table_modifiee = 'sortclasse' THEN
            CONCAT('Classe: ', c.nom, ', Niveau: ', SUBSTRING_INDEX(sa.nouvelle_valeur, ',', -1))
        WHEN sa.table_modifiee = 'sortdomaine' THEN
            CONCAT('Domaine: ', d.domaine, ', Niveau: ', SUBSTRING_INDEX(sa.nouvelle_valeur, ',', -1))
        ELSE sa.nouvelle_valeur
        END AS nouvelle_valeur,
    sa.date_modification,
    u.pseudo AS utilisateur
FROM
    sort_audit sa
        LEFT JOIN
    sort s ON sa.sort_id = s.id
        LEFT JOIN
    user_ u ON sa.user_id = u.id
        LEFT JOIN
    classe c ON sa.table_modifiee = 'sortclasse' AND
                CASE
                    WHEN sa.action = 'DELETE' THEN c.id = SUBSTRING_INDEX(sa.ancienne_valeur, ',', 1)
                    ELSE c.id = SUBSTRING_INDEX(sa.nouvelle_valeur, ',', 1)
                    END
        LEFT JOIN
    domaine d ON sa.table_modifiee = 'sortdomaine' AND
                 CASE
                     WHEN sa.action = 'DELETE' THEN d.id = SUBSTRING_INDEX(sa.ancienne_valeur, ',', 1)
                     ELSE d.id = SUBSTRING_INDEX(sa.nouvelle_valeur, ',', 1)
                     END
ORDER BY
    sa.date_modification DESC;
