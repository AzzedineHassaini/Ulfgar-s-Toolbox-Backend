USE dnd35;
-- { DATA DEFINITION 1st step

-- { Structure de la table `user_`

DROP TABLE IF EXISTS `user_`;
CREATE TABLE `user_` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `pseudo` varchar(255) NOT NULL,
  `role` enum('ADMIN','CONTRIBUTOR','USER') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKha67cvlhy4nk1prswl5gj1y0y` (`email`),
  UNIQUE KEY `UKe5gmkv0er9tfcaijul8uxqfqf` (`pseudo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- }

-- { Structure de la table `classe`

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id` int NOT NULL,
  `nom` varchar(45) NOT NULL,
  `dV` int NOT NULL,
  `points_competences` int NOT NULL,
  `caracteristique_lanceur_sort` varchar(15) DEFAULT NULL,
  `po_min_lvl1` int NOT NULL DEFAULT '0',
  `po_max_lvl1` int NOT NULL DEFAULT '0',
  `description` text,
  `type_magie` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- }

-- { Structure de la table `race`

DROP TABLE IF EXISTS `race`;
CREATE TABLE IF NOT EXISTS `race` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `taille` varchar(3) NOT NULL,
  `vitesse` int NOT NULL,
  `dons_supp_lvl1` int NOT NULL,
  `comp_supp_lvl1` int NOT NULL,
  `comp_supp_by_lvl` int NOT NULL,
  `id_classe_predilection` int NOT NULL,
  `immunite_sommeil` tinyint NOT NULL,
  `vision_nocturne` int NOT NULL,
  `vision_noir` int NOT NULL,
  `modif_for` int NOT NULL DEFAULT '0',
  `modif_dex` int NOT NULL DEFAULT '0',
  `modif_con` int NOT NULL DEFAULT '0',
  `modif_int` int NOT NULL DEFAULT '0',
  `modif_sag` int NOT NULL DEFAULT '0',
  `modif_cha` int NOT NULL DEFAULT '0',
  `nb_langues_supplementaires` int NOT NULL DEFAULT '0',
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- }

-- { Structure de la table `dieu`

DROP TABLE IF EXISTS `dieu`;
CREATE TABLE IF NOT EXISTS `dieu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `alignement` varchar(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- }

-- { Structure de la table `alignement`

DROP TABLE IF EXISTS `alignement`;
CREATE TABLE IF NOT EXISTS `alignement` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `diminutif` varchar(2) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- }

-- { Structure de la table `caracteristique` 

DROP TABLE IF EXISTS `caracteristique`;
CREATE TABLE IF NOT EXISTS `caracteristique` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `diminutif` varchar(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- }

-- { Structure de la table `age` (Dépendance : Race)

DROP TABLE IF EXISTS `age`;
CREATE TABLE IF NOT EXISTS `age` (
  `id` int NOT NULL AUTO_INCREMENT,
  `race` int NOT NULL,
  `age_adulte` int NOT NULL,
  `age_mur` int NOT NULL,
  `age_grand` int NOT NULL,
  `age_venerable` int NOT NULL,
  `age_maximal` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_age_race` FOREIGN KEY (`race`) REFERENCES `race` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- }

-- { Structure de la table `charge`

DROP TABLE IF EXISTS `charge`;
CREATE TABLE IF NOT EXISTS `charge` (
  `id` int NOT NULL AUTO_INCREMENT,
  `force` int NOT NULL,
  `legere_max` float NOT NULL,
  `intermediaire_max` float NOT NULL,
  `lourde_max` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

-- }

-- { Structure de la table `competence`

DROP TABLE IF EXISTS `competence`;
CREATE TABLE IF NOT EXISTS `competence` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `caracteristique` varchar(3) NOT NULL,
  `malus_armure` tinyint NOT NULL,
  `formation_necessaire` tinyint NOT NULL,
  `description` text,
  `action` text,
  `nouvelle_tentative` text,
  `special` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4;

-- }

-- { Structure de la table `arme`

DROP TABLE IF EXISTS `arme`;
CREATE TABLE IF NOT EXISTS `arme` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` enum('Arme courante','Arme de guerre','Arme exotique','') NOT NULL DEFAULT 'Arme courante',
  `sous_type` enum('Combat à mains nues','Armes de corps à corps légères','Armes de corps à corps à une main','Armes de corps à corps à deux mains','Armes à distance','') NOT NULL,
  `nom` varchar(255) NOT NULL,
  `degats_p` varchar(10) NOT NULL,
  `degats_m` varchar(10) NOT NULL,
  `critique` varchar(15) NOT NULL,
  `portee` int DEFAULT NULL,
  `poids` float DEFAULT NULL,
  `type_degats` enum('Perforant','Contondant','Tranchant','Contondant et perforant','Perforant ou tranchant','') NOT NULL DEFAULT 'Contondant',
  `prix` float DEFAULT NULL,
  `force_min` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4;

-- }

-- { Structure de la table `armure_bouclier`

DROP TABLE IF EXISTS `armure_bouclier`;
CREATE TABLE IF NOT EXISTS `armure_bouclier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `type` enum('Bouclier','Armure légère','Armure intermédiaire','Armure lourde') NOT NULL,
  `prix` int NOT NULL,
  `bonus` int NOT NULL,
  `dex_max` int NOT NULL,
  `malus_tests` int NOT NULL,
  `echec_sorts` int NOT NULL,
  `vitesse9` int NOT NULL,
  `vitesse6` int NOT NULL,
  `poids` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- }

-- }


-- { DATA DEFINITION 2nd step

-- { Structure de la table `bouquin`
DROP TABLE IF EXISTS `bouquin`;
CREATE TABLE IF NOT EXISTS `bouquin`
(
    id bigint auto_increment primary key,
    cover      varchar(255) null,
    link       varchar(255) null,
    nom        varchar(255) not null,
    short_name varchar(255) not null
);

-- }

-- { Structure de la table `sort`

DROP TABLE IF EXISTS `sort`;
CREATE TABLE IF NOT EXISTS `sort` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `ecole` enum('Abjuration','Divination','Enchantement','Evocation','Illusion','Invocation','Nécromancie','Transmutation','Universelle','') DEFAULT NULL,
  `complement_ecole` varchar(255) DEFAULT NULL,
  `description` text,
  `sauvegarde` text,
  `composantes` text,
  `temps_incantation` text,
  `portee` text,
  `effet` text,
  `duree` text,
  `resistance_magie` text,
  `cibles` text,
  `id_bouquin` bigint,
  `page` int,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sort_bouquin` FOREIGN KEY (`id_bouquin`) REFERENCES `bouquin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=831 DEFAULT CHARSET=utf8mb4;

-- }

-- { Structure de la table `sortclasse` (Dependance : Classe & Sort)

DROP TABLE IF EXISTS `sortclasse`;
CREATE TABLE IF NOT EXISTS `sortclasse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_sort` int NOT NULL,
  `id_classe` int NOT NULL,
  `niveau` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sort_classe` FOREIGN KEY (`id_sort`) REFERENCES `sort` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_classe` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1415 DEFAULT CHARSET=utf8mb4;

-- }

-- { Structure de la table `domaine`

DROP TABLE IF EXISTS `domaine`;
CREATE TABLE IF NOT EXISTS `domaine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `domaine` varchar(255) NOT NULL,
  `pouvoir` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- }

-- { Structure de la table `sortdomaine` (Dependance : Domaine & Sort)

DROP TABLE IF EXISTS `sortdomaine`;
CREATE TABLE IF NOT EXISTS `sortdomaine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_sort` int NOT NULL,
  `id_domaine` int NOT NULL,
  `niveau` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sort_domaine` FOREIGN KEY (`id_sort`) REFERENCES `sort` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_domaine` FOREIGN KEY (`id_domaine`) REFERENCES `domaine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=utf8mb4;

-- }

-- }


-- { DATA DEFINITION 3rd step

-- { Structure de la table `classeleveling`  (Dépendance : Classe)

DROP TABLE IF EXISTS `classeleveling`;
CREATE TABLE IF NOT EXISTS `classeleveling` (
	`id` int NOT NULL AUTO_INCREMENT,
	`id_classe` int NOT NULL,
	`niveau` int NOT NULL,
	`bba` varchar(20) NOT NULL,
	`reflexes` int NOT NULL,
	`vigueur` int NOT NULL,
	`volonte` int NOT NULL,
	`special` int NOT NULL,
	`don_supp` int NOT NULL,
	`don_supp_guerrier` int NOT NULL DEFAULT '0',
	`deluge_coups` varchar(25) DEFAULT NULL,
	`degats_mains_nues_p` varchar(10) DEFAULT NULL,
	`degats_mains_nues_m` varchar(10) DEFAULT NULL,
	`bonus_ca` int DEFAULT '0',
	`deplacement_accelere` int DEFAULT NULL,
	`sort_connu_lvl0` int DEFAULT NULL,
	`sort_connu_lvl1` int DEFAULT NULL,
	`sort_connu_lvl2` int DEFAULT NULL,
	`sort_connu_lvl3` int DEFAULT NULL,
	`sort_connu_lvl4` int DEFAULT NULL,
	`sort_connu_lvl5` int DEFAULT NULL,
	`sort_connu_lvl6` int DEFAULT NULL,
	`sort_connu_lvl7` int DEFAULT NULL,
	`sort_connu_lvl8` int DEFAULT NULL,
	`sort_connu_lvl9` int DEFAULT NULL,
	`sort_lvl0` int DEFAULT NULL,
	`sort_lvl1` int DEFAULT NULL,
	`sort_lvl2` int DEFAULT NULL,
	`sort_lvl3` int DEFAULT NULL,
	`sort_lvl4` int DEFAULT NULL,
	`sort_lvl5` int DEFAULT NULL,
	`sort_lvl6` int DEFAULT NULL,
	`sort_lvl7` int DEFAULT NULL,
	`sort_lvl8` int DEFAULT NULL,
	`sort_lvl9` int DEFAULT NULL,
	PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=321 DEFAULT CHARSET=utf8mb4;
	
-- }

-- { Structure de la table `modificateurs`

DROP TABLE IF EXISTS `modificateurs`;
CREATE TABLE IF NOT EXISTS `modificateurs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `valeur_caracteristique` int NOT NULL,
  `modificateur` int NOT NULL,
  `bonus_sort0` int DEFAULT NULL,
  `bonus_sort1` int DEFAULT NULL,
  `bonus_sort2` int DEFAULT NULL,
  `bonus_sort3` int DEFAULT NULL,
  `bonus_sort4` int DEFAULT NULL,
  `bonus_sort5` int DEFAULT NULL,
  `bonus_sort6` int DEFAULT NULL,
  `bonus_sort7` int DEFAULT NULL,
  `bonus_sort8` int DEFAULT NULL,
  `bonus_sort9` int DEFAULT NULL,
  `can_cast` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4;

-- }

-- }

