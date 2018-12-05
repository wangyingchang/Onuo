<template>
  <div class="orderInfo" style="height:1800px;">
    <!-- 步骤条 -->
       <div class="orderTop">
         <el-card>
         <div class="successInfo">
           <span class="orderStatus"> {{orderMessage}} </span>
           <span class="orderPrice">订单总价：</span>
           <span class="price">
             <em class="rmb">￥</em>
             <em class="num">{{order.totalMoney}}</em>
           </span>
         </div>
         <div class="orderDetail">
           <span>订单号：{{order.orderId}} |</span>
           <span>租车人：{{card.cardName}} |</span>
           <span>租期：{{order.rentDays}} |</span>
           <span>取车时需要刷取预授权</span>
         </div>
         </el-card>
       </div>
       <div class="order_car_info">
         <el-card>
         <h3>基本信息</h3>
         <table width="100%" border="0" cellspacing="0" cellpadding="0" class="orderTable">
           <tbody>
             <tr>
               <td width="10"></td>
               <td colspan="3" rowspan="3" align="center" valign="middle" class="borderBlueB borderBlueR pre" height="99">
                 <img :src="carInfo.carImgPath" width="138" height="80">
               </td>
               <td width="240" align="center" class="borderBlueR borderBlueBda" rowspan="2">
                 <strong>取车时间：</strong>
                  {{startTime}}
               </td>
             </tr>
             <tr><td></td></tr>
             <tr>
               <td class="borderBlueB"></td>
               <td rowspan="2" align="center" valign="middle" class="borderBlueR borderBlueB" height="66">
                 <strong>还车时间：</strong>
                 {{endTime}}
               </td>
             </tr>
             <tr class="f16 borderBlueB" style="font-family:'微软雅黑'；">
               <td></td>
               <td height="33" align="center" valign="middle" class="borderBlueR">{{ carInfo.carName }}</td>
               <td align="center" valign="middle" class="borderBlueR">{{ carInfo.carPower }}/{{carInfo.carDisplacement}}/{{carInfo.carTransmission}}</td> 
               <td align="center" valign="middle" class="borderBlueR">乘坐{{carInfo.carSeat}}人</td>
             </tr>
           </tbody>
         </table>
         </el-card>
       </div>
       <el-card style="height:420px">
        <!-- 双证校验 -->
      <div class="content">
        <h3>双证校验</h3>
      <!--上传身份证-->
      <div class="upload" style="border-right: 2px solid orange;">
          <!--身份信息-->
          <div class="upload_content">
              <p>身份证校验：</p>
            <el-form inline ref="card"  label-width="70px" >
              <el-form-item label="姓名">
                <el-input  size="6px" v-model="card.cardName" disabled></el-input>
              </el-form-item>
              <el-form-item label="性别">
                <el-input size="1px" v-model="card.gender" disabled></el-input>
              </el-form-item>
              <el-form-item label="出生日期">
                <el-input  size="7px" v-model="card.birthDay" disabled></el-input>
              </el-form-item>
              <el-form-item label="证号">
                <el-input  size="23px" v-model="card.cardId" disabled></el-input>
              </el-form-item>
              <el-form-item label="地址">
                <el-input  size="35px" v-model="card.address" disabled></el-input>
              </el-form-item>
            </el-form>
          </div><br>
      </div>
      <!--上传驾驶证-->
      <div class="upload">
          <!--身份信息-->
          <div class="upload_content">
             <p style="margin-left:10px;">驾驶证校验：</p>
            <el-form inline ref="driver" label-width="70px" >
              <el-form-item label="姓名">
                <el-input  size="6px" v-model="driverDetail.name" disabled></el-input>
              </el-form-item>
              <el-form-item label="性别">
                <el-input  size="1px" v-model="driverDetail.gender" disabled></el-input>
              </el-form-item>
              <el-form-item label="开始时间">
                <el-input  size="7px" v-model="driverDetail.beginTime" disabled></el-input>
              </el-form-item>
              <el-form-item label="国籍">
                <el-input  size="6px" v-model="driverDetail.country" disabled></el-input>
              </el-form-item>
              <el-form-item label="类型" >
                <el-input  size="1px" v-model="driverDetail.type" disabled></el-input>
              </el-form-item>
              <el-form-item label="结束时间">
                <el-input  size="7px" v-model="driverDetail.endTime" disabled></el-input>
              </el-form-item>
              <el-form-item label="证号">
                <el-input  size="21px" v-model="driverDetail.driverId" disabled></el-input>
              </el-form-item>
              <el-form-item label="地址" >
                <el-input size="35px" v-model="driverDetail.address" disabled></el-input>
              </el-form-item>
            </el-form>
          </div><br>
      </div><br>
      </div><br>
      </el-card>
      <div style="height:20px;background-color:#ebedf0;"></div>

      <!--已评价-->
      <div style="background-color:white;" v-if="this.order.evaluateInfo==1&&this.judge.judgeConent!=''">
        <p style="color:#2b90d9;font-size:20px;text-align:center;">评价信息</p>
        <hr>
        <div style="text-align:center;">
          <el-rate v-model="judge.judgeScore" disabled style="float:left;margin-left:50px;">
          </el-rate>
          <span style="float:right;margin-right:50px;" v-if="judgeTime!=''">评价时间:{{judgeTime}}</span>
        </div>
        <el-form ref="form" :model="judge" label-width="80px">
           <el-input type="textarea" v-model="judge.judgeConent" disabled/>
        </el-form>
      </div>
      <!--未评价-->
      <div style="background-color:white;" v-if="this.order.evaluateInfo==1&&this.judge.judgeConent==''">
        <p style="color:#2b90d9;font-size:20px;text-align:center;">待评价</p>
        <hr>
        <div style="text-align:center;">
          <el-rate v-model="judge1.judgeScore"></el-rate>
        </div>
        <el-form ref="form" :model="judge1" label-width="80px">
           <el-input type="textarea" v-model="judge1.judgeConent" placeholder="您还没有评价该订单！"/>
        </el-form>
      </div>

     
     <!--下一步按钮-->
      <div class="next">
        <el-button v-if="this.order.evaluateInfo=='2'" type="primary" style="width:90px;">
          <a :href="payUrl">请求支付</a>
        </el-button>
        <el-button v-if="this.order.evaluateInfo=='2'||this.order.evaluateInfo=='3'" @click="cancelOrder" type="primary" style="width:90px;">
         取消订单
        </el-button>
        <el-button v-if="this.order.evaluateInfo=='1'&& this.judge.judgeConent==''" @click="judgeOrder" type="primary" style="width:90px;">
         提交评价
        </el-button>
        <router-link :to="{path:'/order/my_order'}">
          <el-button type="primary" style="width:90px;">
          返回
          </el-button>
        </router-link>
      </div>
  <el-card>
       <div>
         <p style="font-size:14px"><b>如何取车</b><br>
          <br>
        1.取车时,出示以下证件的原件：本人二代身份证、本人国内有效驾驶证正副本、本人一张信用及可用额度均不低于3000元的国内有效信用卡，所有证件有效期须至少超过当次租期的一个月以上。<br>
        <br>
        2.请您准时取车，超时取车，起租时间按预订取车时间起算。</p>
       </div>
       </el-card>

       <el-card> 
         <div>
           <p style="font-size:15px"><b>退改规则</b><br>
            <br>
        订单修改或取消：<br><br>
        a)取车时间距当前时间≥2个工作小时，请提前致电400 616 6666：取车时间在门店的营业时间内，请提前2小时申请；取车时间在门店营业时间之外，请您尽早致电申请。<br><br>
        b)取车时间距当前时间＜2个工作小时，不接受修改。驾照认证授权：取车前，您可通过神州租车APP、神州租车官网等网络渠道自行认证驾照，或到门店由工作人员协助认证驾照。您的驾照信息仅作为身份和驾驶资格认证。<br>
        <br>
        （小贴士：如果您修改订单或取消订单重新预订，价格可能会发生变化。）</p>
         </div>
       </el-card>
  </div>
</template>
<script>
import {getOrderInfo,getCarInfo,getCustomerInfo,getDriverInfo,updateOrder,identifyCard
,identifyDriver,getAliPayId,queryOrderJudgeById,addOrderJudge} from '@/api/order'
import {unix2CurrentDate} from '@/utils/date'//时间转换
import axios from 'axios'
import store from '@/store'
export default {
  name: "order_info",
  data() {
    return {
      active:3,
      orderPayId:'',
      payUrl:'',
      orderMessage:'',
      form:{
        orderJudge:''
      },
      order:{
        totalMoney:'',
        orderId:'',
        rentDays:'',
        orderBeginTime:'',
        orderEndTime:'',
        evaluateInfo:'',
        carJudgeId:'',
      },
      judge:{
        judgeConent:'',
        judgeScore:'',
        judgeTime:'',
        orderId:this.$route.query.orderId,
        carOrCompanyId:'',
        useId:store.getters.userId,
      },
      judge1:{
        judgeConent:'',
        judgeScore:'',
        judgeTime:'',
        orderId:this.$route.query.orderId,
        carOrCompanyId:'',
        useId:store.getters.userId,
      },
    card:{
        cardName:'',
        gender:'',
        birthDay:'',
        cardId:'',
        address:''
    },
    driverDetail:{
        name:'',
        gender:'',
        beginTime:'',
        country:'',
        type:'',
        endTime:'',
        driverId:'',
        birthDay:'',
        address:''
    },
    carInfo:{
      carName:'',
      carPower:'',
      carTransmission:'',
      carSeat:'',
      carDisplacement:'',
      carImgPath:''
    },
    };
  },
  methods:{
    //查询订单评价
    queryOrderJudge(){
      queryOrderJudgeById(this.$route.query.orderId).then(response=>{
        if(response.data!=null){
        this.judge.judgeTime=response.data.judgeTime;
        this.judge.judgeScore=response.data.judgeScore;
        this.judge.judgeConent=response.data.judgeConent;
        }
      })

    },
    //提交评价
    judgeOrder(){
      if(this.judge1.judgeConent!=''){
      console.log(this.judge1);
      addOrderJudge(this.judge1).then(response=>{
        if(response.data==1){
          alert("评价成功!");
          this.$router.go(0)
        }
      });//添加订单评价
      }else{
        alert("评价失败,评级内容不能为空！");
      }
    },
    //取消订单
    cancelOrder(){
      this.order.evaluateInfo='0';
      console.log(this.order);
      updateOrder(this.order).then(response=>{
        alert("test");
        if(response.data=='1'){
          alert("取消成功")
        }
      });
      this.$router.push({path :'/order/my_order'});
    },
    //判断订单是否录入完全
    load(){
      if(this.order.orderBeginTime ||this.order.orderEndTime){
        return this.$router.push({path :'/order/order_two',query:{orderId:response.data,carPrice:this.$route.query.carPrice}});
      }
    },
    getOrderInfoDetail(){
      // 查询车辆信息
      getOrderInfo(this.$route.query.orderId)
        .then(response=>{
          // 订单Id
          // 封装订单信息
          this.order.orderId=this.$route.query.orderId
          this.order.totalMoney=response.data.totalMoney
          this.order.rentDays=response.data.rentDays
          this.order.orderBeginTime=response.data.orderBeginTime
          this.order.orderEndTime=response.data.orderEndTime
          this.order.evaluateInfo=response.data.evaluateInfo
          if(response.data.evaluateInfo==='0'){
            this.orderMessage='已取消'
          }
          if(response.data.evaluateInfo==='1'){
            this.orderMessage='已完成'
          }
          if(response.data.evaluateInfo==='2'){
            this.orderMessage='等待付款'
          }
          if(response.data.evaluateInfo==='3'){
            this.orderMessage='预定成功'
          }
          if(response.data.evaluateInfo==='4'){
            this.orderMessage='租贷中'
          }          
          // // 查询身份证信息
          this.cardInfoByCardId(response.data.cardId)

          // 查询车辆信息
          this.carInfoByCarId(response.data.carId)
          
          // 查询驾驶证信息
          this.driverInfo(response.data.carLicenceId)
          // 校验
          this.identifyInfo()
          // 请求支付订单id
          this.getPayId();
        })


    },
    // 查询租车人身份证信息
    cardInfoByCardId(cardId){
      getCustomerInfo(cardId)
        .then(response=>{
          this.card.cardName=response.data.cardName
          this.card.gender=response.data.cardGender
          this.card.birthDay=response.data.birthday
          this.card.cardId=response.data.cardId
          this.card.address=response.data.cardAddress
          if(this.card.gender===1){
            this.card.gender='男'
          }else{
            this.card.gender='女'
          }
        })
    },
    // 查询车辆信息
    carInfoByCarId(carId){
      getCarInfo(carId)
        .then(response=>{
        this.judge1.carOrCompanyId=response.data.carId;
         this.carInfo.carId=response.data.carId;
         this.carInfo.carImgPath=response.data.generalImage[0].imgPath
         this.carInfo.carName=response.data.carName
         this.carInfo.carPower=response.data.carPower
         this.carInfo.carTransmission=response.data.carTransmission
         this.carInfo.carSeat=response.data.carSeat
         this.carInfo.carDisplacement=response.data.carDisplacement
        })
    },
    // 查询驾驶证信息
    driverInfo(driverId){
      getDriverInfo(driverId)
        .then(response=>{
          this.driverDetail.name=response.data.diverName
          this.driverDetail.gender=response.data.diverGender
          this.driverDetail.beginTime=response.data.diverStartTime
          this.driverDetail.country=response.data.diverCountry
          this.driverDetail.type=response.data.diverType
          this.driverDetail.endTime=response.data.diverEndTime
          this.driverDetail.driverId=response.data.diverId
          this.driverDetail.birthDay=response.data.diverBirthday
          this.driverDetail.address=response.data.diverAddress
          if(this.driverDetail.gender===1){
            this.driverDetail.gender='男'
          }else{
            this.driverDetail.gender='女'
          }  
        })
    },
    // 身份证和驾驶证校验
    identifyInfo(){
      // 身份证校验
    identifyCard(this.card)
      .then(response=>{
        console.log(response.data)
      })
      // 驾驶证校验
    identifyDriver(this.driverDetail)
      .then(response=>{
        console.log(response.data)
      })
    },
    getPayId(){
      getAliPayId()
        .then(response=>{
          this.orderPayId=response.data
          this.payUrl='http://120.79.182.104:8080/Alipay/PayInformation?requestPort=0110&requestId='+this.orderPayId+'&p_name=欧诺租车&Id='+this.orderPayId+'&totalMoney=0.01&name=欧诺租车&describe=汽车租赁'
        })
    },

  },

    next(){
         if (this.active++ > 2) 
           this.active = 0;
     },
  mounted:function () {
    this.load();
    this.getOrderInfoDetail();
    this.queryOrderJudge();
    },
  computed:{
    startTime:function(){ //订单开始时间格式转换
      return unix2CurrentDate(this.order.orderBeginTime);
    },
    endTime:function(){//订单结束时间格式转换
      return unix2CurrentDate(this.order.orderEndTime);
    },
    judgeTime:function(){
      if(this.judge.judgeTime!=''){
      return unix2CurrentDate(this.judge.judgeTime);
      }
    }
  }
  
};
</script>
<style scoped>
body{
  font-weight: 300;
 
}
a {
  text-decoration: none;
  color: #fff;
}
.top{
  margin:30px auto;
  width: 800px;
  text-align: center;
}
.orderInfo {
    width: 980px;
    height: 1630px;
    margin: 0 auto;
}

.orderTop {
  margin-top: 20px;
    background: #fff;
    position: relative;
}
.successInfo {
  border-bottom: 1px dashed #848484;
  padding: 10px 0;
}
.orderStatus {
  font-size: 30px;
  font-family: "微软雅黑",arial,Simsun,sans-serif;
  color: #848484;
}
.orderPrice {
  font-size: 14px;
}
.price {
  display: inline-block;
  overflow: hidden;
  vertical-align: -8px;
}
.price em.rmb {
  width: 10px;
  height: 16px;
  display: inline-block;
  font: 16px/16px "微软雅黑";
  color: #f60;
  float: left;
  margin: 9px 3px 0 0;
}
.price em.num {
  display: inline-block;
  font: 30px/30px arial;
  color: #f60;
  float: left;
  margin-right: 2px;
}
.orderDetail {
  font-size: 14px;
  padding: 10px 0;
}
.order_car_info {
  background: #fff;
  margin-top: 20px;
  margin-bottom: 20px;
  
}
.order_car_info h3 {
  height: 40px;
  line-height: 40px;
  background: #eaf6fd;
  border-bottom: solid 1px #dbe4eb;
  font-size: 16px;
  color: #61a1df;
  font-family: "微软雅黑";
  padding: 0 10px;
  font-weight: 400;
}
.orderTable {
  font-size: 14px;
  border-collapse: collapse;
}
d.pre {
    position: relative;
}
.borderBlueR {
    border-right: solid 1px #dbe4eb;
}
.borderBlueB {
    border-bottom: solid 1px #dbe4eb;
}
.borderBlueR {
    border-right: solid 1px #dbe4eb;
}
.borderBlueBda {
    border-bottom: dashed 1px #dbe4eb;
}
.borderBlueBda {
    border-bottom: dashed 1px #dbe4eb;
}
.f16 {
    font-size: 16px;
}
.pink {
  background: #fdf1ea;
  color: #f60;
}
.orderFeeDetails {
  background: #fffbf8;
}
.feeItem {
    height: 74px;
    padding: 0 10px;
    overflow: hidden;
}
.feeItem .feePrice {
    float: right;
    margin-top: 27px;
}
.feeItem .feeName {
    padding: 0 10px;
    line-height: 20px;
    display: inline-block;
    float: left;
    font-size: 14px;
    font-weight: 700;
    color: #333;
    margin-top: 30px;
}
.feeName b.down {
    width: 12px;
    height: 8px;
    background: url(https://image.zuchecdn.com/newversion/common/order.png?v=201506300000) no-repeat -23px -47px;
    overflow: hidden;
    display: none;
    position: absolute;
    left: 83px;
    top: 36px;
}
.feeName b.up {
    width: 12px;
    height: 8px;
    background: url(https://image.zuchecdn.com/newversion/common/order.png?v=201506300000) no-repeat -63px -196px;
    overflow: hidden;
    display: block;
    position: absolute;
    left: 83px;
    top: 36px;
}
.selectabletotal {
    position: relative;
    cursor: pointer;
}
.feeline50 {
    height: 50px;
    padding: 0 10px;
    overflow: hidden;
    display: none;
}
.orderFeeTotal {
    padding: 22px 10px;
    text-align: right;
    position: relative;
    background: #fff;
}
.orderFeeTotal .yjtotal {
    font-size: 14px;
    font-weight: 700;
    color: #848484;
    display: inline-block;
}
.orderFeeTotal .on_OrderpOrangeB {
    position: relative;
    top: 10px;
}
.on_OrderpOrangeB {
    display: inline-block;
    overflow: hidden;
}
.feeline50 .on_OrderpOrangeM em.rmb {
    font: bold 14px/14px "微软雅黑";
    margin: 2px 0 0 0;
}
.on_OrderpOrangeM em.rmb {
    width: 10px;
    height: 13px;
    display: inline-block;
    font: bold 16px/16px "微软雅黑";
    color: #f60;
    float: left;
    margin: 5px 5px 0 0;
    _margin-right: -1px;
}
.feeline50 .on_OrderpOrangeM em.num {
    font: bold 18px/18px arial;
}
.on_OrderpOrangeM em.num {
    display: inline-block;
    font: bold 24px/24px arial;
    color: #f60;
    float: left;
    margin-right: 2px;
}
.feeline50 .feeName {
    padding: 0 26px;
    line-height: 20px;
    display: inline-block;
    float: left;
    font-size: 12px;
    color: #848484;
    margin-top: 15px;
}
.bold {
    font-weight: 700;
}
.orderFeeTotal .on_OrderpOrangeB {
    position: relative;
    top: 10px;
}
.on_OrderpOrangeB {
    display: inline-block;
    overflow: hidden;
}
.on_OrderpOrangeB em.rmb {
    width: 10px;
    height: 13px;
    display: inline-block;
    font: bold 16px/16px "微软雅黑";
    color: #f60;
    float: left;
    margin: 11px 5px 0 0;
    margin-right: -1px;
}
.on_OrderpOrangeB em.num {
    display: inline-block;
    font: bold 36px/32px arial;
    color: #f60;
    float: left;
    margin-right: 2px;
}
.content {
    height: 40px;
    line-height: 40px;
    background: #eaf6fd;
    border-bottom: solid 1px #dbe4eb;
    font-size: 16px;
    color: #61a1df;
    font-family: "\5FAE\8F6F\96C5\9ED1";
    padding: 0 10px;
}

.upload{
  float: left;
  width: 50%;
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
  height:220px;
  width: 100%;
}
.next{
  clear: both;
  margin:10px auto;
  text-align: center;
  width: 1000px;
  height: 50px;
  line-height: 50px;
}
.order_status_p{
    font-size:18px;
    font-weight: 500px;
    text-align: center;
    color:#2b90d9;
}
</style>