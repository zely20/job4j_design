create table if not exists type( id  serial PRIMARY KEY, name varchar);
create table if not exists product( id serial PRIMARY KEY, name varchar,
					type_id integer REFERENCES type(id), expired_date date, price integer);

INSERT INTO type (name) VALUES ('СЫР');
INSERT INTO type (name) VALUES ('МЯСО');
INSERT INTO type (name) VALUES ('МОЛОКО');
INSERT INTO type (name) VALUES ('МОРОЖЕННОЕ');

INSERT INTO product (name, type_id, expired_date, price) VALUES ('Camamber', 1, '2020-10-29', 100);
INSERT INTO product (name, type_id, expired_date, price) VALUES ('Blue Chees', 1, '2020-10-29', 90);
INSERT INTO product (name, type_id, expired_date, price) VALUES ('Milk', 3, '2020-11-20', 30);
INSERT INTO product (name, type_id, expired_date, price) VALUES ('Black Milk', 3, '2020-12-29', 20);
INSERT INTO product (name, type_id, expired_date, price) VALUES ('Milk IceCream', 4, '2020-12-29', 20);
INSERT INTO product (name, type_id, expired_date, price) VALUES ('Chokolate IceCream', 4, '2020-12-29', 20);

select * from product;
--Написать запрос получение всех продуктов с типом "СЫР"
SELECT p.id AS id, p.name AS name, t.name AS name
FROM product AS p
LEFT JOIN
type AS t
ON
p.type_id = t.id
WHERE p.type_id = 1;
--Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT * FROM product WHERE product.name LIKE '%IceCream';
--Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT * FROM product WHERE product.expired_date < '2020-11-01';
--Написать запрос, который выводит самый дорогой продукт.
SELECT * FROM product
WHERE product.price = (SELECT MAX(price) FROM product);
--Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT type_id, COUNT(type_id) FROM product
GROUP BY type_id;
--Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
--НЕ РАБОТАЕТ НЕ ПОЙМУ
SELECT p.id AS id, p.name AS name, t.name AS name
FROM product AS p
LEFT JOIN
type AS t
ON
p.type_id = t.id
WHERE (p.type_id = 1 AND p.type_id = 3);
--Вывести все продукты и их тип.
select p.name, p.expired_date, p.price, t.name from product AS p, type AS t
where t.id=p.type_id;

SELECT * FROM product ;