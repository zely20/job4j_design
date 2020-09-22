--Создать структур данных в базе.
--Таблицы.
--Кузов. Двигатель, Коробка передач.
CREATE TABLE body (
                      id serial PRIMARY  KEY,
                      name varchar(300)
);
CREATE TABLE engine (
                        id serial PRIMARY  KEY,
                        name varchar(300)
);

CREATE TABLE transmission (
                              id serial PRIMARY  KEY,
                              name varchar(300)
);
--Создать структуру Машина. Машина не может существовать без данных из п.1.
CREATE TABLE car (
                     id serial PRIMARY  KEY,
                     name varchar(300),
                     body_id integer REFERENCES body(id),
                     engine_id integer REFERENCES engine(id),
                     transmission_id integer REFERENCES transmission(id)
);
--Заполнить таблицы через insert.
INSERT INTO body (name) VALUES ('blue');
INSERT INTO body (name) VALUES ('red');
INSERT INTO body (name) VALUES ('black');

INSERT INTO engine (name) VALUES ('V4');
INSERT INTO engine (name) VALUES ('V6');
INSERT INTO engine (name) VALUES ('V8');
INSERT INTO engine (name) VALUES ('V12');

INSERT INTO transmission (name) VALUES ('Manual 5');
INSERT INTO transmission (name) VALUES ('Manual 6');
INSERT INTO transmission (name) VALUES ('Manual 7');
INSERT INTO transmission (name) VALUES ('Automatic 5');
INSERT INTO transmission (name) VALUES ('Automatic 6');

INSERT INTO car VALUES (1, 'car1', 2, 2, 4);
INSERT INTO car VALUES (2, 'car2', 3, 3, 5);

select * from car;
--Вывести список всех машин и все привязанные к ним детали.
select c.name, b.name, e.name, t.name
from car AS c,
     body as b,
     engine as e,
     transmission as t
where c.body_id = b.id and
        c.engine_id = e.id and
        c.transmission_id = t.id;

SELECT c.name, b.name, e.name, t.name FROM car c
                                               LEFT JOIN body b on c.body_id = b.id
                                               LEFT JOIN engine e ON c.engine_id = e.id
                                               LEFT JOIN transmission t ON c.transmission_id = t.id;

--Вывести отдельно детали, которые не используются в машине, кузова
SELECT b.name AS body_car FROM body b
                                   LEFT OUTER JOIN car c
                                                   ON c.body_id = b.id  WHERE c.body_id IS NULL;
--Вывести отдельно детали, которые не используются в машине, двигатель
SELECT e.name AS engine_car FROM engine e
                                     LEFT OUTER JOIN car c
                                                     ON c.engine_id = e.id  WHERE c.body_id IS NULL;
--Вывести отдельно детали, которые не используются в машине трансмисия
SELECT t.name AS transmission_car FROM transmission t
                                           LEFT OUTER JOIN car c
                                                           ON c.transmission_id = t.id  WHERE c.transmission_id IS NULL;
