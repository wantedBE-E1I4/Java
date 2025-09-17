# Java
wantedBE 1번째 달 팀스터디 
https://www.notion.so/ohgiraffers/270649136c1180c58622c93aa405ffe3?v=270649136c11807c97f2000c47bf764c

# ☕ Java Study Team

Java 문법 학습과 Git/GitHub 협업을 통한 실무 경험을 쌓기 위한 스터디 그룹입니다.

## 📚 스터디 목적

- **Java 기초 문법 완전 정복**: 변수, 조건문, 반복문부터 객체지향 프로그래밍까지
- **GitHub 협업 경험**: 실무에서 사용하는 Git workflow 학습
- **코드 리뷰 문화**: 서로의 코드를 검토하며 코딩 실력 향상
- **알고리즘 문제 해결**: 백준, 프로그래머스 문제를 Java로 해결

## 📁 폴더 구조 - 참고만!!! 확정아님 

```
📦 java-study
├── 📂 week01-basic-syntax/          # 1주차: 기본 문법
├── 📂 week02-oop/                   # 2주차: 객체지향
├── 📂 week03-collections/           # 3주차: 컬렉션 프레임워크
├── 📂 algorithm/                    # 알고리즘 문제 풀이
│   ├── 📂 baekjoon/
│   └── 📂 programmers/
├── 📂 projects/                     # 개인/팀 프로젝트
└── 📂 resources/                    # 학습 자료
```

## 🤝 커밋 컨벤션

일관된 커밋 메시지로 프로젝트 히스토리를 깔끔하게 관리합니다.


### 커밋 타입

- **feat** : 새로운 기능 추가
  `feat: 변수 선언 예제 추가`

- **fix** : 버그 수정
  `fix: 반복문 무한루프 오류 수정`

- **docs** : 문서 수정
  `docs: README 학습 계획 업데이트`

- **style** : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
  `style: 들여쓰기 및 공백 정리`

- **refactor** : 코드 리펙토링
  `refactor: 중복된 메서드 통합`

- **test** : 테스트 코드, 리펙토링 테스트 코드 추가
  `test: 계산기 클래스 단위 테스트 추가`

- **chore** : 빌드 업무 수정, 패키지 매니저 수정
  `chore: .gitignore 파일 업데이트`

```
# 좋은 커밋 메시지
git commit -m "docs: 2주차 학습 목표 및 일정 추가"

# 피해야 할 커밋 메시지  
git commit -m "수정"
git commit -m "아무거나"
```

## 🚀 참여 방법

1. **Repository Fork**: 우측 상단의 Fork 버튼 클릭
2. **Clone**: `git clone [your-forked-repo-url]`
3. **Branch 생성**: `git checkout -b feature/your-name-week01`
4. **작업 및 Commit**: 학습 내용 정리 후 커밋
5. **Push**: `git push origin feature/your-name-week01`
6. **Pull Request 생성**: 원본 저장소로 PR 요청

## 🌿 브랜치 관리 전략

### Git Flow 구조

```
main (배포용 메인 브랜치)
├── feature/member1 # 멤버1의 학습 + 코드수정 
├── feature/member2 # 멤버2의 학습 + 코드수정 
├── feature/member3 # 멤버3의 학습 + 코드수정 
└── main # 최종 프로젝트 (무기 상점 게임 weapon-shop-game)
```

### 작업 플로우
```
1. **main 브랜치에서 새 브랜치 생성**
git checkout main
git pull origin main
git checkout -b feature/yourname-week01

2. **개인 브랜치에서 학습 및 코딩**
3. **완료 후 Push 및 PR 생성**
4. **코드 리뷰 후 main 브랜치로 병합**
```
## 📋 Pull Request (PR) 규칙

### PR 생성 규칙

#### 1. PR 제목 형식
```
PR 제목 작성 규칙
1. 기본 형식
[타입] 간단한 요약 설명
또는 
타입: 간단한 요약 설명
2. 타입 종류
[FEAT] 또는 feat: - 새로운 기능 추가

[FIX] 또는 fix: - 버그 수정

[DOCS] 또는 docs: - 문서 수정

[STYLE] 또는 style: - 코드 포맷팅, 스타일 변경

[REFACTOR] 또는 refactor: - 코드 리팩터링

[TEST] 또는 test: - 테스트 코드 추가/수정

[CHORE] 또는 chore: - 기타 작업
```
3. 제목 작성 원칙
50자 이내로 간결하게 작성

명령형 현재시제 사용 ("Add", "Fix", "Update")

첫 글자 대문자로 시작

마침표 없이 작성

```
[타입] 간단한 설명 - 작성자명

예시:
[STUDY] 1주차 변수와 자료형 학습 - 홍길동
[FEAT] 무기 상점 기본 구조 구현 - 김철수
[FIX] 인벤토리 버그 수정 - 이영희
```

#### 2. PR 템플릿
```
📚 학습 내용 / 작업 내용
 학습한 주제나 구현한 기능 설명

🔍 주요 변경사항
추가된 파일들
구현한 기능들
학습한 개념들

📝 코드 설명
핵심 로직 설명
어려웠던 부분이나 질문사항

✅ 체크리스트
 코드에 주석이 적절히 작성되었는가?
 변수명과 메서드명이 명확한가?
 컴파일 오류가 없는가?
 커밋 메시지가 컨벤션을 따르는가?

🤔 질문사항 (선택)
팀원들에게 묻고 싶은 내용
개선이 필요한 부분
```

PR 라벨링 규칙
Priority: high, medium, low

Type: feature, bugfix, hotfix, refactor

Status: WIP (Work In Progress), ready for review, needs changes

Size: XS, S, M, L, XL (변경된 코드 양 기준)

### PR 리뷰 규칙
#### 리뷰어 규칙
- **최소 1명 이상**의 팀원 리뷰 필수
- 학습용 PR은 **교육적 피드백** 위주
- 프로젝트용 PR은 **코드 품질** 중심 리뷰

```
#### 리뷰 댓글 가이드
👍 잘했어요!
"Scanner 사용법을 정확히 이해했네요!"
"변수명이 직관적이에요 👍"

🤔 제안/질문

"이 부분을 메서드로 분리하면 어떨까요?"
"여기서 null 체크를 추가하면 더 안전할 것 같아요"

📚 학습 도움

"Optional을 사용해보는 것도 좋은 연습이 될 것 같아요"
"이런 방식도 있어요: [코드 예시]"


#### 승인 기준
- **학습 PR**: 컴파일 오류 없고 학습 목표 달성시 승인
- **기능 PR**: 코드 품질 + 기능 동작 확인 후 승인
- **버그 수정 PR**: 문제 해결 확인 후 즉시 승인
```

## 🚪 온보딩 플로우

### 🎯 새로운 팀원을 위한 시작 가이드

#### Step 1: 사전 준비사항 체크리스트
```
필수 준비물
 Java JDK 11 이상 설치
 IntelliJ IDEA 또는 Eclipse IDE 설치
 Git 설치 및 GitHub 계정 생성
 백준 온라인 저지 계정 생성
 프로그래머스 계정 생성
권장 준비물
 VS Code (마크다운 편집용)
 디스코드/슬랙 등 팀 커뮤니케이션 도구
 ```
#### Step 2: 개발환경 설정 가이드
```

**Java 개발환경 확인**
Java 버전 확인
java -version
javac -version

예상 출력: java version "11.0.x" 이상
text
```

**Git 설정**

Git 사용자 정보 설정
- `git config --global user.name "본인이름"`
- `git config --global user.email "본인이메일@example.com"`

설정 확인
- `git config --list`


#### Step 3: 팀 커뮤니케이션 참여

**디스코드/슬랙 채널 참여**
- 📢 공지사항: 중요한 알림
- 💬 일반대화: 자유로운 소통
- 🤔 질문답변: 학습 관련 질의응답
- 📚 자료공유: 유용한 학습 자료 공유
- 🎯 진도체크: 주간 학습 현황 공유

**정기 미팅 참여**
- **매주 화요일 저녁**: 주간 회고 및 다음 주 계획

### 🆘 도움이 필요할 때

#### 즉시 도움받을 수 있는 방법
1. **디스코드/슬랙 #질문답변** 채널에 질문 올리기
2. **GitHub Issue**로 기술적 문제 신고
3. **팀장에게 개인 메시지**로 긴급한 도움 요청


## 🔗 유용한 링크

- [Java 공식 문서](https://docs.oracle.com/javase/)
- [백준 온라인 저지](https://www.acmicpc.net/)
- [프로그래머스](https://programmers.co.kr/)
- [Git 기본 명령어 정리](https://git-scm.com/docs)


**함께 성장하는 개발자가 되어봅시다! 🌱**
