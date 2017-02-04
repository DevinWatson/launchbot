CREATE DATABASE IF NOT EXISTS launches;

USE launches;

CREATE TABLE IF NOT EXISTS `launches`.`launch` (
  `id` int NOT NULL,
  `name` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `isostart` DATETIME COLLATE utf8_bin DEFAULT NULL,
  `isoend` DATETIME COLLATE utf8_bin DEFAULT NULL,
  `isonet` DATETIME COLLATE utf8_bin DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  `tbddate` tinyint DEFAULT NULL,
  `probability` tinyint DEFAULT NULL,
  `inhold` tinyint DEFAULT NULL,
  `vidURLs` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `infoURLs` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `holdreason` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `failreason` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `hashtag` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS `launches`.`location` (
  `id` int NOT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `infoURL` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `wikiURL` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `countryCode` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `launchId` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY(launchId) REFERENCES launch(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS `launches`.`pad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `infoURL` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `wikiURL` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `mapURL` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `latitude` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `longitude` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `agencies` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `locationId` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY(locationId) REFERENCES location(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS `launches`.`rocket` (
  `id` int NOT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `configuration` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `familyname` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `agencies` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `infoURL` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `wikiURL` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `imageURL` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `imageSizes` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `launchId` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY(launchId) REFERENCES launch(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS `launches`.`missions` (
  `id` int NOT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `type` int COLLATE utf8_bin DEFAULT NULL,
  `typeName` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `launchId` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY(launchId) REFERENCES launch(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;