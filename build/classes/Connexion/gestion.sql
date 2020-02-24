-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- GÃ©nÃ©rÃ© le :  Mar 11 FÃ©vrier 2020 Ã  13:45
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de donnÃ©es :  `gestion`
--

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

CREATE TABLE IF NOT EXISTS `achat` (
  `id_achat` int(11) NOT NULL AUTO_INCREMENT,
  `id_product` int(11) NOT NULL,
  `client_name` varchar(255) NOT NULL,
  `client_type` varchar(255) NOT NULL,
  `client_address` varchar(255) NOT NULL,
  `quantite` int(11) NOT NULL,
  `etat` int(11) NOT NULL,
  PRIMARY KEY (`id_achat`),
  KEY `fk_achat` (`id_product`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `delivery`
--

CREATE TABLE IF NOT EXISTS `delivery` (
  `id_delivery` int(11) NOT NULL AUTO_INCREMENT,
  `reference` varchar(255) NOT NULL,
  `client_name` varchar(255) NOT NULL,
  `driver_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `statut` varchar(255) NOT NULL,
  `vehicule` int(11) NOT NULL,
  PRIMARY KEY (`id_delivery`),
  KEY `vehicule` (`vehicule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `entrepot`
--

CREATE TABLE IF NOT EXISTS `entrepot` (
  `id_entrepot` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `nbrRangs` int(11) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `phone_bis` varchar(255) NOT NULL,
  `id_stocks` int(11) NOT NULL,
  PRIMARY KEY (`id_entrepot`),
  KEY `fk_entrepot` (`id_stocks`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `id_facture` int(11) NOT NULL AUTO_INCREMENT,
  `reference` varchar(255) NOT NULL,
  `id_achat` int(11) NOT NULL,
  `client_name` varchar(255) NOT NULL,
  `client_type` varchar(255) NOT NULL,
  `type_facture` varchar(255) NOT NULL,
  `statut_facture` varchar(255) NOT NULL,
  `totalHT` float NOT NULL,
  `totalTTC` float NOT NULL,
  `echeance` varchar(255) NOT NULL,
  `delivery` int(11) NOT NULL,
  PRIMARY KEY (`id_facture`),
  UNIQUE KEY `delivery` (`delivery`),
  KEY `fk_facture` (`id_achat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `facture_transport`
--

CREATE TABLE IF NOT EXISTS `facture_transport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_reference` varchar(255) NOT NULL,
  `facture_reference` varchar(255) NOT NULL,
  `etat` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id_fournisseur` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `phoneNumber` int(8) NOT NULL,
  `type_product` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id_fournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE IF NOT EXISTS `paiement` (
  `id_paiement` int(11) NOT NULL AUTO_INCREMENT,
  `reference` varchar(255) NOT NULL,
  `client_name` varchar(255) NOT NULL,
  `paiement_type` varchar(255) NOT NULL,
  `rib` varchar(255) NOT NULL,
  `num_cheque` varchar(255) NOT NULL,
  PRIMARY KEY (`id_paiement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `product_type` varchar(255) NOT NULL,
  `reference` varchar(255) NOT NULL,
  `marque` varchar(255) NOT NULL,
  `priceHT` float NOT NULL,
  `priceTTC` float NOT NULL,
  `TVA` float NOT NULL,
  `weight` float NOT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `recalamtion`
--

CREATE TABLE IF NOT EXISTS `recalamtion` (
  `id_reclamation` int(11) NOT NULL AUTO_INCREMENT,
  `id_product` int(11) DEFAULT NULL,
  `id_facture` int(11) DEFAULT NULL,
  `contenu` varchar(500) NOT NULL,
  `Date_rec` date NOT NULL,
  `etat` int(11) NOT NULL,
  PRIMARY KEY (`id_reclamation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `id_staff` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `pathImg` varchar(255) NOT NULL,
  `salary` float NOT NULL,
  `rib` varchar(255) NOT NULL,
  `post` int(11) NOT NULL,
  `prime` float NOT NULL,
  `statut` varchar(255) NOT NULL,
  PRIMARY KEY (`id_staff`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `stocks`
--

CREATE TABLE IF NOT EXISTS `stocks` (
  `id_stocks` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` float NOT NULL,
  `id_product` int(11) NOT NULL,
  `unity` varchar(255) NOT NULL,
  PRIMARY KEY (`id_stocks`),
  KEY `fk_stocks` (`id_product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `IDU` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName_U` varchar(30) NOT NULL,
  `LastName_U` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `UserType` varchar(30) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Photo` varchar(100) NOT NULL,
  `Phone_Number` int(8) NOT NULL,
  PRIMARY KEY (`IDU`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `Phone_Number` (`Phone_Number`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE IF NOT EXISTS `vehicule` (
  `id_vehicule` int(11) NOT NULL AUTO_INCREMENT,
  `matricule` varchar(255) NOT NULL,
  `weight` float NOT NULL,
  `etat` varchar(255) NOT NULL,
  `marque` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id_vehicule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportÃ©es
--

--
-- Contraintes pour la table `achat`
--
ALTER TABLE `achat`
  ADD CONSTRAINT `fk_achat` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`);

--
-- Contraintes pour la table `entrepot`
--
ALTER TABLE `entrepot`
  ADD CONSTRAINT `fk_entrepot` FOREIGN KEY (`id_stocks`) REFERENCES `stocks` (`id_stocks`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `fk_facture` FOREIGN KEY (`id_achat`) REFERENCES `achat` (`id_achat`);

--
-- Contraintes pour la table `stocks`
--
ALTER TABLE `stocks`
  ADD CONSTRAINT `fk_stocks` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
