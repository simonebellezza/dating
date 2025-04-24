-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 24, 2025 at 04:50 PM
-- Server version: 9.0.1
-- PHP Version: 8.3.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dating_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `genres`
--

CREATE TABLE `genres` (
  `id` smallint NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `genres`
--

INSERT INTO `genres` (`id`, `type`) VALUES
(2, 'Female'),
(1, 'Male'),
(3, 'Non_binary'),
(4, 'Queer');

-- --------------------------------------------------------

--
-- Table structure for table `genre_preference`
--

CREATE TABLE `genre_preference` (
  `genre_id` smallint NOT NULL,
  `preference_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `genre_preference`
--

INSERT INTO `genre_preference` (`genre_id`, `preference_id`) VALUES
(1, 6),
(3, 6),
(4, 6),
(3, 7),
(1, 8),
(2, 8),
(3, 8);

-- --------------------------------------------------------

--
-- Table structure for table `genre_user`
--

CREATE TABLE `genre_user` (
  `genre_id` smallint NOT NULL,
  `user_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `genre_user`
--

INSERT INTO `genre_user` (`genre_id`, `user_id`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(3, 4),
(2, 5),
(1, 6),
(3, 6),
(4, 6),
(1, 7),
(1, 8);

-- --------------------------------------------------------

--
-- Table structure for table `interests`
--

CREATE TABLE `interests` (
  `id` bigint NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `interests`
--

INSERT INTO `interests` (`id`, `name`) VALUES
(1, 'Calcio'),
(4, 'Cucina'),
(2, 'Fotografia'),
(5, 'Lettura'),
(3, 'Viaggi');

-- --------------------------------------------------------

--
-- Table structure for table `interest_user`
--

CREATE TABLE `interest_user` (
  `interest_id` bigint NOT NULL,
  `user_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `interest_user`
--

INSERT INTO `interest_user` (`interest_id`, `user_id`) VALUES
(1, 1),
(3, 1),
(2, 2),
(4, 3),
(5, 4),
(1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `matches`
--

CREATE TABLE `matches` (
  `id` bigint NOT NULL,
  `timestamp` datetime(6) NOT NULL,
  `user_id` bigint NOT NULL,
  `user_target_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `matches`
--

INSERT INTO `matches` (`id`, `timestamp`, `user_id`, `user_target_id`) VALUES
(1, '2025-04-23 09:38:47.962257', 6, 7),
(2, '2025-04-24 14:21:32.117689', 6, 8);

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `id` bigint NOT NULL,
  `receiver_id` bigint NOT NULL,
  `sender_id` bigint NOT NULL,
  `sent_at` datetime(6) NOT NULL,
  `content` varchar(500) COLLATE utf8mb4_general_ci NOT NULL,
  `message_type` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `status` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`id`, `receiver_id`, `sender_id`, `sent_at`, `content`, `message_type`, `status`) VALUES
(1, 7, 8, '2025-04-24 14:23:52.093617', 'Saluti da utente con id 8', 'text', 'sent');

-- --------------------------------------------------------

--
-- Table structure for table `preferences`
--

CREATE TABLE `preferences` (
  `max_age` int NOT NULL,
  `min_age` int NOT NULL,
  `distance` bigint NOT NULL,
  `user_id` bigint NOT NULL
) ;

--
-- Dumping data for table `preferences`
--

INSERT INTO `preferences` (`max_age`, `min_age`, `distance`, `user_id`) VALUES
(35, 25, 100, 1),
(40, 30, 50, 2),
(30, 20, 150, 3),
(38, 28, 200, 4),
(32, 22, 75, 5),
(22, 18, 100, 6),
(29, 18, 69, 7),
(29, 18, 69, 8);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `user_id` bigint NOT NULL,
  `type` enum('ADMIN','MODERATOR','USER') COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`user_id`, `type`) VALUES
(1, 'USER'),
(2, 'ADMIN'),
(3, 'USER'),
(4, 'MODERATOR'),
(5, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `swipes`
--

CREATE TABLE `swipes` (
  `id` bigint NOT NULL,
  `timestamp` datetime(6) NOT NULL,
  `user_id` bigint NOT NULL,
  `user_target_id` bigint NOT NULL,
  `type` enum('LIKE','PASS','SUPER_LIKE') COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `swipes`
--

INSERT INTO `swipes` (`id`, `timestamp`, `user_id`, `user_target_id`, `type`) VALUES
(1, '2025-04-23 09:35:13.823760', 5, 6, 'LIKE'),
(2, '2025-04-23 09:36:31.504522', 6, 7, 'LIKE'),
(3, '2025-04-23 09:38:47.921953', 7, 6, 'LIKE'),
(4, '2025-04-24 14:21:08.996067', 8, 6, 'LIKE'),
(5, '2025-04-24 14:21:32.078290', 6, 8, 'LIKE');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `birthday` date NOT NULL,
  `registration_date` date DEFAULT NULL,
  `id` bigint NOT NULL,
  `bio` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fcm_token` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `account_type` enum('PREMIUM','STANDARD') COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`birthday`, `registration_date`, `id`, `bio`, `fcm_token`, `email`, `name`, `password`, `account_type`) VALUES
('1990-05-15', '2023-01-01', 1, 'Amo viaggiare e leggere.', NULL, 'mario.rossi@example.com', 'Mario Rossi', 'password123', 'STANDARD'),
('1985-08-20', '2023-02-15', 2, 'Appassionata di cucina.', NULL, 'luisa.bianchi@example.com', 'Luisa Bianchi', 'password456', 'PREMIUM'),
('1992-03-10', '2023-03-10', 3, 'Amante della musica.', NULL, 'giulia.verdi@example.com', 'Giulia Verdi', 'password789', 'STANDARD'),
('1988-07-25', '2023-04-05', 4, 'Sportivo e dinamico.', NULL, 'alessandro.neri@example.com', 'Alessandro Neri', 'password321', 'PREMIUM'),
('1995-12-01', '2023-05-20', 5, 'Appassionata di arte.', NULL, 'francesca.blu@example.com', 'Francesca Blu', 'password654', 'STANDARD'),
('1995-12-01', '2025-04-23', 6, 'My bio 1', 'test_fmc_token_1', 'test@sender.com', 'Test sender', '$2a$10$d7Ijtx1Sh/nVF0qb9i1hN.Llr/zO2u3wMXq9aoLfyqu9mhU.1APrS', 'STANDARD'),
('1975-04-15', '2025-04-23', 7, 'My bio 2', 'device_2', 'receive@test.it', 'Receiver', '$2a$10$VA/DTyk1tPsI0U6IgV1EjeH.6A9aMXDB2LbQbF8iZPntNR89M..kS', 'STANDARD'),
('1975-04-15', '2025-04-24', 8, 'My bio 3', 'dispositivo_id_8', 'receive@test2.it', 'Tester2', '$2a$10$kJF.iPQAIMyssAkTkDOMHeyBFToRd/G.5QuYMrJmCk1gBNHH.RQsO', 'STANDARD');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `last_online` datetime(6) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  `status` enum('INVISIBLE','OFFLINE','ONLINE') COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`last_online`, `user_id`, `status`) VALUES
('2023-10-01 14:30:00.000000', 1, 'ONLINE'),
('2023-10-01 10:00:00.000000', 2, 'OFFLINE'),
('2023-10-01 16:45:00.000000', 3, 'INVISIBLE'),
('2023-10-01 18:20:00.000000', 4, 'ONLINE'),
('2023-10-01 12:00:00.000000', 5, 'OFFLINE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `genres`
--
ALTER TABLE `genres`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKmi1pkdha007yt6mr9h4xvp38q` (`type`);

--
-- Indexes for table `genre_preference`
--
ALTER TABLE `genre_preference`
  ADD PRIMARY KEY (`genre_id`,`preference_id`),
  ADD KEY `FKnl42wy3361o6u03ejoanbtgio` (`preference_id`);

--
-- Indexes for table `genre_user`
--
ALTER TABLE `genre_user`
  ADD PRIMARY KEY (`genre_id`,`user_id`),
  ADD KEY `FKk8l5cwohx1lt6rjng98yk20ev` (`user_id`);

--
-- Indexes for table `interests`
--
ALTER TABLE `interests`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKniknbu0ipih4n1x85t0g6h68` (`name`);

--
-- Indexes for table `interest_user`
--
ALTER TABLE `interest_user`
  ADD PRIMARY KEY (`interest_id`,`user_id`),
  ADD KEY `FKbh5splovhabyn6ki4da3bp4g0` (`user_id`);

--
-- Indexes for table `matches`
--
ALTER TABLE `matches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKfae2s97pmwnfqs958y2koxxf4` (`user_id`,`user_target_id`),
  ADD KEY `FKl3w2yilbeva81h97mn4a9fi3j` (`user_target_id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt05r0b6n0iis8u7dfna4xdh73` (`receiver_id`),
  ADD KEY `FK4ui4nnwntodh6wjvck53dbk9m` (`sender_id`);

--
-- Indexes for table `preferences`
--
ALTER TABLE `preferences`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `swipes`
--
ALTER TABLE `swipes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnfck460rxwa0k3631tmqu6x5s` (`user_id`),
  ADD KEY `FK5qggftkrslfn284iiuov59t8h` (`user_target_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `genres`
--
ALTER TABLE `genres`
  MODIFY `id` smallint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `interests`
--
ALTER TABLE `interests`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `matches`
--
ALTER TABLE `matches`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `swipes`
--
ALTER TABLE `swipes`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `genre_preference`
--
ALTER TABLE `genre_preference`
  ADD CONSTRAINT `FKnl42wy3361o6u03ejoanbtgio` FOREIGN KEY (`preference_id`) REFERENCES `preferences` (`user_id`),
  ADD CONSTRAINT `FKp2v19rrmo6sdco2043ymq1gkg` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`);

--
-- Constraints for table `genre_user`
--
ALTER TABLE `genre_user`
  ADD CONSTRAINT `FKk8l5cwohx1lt6rjng98yk20ev` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKld9bnccp3q21o9b2io2oomlvf` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`);

--
-- Constraints for table `interest_user`
--
ALTER TABLE `interest_user`
  ADD CONSTRAINT `FKbh5splovhabyn6ki4da3bp4g0` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKhsnau9m3d95s0m7eyiu75bp75` FOREIGN KEY (`interest_id`) REFERENCES `interests` (`id`);

--
-- Constraints for table `matches`
--
ALTER TABLE `matches`
  ADD CONSTRAINT `FKjn5cea248gae6hjub299oyqlf` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKl3w2yilbeva81h97mn4a9fi3j` FOREIGN KEY (`user_target_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `FK4ui4nnwntodh6wjvck53dbk9m` FOREIGN KEY (`sender_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKt05r0b6n0iis8u7dfna4xdh73` FOREIGN KEY (`receiver_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `preferences`
--
ALTER TABLE `preferences`
  ADD CONSTRAINT `FKme1hmam0h8w07410h7qkjna5m` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `roles`
--
ALTER TABLE `roles`
  ADD CONSTRAINT `FK97mxvrajhkq19dmvboprimeg1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `swipes`
--
ALTER TABLE `swipes`
  ADD CONSTRAINT `FK5qggftkrslfn284iiuov59t8h` FOREIGN KEY (`user_target_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKnfck460rxwa0k3631tmqu6x5s` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `user_details`
--
ALTER TABLE `user_details`
  ADD CONSTRAINT `FKicouhgavvmiiohc28mgk0kuj5` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
