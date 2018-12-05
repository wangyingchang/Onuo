<template>

  <div class="login">
      <div class="center-login">
       <div class = "loginFrame">
        <el-form ref = "AccountForm" :model = "account"  label-position = "left" label-width = "0px" class = "demo-ruleForm login-container">
       <!--tab标签-->
        <el-tabs v-model = "activeName" class = "users" @tab-click="handleClick">
            <el-tab-pane label = "欢迎注册" name = "students">

                <el-form-item prop = "username">
                    <el-input type = "text" v-model = "account_username" auto-complete = "off" placeholder = "设置账号/手机号"></el-input></el-form-item> 
              

<el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2"  class="demo-ruleForm">
  <el-form-item prop="pass">
    <el-input type="password" v-model="ruleForm2.pass" autocomplete="off" placeholder="设置密码"></el-input>
  </el-form-item>
  <el-form-item prop="checkPass">
    <el-input type="password" v-model="ruleForm2.checkPass" autocomplete="off" placeholder="确认密码"></el-input>
  </el-form-item>

  
</el-form>



                    <el-form-item prop = "email">
                <el-input type = "text" v-model = "account_email" auto-complete = "off" placeholder = "请输入邮箱"></el-input></el-form-item> 
                
                
                <el-form-item style = "width:100%;">
                    <el-button class="submitBtn" type = "primary" style = "width:100%;" >注册</el-button>
                </el-form-item>


        </el-tab-pane>

    </el-tabs><br>

    </el-form>
       </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "regist",
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

   var checkAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('年龄不能为空'));
        }
        setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('请输入数字值'));
          } else {
            if (value < 18) {
              callback(new Error('必须年满18岁'));
            } else {
              callback();
            }
          }
        }, 1000);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm2.checkPass !== '') {
            this.$refs.ruleForm2.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm2.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
        return {

  ruleForm2: {
          pass: '',
          checkPass: '',
          age: ''
        },
        rules2: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
          age: [
            { validator: checkAge, trigger: 'blur' }
          ]
        },
      

inputInfo:'',   //用户输入信息
            
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
            account_repassword:'',
            account_username:'',
            account_email:'',

        ReginForm: {
    tel: '',
   },

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

submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
    



 handleClick(tab, event) {
        console.log(tab, event);
      },

 },
  
}
</script>




<style scoped>

.loginFrame{
 padding: 8% 0;
}
.center-login{
  background-image: url('../../../static/image/regist-bgi.jpg');
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
    height: 380px;
    padding: 15px 35px 15px 35px;
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