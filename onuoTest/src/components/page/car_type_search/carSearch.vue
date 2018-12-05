<template>
  <div class="car_search">
    <div class="top">
      <div class="cont" style="margin:auto;">
        <el-input class="search"
                  type="text"
                  placeholder="请输入车辆信息"
                  clearable v-model="carWords"
                  size="large"
                  >
        </el-input>
        <el-row>
          <el-button type="primary" @click="searchCompany">搜一搜</el-button>
        </el-row>
      </div>
    </div>

<div style="height:1050px;width:1300px;margin:40px auto;">
  <!--车辆列表-->
  <carList ref="childComponent" :carSearchWords="carWords" :leftWords="carLeftWords"></carList>
  <!--坐车导航-->
  <carSearchLeftNav @searchOption="searchLeftWords"></carSearchLeftNav>
</div>
    
  </div>
</template>
<script>
import carList from '@/components/page/car_type_search/carList'
import carSearchLeftNav from '@/components/page/car_type_search/carSearchLeftNav'
export default {
  name: 'car_search',
  data () {
    return {
      msg: '我是车型搜索页',
      carWords:'',
      carLeftWords:[]
    }
  },
  methods:{
    searchCompany(){
      this.$refs.childComponent.$emit('closeDialogchild')
    },
    searchLeftWords(data){
      this.carLeftWords=data
    }
  },
  components:{
    carList,carSearchLeftNav
  },
}
</script>
<style scoped>
.top{
  margin: auto;
  height: 200px;
  width:100%;
  background: url("/static/image/carFind.jpg");
}
.el-input{
  width: 300px;
  margin-left: 40%;
  margin-top: 80px;
}
.el-button{
  position: absolute;
  margin-left: 60%;
  margin-top: -42px;
  height: 42px;
}
</style>

