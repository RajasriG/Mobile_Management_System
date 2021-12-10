CREATE SEQUENCE mobilemodel_sequence;

CREATE TABLE IF NOT EXISTS public."mobilemodel"
(
    id integer NOT NULL DEFAULT nextval('mobilemodel_sequence'::regclass),
    model_name character varying(255) NOT NULL,
    model_code character varying(255) NOT NULL,
    CONSTRAINT mobilemodel_pkey PRIMARY KEY (id),
    CONSTRAINT model_name_unique_index UNIQUE (model_name),
    CONSTRAINT model_code_unique_index UNIQUE (model_code)
);

INSERT INTO "mobilemodel"(ID, MODEL_NAME, MODEL_CODE) VALUES (1, 'M11','AB12');
