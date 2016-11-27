CREATE TABLE students (
	registration_number serial,
  ci integer,
  name varchar(25),
  last_name varchar(25),
  incorporation_date timestamp
);

CREATE TABLE groups (
  id serial,
  name varchar(25),
  components_number integer,
  description text,
  teacher_id integer NOT NULL
);

CREATE TABLE projects (
  order_number serial,
  start_date timestamp,
  end_date timestamp,
  status varchar(25) NOT NULL DEFAULT 'No evaluado',
  student_registration_number integer NOT NULL
);

CREATE TABLE tribunals (
  id serial,
  test_place varchar(50),
  components_number integer,
  teacher_id integer NOT NULL
);

CREATE TABLE teachers (
  id integer,
  name varchar(25),
  last_name varchar(25),
  address varchar(50)
);

CREATE TABLE themes (
  order_number integer,
  title varchar(25)
);

CREATE TABLE users (
  id serial,
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  role varchar(50) NOT NULL DEFAULT 'student',
  role_reference integer
);

# Relations
CREATE TABLE integrates (
  teacher_id integer,
  tribunal_id integer
);

CREATE TABLE helps (
  teacher_id integer,
  student_registration_number integer  
);

CREATE TABLE conforms (
  teacher_id integer,
  group_id integer
);

# Primary Keys
ALTER TABLE groups ADD CONSTRAINT pk_groups PRIMARY KEY(id);

ALTER TABLE projects ADD CONSTRAINT pk_projects PRIMARY KEY(order_number);

ALTER TABLE students ADD CONSTRAINT pk_students PRIMARY KEY(registration_number);

ALTER TABLE teachers ADD CONSTRAINT pk_teachers PRIMARY KEY(id);

ALTER TABLE themes ADD CONSTRAINT pk_themes PRIMARY KEY(order_number);

ALTER TABLE tribunals ADD CONSTRAINT pk_tribunals PRIMARY KEY(id);

ALTER TABLE integrates ADD CONSTRAINT pk_integrates PRIMARY KEY(teacher_id, tribunal_id);

ALTER TABLE helps ADD CONSTRAINT pk_helps PRIMARY KEY(teacher_id, student_registration_number);

ALTER TABLE conforms ADD CONSTRAINT pk_conforms PRIMARY KEY(teacher_id, group_id);

ALTER TABLE users ADD CONSTRAINT pk_users PRIMARY KEY(id);

# Aditional Fields
ALTER TABLE projects ADD COLUMN tribunal_id integer;

ALTER TABLE students ADD COLUMN group_id integer;

ALTER TABLE students ADD COLUMN order_number integer;

ALTER TABLE students ADD COLUMN teacher_id integer;

# Constraints & foreign keys

ALTER TABLE themes ADD CONSTRAINT fk_themes_projects 
  FOREIGN KEY(order_number) REFERENCES projects(order_number) 
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE students ADD CONSTRAINT fk_students_groups
  FOREIGN KEY(group_id) REFERENCES groups(id) 
  ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE students ADD CONSTRAINT fk_students_projects
  FOREIGN KEY(order_number) REFERENCES projects(order_number) 
  ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE students ADD CONSTRAINT fk_students_teachers
  FOREIGN KEY(teacher_id) REFERENCES teachers(id) 
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE projects ADD CONSTRAINT fk_projects_tribunals
  FOREIGN KEY(tribunal_id) REFERENCES tribunals(id) 
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE projects ADD CONSTRAINT fk_projects_students
  FOREIGN KEY(student_registration_number) REFERENCES students(registration_number) 
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE integrates ADD CONSTRAINT pk_integrates_teacher 
  FOREIGN KEY(teacher_id) REFERENCES teachers(id)
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE integrates ADD CONSTRAINT pk_integrates_tribunal 
  FOREIGN KEY(tribunal_id) REFERENCES tribunals(id)
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE helps ADD CONSTRAINT pk_helps_teacher
  FOREIGN KEY(teacher_id) REFERENCES teachers(id)
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE helps ADD CONSTRAINT pk_helps_students 
  FOREIGN KEY(student_registration_number) REFERENCES students(registration_number)
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE conforms ADD CONSTRAINT pk_conforms_teachers
  FOREIGN KEY(teacher_id) REFERENCES teachers(id)
  ON DELETE CASCADE ON UPDATE RESTRICT;

ALTER TABLE conforms ADD CONSTRAINT pk_conforms_groups
  FOREIGN KEY(group_id) REFERENCES groups(id)
  ON DELETE CASCADE ON UPDATE RESTRICT;

ALTER TABLE tribunals ADD CONSTRAINT pk_tribunals_teachers
  FOREIGN KEY(teacher_id) REFERENCES teachers(id)
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE groups ADD CONSTRAINT pk_groups_teachers
  FOREIGN KEY(teacher_id) REFERENCES teachers(id)
  ON DELETE RESTRICT ON UPDATE RESTRICT;


#Triggers
##Crear un usuario al insertar un estudiante

CREATE OR REPLACE FUNCTION create_user_from_student() RETURNS TRIGGER AS
$create_user_from_student$
DECLARE
BEGIN
	INSERT INTO users(username, password, role_reference) VALUES(lower(NEW.name), NEW.ci, NEW.registration_number);
	RETURN NEW;
END;
$create_user_from_student$ LANGUAGE plpgsql;

CREATE TRIGGER create_user_from_student AFTER INSERT ON students
FOR EACH ROW EXECUTE PROCEDURE create_user_from_student();


##Crear un usuario al insertar un profesor

CREATE OR REPLACE FUNCTION create_user_from_teacher() RETURNS TRIGGER AS
$create_user_from_teacher$
DECLARE
BEGIN
	INSERT INTO users(username, password, role, role_reference) VALUES(lower(NEW.name), lower(NEW.name), 'teacher', NEW.id);
	RETURN NEW;
END;
$create_user_from_teacher$ LANGUAGE plpgsql;

CREATE TRIGGER create_user_from_teacher AFTER INSERT ON teachers
FOR EACH ROW EXECUTE PROCEDURE create_user_from_teacher();

##Delete
CREATE OR REPLACE FUNCTION delete_user_from_student() RETURNS TRIGGER AS
$delete_user_from_student$
DECLARE
BEGIN
  DELETE FROM users WHERE role_reference=OLD.registration_number AND role='student';
  RETURN OLD;
END;
$delete_user_from_student$ LANGUAGE plpgsql;

CREATE TRIGGER delete_user_from_student BEFORE DELETE ON students
FOR EACH ROW EXECUTE PROCEDURE delete_user_from_student();


##Crear un usuario al insertar un profesor

CREATE OR REPLACE FUNCTION delete_user_from_teacher() RETURNS TRIGGER AS
$delete_user_from_teacher$
DECLARE
BEGIN
  DELETE FROM users WHERE role_reference=OLD.id AND role='teacher';
  RETURN OLD;
END;
$delete_user_from_teacher$ LANGUAGE plpgsql;

CREATE TRIGGER delete_user_from_teacher BEFORE DELETE ON teachers
FOR EACH ROW EXECUTE PROCEDURE delete_user_from_teacher();

##Disparador para la evaluación de proyectos

CREATE OR REPLACE FUNCTION evaluate_project() RETURNS TRIGGER AS $$
BEGIN
    IF (NEW.status NOT = OLD.status AND NEW.status = 'Evaluado') THEN
    	NEW.evaluated_at = now()
	END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER evaluate_project
AFTER INSERT OR UPDATE ON projects
FOR EACH ROW EXECUTE PROCEDURE evaluate_project();