/* 사용자 */
CREATE TABLE t_user (
	user_no INTEGER NOT NULL, /* 회원번호 */
	email VARCHAR2(50), /* 이메일 */
	pass VARCHAR2(255), /* 비밀번호 */
	nick VARCHAR2(20), /* 닉네임 */
	name VARCHAR2(30), /* 이름 */
	bir VARCHAR2(20), /* 생년월일 */
	gender VARCHAR2(6), /* 성별 */
	auth_cd VARCHAR2(4), /* 권한코드 */
	gb_del VARCHAR2(1) /* 탈퇴여부 */
);

CREATE UNIQUE INDEX PK_t_user
	ON t_user (
		user_no ASC
	);

ALTER TABLE t_user
	ADD
		CONSTRAINT PK_t_user
		PRIMARY KEY (
			user_no
		);

/* 공통코드 */
CREATE TABLE t_code (
	cd_id VARCHAR2(4) NOT NULL, /* 코드ID */
	cd_nm VARCHAR2(50), /* 코드명 */
	gb_using VARCHAR2(1), /* 사용여부 */
	cd_des VARCHAR2(255) /* 코드설명 */
);

CREATE UNIQUE INDEX PK_t_code
	ON t_code (
		cd_id ASC
	);

ALTER TABLE t_code
	ADD
		CONSTRAINT PK_t_code
		PRIMARY KEY (
			cd_id
		);

/* 게시판 */
CREATE TABLE t_board (
	bd_no INTEGER NOT NULL, /* 글번호 */
	bd_title VARCHAR2(30), /* 제목 */
	user_no INTEGER, /* 회원번호 */
	nick VARCHAR2(20), /* 작성자 */
	bd_content VARCHAR2(1000), /* 내용 */
	bd_wdt DATE, /* 작성일 */
	bd_hit INTEGER, /* 조회수 */
	bd_like INTEGER, /* 좋아요수 */
	gb_del VARCHAR2(1) /* 삭제여부 */
);

CREATE UNIQUE INDEX PK_t_board
	ON t_board (
		bd_no ASC
	);

ALTER TABLE t_board
	ADD
		CONSTRAINT PK_t_board
		PRIMARY KEY (
			bd_no
		);

/* 게시판댓글 */
CREATE TABLE t_board_re (
	re_no INTEGER NOT NULL, /* 댓글번호 */
	bd_no INTEGER, /* 글번호 */
	user_no INTEGER, /* 회원번호 */
	nick VARCHAR2(20), /* 작성자 */
	re_content VARCHAR2(100), /* 댓글내용 */
	re_wdt DATE, /* 댓글작성일 */
	gb_del VARCHAR2(1) /* 삭제여부 */
);

CREATE UNIQUE INDEX PK_t_board_re
	ON t_board_re (
		re_no ASC
	);

ALTER TABLE t_board_re
	ADD
		CONSTRAINT PK_t_board_re
		PRIMARY KEY (
			re_no
		);

/* 공감테이블 */
CREATE TABLE t_like (
	bd_no INTEGER NOT NULL, /* 글번호 */
	user_no INTEGER NOT NULL, /* 회원번호 */
	like_cnt INTEGER /* 공감수 */
);

CREATE UNIQUE INDEX PK_t_like
	ON t_like (
		bd_no ASC,
		user_no ASC
	);

ALTER TABLE t_like
	ADD
		CONSTRAINT PK_t_like
		PRIMARY KEY (
			bd_no,
			user_no
		);

/* 첨부파일 */
CREATE TABLE t_att (
	att_no INTEGER NOT NULL, /* 첨부파일번호 */
	user_no INTEGER, /* 회원번호 */
	COL VARCHAR2(50) /* 첨부파일명 */
);

CREATE UNIQUE INDEX PK_t_att
	ON t_att (
		att_no ASC
	);

ALTER TABLE t_att
	ADD
		CONSTRAINT PK_t_att
		PRIMARY KEY (
			att_no
		);

ALTER TABLE t_board
	ADD
		CONSTRAINT FK_t_user_TO_t_board
		FOREIGN KEY (
			user_no
		)
		REFERENCES t_user (
			user_no
		);

ALTER TABLE t_board_re
	ADD
		CONSTRAINT FK_t_user_TO_t_board_re
		FOREIGN KEY (
			user_no
		)
		REFERENCES t_user (
			user_no
		);

ALTER TABLE t_board_re
	ADD
		CONSTRAINT FK_t_board_TO_t_board_re
		FOREIGN KEY (
			bd_no
		)
		REFERENCES t_board (
			bd_no
		);

ALTER TABLE t_like
	ADD
		CONSTRAINT FK_t_board_TO_t_like
		FOREIGN KEY (
			bd_no
		)
		REFERENCES t_board (
			bd_no
		);

ALTER TABLE t_like
	ADD
		CONSTRAINT FK_t_user_TO_t_like
		FOREIGN KEY (
			user_no
		)
		REFERENCES t_user (
			user_no
		);

ALTER TABLE t_att
	ADD
		CONSTRAINT FK_t_user_TO_t_att
		FOREIGN KEY (
			user_no
		)
		REFERENCES t_user (
			user_no
		);
		
	