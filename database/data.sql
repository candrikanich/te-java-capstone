-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO app_user (user_name, password, salt) VALUES ('gates', 'WzYbaCzcPr6PSX0W50gUWw==', 'SDJydqT014UpMj7hCx+1/aeV7HJ82PA+CxZm0BeelT75HfxhbnAH/w5AVIHoX+A6eGiyzIMPflQlLiYhQxtB8LqddoMPWIW6jsX3MrjuKZKlRdd52az4DXdV3jWzFb+CwkGjVlLZ0SE/NvNmMxoEcwKPEEnGevnkZ8T0ZJJdh/s=');
INSERT INTO app_user (user_name, password, salt) VALUES ('jobs', '4oM/sadeaSO27uqo5BjUZg==', 'GGQJ0g4eqopsi2HTa/uvBGSQrx8+AhhsK4DvSvQy10w9FMtcUxsvVS+MOIHUii6FoCSfQR/dJnoivxyeoRsZKU6xTGA2ByWmRI/6AJosGICwxG1s+YmgbaIqii7CtBW89r9P0uKQT8tUXW5HbXy+buQiifS8BhWr9A4YYdVcUAU=');
INSERT INTO app_user (user_name, password, salt) VALUES ('woz', '3OVAF52wRJaH34Jd84LAiw==', 'mkhoEViWKG/044kVyqGY4hnh3pU3vkCvreGdmVb81o1Jy0VcvY9/5TTbbJ8mHV1ueV2HKhVY0W22qg0avAGxsVe+8JXr1hONvig50GhDYUdVV+qZWjyYlRnT9XWQHUDEEGAPRmYmcU8U0nmDDxT1mh0L2yayfajmxqRlVYTi8Yw=');
INSERT INTO app_user (user_name, password, salt) VALUES ('ellison', 'xdtB3l+U+XLK7L4qemdL4w==', 'L6bgOH3ffWWGWv0S5Rtudu7FtGXn/I4hYksEEmO8vjTVh74zbvsYQtC58gWO4VvopGfE1CScD3VPLMxCgeaIpWy4WJW1bicjgA5mW8AKWYoMudYSDciNrWbjxH41JgIbWtz3mXo7JTQXU7sGyqTZRw7lghbaSrW09jovEfSc63U=');
INSERT INTO app_user (user_name, password, salt) VALUES ('kildall', 'Dy9UfeLCtUW2PrJlMVhfJw==', 'jrojMvgS+XDQq7NZqF/gXaDTzlR8/bLbLvg4q/TeerQqL/V1/8qt4WN8zQTZCttuwJ78JY4TJSgAbq50MKDD85pzLQ1XbZtWWc8nqV+IzNaKExNcPIbXY8Ol5EGkW4RY0zbv/QAJm0u9+z41NQOY4/ctm4YBSVV+aoOGMkgE7ME=');

INSERT INTO recipe (recipe_name, instructions) VALUES ('mac n cheese', 'test instructions');
INSERT INTO recipe (recipe_name, instructions) VALUES ('roast beef', 'test instructions');
INSERT INTO recipe (recipe_name, instructions) VALUES ('pork loin', 'test instructions');
INSERT INTO recipe (recipe_name, instructions) VALUES ('cheerios', 'test instructions');
INSERT INTO recipe (recipe_name, instructions) VALUES ('ramen', 'test instructions');

INSERT INTO app_user_recipe (user_id, recipe_id) VALUES (1,1);
INSERT INTO app_user_recipe (user_id, recipe_id) VALUES (1,2);
INSERT INTO app_user_recipe (user_id, recipe_id) VALUES (1,3);
INSERT INTO app_user_recipe (user_id, recipe_id) VALUES (2,4);
INSERT INTO app_user_recipe (user_id, recipe_id) VALUES (2,5);

INSERT INTO ingredient (ingredient_name) VALUES ('macaroni pasta');
INSERT INTO ingredient (ingredient_name) VALUES ('cheddar cheese');
INSERT INTO ingredient (ingredient_name) VALUES ('milk');
INSERT INTO ingredient (ingredient_name) VALUES ('butter');
INSERT INTO ingredient (ingredient_name) VALUES ('roast beef');
INSERT INTO ingredient (ingredient_name) VALUES ('green beans');
INSERT INTO ingredient (ingredient_name) VALUES ('baked potatoes');
INSERT INTO ingredient (ingredient_name) VALUES ('pork loin');
INSERT INTO ingredient (ingredient_name) VALUES ('carrots');
INSERT INTO ingredient (ingredient_name) VALUES ('couscous');
INSERT INTO ingredient (ingredient_name) VALUES ('honey nut cheerios&reg;');
INSERT INTO ingredient (ingredient_name) VALUES ('ramen noodles');
INSERT INTO ingredient (ingredient_name) VALUES ('hot water');
INSERT INTO ingredient (ingredient_name) VALUES ('crackers');

INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(1,1);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(2,1);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(3,1);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(4,1);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(5,2);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(6,2);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(7,2);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(8,3);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(9,3);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(10,3);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(11,4);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(3,4);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(12,4);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(13,4);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(14,4);

COMMIT;
