<template>
  <div class="company_detail">
    <div class="company_content">
       <el-carousel :interval="4000" type="card" height="230px">
         <el-carousel-item v-for="(item,index) in companyDetailInfo.imagePathList" :key="index">
          <h3>
             <img :src="item">
          </h3>
         </el-carousel-item>
      </el-carousel>
      <div class="company_btn">
        <router-link :to="{path:'/car/company_carList',query:{id: companyId}}">
        <el-button>查看车辆</el-button>
        </router-link>
        <router-link :to="{path:'/company_map',query:{companyLongitude: companyDetailInfo.companyLongitude, companyLaittude:companyDetailInfo.companyLaittude}}">
          <el-button>地图导航</el-button>
        </router-link>
      </div>
      <div id="companyInfo">
        <div class="baseinfo"> 
            <table class="carList_tb1" cellpadding="0" cellspacing="0" border="0">
              <tr>
                <td>
                  <span style="font-size:20px;">{{companyDetailInfo.companyName}}</span>
                </td>
              </tr>
            </table>
        </div>
        <div class="detailinfo">
          <table class="carList_tb2" cellpadding="0" cellspacing="0" border="0">
              <tr>
                <td>
                  <img src="../../../../static/image/dh.png">
                  <span class="comp">公司电话: {{companyDetailInfo.companyPhone}}</span>
                </td>                
                <td>
                  <img src="../../../../static/image/score.png" >
                  <span class="comp">公司星级:</span>
                  <el-rate style="display:inline;margin-left:-130px;" v-model="companyDetailInfo.companyGrade" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" disabled>
                  </el-rate>
                </td>
              </tr>
              <tr>
                <td><img src="../../../../static/image/desc.png">
                  <span class="comp">公司描述: {{companyDetailInfo.companyDesc}}</span>
                </td>

                <td>
                   <img src="../../../../static/image/address.png">
                   <span class="comp">公司地址: {{companyDetailInfo.companyAddress}}</span>
                </td>
                
              </tr>
              <tr>
                <td><img src="../../../../static/image/time.png">
                  <span class="comp">公司注册时间: {{companyCreateDate}}</span>
                </td>
                <td><img src="../../../../static/image/money.png">
                  <span class="comp">公司注册资金: {{companyDetailInfo.companyRegistMoney}}</span>
                </td>
              </tr>
              <tr>
                <td><img src="../../../../static/image/status.png">
                  <span class="comp">公司状态: {{companyDetailInfo.status}}</span>
                </td>
                <td><img src="../../../../static/image/leader.png">
                  <span class="comp">公司法人:{{companyResponsible.cardName}} </span>
                </td>
              </tr>
          </table>
           <div class="company_btn">
              <el-button @click="viewJudge">查看评论</el-button>
           </div>
           <div id="company_comment" style="display:none;">
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
           <div class="comment_detail" v-for="(item,index) in companyJudgeInfo" :key="index">
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
                <span class="comment_right_font">内容:{{ item.judgeConent }}</span>
             </div>
             <div class="comment_time">
                  {{item.judgeTime}}
                </div>
           </div>
          </div> 
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";//axios请求
import {getCompanyDetail} from '@/api/comInfo'//查询公司详情
import {getCompanyJudgeInfo} from '@/api/comInfo'//查询公司评价
import {unix2CurrentDate} from '@/utils/date'//时间转换

export default {
  name: 'company_detail',
    data () {
    return {
      pageCode: 1,// 默认当前页
      pageSize: 2,// 每页显示数
      totalCount: 0,// 总记录数
      companyId: '',//公司Id
      companyDetailInfo:{},//公司详情对象
      companyResponsible:{},//公司法人信息
      companyJudgeInfo:[],//公司评价数组
      show:true,
    }
  },
  created(){
    //接收传过来的值
    this.companyId=this.$route.query.companyId;
  },
  methods:{
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
    //查询公司详情信息
    companyDetail(){
      getCompanyDetail(this.companyId).then(response=>{
        this.companyDetailInfo=response.data;//公司详情信息
        this.companyResponsible=response.data.companyResponsibleInfo;//公司法人信息
      
      
      })
    },
    //查看评论按钮方法
    viewJudge(){
      var show=document.getElementById("company_comment");
      if(show.style.display=='none'){
        show.style.display='inline';
        //查询公司评价
        getCompanyJudgeInfo(this.pageCode,this.pageSize,this.companyId).then(response=>{
          this.companyJudgeInfo=response.data.list;
          this.totalCount=response.data.total;//总记录数
          this.pageCode=response.pageNum; // 当前页数
          for(let i=0;i<this.companyJudgeInfo.length;i++) {// 格式化评价时间
          this.companyJudgeInfo[i].judgeTime = this.formatTime(this.companyJudgeInfo[i].judgeTime);
        }
        });
      }else{
        show.style.display='none';
      }
    },
    //页码改变触发的方法
    changeIndex(val){
      //查询公司评价
      getCompanyJudgeInfo(val,this.pageSize,this.companyId).then(response=>{
      this.companyJudgeInfo=response.data.list;
      this.totalCount=response.data.total;//总记录数
      this.pageCode=response.data.pageNum; // 当前页数
      });
    }
  },
  mounted:function(){
    this.companyDetail();
  },
  computed:{
    //公司日期格式化
    companyCreateDate:function (){
      return unix2CurrentDate(this.companyDetailInfo.companyCreatTime);
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

  .company_detail {
    width: 100%;
    height: 100%;
    padding-top:50px;
    background-color: #ffffff;
  }
  .company_content {
    width: 980px;
    height:100%;
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
.company_btn {
  width: 100%;
  height: 80px;
  margin: 0 auto;
  border-bottom: 1px solid rgb(158, 203, 248);
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

.baseinfo {
  width: 100%;
  height: 80px;
  margin: 0 auto;
  border-bottom: 1px solid rgb(149, 200, 250);

}

.detailinfo {
  width: 980px;
  height: 460px;
  margin: 20px auto;
}
.carList_tb1 {
  width: 100%;
  margin: 25px auto;
}
.carList_tb1 tr{
  width: 100%;
  text-align: center;
  margin: 0,auto;
}
.carList_tb1 td{
  width: 50%;
  height: 40px;
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
  height: 50px;
  border-bottom: 1px dashed #dddddd;
}
.carList_tb2 td img {
 width:20px;
 height:20px; 
 margin-left:20%;
 margin-right: 2%;
 float: left;
}
.comp {
  font-size: 15px;
  /* color:rgb(97, 161, 223);  */
  float: left;
  font-weight: 1;
}
#company_comment {
  width: 100%;
  height: 100%;
  margin-bottom: 10px;
}
.comment_detail {
  width: 100%;
  height: 150px;
  /* background-color: #f2f2f2; */
  border-top: 1px solid rgb(189, 220, 252);
  /* border-top: 1px solid rgb(97, 161, 223); */
}
.comment_left {
  margin: auto;
  width: 20%;
  height: 150px;
  float: left;
}
.comment_right {
  width: 60%;
  height: 150px;
  float: left;
}
.comment_right_font{
  font-size: 12px;
}
.user {
  width: 100%;
  height: 100px;
}
.user img {
  margin:50px 20px;
  width: 50px;
  height: 50px;
  float: left;
}

.user p {
  font-size:18px;
  font-weight: 500px;
  margin-top: 50px;
  text-align: center;
  float: left;
}
 .el-rate {
    height: 20px;
    margin: 24px 2px 10px 2px;
    line-height: 1;
}
.comment_right span {
  font-size: 14px;
  margin: 1px 2px;
  font-weight: 1;
}
.page{
    clear: both;
    padding-left: 30%;
    margin:20px auto;
    height: 50px;
    padding-top:10px; 
    width: 100%;
}
.comment_time {
  float:right;
  font-size: 12px;
}
</style>
