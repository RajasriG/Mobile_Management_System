    
CREATE TABLE IF NOT EXISTS public.distributiondetails
(
    id integer NOT NULL,
    location character varying(50),
    CONSTRAINT distributiondetails_pkey PRIMARY KEY (id),
    CONSTRAINT distributiondetails_location_unique_index UNIQUE (location)   
);
INSERT INTO distribution(id, location) VALUES (1, 'hyd');
 