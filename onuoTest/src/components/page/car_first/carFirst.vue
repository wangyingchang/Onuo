<template>
    <div class="first_main" style="background-color:#ebedf0;">

      <!-- 第一部分 -->
      <div class="top">
        <!-- 轮播图 -->
        <div class="wheel_img">
          <el-carousel indicator-position="outside" height="500px">
            <el-carousel-item v-for="item in 4" :key="item" class="caonimade">
			          <img src="../../../../static/image/aaa.jpg" v-if="item == 1" class="banner-style"/>
                <img src="../../../../static/image/aab.jpg" v-if="item == 2" class="banner-style"/>
                <img src="../../../../static/image/aac.jpg" v-if="item == 3" class="banner-style"/>   
                <img src="../../../../static/image/aad.jpg" v-if="item == 4" class="banner-style"/>  
			</el-carousel-item>
          </el-carousel>
        </div>
        <!--轮播图中的tags-->
        <div class="tags">
          <el-tabs type="border-card">
            <!-- 特价套餐 -->
            <el-tab-pane label="特价套餐">
              <div class="package">
                <a href="/#/car_search/">
                <div id='day' class="day1" @mouseover='change1'>
                  
                </div>
                </a>
                <a  href="/#/car_search/">
                <div id='week' class="week" @mouseover='change2'>
                
                </div>
                </a>
                <a  href="/#/car_search/">
                <div id='mouth' class="mouth" @mouseover='change3'>

               
                </div>
                </a>
                <a  href="/#/car_search/">
                <div id='year' class="year" @mouseover='change4'>

               
                </div>
                </a>
              </div>
            </el-tab-pane>
            <!-- 优惠活动 -->
            <el-tab-pane label="优惠活动">
              <div class="activity">
                <a href="#">
                  <div>
                <p>{{activityDesc}}</p>
                <p>{{companyName}}</p>
                </div>
                </a>
                <a  href="#"><div>
                <p>{{activityDesc}}</p>
                <p>{{companyName}}</p>
                </div></a>
                <a  href="#"><div>
                <p>{{activityDesc}}</p>
                <p>{{companyName}}</p>

                </div></a>
                <a  href="#"><div>
                <p>{{activityDesc}}</p>
                <p>{{companyName}}</p>
                </div></a>
              </div>
            </el-tab-pane>
            <!-- 企业租车 -->
            <el-tab-pane label="企业租车">
              <div class="enterprise">
              <img src="../../../../static/image/Q1.png" alt="">
              <img src="../../../../static/image/Q2.png" alt="">
              <img src="../../../../static/image/Q3.png" alt="">
              <img src="../../../../static/image/Q4.png" alt="">
              </div>
            </el-tab-pane>
            
          </el-tabs>
          
        </div>
        
      </div>
<div class="induct" ><img src="../../../../static/image/caca.png" alt="" style="border-left:1px solid #DDDDDD;border-right:1px solid #DDDDDD;">

</div>
      
        <div style="margin-bottom: 60px;;width:100%;height:380px;background-color:#fff">
          <div style="margin:0 auto;">
            <ul class="niduct-body">
              <li class="niduct-body-font">短租自驾</li>
              <li class="niduct-body-img"><img src="../../../../static/image/shortRent.png" alt=""></li>
              <li class="niduct-body-small">24小时轻松取 / 还车</li>
              <router-link :to="'car_search'"><li class="niduct-body-button"><el-button >我要租车</el-button></li></router-link>
              
            </ul>
            <ul class="niduct-body">
              <li class="niduct-body-font">长租服务</li>
              <li class="niduct-body-img"><img src="../../../../static/image/longRent.png" alt=""></li>
              <li class="niduct-body-small">长租一次告别常租</li>
              <router-link :to="'car_search'"><li class="niduct-body-button"><el-button >我要租车</el-button></li></router-link>
            </ul>
            <ul class="niduct-body">
              <li class="niduct-body-font">企业租车</li>
              <li class="niduct-body-img"><img src="../../../../static/image/qiyeRent.png" alt=""></li>
              <li class="niduct-body-small">企业出行一步搞定</li>
              <router-link :to="'car_search'"><li class="niduct-body-button"><el-button >我要租车</el-button></li></router-link> 
            </ul>
            <ul class="niduct-body">
              <li class="niduct-body-font">顺风车站</li>
              <li class="niduct-body-img"><img src="../../../../static/image/quickRent.png" alt=""></li>
              <li class="niduct-body-small">价格便宜就是任性</li>
              <router-link :to="'car_search'"><li class="niduct-body-button"><el-button >我要租车</el-button></li></router-link>
            </ul>
          </div>
        
      </div>
      <!-- 第二部分 -->
      <div style="background-color:white;">
        <div style="margin-top:60px; text-align: center;">
          <p style="font-size:28px;font-weight: 50;padding-top:50px;">热门车型</p>
          <!--卡片-->
        </div>
      <div class="mid-next">
        
        <div class="card" v-for="(item,index) in carInfo" :key="index">
          
          <router-link :to="{path:'/car/car_detail',query:{carId: item.carId}}">
            <el-button style="margin:0;padding:0;border:0;">
                <!-- <img src="../../../../static/image/87.jpg"> -->
                <!-- <img src="https://fimg.zuchecdn.com/upload/web/modepic/849.jpg" alt=""> -->
                
                <img :src="item.generalImage[0].imgPath">
            </el-button></router-link>
          <p  style="font-size:16px;color:black;">{{item.carName}}</p>
          
          <span style="font-size:14px;">{{item.carPower}}/{{item.carType}}/{{item.carTransmission}} 乘坐{{item.carSeat}}人</span>
          
          
        </div>
        </div>
      
        <div class="more" style="padding-bottom:30px;">
         
        </div>
    </div>
    <div style="text-align: center; background-color:#FFF;margin-top:60px;">
      <p style="font-size:28px;font-weight: 50;padding-top:50px;padding-bottom:50px;margin-bottom;">优惠活动</p>
    
    </div>
    <div class="jujujujuzhong">
      
      <ul class="niduct-body">
        <li><img src="https://fimg.zuchecdn.com/upload/web/HomePage/ActivityList/2017/20170620Newmember_lis.jpg" alt=""></li>
        <li class="niduct-body-font2">新用户留步 150元请收下</li>
        <li class="niduct-body-small2">连环送券 租车直抵</li>
        <li class="niduct-body-small2">专享特惠 只送给你</li>
      </ul>
      
      <ul class="niduct-body">
        <li><img src="https://fimg.zuchecdn.com/upload/web/HomePage/ActivityList/2018/20180123_fengbao.jpg" alt=""></li>
        <li class="niduct-body-font2">万辆新车来袭 69元起租</li>
        <li class="niduct-body-small2">适用于全国直营门店,雪佛兰科鲁兹、别克英朗、大众朗逸...</li> 
      </ul>
      <ul class="niduct-body">
        <li><img src="https://image.zuchecdn.com/newversion/news/huodong/20160311pc_news_03.jpg" alt=""></li>
        <li class="niduct-body-font2">超值优惠 低至6折</li>
        <li class="niduct-body-small2">月租价格 再刷新低</li>
        <li class="niduct-body-small2">低价诱惑 就等你了</li>
      </ul>
      <ul class="niduct-body">
        <li><img src="https://fimg.zuchecdn.com/upload/web/HomePage/ActivityList/2017/20160909hertz_web.jpg" alt=""></li>
        <li class="niduct-body-font2">赫兹全球租车 点我直达</li>
        <li class="niduct-body-small2">全球租车网络 横跨6大洲</li>
        <li class="niduct-body-small2">支持异国还车 超多优惠轮番来袭</li>
      
      
      </ul>
      </div>
    </div>
</template>

<script>
import axios from "axios";
import {getHotCar} from '@/api/indexinfo'
export default {
  name: "Pos",
  data(){
    return{
      input1: '',
      input2: '',
      checked:'',
      activityDesc:'国庆优惠',
      companyName:'苏州驰星科技有限公司',
      carInfo:[]
    }
  },
  methods: {
    change1(){
        document.getElementById('day').className='day1'
        document.getElementById('week').className='week'
        document.getElementById('mouth').className='mouth'
        document.getElementById('year').className='year'
    },
    change2(){
        document.getElementById('day').className='day'
        document.getElementById('week').className='week1'
        document.getElementById('mouth').className='mouth'
        document.getElementById('year').className='year'
    },
    change3(){
        document.getElementById('day').className='day'
        document.getElementById('week').className='week'
        document.getElementById('mouth').className='mouth1'
        document.getElementById('year').className='year'
    },
    change4(){
        document.getElementById('day').className='day'
        document.getElementById('week').className='week'
        document.getElementById('mouth').className='mouth'
        document.getElementById('year').className='year1'
    },
    hotcarList(){
      getHotCar()
      .then(response=>{
        this.carInfo=response.data;
      })
    }
  },
  mounted: function(){
    this.hotcarList();
  }

};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
*{padding: 0;}

.day{
  background-image:url('../../../../static/image/day1.png');
  background-size:200px 120px;
}
.day1{
  background-image:url('../../../../static/image/day2.png');
  background-size:200px 120px;
}

  .week{
    background-image:url('../../../../static/image/week1.png');
  background-size:200px 120px;
  }
  .week1{
    background-image:url('../../../../static/image/week2.png');
  background-size:200px 120px;
  }

  .mouth{
    background-image:url('../../../../static/image/mouth1.png');
  background-size:200px 120px;
  }
  .mouth1{
    background-image:url('../../../../static/image/mouth2.png');
  background-size:200px 120px;
  }

   .year{
    background-image:url('../../../../static/image/year1.png');
  background-size:200px 120px;
  }
  .year1{
    background-image:url('../../../../static/image/year2.png');
    background-size:200px 120px;
  }

/* 特价套餐图片样式 */
.img-active img{
  width: 215px;
  height: 120px;
}

.first_main li{
  letter-spacing: normal;
}
hr{
  border: 1px solid white;
}
.first_main {
  background-color: white;
}
.caonimade{
  text-align: center;
  margin: 0 auto;
}
/*轮播图样式*/
.banner-style{
    width: 100%;
    height: 100%;

}
.el-carousel__item:nth-child(2n) {
  background-color:blueviolet;
}
.el-carousel__item:nth-child(2n + 1) {
  background-color: green;
}
.top{
  position: relative;
  height: 500px;
}
.top .wheel_img{
  position: absolute;
  float: left;
  width:100%;
  
}
.top .tags{
    position: absolute;
    z-index: 2;
    width: 500px;
    height: 400px;
    margin: 50px 150px;
    font-weight: 10;
    
}
/*优惠活动tags*/
.top .tags .activity div{
  text-align: center;
background-color: rgb(241, 241, 241);
padding-top: 50px;
width:190px;
height:120px;
border-radius:25px;
float: left;
margin:10px 20px ;
}
.top .tags .activity p{
  font-size: 16px;
}


/*特价套餐tags*/
.top .tags .package div{
 
  text-align: center;
padding-top: 15px;
width:190px;
height:120px;
float: left;
margin:20px 20px ;
border-radius:15px;
}

.top .tags .package p{
  font-size: 16px; 
}

/*企业租车*/

.top .tags .enterprise img{
  width: 220px;
  height: 130px;
  margin-top: 20px;
  margin-bottom:20px ;
  margin-left:10px;
}

.mid {
  margin:60px auto;
  text-align: center;
  width: 100%;
}.mid-next{
   margin:60px auto;
 
  width: 100%;
  
}
.mid p:first-child {
  text-align: center;
  font-size: 30px;
  font-family: PingFang SC;
}
/*卡片*/
.card {
  
  padding:10px 5px;
  float: left;
  height: 300px;
  width: 25%;
  margin-left: 80px;
}
.card img {
  height: 200px;
  width: 350px;
  
}

.card p {
  margin-left: 10px;
  font-family: PingFang SC;
  color: gray;
}
.card span {
  margin-left: 10px;
  color: gray;
  font-size: 15px;
  font-family: PingFang SC;
}
.more{
  text-align: center;
  margin-bottom: 30px;
  clear: both;
}
.induct{
  background-color: #fff;
  width: 100%;
  margin:0 auto 60px;
  text-align: center;
}
.niduct-body{
  float: left;
  margin: 0 ;
  background-color:#fff;
  width: 25%;
  height: 70%;
  text-align: center;
  padding-bottom: 30px;
 
}

.niduct-body-font{
  font-size: 20px;
  font-weight: 50;
  padding-top:30px ;
  text-align: center;
  margin-bottom: 30px;
  
}
.niduct-body-font2{
  font-size: 16px;
  font-weight: 50;
  padding-top:30px ;
 
  margin-bottom: 30px;
  
}

.niduct-body li{
  list-style: none;
}
.niduct-body-img{
  text-align: center;
}
.niduct-body-small{
  font-size: 14px;
  color: gray;
  text-align: center;
}
.niduct-body-small2{
  font-size: 14px;
  color: gray;

}
.niduct-body-button{
  margin-top: 40px;
  text-align: center;
}
</style>
