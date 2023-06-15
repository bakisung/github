/* 회원 */
CREATE TABLE member (
   id VARCHAR2(50) NOT NULL, /* ID */
   pwd VARCHAR2(75), /* 비밀번호 */
   email VARCHAR2(60), /* 이메일 */
   picture VARCHAR2(200), /* 프로필사진경로 */
   enabled NUMBER, /* ID사용여부 */
   regdate DATE, /* 등록일 */
   phone VARCHAR2(35), /* 핸드폰번호 */
   name VARCHAR2(20), /* 이름 */
   register VARCHAR2(50), /* 등록자 */
   address VARCHAR2(200), /* 주소 */
   authority VARCHAR2(50) /* 권한 */
);

CREATE UNIQUE INDEX PK_member
   ON member (
      id ASC
   );

ALTER TABLE member
   ADD
      CONSTRAINT PK_member
      PRIMARY KEY (
         id
      );

/* 게시판 */
CREATE TABLE board (
   bno NUMBER NOT NULL, /* 게시글번호 */
   title VARCHAR2(300), /* 제목 */
   writer VARCHAR2(50), /* 작성자ID */
   content VARCHAR2(3200), /* 내용 */
   regdate DATE, /* 등록일 */
   viewcnt NUMBER, /* 조회수 */
   updatedate DATE /* 수정일 */
);

CREATE UNIQUE INDEX PK_board
   ON board (
      bno ASC
   );

ALTER TABLE board
   ADD
      CONSTRAINT PK_board
      PRIMARY KEY (
         bno
      );

/* 댓글 */
CREATE TABLE reply (
   rno NUMBER NOT NULL, /* 댓글번호 */
   bno NUMBER, /* 게시글번호 */
   REPLYER VARCHAR2(50), /* 작성자 */
   replytext VARCHAR2(600), /* 댓글내용 */
   regdate DATE, /* 등록일 */
   updatedate DATE /* 수정일 */
);

CREATE UNIQUE INDEX PK_reply
   ON reply (
      rno ASC
   );

ALTER TABLE reply
   ADD
      CONSTRAINT PK_reply
      PRIMARY KEY (
         rno
      );

/* 메뉴 */
CREATE TABLE menu (
   mcode VARCHAR2(30) NOT NULL, /* 메뉴코드 */
   mname VARCHAR2(40), /* 메뉴명 */
   murl VARCHAR2(150), /* 메뉴url */
   micon VARCHAR2(100), /* 메뉴아이콘 */
   upcode VARCHAR2(30), /* 상위메뉴코드 */
   mlevel NUMBER, /* 메뉴레벨 */
   isnav NUMBER /* 네비게이션여부 */
);

CREATE UNIQUE INDEX PK_menu
   ON menu (
      mcode ASC
   );

ALTER TABLE menu
   ADD
      CONSTRAINT PK_menu
      PRIMARY KEY (
         mcode
      );

/* 자료실 */
CREATE TABLE pds (
   pno NUMBER NOT NULL, /* 게시글번호 */
   title VARCHAR2(300), /* 제목 */
   writer VARCHAR2(50), /* 작성자 */
   content VARCHAR2(3800), /* 내용 */
   viewcnt NUMBER, /* 조회수 */
   regdate DATE, /* 등록일 */
   updatedate DATE, /* 수정일 */
   startdate DATE, /* 게시물접근허용시작일 */
   enddate DATE /* 게시물접근허용종료일 */
);

CREATE UNIQUE INDEX PK_pds
   ON pds (
      pno ASC
   );

ALTER TABLE pds
   ADD
      CONSTRAINT PK_pds
      PRIMARY KEY (
         pno
      );

/* 첨부파일 */
CREATE TABLE attach (
   ano NUMBER NOT NULL, /* 첨부파일번호 */
   uploadpath VARCHAR2(500), /* 첨부파일업로드경로 */
   filename VARCHAR2(200), /* 첨부파일명 */
   filetype VARCHAR2(20), /* 첨부파일형식 */
   pno NUMBER, /* 게시글번호 */
   attacher VARCHAR2(50), /* 첨부파일등록자 */
   regdate DATE /* 등록일 */
);

CREATE UNIQUE INDEX PK_attach
   ON attach (
      ano ASC
   );

ALTER TABLE attach
   ADD
      CONSTRAINT PK_attach
      PRIMARY KEY (
         ano
      );

ALTER TABLE board
   ADD
      CONSTRAINT FK_member_TO_board
      FOREIGN KEY (
         writer
      )
      REFERENCES member (
         id
      );

ALTER TABLE reply
   ADD
      CONSTRAINT FK_member_TO_reply
      FOREIGN KEY (
         REPLYER
      )
      REFERENCES member (
         id
      );

ALTER TABLE reply
   ADD
      CONSTRAINT FK_board_TO_reply
      FOREIGN KEY (
         bno
      )
      REFERENCES board (
         bno
      );

ALTER TABLE menu
   ADD
      CONSTRAINT FK_menu_TO_menu
      FOREIGN KEY (
         upcode
      )
      REFERENCES menu (
         mcode
      );

ALTER TABLE pds
   ADD
      CONSTRAINT FK_member_TO_pds
      FOREIGN KEY (
         writer
      )
      REFERENCES member (
         id
      );

ALTER TABLE attach
   ADD
      CONSTRAINT FK_pds_TO_attach
      FOREIGN KEY (
         pno
      )
      REFERENCES pds (
         pno
      );

ALTER TABLE attach
   ADD
      CONSTRAINT FK_member_TO_attach
      FOREIGN KEY (
         attacher
      )
      REFERENCES member (
         id
      );