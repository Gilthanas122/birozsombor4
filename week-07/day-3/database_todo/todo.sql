CREATE DATABASE IF NOT EXISTS todo;
USE todo;
CREATE TABLE IF NOT EXISTS tasks(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    status ENUM("UNDONE","PENDING","DONE") NOT NULL DEFAULT ("UNDONE"),
    name VARCHAR(40) NOT NULL DEFAULT ("new Task"),
    description VARCHAR(200) NULL,
    date_added DATE NOT NULL,
    date_due DATE,
    priority ENUM("LOW", "MEDIUM", "HIGH"),
    location VARCHAR(50) NOT NULL DEFAULT ("home")
);

CREATE TABLE IF NOT EXISTS locations(
    location VARCHAR(50) NOT NULL DEFAULT ("home") PRIMARY KEY,
    zip INT UNSIGNED NOT NULL DEFAULT("7940"),
    country VARCHAR(40) NOT NULL DEFAULT("Hungary")
);

INSERT INTO locations 
VALUES ("home", 7940, "Hungary"), ("Paris", 101010, "France"), ("Heaven", 9999, "Neverland");

INSERT INTO tasks
(status, name, description, date_added, priority, location)
VALUES ("UNDONE", "mytask", "Walk the dog", "2020-04-15", "low", "home"),
("PENDING", "important task", "Buy milk", "2020-04-16", "low", "Budapest"),
("PENDING", "your task", "Go to DisneyLand", "2020-04-17", "high", "Paris"),
("DONE", "task title", "Learn JAVA", "2020-04-20", "low", "home"),
("UNDONE", "random title", "Missing JAVA", "2020-04-25", "medium", "home"),
("UNDONE", "another title", "Dreaming about JAVA", "2020-04-29", "high", "Heaven");

SELECT * FROM tasks;
SELECT * FROM locations;

SELECT description, priority FROM tasks
WHERE status = "UNDONE"
ORDER BY date_added;

SELECT DISTINCT location, description FROM tasks
WHERE priority = "high"
ORDER BY date_added
LIMIT 1;

SELECT DISTINCT location, description FROM tasks
WHERE priority = "high"
ORDER BY date_added
LIMIT 1 OFFSET 1;

SET SQL_SAFE_UPDATES = 0;

UPDATE tasks 
SET date_due = "2020-04-22"
WHERE status = "DONE";

DELETE FROM tasks
WHERE name = "Task 1";

RENAME TABLE  tasks to taskList;
RENAME TABLE  taskList to tasks;

SELECT concat(name, " : ", description) FROM tasks;

SELECT location, COUNT(id) AS how_many_todo FROM tasks
GROUP BY location;

SELECT tasks.description, locations.country FROM tasks
JOIN locations ON tasks.location = locations.location;

ALTER TABLE tasks
ADD details VARCHAR(200) AFTER description;

ALTER TABLE tasks
DROP COLUMN details;
