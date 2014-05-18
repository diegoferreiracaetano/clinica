SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `clinica` ;
CREATE SCHEMA IF NOT EXISTS `clinica` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `clinica` ;

-- -----------------------------------------------------
-- Table `clinica`.`paciente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica`.`paciente` ;

CREATE  TABLE IF NOT EXISTS `clinica`.`paciente` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NULL ,
  `sobrenome` VARCHAR(45) NULL ,
  `telefone` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica`.`medico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica`.`medico` ;

CREATE  TABLE IF NOT EXISTS `clinica`.`medico` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `crm` VARCHAR(45) NULL ,
  `nome` VARCHAR(45) NULL ,
  `sobrenome` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica`.`atendimento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica`.`atendimento` ;

CREATE  TABLE IF NOT EXISTS `clinica`.`atendimento` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `paciente_id` INT NOT NULL ,
  `medico_id` INT NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  `data` DATETIME NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_atendimento_paciente1_idx` (`paciente_id` ASC) ,
  INDEX `fk_atendimento_medico1_idx` (`medico_id` ASC) ,
  CONSTRAINT `fk_atendimento_paciente1`
    FOREIGN KEY (`paciente_id` )
    REFERENCES `clinica`.`paciente` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_atendimento_medico1`
    FOREIGN KEY (`medico_id` )
    REFERENCES `clinica`.`medico` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica`.`procedimento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica`.`procedimento` ;

CREATE  TABLE IF NOT EXISTS `clinica`.`procedimento` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `atendimento_id` INT NOT NULL ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_procedimento_atendimento1_idx` (`atendimento_id` ASC) ,
  CONSTRAINT `fk_procedimento_atendimento1`
    FOREIGN KEY (`atendimento_id` )
    REFERENCES `clinica`.`atendimento` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica`.`material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica`.`material` ;

CREATE  TABLE IF NOT EXISTS `clinica`.`material` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `tipo` INT NULL ,
  `descricao` VARCHAR(45) NULL ,
  `valor` DOUBLE(10,2) NULL ,
  `procedimento_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_material_procedimento1_idx` (`procedimento_id` ASC) ,
  CONSTRAINT `fk_material_procedimento1`
    FOREIGN KEY (`procedimento_id` )
    REFERENCES `clinica`.`procedimento` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `clinica` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
