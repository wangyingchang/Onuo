<template>
  <div class="company_rent_car">
    <div class="bgc-img" style="background-image:url(../../../static/image/bgc-img.jpg);height:300px;">
        <div class="center-login">
       <div class = "loginFrame">
        <el-form ref = "AccountForm" :model = "account"  label-position = "left" label-width = "0px" class = "demo-ruleForm login-container">
       <!--tab标签-->
        <el-tabs v-model = "activeName" class = "users" @tab-click="handleClick">
            <el-tab-pane label = "账号密码登录" name = "students">

                <el-form-item prop = "username">
                    <el-input type = "text" v-model = "account_username" auto-complete = "off" placeholder = "请输入您的账号"></el-input></el-form-item> 
                <el-form-item prop = "password">
                    <el-input type = "password" v-model = "account_password" auto-complete = "off" placeholder = "请输入密码"></el-input></el-form-item> 
                    
                        <el-input style="width:40%;" type="text" v-model="inputInfo" auto-complete="off" placeholder="请输入验证码"></el-input>
                        <span class="code-style" @click="createCode" style="padding:5px;border:1px solid gray;">{{verificationCode}}</span>
                        <!-- <span class="confirm-botton" @click="confirmTheCode">验证</span> -->
                    

                
                <el-checkbox v-model = "checked" checked class = "remember" style="float:right;">记住密码</el-checkbox><br>
                <a class = "forgetpwd" href="#"  style="float:right;">忘记密码</a>
                
                <el-form-item style = "width:100%;">
                    <el-button class="submitBtn" type = "primary" style = "width:100%;" @click="confirmTheCode">登录</el-button>
                </el-form-item>

        </el-tab-pane>



        <el-tab-pane label = "手机号码登录" name = "teacher">
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
                <el-form-item >
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
    </el-tabs>

    </el-form>
       </div>
    </div>
    </div>
     <div class="orderBoxBlue">
        <ul class="abc" >
          <li class="biaoti">优势</li>
          <li class="imgg">
            <img src="../../../../static/image/youshi.png" alt="">
          </li>
        </ul>
        <ul class="abc">
          <li class="biaoti">功能</li>
          <li class="imgg">
            <img src="../../../../static/image/gongneng.png" alt="">
          </li>
        </ul>
        <ul class="abc">
          <li class="biaoti">长租</li>
          <li class="imgg">
            <img src="../../../../static/image/changzu.png" alt="">
          </li>
        </ul>
        <ul class="abc">
          <li class="biaoti">融资租赁</li>
          <li class="imgg">
            <img src="../../../../static/image/rongzi.png" alt="">
          </li>
        </ul>
        <ul class="abc" style="height:280px;">
          <li class="biaoti">产品</li>
          <ul class="abc1" >
            <li class="dabiao">自驾游</li>
            <li class="xiaobiao">网点多</li>
            <li class="imgg">66大城市</li>
            <li class="imgg">52大机场</li>
            <li class="imgg">38大高铁</li>
            <li class="imgg">1000多网点</li>
          </ul>
          <ul class="abc1" style="margin-top:67px;">
            <li class="xiaobiao">车型丰富</li>
            <li class="imgg">超过100种车型</li>
            <li class="imgg">代步型:凯越、K2、飞度 等</li>
            <li class="imgg">商务型:凯美瑞、奥迪、宝马 等</li>
            <li class="imgg">功能型：GL8、SUV 等</li>
            <li class="imgg">个性化：Mini、Smart 等</li>
          </ul>
          <ul class="abc1" style="margin-top:67px;">
            <li class="xiaobiao">车龄短</li>
            <li class="imgg">平均车龄小于两年</li>
            <li class="imgg">中国车龄最短的车队</li>
            <li class="imgg">24小时服务（取还车、救援、中英文客服）</li>
            <li class="imgg">免费GPS导航</li>
            <li class="imgg">不限公里</li>
          </ul>
           <ul class="abc1" >
            <li class="dabiao">国际租车</li>
            <li class="xiaobiao">网点多</li>
            <li class="imgg">全球6大洲</li>
            <li class="imgg">150个国家</li>
            <li class="imgg">10,400个服务网点</li>
          </ul>
          <ul class="abc1">
            <li class="xiaobiao" style="margin-top:67px;">全球主流最新车型</li>
            <li class="imgg">常用标准车组  尊贵豪华车组</li>
            <li class="imgg">绿色环保车组  豪华敞篷跑车</li>
            <li class="imgg">动感酷趣车组  激情探险车组</li>
          </ul>
          <ul class="abc1">
            <li class="xiaobiao" style="margin-top:67px;">特色服务</li>
            <li class="imgg">中国驾照英文认证书</li>
            <li class="imgg">24小时紧急救援</li>
            <li class="imgg">中文GPS导航</li>
            <li class="imgg">异地/异国换车</li>
            <li class="imgg">累计全球60多家航空公司里程积分</li>
          </ul>
        </ul>
        
     </div>
    
  </div>
</template>
<script>
export default {
    name: "company_rent_car",
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
            }else if(customerCode != this.verificationCode){
                this.createCode();
                this.inputInfo = ''
                alert('验证码不正确，请重新输入');
            }else {
                alert('输入正确')
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
*{
  padding:0;

}

.company_rent_car {
  background-color: #f6fafb;
  padding-bottom: 10px;
  margin: 0 auto;
}

.company_rent_car li{
  list-style:none;
}
.biaoti{
     font-size: 20px;
    font-family: "微软雅黑",arial,Simsun,sans-serif;
    height: 40px;
    line-height: 40px;
    font-weight: 400;
    border-bottom:1px solid #DDDDDD;
    padding-left: 40px;
    
}
.orderBoxBlue {
    
    border-bottom-width: 2px;
    width: 90%;
    margin: 0 auto ;
}
.imgg{
  
  padding-left: 20px;
  font-size: 12px;
  color:gray;
}
.abc{
  margin: 20px auto;
  border:1px solid #DDDDDD;
  background-color: #fff;
  width: 1250px;
}
.xiaobiao{
  padding-left: 20px;
  font-size: 14px;
  color: skyblue;
  margin-bottom: 10px;
}
.dabiao{
  padding-left: 20px;
    margin: 20px 0;

    font-size: 18px;
    color: black;
}
.abc1{
  float: left;
  margin: 0 auto;
  margin-left:20px;
  margin-bottom:20px;
  background-color: #fff;
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
   margin-left: 100px;
  -webkit-border-radius: 5px;
    border-radius: 15px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    width: 25%;
    height: 280px;
    padding: 10px 35px 15px 35px;
    background: rgba(255,255,255,0.7) ;
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