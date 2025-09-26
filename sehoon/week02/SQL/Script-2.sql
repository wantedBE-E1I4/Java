/*
 * 테이블을 만드는 것은 단순히 칸을 나누는 작업이 아니다.
 * 데이터가 지켜야 할 규칙을 정의하고, 데이터베이스가 스스로 데이터의 품질을 유지하도록 만드는 시스템을 설계하는 과정이다.
 * 이러한 규칙이 없다면 데이터베이스에 여러가지 데이터가 저장이 되고 그로 인해 데이터를 조작하거나 관리하는데 어려움이 생길 수 있기 때문이다.
 * 이 규칙을 정의하는 두 가지 핵심 요소가 바로 '데이터 타입'과 '제약 조건'이다.
 *
 * 1. 데이터 타입 (Data Types)은 왜 필요한가?
 * - 각 열(Column)에 어떤 종류의 데이터만 저장될 수 있는지 강제하는 규칙이다.
 * '나이' 열에 '스무살'이라는 글자가 들어가는 것을 원천 차단하여 데이터의 오염을 막고,
 * 데이터 종류에 맞는 최적의 공간만 사용하여 저장 효율을 높인다.
 * 
 * - 각 열(Column)에 저장될 데이터의 종류를 지정한다.
 * - INT/BIGINT: 정수(Integer)를 저장한다. (예: user_id, author_id)
 * - VARCHAR(n): 최대 n글자의 변수 길이 문자열(Variable Character)을 저장한다. (예: email, name)
 * - TEXT: 매우 긴 텍스트를 저장한다. (예: description, content)
 * - DATE: 날짜(YYYY-MM-DD)를 저장한다.
 * - DATETIME/TIMESTAMP: 날짜와 시간(YYYY-MM-DD HH:MI:SS)을 함께 저장한다.
 *
 *
 * 2. 제약 조건 (Constraints)은 왜 필요한가?
 * - 데이터 타입을 넘어, 데이터들 사이의 논리적인 규칙까지 강제하는 강력한 도구이다.
 * '이 칸은 비워둘 수 없음(NOT NULL)', '이 칸의 값은 중복 불가(UNIQUE)',
 * '이 칸의 값은 다른 테이블의 특정 값 중 하나여야 함(FOREIGN KEY)' 등
 * 데이터베이스가 스스로 데이터의 정합성을 지키는 '자동 경찰' 역할을 하도록 만든다.
 * 
 * - NOT NULL: 해당 열에 NULL 값이 들어올 수 없도록 강제한다. (필수 입력)
 * - UNIQUE: 해당 열의 모든 값이 테이블 내에서 유일해야 함을 보장한다. (중복 방지)
 * - PRIMARY KEY (기본 키): NOT NULL과 UNIQUE의 특징을 모두 가지는 테이블의 대표 식별자이다.
 * - FOREIGN KEY (외래 키): 다른 테이블의 기본 키를 참조하여 테이블 간의 관계를 맺고 데이터의 일관성을 보장한다.
 * - DEFAULT: 값이 명시적으로 입력되지 않았을 때 사용할 기본값을 지정한다.
 */

CREATE TABLE `users` (
	`user_id` 	bigint NOT NULL AUTO_INCREMENT COMMENT "고유 식별자 (회원번호)",
	`email` 	varchar(255) UNIQUE NOT NULL COMMENT "이메일 주소 (로그인 ID)",
	`name` 		varchar(10)	NOT NULL COMMENT "사용자 이름",
	
	`status`	varchar(20)	NOT NULL DEFAULT "active" comment "계정 상태",
	`created_at` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시',
    `updated_at` TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시',
    `deleted_at` TIMESTAMP  NULL COMMENT '삭제 일시',
    PRIMARY KEY (`user_id`)
)COMMENT "서비스의 모든 사용자에 대한 핵심 정보";

-- =========================================================================================
-- 실습 2단계: `courses` 테이블 생성 (`users` 테이블을 참조하는 자식 테이블)
-- =========================================================================================
/*
  -- `courses` 테이블: 개설된 과정 정보를 담는 테이블.
  -- FOREIGN KEY (외래 키) 제약 조건:
  --   FOREIGN KEY (`author_id`): 이 테이블의 `author_id` 열을 외래 키로 지정한다.
  --   REFERENCES `users`(`user_id`): 이 외래 키는 `users`(부모) 테이블의 `user_id`(PK) 열을 참조한다.
  --   -> 이 규칙으로 인해, 부모 테이블(`users`)에 존재하지 않는 `user_id`를 자식 테이블(`courses`)의
  --      `author_id`에 입력하려는 시도는 DBMS에 의해 자동으로 차단된다.
  --      즉, 참고하려고 하는 곳에 값이 없다면 해당 값을 넣을 수 없다는 것이고 이를 통해 데이터의 일관성이 보장된다.
  --      이는 데이터베이스의 "참조 무결성(Referential Integrity)"을 지키는 매우 중요한 메커니즘이다.
*/

create table `courses`(
	`course_id` bigint not null auto_increment comment "과정 고유 ID",
	`author_id` bigint not null comment "과정 개설자",
	`title`		varchar(255) not null comment "과정 제목",
	`description` text null comment "과정 상세 설명",
	`status` varchar(20) not null default "draft" comment "과정 상태",
	primary KEY(`course_id`),
	foreign KEY(`author_id`) references `users`(`user_id`)
)COMMENT "최상위 학습 단위 과정";


create table `enrollments`(
	`enrollment_id` bigint not null auto_increment comment "등록 ID",
	`user_id` bigint not null comment "수강생 ID",
	`course_id` bigint not null comment "수강 과정 Id",
	`status` varchar(20) not null default "active" comment "수강 상태",
	`enrolled_at` timestamp not null default current_timestamp comment "등록말",
	
	primary key (`enrollment_id`),
	foreign key (`user_id`) references `users`(user_id),
	foreign key (`course_id`) references `courses`(course_id)
) comment "수강 신청 정보";




