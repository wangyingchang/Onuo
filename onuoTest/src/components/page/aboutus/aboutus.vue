<template>
  <div class="abouthead">
        <div class="video-bg">
          <img src="../../../../static/image/abouthead.jpg">
          <h2>
            <i>Never settle<b class="hidden-xs">,</b><span> be the best you can be</span></i><br>
            不将就，做更好的自己
          </h2>
        </div>

          <div class='black'>
            <h1>关于我们</h1>
            <div class='line'></div>
            <div class='detail'><p>
                2018年7月，一个平常的日子CBC降生<br>
                    一个由信仰不将就的人构成的Team<br>
                                从一开始<br>
            我们就希望做点不一样的事情，去影改变这自己将就的生活<br>
                我们选择了CBC作为我们实践梦想的第一步<br>
            </p></div>
          </div>

          <div id='map'>
                <img src="https://statics.oneplus.cn/v2/img/aboutOneplus/map.png" alt="我们躲起来啦！">
          </div>

          <div class='msg'>
              <ul>
                  <li>
                      
                          <hr class='line2'>
                          <p class='say'>
                                    我同样信仰这个世界上有这样一群你们<br>
                                    热衷互联网生活、有品位、乐分享<br>
                                    酷爱一切精致<br>
                                    愿为美好喝彩<br>
                          </p>
                     
                  </li>
                   <li>
                     
                          <hr class='line2'>
                           <p class='say'>
                          我非常愿意为我们<br>
                          付出所有的情谊<br>
                            这是一种天性使然的默契<br>
                           我们是一家人<br>
                            无论你是如何发现CBC<br>
                          我们都愿闻其详，你对CBC的期许和建议<br>
                          </p>
                     
                  </li>
                   <li>
                          <hr class='line2'>
                           <p class='say'>
                            因为在这里<br>
                            谱写的<br>
                            是关于我的，也是关于我们的不将就故事<br>
                            <br>
                            从这一天开始，一切都不平常<br>
                          </p>
                  </li>
              </ul>
          </div>
          <div class='secondline'>
              <h1>欧诺Onuo</h1>

              
              <div class='membermsg'>
               <ul>
                  <li class='membermsg1'>
                      
                          <hr class='line3'>
                          <img src="../../../../static/image/JMR.jpg" alt="">
                          <p class='say1'>
                          梦想是可以实现的<br>
                          在于我们怎么去努力实现<br>
                          理想是要有的<br>
                          在于我们怎么去思考<br>
                          所有的一切都靠我们的实际行动<br>
                          实现我们想要的一切<br>
                          未来在等你<br>
                          </p>
                     
                  </li>
                   <li class='membermsg1'>
                     
                          <hr class='line3'>
                          <img src="../../../../static/image/BYK.jpg" alt="">
                           <p class='say1'>
                          我们非常愿意为你们<br>
                          提供高品质、优设计的产品<br>
                          有情谊的服务<br>
                          这是一种天性使然的默契<br>
                          我们是一加人，也是一家人<br>
                          无论你是如何发现一加<br>
                          我们都愿闻其详，你对一加的期许和建议<br>
                          </p>
                     
                  </li>
                   <li class='membermsg1'>
                          <hr class='line3'>
                          <img src="../../../../static/image/WYC.jpg" alt="">
                           <p class='say1'>
                          我们非常愿意为你们<br>
                          提供高品质、优设计的产品<br>
                          有情谊的服务<br>
                          这是一种天性使然的默契<br>
                          我们是一加人，也是一家人<br>
                          无论你是如何发现一加<br>
                          我们都愿闻其详，你对一加的期许和建议<br>
                          </p>
                  </li>
              </ul>
          </div>


          <div id='membermsg2'>
              <ul>
                  <li class='membermsg2'>
                      
                          <hr class='line4'>
                          <img src="../../../../static/image/YGG.jpg" alt="">
                          <p class='say1'>
                          我们非常愿意为你们<br>
                          提供高品质、优设计的产品<br>
                          有情谊的服务<br>
                          这是一种天性使然的默契<br>
                          我们是一加人，也是一家人<br>
                          无论你是如何发现一加<br>
                          我们都愿闻其详，你对一加的期许和建议<br>
                          </p>
                     
                   </li>
                   <li class='membermsg2'>
                     
                          <hr class='line4'>
                          <img src="../../../../static/image/WDQ.jpg" alt="">
                           <p class='say1'>
                          我们非常愿意为你们<br>
                          提供高品质、优设计的产品<br>
                          有情谊的服务<br>
                          这是一种天性使然的默契<br>
                          我们是一加人，也是一家人<br>
                          无论你是如何发现一加<br>
                          我们都愿闻其详，你对一加的期许和建议<br>
                          </p>
                    </li>
                 </ul>
            </div>
            <div id='phone'>
                 <h1 id='aboutuus'>联系我们</h1>
                 <hr id='last'>
                 <p>公司:上海欧诺有限公司</p>
                 <p>地址:上海市浦东新区世纪大道1号</p>
              </div>     
         </div>
    </div>
  
 
          
  
</template>
<script>
export default {
  name: "aboutus",
  data() {
    return {
      msg: "关于我们",
      active: 1,
      
    };
  },
  methods: {
  }
};
</script>
<style scoped>

.abouthead{
    
    width: 100%;
}

.video-bg{
    width:100%; 
     height: 600px;
}
img{
   width:100%; 
   height: 600px;
}

h2{
    font-size: 35px;
    color: white;
    margin-left: 450px;
    margin-top: -300px;  
}

.black{
    height: 300px;
    width: 100%;
    text-align: center;
}

h1{
    /* text-align: center; */
 
    margin-top: 30px;
}
.line{
    
    width: 80px;
    border-bottom:solid 1px black;
    margin-left: 47%;
    
}

.black p{
    font-weight: 10;
    margin-top: 30px;
    font-size: 14px;
    color: rgb(110, 110, 110);
    line-height: 28px;
    text-align: center   
}


#map{
    height: 500px;
    width: 80%;
}
#map img{
    height: 500px;
    width: 90%;
    margin-left: 130px;
}

.msg{
    height: 270px;
    width: 100%;
    border: 1px solid white;
}

.msg li{
   list-style: none;
   float: left;
   margin-left: 150px;;
}

.say{
    font-weight: 10;
    font-size: 13px;
    color: rgb(110, 110, 110);
    line-height: 28px;
}

.line2{
    background-color: black;
    width: 30px;
}

.secondline{
  padding-top: 1px;
  
    width: 100%;
    height: 1096px;
    text-align: center;
    background-color: #f8f8f8;
}
.secondline img{
    width: 360px;
    height: 36px;
    
}

.membermsg{
     height: 360px;
     padding-left: 50px;
   width: 100%;
  
}
.membermsg li{
   list-style: none;
   float: left;

   height: 350px;
   width: 30%;
 
}

.membermsg img{
    margin-left: -180px;
    height: 280px;
    width: 170px;
}

.membermsg p{
    margin-left: 200px;
    margin-top: -260px;
    font-size: 14px;
    color: rgb(110, 110, 110);;
    line-height: 28px;
    font-weight: 10;
}

#membermsg2{
    height: 360px;
   width: 100%;
  
}

#membermsg2 li{
   list-style: none;
   float: left;
    margin-left: 180px;; 
   height: 350px;
   width: 380px;
  
}

#membermsg2 img{
    margin-left: -180px;
    height: 280px;
    width: 170px;
}

#membermsg2 p{
    font-weight: 10;
    margin-left: 200px;
    margin-top: -260px;
    font-size: 14px;
    color: rgb(110, 110, 110);
    line-height: 28px;
}

#phone{
    height: 230px;
    width: 100%;
    background-color: #fff;  
}

#aboutuus{
   
    padding: 50px;
   
    margin-bottom: -30px;
}

#phone p{
   
      font-size: 14px;
    line-height: 28px;
    
}
#last{
    background-color: #fff;
    width: 88px;
    margin: 0 auto;
}
#last p{
    color:black;
}



</style>