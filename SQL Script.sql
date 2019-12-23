-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema crud
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `crud` ;

-- -----------------------------------------------------
-- Schema crud
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `crud` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `crud` ;

-- -----------------------------------------------------
-- Table `crud`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `crud`.`customer` ;

CREATE TABLE IF NOT EXISTS `crud`.`customer` (
  `cust_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cust_name` VARCHAR(45) NULL DEFAULT NULL,
  `cust_address` VARCHAR(45) NULL DEFAULT NULL,
  `cust_phone` VARCHAR(45) NULL DEFAULT NULL,
  `cust_email` VARCHAR(45) NULL DEFAULT NULL,
  `cust_gender` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`cust_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `crud`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `crud`.`employee` ;

CREATE TABLE IF NOT EXISTS `crud`.`employee` (
  `emp_id` INT(11) NOT NULL AUTO_INCREMENT,
  `emp_name` VARCHAR(45) NULL DEFAULT NULL,
  `emp_role` VARCHAR(45) NULL DEFAULT NULL,
  `emp_email` VARCHAR(45) NULL DEFAULT NULL,
  `emp_salary` INT(11) NULL DEFAULT NULL,
  `emp_phone` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `crud`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `crud`.`order` ;

CREATE TABLE IF NOT EXISTS `crud`.`order` (
  `o_id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` DATE NULL DEFAULT NULL,
  `total` FLOAT NULL DEFAULT NULL,
  `customer_cust_id` INT(11) NOT NULL,
  `employee_emp_id` INT(11) NOT NULL,
  PRIMARY KEY (`o_id`),
  INDEX `fk_order_customer_idx` (`customer_cust_id` ASC) VISIBLE,
  INDEX `fk_order_employee1_idx` (`employee_emp_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_customer`
    FOREIGN KEY (`customer_cust_id`)
    REFERENCES `crud`.`customer` (`cust_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_employee1`
    FOREIGN KEY (`employee_emp_id`)
    REFERENCES `crud`.`employee` (`emp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `crud`.`vehicle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `crud`.`vehicle` ;

CREATE TABLE IF NOT EXISTS `crud`.`vehicle` (
  `v_id` INT(11) NOT NULL AUTO_INCREMENT,
  `v_manufacturer` VARCHAR(45) NULL DEFAULT NULL,
  `v_model` VARCHAR(45) NULL DEFAULT NULL,
  `v_year` INT(11) NULL DEFAULT NULL,
  `v_category` VARCHAR(45) NULL DEFAULT NULL,
  `v_transmission` VARCHAR(45) NULL DEFAULT NULL,
  `v_milleage` INT(11) NULL DEFAULT NULL,
  `v_plate` VARCHAR(45) NULL DEFAULT NULL,
  `v_color` VARCHAR(45) NULL DEFAULT NULL,
  `v_price` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`v_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `crud`.`order_has_vehicle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `crud`.`order_has_vehicle` ;

CREATE TABLE IF NOT EXISTS `crud`.`order_has_vehicle` (
  `order_o_id` INT(11) NOT NULL,
  `vehicle_v_id` INT(11) NOT NULL,
  PRIMARY KEY (`order_o_id`, `vehicle_v_id`),
  INDEX `fk_order_has_vehicle_vehicle1_idx` (`vehicle_v_id` ASC) VISIBLE,
  INDEX `fk_order_has_vehicle_order1_idx` (`order_o_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_has_vehicle_order1`
    FOREIGN KEY (`order_o_id`)
    REFERENCES `crud`.`order` (`o_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_has_vehicle_vehicle1`
    FOREIGN KEY (`vehicle_v_id`)
    REFERENCES `crud`.`vehicle` (`v_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
