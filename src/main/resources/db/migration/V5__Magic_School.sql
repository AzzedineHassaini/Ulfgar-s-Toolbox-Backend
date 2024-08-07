--
-- Structure de la table `sortecoles`
--

DROP TABLE IF EXISTS `sortecoles`;
CREATE TABLE IF NOT EXISTS `sortecoles` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `ecole` varchar(255) NOT NULL,
    `titre` varchar(255) NOT NULL,
    `peut_etre_interdite` tinyint(1) NOT NULL DEFAULT '1',
    `nb_ecole_intedite` int(11) NOT NULL DEFAULT '2',
    `image` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sortecoles`
--

INSERT INTO `sortecoles` (`id`, `ecole`, `titre`, `peut_etre_interdite`, `nb_ecole_intedite`,`image`) VALUES
 (1, 'Abjuration', 'Abjurateur', 1, 2, 'abjuration.png'),
 (2, 'Divination', 'Devin', 0, 1, 'divination.png'),
 (3, 'Transmutation', 'Transmutateur', 1, 2, 'transmutation.png'),
 (4, 'Nécromancie', 'Nécromancien', 1, 2, 'necromancy.png'),
 (5, 'Invocation', 'Invocateur', 1, 2, 'conjuration.png'),
 (6, 'Illusion', 'Illusionniste', 1, 2, 'illusion.png'),
 (7, 'Evocation', 'Evocateur', 1, 2, 'evocation.png'),
 (8, 'Enchantement', 'Enchanteur', 1, 2, 'enchantment.png');

-- --------------------------------------------------------