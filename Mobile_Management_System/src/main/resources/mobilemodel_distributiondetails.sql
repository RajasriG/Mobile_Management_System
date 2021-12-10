CREATE TABLE IF NOT EXISTS public.mobilemodel_distributiondetails
(
    model_id integer NOT NULL,
    distributor_id integer NOT NULL,
     CONSTRAINT mobilemodel_distributiondetails_mobilemodel_fkey FOREIGN KEY (model_id)
        REFERENCES public."mobilemodel" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT mobilemodel_distributiondetails_distributiondetails_fkey FOREIGN KEY (distributor_id)
        REFERENCES public.distributiondetails (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

INSERT INTO mobilemodel_distributiondetails(model_id, distributor_id) VALUES (1, 1);
