<template>
  <div class="car-left-nav">
    <span id='msg'>{{msg}}:</span>
    <div id="line1">
      <ul class="line1">
        <li id="buxian"><a><span>不限</span><img class=0  @click="changecolor9($event)" src="\static\image\carleft1-1.png"></a></li>
        <li id="img1"><a><img id='img112' class='手动紧凑型' @click="changecolor1($event)" src="\static\image\carleft1-2.png"><span>手动紧凑型</span></a></li>
        <li id="img2"><a><img id='img113' class='经济型' @click="changecolor2($event)" src="\static\image\carleft1-3.png"><span>经济型</span></a></li>
      </ul>
    </div>
    <div id="line2">
      <ul class="line2">
        <li id="img21"><a><img id='img221' class='商务型' @click="changecolor3($event)" src="\static\image\carleft2-1.png"><span>商务型</span></a></li>
         <li id="img22"><a><img id='img222'  class='豪华型' @click="changecolor4($event)" src="\static\image\carleft2-2.png"><span>豪华型</span></a></li>
          <li id="img23"><a><img id='img223' class='SUV' @click="changecolor5($event)" src="\static\image\carleft2-3.png"><span>SUV</span></a></li>
      </ul>
    </div>
    <div id="line3">
      <ul class="line3">
        <li id="img31"><a><img id='img331' class='6至15商务座' @click="changecolor6($event)" src="\static\image\carleft3-1.png"><span>6至15商务座</span></a></li>
         <li id="img32"><a><img id='img332' class='个性车' @click="changecolor7($event)" src="\static\image\carleft3-2.png"><span>个性车</span></a></li>
          <li id="img33"><a><img id='img333' class='电动汽车' @click="changecolor8($event)" src="\static\image\carleft3-3.png"><span @click="changecolor($event)">电动汽车</span></a></li>
      </ul>
    </div>
    
    <div id="line4">
      <a>{{msg1}}:</a>
    </div>
    
    <div id="line5" >
                <span @click="allchangecolor2($event)"><a class='carname2' href="#">不限</a></span>
                <span @click="changecolor($event)"><a class='carname'>奔驰</a></span>
                <span @click="changecolor($event)"><a class='carname'>宝马</a></span>
                <span @click="changecolor($event)"><a class='carname'>奥迪</a></span>
                <span @click="changecolor($event)"><a class='carname'>本田</a></span>
                <span @click="changecolor($event)"><a class='carname'>标致</a></span>
                <span @click="changecolor($event)"><a class='carname'>别克</a></span>
                <span @click="changecolor($event)"><a class='carname'>比亚迪</a></span>
                <span @click="changecolor($event)"><a class='carname'>长城</a></span>
                <span @click="changecolor($event)"><a class='carname'>大众</a></span>
                <span @click="changecolor($event)"><a class='carname'>丰田</a></span>
                <span @click="changecolor($event)"><a class='carname'>福特</a></span>
                <span @click="changecolor($event)"><a class='carname'>金杯</a></span>
                <span @click="changecolor($event)"><a class='carname'>野马</a></span>
                <span @click="changecolor($event)"><a class='carname'>铃木</a></span>
                <span @click="changecolor($event)"><a class='carname'>马自达</a></span>
                <span @click="changecolor($event)"><a class='carname'>奇瑞</a></span>
                <span @click="changecolor($event)"><a class='carname'>起亚</a></span>
                <span @click="changecolor($event)"><a class='carname'>斯柯达</a></span>
                <span @click="changecolor($event)"><a class='carname'>雪佛兰</a></span>
                <span @click="changecolor($event)"><a class='carname'>日产</a></span>
                <span @click="changecolor($event)"><a class='carname'>猎豹</a></span>
                <span @click="changecolor($event)"><a class='carname'>沃尔沃</a></span>
                <span @click="changecolor($event)"><a class='carname'>依维柯</a></span>
                <span @click="changecolor($event)"><a class='carname'>华泰</a></span>
                <span @click="changecolor($event)"><a class='carname'>凯迪拉克</a></span>
                <span @click="changecolor($event)"><a class='carname'>三菱</a></span>
                <span @click="changecolor($event)"><a class='carname'>MINI</a></span>
                <span @click="changecolor($event)"><a class='carname'>江淮</a></span>
                <span @click="changecolor($event)"><a class='carname'>北京汽车</a></span>
                <span @click="changecolor($event)"><a class='carname'>雪铁龙</a></span>
                <span @click="changecolor($event)"><a class='carname'>菲亚特</a></span>
                <span @click="changecolor($event)"><a class='carname'>江铃</a></span>
                <span @click="changecolor($event)"><a class='carname'>上汽大通</a></span>
                <span @click="changecolor($event)"><a class='carname'>华颂</a></span>
                <span @click="changecolor($event)"><a class='carname'>风行</a></span>
                <span @click="changecolor($event)"><a class='carname'>广汽</a></span>     
    </div>
      <hr>
  
      <!--价格-->
          <div id="line6">
            <a>{{msg2}}(元)</a>
          </div>
          <el-select v-model="searchword.carminprice" slot="prepend" placeholder="请选择">
            <el-option label="0" value="0"></el-option>
            <el-option label="100" value="100" ></el-option>
            <el-option label="300" value="300" ></el-option>
            <el-option label="500" value="500" ></el-option>
          </el-select>
          <span>-</span>
          <el-select v-model="searchword.carmaxprice" slot="prepend" placeholder="请选择">
            <el-option label="300" value="300"></el-option>
            <el-option label="500" value="500"></el-option>
            <el-option label="700" value="700"></el-option>
            <el-option label="1500" value="1500"></el-option>
          </el-select>
          <hr id="hr2">

          <!--座位数-->
          <div id="line7">
            <a>{{msg3}}(坐)</a>
          </div>
          <el-select v-model="searchword.carminseat" slot="prepend" placeholder="请选择座位">
            <el-option label="2" value="2" ></el-option>
            <el-option label="5" value="5" ></el-option>
            <el-option label="7" value="7" ></el-option>
          </el-select>
          <span>-</span>
          <el-select v-model="searchword.carmaxseat" slot="prepend" placeholder="请选择座位">
            <el-option label="9" value="9"></el-option>
            <el-option label="13" value="13"></el-option>
            <el-option label="15" value="15"></el-option>
          </el-select>
          <hr id="hr2">
        </div>
</template>

<script>
export default {
  name: 'CarSearchLeftNav',
  data () {
    return {
      searchword:{
        cartype:'0',
        carbrand:'0',
        carminprice:'0',
        carmaxprice:'1500',
        carminseat:'2',
        carmaxseat:'15'
      },
      msg: '车型',
      msg1:'品牌',
      msg2:'价格',
      msg3:'座位数',
    }
  },
  watch:{
    searchword:{
      handler(newVal,oldVal){
        this.$emit('searchOption',newVal)
      },
    deep:true
    }
  },
   methods:{
     changecolor(e){
          if(e.target.style.color.toString()=='rgb(255, 143, 2)') {
            e.target.style.color =  "gray"
            this.searchword.carbrand=(this.searchword.carbrand).replace(e.target.innerHTML+',','');
          }else{
              e.target.style.color = "#ff8f02"
              if(this.searchword.carbrand == 0){
             this.searchword.carbrand=''
        }
          this.searchword.carbrand+=e.target.innerHTML+','
          }
           
      }, 
      allchangecolor2(e){
           var all=[];
           all = document.getElementsByClassName('carname')
           for(var i=0;i<all.length;i++){
            all[i].style.color='gray'
             }
             this.searchword.carbrand=0
          },
      
      changecolor1($event){
        
       if( $event.currentTarget.src!='http://localhost:8090/static/image/change1-2.png'){
        $event.currentTarget.src='http://localhost:8090/static/image/change1-2.png'
        if(this.searchword.cartype==0){
           this.searchword.cartype=''
        }
        this.searchword.cartype+=$event.currentTarget.className+','
       }else{
          $event.currentTarget.src='http://localhost:8090/static/image/carleft1-2.png'
          this.searchword.cartype=(this.searchword.cartype).replace($event.currentTarget.className+',','');
       }  
      },
       changecolor2($event){
        
       if( $event.currentTarget.src!='http://localhost:8090/static/image/change1-3.png'){
        $event.currentTarget.src='http://localhost:8090/static/image/change1-3.png'
        if(this.searchword.cartype==0){
           this.searchword.cartype=''
        }
        this.searchword.cartype+=$event.currentTarget.className+','
       }else{
          $event.currentTarget.src='http://localhost:8090/static/image/carleft1-3.png'
          this.searchword.cartype=(this.searchword.cartype).replace($event.currentTarget.className+',','');
       }   
      },
       changecolor3($event){
       
       if( $event.currentTarget.src!='http://localhost:8090/static/image/change2-1.png'){
        $event.currentTarget.src='http://localhost:8090/static/image/change2-1.png'
        if(this.searchword.cartype==0){
           this.searchword.cartype=''
        }
        this.searchword.cartype+=$event.currentTarget.className+','
       }else{
          $event.currentTarget.src='http://localhost:8090/static/image/carleft2-1.png'
          this.searchword.cartype=(this.searchword.cartype).replace($event.currentTarget.className+',','');
       }  
      },
       changecolor4($event){
         
       if( $event.currentTarget.src!='http://localhost:8090/static/image/change2-2.png'){
        $event.currentTarget.src='http://localhost:8090/static/image/change2-2.png'
        if(this.searchword.cartype==0){
           this.searchword.cartype=''
        }
        this.searchword.cartype+=$event.currentTarget.className+','
       }else{
          $event.currentTarget.src='http://localhost:8090/static/image/carleft2-2.png'
          this.searchword.cartype=(this.searchword.cartype).replace($event.currentTarget.className+',','');
       } 
      },
       changecolor5($event){
   
       if( $event.currentTarget.src!='http://localhost:8090/static/image/change2-3.png'){
        $event.currentTarget.src='http://localhost:8090/static/image/change2-3.png'
        if(this.searchword.cartype==0){
           this.searchword.cartype=''
        }
        this.searchword.cartype+=$event.currentTarget.className+','
       }else{
          $event.currentTarget.src='http://localhost:8090/static/image/carleft2-3.png'
          this.searchword.cartype=(this.searchword.cartype).replace($event.currentTarget.className+',','');
       } 
   },
       changecolor6($event){
       
       if( $event.currentTarget.src!='http://localhost:8090/static/image/change3-1.png'){
        $event.currentTarget.src='http://localhost:8090/static/image/change3-1.png'
        if(this.searchword.cartype==0){
           this.searchword.cartype=''
        }
        this.searchword.cartype+=$event.currentTarget.className+','
       }else{
          $event.currentTarget.src='http://localhost:8090/static/image/carleft3-1.png'
          this.searchword.cartype=(this.searchword.cartype).replace($event.currentTarget.className+',','');
       } 
      },
       changecolor7($event){
         
       if( $event.currentTarget.src!='http://localhost:8090/static/image/change3-2.png'){
        $event.currentTarget.src='http://localhost:8090/static/image/change3-2.png'
        if(this.searchword.cartype==0){
           this.searchword.cartype=''
        }
        this.searchword.cartype+=$event.currentTarget.className+','
       }else{
          $event.currentTarget.src='http://localhost:8090/static/image/carleft3-2.png'
          this.searchword.cartype=(this.searchword.cartype).replace($event.currentTarget.className+',','');
       } 
      },
       changecolor8($event){
         
       if( $event.currentTarget.src!='http://localhost:8090/static/image/change3-3.png'){
        $event.currentTarget.src='http://localhost:8090/static/image/change3-3.png'
        if(this.searchword.cartype==0){
           this.searchword.cartype=''
        }
        this.searchword.cartype+=$event.currentTarget.className+','
       }else{
          $event.currentTarget.src='http://localhost:8090/static/image/carleft3-3.png'
          this.searchword.cartype=(this.searchword.cartype).replace($event.currentTarget.className+',','');
       }    
      },
      changecolor9($event){
        document.getElementById('img112').src='http://localhost:8090/static/image/carleft1-2.png'
        document.getElementById('img113').src='http://localhost:8090/static/image/carleft1-3.png'
        document.getElementById('img221').src='http://localhost:8090/static/image/carleft2-1.png'
        document.getElementById('img222').src='http://localhost:8090/static/image/carleft2-2.png'
        document.getElementById('img223').src='http://localhost:8090/static/image/carleft2-3.png'
        document.getElementById('img331').src='http://localhost:8090/static/image/carleft3-1.png'
        document.getElementById('img332').src='http://localhost:8090/static/image/carleft3-2.png'
        document.getElementById('img333').src='http://localhost:8090/static/image/carleft3-3.png'
        this.searchword.cartype=$event.currentTarget.className
      },
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.carname2{
  color: #ff7d00;
}
    .car-left-nav{
       color:rgb(95, 95, 95);
       font-size:15px;
       font-weight: 1;
       background-color:white;
       float:right;
       width:250px;
       height: 1033px;
       padding-top: 10px;
       float: left;
       margin-left:50px;
    }

    
    .car-left-nav a{
      padding: 2px 8px 3px;
      margin: 5px 0px 0px 0;
      display: inline-block;
    }

#msg{
  font-size: 15px;
  margin-left: 10px;
  
  
}


#line1 {
  margin-top: -30px;;

  width: 220px;
  height: 70px;

}

#line1 span{
  font-size: 10px;
}

#line2 span{
  font-size: 10px;
}

#line3 span{
  font-size: 10px;
}

#line2 {
  width: 220px;
  height: 56px;
}

#line3 {
  width: 220px;
  height: 56px;
}

#line4 {
  width: 220px;
  
}

.line1{
  display: inline;
  list-style: none;
}

#buxian{
  position: absolute;
  margin-left: 35px;
  margin-top: 10px;
}


#buxian img{
  margin-bottom: 10px;
  margin-left: -30px;
  height: 40px;
  width: 40px;
}


#img1{
  margin-left: 100px;
  margin-top: 5px;
  width: 65x;
  
  
}

#img1 img{
  height: 50px;
  width: 45x;
  
}

#img1 span{
  margin-left: -55px;
}


#img2{
  margin-left: 180px;
  margin-top: -54px;
  
}

#img2 img{
   height: 40px;
   width: 50px;
   margin-bottom: -15px;
}

#img2 span{
  margin-left: 5px;
}

   
.line2 {
  display: inline;
  list-style: none;
}

    
#img21{
   position: absolute;
   margin-left: 20px;
   margin-top: 5px;
}  

#img21 img{
  height: 30px;
  width:70px;
  margin-bottom: 9px;
  
}

#img21 span{
  margin-left: -55px;
  margin-bottom: -10px;
}


#img22{
  position: absolute;
  margin-left: 100px;
  margin-top: -10px;
}

#img22 img{
  height: 60px;
  width:55px;
  margin-bottom: -7px;
}

#img22 span{
  margin-left: -45px;
 
}

#img23{
  position: absolute;
  margin-left: 178px;
  margin-top: -5px;
}

#img23 img{
  height: 55px;
  width:50px;
   margin-bottom: -2px;
}

#img23 span{
  margin-left: -38px;
}


.line3{
   display: inline;
   list-style: none;
}
    
#img31{
  position: absolute;
  margin-left: 29px;
   margin-top:-5px;
}

#img31 img{
   height: 60px;
   width:60px;
   margin-bottom: -3px;
}

#img31 span{
  margin-left: -62px;
}


#img32{
  position: absolute;
  margin-left: 108px;
   margin-top:3px;

  
}

#img32 img{
  height:40px;
  width:55px;
  margin-bottom: 10px;
}

#img32 span{
  margin-left: -43px;
}


#img33{
  position: absolute;
  margin-left: 180px;
  margin-top: 0px;
  
}

#img33 img{
  height: 50px;
  width:50px;
  margin-bottom: 3px;
  
}

#img33 span{
  margin-left: -40px;
}

#line4{
  margin-top: 50px;
  margin-left: 5px;
}

#line5{
  width: 100%;
  height: 300px;
  margin-left: 0px;
  margin-top: 10px; 
}

#line5 .b1{
  margin-left:22px;
  color:gray;
  width:35px
}

#line5 a:hover{
  color: #ff7d00;
}

a{
   text-decoration:none
}

 
#line5 span a{
  text-align: center;
  font-size: 12px;
  font-weight: 50;
  width: 70px;
  /* color:gray; */
}



#line5 .b2{
  color:gray;
  width:33px
}

#line6 .block{
  margin-top: 1320px;
}

.el-select{
  width: 120px;
  margin-top: 40px;
}
.el-select{
  margin-left: 5px;
}

#hr2{
  margin-top: 25px;
  color: gray
}    
</style>
