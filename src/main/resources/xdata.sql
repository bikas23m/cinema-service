INSERT INTO Movie (movie_id, title, genre, duration, release_date, rating, created_at, updated_at) VALUES
(1,'Inception', 'Science Fiction', 148, '2010-07-16', 8.8, NOW(), NOW()),
(2,'The Shawshank Redemption', 'Drama', 142, '1994-09-22', 9.3, NOW(), NOW()),
(3,'The Dark Knight', 'Action', 152, '2008-07-18', 9.0, NOW(), NOW()),
(4,'Pulp Fiction', 'Crime', 154, '1994-10-14', 8.9, NOW(), NOW()),
(5,'The Matrix', 'Action', 136, '1999-03-31', 8.7, NOW(), NOW());

INSERT INTO Theatre (theatre_id, name, location,  created_at, updated_at) VALUES
(1,'Grand Cinemas', 'Downtown', NOW(), NOW()),
(2,'Cineworld', 'Uptown', NOW(), NOW()),
(3,'Film House', 'Midtown', NOW(), NOW()),
(4,'Luxury Theatres', 'Suburbs', NOW(), NOW()),
(5,'Classic Cinema', 'City Center', NOW(), NOW());

INSERT INTO Schedule (movie_id, theatre_id, show_time, available_seats, created_at, updated_at) VALUES
(1, 1, '2024-07-26 19:00:00', 50, NOW(), NOW()),
(1, 2, '2024-07-26 21:30:00', 45, NOW(), NOW()),
(2, 3, '2024-07-26 18:00:00', 60, NOW(), NOW()),
(3, 4, '2024-07-26 20:00:00', 55, NOW(), NOW()),
(4, 5, '2024-07-26 22:00:00', 40, NOW(), NOW()),
(5, 1, '2024-07-26 16:00:00', 50, NOW(), NOW());
