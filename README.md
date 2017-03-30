# coreUp
coreUp은 coreApp의 상위 버젼임.
spring frame work core를 공부한다.


#################################### Gaols ######################################

Maven
Spring Application Context 설정 -> 연관 기술 적용 aop 설정 spring security 설정 datasource 설정 : 다중 DB CONNECTION data 처리 방식 : Data Access 서비스(sqlMapper:ibatis , mybatis) / ORM 서비스(JPA/HIBERNATE) transaction 설정 스프링 mvc 설정 로그 설정 SITEMESH 설정
TDD (Test Driven development) junit + mock mvc + mockito
AOP
RESTFUL API SERVER 구축
표준 프레임웍 적용 [가이드]표준프레임워크_적용가이드_v2.3_20130906.hwp #################################### Gaols ######################################
coreAppNext V.01

coreApp V4.0

coreApp db 이중화 처리 / Transaction 적용

db : DB1 / DB1 (사용자정보 / 권한관리)
db : DB2 / DB2 (application 관리)
user 정보 : 
('test1', 'test1', '테스트1');
('member1', 'member1password', '준회원');
('member2', 'member2password', '정회원');
('admin', 'admin', '관리자');
DB script  프로젝트 내에	/coreApp/webapp/sql/db1/data.sql , coreApp/webapp/sql/db1/table.sql 제공

coreApp spring security 적용

access denied 처리
DB를 이용한 권한관리 미적용 -> To do
중복 로그인 설정 미적용 -> To do
에러 handling 적용

hibernate validatior 적용 -> 구체화 시켜야 함

[Study & To Do]

aop 적용 (보안 , 로깅 .....)
RESTFUL API SERVER 구축
TDD (Test Driven development) junit + mock mvc + mockito
eclipse debugging
front-end 학습 jquery / bootstrap / angularjs 등
logback 설정 -> 상세 처리
[개발정보]

jdk 8

spring mvc 4 -spring security 3.x

tomcat7

maven4.0

oracle 11g

localhost:7777

site 계정정보 ('test1', 'test1', '테스트1'); ('member1', 'member1password', '준회원'); ('member2', 'member2password', '정회원'); ('admin', 'admin', '관리자');

[Reference] -spring security 참고 http://zgundam.tistory.com/43 http://zgundam.tistory.com/44 http://zgundam.tistory.com/45 http://zgundam.tistory.com/46 http://zgundam.tistory.com/47 http://zgundam.tistory.com/48 http://zgundam.tistory.com/49 http://zgundam.tistory.com/50 http://zgundam.tistory.com/51 http://zgundam.tistory.com/52 http://zgundam.tistory.com/53 http://zgundam.tistory.com/54 http://zgundam.tistory.com/55 http://zgundam.tistory.com/56 http://zgundam.tistory.com/57 http://zgundam.tistory.com/58 http://zgundam.tistory.com/59 http://zgundam.tistory.com/60

coreApp V 0.3

coreApp 세번째 모듈 : spring framework 구성 및 기능을 연구한다 1.oracle database   연동 2.mybatis data access framework 3.db 이중화 처리   4.transaction 처리 5.Layer 별로  디렉토리 및 설정파일 추가, 변경

-- To do 1.JUNIT 기반 Test case 작성 방법 2.spring security , aop 적용 3.요소기술 적용 해야함 : 파일업로드 , 페이징 .... 4.maven Project 배포방법

coreAppNext V 0.2

coreApp 두번째 모듈 : spring framework 구성 및 기능을 연구한다 1.oracle database   연동 2.mybatis data access framework 3.db 이중화 처리  

-- To do 4.applicationContext 구성 방법 모색 5.JUNIT 기반 Test case 작성 방법

coreAppNext V 0.1

coreApp 첫번째 모듈 : spring framework 구성 및 기능을 연구한다

1.h2database를 이용한 in-memory 저장방식 2.mock mvc를 이용한 test 방법에 대한
3.maven build tool에 대한 이해 4.applicationContext 구성 방법 모색 5.DI Pattern에 대한 연구
