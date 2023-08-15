# wanted-pre-onboarding-backend
**지원자 성명**
박상은


**애플리케이션 실행 방법**
스프링부트 실행 후 localhost:지정된포트번호로 진입한다.
- localhost:포트번호(이하 생략) - community/list로 이동
- post   /community - 게시글 작성 로직 후 커뮤니티 리스트로 이동 혹은 작성 페이지 유지
- put    /community - 게시글 수정 로직 후 커뮤니티 상세 페이지로 이동 혹은 수정 페이지 유지
- get    /community/list - 커뮤니티 리스트로 이동
- get    /community/write - 게시글 작성 페이지로 이동
- get    /community/번호 - 게시글 상세 페이지로 이동
- delete /community/번호 - 게시글 삭제 로직 후 커뮤니티 리스트로 이동 혹은 상세 페이지 유지
- get    /community/update/번호 - 게시글 수정 페이지로 이동
- get    /login - 로그인 페이지로 이동
- post   /login - 로그인 로직 후 커뮤니티 리스트로 이동 혹은 로그인 페이지 유지
- get    /join - 회원가입 페이지로 이동
- post   /join - 회원가입 로직 후 로그인 페이지로 이동 혹은 회원가입 페이지 유지


**데이터베이스 테이블 구조**
Member테이블 : member_id, email, password
Community테이블 : community_id, member_id, title, content, write_time, update_date
member_id을 외래키로 사용하고 있습니다.
CREATE TABLE member (
	member_id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(256) NOT NULL,
    PRIMARY KEY(member_id),
    UNIQUE KEY (email)
) ENGINE=MYISAM CHARSET=utf8;

CREATE TABLE community (
	community_id BIGINT NOT NULL AUTO_INCREMENT,
    member_id BIGINT NOT NULL,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(4000) NOT NULL,
    write_time DATETIME NOT NULL,
    update_time DATETIME,
    PRIMARY KEY(community_id)
) ENGINE=MYISAM CHARSET=utf8;

**구현한 API의 동작을 촬영한 데모 영상 링크**
https://www.youtube.com/watch?v=GmjLI1QYpCA

**구현 방법 및 이유에 대한 간략한 설명**
1. 사용자 계정을 생성하고 로그아웃하는 프로세스를 작성하였습니다.
2. 사용자의 정보, 게시글 내용 등을 저장하고 관리할 수 있는 데이터베이스를 구축하였습니다. spring framework를 공부하던 도중, 원티드 백엔드 프리온보딩을 알게되어 spring boot와, JPA로 DataBase에 접근하는 법을 공부하여 적용해보았습니다.
4. 사용자들이 게시글을 작성, 수정, 삭제할 수 있는 기능을 작성하였습니다.


**API명세(request/response 포함)**
1. 사용자 로그인 API
Endpoint: POST /login
Request:
    {
       "email": "test@naver.com",
       "password": "qwer1234"
    }
response: (String 형식)
   "-1" : 존재하지 않는 계정일 경우
   그 외 : 로그인된 회원의 id

2. 회원가입 API
Endpoint: POST /join
Request:
    {
       "email": "test@naver.com",
       "password": "qwer1234"
    }
response: (String 형식)
   null : 성공했을 경우
   그 외 : 실패된 이유

3. 게시글 작성 API
Endpoint: POST /community
Request:
    {
       "title": "제목",
       "content": "본문",
       "memberId": "1"
    }
response: (String 형식)
   null : 실패했을 경우
   그 외 : 게시글 번호

4. 게시글 수정 API
Endpoint: PUT /community
Request:
    {
       "title": "제목",
       "content": "본문",
       "memberId" : "1"
    }
response: (String 형식)
   null : 실패했을 경우
   그 외 : 게시글 번호

5. 게시글 삭제 API
Endpoint: DELETE /community/번호
Request:
    {
       "id": "2"
    }
response: (String 형식)
   "0" : 삭제된 경우
   그 외 : 삭패 실패한 경우

6. 게시글 리스트 조회 API
Endpoint: GET /community

7. 게시글 상세 페이지
Request:
    {
       "id": "2"
    }
response: (model)
    {
       "id" : 게시글 번호,
       "title" : 제목,
       "content" : 본문,
       "member" : 작성자 정보
    }
   


