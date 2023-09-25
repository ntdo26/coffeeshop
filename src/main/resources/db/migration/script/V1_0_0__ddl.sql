CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.brand
(
    id uuid NOT NULL,
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT brand_pkey PRIMARY KEY (id),
    CONSTRAINT brand_uk_code UNIQUE (code)
);



CREATE TABLE IF NOT EXISTS public.shop
(
    id uuid NOT NULL,
    close_time integer NOT NULL,
    is_closed boolean,
    location character varying(255) COLLATE pg_catalog."default" NOT NULL,
    maximum_size_of_queues integer NOT NULL,
    number_of_queues integer NOT NULL,
    opening_time integer NOT NULL,
    phone_number character varying(255) COLLATE pg_catalog."default" NOT NULL,
    tenant character varying(255) COLLATE pg_catalog."default" NOT NULL,
    brand_id uuid NOT NULL,
    CONSTRAINT shop_pkey PRIMARY KEY (id),
    CONSTRAINT shop_fk_brand FOREIGN KEY (brand_id)
        REFERENCES public.brand (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT shop_uk_phone_number UNIQUE (phone_number),
    CONSTRAINT shop_uk_location UNIQUE (location)

);

CREATE TABLE IF NOT EXISTS public.drink
(
    id uuid NOT NULL,
    discount_by_percent integer,
    is_out_of_stock boolean,
    minutes_for_preparing integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    price character varying(255) COLLATE pg_catalog."default" NOT NULL,
    tenant character varying(255) COLLATE pg_catalog."default",
    shop_id uuid,
    CONSTRAINT drink_pkey PRIMARY KEY (id),
    CONSTRAINT drink_fk_shop_id FOREIGN KEY (shop_id)
        REFERENCES public.shop (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.user_information
(
    id uuid NOT NULL,
    user_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    tenant character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.order_transaction
(
    id uuid NOT NULL,
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    price character varying(255) COLLATE pg_catalog."default" NOT NULL,
    status character varying(255) COLLATE pg_catalog."default" NOT NULL,
    tenant character varying(255) COLLATE pg_catalog."default" NOT NULL,
    drink_id uuid NOT NULL,
    shop_id uuid NOT NULL,
    user_id uuid NOT NULL,
    CONSTRAINT order_transaction_pkey PRIMARY KEY (id),
    CONSTRAINT order_transaction_fk_shop_id FOREIGN KEY (shop_id)
        REFERENCES public.shop (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT order_transaction_fk_drink_id FOREIGN KEY (drink_id)
        REFERENCES public.drink (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT order_transaction_fk_user_id FOREIGN KEY (user_id)
            REFERENCES public.user_information (id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION,
    CONSTRAINT order_transaction_status_check CHECK (status::text = ANY (ARRAY['WAITING'::character varying, 'CONFIRMED'::character varying, 'COMPLETED'::character varying, 'CANCELED'::character varying]::text[]))
);