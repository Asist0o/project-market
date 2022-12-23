-- removing tables for clean database
DROP TABLE IF EXISTS password_tokens CASCADE;
DROP TABLE IF EXISTS role CASCADE;
DROP TABLE IF EXISTS account CASCADE;

-- removing sequences
DROP SEQUENCE IF EXISTS role_id_seq;
DROP SEQUENCE IF EXISTS account_id_seq;
DROP SEQUENCE IF EXISTS password_tokens_id_seq;

-- creating sequences
CREATE SEQUENCE role_id_seq INCREMENT 1 MINVALUE 3 MAXVALUE 9223372036854775807 CACHE 2;
CREATE SEQUENCE account_id_seq INCREMENT 1 MINVALUE 2 MAXVALUE 9223372036854775807 CACHE 1;
CREATE SEQUENCE password_tokens_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

-- creating tables
CREATE TABLE public.role
(
    "id"        bigint DEFAULT nextval('role_id_seq') NOT NULL,
    "authority" character varying(255),
    CONSTRAINT "role_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "uk_irsamgnera6angm0prq1kemt2" UNIQUE ("authority")
) WITH (oids = false);

CREATE TABLE public.account
(
    "id"          bigint DEFAULT nextval('account_id_seq') NOT NULL,
    email         character varying(255)                   NOT NULL,
    is_blocked    boolean,
    last_name     character varying(255)                   NOT NULL,
    name          character varying(255)                   NOT NULL,
    password_hash character varying(255),
    role          character varying(255)                   NOT NULL,
    CONSTRAINT account_pkey PRIMARY KEY (id),
    CONSTRAINT ukq0uja26qgu1atulenwup9rxyr UNIQUE (email)
) WITH (oids = false);

CREATE TABLE public.password_tokens
(
    "id"        bigint DEFAULT nextval('password_tokens_id_seq') NOT NULL,
    expiry_date timestamp,
    token       character varying(255),
    account_id  bigint                                           NOT NULL,
    CONSTRAINT password_tokens_pkey PRIMARY KEY (id)
) WITH (oids = false);

-- filling tables
INSERT INTO public.role(id, authority)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.role(id, authority)
VALUES (2, 'ROLE_USER');
INSERT INTO public.account(id, name, last_name, email, password_hash, role, is_blocked)
VALUES (1, 'user1_name_test', 'user1_last_name_test', 'user1_test@gmail.com',
        '$2a$10$F40D/VYE.MLHES98QCWhhun.niv4z3d20H9EcSM9FeUWd.DPYPSD6', 'ROLE_USER', false);