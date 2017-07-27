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
	today NUMBER(9) DEFAULT 0 NOT NULL,
	profile_img CLOB, -- 기본 가입시 default 이미지로 아무거나 넣어줄거임
    profile_cmt VARCHAR2(300)
);

CREATE SEQUENCE tp_account_seq;

CREATE TABLE tp_picboard(
	user_id NUMBER(5) REFERENCES tp_account(user_id),
	cont_id NUMBER(5) PRIMARY KEY,
	content_title VARCHAR2(50) NOT NULL,
	content_content CLOB,
	pic CLOB NOT NULL,
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
	

-- comment ------------------------------------------------ 
CREATE TABLE tp_priboard_comment(
    num NUMBER PRIMARY KEY, --덧글의 글번호 
    user_id NUMBER(5) REFERENCES tp_account(user_id), -- 작성자 ${id}
    writer  VARCHAR2(30) NOT NULL, -- 작성자 ${info.name}
    content VARCHAR2(500),
    ref_group NUMBER, -- 덧글 그룹. 원글의 con_id를 넣는다.
    comment_group NUMBER, -- 덧글 내에서의 그룹
    regdate DATE DEFAULT SYSDATE NOT NULL,
    profile_img CLOB
);

CREATE TABLE tp_picboard_comment(    
    num NUMBER PRIMARY KEY, --덧글의 글번호 
    user_id NUMBER(5) REFERENCES tp_account(user_id), -- 작성자  ${id}
    writer  VARCHAR2(30) NOT NULL, -- 작성자 ${info.name}
    content VARCHAR2(500),
    ref_group NUMBER, -- 덧글 그룹
    comment_group NUMBER, -- 덧글 내에서의 그룹
    regdate DATE DEFAULT SYSDATE NOT NULL,
    profile_img CLOB
);

CREATE SEQUENCE tp_priboard_comment_seq NOCACHE;
CREATE SEQUENCE tp_picboard_comment_seq NOCACHE;

select * from tp_priboard_comment;
DROP TABLE tp_priboard_comment;
DROP TABLE tp_picboard_comment;
select * from tp_account;
commit


