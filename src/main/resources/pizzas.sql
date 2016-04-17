--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

-- Started on 2016-04-18 02:37:32

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2118 (class 1262 OID 16393)
-- Name: pizzas; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE pizzas WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE pizzas OWNER TO postgres;

\connect pizzas

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2121 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 559 (class 1247 OID 16420)
-- Name: type; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE type AS ENUM (
    'SEA',
    'VEGETERIAN',
    'REGULAR'
);


ALTER TYPE type OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 181 (class 1259 OID 16397)
-- Name: order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "order" (
    id integer NOT NULL
);


ALTER TABLE "order" OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 16402)
-- Name: order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE order_id_seq OWNER TO postgres;

--
-- TOC entry 2122 (class 0 OID 0)
-- Dependencies: 182
-- Name: order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE order_id_seq OWNED BY "order".id;


--
-- TOC entry 184 (class 1259 OID 16413)
-- Name: pizzas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pizzas (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    type type NOT NULL,
    cost double precision NOT NULL
);


ALTER TABLE pizzas OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16411)
-- Name: pizzas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pizzas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pizzas_id_seq OWNER TO postgres;

--
-- TOC entry 2123 (class 0 OID 0)
-- Dependencies: 183
-- Name: pizzas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pizzas_id_seq OWNED BY pizzas.id;


--
-- TOC entry 1990 (class 2604 OID 16404)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "order" ALTER COLUMN id SET DEFAULT nextval('order_id_seq'::regclass);


--
-- TOC entry 1991 (class 2604 OID 16416)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pizzas ALTER COLUMN id SET DEFAULT nextval('pizzas_id_seq'::regclass);


--
-- TOC entry 2110 (class 0 OID 16397)
-- Dependencies: 181
-- Data for Name: order; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2124 (class 0 OID 0)
-- Dependencies: 182
-- Name: order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('order_id_seq', 1, false);


--
-- TOC entry 2113 (class 0 OID 16413)
-- Dependencies: 184
-- Data for Name: pizzas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO pizzas (id, name, type, cost) VALUES (1, 'Pizza1', 'SEA', 10.5);
INSERT INTO pizzas (id, name, type, cost) VALUES (2, 'Pizza2', 'REGULAR', 12.5);


--
-- TOC entry 2125 (class 0 OID 0)
-- Dependencies: 183
-- Name: pizzas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pizzas_id_seq', 2, true);


--
-- TOC entry 1993 (class 2606 OID 16409)
-- Name: order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "order"
    ADD CONSTRAINT order_pkey PRIMARY KEY (id);


--
-- TOC entry 1995 (class 2606 OID 16418)
-- Name: pizzas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pizzas
    ADD CONSTRAINT pizzas_pkey PRIMARY KEY (id);


--
-- TOC entry 2120 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-04-18 02:37:33

--
-- PostgreSQL database dump complete
--

