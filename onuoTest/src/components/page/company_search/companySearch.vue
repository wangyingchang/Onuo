<template>
  <div class="company_search">
    
       <!-- 轮播图 -->
      <div class="wheel_img">
        <!-- <img src="../../../../static/image/timg.jpg" alt=""> -->
        <div class="select">
        <el-select v-model="searchCity" placeholder="请选择" @change="changeCity">
          <el-option-group
            v-for="group in options3"
            :key="group.label"
            :label="group.label"
            >
            <el-option
              blur="changeCity"
              v-for="item in group.options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
              >
            </el-option>
          </el-option-group>
        </el-select>
        <el-input
          placeholder="请输入内容"
          clearable style="height:120px;width:300px;"
          v-model="searchCompanyName"
          
        >
        </el-input>
        <el-button  type="primary" @click="searchCompany">搜索</el-button>
      </div>
          
        </div>

    <div class="content">
      <!--条件栏-->
      
 

      <!--公司列表-->
      <div class="company_list">
        <div class="coampany_comtent">
          <div class="card" v-for="(item,index) in companyListCount" :key="index">
            <img :src="item.imagePathList[0]">
            <p>公司名：{{item.companyName}}</p>
            <p>联系电话:{{item.companyPhone}}</p>
            <p>地址：{{item.companyAddress}}</p>
            <p>
            <router-link :to="{path:'/company/company_detail',query:{companyId: item.companyId}}">
              <el-button type="primary">查看公司>></el-button>
            </router-link>
            </p>
            <p>
              <el-rate style="display:inline;" v-model="item.companyGrade" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" disabled>
              </el-rate>
            </p><br>

          </div>
        </div>
        <!--分页栏-->
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
      </div>
    </div>
  </div>
 
</template>
<script>
import axios from "axios";//axios请求
import { getAllCompany } from "@/api/comInfo";//查询所有公司
import { getCompanyByNameAndCity } from "@/api/comInfo";//多条件检索公司

export default {
  name: "SearchList",
  data() {
    return {
      searchCompanyName: '',
      companyListCount: [],
      searchCity: '默认',
      pageSize: 6, // 每页显示数
      totalCount: 0, // 总记录数
      pageCode: 1, // 默认当前页
      flag: 0,
      options3: [
        {
          label: "热门城市",
          options: [
            {
              value: "苏州市",
              label: "苏州市"
            },
            {
              value: "上海市",
              label: "上海市"
            },
            {
              value: "北京市",
              label: "北京市"
            }
          ]
        },
        {
          label: "城市名",
          options: [
            {
              value: "Chengdu",
              label: "成都"
            },
            {
              value: "Shenzhen",
              label: "深圳"
            },
            {
              value: "Guangzhou",
              label: "广州"
            },
            {
              value: "Dalian",
              label: "大连"
            }
          ]
        }]
    };
  },
  methods: {
    // 查询所有公司
    getAllCompanyList: function() {
      this.companyListCount = [];
      this.pageCode = 1;
      getAllCompany(this.pageCode, this.pageSize).then(response => {
        this.companyListCount = response.data.list;
        this.pageCode = response.data.pageNum; // 当前页数
        this.totalCount = response.data.total; // 总记录数
      });
      this.flag=0;
    },
    //选择城市触发的事件
    changeCity() {
      this.companyListCount = [];
      this.pageCode = 1;
      getCompanyByNameAndCity(this.pageCode,this.pageSize,this.searchCompanyName,this.searchCity).then(response => {
        this.companyListCount = response.data.list;
        this.pageCode = response.data.pageNum; // 当前页数
        this.totalCount = response.data.total; // 总记录数
      });
      this.flag = 1;
    },
    //搜索按钮的事件
    searchCompany() {
      if(this.searchCity==='默认'){
        this.searchCity='';
      }
      this.companyListCount = [];
      this.pageCode = 1;
      getCompanyByNameAndCity(this.pageCode,this.pageSize,this.searchCompanyName,this.searchCity).then(response => {
        this.companyListCount = response.data.list;
        this.pageCode = response.data.pageNum; // 当前页数
        this.totalCount = response.data.total; // 总记录数
      });
      this.flag = 1;
    },
    // 页码改变分页
    changeIndex(val) {
      if (this.flag == 1) {
        //搜索按钮的分页
        this.companyListCount = [];
        getCompanyByNameAndCity(val,this.pageSize,this.searchCompanyName,this.searchCity).then(response => {
          this.companyListCount = response.data.list;
          this.pageCode = response.data.pageNum; // 当前页数
          this.totalCount = response.data.total; // 总记录数
        });
      } else {
        //查询所有的分页
        this.companyListCount = [];
        getAllCompany(val, this.pageSize).then(response => {
          this.companyListCount = response.data.list;
          this.pageCode = response.data.pageNum; // 当前页数
          this.totalCount = response.data.total; // 总记录数
        });
      }
    }
  },
  mounted: function() {
    this.getAllCompanyList();
  }
};
</script>
<style scoped>
.company_search {
  width: 100%;
  background-color: #f2f2f2;
}
.wheel_img{
  height: 407px;
  width:100%;
  background-image: url("../../../../static/image/timg3.jpg");
  background-size:100% 407px;
}
/* .wheel_img img{
position: relative;
  width:100%;
  height: 407px;
} */
.banner-style{
    width: 100%;
    height: 100%;
}
.content {
  width: 1250px;
  margin:auto;
}
.select { 
  position: absolute;
  z-index: 3;
  width: 650px;
  height: 54px;
  margin-left: 30%;
  text-align: center;
  margin-top:250px;
  line-height: 40px;
  background-color:rgb(19, 19, 19);
  padding-top: 5px;
  opacity:0.8;
  border-radius: 10px;
}
.company_list {
  margin-left: 50px;
}
.card {
  float: left;
  width: 370px;
  height: 400px;
  margin-top:10px;
  margin-left: 15px;
  background-color: #ffffff;
}

.card img {
  height: 70%;
  width: 100%;
}
.card button {
  float: right;
  margin-right: 10px;
}
.card p {
  margin-left: 10px;
  font-size: 15px;
  font-weight: bolder;
  font-family: PingFang SC;
  color: #a2a2a2;
}
.card span {
  margin-left: 10px;
  color: gray;
  font-size: 15px;
  font-family: PingFang SC;
}
.page {
  margin: 50px auto;
  padding-top: 20px;
  text-align: center;
  clear: both;
}
</style>