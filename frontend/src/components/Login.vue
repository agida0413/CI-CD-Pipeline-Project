<template>
    <v-sheet class="bg-deep-purple pa-12" rounded>
      <v-card class="mx-auto px-6 py-8" max-width="344">
      
          <v-text-field
            v-model="email"
            :readonly="loading"
            :rules="[required]"
            class="mb-2"
            label="Email"
            clearable
          ></v-text-field>
  
          <v-text-field
            v-model="password"
            :readonly="loading"
            :rules="[required]"
            label="Password"
            placeholder="Enter your password"
            clearable
          ></v-text-field>
  
          <br>
       <v-row>      
        <v-col>  
          <v-btn
            :disabled="!form"
            :loading="loading"
            color="success"
            size="large"
            type="submit"
            variant="elevated"
            block
          >
            Sign In
          </v-btn>
        </v-col>
        <v-col>
        <v-btn
           
            :loading="loading"
            color="danger"
            size="large"
            type="submit"
            variant="elevated"
            block
            @click="goToJoin"
          >
           JOIN
          </v-btn>
        </v-col>
        </v-row>

       
      </v-card>
   
    </v-sheet>
</template>
  <script>
  import api from '@/axios';
    export default {
        data(){
            return{
                username:'',
                password:''
            }
        },
        mounted(){
            this.getCaptcha()
        },
  
      methods: {
        required (v) {
          return !!v || 'Field is required'
        },
        goToJoin(){
            this.$router.push('/Join')
        },
        getCaptcha(){
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
      },
    }
</script>