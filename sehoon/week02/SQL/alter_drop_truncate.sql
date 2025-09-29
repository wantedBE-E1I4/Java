/*
 * 소프트웨어는 살아있는 유기체와 같다
 * 서비스는 계속해서 변하고, 그에 따라 저장해야 하는 데이터의 종류도 바뀐다.
 * 과정에 수강료 정보를 새로 추가하거나, 사용자 이름의 글자 수를 늘려야하는 등 비즈니스의 요구사항은 끊임없이 진화한다.
 * 
 * alter table은 이처럼 이미 만들어진 테이블의 설계도를 수정할 수 있도록 해주는 강력한 명령어이다
 * drop과 truncate는 테이브르이 데이터를 제거하는 각기 다른 방식을 제공한다.
 * */

CREATE TABLE courses_temp AS SELECT * FROM courses;

DESC courses_temp;

ALTER TABLE courses_temp
ADD COLUMN price int NOT NULL DEFAULT 0;

DESC courses_temp;
-- 

ALTER TABLE courses_temp
MODIFY COLUMN title varchar(500) NOT NULL;

DESC courses_temp;

-- 

ALTER TABLE courses_temp
DROP COLUMN status;

DESC courses_temp;


/*
 * 이론: DELETE, TRUNCATE, DROP의 결정적 차이 (The "Why")
 *
 * 세 명령어 모두 데이터를 삭제하지만, 그 방식과 범위, 복구 가능성이 완전히 다르다.
 *
 * - DELETE FROM table_name WHERE ...:
 * - DML(데이터 조작어). 행(Row) 단위로 삭제. WHERE 절로 특정 행만 삭제 가능.
 * - 느리다. 삭제 기록(로그)을 남기므로 롤백(ROLLBACK)으로 복구 가능.
 *
 * - TRUNCATE TABLE table_name:
 * - DDL(데이터 정의어). 테이블의 구조는 남기고, 내부의 모든 데이터를 한 번에 삭제.
 * - 매우 빠르다. 삭제 기록을 거의 남기지 않아 롤백 불가. 테이블을 초기화할 때 사용.
 *
 * - DROP TABLE table_name:
 * - DDL(데이터 정의어). 테이블의 데이터와 구조 자체를 영구적으로 삭제.
 * - 매우 빠르다. 롤백 불가. 테이블의 존재 자체가 사라지므로 복구가 매우 어렵다.
 * 반드시 신중하게 사용해야 한다.
 */


-- [실습 2-1] TRUNCATE - 테이블의 모든 데이터 삭제 (초기화)
-- `TRUNCATE`는 테이블 구조는 그대로 둔 채, 내부의 모든 행을 삭제한다.
TRUNCATE TABLE courses_temp;

-- [확인 1] 데이터가 모두 사라졌는지 확인한다. (결과: 0개 행)
SELECT * FROM courses_temp;

-- [확인 2] 테이블 구조는 그대로 남아있는지 확인한다. (`DESC`는 정상 동작)
DESC courses_temp;


-- [실습 2-2] DROP - 테이블 영구 삭제
-- `DROP TABLE` 명령어로 임시 테이블을 완전히 삭제한다.
DROP TABLE courses_temp;

-- [확인 3] 테이블이 사라졌는지 확인한다.
-- 아래 쿼리는 'Table 'WANTED_LMS.courses_temp' doesn't exist' 에러를 발생시킨다.
SHOW TABLES LIKE 'courses_temp%';
-- DESC courses_temp; -- 이 쿼리 또한 에러를 발생시킨다.


/*
  과제 1:
  - `users` 테이블의 구조와 데이터를 복사하여 `users_temp` 테이블을 생성하라.

  과제 2 (`ALTER`):
  - `users_temp` 테이블에 `phone_number`라는 이름의 `VARCHAR(20)` 타입 컬럼을 추가하라.
  - `users_temp` 테이블의 `name` 컬럼의 데이터 타입을 `VARCHAR(100)`에서 `VARCHAR(150)`으로 수정하라.
  - `users_temp` 테이블의 `password_hash` 컬럼을 삭제하라.

  과제 3 (`TRUNCATE` vs `DROP`):
  - `users_temp` 테이블의 모든 데이터를 `TRUNCATE` 명령어로 삭제하고,
    `SELECT *`와 `DESC`를 통해 결과를 확인하라.
  - 그 다음, `users_temp` 테이블을 `DROP` 명령어로 완전히 삭제하고,
    `SHOW TABLES`를 통해 테이블이 사라졌는지 최종 확인하라.
*/

--   과제 1:
--   - `users` 테이블의 구조와 데이터를 복사하여 `users_temp` 테이블을 생성하라.

CREATE TABLE users_temp SELECT * FROM users;
SELECT * FROM users_temp;


--   과제 2 (`ALTER`):
--   - `users_temp` 테이블에 `phone_number`라는 이름의 `VARCHAR(20)` 타입 컬럼을 추가하라.
--   - `users_temp` 테이블의 `name` 컬럼의 데이터 타입을 `VARCHAR(100)`에서 `VARCHAR(150)`으로 수정하라.
--   - `users_temp` 테이블의 `password_hash` 컬럼을 삭제하라.

ALTER TABLE users_temp
ADD COLUMN phone_number varchar(20);


ALTER TABLE users_temp
MODIFY COLUMN name varchar(150);

ALTER TABLE users_temp
DROP COLUMN password_hash;

DESC users_temp;

-- 
--   과제 3 (`TRUNCATE` vs `DROP`):
--   - `users_temp` 테이블의 모든 데이터를 `TRUNCATE` 명령어로 삭제하고,
--     `SELECT *`와 `DESC`를 통해 결과를 확인하라.
--   - 그 다음, `users_temp` 테이블을 `DROP` 명령어로 완전히 삭제하고,
--     `SHOW TABLES`를 통해 테이블이 사라졌는지 최종 확인하라.

TRUNCATE users_temp;

SELECT * FROM users_temp;

DROP TABLE users_temp;

SHOW TABLES;


