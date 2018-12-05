<template>
  <div class="order_first" style="background-color:#ebedf0;">
    <!-- 步骤条 -->
    <div class="top">
      <el-steps :active="active" space="33%" simple >
      <el-step title="选择车辆"></el-step>
      <el-step title="上传双证"></el-step>
      <el-step title="确认订单"></el-step>
      <el-step title="支付订单"></el-step>
      </el-steps>
    </div>
    <!--content-->
    <div class="content">
      <!--top车辆和时间-->
      <div class="content_top">
        <!--车辆信息-->
        <div class="content_car_left">
          <div class="content_car_left_img">
            <a href="#"><img  :src="carInfo.carImgPath"/></a>
          </div>
          <div class="content_car_left_info">
            <input type="hidden" :value="carInfo.carId"><!--车辆Id隐藏域-->
            <p style="font-weight:500;">{{carInfo.carName}}</p>
            <span>{{carInfo.carPower}}</span>
            <span>{{carInfo.carType}}</span>
            <span>{{carInfo.carTransmission}}</span>
            <span>乘坐{{carInfo.carSeat}}人</span><br><br>
            <router-link :to="{path:'/car/car_detail',query:{carId: carInfo.carId}}">
              <el-button type="primary">车辆详情</el-button>
            </router-link>
          </div>
        </div>
        <!--取还车时间-->
        <div class="content_car_right"><br><br>
          <el-form ref="form" :model="order" label-width="80px">
            <el-form-item label="取车时间">
                <el-col :span="11">
                  <el-date-picker type="date" placeholder="选择日期" @change="getStartTime" :picker-options="pickerOptions0" v-model="order.orderStartTime" value-format="yyyy-MM-dd" format="yyyy-MM-dd" style="width: 100%;"></el-date-picker>
                </el-col>
                <!-- <el-col class="line" :span="1">--</el-col>
                <el-col :span="11">
                  <el-time-picker type="fixed-time" placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
                </el-col> -->
              </el-form-item>
              <el-form-item label="还车时间">
                <el-col :span="11">
                  <el-date-picker type="date" placeholder="选择日期" @change="getEndTime"  :picker-options="pickerOptions1" v-model="order.orderEndTime" value-format="yyyy-MM-dd" format="yyyy-MM-dd" style="width: 100%;"></el-date-picker>
                </el-col>
                <!-- <el-col class="line" :span="1">--</el-col>
                <el-col :span="11">
                  <el-time-picker type="fixed-time" placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
                </el-col> -->
              </el-form-item>
          </el-form>
        </div>
        <!--温馨提示-->
        <div class="content_car_bottom">
          <!-- <i class="el-icon-warning" style="heigh:100%;"></i> -->
          <span><span style="color:red;">温馨提示：</span>还车结算时，可使用您账户中100元的新用户专享券。</span>
        </div>
      </div>
      <!--租车人信息-->
      <div class="content_man">
        <br>
        <div class="content_man_info">
          <p>租车人信息</p><span style="color:red;font-size:15px;">请认真填写一下信息，取车时需要现场核对！</span>
          <hr class="hr">
          <div style="display:inline;">
            <!--身份证-->
            <div class="content_man_info_main" >
              <el-form :inline="true"  label-width="80px" :model="card">
                <el-form-item label="证件类型:">
                  <el-input v-model="card.type" disabled></el-input>
                </el-form-item>
                <el-form-item label="证件姓名:">
                  <el-input v-model="card.cardName" disabled></el-input>
                </el-form-item>
                <el-form-item label="证件号码:">
                  <el-input v-model="card.cardId" disabled></el-input>
                </el-form-item>
              </el-form>
           </div>
           <!--驾驶证-->
          <div class="content_man_info_main">
            <el-form :inline="true"  label-width="80px" :model="driver">
              <el-form-item label="证件类型:">
                <el-input v-model="driver.type" disabled></el-input>
              </el-form-item>
              <el-form-item label="证件姓名:">
                <el-input v-model="driver.driverName" disabled></el-input>
              </el-form-item>
              <el-form-item label="证件号码:">
                <el-input v-model="driver.cardId" disabled></el-input>
              </el-form-item>
            </el-form>
           </div>
          </div>
        </div>
        <div class="content_man_phone">
          <span>下单成功后，提醒信息会发送至手机
            <span style="color:blue;">{{userPhone}}</span>
          </span>
        </div><br>
        <div class="comtent_man_att">          
          <span><span style="color:red">注意：</span>取车时,出示以下证件的原件：本人二代身份证、本人国内有效驾驶证正副本、本人一张信用及可用额度均不低于3000元的国内有效信用卡，所有证件有效期须至少超过当次租期的两个月以上。</span>
        </div><br>
      </div>
      <!--费用详情-->
      <div class="content_money">
        <br>
        <div class="content_money_p">
          <p>费用详情</p>
          <hr class="hr">
        </div>
        <div class="content_money_p1">
          <p>车辆租赁及服务费<span style="float:right;color:orange;font-size:15px;font-weight:500;">￥{{carRent}}</span></p>
          <hr class="hr1">
        </div>
        <div class="content_money_p1">
          <p>基础服务费
            <el-tooltip class="item" effect="dark" content="基础服务费包括车辆意外事故损失，呼叫中心服务，车辆救援、维修及保养服务，人工服务等服务内容的费用" placement="right-end">
              <i class="el-icon-view" style="color:#2b90d9;"></i>
            </el-tooltip>
            <span style="float:right;color:orange;font-size:15px;font-weight:500;">￥{{baseServerRent}}</span>
          </p>
          <hr class="hr1">
        </div>
        <div class="content_money_p1">
          <p>其他费用
            <el-tooltip class="item" effect="dark" content="车辆整备费" placement="right-end">
              <i class="el-icon-view" style="color:#2b90d9;"></i>
            </el-tooltip>
            <span style="float:right;color:orange;font-size:15px;font-weight:500;">￥{{elRent}}</span>
          </p>
          <hr class="hr1">
        </div>
        <div class="content_money_p">
          <p>基本费用合计<span style="float:right;color:orange;font-size:20px;font-weight:500;">￥{{order.totalMoney}}</span></p>
          <hr class="hr1">
        </div><br><br>

      </div>
    </div>
    <!--下一步按钮-->
    <div class="next">
      <el-button type="primary" @click="next">提交订单</el-button>
    </div>
  </div>
</template>
<script>
import {getOrderInfo,getCarInfo,getCustomerInfo,getDriverInfo,updateOrder} from '@/api/order'
import store from '@/store'
export default {
  name: "order_first",
  data() {
    return {
      pickerOptions0: {
                disabledDate: (time) => {
                    if (this.order.orderEndTime != "") {
                        return time.getTime() < Date.now() || time.getTime() > this.order.orderEndTime;
                    } else {
                        return time.getTime() < Date.now()-8.64e7;
                    }

                }
            },
            pickerOptions1: {
                disabledDate: (time) => {
                    return time.getTime() < this.order.orderStartTime || time.getTime() < Date.now()-8.64e7;
                }
            },

        
      msg: "订单录入",
      active: 2,
      userPhone:'',
      carInfo:{
        carId:'',
        carImgPath:'',
        carName:'',
        carPower:'',
        carType:'',
        carTransmission:'',
        carSeat:'',
      },
      order:{
        orderId:'',
        totalMoney:'',//订单总价格
        rentDays:'',
        orderStartTime:'',
        orderEndTime:'',
        evaluateInfo:'2',
      },
      card:{
        type:'',
        cardName: '',
        cardId:'',
      },
      driver:{
        type:'',
        driverName:'',
        cardId:'',
      },
      baseServerRent:0,//基础服务费
      elRent:0,//其他费用
      carRent:0,//租车价
    };
  },
  methods: {
    next() {
      if (this.active++ > 2) this.active = 0;
      // 更新订单信息
      this.updateOrderInfo();
    },
    // 查询订单信息
    orderInfo() {
      getOrderInfo(this.$route.query.orderId)
        .then(response=>{
          // 订单Id
          this.order.orderId=this.$route.query.orderId
          // 查询身份证信息
          this.cardInfoByCardId(response.data.cardId)
          // 查询车辆信息
          this.carInfoByCarId(response.data.carId)
          // 查询驾驶证信息
          this.driverInfo(response.data.carLicenceId)
          // 设置手机号
          this.userPhone=store.getters.email
        })
    },
    // 更新订单信息
    updateOrderInfo(){
      // 更新订单
      updateOrder(this.order)
      .then(response=>{
        // 如何订单录入成功返回1
        // alert(response.data);
        // 跳转到到订单确认页面
        this.$router.push({path :'/order/orderInfo',query:{orderId:this.order.orderId}});
      })
    },
    // 查询车辆信息
    carInfoByCarId(carId){
      getCarInfo(carId)
        .then(response=>{
          this.carInfo.carId=response.data.carId
          this.carInfo.carImgPath=response.data.generalImage[0].imgPath
          this.carInfo.carName=response.data.carName
          this.carInfo.carPower=response.data.carPower
          this.carInfo.carType=response.data.carType
          this.carInfo.carTransmission=response.data.carTransmission
          this.carInfo.carSeat=response.data.carSeat
        })
    },
    // 查询租车人身份证信息
    cardInfoByCardId(cardId){
      getCustomerInfo(cardId)
        .then(response=>{
          this.card.type='身份证'
          this.card.cardName=response.data.cardName
          this.card.cardId=response.data.cardId
        })
    },
    // 查询驾驶证信息
    driverInfo(driverId){
      getDriverInfo(driverId)
        .then(response=>{
          console.log(response.data);
          this.driver.type='驾驶证'
          this.driver.driverName=response.data.diverName
          this.driver.cardId=response.data.diverId
        })
    },
    getStartTime(val1){
        this.order.orderStartTime = Number.parseInt(Date.parse(new Date(val1)))
      },
    getEndTime(val) {
      this.order.orderEndTime = Number.parseInt(Date.parse(new Date(val)))
       let dateDiff=this.order.orderEndTime-this.order.orderStartTime
       let dayDiff=Math.floor(dateDiff / (24 * 3600 * 1000));// 计算相差天数
      this.order.totalMoney=dayDiff*(this.$route.query.carPrice)
      this.order.rentDays=dayDiff
    }  
  }, 
  mounted() {
    this.orderInfo()
    this.order.totalRent=this.carRent+this.baseServerRent+this.elRent;//计算总价
  }
};
</script>
<style scoped>
.hr{
  border: 1px solid gray;
  width: 100%;
  margin: auto;
}
.hr1{
  width: 100%;
  margin: auto;
}
.top{
  margin:30px auto;
  width: 800px;
  text-align: center;
}
.content{
  margin:10px auto;
  width: 1000px;
  height: auto;
}
.content_top{
  margin: auto;
  height: 200px;
  background-color: white;
}
.content_car_left{
  margin: auto;
  float:left;
  height: 170px;
  width: 50%;
}
.content_car_left_img{
  float: left;
  height: 100%;
  width: 50%;
}
.content_car_left_img img{
  margin:20px 70px;
  height: 130px;
  border-radius:10px;
}
.content_car_left_img img:hover{
  margin:0px 30px;
  height: 170px;
  border-radius:10px;
}
.content_car_left_info{
  padding-top:40px; 
  float: left;
  height: 100%;
  width: 50%;
  text-align: center;
}
.content_car_left_info p{
  font-size: 20px;
  color:#2b90d9;
}
.content_car_bottom{
  text-align: left;
  font-size: 15px;
  clear: both;
  width: 100%;
  height: 30px;
  line-height: 30px;
  background-color:#dae9f4;
}
.content_car_right{
  float:left;
  height: 170px;
  width: 50%;
  border-left: 2px solid #E0E3DA;
}
.content_man{
  margin-top:20px;
  padding-top:20px; 
  background-color: white;
}
.content_man_phone{
  margin:-20px auto 0px;
  padding-left: 20px;
  width: 90%;
  height: 30px;
  font-size: 15px;
  line-height: 30px;
  background-color: #dae9f4;
}
.content_man_info{
  margin: auto;
  width: 90%;
  height: 300px;
}
.content_man_info p{
  display: inline;
  color: #2b90d9;
  font-size: 20px;
  font-weight: 500;
  margin-left: 30px;
  margin-right:10px;
}
.content_man_info_main{
  float: left;
  margin:30px auto 0px 50px;
  width:300px;
}
.comtent_man_att{
  margin:auto;
  width:90%;
  font-size: 15px;
  height:50px;
  background-color:#dae9f4;
}
.content_money{
  margin-top:20px; 
  background-color: white;
}
.content_money_p{
  margin:20px auto 0px auto;
  width: 90%;
  height: 30px;
}
.content_money_p p:first-child{
  color: #2b90d9;
  font-size: 20px;
  font-weight: 500;
  margin-left: 30px;
  margin-right:10px;
}
.content_money_p1{
  margin:20px auto 0px auto;
  width: 90%;
  height: 30px;
}
.content_money_p1 p:first-child{
  display: inline;
  font-size: 15px;
  margin-left: 50px;
  margin-right:10px;
}
.next{
  margin: 10px auto;
  text-align: center;
  width: 1000px;
  height: 50px;
  line-height: 50px;
}
</style>