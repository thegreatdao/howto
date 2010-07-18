CREATE TABLE DEPARTMENT (
    ID BIGINT IDENTITY PRIMARY KEY,  
    NAME VARCHAR(50) NOT NULL,
    LOCATION VARCHAR(50) NOT NULL,
	CONSTRAINT IDX_DEPARTMENT_ID PRIMARY KEY (ID)
);

CREATE TABLE EMPLOYEE (
    ID BIGINT IDENTITY PRIMARY KEY,
    FIRST_NAME VARCHAR(20) NOT NULL,
    LAST_NAME VARCHAR(20) NOT NULL,
    AGE INT NOT NULL,
    DEPARTMENT_ID BIGINT NOT NULL,
    FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT (ID) ON DELETE CASCADE,
	CONSTRAINT IDX_EMPLOYEE_ID PRIMARY KEY (ID)
);

CREATE TABLE INSURANCE_POLICY (
    ID BIGINT IDENTITY PRIMARY KEY,  
    ISSURER VARCHAR(50) NOT NULL,
    POLICY_NUMBER VARCHAR(50) NOT NULL,
    VALID CHAR(1) DEFAULT '1' NOT NULL,
    EMPLOYEE_ID BIGINT NOT NULL,
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (ID) ON DELETE CASCADE,
	CONSTRAINT IDX_INSURANCE_POLICY_ID PRIMARY KEY (ID)
);

CREATE TABLE USER (
	ID BIGINT IDENTITY PRIMARY KEY,
	USER_NAME VARCHAR(20) NOT NULL,
	PASSWORD CHAR(95) NOT NULL,
	FIRST_NAME VARCHAR(20) NOT NULL,
	LAST_NAME VARCHAR(20) NOT NULL,
	GENDER INT DEFAULT 0 NOT NULL,
	AGE INT NOT NULL,
	BIO VARCHAR(1000),
	HOBBIES VARCHAR(300),
	HOME_PAGE VARCHAR(100),
	CREATED_DATE DATE DEFAULT CURRENT_TIMESTAMP NOT NULL,
	CONSTRAINT IDX_USER_ID  PRIMARY KEY (ID),
	CONSTRAINT USER_NAME_UNIQUE_KET UNIQUE (USER_NAME)
);

CREATE TABLE ROLE (
	ID BIGINT IDENTITY PRIMARY KEY,
	NAME VARCHAR(20) NOT NULL,
	DESCRIPTION VARCHAR(100),
	CONSTRAINT IDX_ROLE_ID  PRIMARY KEY (ID),
	CONSTRAINT ROLE_NAME_UNIQUE_KET UNIQUE (NAME)
);

CREATE TABLE USER_ROLE (
	USER_ID BIGINT NOT NULL,
	ROLE_ID BIGINT NOT NULL,
	FOREIGN KEY (USER_ID) REFERENCES USER (ID),
	FOREIGN KEY (ROLE_ID) REFERENCES ROLE (ID),
	PRIMARY KEY (USER_ID,ROLE_ID)
--	CONSTRAINT UNIQUE_UER_ROLE_ID UNIQUE(USER_ID,ROLE_ID)
);

CREATE TABLE CATEGORY (
	ID BIGINT IDENTITY PRIMARY KEY,
	NAME VARCHAR(20) NOT NULL,
	CREATED_DATE DATE DEFAULT CURRENT_TIMESTAMP NOT NULL,
	USER_ID BIGINT NOT NULL,
	FOREIGN KEY (USER_ID) REFERENCES USER (ID),
	CONSTRAINT IDX_CATEGORY_ID PRIMARY KEY (ID),
	CONSTRAINT CATEGORY_NAME_UNIQUE_KET UNIQUE (NAME)
);

CREATE TABLE POST (
	ID BIGINT IDENTITY PRIMARY KEY,
	TITLE VARCHAR(50) NOT NULL,
	BODY VARCHAR(1000) NOT NULL,
	CREATED_DATE DATE DEFAULT CURRENT_TIMESTAMP NOT NULL,
	CATEGORY_ID BIGINT NOT NULL,
	USER_ID BIGINT NOT NULL,
	FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID),
	FOREIGN KEY (USER_ID) REFERENCES USER (ID),
	CONSTRAINT IDX_POST_ID PRIMARY KEY (ID)
);