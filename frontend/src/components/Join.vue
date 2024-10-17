<template>
    <v-card
      class="mx-auto"
      max-width="344"
      title="회원가입"
    >
      <v-container>
        <v-text-field
          v-model="name"
          color="primary"
          label="이름"
          variant="underlined"
        ></v-text-field>
  
     
  
        <v-text-field
          v-model="username"
          color="primary"
          label="아이디"
          variant="underlined"
        ></v-text-field>
  
        <v-text-field
          v-model="password"
          color="primary"
          label="비밀번호"
          placeholder="Enter your password"
          variant="underlined"
          type="password"
        ></v-text-field>
        <v-row class="ml-2">
            <v-col ><img :src="captchaImage"></v-col>
         
        </v-row>
        
        <v-text-field   placeholder="보안문자 입력" v-model="captchaAnswer"></v-text-field>
      </v-container>
  
      <v-divider></v-divider>
  
      <v-card-actions>
        <v-spacer></v-spacer>
  
        <v-btn color="success" @click="postForm">
        회원가입 제출
  
          <v-icon icon="mdi-chevron-right" end></v-icon>
        </v-btn>
     
      </v-card-actions>
    </v-card>
  </template>
  <script>
  import api from '@/axios';
    export default {
     data(){
        return{
            captchaImage:'',
            captchaKey:'',
            captchaAnswer:'',
            name:'',
            username:'',
            password:''
            
        }
     },
     mounted(){
        this.getCaptcha()
     },
     methods:{
        getCaptcha(){
            api.defaults.headers.get['Cache-Control'] = 'no-cache';
            api.defaults.headers.get['Pragma'] = 'no-cache';

            api.get('/captcha')
            .then((res)=>{
                console.log(res.data)
                this.captchaImage='data:image/png;base64,'+res.data.data.captchaImage
                console.log(this.captchaImage)
                
                this.captchaKey=res.data.data.captchaKey
                console.log(this.captchaKey)
                this.captchaAnswer=''
            })
        
        }
        ,
        postForm(){
            let formData=new FormData;
            formData.append('username',this.username)
            formData.append('password',this.password)
            formData.append('name',this.name)
            formData.append('captchaKey',this.captchaKey)
            formData.append('captcha',this.captchaAnswer)
            api.post('/member',formData)
            .then(()=>{
                this.$router.push('/')
            })
            .catch((err)=>{
                alert(err.response.data.message)
            })
        }
     }
    }
  </script>