<template>
  <div class="order_first" style="background-color:#ebedf0;height:730px;" >
    <!-- 步骤条 -->
    <div class="top">
      <el-steps :active="active" space="33%" align-center simple>
      <el-step title="选择车辆"></el-step>
      <el-step title="上传双证"></el-step>
      <el-step title="确认订单"></el-step>
      <el-step title="支付订单"></el-step>
      </el-steps>
    </div>

    <!--content-->
    <div class="content">
      <!--上传身份证-->
      <el-card style="width:500px;margin:0;float:left;">
      <div class="upload" >
          <!--上传按钮-->
          <div class="upload_top" >
            <el-upload
            name="cardFront"
            class="upload-demo"
            action="http://127.0.0.1:8888/order/info/card"
            list-type="picture-card"
            :headers="myHeaders"
            :limit="1"
            :on-success="uploadSuccessCard"
            >
              <el-button size="small" type="primary">上传身份证</el-button>
              <div slot="tip" class="el-upload__tip">上传身份证正面图片文件,支持jpg/png且不超过500kb</div>
            </el-upload>
          </div>
          
          <!--身份信息-->
          <div class="upload_content">
            <el-form inline ref="card" :model="card" :rules="cardRules" label-width="70px" >
              <el-form-item label="姓名" prop="cardName">
                <el-input v-model="card.cardName"   size="5px"></el-input>
              </el-form-item>
              <el-form-item label="性别" prop="cardGender">
                <el-input v-model="card.cardGender" size="1px"></el-input>
              </el-form-item>
              <el-form-item label="出生日期">
                <el-input v-model="card.birthday" size="8px"></el-input>
              </el-form-item>
              <el-form-item label="证号" prop="cardId">
                <el-input v-model="card.cardId" size="18px"></el-input>
              </el-form-item>
              <el-form-item label="地址" prop="cardAddress">
                <el-input v-model="card.cardAddress" size="45px"></el-input>
              </el-form-item>
            </el-form>
          </div><br>
      </div>
      </el-card>
      <!--上传驾驶证-->
      <el-card style="width:500px;float:left">
      <div class="upload">
          <!--上传按钮-->
          <div class="upload_top">
            <el-upload
            name="driverImg"
            class="upload-demo"
            action="http://127.0.0.1:8888/order/info/driver"
            list-type="picture-card"
            :headers="myHeaders"
            :on-success="uploadSuccessDrive"
            limit="1"
            >
              <el-button size="small" type="primary">上传驾驶证</el-button>
              <div slot="tip" class="el-upload__tip">上传驾驶证正面图片文件,支持jpg/png且不超过500kb</div>
            </el-upload>
          </div>
          <!--身份信息-->
          <div class="upload_content">
            <el-form inline ref="driver" :model="driver" :rules="driverRules" label-width="90px" >
              <el-form-item label="姓名" prop="diverName">
                <el-input v-model="driver.diverName" size="5px"></el-input>
              </el-form-item>
              <el-form-item label="性别" prop="diverGender">
                <el-input v-model="driver.diverGender" size="1px"></el-input>
              </el-form-item>
              <el-form-item label="开始时间" prop="diverStartTime">
                <el-input v-model="driver.diverStartTime" size="8px"></el-input>
              </el-form-item>
              <el-form-item label="国籍" prop="diverCountry">
                <el-input v-model="driver.diverCountry" size="2px"></el-input>
              </el-form-item>
              <el-form-item label="类型" prop="diverType">
                <el-input v-model="driver.diverType" size="5px"></el-input>
              </el-form-item>
              <el-form-item label="结束时间" prop="diverEndTime">
                <el-input v-model="driver.diverEndTime" size="8px"></el-input>
              </el-form-item>
              <el-form-item label="证号" prop="diverId">
                <el-input v-model="driver.diverId" size="20px"></el-input>
              </el-form-item>
              <el-form-item label="地址" prop="diverAddress">
                <el-input v-model="driver.diverAddress" size="40px"></el-input>
              </el-form-item>
            </el-form>
          </div><br>
      </div>
      </el-card>
    </div>
      <!--下一步按钮-->
      <div class="next">
        <el-button type="primary" @click="next">下一步</el-button>
      </div>

  </div>
</template>
<script>
import { getToken } from '@/utils/token'
import { throws } from 'assert';
import store from '@/store'
import {addCardInfo,addDrivenfo,addOrdernfo} from '@/api/order'
export default {
  name: "order_first",
  data() {
    return {
       myHeaders: {
           Authorization: ''
        },
      msg: "订单录入",
      active: 1,
      card:{
        cardId:'',
        cardName:'',
        cardGender:'',
        cardAddress:'',
        birthday:''
      },
      driver:{
        diverId:'',
        diverName:'',
        diverGender:'',
        diverStartTime:'',
        diverEndTime:'',
        diverCountry:'',
        diverAddress:'',
        diverBirthday:'',
        diverType:'',
      },
      // 驾驶证校验
      driverRules:{
        diverName: [{
          required:true,
          message:'驾驶证姓名不能为空',
          trigger: "blur"
        }],
       diverStartTime:[{
          required:true,
          message:'开始时间不能为空',
          trigger: "blur"
        }],
        diverGender: [{
          required:true,
          message:'性别不能为空',
          trigger: "blur"
        }],
        diverCountry: [{
          required:true,
          message:'国籍不能为空',
          trigger: "blur"
        }],
        diverType: [{
          required:true,
          message:'驾驶证类型不能为空',
          trigger: "blur"
        }],
        diverEndTime: [{
          required:true,
          message:'结束时间不能为空',
          trigger: "blur"
        }],
        diverId: [{
          required:true,
          message:'驾驶证号不能为空',
          trigger: "blur"
        },{
          pattern:/^[1-9]\d{5}(18|19|2([0-9]))\d{2}(0[0-9]|10|11|12)([0-2][1-9]|30|31)\d{3}[0-9Xx]$/,
           message:'驾驶证格式不正确',
          trigger: "blur"
        }],
        diverAddress: [{
          required:true,
          message:'地址不能为空',
          trigger: "blur"
        }],
      },
      // 身份证校验
      cardRules:{
          cardId:[{
          required:true,
          message:'身份证号不能为空',
          trigger: "blur"
        },
        {
          pattern:/^[1-9]\d{5}(18|19|2([0-9]))\d{2}(0[0-9]|10|11|12)([0-2][1-9]|30|31)\d{3}[0-9Xx]$/,
           message:'身份证号格式不正确',
          trigger: "blur"
        }],
        cardName:[{
          required:true,
          message:'身份证姓名不能为空',
          trigger:'blur'
        }],
        cardGender:[{
          required:true,
          message:'性别不能为空',
          trigger:'blur'
        }],
        cardAddress:[{
          required:true,
          message:'住址不能为空',
          trigger:'blur'
        }]
      },
      orderInfo:{
        cardId:'',
        carId:'',
        carLicenceId:'',
        userId:'',

      }
    };
  },
  methods: {
    next() {
      let driverValid = false
      let cardValid = false
      // this.$refs.driver.validate((valid)=>{
      //   if(valid){
      //     driverValid = true
      //   }else{
      //     return false;
      //   }
      // })

       this.$refs.card.validate((valid)=>{
        if(valid){
          cardValid = true
        }else{
          return false;
        }
      })

      if (cardValid) {
        if (this.active++ > 2) this.active = 0;
        this.addInfo();
      }
    },
    addInfo(){
      // 上传身份证信息
      // addCardInfo,addDrivenfo,addOrdernfo
      if(this.driver.diverGender==='男'){
        this.driver.diverGender='1'
      }else{
        this.driver.diverGender='0'
      }
      if(this.card.cardGender==='男'){
        this.card.cardGender='1'
      }else{
        this.card.cardGender='0'
      }
      addCardInfo(this.card)
        .then(response=>{
            if(response.data===1){
              addDrivenfo(this.driver)
              .then(response=>{
                // 生成订单信息
                if(response.data===1){
                  // 封装order对象传值
                  this.orderInfo.cardId=this.card.cardId;
                  this.orderInfo.carLicenceId=this.driver.diverId;
                  this.orderInfo.userId=store.getters.userId;
                  this.orderInfo.carId=this.$route.query.carId;
                  addOrdernfo(this.orderInfo)
                    .then(response=>{
                      this.$router.push({path :'/order/order_two',query:{orderId:response.data,carPrice:this.$route.query.carPrice}});

                    })
                }
              })
            }
        })
    },
    uploadSuccessCard : function(response, file, fileList) {
      let cardInfo=response.data
      this.card.cardId=cardInfo.cardId
      this.card.cardName=cardInfo.cardName
      this.card.cardGender=cardInfo.cardSex
      this.card.cardAddress=cardInfo.cardAddress
      this.card.birthday=cardInfo.carBirthday
      
    },
    uploadSuccessDrive : function(response, file, fileList){
        let driverInfo=response.data;
        this.driver.diverId=driverInfo.driveId;
        this.driver.diverName=driverInfo.driverName;
        this.driver.diverGender=driverInfo.driverSex;
        this.driver.diverStartTime=driverInfo.driverStartTime;
        this.driver.diverEndTime=driverInfo.driverEndTime;
        this.driver.diverCountry=driverInfo.driverCountry;
        this.driver.diverAddress=driverInfo.driverAddress;
        this.driver.diverBirthday=driverInfo.driverBirthday;
        this.driver.diverType=driverInfo.driverType;
    }
  },

  mounted:function(){
    this.myHeaders.Authorization=getToken();
  }
};
</script>
<style scoped>
.top{
  margin:30px auto;
  width: 800px;
  text-align: center;
}
.content{
  margin:auto;
  width: 1000px;
  background-color: white;
}
.upload{
  margin:auto;
  float: left;
  background-color: white;
}
.upload_top{
  margin:auto; 
  background-color: #dae9f4;
  text-align: center;
  width: 80%;
}
.upload_content{
  margin:10px auto 0px auto; 
  height:340px;
  width: 100%;
}
.next{
  clear: both;
  margin:auto;
  text-align: center;
  width: 1000px;
  height: 50px;
  line-height: 50px;
}

</style>