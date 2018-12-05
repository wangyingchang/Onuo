<template>
    <div class="company_list">
         <div class="card" v-for="item in companyInfo">
          <img :src="item.companyImgPath">
          <p>公司名： {{item.companyName}}</p>
          <el-button type="warning">查看公司>></el-button>
          <p>联系电话： {{item.companyPhone}}</p>
          <p>地址：     {{item.companyAddress}}</p>
          <p>状态：     {{item.companyStatus}}</p>
          <p>评分：     {{item.companyGrade}}</p>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'Pos',
    data(){
        return{
            companyInfo:[
                {companyImgPath:'https://image.zuchecdn.com/newversion/app/remark/dep_01.jpg',
                 companyName:'Manba',
                 companyPhone:'18860414654',
                 companyAddress:'江苏省苏州市工业园区',
                 companyStatus:'正常',
                 companyGrade:'100'
                },
                {companyImgPath:'https://image.zuchecdn.com/newversion/app/remark/dep_03.jpg',
                 companyName:'Manba',
                 companyPhone:'18860414654',
                 companyAddress:'江苏省苏州市工业园区',
                 companyStatus:'正常',
                 companyGrade:'100'
                },
                {companyImgPath:'https://image.zuchecdn.com/newversion/app/remark/dep_01.jpg',
                 companyName:'Manba',
                 companyPhone:'18860414654',
                 companyAddress:'江苏省苏州市工业园区',
                 companyStatus:'正常',
                 companyGrade:'100'
                },
                 {companyImgPath:'https://image.zuchecdn.com/newversion/app/remark/dep_02.jpg',
                 companyName:'Manba',
                 companyPhone:'18860414654',
                 companyAddress:'江苏省苏州市工业园区',
                 companyStatus:'正常',
                 companyGrade:'100'
                },
            ]
        }
    }
    
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.company_list {
    width: 100%;
    height: 1600px;
    margin: 0 auto;
}
.card {
  float: left;
  height: 50%;
  width: 50%;
  margin:0 auto;
  padding: 0 5px;
  background-color: #ffffff;
}
.card img:hover{
  border: 1px solid orange;
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
</style>
