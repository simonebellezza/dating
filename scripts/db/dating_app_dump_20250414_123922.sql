-- Valentina Studio --
-- MySQL dump --
-- ---------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- ---------------------------------------------------------


-- CREATE TABLE "genre_user" -----------------------------------
CREATE TABLE `genre_user`( 
	`genre_id` SmallInt( 0 ) NOT NULL,
	`user_id` BigInt( 0 ) NOT NULL,
	PRIMARY KEY ( `genre_id`, `user_id` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "genres" ---------------------------------------
CREATE TABLE `genres`( 
	`id` SmallInt( 0 ) AUTO_INCREMENT NOT NULL,
	`type` VarChar( 255 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	PRIMARY KEY ( `id` ),
	CONSTRAINT `UKmi1pkdha007yt6mr9h4xvp38q` UNIQUE( `type` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 1;
-- -------------------------------------------------------------


-- CREATE TABLE "interest_user" --------------------------------
CREATE TABLE `interest_user`( 
	`interest_id` BigInt( 0 ) NOT NULL,
	`user_id` BigInt( 0 ) NOT NULL,
	PRIMARY KEY ( `interest_id`, `user_id` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "interests" ------------------------------------
CREATE TABLE `interests`( 
	`id` BigInt( 0 ) AUTO_INCREMENT NOT NULL,
	`name` VarChar( 255 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	PRIMARY KEY ( `id` ),
	CONSTRAINT `UKniknbu0ipih4n1x85t0g6h68` UNIQUE( `name` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 1;
-- -------------------------------------------------------------


-- CREATE TABLE "matches" --------------------------------------
CREATE TABLE `matches`( 
	`id` BigInt( 0 ) AUTO_INCREMENT NOT NULL,
	`timestamp` DateTime NULL DEFAULT NULL,
	`user_id` BigInt( 0 ) NULL DEFAULT NULL,
	`user_target_id` BigInt( 0 ) NULL DEFAULT NULL,
	PRIMARY KEY ( `id` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 1;
-- -------------------------------------------------------------


-- CREATE TABLE "preferences" ----------------------------------
CREATE TABLE `preferences`( 
	`user_id` BigInt( 0 ) NOT NULL,
	`distance` BigInt( 0 ) NOT NULL,
	`max_age` Int( 0 ) NOT NULL,
	`min_age` Int( 0 ) NOT NULL,
	PRIMARY KEY ( `user_id` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "roles" ----------------------------------------
CREATE TABLE `roles`( 
	`user_id` BigInt( 0 ) NOT NULL,
	`type` Enum( 'ADMIN', 'MODERATOR', 'USER' ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	PRIMARY KEY ( `user_id` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "swipes" ---------------------------------------
CREATE TABLE `swipes`( 
	`id` BigInt( 0 ) AUTO_INCREMENT NOT NULL,
	`timestamp` DateTime NULL DEFAULT NULL,
	`type` TinyInt( 0 ) NULL DEFAULT NULL,
	`user_id` BigInt( 0 ) NULL DEFAULT NULL,
	`user_target_id` BigInt( 0 ) NULL DEFAULT NULL,
	PRIMARY KEY ( `id` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 1;
-- -------------------------------------------------------------


-- CREATE TABLE "user_details" ---------------------------------
CREATE TABLE `user_details`( 
	`user_id` BigInt( 0 ) NOT NULL,
	`last_online` DateTime NULL DEFAULT NULL,
	`status` Enum( 'INVISIBLE', 'OFFLINE', 'ONLINE' ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	PRIMARY KEY ( `user_id` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "users" ----------------------------------------
CREATE TABLE `users`( 
	`id` BigInt( 0 ) AUTO_INCREMENT NOT NULL,
	`account_type` Enum( 'PREMIUM', 'STANDARD' ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`bio` VarChar( 255 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
	`birthday` Date NOT NULL,
	`email` VarChar( 255 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`name` VarChar( 255 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`password` VarChar( 255 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`registration_date` Date NULL DEFAULT NULL,
	PRIMARY KEY ( `id` ),
	CONSTRAINT `UK6dotkott2kjsp8vw4d0m25fb7` UNIQUE( `email` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 1;
-- -------------------------------------------------------------


-- Dump data of "genre_user" -------------------------------
BEGIN;

INSERT INTO `genre_user`(`genre_id`,`user_id`) VALUES 
( '1', '1' ),
( '2', '1' ),
( '3', '2' ),
( '4', '3' ),
( '3', '4' ),
( '2', '5' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "genres" -----------------------------------
BEGIN;

INSERT INTO `genres`(`id`,`type`) VALUES 
( '2', 'Female' ),
( '1', 'Male' ),
( '3', 'Non_binary' ),
( '4', 'Queer' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "interest_user" ----------------------------
BEGIN;

INSERT INTO `interest_user`(`interest_id`,`user_id`) VALUES 
( '1', '1' ),
( '3', '1' ),
( '2', '2' ),
( '4', '3' ),
( '5', '4' ),
( '1', '5' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "interests" --------------------------------
BEGIN;

INSERT INTO `interests`(`id`,`name`) VALUES 
( '1', 'Calcio' ),
( '4', 'Cucina' ),
( '2', 'Fotografia' ),
( '5', 'Lettura' ),
( '3', 'Viaggi' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "matches" ----------------------------------
-- ---------------------------------------------------------


-- Dump data of "preferences" ------------------------------
BEGIN;

INSERT INTO `preferences`(`user_id`,`distance`,`max_age`,`min_age`) VALUES 
( '1', '100', '35', '25' ),
( '2', '50', '40', '30' ),
( '3', '150', '30', '20' ),
( '4', '200', '38', '28' ),
( '5', '75', '32', '22' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "roles" ------------------------------------
BEGIN;

INSERT INTO `roles`(`user_id`,`type`) VALUES 
( '1', 'USER' ),
( '2', 'ADMIN' ),
( '3', 'USER' ),
( '4', 'MODERATOR' ),
( '5', 'USER' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "swipes" -----------------------------------
-- ---------------------------------------------------------


-- Dump data of "user_details" -----------------------------
BEGIN;

INSERT INTO `user_details`(`user_id`,`last_online`,`status`) VALUES 
( '1', '2023-10-01 14:30:00.000000', 'ONLINE' ),
( '2', '2023-10-01 10:00:00.000000', 'OFFLINE' ),
( '3', '2023-10-01 16:45:00.000000', 'INVISIBLE' ),
( '4', '2023-10-01 18:20:00.000000', 'ONLINE' ),
( '5', '2023-10-01 12:00:00.000000', 'OFFLINE' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "users" ------------------------------------
BEGIN;

INSERT INTO `users`(`id`,`account_type`,`bio`,`birthday`,`email`,`name`,`password`,`registration_date`) VALUES 
( '1', 'STANDARD', 'Amo viaggiare e leggere.', '1990-05-15', 'mario.rossi@example.com', 'Mario Rossi', 'password123', '2023-01-01' ),
( '2', 'PREMIUM', 'Appassionata di cucina.', '1985-08-20', 'luisa.bianchi@example.com', 'Luisa Bianchi', 'password456', '2023-02-15' ),
( '3', 'STANDARD', 'Amante della musica.', '1992-03-10', 'giulia.verdi@example.com', 'Giulia Verdi', 'password789', '2023-03-10' ),
( '4', 'PREMIUM', 'Sportivo e dinamico.', '1988-07-25', 'alessandro.neri@example.com', 'Alessandro Neri', 'password321', '2023-04-05' ),
( '5', 'STANDARD', 'Appassionata di arte.', '1995-12-01', 'francesca.neri@example.com', 'Francesca Neri', 'password654', '2023-05-20' );
COMMIT;
-- ---------------------------------------------------------


-- CREATE INDEX "FKk8l5cwohx1lt6rjng98yk20ev" ------------------
CREATE INDEX `FKk8l5cwohx1lt6rjng98yk20ev` USING BTREE ON `genre_user`( `user_id` );
-- -------------------------------------------------------------


-- CREATE INDEX "FKbh5splovhabyn6ki4da3bp4g0" ------------------
CREATE INDEX `FKbh5splovhabyn6ki4da3bp4g0` USING BTREE ON `interest_user`( `user_id` );
-- -------------------------------------------------------------


-- CREATE INDEX "FKjn5cea248gae6hjub299oyqlf" ------------------
CREATE INDEX `FKjn5cea248gae6hjub299oyqlf` USING BTREE ON `matches`( `user_id` );
-- -------------------------------------------------------------


-- CREATE INDEX "FKl3w2yilbeva81h97mn4a9fi3j" ------------------
CREATE INDEX `FKl3w2yilbeva81h97mn4a9fi3j` USING BTREE ON `matches`( `user_target_id` );
-- -------------------------------------------------------------


-- CREATE INDEX "FK5qggftkrslfn284iiuov59t8h" ------------------
CREATE INDEX `FK5qggftkrslfn284iiuov59t8h` USING BTREE ON `swipes`( `user_target_id` );
-- -------------------------------------------------------------


-- CREATE INDEX "FKnfck460rxwa0k3631tmqu6x5s" ------------------
CREATE INDEX `FKnfck460rxwa0k3631tmqu6x5s` USING BTREE ON `swipes`( `user_id` );
-- -------------------------------------------------------------


-- CREATE LINK "FK5qggftkrslfn284iiuov59t8h" -------------------
ALTER TABLE `swipes`
	ADD CONSTRAINT `FK5qggftkrslfn284iiuov59t8h` FOREIGN KEY ( `user_target_id` )
	REFERENCES `users`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FK97mxvrajhkq19dmvboprimeg1" -------------------
ALTER TABLE `roles`
	ADD CONSTRAINT `FK97mxvrajhkq19dmvboprimeg1` FOREIGN KEY ( `user_id` )
	REFERENCES `users`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FKbh5splovhabyn6ki4da3bp4g0" -------------------
ALTER TABLE `interest_user`
	ADD CONSTRAINT `FKbh5splovhabyn6ki4da3bp4g0` FOREIGN KEY ( `user_id` )
	REFERENCES `users`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FKhsnau9m3d95s0m7eyiu75bp75" -------------------
ALTER TABLE `interest_user`
	ADD CONSTRAINT `FKhsnau9m3d95s0m7eyiu75bp75` FOREIGN KEY ( `interest_id` )
	REFERENCES `interests`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FKicouhgavvmiiohc28mgk0kuj5" -------------------
ALTER TABLE `user_details`
	ADD CONSTRAINT `FKicouhgavvmiiohc28mgk0kuj5` FOREIGN KEY ( `user_id` )
	REFERENCES `users`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FKjn5cea248gae6hjub299oyqlf" -------------------
ALTER TABLE `matches`
	ADD CONSTRAINT `FKjn5cea248gae6hjub299oyqlf` FOREIGN KEY ( `user_id` )
	REFERENCES `users`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FKk8l5cwohx1lt6rjng98yk20ev" -------------------
ALTER TABLE `genre_user`
	ADD CONSTRAINT `FKk8l5cwohx1lt6rjng98yk20ev` FOREIGN KEY ( `user_id` )
	REFERENCES `users`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FKl3w2yilbeva81h97mn4a9fi3j" -------------------
ALTER TABLE `matches`
	ADD CONSTRAINT `FKl3w2yilbeva81h97mn4a9fi3j` FOREIGN KEY ( `user_target_id` )
	REFERENCES `users`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FKld9bnccp3q21o9b2io2oomlvf" -------------------
ALTER TABLE `genre_user`
	ADD CONSTRAINT `FKld9bnccp3q21o9b2io2oomlvf` FOREIGN KEY ( `genre_id` )
	REFERENCES `genres`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FKme1hmam0h8w07410h7qkjna5m" -------------------
ALTER TABLE `preferences`
	ADD CONSTRAINT `FKme1hmam0h8w07410h7qkjna5m` FOREIGN KEY ( `user_id` )
	REFERENCES `users`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FKnfck460rxwa0k3631tmqu6x5s" -------------------
ALTER TABLE `swipes`
	ADD CONSTRAINT `FKnfck460rxwa0k3631tmqu6x5s` FOREIGN KEY ( `user_id` )
	REFERENCES `users`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- ---------------------------------------------------------


