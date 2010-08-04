INSERT INTO DEPARTMENT (NAME, LOCATION) VALUES ('IT', 'abc 123');
INSERT INTO DEPARTMENT (NAME, LOCATION) VALUES ('DEV', 'def 567');
INSERT INTO EMPLOYEE (FIRST_NAME, LAST_NAME, AGE, DEPARTMENT_ID) VALUES ('John', 'Smith', 20, 1);
INSERT INTO EMPLOYEE (FIRST_NAME, LAST_NAME, AGE, DEPARTMENT_ID) VALUES ('Kate', 'Williams', 22, 1);
INSERT INTO INSURANCE_POLICY (ISSURER, POLICY_NUMBER, VALID, EMPLOYEE_ID) VALUES ('SUN-LIFE', 'SUN-LIFE-1234567890', '1', 1);
INSERT INTO INSURANCE_POLICY (ISSURER, POLICY_NUMBER, VALID, EMPLOYEE_ID) VALUES ('MANULIFE', 'MANULIFE-1234567890', '1', 1);
INSERT INTO ROLE (NAME, DESCRIPTION) VALUES ('ROLE_ADMIN', 'admin''s role');
INSERT INTO ROLE (NAME, DESCRIPTION) VALUES ('ROLE_USER', 'normal user''s role');
INSERT INTO ROLE (NAME, DESCRIPTION) VALUES ('ROLE_MANAGER', 'manger''s role');
INSERT INTO ROLE (NAME, DESCRIPTION) VALUES ('ROLE_EMPLOYEE', 'employee''s role');
INSERT INTO ROLE (NAME, DESCRIPTION) VALUES ('ROLE_EMPLOYER', 'employer''s role');
INSERT INTO ROLE (NAME, DESCRIPTION) VALUES ('ROLE_HR', 'HR''s role');
INSERT INTO USER (USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, GENDER, AGE, BIO, HOBBIES, HOME_PAGE) VALUES ('johnsmith', '45358dd8587f2de278ec7411a560bae78720c13aaa369d0cd95b67715adb445c', 'John', 'Smith', '1', 20, 'No bio yet', 'Music, Traveling, Party', 'www.jsmith.com');
INSERT INTO USER (USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, GENDER, AGE, BIO, HOBBIES, HOME_PAGE) VALUES ('jonesmith', 'cb30d6d3fe7fb16c0e79c199e4897f894fac4c79f99451e479e5e5a53a46d929', 'Jone', 'Smith', '0', 20, 'No bio yet', 'Dancing', 'www.jones.com');
INSERT INTO USER (USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, GENDER, AGE, BIO, HOBBIES, HOME_PAGE) VALUES ('jackwilliams', '41c30fe7d3e9036de0dd10630d91ecb4d2713277a92c563fb4419d861be7681c', 'Jack', 'Williams', '1', 30, 'born in 1980', 'Singing', 'www.jwilliams.com');
INSERT INTO USER (USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, GENDER, AGE, BIO, HOBBIES, HOME_PAGE) VALUES ('joelee', 'cf707bb196a16c156c9e79ef0d198d5222d1a6cc456a318e26bbc3b993250bfd', 'Joe', 'Lee', '1', 40, 'born in 1970', 'Hiking', 'www.jlee.com');
INSERT INTO USER (USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, GENDER, AGE, BIO, HOBBIES, HOME_PAGE) VALUES ('danblack', '27d6362e995af3d67e9ccc0375ddbc61a54f5efe0988f07ceb96eeef88a4ae97', 'Dan', 'Black', '1', 50, 'born in 1960', 'Reading', 'www.dblack.com');
INSERT INTO USER (USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, GENDER, AGE, BIO, HOBBIES, HOME_PAGE) VALUES ('peterjohnson', '97bdc4af4bf8a4fe389f7c52c9539c69d1c86e2dce60bcb3bfb361a4f87be31e', 'Peter', 'Johnson', '1', 60, 'born in 1950', 'Cooking', 'www.pjohnson.com');
INSERT INTO USER (USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, GENDER, AGE, BIO, HOBBIES, HOME_PAGE) VALUES ('mikeclinton', 'c36ff38a8119fc9db3a6d226cc443fde8417aa270c78a431c21c8762afa4d700', 'Mike', 'Clinton', '1', 70, 'No bio yet', 'Sleeping', 'www.mclinton.com');
INSERT INTO USER (USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, GENDER, AGE, BIO, HOBBIES, HOME_PAGE) VALUES ('timbush', '8b0a9c7ddee1e2ffbe4024cf93edc1c3bc271edf92fd322fe05629fe62c16801', 'Tim', 'Bush', '1', 80, 'No bio yet', 'Programming', 'www.tbush.com');
INSERT INTO USER (USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, GENDER, AGE, BIO, HOBBIES, HOME_PAGE) VALUES ('donniejackson', 'f7fd362f3159c3855e588ebe94c2e83141d0e6608390dc34fc77aadada3f4f11', 'Donnie', 'Jackson', '1', 30, 'No bio yet', 'Gambling', 'www.djackson.com');
INSERT INTO USER (USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, GENDER, AGE, BIO, HOBBIES, HOME_PAGE) VALUES ('katechurchil', '57655a1d30833f7111e1e9559defeee223b1227ad3b51dc37dd81045e5503e60', 'Kate', 'Churchil', '0', 40, 'No bio yet', 'Eating', 'www.kchurchil.com');
INSERT INTO CATEGORY (NAME, USER_ID) VALUES ('JAVA', 2);
INSERT INTO CATEGORY (NAME, USER_ID) VALUES ('.NET', 1);
INSERT INTO CATEGORY (NAME, USER_ID) VALUES ('FLEX', 4);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 2);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 3);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 4);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 5);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 6);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (2, 1);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (3, 2);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (4, 2);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (5, 2);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (6, 2);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (7, 2);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (8, 2);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (9, 2);
INSERT INTO POST (TITLE, BODY, CATEGORY_ID, USER_ID) VALUES ('Spring', 'Spring framework introduction', 1, 2);