# 목차
1. 프로젝트 이름 
2. 프로젝트 설명 
3. 프로젝트 환경설정 및 설치방법 
4. 개발에 참여한 팀원 
5. 참고자료 
6. 개선이 필요한 사항 


# 프로젝트 이름 
스프링 시네마(SpringCinema)
    
    수업때 스프링을 배웠고 스프링을 기반으로 영화관을 만들어보자는 의미에서 스프링 시네마라고 지었습니다.

# 프로젝트 설명
#### 이 애플리케이션은 어떤일을 하나요?
    스프링 시네마는 KMDB의 API를 연동해 영화 데이터를 가져와 실제 영화관 사이트처럼 현재/상영 예정작을 보여주는 기능
    그리고 영화를 선택하고 예매하는 프로세스 최종적으로 아임포트를 사용해 테스트 결제까지
    연동해놓은 애플리케이션입니다.
    
#### 이 프로젝트에는 어떤 기술이 사용되었나요?
🔎 프론트
* Bootstrap
* Thymeleaf
* HTML
* CSS
* Javascript
* Jquery
* Ajax

🔎 백엔드
* Java
* SpringBoot
* Mysql
    

# 프로젝트 환경설정 및 설치방법 
    이 프로젝트는 스프링 2.7.6 버전이 사용되었습니다.
    어플리케이션을 구동하고 싶으면 프로젝트를 받아 build.gradle에 있는 종속되는 부분을 다운하고
    사용하시면 됩니다.

# 개발에 참여한 팀원 
* MoonNight285(github : https://github.com/MoonNight285 , email : kimjyjh123@gmail.com)
* EblynCho(github : https://github.com/EblynCho , email : eblyn52@naver.com)
* minho95(github : https://github.com/OwOowl , email : ymh0052@naver.com)

# 참고자료 
* 한국영화데이터베이스(https://www.kmdb.or.kr/info/api/apiDetail/6)
* KOHI배움 폰트(https://noonnu.cc/font_page/813)
* 아임포트 - 깃허브(https://github.com/iamport/iamport-manual)
* 아임포트 - 공식문서(https://docs.iamport.kr/implementation/payment || https://chai-iamport.gitbook.io/iamport/auth/guide)
* 스프링부트 스케줄링 사용(http://jmlim.github.io/spring/2018/11/27/spring-boot-schedule/)

# 개선이 필요한 사항
    로그인 진행 후 세션 아이디가 URL에 노출된 현상이 발견되었습니다.
    마이페이지에서 새로고침을 진행하면 프로필로 돌아오도록 설계가 진행이 돼 불편함이 있습니다.

