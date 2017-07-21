--������ �� DB TABLE, tp_account, tp_picboard, tp_priboard, tp_visboard
--������ �� SEQUENCE tp_picboard_seq, tp_priboard_seq, tp_visboard_seq
DROP SEQUENCE tp_visboard_seq;
DROP SEQUENCE tp_priboard_seq;
DROP SEQUENCE tp_picboard_seq;
DROP SEQUENCE tp_account_seq;
DROP TABLE tp_visboard;
DROP TABLE tp_priboard;
DROP TABLE tp_picboard;
DROP TABLE tp_account;

CREATE TABLE tp_account(
	user_id NUMBER(5) PRIMARY KEY,
	id VARCHAR2(30) NOT NULL UNIQUE,
	pwd VARCHAR2(30) NOT NULL,
	name VARCHAR2(30) NOT NULL,
	gender VARCHAR2(2) NOT NULL CHECK(gender IN ('M', 'F')),
	phone VARCHAR2(30) NOT NULL,
	email VARCHAR2(30) NOT NULL,
	create_date DATE DEFAULT SYSDATE NOT NULL,
	today NUMBER(9) DEFAULT 0 NOT NULL
);

CREATE SEQUENCE tp_account_seq;

CREATE TABLE tp_picboard(
	user_id NUMBER(5) REFERENCES tp_account(user_id),
	cont_id NUMBER(5) PRIMARY KEY,
	content_title VARCHAR2(50) NOT NULL,
	content_content VARCHAR2(300),
	pic VARCHAR2(100) NOT NULL,
	view_count NUMBER(9) DEFAULT 0 NOT NULL,
	content_date DATE DEFAULT SYSDATE NOT NULL
);

CREATE SEQUENCE tp_picboard_seq;

CREATE TABLE tp_priboard(
	user_id NUMBER(5) REFERENCES tp_account(user_id),
	cont_id NUMBER(5) PRIMARY KEY,
	content_title VARCHAR2(50) NOT NULL,
	content_content VARCHAR2(300),
	view_count NUMBER(9) DEFAULT 0 NOT NULL,
	content_date DATE DEFAULT SYSDATE NOT NULL
);

CREATE SEQUENCE tp_priboard_seq;

CREATE TABLE tp_visboard(
	user_id NUMBER(5) REFERENCES tp_account(user_id),
	writer_id NUMBER(5) REFERENCES tp_account(user_id),
	cont_id NUMBER(5) PRIMARY KEY,
	content VARCHAR2(100) NOT NULL,
	content_date DATE DEFAULT SYSDATE NOT NULL
);

CREATE SEQUENCE tp_visboard_seq;
	

