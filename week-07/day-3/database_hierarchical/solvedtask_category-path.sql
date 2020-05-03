use hierarchical;

SELECT * FROM categories;

SELECT a.name, COALESCE(CONCAT(c.name, " > " ,b.name, " > ", a.name), CONCAT(b.name, " > ", a.name), a.name)
AS Category_path FROM categories a 
LEFT JOIN categories b ON a.parent_category_id = b.category_id
LEFT JOIN categories c ON b.parent_category_id = c.category_id
ORDER BY name;