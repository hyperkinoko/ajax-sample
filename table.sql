DROP TABLE IF EXISTS OPEN;
DROP TABLE IF EXISTS RESERVATION;
DROP TABLE IF EXISTS STUDENT;
DROP TABLE IF EXISTS MEMBER;

CREATE TABLE MEMBER (
  ID SERIAL PRIMARY KEY,
  LINE_ID VARCHAR(128),
  NAME VARCHAR(64) NOT NULL,
  MAIL VARCHAR(64) NOT NULL,
  PASSWD VARCHAR(512) NOT NULL
);

CREATE TABLE STUDENT (
  ID SERIAL PRIMARY KEY,
  GUARDIAN INT NOT NULL,
  CAL_DISP_NAME VARCHAR(64),
  BIRTHDAY DATE,
  FOREIGN KEY (GUARDIAN) REFERENCES MEMBER(ID)
);

CREATE TABLE RESERVATION (
  ID SERIAL PRIMARY KEY,
  START_DATE DATE NOT NULL,
  END_DATE DATE NOT NULL,
  STUDENT_ID INT NOT NULL,
  PRICE INT NOT NULL,
  ATTENDED INT DEFAULT 0,
  ADD_TO_CAL BOOLEAN DEFAULT FALSE,
  FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT(ID)
);

CREATE TABLE OPEN (
  START DATETIME NOT NULL,
  END DATETIME NOT NULL
);