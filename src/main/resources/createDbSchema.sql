-- Drop tables
DROP TABLE IF EXISTS day CASCADE;
DROP TABLE IF EXISTS month CASCADE;
DROP TABLE IF EXISTS employee CASCADE;

-- Table: employee
CREATE TABLE employee (
  id              BIGSERIAL    NOT NULL,
  department      VARCHAR(255) NOT NULL,
  sex             BOOLEAN      NOT NULL,
  name            VARCHAR(255) NOT NULL,
  personal_number INT4         NOT NULL,
  PRIMARY KEY (id)
);

-- Table: month
CREATE TABLE month (
  id          BIGSERIAL NOT NULL,
  year        INT4,
  month       INT4,
  employee_id INT8,
  PRIMARY KEY (id)
);

-- Table: day
CREATE TABLE day (
  id       BIGSERIAL NOT NULL,
  minutes  INT4,
  month_id INT8
);

ALTER TABLE employee
  ADD CONSTRAINT UK_9avyg7716c7bc9dlh9k9qk21i UNIQUE (personal_number);

ALTER TABLE month
  ADD CONSTRAINT FKp04sreanep6f5kxlclwnllw0d FOREIGN KEY (employee_id) REFERENCES employee;

ALTER TABLE day
  ADD CONSTRAINT Rsdf79sdf7f9asdsfFDFs7d97jJ FOREIGN KEY (month_id) REFERENCES month;
