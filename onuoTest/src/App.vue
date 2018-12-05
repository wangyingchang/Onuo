<template>
  <div id="app" style=" background-color: #ebedf0;">
    <!--头部导航-->
    <headNav></headNav>
    <!--操作区域-->
    <div id="Main">
      <router-view></router-view>
    </div>
    <el-row :gutter="20">
  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
</el-row>
    <!--尾部导航-->
    <footNav></footNav>
  </div>
</template>

<script>
import headNav from '@/components/common/headNav'
import footNav from '@/components/common/footNav'

export default {
  name: 'app',
  components:{
    headNav,footNav
  }
}
</script>

<style>
html{
  height: auto;
}
</style>
