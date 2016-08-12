-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO app_user (user_name, password, salt) VALUES ('gates', 'WzYbaCzcPr6PSX0W50gUWw==', 'SDJydqT014UpMj7hCx+1/aeV7HJ82PA+CxZm0BeelT75HfxhbnAH/w5AVIHoX+A6eGiyzIMPflQlLiYhQxtB8LqddoMPWIW6jsX3MrjuKZKlRdd52az4DXdV3jWzFb+CwkGjVlLZ0SE/NvNmMxoEcwKPEEnGevnkZ8T0ZJJdh/s=');
INSERT INTO app_user (user_name, password, salt) VALUES ('jobs', '4oM/sadeaSO27uqo5BjUZg==', 'GGQJ0g4eqopsi2HTa/uvBGSQrx8+AhhsK4DvSvQy10w9FMtcUxsvVS+MOIHUii6FoCSfQR/dJnoivxyeoRsZKU6xTGA2ByWmRI/6AJosGICwxG1s+YmgbaIqii7CtBW89r9P0uKQT8tUXW5HbXy+buQiifS8BhWr9A4YYdVcUAU=');
INSERT INTO app_user (user_name, password, salt) VALUES ('woz', '3OVAF52wRJaH34Jd84LAiw==', 'mkhoEViWKG/044kVyqGY4hnh3pU3vkCvreGdmVb81o1Jy0VcvY9/5TTbbJ8mHV1ueV2HKhVY0W22qg0avAGxsVe+8JXr1hONvig50GhDYUdVV+qZWjyYlRnT9XWQHUDEEGAPRmYmcU8U0nmDDxT1mh0L2yayfajmxqRlVYTi8Yw=');
INSERT INTO app_user (user_name, password, salt) VALUES ('ellison', 'xdtB3l+U+XLK7L4qemdL4w==', 'L6bgOH3ffWWGWv0S5Rtudu7FtGXn/I4hYksEEmO8vjTVh74zbvsYQtC58gWO4VvopGfE1CScD3VPLMxCgeaIpWy4WJW1bicjgA5mW8AKWYoMudYSDciNrWbjxH41JgIbWtz3mXo7JTQXU7sGyqTZRw7lghbaSrW09jovEfSc63U=');
INSERT INTO app_user (user_name, password, salt) VALUES ('kildall', 'Dy9UfeLCtUW2PrJlMVhfJw==', 'jrojMvgS+XDQq7NZqF/gXaDTzlR8/bLbLvg4q/TeerQqL/V1/8qt4WN8zQTZCttuwJ78JY4TJSgAbq50MKDD85pzLQ1XbZtWWc8nqV+IzNaKExNcPIbXY8Ol5EGkW4RY0zbv/QAJm0u9+z41NQOY4/ctm4YBSVV+aoOGMkgE7ME=');

INSERT INTO recipe (recipe_name, instructions) VALUES ('mac n cheese', 'Preheat the oven to 350 degrees F. \n
Cook the macaroni until still slightly firm. Drain and set aside.
In a small bowl, beat the egg. In a large pot, melt the butter and sprinkle in the flour. Whisk together over medium-low heat. Cook for a couple of minutes, whisking constantly. Don\''t let it burn. Pour in the milk, add the mustard and whisk until smooth. Cook until very thick, about 5 minutes. Reduce the heat to low. \n
Take 1/4 cup of the sauce and slowly pour it into the beaten egg, whisking constantly to avoid cooking the eggs. Whisk together until smooth. Pour the egg into the sauce, whisking constantly. Stir until smooth. Add in the cheese and stir to melt. Add 1/2 teaspoon salt, 1/2 teaspoon seasoned salt and the pepper. Add any additional spices if desired. Taste the sauce and add more salt and seasoned salt as needed! DO NOT UNDERSALT.\n);
Pour in the drained, cooked macaroni and stir to combine. Serve immediately (while it\''s still very creamy) or pour into a buttered baking dish, top with extra cheese and bake until bubbly and golden on top, 20 to 25 minutes.');
INSERT INTO recipe (recipe_name, instructions) VALUES ('roast beef', 'Preheat oven to 375 degrees F (190 degrees C). If roast is untied, tie at 3 inch intervals with cotton twine. Place roast in pan, and season with salt, garlic powder, and pepper. Add more or less seasonings to taste.\n
Roast in oven for 60 minutes (20 minutes per pound). Remove from oven, cover loosely with foil, and let rest for 15 to 20 minutes.');
INSERT INTO recipe (recipe_name, instructions) VALUES ('pork loin', 'Dissolve steak seasoning in balsamic vinegar, then stir in olive oil. Place pork into a resealable plastic bag and pour marinade overtop. Squeeze out air and seal bag; marinate 2 hours to overnight.\n
Preheat oven to 350 degrees F (175 degrees C).\n Place pork into a glass baking dish along with marinade. Bake in preheated oven, basting occasionally until the pork reaches an internal temperature of 145 degrees F (65 degrees C), about 1 hour. Let the roast rest for 10 minutes before slicing and serving.');
INSERT INTO recipe (recipe_name, instructions) VALUES ('cheerios', 'Whisk the dry ingredients together in a large bowl and set aside.
\n
In a separate bowl, whisk the eggs, milk, melted butter, and vanilla until combined and fold into the wet ingredients just until combined. The dough should be very soft and just slightly sticky.
\n
Set out a piece of parchment paper and place the ball of dough on it. Press into a disc about 1-inch thick and place in the refrigerator for about 10 minutes to firm just slightly. Meanwhile, preheat the oven to 350F.
\n
When the dough is slightly chilled, decide the shape of your homemade Cheerios...
\n
FOR SQUARES, place another piece of parchment over the top of the dough and roll until the dough is about 1/4-inch thick, about the thickness of two nickels.
\n
Using a pizza cutter or a very sharp knife, cut the dough into small squares about 1/2" x 1/2".
');
INSERT INTO recipe (recipe_name, instructions) VALUES ('ramen', 'Heat 1 tablespoon sesame oil in a large stockpot or Dutch oven over medium heat. Add garlic and ginger, and cook, stirring frequently, until fragrant, about 1-2 minutes. \n
Heat 1 tablespoon sesame oil in a large stockpot or Dutch oven over medium heat. Add garlic and ginger, and cook, stirring frequently, until fragrant, about 1-2 minutes. \n
Bring to a boil; reduce heat and simmer until mushrooms have softened, about 10 minutes. Stir in Yaki-Soba until loosened and cooked through, about 2-3 minutes.
 \n
Bring to a boil; reduce heat and simmer until mushrooms have softened, about 10 minutes. Stir in Yaki-Soba until loosened and cooked through, about 2-3 minutes.
\n
Serve immediately.');

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
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(12,5);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(13,5);
INSERT INTO recipe_ingredient (ingredient_id, recipe_id) VALUES(14,5);

INSERT INTO unit (unit_id, unit_name) VALUES(1, 'cups');
INSERT INTO unit (unit_id, unit_name) VALUES(2, 'tsp');
INSERT INTO unit (unit_id, unit_name) VALUES(3, 'TB');
INSERT INTO unit (unit_id, unit_name) VALUES(4, 'oz');

INSERT INTO quantity (quantity_id, quantity_number) VALUES(1, .25);
INSERT INTO quantity (quantity_id, quantity_number) VALUES(1, .33);
INSERT INTO quantity (quantity_id, quantity_number) VALUES(3, .5);
INSERT INTO quantity (quantity_id, quantity_number) VALUES(4, .66);
INSERT INTO quantity (quantity_id, quantity_number) VALUES(5, .75);
INSERT INTO quantity (quantity_id, quantity_number) VALUES(6, 1);
INSERT INTO quantity (quantity_id, quantity_number) VALUES(7, 1.25);
INSERT INTO quantity (quantity_id, quantity_number) VALUES(8, 1.33);
INSERT INTO quantity (quantity_id, quantity_number) VALUES(9, 1.5);
INSERT INTO quantity (quantity_id, quantity_number) VALUES(10, 1.66);
INSERT INTO quantity (quantity_id, quantity_number) VALUES(11, 1.75);
INSERT INTO quantity (quantity_id, quantity_number) VALUES(12, 2);








COMMIT;
