 


  # 📝CI/CD 자동화를 목적으로 한 파이프라인 구축 

 - **중점**

   - **기능은 SECURITY + JWT + CAPTCHA를 활용한 회원가입,로그인기능만 구현한다.** 

   - **Docker, GithubAction 을 이용한 CI/CD 자동화 파이프라인 구축 및 브랜치 전략에 초점을 둔다.**


     

<br>
<br>




 # 🔧 Skills

   ✔️ Back-end
 
   
 <div>
       <span><img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"></span> &nbsp
       <span><img src="https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens"></span> &nbsp
       <span> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white"></span>&nbsp
       <span> <img src="https://img.shields.io/badge/MyBatis-DC382D?style=for-the-badge&logo=mybatis&logoColor=white"></span>   
      </div>

<br>



   ✔️ Front-end
<div>  <span><img src="https://img.shields.io/badge/vuejs-%2335495e.svg?style=for-the-badge&logo=vuedotjs&logoColor=%234FC08D"></span> &nbsp    
      <span><img src="https://img.shields.io/badge/Vuetify-1867C0?style=for-the-badge&logo=vuetify&logoColor=AEDDFF"></span>
 </div>   
     
<br>


   ✔️ DB / DEVOPS



 <div>  <span><img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"></span> &nbsp
         <span><img src="https://img.shields.io/badge/Amazon_RDS-527FFF?style=for-the-badge&logo=amazonaws&logoColor=white"></span> &nbsp;
      <span> <img src="https://img.shields.io/badge/Elastic%20Beanstalk-4B8BBE?style=for-the-badge&logo=Amazon%20AWS&logoColor=white"></span> &nbsp;
        <span> <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white"/></span> &nbsp;
            <span> <img src="https://img.shields.io/badge/GitHub Actions-2088FF?style=for-the-badge&logo=GitHub Actions&logoColor=white"/></span> &nbsp;
             <span><img src="https://img.shields.io/badge/nginx-%23009639.svg?style=for-the-badge&logo=nginx&logoColor=white"/></span> &nbsp;
</div>

   



<br>
<br>















<br>
<br>















#  📊 소프트웨어 구조

![ar4 drawio](https://github.com/user-attachments/assets/ab760275-923d-4aa6-9745-e752d52ffda9)





<br>
<br>









 #  📊 CI/CD 및 브랜치 전략


![CICD drawio](https://github.com/user-attachments/assets/fd91969b-bce4-4602-9404-081e38a40189)







<br>
<br>








# ✔️ PROBLEM & SOLVE

### <u>**Security Filter 내 예외 발생 시 공통 예외 처리 불가한 문제**</u> 

- *Filter는  Servlet 앞단에 위치하여 ControllerAdvice에 접근 불가* 

  - <u>***ResponseApi 클래스에 필요한 예외처리 항목에 대하여 response를 직접 보내주는 메소드를 작성하여 filter 내부에서 예외처리***</u>
---

### <u>**검색어 추천 기능 중 한글 초,중,종성으로 검색 불가 문제**</u> 

- *한글은 유니코드 체계상 초,중,종성 분리검색 필요* 

  - <u>***데이터베이스 내 초,종,종성컬럼을 추가하여 별도로 저장 및 , 검색컬럼 구성***</u> 
---

### <u>**동일 유저가 중복요청시 데이터 일관성 깨짐 문제**</u> 

- *같은 사용자에 대해 동일한 api요청시 막는 로직이 필요* 

  - <u>***인터셉터, ConcurrentHashMap을 이용하여 동일한 유저에대한 동일한 요청API 발생시 리터해주는 로직 추가***</u>
---

### <u>**게시물 C,U 시 데이터베이스 트랜잭션에서 예외가 발생, API요청이 실패 하여도,S3파일 객체는 저장되는 문제**</u> 

- *게시물 C, U작업 실패 시 S3파일 객체도 롤백되어 삭제 해야하는 과정이 필요* 

  - <u>***S3업로드 로직을 먼저 실행하고 데이터베이스 트랜잭션 수행 후 예외 발생 시 생성된 URL과 매치되는 S3객체 삭제***</u>
---

















<br>
<br>




# 📝 개선방안 및 추후학습



- *자동추천 검색, jwt 토큰관리 관련 작업은 RDBMS에 직접접근하는 방식이 성능저하를 일으킴* 

  - <u>***REDIS 학습을 통해 메모리(RAM)을 활용하여 캐싱하자***</u> 

<br>


- *배포를 할때 수동으로 하니 상당한 시간 및 관리가 어려움* 

  - <u>***CI/CD 학습을 통해 자동화 전략을 이용하자***</u> 

<br>

- *JWT 토큰의 STATELESS의 장점를 느끼지 못하였음* 

  - <u>***로드밸런싱을 학습하여 STATLESS의 장점을 느껴보자***</u>
    

















