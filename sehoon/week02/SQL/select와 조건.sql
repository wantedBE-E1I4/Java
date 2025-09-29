/*
 * select 데이터베이스의 가장 중요한 질문
 * 
 * 지금까지 배운 DDL(create)롸 DML(insert, update, delete)는 데이터를 저장하고 관리하기 위한 
 * 준비 작업에 가깝다. 데이터베이스의 진짜 목적은 저장된 데이터를 활용하여 의미있는 점을 만들어내는 것에 있다.
 * 
 * select는 바로 이 데이터 활용을 담당하는 명령어이다.
 * 데이터베이스에 질문을 던져 원하는 답을 얻어내는 과정이며,
 * 전체 SQL 사용량의 90%를 차지할 만큼 압도적으로 중요하다.
 * 
 * select구문의 핵심은 두 가지이다.
 * 1. 어떤 열에서 가져올 것인가. (정보의 종류)
 * 2. 어던 행에서 가져올 것인가. (정보의 범위)
 * 
 * */


/*
 * '*'을 사용하여 모든 열 가져오기
 * *(에스터리스크)는 모든 열을 의미하는 와일드카드이다.
 * 테이브르이 전체 구조와 데이터를 빠르게 확인할 때 유용하다.
 * */
SELECT
		*
	FROM users;

/*
 * 특정 열을 지정하여 필요한 데이터만 가져오기
 * select 뒤에 원하는 컬럼 이름을 콤마(,)로 구분하여 나열한다.
 * 불필요한 데이터를 제외하고 필요한 정보만 가져오므로, select * 보다 효율적이고 바람직하다.
 * */
SELECT 
		name,
		email
	FROM users;


/*
 * 'AS' 키워드로 컬럼에 별칭 부여하기
 * as를 이용해 결과 화면에 표시될 컬럼의 이름을 바꿀 수 있다.
 * 복잡한 쿼리 결과의 가동성을 높이거나, 다른 시스템과 데이터를 연돌할 때 형식을 맞추기 위해서 사용한다.
 * */
SELECT
		name AS "사용자 이름",
		email AS "이메일 주소",
    	created_at AS "가입일"
 	FROM users;


/*
 * where 어떤 행을 가져올 것인가?
 * where절은 sql의 심장과 같다. 수많ㅇ느 데이터 속에서 원하는 조건의 데이터만 정확하게 필터링하는 역할을 한다.
 * where을 얼마나 잘 사용하느냐에 따라 쿼리의 성능과 정확성이 결정된다.
 * 다양한 연산자를 조합하여 매우 정교한 필터일이 가능하다.
 * 
 * 테이블의 모든 행이 아니라, 특정 조건을 만족하는 행만 골라내고 싶을 때 'where'절을 사용한다.
 * where은 select 구문의 가장 강력한 필터링 도구이다.
 * 
 * where절에는 다양한 비교 연산자를 사용하여 조건을 명시할 수 있다.
 * = : 같다
 * !=, <> 다르다
 * > : 크다
 * < : 작다
 * >= : 크거나 같다
 * <= 작거나 같다
 * like : 특정패턴을 포함한다.
 * in : 목록 안의 값 중 하나와 일치한다.
 * between : 두 값 사이의 범위에 있다. 
 * */

-- 비교 연산자
SELECT
		user_id,
		status,
	FROM users
   WHERE status != "active";


SELECT
		user_id,
		name
	FROM users
   WHERE user_id > 10;

SELECT 
		user_id,
		name
	FROM users
   WHERE user_id < 10;

-- 범위 조건
-- 날짜가 같은 값을 찾으려고 하는 경우 아래와 같은 방식은 사용하지 않는다.
-- last_login_at = "2024-02-01"과 같이 비교연산자를 사용하면,
-- mysql은 문자열 2024-02-01을 datetime타입의 2024-02 00:00:00으로 자동 변환한다.
-- 이로 인해 시간까지 맞아야하는 문제가 발생하게 된다, 또한 데이터 베이스는 여기 저장시 마이크로초 단위까지 계산된다.

SELECT 
		*
	FROM users
   WHERE last_login_at = "2024-02-01";


SELECT
		*
	FROM users
   WHERE last_login_at = "2024-02-01 00:00:00";


SELECT
		*
	FROM users
   WHERE created_at BETWEEN "2024-02-01 00:00:00" AND "2024-02-01 23:59:59";


SELECT 
		user_id,
		name,
		created_at
	FROM users
   WHERE created_at BETWEEN "2024-02-01 00:00:00" AND "2024-02-29 23:59:59";


/*
 * 목록 조건 (in, not in)
 * in : 포함되어 있는지 확인하여 값을 조회
 * not in : 포함되지 않은 값을 기준으로 조회
 * */

SELECT 
		user_id,
		name,
		email
	FROM users
   WHERE user_id IN (1,5,10);


SELECT 
		 user_id,
	 	 name,
		 email
	FROM users
   WHERE user_id NOT BETWEEN 1 AND 5;

SELECT 
		user_id,
		name,
		email
	FROM users
   WHERE user_id NOT IN (1, 5);


/*
 * 패턴 매칭(like)
 * like : 특정 컬럼이 값이 지정한 패턴과 일치하는지를 확인하여 레코드를 조회할 때 사용된다.
 * % : 0개 이상의 모든 문자(와일드 카드)
 * - 김% : 김으로 시작하는 모든 문자열 (김철수, 김영희 등)
 * - %철수 : 철수로 끝나는 모든 문자열 (박철수, 김철수 등)
 * - %이% : '이'를 포함하는 모든 문자열 (이순신, 신바람이박사 등)
 * 
 * _ : 정확히 1개의 문자
 * 	- "김_수" : 김으로 시작하고 수로 끝나는 3글자 문자열(김철수, 김성수 등)
 * 
 * */

SELECT 
		 user_id,
		 name
	FROM users
	WHERE name LIKE "김%";



SELECT 
		  user_id,
		  name,
		  email
	FROM users
   WHERE email LIKE "%jae%";


SELECT 
		 user_id,
		 name
	FROM users
   WHERE name LIKE "권__";



/*
 * null 값 확인 (is null, is not null)
 * is null : 해당 컬럼의 값이 비어있는 (null) 레코드를 조회한다.
 * is not null : 해당 컬럼의 값이 비어있지 않은 (null이 아님) 레코드를 조회한다.
 * 
 * last_login_at 컬럼이 비어있는 (한 번도 로그인 하지 않은)사용하를 조회한다.
 * 중요 : where last_login_at = null은 동작하지 않는다.
 * 
 * */
DESC users;
INSERT INTO users (
	user_id,
	email,
	password_hash,
	name,
	status)
VALUES (121, "", "1212df", "김철민수", "active");

SELECT * FROM users WHERE user_id = 121;

SELECT
		 user_id,
		 name,
		 last_login_at
	FROM users
   WHERE last_login_at = NULL;


SELECT
		 user_id,
		 name,
		 last_login_at
	FROM users
   WHERE last_login_at IS NULL;


/*
 * 논리 연산자(and, or, not)
 * and : 모든 조건이 참일 때, 참을 반환
 * or : 둘 중 하나라도 조건이 참이면 참을 반환
 * not : 조건의 참 / 거짓을 반환
 * 
 * */

-- 2024년 3월 이후 가입했고(and) status가 active인 사용자를 조회한다.
SELECT 
		 user_id,
		 name,
		 status,
		 created_at
	FROM users
   WHERE created_at >= "2024-04-01"
   	 AND status = "active";


-- 성이 김이거나 혹은 활성화가 아닌 사용자
SELECT
		user_id,
		name,
		status,
		created_at
	FROM users
	WHERE name LIKE "김%"
	AND status != "active";


-- name like "김%"이거나 status가 false인 조건을 반전하여 아닌 대상을 찾음
SELECT 
		user_id,
		name,
		status,
		created_at
	FROM users
	WHERE NOT (name LIKE "김%" OR status = "active");


/*
 * ORDER BY 와 limit - 결과의 질서와 한계 부여하기
 * 
 * order by는 조회된 결과에 명확한 순서와 질서을 부여하는 필수 기능이다.
 * 최신 가입자 순, 이름 가나다 순 등으로 정렬된 데이터는 사용자가 정보를 훨씬 쉽게 인지하도록 돕는다.
 * 
 * limit는 조회 결과의 개수를 제한하는 기능이다.
 * 수백만 건의 데이터를 한 번에 조회하는 것을 비효율적이며 시스템에 큰 부하를 준다.
 * 
 * limit는 상위 5개만 보기 1페이지에 20개씩 보기 등
 * 우선 데이터는 저마다 각자 크기를 갖게되며 크기는 스키마의 크기에 따라 다르다.
 * 여기서 중요한 것은 크기를 갖는다는 것이다.
 * 
 * 1. 막대한 디스크 (I/O) : 데이터는 디스크에 저장되며 이는 CPU, ram에서 접근하는 것보다 현저하게 느리며 엄청난 양의 I/O작업을 유발한다.
 * 2. 과도한 메모리 사용 :
 * 			디스크에서 읽어온 데이터를 처리하기 위해 메모리에 로드하며 메모리가 부족해지는 문제가 발생할 수 있으며 이때 운영체제는 스와핑을 시작한다.
 * 			이때 사용하지 않는 메모리 페이지를 디스크로 내리고, 필요한 데이터를 다시 메모리로 불러오는 작업을 반복한다.
 * 			이 과정에서 디스크의 I/O를 더욱 증가시키고, 시스템을 훨씬 더 느리게 만드는 스로틀링 현상이 발생된다.
 * */

-- order by를 사용한 데이터 정렬
-- 모든 사용자를 가장 최근에 가입한 순서대로 정렬 "user_id", "name", "created_at"을 조회한다.
SELECT
		 user_id,
		 name,
		 created_at
	FROM users
   ORDER BY created_at DESC; 

-- 가장 최근에 가입한 사용자 5명의 정보 조회

SELECT
		user_id,
		name,
		created_at
	FROM users
   ORDER BY created_at -- 기본값은 내림차순 정렬이다.
   LIMIT 5;


SELECT
		user_id,
		name,
		created_at
	FROM users
   ORDER BY user_id ASC
   LIMIT 10, 10; -- 10번 제외하고 10개 ?


   -- =========================================================================================
-- 최종 종합 실습: 모든 구문 활용하기
-- =========================================================================================
-- [요구사항]
-- LXP 플랫폼의 운영팀에서 마케팅 이메일 발송 대상을 찾고 있다.
-- 1. 2024년 4월 또는 5월에 가입한 사용자여야 한다.
-- 2. 계정 상태(status)는 'active'여야 한다.
-- 3. 이메일 주소가 ''으로 끝나야 한다.
-- 4. 위 조건에 맞는 사용자들을 가장 최근에 가입한 순서(created_at 내림차순)로 정렬하여,
-- 5. 두 번째 페이지에 해당하는 5명(6번째 ~ 10번째)의 `user_id`, `name`, `email`, `created_at`을 조회하라.
DESC users;
   
SELECT 
 		 user_id,
		 name,
		 email,
		 created_at,
		 status
	FROM users
   WHERE created_at BETWEEN "2024-04-01" AND "2024-05-01"
         AND
         status = "active"
         AND
         email LIKE "%"
   ORDER BY created_at DESC;

   
   
/*
  과제 1 (`BETWEEN`, `AND`):
  - 2025년 9월 1일부터 9월 5일까지 마지막으로 로그인한 'active' 상태의 사용자를 모두 조회하라.
    (last_login_at 기준)

  과제 2 (`IN`, `NOT LIKE`):
  - '김씨' 또는 '이씨' 성을 가진 사용자 중에서,
    이메일에 ''이 포함되지 않는 사용자의 이름과 이메일을 조회하라.

  -- 스킵
  과제 3 (`IS NULL`, `ORDER BY`, `LIMIT`):
  - 자기소개(`bio`)를 아직 작성하지 않은 사용자 중에서,
    가장 먼저 가입한 5명의 `user_id`와 `created_at`을 조회하라.

  과제 4 (종합):
  - 'published' 상태인 과정 중에서,
    과정 제목(`title`)에 'Python' 또는 'SQL'이 포함되어 있고,
    `course_id`가 10보다 큰 과정을,
    `course_id`의 역순으로 정렬하여 상위 3개만 조회하라.
*/

-- 과제 1
SELECT 
		user_id,
		name,
		status,
		last_login_at
	FROM users
	WHERE last_login_at BETWEEN "2025-09-01" AND "2025-09-05"
	      AND
	      status = "active";

-- 과제 2
SELECT 
		name,
		email
	FROM users
	WHERE( name LIKE "김%"
		OR name LIKE "이%")
		AND email NOT LIKE "% %";

-- 과제 4
DESC courses;
SELECT
		course_id,
		title,
		status
	FROM courses
	WHERE status = "published"
		AND
		(title LIKE "%Python%"
		OR
		title LIKE "%SQL%")
		AND 
		course_id > 10
	ORDER BY course_id
	LIMIT 3;




SELECT * FROM users;




