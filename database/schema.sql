-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

CREATE SEQUENCE app_user_user_id_seq START 6
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE TABLE app_user (
	user_name varchar(32) NOT NULL,
	password varchar(32) NOT NULL,
	salt varchar(256) NOT NULL,
	user_id integer DEFAULT nextval('app_user_user_id_seq'::regclass) NOT NULL,
	CONSTRAINT pk_app_user_user_id PRIMARY KEY (user_id)
);

CREATE TABLE app_user_recipe (
	user_id integer NOT NULL,
	recipe_id integer NOT NULL,
	CONSTRAINT pk_app_user_recipe_app_user_id_recipe_id PRIMARY KEY (user_id, recipe_id)
);

CREATE TABLE recipe (
	recipe_id integer NOT NULL,
	recipe_name varchar(32) NOT NULL,
	meal_type_id integer,
	category_id integer,
	instructions varchar(256),
	CONSTRAINT pk_recipe_recipe_id PRIMARY KEY (recipe_id)
);

CREATE TABLE recipe_ingredient (
	recipe_id integer NOT NULL,
	ingredient_id integer NOT NULL,
	ingredient_quantity integer,
	CONSTRAINT pk_recipe_ingredient_recipe_id_ingredient_id PRIMARY KEY (recipe_id, ingredient_id)
);

CREATE TABLE ingredient (
	ingredient_id integer NOT NULL,
	ingredient_name varchar(32) NOT NULL,
	unit_of_measurement varchar(32) NOT NULL,
	CONSTRAINT pk_ingredient_ingredient_id PRIMARY KEY (ingredient_id)
);

CREATE TABLE ingredient_unit (
	ingredient_id integer NOT NULL,
	unit_id integer NOT NULL,
	quantity decimal NOT NULL,
	CONSTRAINT pk_ingredient_unit_ingredient_id_unit_id PRIMARY KEY (ingredient_id, unit_id)
);

CREATE TABLE unit (
	unit_id integer NOT NULL,
	unit_name varchar,
	CONSTRAINT pk_unit_unit_id PRIMARY KEY (unit_id)
);

CREATE TABLE meal_plan_recipe (
	meal_plan_id integer NOT NULL,
	recipe_id integer NOT NULL,
	CONSTRAINT pk_meal_plan_recipe_meal_plan_id_recipe_id PRIMARY KEY (meal_plan_id, recipe_id)
);

CREATE TABLE meal_plan (
	meal_plan_id integer NOT NULL,
	meal_plan_start_date date NOT NULL,
	meal_plan_end_date date NOT NULL,
	CONSTRAINT pk_meal_plan_meal_plan_id PRIMARY KEY (meal_plan_id)
);

CREATE TABLE recipe_category (
	recipe_category_id integer NOT NULL,
	recipe_category_name varchar(32) NOT NULL,
	recipe_category_description varchar(128),
	CONSTRAINT pk_recipe_category_recipe_category_id PRIMARY KEY (recipe_category_id)
);

CREATE TABLE meal_type (
	meal_type_id integer NOT NULL,
	meal_type_name varchar(32) NOT NULL,
	CONSTRAINT pk_meal_type_meal_type_id PRIMARY KEY (meal_type_id)
);

ALTER TABLE recipe ADD FOREIGN KEY (meal_type_id) REFERENCES meal_type(meal_type_id);
ALTER TABLE recipe ADD FOREIGN KEY (category_id) REFERENCES recipe_category(recipe_category_id);
ALTER TABLE recipe_ingredient ADD FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id);
ALTER TABLE recipe_ingredient ADD FOREIGN KEY (ingredient_id) REFERENCES ingredient(ingredient_id);
ALTER TABLE ingredient_unit ADD FOREIGN KEY (ingredient_id) REFERENCES ingredient(ingredient_id);
ALTER TABLE ingredient_unit ADD FOREIGN KEY (unit_id) REFERENCES unit(unit_id);
ALTER TABLE meal_plan_recipe ADD FOREIGN KEY (meal_plan_id) REFERENCES meal_plan(meal_plan_id);
ALTER TABLE meal_plan_recipe ADD FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id);
ALTER TABLE app_user_recipe ADD FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id);
ALTER TABLE app_user_recipe ADD FOREIGN KEY (user_id) REFERENCES app_user(user_id);


COMMIT;