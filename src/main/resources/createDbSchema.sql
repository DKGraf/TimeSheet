-- Drop tables
DROP TABLE IF EXISTS workinghours CASCADE;
DROP TABLE IF EXISTS employee CASCADE;

-- Table: employee
CREATE TABLE employee (
  id              BIGSERIAL    NOT NULL,
  department      VARCHAR(255) NOT NULL,
  sex          BOOLEAN      NOT NULL,
  name            VARCHAR(255) NOT NULL,
  personal_number INT4         NOT NULL,
  PRIMARY KEY (id)
);

-- Table: workinghours
CREATE TABLE workinghours (
  id              BIGSERIAL NOT NULL,
  day             INT4,
  month           INT4,
  working_minutes INT4,
  year            INT4,
  employee_id     INT8,
  PRIMARY KEY (id)
);

ALTER TABLE employee
  ADD CONSTRAINT UK_9avyg7716c7bc9dlh9k9qk21i UNIQUE (personal_number);

ALTER TABLE workinghours
  ADD CONSTRAINT FKp04sreanep6f5kxlclwnllw0d FOREIGN KEY (employee_id) REFERENCES employee;
