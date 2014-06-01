INSERT INTO `personne` (`id`, `dateCreated`, `lastModified`, `version`, `nom`, `prenom`, `utilisateur_id`) VALUES (1, NOW(), NOW(), 0, 'admin', 'admin', NULL), (2, NOW(), NOW(), 0, 'user', 'user', NULL);
INSERT INTO `utilisateur` (`id`, `dateCreated`, `lastModified`, `version`, `admin`, `password`, `username`, `personne_id`) VALUES (1, NOW(), NOW(), 0, b'1', 'admin', 'admin', 1), (2, NOW(), NOW(), 0, b'0', 'user', 'user', 2);

