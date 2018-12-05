<template>
  <div class="company_map" style="height:800px">

    <!-- top搜索框 -->
    <div class="top">
      <div class="top_position">
        <el-card>
          <p class="position_area">
            <span>当前城市:</span>
            <el-button type="text" v-for="(item,index) in area" :key="index" @click="topSearch(item)">
              <span v-if="index==1" style="color:gray;font-weight:1;">当前城区:</span>
              {{item}}
            </el-button>
          </p>
          <p class="position_city">
            <span>热门城市:</span>
            <el-button type="text" @click="hotCity('苏州市')">苏州市</el-button>
            <el-button type="text" @click="hotCity('上海市')">上海市</el-button>
            <el-button type="text" @click="hotCity('杭州市')">杭州市</el-button>
          </p>
        </el-card>
      </div>
    </div>
    <!-- content内容 -->
    <div class="content">
        <!--左侧信息-->
        <div class="left">
          <div class="left-fontt">
          <el-card style="margin-top:0px;"><p style="font-size:15px;"> <span>当前位置:</span><span style="color:#2b90d9;font-size:16px;font-weight:500;">{{city}}</span></p>
          
          <p style="font-size:16px;"><span>附近有</span><span style="color:#2b90d9;font-size:30px;">{{this.companyList.length}}</span>家门店等候您</p></el-card>
          </div>
          <!-- <p style="font-size:15px;margin-left:10px;">推荐公司:</p> -->
          <!--推荐一-->
          <div class="hot_company" style="width:70%;margin:auto;">
            <el-card class="box-card" 
              header 
              shadow="always"
              >
              <div slot="header" class="clearfix">
                <span style="color:blue">{{this.companyList[0].companyName}}</span>
                <el-button style="float: right; padding: 3px 0" type="text" @click="goToCompany(0)">上门取车</el-button>
              </div>
              <div class="text item">地址:<span style="color:blue;">{{this.companyList[0].companyAddress}}</span></div>
              <div class="text item">电话:<span style="color:blue;">{{this.companyList[0].companyPhone}}</span></div>
              <div class="text item">描述:<span style="color:blue;">{{this.companyList[0].companyDesc}}</span></div>
              <div class="text item">创建时间:<span style="color:blue;">{{fristCompanyCreateTime}}</span></div>
              <div class="text item">
                <el-rate v-model="this.companyList[0].companyGrade" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" disabled></el-rate>
              </div>
              <hr>
              <div class="text item">
                <router-link :to="{path:'/company/company_detail',query:{companyId: this.companyList[0].companyId}}">
                  <el-button style="float: left; padding: 3px 0" type="text">查看详情</el-button>
                </router-link>
              </div>
            </el-card>
          </div>
          <br>
          <!--推荐二-->
          <div class="hot_company" style="width:70%;margin:auto;">
            <el-card class="box-card" 
              shadow="always"
              >
              <div slot="header" class="clearfix">
                <span style="color:blue;">{{this.companyList[1].companyName}}</span>
                <el-button style="float: right; padding: 3px 0" type="text" @click="goToCompany(1)">上门取车</el-button>
              </div>
              <div class="text item">地址:<span style="color:blue;">{{this.companyList[1].companyAddress}}</span></div>
              <div class="text item">电话:<span style="color:blue;">{{this.companyList[1].companyPhone}}</span></div>
              <div class="text item">描述:<span style="color:blue;">{{this.companyList[1].companyDesc}}</span></div>
              <div class="text item">创建时间:<span style="color:blue;">{{twoCompanyCreateTime}}</span></div>
              <div class="text item">
                <el-rate v-model="this.companyList[1].companyGrade" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" disabled></el-rate>
              </div>
              <hr>
              <div class="text item">
                <router-link :to="{path:'/company/company_detail',query:{companyId: this.companyList[1].companyId}}">
                  <el-button style="float: left; padding: 3px 0" type="text">查看详情</el-button>
                </router-link>
              </div>
            </el-card>
          </div>
          <br>

        </div>

        <!--右侧信息-->
        <div class="right">     
            <div id="container"><!--地图容器-->
              <!--左上角搜索-->
              <div class="container_LT">
                <el-autocomplete
                  v-model="searchStr"
                  :fetch-suggestions="querySearchAsync"
                  placeholder="请输入公司名"
                  @select="handleSelect"
                  size="large"
                >
                </el-autocomplete>
                <el-button @click="searchCompany" style="height:40px;" type="primary" size="medium">搜索</el-button>
              </div>
              <div id="panel"></div>
              <!--定位-->
              <div class="city">
                  <p>
                    <img src="/static/image/定位_16.png">
                    <span>{{city}}</span>
                  </p>
              </div>
            </div>
            
            
        </div>
    </div>
  </div>
</template>

<script>
import { getCompanyByCity } from "@/api/comInfo";
import { getAreaByCity } from "@/api/comInfo";
import { getCompanyByName } from "@/api/comInfo";
import { rejects } from "assert";
import {unix2CurrentDate} from '@/utils/date'

var map;//申明全局地图变量
var infoWindow;//申明全局信息窗体
var marker;//申明全局点标记
var markers=[];
var driving;

export default {
  name: "SearchList",
  data() {
    return {
      restaurants: [],//input选中提示
      companyList: [
        {
          companyName:'',
          companyAddress:'',
          companyPhone:'',
          companyDesc:'',
          companyGrade:'',
          companyId:'',
        },
        {
          companyName:'',
          companyAddress:'',
          companyPhone:'',
          companyDesc:'',
          companyGrade:'',
          companyId:'',
        }
      ],//公司信息
      searchStr: '',
      timeout: '',
      city: '',
      area:[],
      lng: '',
      lat: '',
      icon1:'/static/image/车辆定位_blue_48.png',
      icon2:'/static/image/车辆定位_red_48.png',
    };
  },
  methods: {
    //top搜索区域公司
    topSearch(city){
      this.companyList=[];
      map.remove(markers);
      getCompanyByCity(city).then(response => {
          if (response.data != null) {
            this.companyList=response.data;
            this.addMarker(this.companyList,this.icon1);
          } else {
            console.log("error")
          }
        });
    },
    //top热门城市公司
    hotCity(city){
      this.topSearch(city);
    },
    //加载区域
    loadArea(e){
      getAreaByCity(e).then(response=>{
        this.area=response.data;
      })
    },
    //搜索按钮
    searchCompany(){
      if(this.searchStr!=''){
        getCompanyByName(1,5,this.searchStr).then(response=>{
          let company=response.data.list;
          if(company!=null){
            map.remove(markers);  
            this.addMarker(company,this.icon2);
            markers.push(company);//添加到容器
          }
        })
      }else{
        alert("请输入公司名");
      }
    },
    loadAll() {
      for(let i=0;this.companyList.length;i++){
        if(i<5){
        let v=this.companyList[i].companyName
        let a=this.companyList[i].companyAddress
        let object={
          value:v,
          address:a
        };
          this.restaurants.push(object)
        }else{
          break;
        }
      }
    },
    //选中input控件绑定的方法
    querySearchAsync(queryString, cb) {
      var restaurants = this.restaurants;
      var results = queryString
        ? restaurants.filter(this.createStateFilter(queryString))
        : restaurants;

      clearTimeout(this.timeout);
      this.timeout = setTimeout(() => {
        cb(results);
      }, 2000 * Math.random());
    },
    createStateFilter(queryString) {
      return state => {
        return (
          state.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0
        );
      };
    },
    handleSelect(item) {
      console.log(item.value);
    },
    //加载地图方法和返回定位
    loadMap() {
        //加载地图
        map = new AMap.Map("container", {
          resizeEnabel: true,//定位
          zoom: 11, //地图显示的缩放级别
        });
        // 加载点标记信息窗体对象
        infoWindow = new AMap.AdvancedInfoWindow({
          offset: new AMap.Pixel(0, -30),
          closeWhenClickMap:true,//控制是否在鼠标点击地图后关闭信息窗体
          panel:'panel'
        });
        //加载驾驶对象
        driving= new AMap.Driving({
         map: map,
          panel: "panel"
        });

        //定位
        return new Promise((resolve, reject) => {
          AMap.plugin(['AMap.Geolocation',
                      'AMap.ToolBar',
                      'AMap.Scale',
                      'AMap.OverView',
                      'AMap.MapType',
                      ], () => {
          const geolocation = new AMap.Geolocation({
            enableHighAccuracy: true, // 是否使用高精度定位，默认：true
            timeout: 10000, // 设置定位超时时间，默认：无穷大
            buttonPosition: "RB", //  定位按钮的排放位置,  RB表示右下
            buttonOffset: new AMap.Pixel(10, 20), // 定位按钮的停靠位置的偏移量，默认：Pixel(10, 20)
            zoomToAccuracy: false, //  定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            showButton: true,//是否显示定位按钮
            buttonPosition: 'RB',//定位按钮的位置
            buttonOffset: new AMap.Pixel(10, 20),//定位按钮距离对应角落的距离
            showMarker: true,//是否显示定位点
            markerOptions:{//自定义定位点样式，同Marker的Options
            offset: new AMap.Pixel(-18, -36),
            content:'<img src="https://a.amap.com/jsapi_demos/static/resource/img/user.png" style="width:30px;height:30px"/>'
            },
            showCircle: true,//是否显示定位精度圈
            circleOptions: {//定位精度圈的样式
            strokeColor: '#0093FF',
            noSelect: true,
            strokeOpacity: 0.5,
            strokeWeight: 1,
            fillColor: '#02B0FF',
            fillOpacity: 0.25
            }
          });
          geolocation.getCurrentPosition((status, result) => {
              if (status === "complete") {
                resolve(result);
              } else {
                reject(result);
              }
            });
            map.addControl(geolocation);// 在图面添加定位控件，用来获取和展示用户主机所在的经纬度位置
            map.addControl(new AMap.ToolBar());// 在图面添加工具条控件，工具条控件集成了缩放、平移、定位等功能按钮在内的组合控件
            map.addControl(new AMap.Scale());// 在图面添加比例尺控件，展示地图在当前层级和纬度下的比例尺
            map.addControl(new AMap.OverView({isOpen:false}));// 在图面添加鹰眼控件，在地图右下角显示地图的缩略图
            map.addControl(new AMap.MapType());// 在图面添加类别切换控件，实现默认图层与卫星图、实施交通图层之间切换的控制
          });
      });
    },
    //获取城市周围公司
    loadCompany() {
      return new Promise((resolve, reject) => {
        getCompanyByCity(this.city).then(response => {
          if (response.data != null) {
            resolve(response.data);
          } else {
            reject(error);
          }
        });
      });
    },
    //添加标记到地图中
    addMarker(companyList,icon) {
      for (let i = 0; i < companyList.length; i++) {// 遍历所有公司
        if(companyList[i].avgScore==''||companyList[i].avgScore==null){
          companyList[i].avgScore='待评价';
        }
        marker = new AMap.Marker({//标记点
          position: [companyList[i].companyLongitude,companyList[i].companyLaittude],
          icon:icon,//'http://vdata.amap.com/icons/b18/1/2.png'
          map: map,
        });
        marker.content = //添加信息窗体
          "<div class='info-title' style='font-weight:bold;padding-left:10px;font-size:14px;background-color: #f2f2f2;width:340px;'>欧诺租车</div>"+
          "<div class='info-content' style='height:130px'>"+
            "<img src='"+companyList[i].imagePathList[0]+"' style='height:90px;width:143px;float:left;margin:18px 0 18px 10px'/><br>" +
            "<span style='margin-left:8px;font-weight:5;float:left'><span style='font-weight:bold;'>公司名:</span>" +companyList[i].companyName +"</span><br>" +
            "<span style='margin-left:8px;font-weight:5;float:left'><span style='font-weight:bold;'>描述:</span>" +this.companyList[i].companyDesc +"</span><br>" +
            "<span style='margin-left:8px;font-weight:5;float:left'><span style='font-weight:bold;'>电话:</span>" +companyList[i].companyPhone +"</span><br>" +
            "<span style='margin-left:8px;font-weight:5;float:left'><span style='font-weight:bold;'>评价分:</span>"+companyList[i].avgScore+"</span><br>"+ 
            "<span style='margin-left:8px;font-weight:5;float:left'><span style='font-weight:bold;'>地址:</span>" +this.companyList[i].companyAddress +"</span><br>" +
            "</div>";
        marker.on("click", markerClick);//信息窗体点击事件
        function markerClick(e) {
          infoWindow.setContent(e.target.content);
          infoWindow.open(map, e.target.getPosition());
        }
        //添加标记点到地图
        map.add(marker);
        //添加点标记到集合
        markers.push(marker);
      }
    },
    // 路线规划
    goToCompany(val){
      // 根据起终点经纬度规划驾车导航路线
      driving.search(new AMap.LngLat(this.lng, this.lat),new AMap.LngLat(this.companyList[val].companyLongitude,this.companyList[val].companyLaittude),
        function(status, result) {
          // result 即是对应的驾车导航信息，相关数据结构文档请参考
          // https://lbs.amap.com/api/javascript-api/reference/route-search#m_DrivingResult
          if (status === "complete") {
            log.success("绘制驾车路线完成!");
          } else {
            log.error("获取驾车数据失败:" + result);
          }
        }
      );
    },
    //地图导航
    goToCompany1(toLng,toLat){
      // 根据起终点经纬度规划驾车导航路线
      driving.search(new AMap.LngLat(this.lng, this.lat),new AMap.LngLat(toLng,toLat),
        function(status, result) {
          // result 即是对应的驾车导航信息，相关数据结构文档请参考
          // https://lbs.amap.com/api/javascript-api/reference/route-search#m_DrivingResult
          if (status === "complete") {
            log.success("绘制驾车路线完成!");
          } else {
            log.error("获取驾车数据失败:" + result);
          }
        }
      );
    },
  },
  async mounted() {


    // this.loadMap().then(result => {
    //   //加载成功
    //   console.log(result)
    // }).catch(error=>{
    //   //加载失败
    // });
    try { //返回定位信息
      const result = await this.loadMap();
      //console.log(result)
      this.city = result.addressComponent.city;
      this.lng = result.position.lng;
      this.lat = result.position.lat;
    } catch (error) { //定位失败
      console.log(error)
    }

    try {//加载周围公司
      const result = await this.loadCompany(); 
      this.companyList = result;
    } catch (error) {
      console.log(error)
    }
    
    this.loadAll();//加载提示公司
    this.addMarker(this.companyList,this.icon1); //添加点标记
    this.loadArea(this.city);//加载区域
    
    //公司详情页跳转过来的地图导航
    let toLng=this.$route.query.companyLongitude;
    let toLat=this.$route.query.companyLaittude;
    this.goToCompany1(toLng,toLat);
  },

  computed:{
    fristCompanyCreateTime:function(){//推荐一公司时间
      return unix2CurrentDate(this.companyList[0].companyCreatTime);
    },
    twoCompanyCreateTime:function(){//推荐二公司时间
      return unix2CurrentDate(this.companyList[1].companyCreatTime);
    }
  }
};
</script>


<style scoped>
.left-fontt{
  background: rgb(252, 252, 252);
  margin-bottom:10px ;
  margin-left: 50px;
  width: 225.5px;
}
.company_map {
  height: 600px;
  background-color: #ebedf0;
}
.top {
  position: relative;
  margin: 1px auto;
  height: 140px;
  width: 1300px;

}
.top_position{
  position:absolute;
  top:10px;
  left: 52px;
  width: 96%;
  height:80px;
  margin-bottom: 50px;
 
}
.position_area{
  margin-left:50px;
  margin-top:5px;
  font-weight: 1;
}
.position_city{
  margin-left:50px;
  margin-top:5px;
  font-weight: 1;
}

.content {
  margin: auto;
  width: 1300px;
}

/*左侧DIV*/
.left {
  float: left;
  width: 325px;
  height:550px;
  
}

/*右侧DIV*/
.right {
  float: right;
  width: 75%;
  height:550px;
}

/*地图容器*/
#container {
  height: 100%;
}

.container_LT{
  float: left;
  position: relative;
  left: 100px;
  z-index:2;
  width: 300px;
}
.el-autocomplete {
  width: 70%;
}

#panel {
  float: right;
  position: relative;
  z-index: 3;
  max-height: 70%;
  overflow-y: auto;
  top: 100px;
  right: 10px;
  width: 280px;
}
#panel .amap-call {
  background-color: #009cf9;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
}
#panel .amap-lib-driving {
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  overflow: hidden;
}
.city {
  margin: auto;
  position: relative;
  z-index: 2;
  width: 80px;
  font-size: 15px;
  line-height: 15px;
  background-color: #dae9f4;
  border: 1px solid #009cf9;
}


        .info-title {
            color: white;
            font-size: 14px;
            background-color: #25A5F7;
            line-height: 26px;
            padding: 0px 0 0 6px;
            font-weight: lighter;
            letter-spacing: 1px
        }

        .info-content {
            font: 12px Helvetica, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑', Arial;
            padding: 4px;
            color: #666666;
            line-height: 23px;
        }

        .info-content img {
            float: left;
            margin: 3px;
        }

        .amap-info-combo .keyword-input{
            height: 25px;
            border-radius: 2px 0 0 2px;
        }
</style>
