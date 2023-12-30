show databases;

-- metadb 라는 데이터베이스 생성
create DATABASE metadb;

-- 생성한 metadb 데이버베이스 실행
use metadb;

create TABLE Book(  -- maria db는 대소문자를 구분하므로 테이블 첫글자를 대문자로 한다. (JPA 사용 목적)
    id BIGINT auto_increment primary key,   -- auto increment : 자동 증가
    title varchar(255),
    content varchar(255),
    author varchar(255)
);

-- character_set_database와 collation_database를 utf8로 바꿔줘야 한다. (한글 꺠짐 방지)
show variables like 'c%';

-- mb4는 이모지를 사용할 수 있게 해준다.
alter database metadb character set ='utf8mb4' collate = 'utf8mb4_general_ci';

SELECT * FROM Book;