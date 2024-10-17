// router.js
import { createRouter, createWebHistory } from 'vue-router';
import Login from './components/Login.vue';
import Join from './components/Join.vue'; // Join 컴포넌트 가져오기
const routes = [
  {
    path: '/', // 기본 경로
    name: 'Login',
    component: Login, // Home 컴포넌트를 표시
  },
  {
    path: '/Join', // '/about' 경로
    name: 'Join',
    component: Join, // About 컴포넌트를 표시
  },
];

const router = createRouter({
  history: createWebHistory(), // HTML5 History 모드 사용
  routes, // 라우트 설정
});

export default router;
