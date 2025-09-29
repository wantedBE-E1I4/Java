-- =========================================================================================
-- 집계 함수 (Aggregate Functions) - 데이터를 하나의 값으로 요약하기
-- =========================================================================================
/*
 * 이론: 집계 함수란?
 * 여러 행의 데이터를 입력으로 받아 단 하나의 결과 값을 반환하는 함수이다.
 *
 * 주요 집계 함수
 * - COUNT(컬럼명) : 해당 컬럼의 데이터(행) 개수를 센다. (NULL은 제외)
 * - SUM(컬럼명)   : 해당 컬럼의 숫자 데이터의 합계를 계산한다.
 * - AVG(컬럼명)   : 해당 컬럼의 숫자 데이터의 평균을 계산한다.
 * - MAX(컬럼명)   : 해당 컬럼의 데이터 중 최댓값을 찾는다.
 * - MIN(컬럼명)   : 해당 컬럼의 데이터 중 최솟값을 찾는다.
 *
 * 중요한 특징: NULL 값 처리
 * - COUNT(컬럼명)을 제외한 모든 집계 함수 (SUM, AVG, MAX, MIN)는 기본적으로 NULL 값을 무시하고 계산에서 제외한다.
 * - COUNT(*)는 NULL 여부와 관계없이 모든 행의 개수를 센다.
 */

-- [실습 2-1] COUNT: 개수 세기
-- LXP 플랫폼의 전체 사용자 수를 계산한다.
-- `COUNT(*)`는 모든 행의 개수를 세므로 가장 간단하고 일반적인 방법이다.
SELECT
	   COUNT(*) AS '총 사용자 수'
  FROM users;

-- `user_profiles` 테이블에서 `bio`(자기소개)를 작성한 사용자는 몇 명인지 계산한다.
-- `COUNT(컬럼명)`은 해당 컬럼의 값이 NULL이 아닌 행의 개수만 센다.
SELECT
	   COUNT(bio) AS '자기소개 작성자 수'
  FROM user_profiles;

-- `courses` 테이블에 과정을 등록한 교육자는 총 몇 명인지 중복 없이 계산한다.
-- `COUNT(DISTINCT 컬럼명)`은 해당 컬럼에서 중복을 제거한 유일한 값의 개수를 센다.
SELECT
       COUNT(DISTINCT author_id) AS '과정을 등록한 교육자 수'
  FROM courses;

-- [실습 2-2] SUM, AVG, MAX, MIN: 숫자 데이터 집계
-- `grades` 테이블에서 모든 제출물의 총점과 평균 점수를 계산한다.
SELECT
    SUM(score) AS '총점',
    AVG(score) AS '평균 점수'
FROM grades;

-- 가장 높은 점수와 가장 낮은 점수는 몇 점인지 확인한다.
SELECT
    MAX(score) AS '최고 점수',
    MIN(score) AS '최저 점수'
FROM grades;


-- [에러 케이스] 비집계 컬럼과 집계 함수 동시 사용 (GROUP BY 없이)
-- 집계 함수는 여러 행의 값을 하나의 결과 값으로 요약한다.
-- 하지만 `SELECT` 절에 집계 함수와 함께 `GROUP BY` 절 없이 일반 컬럼(비집계 컬럼)을 함께 명시하면 에러가 발생한다.
-- 데이터베이스는 `name`과 같은 일반 컬럼을 각 행마다 반환해야 하는데, `COUNT(*)`와 같은 집계 함수는 전체 행에 대해 하나의 값만 반환하기 때문에,
-- 어떤 `name` 값을 `COUNT(*)`와 함께 묶어야 할지 알 수 없기 때문이다.
-- 이 문제를 해결하려면, `GROUP BY` 절을 사용하여 일반 컬럼을 기준으로 그룹을 묶어주어야 한다.
SELECT
    name,             -- 일반 컬럼 (비집계 컬럼)
    COUNT(*) AS '총 사용자 수' -- 집계 함수
FROM users;
/*
 * 예상 에러 (MySQL 기준):
 * ERROR 1140 (42000): In aggregated query without GROUP BY, expression #1 of SELECT list contains nonaggregated column ''; this is incompatible with sql_mode=only_full_group_by
 * 또는
 * ERROR 1055 (42000): Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column '' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
 *
 * 다른 RDBMS에서도 유사한 에러 메시지("not an aggregate function and not in GROUP BY clause")가 발생한다.
 */



/*
 * Group by 
 * 집계 합수만으로 전체에 대한 통계만 낼 수 있다.
 * 하지만 우리는 각 과정별 등록 학생 수, 사용자 상태별 인원수와 같이
 * 특정그룹에 대한 소계를 알고 싶을 때가 훨씬 많다
 * group by는 테이블의 데이터를 특정 컬럼을 기준으로 그룹을 묶고,
 * 각 그룹에 대해 집계 함수를 적용하여 소계를 계산하는 강력한 기능이다. 
 * 
 * */

SELECT 
		status,
		count(*) AS "사용자 수"
	FROM users
	GROUP BY status;


SELECT
		author_id,
		count(*) AS "개설한 과정 수"
	FROM courses
	GROUP BY author_id
	ORDER BY "개설한 과정 수" DESC;



/*
 * having 그룹화된 결과에 조건 걸기
 * 
 * where은 데이터를 그룹화하기 "전"에 원본 테이블의 개별 행들을 필터링한다.
 * having은 데이터를 그룹화하고 집계 함수를 계산한 후에 그룹 결과를 필터링 한다.
 * 
 * where : 요리하기 전에, 상한 재료는 버리는 과정
 * having : 요리를 마친 후, 완성된 요리 중 별점 4점 이상인 요리만 남기는 과정
 * 따라서 집계 함수에 대한 조건(count(*) >= 4)는 having 절에만 사용할 수 있다. 
 * */

SELECT
		author_id,
		count(*) AS "개설 과정 수"
	FROM courses
	GROUP BY author_id
	HAVING count(*) >= 3;



SELECT
		course_id,
		count(*) AS "등록 학생 수"
	FROM enrollments
   WHERE status = "completed"
   GROUP BY course_id
  HAVING count(*) >= 2
   ORDER BY "등록 학생 수" DESC;


/*
  과제 1 (`COUNT`):
  - 'published' 상태인 과정은 총 몇 개인지 `courses` 테이블을 이용해 계산하라.

  과제 2 (`GROUP BY`):
  - `user_roles` 테이블을 사용하여, '학습자(ROLE_LEARNER)'와 '교육자(ROLE_EDUCATOR)' 역할별로
    각각 몇 명이 할당되어 있는지 `role_id`와 사용자 수를 함께 조회하라.

  과제 3 (`GROUP BY`, `ORDER BY`, `LIMIT`):
  - 가장 많은 질문(thread)을 작성한 사용자 상위 5명의 `author_id`와 작성한 질문 수를 조회하라.

  과제 4 (`HAVING`):
  - 수강신청(`enrollments`) 기록이 3번 이상인 학생의 `user_id`와 수강신청 횟수를 조회하라.

  과제 5 (종합):
  - `grades` 테이블에서, 2번 이상 평가(grade)를 받은 학생(`user_id`) 중에서,
    평균 점수가 80점 이상인 학생의 `user_id`와 평균 점수, 그리고 받은 평가 횟수를 조회하라.
*/


-- 과제 1
SELECT 
		count(*) AS "과정 수"
	FROM courses
	WHERE status = 'published';

-- 과제 2
DESC role
DESC user_roles;
SELECT * FROM user_roles; -- id값으로 들어가 있는걸

SELECT 
		user_roles.role_id,
		r.name,
		count(*)
	FROM user_roles
	LEFT JOIN roles AS r ON (user_roles.role_id = r.role_id)
	GROUP BY user_roles.role_id, r.name;

--   과제 3 (`GROUP BY`, `ORDER BY`, `LIMIT`):
--   - 가장 많은 질문(thread)을 작성한 사용자 상위 5명의 `author_id`와 작성한 질문 수를 조회하라.

SELECT
		author_id,
		count(*) AS "질문 수"
	FROM forum_threads
	GROUP BY author_id
	ORDER BY "질문 수" DESC 
	LIMIT 5;

--   과제 4 (`HAVING`):
--   - 수강신청(`enrollments`) 기록이 3번 이상인 학생의 `user_id`와 수강신청 횟수를 조회하라.

SELECT
		user_id,
		count(*) AS "수강신청 횟수"
	FROM enrollments
	GROUP BY user_id
	HAVING count(*) >= 3;


--   과제 5 (종합):
--   - `grades` 테이블에서, 2번 이상 평가(grade)를 받은 학생(`user_id`) 중에서,
--     평균 점수가 80점 이상인 학생의 `user_id`와 평균 점수, 그리고 받은 평가 횟수를 조회하라.

SELECT 
		user_id,
		AVG(score) AS "평균 점수",
		COUNT(*) AS "평가 횟수"
	FROM grades
	GROUP BY user_id
	HAVING AVG(score) >= 80
		AND COUNT(*) >= 2;



