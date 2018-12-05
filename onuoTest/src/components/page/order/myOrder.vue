<template>
  <div class="my_order" style="background-color:#ebedf0;height:950px;">
      <div class="content">
          <div class="right">
            <hr>
            <div class="status">
                <el-radio-group 
                    v-model="statusType"
                    @change="tableChange"
                    >
                    <el-radio-button label="全部"></el-radio-button>
                    <el-radio-button label="等待付款"></el-radio-button>
                    <el-radio-button label="预定成功"></el-radio-button>
                    <el-radio-button label="租贷中"></el-radio-button> 
                    <el-radio-button label="已完成"></el-radio-button>
                    <el-radio-button label="已取消"></el-radio-button>
                </el-radio-group>
            </div>
            <div class="time">
                    <el-date-picker
                    v-model="startTime"
                    type="date"
                    placeholder="开始时间">
                    </el-date-picker>
                    <span class="demonstration">--</span>
                    <el-date-picker
                    v-model="endTime"
                    type="date"
                    placeholder="结束时间">
                    </el-date-picker>
                    <el-button type="primary" @click="search">查询</el-button>
            </div>
            <hr style="clear:both;">
       <!--info-->
      <div class="content_top" >
        <div class="table">
            <p style="width:450px;float:left;text-align:center;">车辆信息</p>
            <p style="width:350px;float:left;text-align:center;">订单时间</p>
            <p style="width:150px;float:left;text-align:center;">订单金额</p>
            <p style="width:100px;float:left;text-align:center;">订单状态</p>
        </div>
        <!--车辆信息-->
        <div v-for="(item,index) in orderList" :key="index" style="margin:5px auto;">
        <div class="content_car_left" >
          <div class="content_car_left_img">
            <router-link :to="{path:'/car/car_detail',query:{carId: item.carId}}">
                <img  :src="item.generalImage.imgPath"/>
            </router-link>
          </div>
          <div class="content_car_left_info">
            <p style="font-weight:500;">{{item.carInfo.carName}}</p>
            <span>{{item.carInfo.carPower}}</span>
            <span>{{item.carInfo.carType}}</span>
            <span>{{item.carInfo.carTransmission}}</span>
            <span>乘坐{{item.carInfo.carSeat}}人</span><br>
            <span>订单号:{{item.orderId}}</span>
          </div>
        </div>
        <!--取还车时间-->
        <div class="content_time">
            <p>下单时间:<span>{{time(item.orderBeginTime)}}</span></p>
            <p>结单时间:<span>{{time(item.orderEndTime)}}</span></p>
        </div>
        <!--订单总额-->
        <div class="content_money">
            <p>￥:{{item.totalMoney}}</p>
        </div>
        <!--订单状态 -->
        <div class="content_status">
            <router-link :to="{path:'/order/orderInfo',query:{orderId: item.orderId}}">
                <el-button type="primary">查看订单</el-button>
            </router-link>
        </div>
        <hr style="clear:both;">
        </div>
      </div>
        <!--分页栏-->
        <div class="page">
            <el-pagination
                background="true"
                @current-change="pageChange"
                :current-page="pageCode"
                :page-size="pageSize"  
                :total="totalCount"
                layout="total, prev, pager, next, jumper"
            ></el-pagination>
        </div>
        <hr>
        <div style="background-color:#ebedf0;height:20px;"></div>
        <p class="order_status_p">订单状态说明</p>
        <hr>
        <div class="order_status_info">
            <div class="item">
                <p style="color:gray;font-size:15px;">已取消(0)</p>
                <p>订单已经取消</p>
            </div>
            <div class="item">
                <p style="color:orange;font-size:15px;">已完成(1)</p>
                <p>已还车，订单结算完毕</p>
            </div>
            <div class="item">
                <p style="color:red;font-size:15px;">等待付款(2)</p>
                <p>订单尚未付款，请在1小时内完成支付</p>
            </div>
            <div class="item">
                <p style="color:green;font-size:15px;">预订成功(3)</p>
                <p>订单已确认，尚未提车</p>
            </div>
            <div class="item">
                <p style="color:blue;font-size:15px;">租贷中(4)</p>
                <p>提车成功，正在租贷中</p>
            </div>

        </div>
    </div>
  </div>
  </div>
</template>

<script>
import axios from "axios";//axios请求
import store from '@/store'
import {unix2CurrentDate} from "@/utils/date"
import {myOrder} from "@/api/order";//查询我的订单

export default {
  name: "my_order",
  data() {
    return {
      msg: "我的订单页",
      statusType:'全部',
      pageSize: 3, // 每页显示数
      totalCount: 0, // 总记录数
      pageCode: 1, // 默认当前页
      userId:store.getters.userId,//绑定session中的userId
      status:'',
      startTime:null,
      endTime:null,
      orderList:[],
    };
  },
  methods:{
      //加载订单
      loadMyOrder(){
            myOrder(this.pageCode,this.pageSize,this.userId,this.status,this.startTime,this.endTime).then(response=>{
                this.orderList=response.data.list;
                this.totalCount=response.data.total;
            })
      },
      //订单状态改变
      tableChange(val){
        if(val=='全部'){
            this.statusType='全部';
            this.status='';
        }else if(val=='租贷中'){
            this.statusType='租贷中';
            this.status='4';
        }else if(val=='预定成功'){
            this.statusType='预定成功';
            this.status='3'
        }else if(val=='等待付款'){
            this.statusType='等待付款';
            this.status='2'
        }else if(val=='已完成'){
            this.statusType='已完成';
            this.status='1'
        }else if(val=='已取消'){
            this.statusType='已取消';
            this.status='0'
        }
        this.pageCode=1;
        myOrder(this.pageCode,this.pageSize,this.userId,this.status,this.startTime,this.endTime).then(response=>{
            this.orderList=response.data.list;
            this.totalCount=response.data.total;
        })
      },
      //页码改变
      pageChange(val){
        if(val=='全部'){
            this.statusType='全部';
            this.status='';
        }else if(val=='租贷中'){
            this.statusType='租贷中';
            this.status='4';
        }else if(val=='预定成功'){
            this.statusType='预定成功';
            this.status='3'
        }else if(val=='等待付款'){
            this.statusType='等待付款';
            this.status='2'
        }else if(val=='已完成'){
            this.statusType='已完成';
            this.status='1'
        }else if(val=='已取消'){
            this.statusType='已取消';
            this.status='0'
        }
        this.pageCode=val;
        myOrder(this.pageCode,this.pageSize,this.userId,this.status,this.startTime,this.endTime).then(response=>{
            this.orderList=response.data.list;
        })
      },
      //搜索按钮
      search(){
        if(val=='全部'){
            this.statusType='全部';
            this.status='';
        }else if(val=='租贷中'){
            this.statusType='租贷中';
            this.status='4';
        }else if(val=='预定成功'){
            this.statusType='预定成功';
            this.status='3'
        }else if(val=='等待付款'){
            this.statusType='等待付款';
            this.status='2'
        }else if(val=='已完成'){
            this.statusType='已完成';
            this.status='1'
        }else if(val=='已取消'){
            this.statusType='已取消';
            this.status='0'
        }
        // this.startTime=unix2CurrentDate(this.startTime);
        // this.endTime=unix2CurrentDate(this.endTime);
        this.pageCode=1;
        myOrder(this.pageCode,this.pageSize,this.userId,this.status,this.startTime,this.endTime).then(response=>{
            console.log(response.date);
            this.orderList=null;
        })
      }
  },
  mounted:function(){
      this.loadMyOrder();
  },
  computed:{
      time:function(time){
          return function(time){
              return unix2CurrentDate(time);
          }
          
      }
  }
};
</script>
<style scoped>
.top{
    margin: auto;
    width: 1300px;
    height:100px;
}
.top_weather{
    float: left;
    width: 250px;
    height: 100%;
}
.top_me{
    float: left;
    width: 350px;
    height: 100%;
}
.top_info{
    float: left;
    width: 160px;
    height: 100%;
}
.top_clear{
    float: left;
    width: 170px;
    height: 100%;
}


.content{
    background-color: white;
    margin: 20px auto;
    width: 1100px;
    height:1000px
}
.right{
    margin-top:10px;
    float: right;
}
.status{
    margin-left:100px;
    height: 80px;
    line-height: 80px;
    float: left;
}
.time{
    float: right;
    margin-right: 50px;
    height: 80px;
    line-height: 80px;
}


.content_top{
  margin:10px auto;
  height: 150px;
  width: 1100px;
}
.table{

    height: 30px;
    line-height: 30px;
    font-size: 15px;
    background: #dae9f4;
}
.content_car_left{
  margin: auto;
  float:left;
  width: 500px;
  height:150px;
}
.content_car_left_img{
  float: left;
  margin-left:90px;
  margin-top:5px;
  width: 200px;

}
.content_car_left_img img{
  margin-left: 10px;
  width: 200px;
  border-radius:10px;
}
.content_car_left_info{
  padding-top:30px; 
  margin-left: 20px;
  float: left;
  width: 150px;
}
.content_car_left_info p{
  font-size: 15px;
  color:#2b90d9;
}
.content_time{
    float: left;
    width:300px;
    height: 150px;
    line-height: 70px;
    text-align: center;
}
.content_money{
    float: left;
    width:150px;
    height: 150px;
    line-height: 150px;
    text-align: center;
    font-size:20px;
    color:orange;
    font-weight: 500;
}
.content_status{
    padding-top:50px; 
    float: left;
    width:150px;
    height: 150px;
    color:orange;
    text-align: center;
    font-size:15px;
}
.page{
    clear: both;
    margin:auto;
    padding: 15px;
    height:50px;
    line-height: 50px;
    text-align: center; 
}
.order_status_info{
    margin:10px auto;
    height: 220px;
    width:1000px;
}
.order_status_p{
    font-size:18px;
    font-weight: 500px;
    text-align: center;
    color:#2b90d9;
}
.item{
    margin:10px;
    float: left;
    width:300px;
    height:90px;
    background-color: #dae9f4
}
.item p{
    margin:10px;
    font-size: 15px;
}
</style>