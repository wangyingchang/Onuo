<template>
  <div class="foot-nav">
    <div>
      <span class="lianjie">友情链接:</span>
      <ul>
        <li><a href="http://bj.tuniu.com/">北京旅游网</a></li>
        <li><a href="http://z.mafengwo.cn/">旅游指南</a></li>
        <li><a href="http://www.ynet.com/index.html">北青网</a></li>
        <li><a href="https://wan.cncn.com/">欣欣旅游</a></li>
        <li><a href="http://www.mianfeiwucan.org/">免费午餐</a></li>
        <li><a href="http://www.ilvping.com/view/Index/home.html">旅评网</a></li>
        <li><a href="http://www.lavago.com/">拉拉勾旅游网</a></li>
        <li><a href="http://www.caissa.com.cn/">凯撒旅游网</a></li>
        <li><a href="https://www.ly.com/">同程网</a></li>
        <li><a href="http://travel.sina.com.cn/">新浪旅游</a></li>
        <li><a href="https://www.ufenghuang.com/">游凤凰网</a></li>
        <li><a href="http://www.cits.cn/">国旅在线</a></li>
        <li><a href="http://www.qyer.com/">穷游出境游</a></li>
        <li><a href="http://www.jdair.net/">首都航空</a></li>

      </ul>
      
    </div>
    <span class="di">Copyright©2008-2018 www.onuo.com All Rights Reserved.</span>
  </div>
</template>

<script>
export default {
  name: 'Main',
  data () {
    return {
      
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .foot-nav{
        height: 150px;
        background-color: #1b2b3b;
        padding-top: 1px;
    }
    .foot-nav .lianjie{
      float: left;
      margin-left: 80px;
      height: 100px;
      line-height: 28px;
      font-size: 14px;
      margin-right: 50px;
      color: #5b7b9b;
    }
    .foot-nav ul li{
      float: left;
      list-style:none;
      height: 30px;
      line-height: 30px;
      width: 120px;
      font-size: 14px
    }
    .foot-nav a{
      text-decoration: none;
      color: #5b7b9b;
    }
    .di{
      width: 100%;
      float: left;
      color: #5b7b9b;
      font-size: 13px;
      text-align: center;
    }
</style>
