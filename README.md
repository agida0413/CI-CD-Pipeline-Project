 


  # 📝CI/CD 자동화를 목적으로 한 파이프라인 구축 

 - **중점**

   - **기능은 SECURITY + JWT + CAPTCHA를 활용한 회원가입,로그인기능만 구현한다.** 

   - **Docker, GithubAction 을 이용한 CI/CD 자동화 파이프라인 및 브랜치 전략 구축에 초점을 둔다.**


     

<br>





 # 🔧 Skills

   ✔️ Back-end
 
   
![Spring Boot](https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=Spring%20Security&logoColor=white)
![MyBatis](https://img.shields.io/badge/MyBatis-DC382D?style=for-the-badge&logo=mybatis&logoColor=white)


<br>



   ✔️ Front-end
![Vue.js](https://img.shields.io/badge/vuejs-35495e?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D) 
![Vuetify](https://img.shields.io/badge/Vuetify-1867C0?style=for-the-badge&logo=vuetify&logoColor=AEDDFF)

     
<br>


   ✔️ DB / DEVOPS



![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white)
![Amazon RDS](https://img.shields.io/badge/Amazon%20RDS-527FFF?style=for-the-badge&logo=amazonrds&logoColor=white)
![Elastic Beanstalk](https://img.shields.io/badge/Elastic%20Beanstalk-4B8BBE?style=for-the-badge&logo=amazonaws&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white)
![NGINX](https://img.shields.io/badge/nginx-009639?style=for-the-badge&logo=nginx&logoColor=white)


   



<br>
<br>















<br>
<br>















#  📊 소프트웨어 구조

![1 drawio](https://github.com/user-attachments/assets/af40b0e1-210d-403b-a1d5-819b0c72c2aa)







<br>
<br>









 #  📊 CI/CD 및 브랜치 전략

![2 drawio](https://github.com/user-attachments/assets/31da7b91-1e22-45ab-8fa2-bbe321cacba2)









<br>
<br>








# ✔️ PROBLEM & SOLVE

### <u>**도커 컴포즈 환경의 통합테스트 구축 중 데이터베이스 통신이 불가하여 테스트가 실패하는 문제**</u> 

- *일반적인 compose up을 하면 데이터베이스 컨테이너가 시작하기 전 백엔드 컨테이너가 시작될 경우 테스트에 실패한다.* 

  - <u>***compose up [데이터베이스 컨테이너] 로 먼저 데이터베이스 컨테이너를 시작하고 백엔드 컨테이너는 시작 후 mvn clean verify로 통합테스트를 진행***</u>
---

### <u>**통합테스트 수행시 운영 데이터베이스 사용으로 인한 데이터 손상 문제**</u> 

- *테스트용 데이터베이스가 필요* 

  - <u>***테스트용 데이터베이스 이미지를 만들어 이미지 안에 테이블,더미데이터를 포함한 초기sql파일을 넣고 테스트시 사용***</u>
---

### <u>**이미지의 버전 관리에 있어서 수동으로 workflow파일에 버전을 수정하여 push해야하는 문제**</u> 

- *버전관리를 동적으로 진행* 

  - <u>***release,hotfix 브런치에 버전정보를 명시하여 workflow파일 수행시 버전정보를 추출하여 동적으로 이미지를 push***</u>
---
### <u>**어떤 브런치전략이 정답이지?**</u> 

- *브런치 전략은 회사,개인의 성향마다 다르고, 프로젝트마다 다를 수 있음* 

  - <u>***틀에 박히지 않고, 유연하고 동적인 나만의 브런치 전략 및 CI/CD 전략 구축 - [PR생성시 테스트 -> MERGE 승인] 등***</u>
---















<br>
<br>




# 📝 개선방안 및 추후학습



- *현재 프로젝트에서 HTTP 사용 -> NGINX 사용 시 HTTPS사용이 권장됌* 

  - <u>***NGINX 및 HTTPS + SSL 방식에 대해 자세히 학습한 후 추후 프로젝트에 적용해 보자***</u> 

<br>


- *다소 복잡하고, 반복된 테스트, 불필요한 빌드 등으로 인한 WORKFLOW의 비용이 증가* 

  - <u>***간소화, 및 최적화된 CI/CD 전략을 연구하여 추후 프로젝트에 적용해 보자***</u> 

<br>

    

















