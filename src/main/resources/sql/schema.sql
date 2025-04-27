DROP SCHEMA IF EXISTS `xet-da-furia-db`;

-- -----------------------------------------------------
-- Schema xet-da-furia-db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `xet-da-furia-db`;
USE `xet-da-furia-db`;

-- -----------------------------------------------------
-- Table `xet-da-furia-db`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `xet-da-furia-db`.`usuarios` (
  `id` VARCHAR(36) NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) UNIQUE NOT NULL,
  `senha` VARCHAR(100) NOT NULL,
  `criado_em` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;