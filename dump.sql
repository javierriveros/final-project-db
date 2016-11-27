--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.5
-- Dumped by pg_dump version 9.5.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: create_user_from_student(); Type: FUNCTION; Schema: public; Owner: root
--

CREATE FUNCTION create_user_from_student() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
BEGIN
INSERT INTO users(username, password, role_reference) VALUES(lower(NEW.name), NEW.ci, NEW.registration_number);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.create_user_from_student() OWNER TO root;

--
-- Name: create_user_from_teacher(); Type: FUNCTION; Schema: public; Owner: root
--

CREATE FUNCTION create_user_from_teacher() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
BEGIN
INSERT INTO users(username, password, role, role_reference) VALUES(lower(NEW.name), lower(NEW.name), 'teacher', NEW.id);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.create_user_from_teacher() OWNER TO root;

--
-- Name: delete_user_from_student(); Type: FUNCTION; Schema: public; Owner: root
--

CREATE FUNCTION delete_user_from_student() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
BEGIN
  DELETE FROM users WHERE role_reference=OLD.registration_number AND role='student';
  RETURN OLD;
END;
$$;


ALTER FUNCTION public.delete_user_from_student() OWNER TO root;

--
-- Name: delete_user_from_teacher(); Type: FUNCTION; Schema: public; Owner: root
--

CREATE FUNCTION delete_user_from_teacher() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
BEGIN
  DELETE FROM users WHERE role_reference=OLD.id AND role='teacher';
  RETURN OLD;
END;
$$;


ALTER FUNCTION public.delete_user_from_teacher() OWNER TO root;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: conforms; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE conforms (
    teacher_id integer NOT NULL,
    group_id integer NOT NULL
);


ALTER TABLE conforms OWNER TO root;

--
-- Name: groups; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE groups (
    id integer NOT NULL,
    name character varying(25),
    components_number integer,
    description text,
    teacher_id integer
);


ALTER TABLE groups OWNER TO root;

--
-- Name: groups_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE groups_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE groups_id_seq OWNER TO root;

--
-- Name: groups_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE groups_id_seq OWNED BY groups.id;


--
-- Name: helps; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE helps (
    teacher_id integer NOT NULL,
    student_registration_number integer NOT NULL
);


ALTER TABLE helps OWNER TO root;

--
-- Name: integrates; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE integrates (
    teacher_id integer NOT NULL,
    tribunal_id integer NOT NULL
);


ALTER TABLE integrates OWNER TO root;

--
-- Name: projects; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE projects (
    order_number integer NOT NULL,
    start_date timestamp without time zone,
    status character varying(25) DEFAULT 'No evaluado'::character varying NOT NULL,
    tribunal_id integer,
    end_date timestamp without time zone,
    student_registration_number integer
);


ALTER TABLE projects OWNER TO root;

--
-- Name: projects_order_number_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE projects_order_number_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE projects_order_number_seq OWNER TO root;

--
-- Name: projects_order_number_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE projects_order_number_seq OWNED BY projects.order_number;


--
-- Name: students; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE students (
    registration_number integer NOT NULL,
    ci integer,
    name character varying(25),
    last_name character varying(25),
    incorporation_date timestamp without time zone,
    group_id integer,
    order_number integer,
    teacher_id integer
);


ALTER TABLE students OWNER TO root;

--
-- Name: students_registration_number_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE students_registration_number_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE students_registration_number_seq OWNER TO root;

--
-- Name: students_registration_number_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE students_registration_number_seq OWNED BY students.registration_number;


--
-- Name: teachers; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE teachers (
    id integer NOT NULL,
    name character varying(25),
    last_name character varying(25),
    address character varying(50)
);


ALTER TABLE teachers OWNER TO root;

--
-- Name: themes; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE themes (
    order_number integer NOT NULL,
    title character varying(25)
);


ALTER TABLE themes OWNER TO root;

--
-- Name: tribunals; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE tribunals (
    id integer NOT NULL,
    test_place character varying(50),
    components_number integer,
    teacher_id integer
);


ALTER TABLE tribunals OWNER TO root;

--
-- Name: tribunals_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE tribunals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tribunals_id_seq OWNER TO root;

--
-- Name: tribunals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE tribunals_id_seq OWNED BY tribunals.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE users (
    id integer NOT NULL,
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    role character varying(50) DEFAULT 'student'::character varying NOT NULL,
    role_reference integer
);


ALTER TABLE users OWNER TO root;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO root;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY groups ALTER COLUMN id SET DEFAULT nextval('groups_id_seq'::regclass);


--
-- Name: order_number; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY projects ALTER COLUMN order_number SET DEFAULT nextval('projects_order_number_seq'::regclass);


--
-- Name: registration_number; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY students ALTER COLUMN registration_number SET DEFAULT nextval('students_registration_number_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY tribunals ALTER COLUMN id SET DEFAULT nextval('tribunals_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Data for Name: conforms; Type: TABLE DATA; Schema: public; Owner: root
--

COPY conforms (teacher_id, group_id) FROM stdin;
1	4
2	5
2	4
2	6
3	4
3	5
3	6
\.


--
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: root
--

COPY groups (id, name, components_number, description, teacher_id) FROM stdin;
4	Gitecxx	2	Tecnología de punta	1
5	Macrypts	2	Encriptación de información	2
6	Seguridad Informática	10	La Seguridad Informática es muy importante para la salud	3
\.


--
-- Name: groups_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('groups_id_seq', 6, true);


--
-- Data for Name: helps; Type: TABLE DATA; Schema: public; Owner: root
--

COPY helps (teacher_id, student_registration_number) FROM stdin;
1	4
1	1
1	2
1	3
1	5
1	6
3	2
\.


--
-- Data for Name: integrates; Type: TABLE DATA; Schema: public; Owner: root
--

COPY integrates (teacher_id, tribunal_id) FROM stdin;
1	1
1	2
2	1
2	2
3	1
3	2
\.


--
-- Data for Name: projects; Type: TABLE DATA; Schema: public; Owner: root
--

COPY projects (order_number, start_date, status, tribunal_id, end_date, student_registration_number) FROM stdin;
1	2016-11-23 22:39:06.467127	No evaluado	1	2016-11-26 01:09:11.865381	1
2	2016-11-25 23:42:19.96699	No evaluado	1	2016-11-26 01:09:11.865381	2
8	2016-10-10 22:56:43	Evaluado	1	2016-10-10 23:13:50	4
\.


--
-- Name: projects_order_number_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('projects_order_number_seq', 8, true);


--
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: root
--

COPY students (registration_number, ci, name, last_name, incorporation_date, group_id, order_number, teacher_id) FROM stdin;
2	160003546	Yamid Mauricio	Leal García	2016-11-24 11:38:17.364628	4	2	1
1	160003532	Walter Javier	Riveros Castro	2016-11-23 20:48:38.67149	4	1	2
3	160003525	Jhonathan	Mejia	2016-11-24 12:56:11.381699	4	\N	2
4	160003512	Mauricio	Mejia	2016-11-24 12:58:27.3595	4	\N	2
6	1600035	Monopeña	Aguilera	2016-10-10 16:31:03	4	\N	\N
5	160003590	Juan Albeiro	Garavito Follador	2016-10-10 16:05:12	\N	\N	\N
7	160003590	Juan Albeiro	Garavito Follador	2016-10-10 16:05:12	4	\N	\N
\.


--
-- Name: students_registration_number_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('students_registration_number_seq', 7, true);


--
-- Data for Name: teachers; Type: TABLE DATA; Schema: public; Owner: root
--

COPY teachers (id, name, last_name, address) FROM stdin;
2	Cesar Augusto	Romero	Villavicencio, Meta
3	Esteban	Padilla	Villavo
1	Jesús Reyes	Carvajal Carvajal	Villavicencio -  Meta
\.


--
-- Data for Name: themes; Type: TABLE DATA; Schema: public; Owner: root
--

COPY themes (order_number, title) FROM stdin;
1	Economía
2	Electrónica
8	Programación Cuantica
\.


--
-- Data for Name: tribunals; Type: TABLE DATA; Schema: public; Owner: root
--

COPY tribunals (id, test_place, components_number, teacher_id) FROM stdin;
1	San Antonio	5	1
2	Unillanos Barcelon	1	2
\.


--
-- Name: tribunals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('tribunals_id_seq', 4, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: root
--

COPY users (id, username, password, role, role_reference) FROM stdin;
2	admin	admin	admin	\N
1	javier	160003532	student	1
3	jesus	jesus	teacher	1
4	mauricio	160003546	student	2
5	cesar	cesar	teacher	2
6	jhonathan	160003525	student	3
7	mauricio	160003512	student	4
14	albeiro	160003590	student	5
15	monopeña	1600035	student	6
16	esteban	esteban	teacher	3
18	juan albeiro	160003590	student	7
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('users_id_seq', 18, true);


--
-- Name: pk_conforms; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY conforms
    ADD CONSTRAINT pk_conforms PRIMARY KEY (teacher_id, group_id);


--
-- Name: pk_groups; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY groups
    ADD CONSTRAINT pk_groups PRIMARY KEY (id);


--
-- Name: pk_helps; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY helps
    ADD CONSTRAINT pk_helps PRIMARY KEY (teacher_id, student_registration_number);


--
-- Name: pk_integrates; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY integrates
    ADD CONSTRAINT pk_integrates PRIMARY KEY (teacher_id, tribunal_id);


--
-- Name: pk_projects; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY projects
    ADD CONSTRAINT pk_projects PRIMARY KEY (order_number);


--
-- Name: pk_students; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY students
    ADD CONSTRAINT pk_students PRIMARY KEY (registration_number);


--
-- Name: pk_teachers; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY teachers
    ADD CONSTRAINT pk_teachers PRIMARY KEY (id);


--
-- Name: pk_themes; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY themes
    ADD CONSTRAINT pk_themes PRIMARY KEY (order_number);


--
-- Name: pk_tribunals; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY tribunals
    ADD CONSTRAINT pk_tribunals PRIMARY KEY (id);


--
-- Name: pk_users; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY users
    ADD CONSTRAINT pk_users PRIMARY KEY (id);


--
-- Name: create_user_from_student; Type: TRIGGER; Schema: public; Owner: root
--

CREATE TRIGGER create_user_from_student AFTER INSERT ON students FOR EACH ROW EXECUTE PROCEDURE create_user_from_student();


--
-- Name: create_user_from_teacher; Type: TRIGGER; Schema: public; Owner: root
--

CREATE TRIGGER create_user_from_teacher AFTER INSERT ON teachers FOR EACH ROW EXECUTE PROCEDURE create_user_from_teacher();


--
-- Name: delete_user_from_student; Type: TRIGGER; Schema: public; Owner: root
--

CREATE TRIGGER delete_user_from_student BEFORE DELETE ON students FOR EACH ROW EXECUTE PROCEDURE delete_user_from_student();


--
-- Name: delete_user_from_teacher; Type: TRIGGER; Schema: public; Owner: root
--

CREATE TRIGGER delete_user_from_teacher BEFORE DELETE ON teachers FOR EACH ROW EXECUTE PROCEDURE delete_user_from_teacher();


--
-- Name: fk_projects_students; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY projects
    ADD CONSTRAINT fk_projects_students FOREIGN KEY (student_registration_number) REFERENCES students(registration_number) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: fk_projects_tribunals; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY projects
    ADD CONSTRAINT fk_projects_tribunals FOREIGN KEY (tribunal_id) REFERENCES tribunals(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: fk_students_groups; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY students
    ADD CONSTRAINT fk_students_groups FOREIGN KEY (group_id) REFERENCES groups(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: fk_students_projects; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY students
    ADD CONSTRAINT fk_students_projects FOREIGN KEY (order_number) REFERENCES projects(order_number) ON UPDATE RESTRICT ON DELETE CASCADE;


--
-- Name: fk_students_teachers; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY students
    ADD CONSTRAINT fk_students_teachers FOREIGN KEY (teacher_id) REFERENCES teachers(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: fk_themes_projects; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY themes
    ADD CONSTRAINT fk_themes_projects FOREIGN KEY (order_number) REFERENCES projects(order_number) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: pk_conforms_groups; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY conforms
    ADD CONSTRAINT pk_conforms_groups FOREIGN KEY (group_id) REFERENCES groups(id) ON UPDATE RESTRICT ON DELETE CASCADE;


--
-- Name: pk_conforms_teachers; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY conforms
    ADD CONSTRAINT pk_conforms_teachers FOREIGN KEY (teacher_id) REFERENCES teachers(id) ON UPDATE RESTRICT ON DELETE CASCADE;


--
-- Name: pk_groups_teachers; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY groups
    ADD CONSTRAINT pk_groups_teachers FOREIGN KEY (teacher_id) REFERENCES teachers(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: pk_helps_students; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY helps
    ADD CONSTRAINT pk_helps_students FOREIGN KEY (student_registration_number) REFERENCES students(registration_number) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: pk_helps_teacher; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY helps
    ADD CONSTRAINT pk_helps_teacher FOREIGN KEY (teacher_id) REFERENCES teachers(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: pk_integrates_teacher; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY integrates
    ADD CONSTRAINT pk_integrates_teacher FOREIGN KEY (teacher_id) REFERENCES teachers(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: pk_integrates_tribunal; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY integrates
    ADD CONSTRAINT pk_integrates_tribunal FOREIGN KEY (tribunal_id) REFERENCES tribunals(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: pk_tribunals_teachers; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY tribunals
    ADD CONSTRAINT pk_tribunals_teachers FOREIGN KEY (teacher_id) REFERENCES teachers(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

