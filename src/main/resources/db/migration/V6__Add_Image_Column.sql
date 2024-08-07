-- Add 'image' column to specified tables
ALTER TABLE arme ADD COLUMN image VARCHAR(255);
ALTER TABLE armure_bouclier ADD COLUMN image VARCHAR(255);
ALTER TABLE classe ADD COLUMN image VARCHAR(255);
ALTER TABLE dieu ADD COLUMN image VARCHAR(255);
ALTER TABLE race ADD COLUMN image VARCHAR(255);
ALTER TABLE user_ ADD COLUMN image VARCHAR(255);

-- Update 'classe' table with provided images
UPDATE classe SET image = 'magicien.jpeg' WHERE id = 6;
UPDATE classe SET image = 'ensorceleur.jpeg' WHERE id = 4;
UPDATE classe SET image = 'roublard.jpeg' WHERE id = 11;
UPDATE classe SET image = 'rodeur.jpeg' WHERE id = 10;
UPDATE classe SET image = 'paladin.jpeg' WHERE id = 8;
UPDATE classe SET image = 'moine.jpeg' WHERE id = 7;
UPDATE classe SET image = 'guerrier.jpeg' WHERE id = 5;
UPDATE classe SET image = 'druide.jpeg' WHERE id = 3;
UPDATE classe SET image = 'pretre.jpeg' WHERE id = 9;
UPDATE classe SET image = 'barde.jpeg' WHERE id = 2;
UPDATE classe SET image = 'barbare.jpeg' WHERE id = 1;