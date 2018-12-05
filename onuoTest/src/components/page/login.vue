<template>

  <div class="login">
      <div class="center-login">
       <div class = "loginFrame">
        <el-form ref = "AccountForm" :model = "account"  label-position = "left" label-width = "0px" class = "demo-ruleForm login-container">
       <!--tab标签-->
        <el-tabs v-model = "activeName" class = "users" @tab-click="handleClick">
            <el-tab-pane label = "账号密码登录" name = "students"><br>

                <el-form-item prop = "username">
                    <el-input type = "text" v-model = "account_username" auto-complete = "off" placeholder = "请输入您的账号"></el-input></el-form-item> 
                <el-form-item prop = "password">
                    <el-input type = "password" v-model = "account_password" auto-complete = "off" placeholder = "请输入密码"></el-input></el-form-item> 
                    
                        <el-input style="width:35%;" type="text" v-model="inputInfo" auto-complete="off" placeholder="请输入验证码"></el-input>
                        <span class="code-style" @click="createCode" style="padding:5px;border:1px solid gray;">{{verificationCode}}</span>
                        <!-- <span class="confirm-botton" @click="confirmTheCode">验证</span> -->
                    

                
                <br><br><el-checkbox v-model = "checked" checked class = "remember">记住密码</el-checkbox>
                <a class = "forgetpwd" href="#">忘记密码</a><br>
                
                <el-form-item style = "width:100%;">
                    <el-button class="submitBtn" type = "primary" style = "width:100%;" @click="confirmTheCode">登录</el-button>
                </el-form-item>

        </el-tab-pane>



        <el-tab-pane label = "手机号码登录" name = "teacher"><br>
                <el-form 
                :model="ReginForm"
                ref="ReginForm"
                :rules="rule"
              
                label-width="0">
                    <el-form-item prop="tel">
                    <el-input 
                    type="text"
                    v-model.number="ReginForm.tel"
                    placeholder="手机号码">
                    </el-input>
                </el-form-item>
                
                      <p>
                    <input class="auth_input" type="text" v-model="verification"  placeholder="输入验证码" />
                <el-button v-show="sendAuthCode" class="auth_text auth_text_blue" @click="getAuthCode">获取验证码</el-button>
                <span v-show="!sendAuthCode" class="auth_text" style="color:gray;">  <span class="auth_text_blue">{{auth_time}} </span>S 重新发送</span> 
                </p>
                <el-form-item ><br>
                    <el-button 
                    type="primary" 
                    class="submitBtn"
                    round
                    @click.native.prevent="submit"
                    :loading="logining">
                    登录
                    </el-button>
                </el-form-item>
                </el-form>

        </el-tab-pane>
    </el-tabs><br>

    </el-form>
       </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "login",
    data() {
                let telCheck = (rule, value, callback) => {
                if (value === '') {
                    return callback(new Error('电话号码是必须的'))
                } else if (!Number.isInteger(value)) {
                    return callback(new Error('电话号码必须是数字'))
                } else if (value.toString().length !== 11) {
                    return callback(new Error('电话号码必须是11位数字'))
                } else {
                    callback()
                }
                }
        return {
            inputInfo:'',   //用户输入信息
            verificationCode:'',   //生成的验证码
            
            logining : false,
            
            account : {
                username:'',
                password:'',
            },
            rules: {
                username :[
                    {required: true, message: '请输入账号',trigger: 'blur'},
                    //{ validator: validaePass }
                ]
               
            }, 
            checked: false,


            activeName:'students',
            account_password:'',
            account_username:'',

        ReginForm: {
    tel: '',
   },
   logining: false,
    sendAuthCode:true,/*布尔值，通过v-show控制显示‘获取按钮'还是‘倒计时' */
      auth_time: 0, /*倒计时 计数器*/
      verification:"",//绑定输入验证码框框
   rule: {
    tel: [
     {
      required: true,
      validator: telCheck,
      trigger: 'blur'
     }
    ],
   }
  }
          
        
    },
    created() {},  
    methods: {
 handleClick(tab, event) {
        console.log(tab, event);
      },

createCode:function () {    //通过随机数生成验证码
            this.verificationCode = '';
            var code = '';
            var codeLength = 4;     //验证码长度
            var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');
            for(var i = 0;i<codeLength;i++){
                var index = Math.floor(Math.random()*36);
                code += random[index];
            }this.verificationCode = code
            
                },

confirmTheCode:function () {      //验证函数
            var customerCode = this.inputInfo.toUpperCase();   //把你输入的小写转化为大写
            if(customerCode == 0){
                this.createCode();
                this.inputInfo = ''
                alert('请输入验证码')
                return;
            }else if(customerCode != this.verificationCode){
                this.createCode();
                this.inputInfo = ''
                alert('验证码不正确，请重新输入');
                return;
            }else {
                
            const user = {}

            user.username = this.account_username
            user.password = this.account_password
            this.$store.dispatch('Login', user).then(() => {
            this.$router.push({ path: '/' })
            }).catch((errors) => {
                alert(errors);
              this.loading = false
            })
          
            }
        },



     getAuthCode:function () {
      const verification =this.ReginForm.tel;
       const url = " "
       console.log("url",url);
       
      this.sendAuthCode = false;
     //设置倒计时秒
      this.auth_time = 60;
      var auth_timetimer = setInterval(()=>{
        this.auth_time--;
        if(this.auth_time<=0){
          this.sendAuthCode = true;
          clearInterval(auth_timetimer);
        }
      }, 1000);
    },

 },
  mounted(){
        this.createCode()
    }

}
</script>




<style scoped>

.loginFrame{
 padding: 8% 0;
}
.center-login{
  background-image: url('/static/image/login-background.jpg');
    position:relative;
                top: 0;
                left:0px;
                width: 100%;
                height:100%;
                background-size: 100% 110%;
                
}
.code-box{
        margin-top: 50px;
        text-align: center;
    }
    .code-style{
        font-size: 16px;
        color: red;
        cursor: pointer;
    }
    .confirm-botton{
        display: inline-block;
        width: 50px;
        background-color: #fcce00;
        font-size: 16px;
        line-height: 32px;
        cursor: pointer;
    }




.login a{
  float: right;
  color:gray;
  font-size:12px;
}
 .login-container {
  -webkit-border-radius: 5px;
    border-radius: 15px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 0 auto;
    
    width: 25%;
    height: 350px;
    padding: 35px 35px 15px 35px;
    background: rgba(255,255,255,0.7)
 
    ;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
}

.submitBtn {
 width: 100%;
 background:#fcce00;
 border: 0;
 margin: 0 auto;

}
.to {
 color: #FA5555;
 cursor: pointer;
}
.auth_input{
  width:140px;
  height:38px;
  
  border:1px solid #DCDFE6;
  /* color:red; */
  padding-left:10px;
  border-radius: 8%;
}
.regform[data-v-92def6b0]{
  width:370px;
  min-height: 440px;
}
.login-text{
 text-align: center;

}      

</style>