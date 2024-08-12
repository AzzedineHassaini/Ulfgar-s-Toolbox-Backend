-- Création table d'audit
CREATE TABLE IF NOT EXISTS sort_audit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sort_id INT,
    action ENUM('INSERT', 'UPDATE', 'DELETE') NOT NULL,
    table_modifiee ENUM('sort', 'sortclasse', 'sortdomaine') NOT NULL,
    champ_modifie VARCHAR(255),
    ancienne_valeur TEXT,
    nouvelle_valeur TEXT,
    date_modification TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id BIGINT,
    CONSTRAINT fk_sort_audit_sort FOREIGN KEY (sort_id) REFERENCES sort(id) ON DELETE SET NULL,
    CONSTRAINT fk_sort_audit_user FOREIGN KEY (user_id) REFERENCES user_(id) ON DELETE SET NULL
);
