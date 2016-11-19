CREATE TABLE groups (
  id serial,
  name varchar(25),
  components_number integer
);

CREATE TABLE projects (
  order_number serial,
  start_date timestamp
);

CREATE TABLE tribunals (
  id serial,
  test_place varchar(50),
  components_number integer
);

CREATE TABLE teachers (
  ci serial,
  name varchar(25),
  last_name varchar(25),
  address varchar(50)
);

CREATE TABLE themes (
  order_number integer,
  title varchar(25)
);

CREATE TABLE students (
  registration_number integer,
  ci serial,
  name varchar(25),
  last_name varchar(25),
  incorporation_date timestamp
);

# Relations
CREATE TABLE integrates (
    teacher_ci integer,
    tribunal_id integer
);

# Primary Keys
ALTER TABLE groups ADD CONSTRAINT pk_groups PRIMARY KEY(id);
ALTER TABLE projects ADD CONSTRAINT pk_projects PRIMARY KEY(order_number);
ALTER TABLE students ADD CONSTRAINT pk_students PRIMARY KEY(registration_number);
ALTER TABLE teachers ADD CONSTRAINT pk_teachers PRIMARY KEY(ci);
ALTER TABLE themes ADD CONSTRAINT pk_themes PRIMARY KEY(order_number);
ALTER TABLE tribunals ADD CONSTRAINT pk_tribunals PRIMARY KEY(id);
ALTER TABLE integrates ADD CONSTRAINT pk_integrates PRIMARY KEY(teacher_ci, tribunal_id);

# Aditional Fields
ALTER TABLE projects ADD COLUMN tribunal_id integer;
ALTER TABLE students ADD COLUMN group_id integer;
ALTER TABLE students ADD COLUMN order_number integer;
ALTER TABLE students ADD COLUMN teacher_ci integer;

# Constraints & foreign keys

ALTER TABLE themes ADD CONSTRAINT fk_themes_projects 
  FOREIGN KEY(order_number) REFERENCES projects(order_number) 
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE students ADD CONSTRAINT fk_students_groups
  FOREIGN KEY(group_id) REFERENCES groups(id) 
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE students ADD CONSTRAINT fk_students_projects
  FOREIGN KEY(order_number) REFERENCES projects(order_number) 
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE students ADD CONSTRAINT fk_students_teachers
  FOREIGN KEY(teacher_ci) REFERENCES teachers(ci) 
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE projects ADD CONSTRAINT fk_projects_tribunals
  FOREIGN KEY(tribunal_id) REFERENCES tribunals(id) 
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE integrates ADD CONSTRAINT pk_integrates_teacher 
  FOREIGN KEY(teacher_ci) REFERENCES teachers(ci)
  ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE integrates ADD CONSTRAINT pk_integrates_tribunal 
  FOREIGN KEY(tribunal_id) REFERENCES tribunals(id)
  ON DELETE RESTRICT ON UPDATE RESTRICT;