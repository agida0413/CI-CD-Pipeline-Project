 


  # 📝CI/CD 자동화를 목적으로 한 파이프라인 구축 

 - **중점**

   - **기능은 SECURITY + JWT + CAPTCHA를 활용한 회원가입,로그인기능만 구현한다.** 

   - **Docker, GithubAction 을 이용한 CI/CD 자동화 파이프라인 구축 및 브랜치 전략에 초점을 둔다.**


     

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
![ar5 drawio](https://github.com/user-attachments/assets/4e76802c-29f7-4e87-8cd4-7575ccd2c3bd)







<br>
<br>









 #  📊 CI/CD 및 브랜치 전략


![CICD drawio](https://github.com/user-attachments/assets/fd91969b-bce4-4602-9404-081e38a40189)







<br>
<br>








# ✔️ PROBLEM & SOLVE

### <u>**도커 컴포즈 환경의 통합테스트 구축 중 데이터베이스 통신이 불가하여 테스트가 실패하는 문제**</u> 

- *일반적인 compose up을 하면 데이터베이스 컨테이너가 시작하기 전 백엔드 컨테이너가 시작될 경우 테스트에 실패한다.* 

  - <u>***compose up [데이터베이스 컨테이너] 로 먼저 데이터베이스 컨테이너를 시작하고 백엔드 컨테이너는 시작 후 mvn clean verify로 통합테스트를 진행한다.***</u>
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
    

















