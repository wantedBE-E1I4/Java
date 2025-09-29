
/*
 * 서브쿼리가 왜 필요한가?
 * sql 기초 강의를 수강하는 학생들의 평균 점수보다 높은 점수를 받은 학생은 누구인가 ?
 * 이 질문에 답하려면 두 단계의 작업이 필요하다
 * 1. sql기초 강의 수강생들의 평균 점수를 구한다.
 * 2. 이 점수보다 높은 점수를 받은 학생들을 찾는다.
 * 
 * 서브쿼리는 이처럼 여러 단계로 나누어 생각해야 하는 문제를 하나의 sql문 안에서
 * 해결할 수 있도록 해주는 강력한 기능이다. 왼쪽 쿼리(서브쿼리)가 먼저 실행되어
 * 바깥쪽 쿼리(메인 쿼리)가 사용할 값을 총적으로 제공해준다.
 * 
 * 서브쿼리는 실행 결과와 사용 위치ㅔㅇ 따라서 여러종류로 나뉭다.
 * 결과 행의 수 : 단일행, 다중 행 서브쿼리
 * 결과 열의 수 : 스칼라 (단일 값) 서브쿼리
 * 사용 취리 where 절, select 절, from 절
 * */

/*
 * where 절에서 사용하는 서브쿼리
 * 
 * where 절의 조건 값으로 다른 쿼리의 결과를 사용할 때 사용된다.
 * 가장 일반적인 형태이다.
 * */

-- 서브쿼리를 사용할 때, 목적을 먼저 잡아야한다. 
-- 목적을 리스트하고 하나씩 조합해 나간다.
SELECT
		name,
		created_at
	FROM users
	WHERE YEAR(created_at) = (
		SELECT 
			YEAR(created_at)
		FROM users
		WHERE name = "홍길동"
	);





-- 다중 행 서브쿼리
SELECT 
		u.user_id,
		u.name,
		e.course_id
	FROM users AS u
	JOIN enrollments AS e ON (u.user_id = e.user_id)
	WHERE e.course_id IN ( -- python 강의
		SELECT 
			c.course_id
		FROM courses AS c -- 과정 테이블
		JOIN course_tags AS ct ON (c.course_id = ct.course_id) -- course tag : 과정의 카테고리
		JOIN tags AS t ON (ct.tag_id = t.tag_id) -- tags : 카테고리 명
		WHERE t.name LIKE "%python"
	);


/*
 * from 절에 사용하는 인라인 뷰
 * from 절에서 마치 하나의 테이블 처럼 사용되는 서브쿼리이다.
 * 서브쿼리의 결과 집합을 가상의 데이틉(뷰)로 만들어, 메인 쿼리에서 이 가상의 테이블을
 * 조회하거나 다른 테이블과 조인 할 수 있다.
 * 
 * 복잡한 쿼리를 단순화하거나, 특정 순서의 데이터 일부만 가져와 가공할 때 매우 유용하다.
 * 
 * */

SELECT 
		u.name AS "교육자 이름",
		author_stats.course_count AS "개설 과정 수"
	FROM users u
	JOIN (
		SELECT 
				author_id,
				count(*) AS course_count
			FROM courses
			GROUP BY author_id
	)AS author_stats ON u.user_id = author_stats.author_id;


/*
  과제 1 (WHERE절 서브쿼리):
  - '홍길동'이 수강 신청한 과정(`courses`)들의 제목을 조회하라.
    (힌트: `enrollments` 테이블과 `users` 테이블을 활용)

  과제 2 (WHERE절 서브쿼리):
  - 자기소개(`bio`)를 작성한 사용자들이 개설한 모든 과정의 제목을 조회하라.
    (힌트: `user_profiles` 테이블을 활용)

  과제 3 (SELECT절 스칼라 서브쿼리):
  - 모든 과정의 제목(`title`)과, 해당 과정의 포럼(`forums`)에 작성된 게시글(`forum_threads`)의 총 개수를 함께 조회하라.

  과제 4 (FROM절 인라인 뷰):
  - 각 과정(`course_id`)별로 등록 학생 수를 계산하는 서브쿼리를 인라인 뷰로 만든다.
  - 이 인라인 뷰와 `courses` 테이블을 조인하여, 과정 제목과 등록 학생 수를 함께 조회하라.
    (실습 4-1과 유사한 구조)
*/


--   과제 1 (WHERE절 서브쿼리):
--   - '홍길동'이 수강 신청한 과정(`courses`)들의 제목을 조회하라.
--     (힌트: `enrollments` 테이블과 `users` 테이블을 활용)

SELECT 
		c.title
	FROM courses AS c, enrollments AS e
	WHERE e.user_id = (
		SELECT 
			user_id
		FROM users
		WHERE name = '홍길동'
	);


--   과제 2 (WHERE절 서브쿼리):
--   - 자기소개(`bio`)를 작성한 사용자들이 개설한 모든 과정의 제목을 조회하라.
--     (힌트: `user_profiles` 테이블을 활용)

SELECT * FROM user_profiles;

SELECT 
		c.title
	FROM courses AS c
	WHERE c.author_id IN (
		SELECT 
				up.user_id
			FROM user_profiles AS up
			WHERE up.bio IS NOT NULL
	);

--   과제 3 (SELECT절 스칼라 서브쿼리):
--   - 모든 과정의 제목(`title`)과, 해당 과정의 포럼(`forums`)에 작성된 게시글(`forum_threads`)의 총 개수를 함께 조회하라.

SELECT 
    c.title AS "과정 제목",
    (
        SELECT COUNT(*)
        FROM forums f
        JOIN forum_threads ft ON f.forum_id = ft.forum_id
        WHERE f.course_id = c.course_id
    ) AS "게시글 수" -- 스칼라 서브쿼리는 한 열만 반환해야 한다.
FROM courses c;

--   과제 4 (FROM절 인라인 뷰):
--   - 각 과정(`course_id`)별로 등록 학생 수를 계산하는 서브쿼리를 인라인 뷰로 만든다.
--   - 이 인라인 뷰와 `courses` 테이블을 조인하여, 과정 제목과 등록 학생 수를 함께 조회하라.
--     (실습 4-1과 유사한 구조)
SELECT 
		c.title,
		i.`학생 수` 
	FROM courses AS c,
		(
			SELECT
					course_id,
					count(*) AS "학생 수"
				FROM enrollments AS e
				GROUP BY e.COURSE_ID 
		) AS i
	WHERE c.course_id = i.course_id;



