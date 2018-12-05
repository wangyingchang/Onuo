<template>
  <div class="car_detail">
    <div class="car_content">
       <el-carousel :interval="4000" type="card" height="300px">
         <el-carousel-item v-for="(item,index) in carDetail.generalImage" :key="index">
          
             <img :src="item.imgPath" style="width:490px;height:300px;">
          
         </el-carousel-item>
      </el-carousel>
      <div id="carInfo">
        <div class="baseinfo"> 
            <table class="carList_tb1" cellpadding="0" cellspacing="0" border="0">
              <tr>
                <td>
                  <span style="font-size:18px;font-weight:bolder;">车辆基本信息</span>
                  
                </td>
                 
                <td>
                  <el-rate
                   v-model="avgScore"
                          disabled
                        show-score
                       text-color="#ff9900"
                      score-template="{avgScore}">
                  </el-rate>
                </td>
              </tr>
            </table>
        </div>
        <div class="detailinfo">
          <table class="carList_tb2" cellpadding="0" cellspacing="0" border="0">
              <tr>
                <td>
                  <img src="../../../../static/image/car.png">
                  <span class="comp">车名：{{carDetail.carName}}</span>
                </td>
                <td>
                   <img src="../../../../static/image/car1.png">
                   <span class="comp">品牌：{{carDetail.carBrand.brandName}}</span>
                </td>
              </tr>
              <tr>
                <td><img src="../../../../static/image/useyears.png">
                  <span class="comp">使用年限：{{carDetail.carYear}}</span>
                </td>
                <td>
                  <img src="../../../../static/image/cartype.png" >
                  <span class="comp">车 型：{{carDetail.carType}}</span>
                  <!-- <el-rate style="display:inline;margin-left:-130px;" v-model="companyDetailInfo.companyGrade" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" disabled>
                  </el-rate> -->
                </td>
              </tr>
          </table>
            <table class="carList_tb1" cellpadding="0" cellspacing="0" border="0">
              <tr>
                <td>
                  <span style="font-size:18px;font-weight:bolder">车辆配置信息</span>
                </td>
              </tr>
            </table>
             <table class="carList_tb2" cellpadding="0" cellspacing="0" border="0">
              <tr>
                <td><img src="../../../../static/image/seat.png">
                  <span class="comp">座位：{{carDetail.carSeat}}</span>
                </td>
                <td><img src="../../../../static/image/pailiang.png">
                  <span class="comp">排量：{{carDetail.carDisplacement}}T</span>
                </td>
              </tr>
              <tr>
                <td><img src="../../../../static/image/color.png">
                  <span class="comp">颜色：{{carDetail.carColor}}</span>
                </td>
                <td><img src="../../../../static/image/power.png">
                  <span class="comp">燃油：{{carDetail.carPower}} </span>
                </td>
              </tr>
               <tr>
                <td><img src="../../../../static/image/windon.png">
                  <span class="comp">天窗：{{carDetail.carWindon}}</span>
                </td>
                <td><img src="../../../../static/image/gearbox.png">
                  <span class="comp">档 型：{{carDetail.carTransmission}} </span>
                </td>
              </tr>
               <tr>
                <td><img src="../../../../static/image/qinang.png">
                  <span class="comp">安全气囊数：{{carDetail.airBag}}</span>
                </td>
                <td><img src="../../../../static/image/GPS Device.png">
                  <span class="comp">GPS：{{carDetail.carGps}} </span>
                </td>
              </tr>
               <tr>
                <td><img src="../../../../static/image/maintain.png">
                  <span class="comp">保养时间：{{carDetail.carMaintain}}</span>
                </td>
                <td><img src="../../../../static/image/price.png">
                  <span class="comp">车 价：{{carDetail.carPrice}} </span>
                </td>
              </tr>
              <tr>
                <td>
                  <img src="../../../../static/image/zhongliang.png">
                  <span class="comp">重量：{{carDetail.carQuality}}kg</span>
                </td>
                <td>
                  <img  v-if="orderInfo!=''" src="../../../../static/image/time1.png">
                  <span class="comp" v-if="orderInfo!=''">租赁中：{{time(orderInfo[0].orderBeginTime)}}/{{time(orderInfo[0].orderEndTime)}}</span>
                </td>
              </tr>
          </table>
           <div class="car_btn">
              <el-button @click="getJudge">查看评论</el-button>
              <router-link :to="{path:'/order/order_first',query:{carId: carId,carPrice: this.$route.query.car_price}}">
                <el-button v-if="orderInfo==''">立即预定</el-button>
              </router-link>
           </div>

           <div id="car_comment" style="display:none;">
           <div class="page">
            <el-pagination
                background
                @current-change="changeIndex"
                :current-page="pageCode"
                :page-size="pageSize"  
                :total="totalCount"
                layout="total, prev, pager, next, jumper"
            ></el-pagination>
            </div>
           <!--单个评论-->
           <div class="comment_detail" v-for="(item,index) in carJudgeInfo" :key="index">
             <div class="comment_left">
               <div class="user">
                <img :src="item.user.avatar">
                <p>{{ item.user.username}} :</p>
              </div>
             </div>
             <div class="comment_right">
                <el-rate v-model="item.judgeScore" disabled
                         show-score
                         text-color="#ff9900"
                         score-template="{item.judgeScore}">
                </el-rate>
                <div class="comment_time">
                  {{time(item.judgeTime)}}
                </div>
                <div class="comment_content">
                  <span>内容:{{ item.judgeConent }}</span>
                </div>

             </div>
           </div>

           </div> 
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import {getCarById} from '@/api/carinfo'
import {getCarJudgeInfo} from '@/api/carinfo'
import {getAvgScore} from '@/api/carinfo'
import {unix2CurrentDate} from '@/utils/date'
import {getOrderTime} from '@/api/order';

export default {
 name: 'car_detail',
  data () {
    return {
      pageSize:3,// 每页显示数
      totalCount:null,// 总记录数
      pageCode:1,// 默认当前页
      carId:'',
      orderInfo:[],
      evaluateInfo:'4',
      carJudgeInfo:[],
      carDetail:{},
      avgScore:null,
      src1:'../../../../static/image/car1-1.jpg',
      src2:'../../../../static/image/car1-2.jpg',
      src3:'../../../../static/image/car2-1.jpg',
      src4:'../../../../static/image/car2-2.jpg',
      src5:'../../../../static/image/car3-1.jpg',
      src6:'../../../../static/image/car3-2.jpg',
      src7:'../../../../static/image/car4-1.jpg',
      src8:'../../../../static/image/car4-2.jpg',
      src9:'../../../../static/image/car5-1.jpg',
      src10:'../../../../static/image/car5-2.jpg',
      src11:'../../../../static/image/car6-1.jpg',
      src12:'../../../../static/image/car6-2.jpg',
      src13:'../../../../static/image/car7-1.jpg',
      src14:'../../../../static/image/car1-2.jpg',
      src15:'../../../../static/image/61_a.jpg',
      src16:'../../../../static/image/61_b.jpg',
      src17:'../../../../static/image/61_c.jpg',
      src18:'../../../../static/image/61_d.jpg'
    }
  },
   created(){
    //接收传过来的值
    this.carId=this.$route.query.carId;
   },
    
  //  // 转换时间
  //   filters: {
  //       formatDate(time) {
  //           var date = new Date(time);
  //           return formatDate(date, 'yyyy-MM-dd hh:mm');
  //       }
  //   },
  methods:{
    //查询车辆租定中订单时间
   getTime() {
     getOrderTime(this.carId,this.evaluateInfo).then(response=>{
       if(response.data!=''){
          this.orderInfo=response.data;
       }
     })
   },

   formatTime(myTime){
      // 格式化时间
        //获取当前时间
        let date = new Date(myTime);
        let year = date.getFullYear();
        let month = date.getMonth() + 1;
        let day = date.getDate();
        if (month < 10) {
            month = "0" + month;
        }
        if (day < 10) {
            day = "0" + day;
        }
        let nowDate = year + "-" + month + "-" + day;
        return nowDate;
    },

      // 查询车辆详细信息
  getCarDetail(){
      getCarById(this.carId)
        .then(response=>{
           this.carDetail=response.data;
      })
    },
    // 点击按钮查询评价信息
    getJudge() {
      var show = document.getElementById("car_comment")
      if(show.style.display=='none') {
        show.style.display='inline';
      getCarJudgeInfo(this.pageCode,this.pageSize,this.carId)
      .then(response=>{
        this.carJudgeInfo=response.data.list;
        this.totalCount=response.data.total;
        this.pageCode=response.data.pageNum;
        for(let i=0;i<this.carJudgeInfo.length;i++) {// 格式化评价时间
          this.carJudgeInfo[i].judgeTime = this.formatTime(this.carJudgeInfo[i].judgeTime);
        }
      })
      }else{
        show.style.display='none';
      }
    } ,
    // 分页
    changeIndex(val) {
      getCarJudgeInfo(val,this.pageSize,this.carId)
      .then(response=>{
        this.carJudgeInfo=response.data.list;
        this.totalCount=response.data.total;
        this.pageCode=response.data.pageNum;
      })
    },
// 查询车辆平均评价分
   getCarAvgScore() {
     getAvgScore(this.carId)
     .then(response=>{
       this.avgScore=response.data;
     })
   }
    },
  mounted: function(){
    this.getCarDetail();
    this.getCarAvgScore();
    this.getTime();
    },
  computed:{
      time:function (e) {
        return function(e){
          return unix2CurrentDate(e);
        }
      }
  }
}
</script>
<style scoped>

ul {
  list-style: none;
}
li {
  float: left;
}
.car_detail[data-v-5a921af2] {
  margin: 10px 0 0 0;
}
.car_detail {
    width: 100%;
    background-color: #ffffff;
}
  .car_content {
    width: 980px;
    margin: 0 auto;
  }

.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
  .el-button+.el-button {
    margin-left: 10px;
}
.car_btn {
  width: 100%;
  height: 80px;
  padding-left: 80px;
  border-bottom: 1px solid rgb(191, 214, 238);
}
.el-button {
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    background: #fff;
    border: 1px solid #c4c4c4;
    color: #1f2d3d;
    margin: 30px 20px 20px 10px;
    padding: 10px 15px;
    border-radius: 4px;
}

 .car_detail {
    width: 100%;
    margin: 70px 0 0 0;
    background-color: #ffffff;
  }
  .car_content {
    width: 980px;
    margin: 0 auto;
  }
.baseinfo {
  width: 100%;
  height: 45px;
  margin: 0 auto;
  /* border-bottom: 1px solid rgb(97,161,223); */

}

.detailinfo {
  width: 980px;
  height: 600px;
  margin: 10px auto;
}
.carList_tb1 {
  width: 100%;
  margin: 25px auto;
  border-bottom: 1px solid rgb(191, 214, 238)
}
.carList_tb1 tr{
  width: 100%;
  /* text-align: center; */
  height: 45px;
  margin: 0,auto;
}

.carList_tb1 td{
  width: 50%;
  height: 45px;
  padding-left: 100px;
  border-bottom: 1px solid #F2F2F2;
}
.carList_tb2 {
  width: 100%;
  margin: 0 auto;
 
}
.carList_tb2 tr{
  width: 100%;
  text-align: center;
  margin: 0,auto;
}
.carList_tb2 td{
  width: 50%;
  height: 45px;
  border-bottom: 1px dashed rgb(229, 235, 240);
}
.carList_tb2 td img {
 width:20px;
 height:20px; 
 margin-left:20%;
 margin-right: 2%;
 float: left;
}
.comp {
  font-size: 14px;
  /* color:rgb(97, 161, 223);  */
  float: left;
  color: black;
  font-weight: 1;
}
#car_comment {
  margin-bottom: 10px;
}
.comment_detail {
  height: 120px;
  border-top: 1px solid rgb(97, 161, 223);
}
.comment_left {
  margin: auto;
  width: 20%;
  height: 120px;
  float: left;
}
.comment_right {
  width: 80%;
  height: 120px;
  float: left;
}
.user {
  width: 100%;
  height: 150px;
  color: rgb(97, 161, 223);
}
.user img {
  margin:40px 20px;
  height: 50px;
  width: 50px;
  float: left;

}
.user p {
  font-size: 18px;
 
  margin-top: 40px;
  text-align: center;
  float: left;
}
 .el-rate[data-v-5a921af2] {
    margin:20px 0px 0px;
}
.comment_content {
  width: 650px;
  font-size: 14px;
  font-weight: 500;
}
.comment_time {
  font-size: 12px;
  color: rgb(97, 161, 223);
}
.page{
    clear: both;
    text-align: center;
    margin:20px auto;
}
</style>
