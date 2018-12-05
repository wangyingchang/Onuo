<template>
  <div class="carPreferential" style="background-color:#ebedf0;">
    <!-- 优惠活动时间-->
    <div class="top">
      <el-form ref="form" :model="sizeForm" label-width="200px" size="medium">
        <!--活动区域-->
        <div class="act_area">
        </div>
        <!-- 活动时间 -->
        <div class="act_time">
          <el-form-item label="活动时间">
            <el-col :span="13">
              <el-date-picker type="date" placeholder="开始时间" v-model="sizeForm.date_begin" ></el-date-picker>
            </el-col>
            <el-col :span="1">
              <el-date-picker type="date" placeholder="结束时间" v-model="sizeForm.date_end" ></el-date-picker>
            </el-col>
          </el-form-item>
        </div>
        <!--活动搜索按钮-->
        <div class="act_search">
          <el-button type="primary" @click="getActivityCarByTime">搜索</el-button>
        </div>
      </el-form>
    </div>
    <!-- 优惠活动List-->
    <div class="content">
      <!-- 活动对象-->
      <div class="actObject" v-for="(actObject,index) in activityObject" :key="index"> 
        <div class="left">
          <img :src="actObject.generalImage.imgPath"/>
        </div>
        <div class="right">
          <h3>{{actObject.discountDesc}}</h3>
          <p><span>车辆：</span>{{actObject.carBrand.brandName}}{{actObject.carInfo.carName}}/{{actObject.carInfo.carColor}}/{{actObject.carInfo.carDisplacement}}L{{actObject.carInfo.carTransmission}}</p><br>
          <p><span>租金：</span>{{actObject.price}}元</p><br>
          <p><span>租用天数：</span>{{actObject.rentDays}}</p><br>
          <p><span>活动时间：</span>{{actObject.beginTime}}/{{actObject.endTime}}</p><br>
          <p><span>优惠区域：</span>{{actObject.carInfo.companyArea}}</p><br>
          <el-button type="primary">立即租车</el-button>
          <router-link :to="{path:'/car/car_detail',query:{carId: actObject.carInfo.carId}}">
          <el-button type="primary">车辆详情</el-button>
          </router-link>
        </div>
      </div>
    </div>

  </div>
</template>
<script>
import {allActivityCar,allActivityCarWithTime} from '@/api/activityinfo'
import { notEqual } from 'assert';
export default {
  name: 'car_search',
  data () {
    return {
      msg: '优惠活动',
      sizeForm: {
          name: '',
          region: '',
          date_begin: '',
          date_end: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
      activityObject:[],
    }
  },
  methods:{
    // 查询所有优惠活动
    getAllActivityCar(){
      allActivityCar()
        .then(response=>{
          this.activityObject=response.data;
          // 调用格式化时间方法
          for(let i=0;i<this.activityObject.length;i++){
          this.activityObject[i].endTime=this.formatTime(this.activityObject[i].endTime);
          this.activityObject[i].beginTime=this.formatTime(this.activityObject[i].beginTime);
        }
          
        })
    },
    // 根据活动开始时间和结束时间查询优惠活动
    getActivityCarByTime(){
      alert(this.sizeForm.date_begin+this.sizeForm.date_end);
      allActivityCarWithTime(this.sizeForm.date_begin,this.sizeForm.date_end)
        .then(response=>{
          this.activityObject=response.data;
          // 调用格式化时间方法
          for(let i=0;i<this.activityObject.length;i++){
          this.activityObject[i].endTime=this.formatTime(this.activityObject[i].endTime);
          this.activityObject[i].beginTime=this.formatTime(this.activityObject[i].beginTime);
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
    }
  },
  mounted: function(){
    this.getAllActivityCar();
  },
  
}
</script>
<style scoped>
.top{
  margin:auto;
  padding: 20px;
  height: 80px;
  line-height: 80px;
  width: 1000px;
  color:gray;
  border-bottom: 2px solid rgb(223, 221, 221);
}
.top .act_time{
  margin-left: 10%;
  height: 40px;
  float:left;
}
.top .act_search{
  margin-left: 30px;
  height: 40px;
  line-height: 40px;
  float: left;
}
.content{
  margin: auto;
  padding-top:30px; 
  width:1000px; 
  height: auto;
}
.content .actObject {
  margin: 20px auto 20px auto;
  width: 100%;
  height: 350px;
  background-color: white;
}

.content .actObject .left{
  float: left;
  width: 50%;
}
.content .actObject .left img{
  margin: 70px 0 0 80px;
  height: 250px;
  width: 350px;
}
.content .actObject .right{
  padding: 50px;
  float: right;
  width: 50%;
}
</style>
