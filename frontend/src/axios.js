// api.js
import axios from "axios";
const api = axios.create({
  
  baseURL:'http://localhost:8080/api/v1', // 여기에 기본 URL 설정
});

export default api; // 인스턴스를 기본으로 내보내기