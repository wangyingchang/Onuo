<template>
  <div class="head-nav">         
      <el-menu
        class="el-menu-demo"
        mode="horizontal"
        background-color="#1b2b3b"
        text-color="#1b2b3b"
        active-text-color="#eeb816"
        router :default-active="$route.path"
      >
        <img class="logo" src="../../../static/image/LogoNew.jpg" alt="欧诺Onuo">
        <el-menu-item class="asd" index="/" style="background-color:#1b2b3b;">首页</el-menu-item>
        <el-menu-item class="asd" index="/car_search" style="background-color:#1b2b3b;">车辆检索</el-menu-item>
        <el-menu-item class="asd" index="/company_search" style="background-color:#1b2b3b;" >公司查询</el-menu-item>
        <el-menu-item class="asd" index="/company_map"  style="background-color:#1b2b3b;">门店地图</el-menu-item>
        <el-menu-item class="asd" index="/car_preferential" style="background-color:#1b2b3b;" >优惠活动</el-menu-item>
         <el-menu-item class="asd" index="/car/company_rent_car" style="background-color:#1b2b3b;" >企业租车</el-menu-item>
        <el-menu-item class="asd" index="/order/my_order"  style="background-color:#1b2b3b;">我的订单</el-menu-item>
         
        <span class="phone" style="background-color:#1b2b3b;color:#eeb816;">400-666-6666</span>
        <el-dropdown style="float:right;">
                <span class="asd" style="line-height:60px;colot:gray">
                  帮助中心<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>1</el-dropdown-item>
                        <el-dropdown-item>2</el-dropdown-item>
                        <el-dropdown-item>3</el-dropdown-item>
                </el-dropdown-menu>
        </el-dropdown>
        <el-menu-item class="asd" index="/aboutus" style="float:right;background-color:#1b2b3b;" >关于我们</el-menu-item> 
        <el-menu-item class="asd" index="/regist" style="width:40px;padding:0;float:right;background-color:#1b2b3b;margin-right:10px">{{msg1}}</el-menu-item>
        <el-menu-item class="asd" index="/login" style="width:40px;padding:0;float:right;background-color:#1b2b3b;">{{msg}}</el-menu-item>
         <span class='asd1'>{{hello}}</span>
      </el-menu> 
  </div>
</template>

<script>
import store from '@/store'
export default {
  name: 'Main',
  data () {
    return {
      msg:'',
      msg1:'注册',
      hello:''
     
    }
  },
  methods:{
          check(){
            if(store.getters.username===null){
                  this.msg='登录'
                  
            }else{
              this.msg=store.getters.username
              this.hello='你好!'
            }
          },
       },
     beforeUpdate: function(){
    this.check();
  }
  


}


</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
    .head-nav{
        height: 60px;
        width: 100%;
        background-color:#1b2b3b; 
    }
    .logo{
      float: left;
      height: 60px;
      width: 300px;
    }
    .phone{
      font-size: 18px;
      font-weight: 20;
      height: 60px;
      line-height: 60px;
      text-align: center;
      width: 150px;
      float: right;
    }
    .el-menu-demo{
      width: 100%;
      background-color: #1b2b3b !important;
    }
    .asd{
      padding: 0 !important;
      font-weight: 20 !important;
      background-color: #1b2b3b !important;
      text-align: center;
      width: 70px;
      font-size: 13px !important;
      color: white !important;
    }

     .asd1{
      padding: 0 !important;
      font-weight: 20 !important;
      background-color: #1b2b3b !important;
      text-align: center;
      width: 35px;
      font-size: 13px !important;
      color: white !important;
      float: right;
      line-height: 60px;
    }
    
    .el-menu-item.is-active{
    
      color: #eeb819 !important;
    }
</style>
