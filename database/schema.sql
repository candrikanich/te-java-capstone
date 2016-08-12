-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

CREATE SEQUENCE app_user_user_id_seq
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

CREATE SEQUENCE recipe_recipe_id_seq 
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE TABLE recipe (
	recipe_id integer DEFAULT nextval('recipe_recipe_id_seq'::regclass) NOT NULL,
	recipe_name varchar(32) NOT NULL,
	instructions varchar,
	CONSTRAINT pk_recipe_recipe_id PRIMARY KEY (recipe_id)
);

CREATE TABLE recipe_ingredient (
	recipe_id integer NOT NULL,
	ingredient_id integer NOT NULL,
	unit_id integer NOT NULL,
	quantity_id integer,
	CONSTRAINT pk_recipe_ingredient_recipe_id_ingredient_id PRIMARY KEY (recipe_id, ingredient_id, unit_id)
);

CREATE SEQUENCE ingredient_ingredient_id_seq 
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;
	
CREATE TABLE ingredient (
	ingredient_id integer DEFAULT NEXTVAL('ingredient_ingredient_id_seq'::regclass) NOT NULL,
	ingredient_name varchar(32) NOT NULL,
	CONSTRAINT pk_ingredient_ingredient_id PRIMARY KEY (ingredient_id)
);

CREATE SEQUENCE unit_unit_id_seq 
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE TABLE unit (
	unit_id integer DEFAULT NEXTVAL('unit_unit_id_seq':: regclass) NOT NULL,
	unit_name varchar,
	CONSTRAINT pk_unit_unit_id PRIMARY KEY (unit_id)
);

CREATE SEQUENCE quantity_quantity_id_seq
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;
	
CREATE TABLE quantity (
	quantity_id integer DEFAULT NEXTVAL('quantity_quantity_id_seq'::regClass) NOT NULL,
	quantity_name varchar(16) NOT NULL,
	quantity_value decimal NOT NULL,
	CONSTRAINT pk_quantity_quantity_id PRIMARY KEY (quantity_id)
);

CREATE TABLE meal_plan_recipe (
	meal_plan_id integer NOT NULL,
	recipe_id integer NOT NULL,
	CONSTRAINT pk_meal_plan_recipe_meal_plan_id_recipe_id PRIMARY KEY (meal_plan_id, recipe_id)
);

CREATE SEQUENCE meal_plan_meal_plan_id_seq 
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE TABLE meal_plan (
	meal_plan_id integer DEFAULT NEXTVAL('meal_plan_meal_plan_id_seq':: regclass) NOT NULL,
	meal_plan_start_date date NOT NULL,
	meal_plan_end_date date NOT NULL,
	CONSTRAINT pk_meal_plan_meal_plan_id PRIMARY KEY (meal_plan_id)
);

ALTER TABLE recipe_ingredient ADD FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id);
ALTER TABLE recipe_ingredient ADD FOREIGN KEY (ingredient_id) REFERENCES ingredient(ingredient_id);
ALTER TABLE recipe_ingredient ADD FOREIGN KEY (unit_id) REFERENCES unit(unit_id);
ALTER TABLE meal_plan_recipe ADD FOREIGN KEY (meal_plan_id) REFERENCES meal_plan(meal_plan_id);
ALTER TABLE meal_plan_recipe ADD FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id);
ALTER TABLE app_user_recipe ADD FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id);
ALTER TABLE app_user_recipe ADD FOREIGN KEY (user_id) REFERENCES app_user(user_id);


COMMIT;