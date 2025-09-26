/*
 * 데이터 조작어 (DML - data manipulation language)
 * DML은 테이블의 데이터를 관리(조작)하기 위한 SQL의 한 부분이다. 
 * 데이터의 전체 생명주기, 즉, 생성 , 수정, 삭제를 담당하며, 가장 번번하게 사용되는 명령어들이다.
 * 
 * 1. INSERT : 테이블에 새로운 행(ROW)를 추가한다.
 * 2. UPDATE : 기존 행의 열 (COLUMN) 값을 수정한다.
 * 3. DELETE : 테이블에서 특정 행을 삭제한다.
 * */

/*
 * INSERT 
 * 'CREATE TABLE'이 데이터의 뼈대(설계도)를 만드는 작업이었다면,
 * 'INSERT'는 이 뼈대에 살(데이터)를 붙여넣는 작업이다.
 * 
 * INSERT 구문은 테이블에 정의된 데이터 타입과 제약 조건이라는 규칙을 철저히 검사받는다.
 * 만약 규칙에 어긋나는 데이터를 삽입하려고 시도라면 데이터베이스의 "자동 경찰"역할을 하는
 * 제약 조건이 동작하여 오류를 발생시키도 데이터를 보호한다.
 * 이를 통해 데이터의 일관성과 무셜성이 유지된다.
 * */

/*
 * 제약 조건은 언제 동작하는가
 * 이전 챕터에서 테이블에 지정한 'UNIQUE', 'NOT NULL', 'FOREIGN KEY'등의 제약조건을 배치했다.
 * 이 제약조건은 'INSERT', 'UPDATE' 등 데이터의 변경이 일어나는 모든 순간에 깨어나게 된다. 
 * */

INSERT INTO `USERS`(`email`, `name`) VALUES ("educator@example.com", "김교육");
INSERT INTO `USERS`(`email`, `name`, `status`) VALUES ("learner@example.com", "이학습", "test");

SELECT * FROM users;

-- error (Unique 위배)
-- INSERT INTO `USERS`(`email`, `name`) VALUES ("educator@example.com", "김중복");

-- error : name 값도 줘야해 ! (not null을 위배)
-- INSERT INTO `USERS` (`email`) VALUES("noname@example.com");

INSERT INTO `courses` (`author_id`, `title`, `description`)
VALUES (1, "introduction to sql", "데이터베이스의 기초부터 시작하는 SQL 입문 과정");

SELECT * FROM courses;

-- error(참조 에러)
-- INSERT INTO `courses` (`author_id`, `title`, `description`)
-- VALUES (999, "introduction to sql", "데이터베이스의 기초부터 시작하는 SQL 입문 과정");


DELETE FROM courses;
DELETE FROM users;

SELECT * FROM users;

INSERT INTO `USERS`(`email`, `name`) VALUES ("educator@example.com", "김교육");
INSERT INTO `USERS`(`email`, `name`) VALUES ("learner@example.com", "이학습");

SELECT * FROM users;
SELECT * FROM courses;
SELECT * FROM enrollments;

-- 외래키 제약조건 해제
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE enrollments;
TRUNCATE TABLE courses;
TRUNCATE TABLE users;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `USERS`(`email`, `name`) VALUES ("educator@example.com", "김교육");
INSERT INTO `USERS`(`email`, `name`) VALUES ("learner@example.com", "이학습");
SELECT * FROM users;


INSERT INTO `courses` (`author_id`, `title`, `description`)
VALUES (1, "introduction to sql", "데이터베이스의 기초부터 시작하는 SQL 입문 과정");

INSERT INTO `enrollments` (`user_id`, `course_id`) VALUES (2,1);
SELECT * FROM users;

SELECT * FROM `enrollments`;
SELECT * FROM `courses`;
SELECT * FROM `users`;



/*
 * update 
 * 
 * update는 이미 존재하는 행(row)의 데이터를 새로운 값으로 변경하는 명령어이다.
 * "이학습" 학생이 이름을 "이성장"으로 개명했거나, 과정의 설명이 변경되었을 때 사용한다.
 * 
 * update문에서 where절을 생략하면, 테이블의 모든 행이 변경되는 대참사가 발생한다.
 * where절은 update의 대앗을 명확히 지정하는 안전장치이다.
 * update를 실행하기 이전에 동일한 where절로 select를 먼저 실행하여 변경 대상을 정확하게 확인해야한다.
 * */

SELECT * FROM users WHERE user_id = 2;

UPDATE `users`
	SET `name` = "이성장" -- 여기서 끝내면 모든 데이터의 name이 "이성장"으로 변경이 된다.
	WHERE `user_id` = 2;

SELECT * FROM users WHERE user_id = 2;



/*
 * delete는 테이블에서 특정 행을 삭제하는 명령어이다. 
 * 사용자가 탈퇴했거나 과정이 폐강되었을 때 사용한다
 * 
 * update와 동일하게 중요한 경고
 * delete문에서 where절을 생략하면 테이블의 모든 데이터가 삭제된다.
 * 복구가 매우 어렵기 때문에 where절을 반드기 사용하여 삭제 대상을 명확하게 해야한다.
 * */

INSERT INTO `users` (`email`, `name`) VALUES ("test@gmail.com", "삭제");
SELECT * FROM users; 

DELETE FROM `users` WHERE user_id = 3;

SELECT * FROM users;


/*
  과제 1 (INSERT):
  - '신규수강생'이라는 이름과 '' 이메일을 가진 사용자를 추가하라.
  - '김교육' 사용자가 'Introduction to Git'이라는 제목의 새로운 과정을 'draft' 상태로 개설하도록 추가하라.

  과제 2 (UPDATE):
  - `user_id`가 2인 '이성장' 학생의 이메일 주소를 ''으로 수정하라.
  - 'Introduction to Git' 과정의 상태를 'published'로 변경하라.

  과제 3 (DELETE):
  - '신규수강생'을 `users` 테이블에서 삭제하라.
    (힌트: 먼저 해당 사용자의 `user_id`를 `SELECT`로 확인해야 한다.)

  과제 4 (생각해보기):
  - `user_id`가 2인 '이성장' 학생은 `enrollments` 테이블에서 참조되고 있다.
    그런데 왜 `DELETE` 시도 시 에러가 발생하지 않았던 '김교육' 사용자와 달리,
    '신규수강생'은 아무 문제 없이 삭제되었을까?
*/

-- 과제 1번
INSERT INTO `users` (`email`, `name`) VALUES ("", "신규수강생");
SELECT * FROM users;

INSERT INTO `courses`(`author_id`, `title`) VALUES (1,"Introduction to Git");
SELECT * FROM courses;

-- 과제 2번
UPDATE `users` SET `email` = '' WHERE `user_id` = 2; -- 문제 오류 !! 이메일이 중복되어서 수정이 안됨.
SELECT * FROM users;

UPDATE `courses` SET `status` = "published" WHERE `title` = "Introduction to Git";
SELECT * FROM courses;

-- 과제 3번
SELECT * FROM users;
DELETE FROM `users` WHERE `name` = "신규수강생";
SELECT * FROM users;

-- 과제 4번
/*
 * `user_id`가 2인 '이성장' 학생은 `enrollments` 테이블에서 참조되고 있다.
    그런데 왜 `DELETE` 시도 시 에러가 발생하지 않았던 '김교육' 사용자와 달리,
    '신규수강생'은 아무 문제 없이 삭제되었을까?
    
    -- `이성장`은 enrollments의 테이블에 참조되어져 있고, 
    -- `김교육`은 courses에 참조되어있다.
    -- 반면에 `신규수강생`은 다른 테이블과 참조관계를 가지지 않고 있어 삭제시 참조 오류가 발생하지 않는 것이다.
 * */
SELECT * FROM enrollments;

