USE Hierarchical;

CREATE TABLE categories(
	category_id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
	name varchar(255) NULL,
	parent_category_id int NULL);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (1, 'Politics', 21);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (2, 'Alien life', 22);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (3, 'Exploration', 23);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (4, 'Natural world', 23);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (5, 'Death and disaster', 21);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (6, 'War and conflict', 21);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (7, 'Sports', 22);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (8, 'Economy', 21);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (9, 'Entertainment and culture', 22);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (10, 'Health and medicine', 21);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (11, 'Love and relationships', 22);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (12, 'Science and technology', 23);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (13, 'Old', 24);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (14, 'Transport', 23);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (15, 'Energy', 23);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (16, 'Royalty and monarchy', 22);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (17, 'Crime and legal', 21);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (18, 'Religio', 22);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (19, 'Educatio', 22);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (20, 'General', 24);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (21, 'Socio/political', 25);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (22, 'Cultural', 25);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (23, 'Scientific/technical', 25);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (24, 'Odd', 25);

INSERT INTO categories (category_id, name, parent_category_id) VALUES (25, 'All categories', NULL);