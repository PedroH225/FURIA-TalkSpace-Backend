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

CREATE TABLE `xet-da-furia-db`.`chats` (
    `id` VARCHAR(36) PRIMARY KEY,
    `nome` VARCHAR(100) NOT NULL,
    `descricao` TEXT NOT NULL,
    `jogo` VARCHAR(100) NOT NULL,
    `tema` VARCHAR(100) NOT NULL,
    `criado_em` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `usuario_id` VARCHAR(36) NOT NULL,
    FOREIGN KEY(`usuario_id`) REFERENCES `xet-da-furia-db`.`usuarios`(`id`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `xet-da-furia-db`.`usuario_chat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `xet-da-furia-db`.`usuario_chat` (
  `usuario_id` VARCHAR(36) NOT NULL,
  `chat_id` VARCHAR(36) NOT NULL,
  FOREIGN KEY (`usuario_id`) REFERENCES `xet-da-furia-db`.`usuarios`(`id`) ON DELETE CASCADE,
  FOREIGN KEY (`chat_id`) REFERENCES `xet-da-furia-db`.`chats`(`id`) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE `xet-da-furia-db`.`mensagens` (
    `id` VARCHAR(36) PRIMARY KEY,
    `conteudo` TEXT NOT NULL,
	`data_envio` TIMESTAMP NOT NULL,
	`chat_id` VARCHAR(36) NOT NULL,
    `usuario_id` VARCHAR(36) NOT NULL,
    FOREIGN KEY (`chat_id`) REFERENCES `xet-da-furia-db`.`chats`(id) ON DELETE CASCADE,
    FOREIGN KEY (`usuario_id`) REFERENCES `xet-da-furia-db`.`usuarios`(id) ON DELETE CASCADE
) ENGINE = InnoDB;


