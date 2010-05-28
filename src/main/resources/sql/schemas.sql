CREATE TABLE DEPARTMENT (
    ID bigint identity primary key,  
    NAME varchar(50) not null,
    LOCATION varchar(50) not null,
	CONSTRAINT IDX_DEPARTMENT_ID PRIMARY KEY (ID)
);

INSERT INTO DEPARTMENT (NAME, LOCATION) values ('IT', 'abc 123');
INSERT INTO DEPARTMENT (NAME, LOCATION) values ('DEV', 'def 567');