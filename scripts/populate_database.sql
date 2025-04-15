-- Popolamento tabella users
INSERT INTO users (id, name, email, password, birthday, bio, account_type, registration_date)
VALUES (1, 'Mario Rossi', 'mario.rossi@example.com', 'password123', '1990-05-15', 'Amo viaggiare e leggere.',
        'STANDARD', '2023-01-01'),
       (2, 'Luisa Bianchi', 'luisa.bianchi@example.com', 'password456', '1985-08-20', 'Appassionata di cucina.',
        'PREMIUM', '2023-02-15'),
       (3, 'Giulia Verdi', 'giulia.verdi@example.com', 'password789', '1992-03-10', 'Amante della musica.', 'STANDARD',
        '2023-03-10'),
       (4, 'Alessandro Neri', 'alessandro.neri@example.com', 'password321', '1988-07-25', 'Sportivo e dinamico.',
        'PREMIUM', '2023-04-05'),
       (5, 'Francesca Blu', 'francesca.blu@example.com', 'password654', '1995-12-01', 'Appassionata di arte.',
        'STANDARD', '2023-05-20');

-- Popolamento tabella user_details
INSERT INTO user_details (user_id, last_online, status)
VALUES (1, '2023-10-01 14:30:00', 'ONLINE'),
       (2, '2023-10-01 10:00:00', 'OFFLINE'),
       (3, '2023-10-01 16:45:00', 'INVISIBLE'),
       (4, '2023-10-01 18:20:00', 'ONLINE'),
       (5, '2023-10-01 12:00:00', 'OFFLINE');

-- Popolamento tabella roles
INSERT INTO roles (user_id, type)
VALUES (1, 'USER'),
       (2, 'ADMIN'),
       (3, 'USER'),
       (4, 'MODERATOR'),
       (5, 'USER');

-- Popolamento tabella preferences
INSERT INTO preferences (user_id, min_age, max_age, distance)
VALUES (1, 25, 35, 100),
       (2, 30, 40, 50),
       (3, 20, 30, 150),
       (4, 28, 38, 200),
       (5, 22, 32, 75);

-- Popolamento tabella genres
INSERT INTO genres (id, type)
VALUES (1, 'Male'),
       (2, 'Female'),
       (3, 'Non_binary'),
       (4, 'Queer');

-- Popolamento tabella genre_user
INSERT INTO genre_user (user_id, genre_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 4),
       (4, 3),
       (5, 2);

-- Popolamento tabella interests
INSERT INTO interests (id, name)
VALUES (1, 'Calcio'),
       (2, 'Fotografia'),
       (3, 'Viaggi'),
       (4, 'Cucina'),
       (5, 'Lettura');

-- Popolamento tabella interest_user
INSERT INTO interest_user (user_id, interest_id)
VALUES (1, 1),
       (1, 3),
       (2, 2),
       (3, 4),
       (4, 5),
       (5, 1);