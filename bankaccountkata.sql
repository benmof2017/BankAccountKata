-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 18 juil. 2017 à 17:55
-- Version du serveur :  10.1.25-MariaDB
-- Version de PHP :  7.1.7

CREATE DATABASE  IF NOT EXISTS `bankaccountkata` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bankaccountkata`;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bankaccountkata`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `code` bigint(20) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`code`, `email`, `nom`, `password`) VALUES
(1, 'jmoulin@email.com', 'Jean Moulin ', 'mdp');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE `compte` (
  `code_compte` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `decouvert` double NOT NULL,
  `solde` double NOT NULL,
  `code_cli` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`code_compte`, `date_creation`, `decouvert`, `solde`, `code_cli`) VALUES
('1500393289670', '2017-07-18 17:54:49', 200, 2500, 1);

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `type_op` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `numero` bigint(20) NOT NULL,
  `date_operation` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `code_cpte` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`type_op`, `numero`, `date_operation`, `montant`, `code_cpte`) VALUES
('V', 1, '2017-07-18 17:54:49', 2000, '1500393289670'),
('R', 2, '2017-07-18 17:54:49', 500, '1500393289670');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`code_compte`),
  ADD KEY `FK2hw4shqsxc782lychpkr52lmv` (`code_cli`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `FKkr9nfjf0ipqrw5xwcf9jqq6gv` (`code_cpte`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `code` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `numero` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `FK2hw4shqsxc782lychpkr52lmv` FOREIGN KEY (`code_cli`) REFERENCES `client` (`code`);

--
-- Contraintes pour la table `operation`
--
ALTER TABLE `operation`
  ADD CONSTRAINT `FKkr9nfjf0ipqrw5xwcf9jqq6gv` FOREIGN KEY (`code_cpte`) REFERENCES `compte` (`code_compte`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
