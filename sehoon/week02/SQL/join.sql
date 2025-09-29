
/*
 * 우리는 모듛 1에서 정규화를 통해 데이터의 중복을 최소화하기 위해
 * 데이터를 여러 테이블로 나누어 저장했다.
 * 하지만 우리가 진짜 원하는 정보는 나누어진 데이터 조각들이 아니다.
 * 어떤 사용자가 어떤 과정을 만들었는가와 같이 여러 테이블에 흩어진 데이터를 연결하여 만든 통합된 정보이다.
 * 
 * join은 이렇게 분히된 테이블들을 공통된 것 (주로 pk-fk)를 기준으로 다시 랍쳐서 의미 있는 결과 집합을 만드는 핵심적인 기능이다.
 * join 없이는 관계형 데이터베이스의 진정한 힘을 발휘할 수 없다.
 * */


/*
 * inner join
 * 두 테이블을 연결할 때, 양쪽 테이블에 모두 존재하는 데이터만 보여준다.
 * 즉, 연결 조건이 일치하는 행동만 결과에 포함된다. 가장 기본적이고 많이 사용되는 조인이다.
 * 수학의 교집합과 같은 개념이다.
 * */
SELECT
		u.name AS "강사 이름",
		c.title AS "과정 이름"
	FROM users AS u
	INNER JOIN courses AS c ON (u.user_id = c.author_id);

SELECT 
		u.name AS "학생 이름",
		c.title AS "과정 제목",
		e.enrolled_at AS "등록일"
	FROM enrollments AS e
	INNER JOIN users AS u ON e.user_id = u.user_id
	INNER JOIN courses AS c ON e.course_id = c.course_id;



/*
 * left join 
 * inner join은 양쪽에 모두 데이터가 있는 경우만 보여준다.
 * 하지만, 과정을 하나도 개설하지 않는 교육자를 포함하여 모든 교육자의 목록을 보고 싶을 때
 * 한쪽 테이블의 데이터는 조건 일치 여부와 상관 없이 모두 보고 싶을 때가 있다.
 * 
 * left join은 from 절에 먼저오는 왼쪽 테이블의 모든 데이터를 우선으로 보여주고, 
 * 그 다음 오른쪽 테이블에서 "on"절의 조건에 맞는 데이터를 붙여준다.
 * 만약 오른쪽 테이블에 일치하는 데이터가 없으면, 해당 컬럼은 null로 표시된다.
 * */

SELECT 
		u.user_id,
		u.name,
		c.title
	FROM users AS u
	LEFT JOIN courses AS c ON u.user_id = c.author_id
	ORDER BY u.user_id;

/*
 * right join
 * right join은 left join과 반대로, 오른족 테이블의 모든 데이터를 우선으로 보여준다.
 * 그리고 왼쪽 테이블에서 조건에 맞는 데이터를 찾아 붙인다.
 * 매칭되는 데이터가 없으면 왼쪽 테이블 컬럼은 null로 표시된다.
 * */

SELECT 
		uap.provider AS "소셜 로그인 제공자",
		u.name AS "사용자 이름"
	FROM user_auth_providers AS uap
	RIGHT JOIN users AS u ON uap.user_id = u.user_id;




/*
 * self join
 * 
 * 하나의 테이블 안에 계층적인 관계가 포함된 경우가 있다.
 * 예를 들어 직원 테이블에 관리자 ID 컬럼이 있고, 이 관리자 ID가 사실은 같은 직원 테이블의 다른 직원의 ID를 가르키는 걍우이다.
 * */

SELECT 
		reply.post_id AS "대댓글 ID",
		reply.content AS "대댓글 내용",
		parent.post_id AS "원본 댓글 ID",
		parent.content AS "원본 댓글 내용"
	FROM forum_posts AS reply
	INNER JOIN forum_posts AS parent ON reply.parent_post_id = parent.post_id;


/*
  과제 1 (`INNER JOIN`):
  - `user_roles` 테이블과 `roles` 테이블을 `INNER JOIN`하여,
    사용자의 `user_id`와 함께, `role_id`가 아닌 실제 역할 이름(`name`)을 조회하라.

  과제 2 (`INNER JOIN` 3개 테이블):
  - `forum_threads`(게시글)와 `users`(작성자), `forums`(포럼) 테이블을 모두 `INNER JOIN`하여,
    '게시글 제목', '포럼 제목', '작성자 이름'을 함께 조회하라.

  과제 3 (`LEFT JOIN`):
  - `courses` 테이블을 기준으로 `enrollments` 테이블을 `LEFT JOIN`하여,
    모든 과정의 제목과 해당 과정에 등록한 학생 수를 함께 조회하라.
    (힌트: GROUP BY와 COUNT(*)를 사용해야 한다. 아무도 등록하지 않은 과정은 0으로 표시되어야 한다.)

  과제 4 (`LEFT JOIN`, `WHERE ... IS NULL`):
  - `courses` 테이블과 `tags` 테이블의 관계를 나타내는 `course_tags`를 활용하여,
    단 하나의 태그도 붙어있지 않은 과정의 `course_id`와 `title`을 조회하라.
*/

--   과제 1 (`INNER JOIN`):
--   - `user_roles` 테이블과 `roles` 테이블을 `INNER JOIN`하여,
--     사용자의 `user_id`와 함께, `role_id`가 아닌 실제 역할 이름(`name`)을 조회하라.

SELECT 
		ur.user_id,
		ur.role_id,
		r.name AS "역할 이름"
	FROM user_roles AS ur
	INNER JOIN roles AS r ON (ur.role_id = r.role_id);
	


--   과제 2 (`INNER JOIN` 3개 테이블):
--   - `forum_threads`(게시글)와 `users`(작성자), `forums`(포럼) 테이블을 모두 `INNER JOIN`하여,
--     '게시글 제목', '포럼 제목', '작성자 이름'을 함께 조회하라.

SELECT
		ft.title AS "게시글",
		f.TITLE AS "포럼 제목",
		u.name AS "작성자"
	FROM forum_threads AS ft
	INNER JOIN users AS u ON (ft.author_id = u.user_id)
	INNER JOIN forums AS f ON (ft.forum_id = f.forum_id);

--   과제 3 (`LEFT JOIN`):
--   - `courses` 테이블을 기준으로 `enrollments` 테이블을 `LEFT JOIN`하여,
--     모든 과정의 제목과 해당 과정에 등록한 학생 수를 함께 조회하라.
--     (힌트: GROUP BY와 COUNT(*)를 사용해야 한다. 아무도 등록하지 않은 과정은 0으로 표시되어야 한다.)

SELECT
		c.course_id,
		c.title,
		count(e.user_id) AS "등록한 학생 수"
	FROM courses AS c
	LEFT JOIN enrollments AS e ON (c.course_id = e.course_id)
	GROUP BY c.course_id;

--   과제 4 (`LEFT JOIN`, `WHERE ... IS NULL`):
--   - `courses` 테이블과 `tags` 테이블의 관계를 나타내는 `course_tags`를 활용하여,
--     단 하나의 태그도 붙어있지 않은 과정의 `course_id`와 `title`을 조회하라.

SELECT
		c.course_id,
		c.title
	FROM courses AS c
	LEFT JOIN course_tags AS ct ON (c.course_id = ct.course_id)
	WHERE ct.tag_id IS NULL;
