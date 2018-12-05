<template>
  <div class="company_car_list">
    <div class="w1">
      <div id="headsearch">
          <el-input
                  size="large"
                  placeholder="请输入搜索内容"
                  v-model="words"
                  clearable>
          </el-input>
          <el-row>
             <el-button size="large" @click="getsearchCompanyCars" type="warning">搜 索</el-button>
          </el-row>
       </div>

          <!-- <span>车型:</span> -->
       <div class='fristline'>
          <ul>
            <span id=type>车型:</span>
            <li><div id='carhead0' class='pp1' @click='chooseallcartype($event)' ><span>不限</span><a><img :src="scr0"></a></div></li>
            <li><div id='carhead1' class='pp1' @click='choosecartype($event)' value='手动紧凑型'><span class='手动紧凑型' id='span2'>手动紧凑型</span><a><img :src="scr1"></a></div></li>
            <li><div id='carhead2' class='pp1' @click='choosecartype($event)'><span class='经济型' id='span3'>经济型</span><a><img :src="scr2"></a></div></li>
            <li><div id='carhead3' class='pp1' @click='choosecartype($event)'><span class='商务型' id='span4'>商务型</span><a><img :src="scr3"></a></div></li>
            <li><div id='carhead4' class='pp1' @click='choosecartype($event)'><span class='豪华型' id='span5'>豪华型</span><a><img :src="scr4"></a></div></li>
            <li><div id='carhead5' class='pp1' @click='choosecartype($event)'><span class='SUV' id='span6'>SUV</span><a><img :src="scr5"></a></div></li>
            <li><div id='carhead6' class='pp1' @click='choosecartype($event)'><span class='6至15商务座' id='span7'>6-15商务座</span><a><img :src="scr6"></a></div></li>
            <li><div id='carhead7' class='pp1' @click='choosecartype($event)'><span class='个性车' id='span8'>个性车</span><a><img :src="scr7"></a></div></li>
            <li><div id='carhead8' class='pp1' @click='choosecartype($event)'><span class='电动车' id='span9'>电动车</span><a><img :src="scr8"></a></div></li>
          </ul>
        </div>
        
       <div class='secomdline'>
            <span id='s1'>{{msg1}}:</span>
            <div class='comcarlist'>
            <a class='allcar' @click="chooseallcarbrand($event)">不限</a>
            <span  @click="changecolor($event)"><a class='carname'>玛莎拉蒂</a></span>
            <span  @click="changecolor($event)"><a class='carname'>大众</a></span> 
            <span  @click="changecolor($event)"><a class='carname'>一汽马自达</a></span>
            <span  @click="changecolor($event)"><a class='carname'>英菲尼迪</a></span> 
            <span  @click="changecolor($event)"><a class='carname'>上汽大通</a></span>
            <span  @click="changecolor($event)"><a class='carname'>奔驰</a></span> 
            <span  @click="changecolor($event)"><a class='carname'>奥迪</a></span>
            <span  @click="changecolor($event)"><a class='carname'>大众斯柯达</a></span> 
            <span  @click="changecolor($event)"><a class='carname'>MG</a></span>
            <span  @click="changecolor($event)"><a class='carname'>荣盛</a></span> 
            <span  @click="changecolor($event)"><a class='carname'>一汽</a></span>
            <span  @click="changecolor($event)"><a class='carname'>别克</a></span> 
            <span  @click="changecolor($event)"><a class='carname'>东风</a></span>
            <span  @click="changecolor($event)"><a class='carname'>本田</a></span> 
            <span  @click="changecolor($event)"><a class='carname'>雪佛兰</a></span>
            <span  @click="changecolor($event)"><a class='carname'>宝马</a></span> 
            <span  @click="changecolor($event)"><a class='carname'>Jeep</a></span>
            <span  @click="changecolor($event)"><a class='carname'>绅宝</a></span>
            <span  @click="changecolor($event)"><a class='carname'>沃尔沃</a></span>
            <span  @click="changecolor($event)"><a class='carname'>路虎</a></span>
            <span  @click="changecolor($event)"><a class='carname'>现代</a></span>
            <span  @click="changecolor($event)"><a class='carname'>丰田</a></span>
             <span @click="changecolor($event)"><a class='carname'>起亚</a></span>
            <div id='showType' v-show="showCarType">
            <span @click="changecolor($event)"><a class='carname'>捷豹</a></span> 
            <span @click="changecolor($event)"><a class='carname'>雪铁龙</a></span>
            <span @click="changecolor($event)"><a class='carname'>华泰</a></span> 
            <span @click="changecolor($event)"><a class='carname'>依维柯</a></span>
            <span @click="changecolor($event)"><a class='carname'>MINI</a></span> 
            <span @click="changecolor($event)"><a class='carname'>华颂</a></span>
            <span @click="changecolor($event)"><a class='carname'>风行</a></span> 
            <span @click="changecolor($event)"><a class='carname'>广汽</a></span>
            <span @click="changecolor($event)"><a class='carname'>北京汽车</a></span> 
            <span @click="changecolor($event)"><a class='carname'>金杯</a></span>
            <span @click="changecolor($event)"><a class='carname'>腾势</a></span> 
            <span @click="changecolor($event)"><a class='carname'>标致</a></span>
            <span @click="changecolor($event)"><a class='carname'>沃尔沃</a></span> 
            <span @click="changecolor($event)"><a class='carname'>菲亚特</a></span>
            <span @click="changecolor($event)"><a class='carname'>江淮</a></span> 
            <span @click="changecolor($event)"><a class='carname'>红旗</a></span>
            <span @click="changecolor($event)"><a class='carname'>雷克萨斯</a></span> 
            <span @click="changecolor($event)"><a class='carname'>九龙</a></span>
            <span @click="changecolor($event)"><a class='carname'>宝骏</a></span>
            <span @click="changecolor($event)"><a class='carname'>菲亚特</a></span>
            <span @click="changecolor($event)"><a class='carname'>smart</a></span>
            <span @click="changecolor($event)"><a class='carname'>北汽</a></span>
            <span @click="changecolor($event)"><a class='carname'>阿斯顿马丁</a></span>
            <span @click="changecolor($event)"><a class='carname'>力帆</a></span>
            <span @click="changecolor($event)"><a class='carname'>扬子江</a></span>
            <span @click="changecolor($event)"><a class='carname'>阿尔法罗密欧</a></span> 
            <span @click="changecolor($event)"><a class='carname'>林肯</a></span>
            <span @click="changecolor($event)"><a class='carname'>海马</a></span> 
            <span @click="changecolor($event)"><a class='carname'>东风风行</a></span>
            <span @click="changecolor($event)"><a class='carname'>保时捷</a></span> 
            <span @click="changecolor($event)"><a class='carname'>汇众</a></span>
            <span @click="changecolor($event)"><a class='carname'>启辰</a></span> 
            <span @click="changecolor($event)"><a class='carname'>道奇</a></span>
            <span @click="changecolor($event)"><a class='carname'>三菱</a></span> 
            <span @click="changecolor($event)"><a class='carname'>吉利</a></span>
            <span @click="changecolor($event)"><a class='carname'>吉利</a></span> 
            <span @click="changecolor($event)"><a class='carname'>上汽大通</a></span>
            <span @click="changecolor($event)"><a class='carname'>哈弗</a></span> 
            <span @click="changecolor($event)"><a class='carname'>福田</a></span> 
            <span @click="changecolor($event)"><a class='carname'>纳智捷</a></span>
            </div>
            <span class='moreclass' id='more' @click="showType">{{more}}</span>
          </div>
        </div>
       <div id='thredline'>
              <span id='s3'>{{msg2}}:</span>
            <div id='pricelist'>
               <a class='allcar' @click='chooseprice0($event)'>不限</a>
               <a class='carname1' @click='chooseprice1($event)'>100元以下</a>
               <a class='carname1' @click='chooseprice2($event)'>100-200元</a>
               <a class='carname1' @click='chooseprice3($event)'>200-300元</a>
               <a class='carname1' @click='chooseprice4($event)'>300元以上</a>
            </div>
       </div>
       <div id='carlist'>


        <div>
            <el-row>
                <!--商品展示-->
                <el-col :span="22">
    
                    <div class="goods-type">
    
                        <el-tabs class="bookmark"  type="card" @tab-click="computedRentMoney">
                            <el-tab-pane label="短租自驾">
                                <table class="carList_tb" cellpadding="0" cellspacing="0" border="0"  >
                                    <tbody class="carList">

                                        <tr v-for="(car,index) in carListCount" :key="index" class="carList_tr">
                                            
                                            <router-link :to="{path:'/car/car_detail',query:{carId: car.carId,carPrice: car.carRentShort}}">
                                            <td class="car_pic">

                                                <a href="#"><img :src="car.generalImage.length === 0 ? '../../../../static/image/LogoNew.jpg' : car.generalImage[0].imgPath" width="230px" height="130px"></a>
                                            </td>
                                            </router-link>
                                            <td class="car_info">
                                                <p class="car_name">{{ car.carName }}</p>
                                                <p class="car_oth">
                                                    <span>{{ car.carDisplacement }}{{car.carTransmission}}|</span>
                                                    <span>{{ car.carPower }}|</span>
                                                    <span>乘坐{{ car.carSeat }}人</span>

                                                </p>
                                            </td>
                                            <td class="car_ord">
                                                <div class="order_box">
                                                    <div class="ord_price">
                                                        <div class="houfu"></div>
                                                        <div class="car_price">
                                                            <span class="price">
                                                                <em class="rmb">￥</em>
                                                                <em class="num">{{ car.carRentShort }}</em>
                                                                <em class="unit">/日均</em>
                                                            </span>
                                                        </div>
                                                        <router-link :to="{path:'/order/order_first',query:{carId: car.carId,carPrice: car.carRentShort}}">
                                                            <el-button class="btn" type="warning">租车</el-button>
                                                        </router-link>
                                                    </div>
                                                </div>
                                              <a href="#">
                                                 <div class="spe_ord xian_o">
                                                      <span class="tip_o tiplh16">套餐价</span>
                                                      <div class="tip_inco">
                                                          <span class="tl">
                                                              <em class="rmb">￥</em>
                                                              <em class="num">{{ car.carRentLong }}</em>
                                                              <em class="unit">/套餐日均价</em>
                                                          </span>
                                                          <span class="tr">
                                                              <em class="all">共优惠</em>
                                                              <em class="num">
                                                                  ￥
                                                                  <span>-{{ car.carWindon }}</span>
                                                              </em>
                                                          </span>
                                                      </div>
                                                  </div>
                                              </a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </el-tab-pane>
                            <el-tab-pane label="周租套餐（7-27）">
                                 <table class="carList_tb" cellpadding="0" cellspacing="0" border="0"  >
                                    <tbody class="carList">
                                        <tr v-for="(car,index) in carListCount" :key="index" class="carList_tr">
                                                <router-link :to="{path:'/car/car_detail',query:{carId: car.carId,carPrice: car.carRentShort}}">
                                            <td class="car_pic">
                                                <a href="#"><img :src="car.generalImage.length === 0 ? '../../../../static/image/LogoNew.jpg' : car.generalImage[0].imgPath" width="230px" height="130px"></a>
                                            </td>
                                                </router-link>
                                            <td class="car_info">
                                                <p class="car_name">{{ car.carName }}</p>
                                                <p class="car_oth">
                                                    <span>{{ car.carDisplacement }}{{car.carTransmission}}|</span>
                                                    <span>{{ car.carPower }}|</span>
                                                    <span>乘坐{{ car.carSeat }}人</span>

                                                </p>
                                            </td>
                                            <td class="car_ord">
                                                <div class="order_box">
                                                    <div class="ord_price">
                                                        <div class="houfu"></div>
                                                        <div class="car_price">
                                                            <span class="price">
                                                                <em class="rmb">￥</em>
                                                                <em class="num">{{ car.carRentShort }}</em>
                                                                <em class="unit">/日均</em>
                                                            </span>
                                                        </div>
                                                        <router-link :to="{path:'/order/order_first',query:{carId: car.carId,carPrice: car.carRentShort}}">
                                                      <el-button class="btn" type="warning">租车</el-button>
                                                        </router-link>
                                                    </div>
                                                </div>
                                              <a href="#">
                                                 <div class="spe_ord xian_o">
                                                      <span class="tip_o tiplh16">套餐价</span>
                                                      <div class="tip_inco">
                                                          <span class="tl">
                                                              <em class="rmb">￥</em>
                                                              <em class="num">{{ car.carRentLong }}</em>
                                                              <em class="unit">/套餐日均价</em>
                                                          </span>
                                                          <span class="tr">
                                                              <em class="all">共优惠</em>
                                                              <em class="num">
                                                                  ￥
                                                                  <span>-{{ car.carWindon }}</span>
                                                              </em>
                                                          </span>
                                                      </div>
                                                  </div>
                                              </a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </el-tab-pane>
                            <el-tab-pane label="月租套餐（28+）">
                                 <table class="carList_tb" cellpadding="0" cellspacing="0" border="0"  >
                                    <tbody class="carList">
                                        <tr v-for="(car,index) in carListCount" :key="index" class="carList_tr">
                                                <router-link :to="{path:'/car/car_detail',query:{carId: car.carId,carPrice: car.carRentShort}}">
                                            <td class="car_pic">
                                                <a href="#"><img :src="car.generalImage.length === 0 ? '../../../../static/image/LogoNew.jpg' : car.generalImage[0].imgPath" width="230px" height="130px"></a>
                                            </td>
                                                </router-link>
                                            <td class="car_info">
                                                <p class="car_name">{{ car.carName }}</p>
                                                <p class="car_oth">
                                                    <span>{{ car.carDisplacement }}{{car.carTransmission}}|</span>
                                                    <span>{{ car.carPower }}|</span>
                                                    <span>乘坐{{ car.carSeat }}人</span>

                                                </p>
                                            </td>
                                            <td class="car_ord">
                                                <div class="order_box">
                                                    <div class="ord_price">
                                                        <div class="houfu"></div>
                                                        <div class="car_price">
                                                            <span class="price">
                                                                <em class="rmb">￥</em>
                                                                <em class="num">{{ car.carRentShort }}</em>
                                                                <em class="unit">/日均</em>
                                                            </span>
                                                        </div>
                                                        <router-link :to="{path:'/order/order_first',query:{carId: car.carId,carPrice: car.carRentShort}}">
                                                      <el-button class="btn" type="warning">租车</el-button>
                                                        </router-link>
                                                    </div>
                                                </div>
                                              <a href="#">
                                                 <div class="spe_ord xian_o">
                                                      <span class="tip_o tiplh16">套餐价</span>
                                                      <div class="tip_inco">
                                                          <span class="tl">
                                                              <em class="rmb">￥</em>
                                                              <em class="num">{{ car.carRentLong }}</em>
                                                              <em class="unit">/套餐日均价</em>
                                                          </span>
                                                          <span class="tr">
                                                              <em class="all">共优惠</em>
                                                              <em class="num">
                                                                  ￥
                                                                  <span>-{{ car.carWindon }}</span>
                                                              </em>
                                                          </span>
                                                      </div>
                                                  </div>
                                              </a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </el-tab-pane>
                            <el-tab-pane label="年租套餐（365+）">
                                 <table class="carList_tb" cellpadding="0" cellspacing="0" border="0"  >
                                    <tbody class="carList">
                                        <tr v-for="(car,index) in carListCount" :key="index" class="carList_tr">
                                            <router-link :to="{path:'/car/car_detail',query:{carId: car.carId,carPrice: car.carRentLong}}">
                                            <td class="car_pic">
                                                <a href="#"><img :src="car.generalImage.length === 0 ? '../../../../static/image/LogoNew.jpg' : car.generalImage[0].imgPath" width="230px" height="130px"></a>
                                            </td>
                                                </router-link>
                                            <td class="car_info">
                                                <p class="car_name">{{ car.carName }}</p>
                                                <p class="car_oth">
                                                    <span>{{ car.carDisplacement }}{{car.carTransmission}}|</span>
                                                    <span>{{ car.carPower }}|</span>
                                                    <span>乘坐{{ car.carSeat }}人</span>

                                                </p>
                                            </td>
                                            <td class="car_ord">
                                                <div class="order_box">
                                                    <div class="ord_price">
                                                        <div class="houfu"></div>
                                                        <div class="car_price">
                                                            <span class="price">
                                                                <em class="rmb">￥</em>
                                                                <em class="num">{{ car.carRentLong }}</em>
                                                                <em class="unit">/日均</em>
                                                            </span>
                                                        </div>
                                                        <router-link :to="{path:'/order/order_first',query:{carId: car.carId,carPrice: car.carRentLong}}">
                                                      <el-button class="btn" type="warning">租车</el-button>
                                                        </router-link>
                                                    </div>
                                                </div>
                                              <a href="#">
                                                 <div class="spe_ord xian_o">
                                                      <span class="tip_o tiplh16">套餐价</span>
                                                      <div class="tip_inco">
                                                          <span class="tl">
                                                              <em class="rmb">￥</em>
                                                              <em class="num">{{ car.carRentLong }}</em>
                                                              <em class="unit">/套餐日均价</em>
                                                          </span>
                                                          <span class="tr">
                                                              <em class="all">共优惠</em>
                                                              <em class="num">
                                                                  ￥
                                                                  <span>-0</span>
                                                              </em>
                                                          </span>
                                                      </div>
                                                  </div>
                                              </a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </el-tab-pane>
                        </el-tabs>
                        <el-button @click="rentSort" id='rentsorebutton' type="warning" size="small" style="position:absolute;right:350px;top:10px;">租金排序</el-button>
                    </div>
    
                </el-col>
            </el-row>
        </div>
        <div class="page">
            <el-pagination
                background
                @current-change="changeIndex"
                :current-page.sync="pageCode"
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
 import {getCompanyAllCarInfo,getShortRentCarInfo,getWeekRentCarInfo,
       getMonthRentCarInfo,getLongRentCarInfo,searchCarsMutipl,
       getCompanyAllCarInfoByPage,companyAllDiscountCarByPage,searchCompanyCars} from '@/api/comInfo'

export default {
  name: 'company_car_list',
  data () {
    return {
      searchword:{
            cartype:'0',
            carbrand:'0',
            carminprice:0,
            carmaxprice:1500,
            carSeatBegin:0,
            carSeatEnd:50,
                 },
      carListCount:[],
      pageSize:5,          //默认每页的条数
      pageCode:1,          // 默认当前页
      totalCount:0, 
      tabIndex:'0',       // 总记录数
      companyId:'',
      showCarType:false,
      isSorted:false,     
      sortDirection:'0',
      isSearch:false, //是否模糊查询
      words:'',
      isSearchOptions:false,   //是否多条件查询
      leftSearchFlag:false,
      more:'>>',     
      msg1:'品牌',
      msg2:'价格',
      searchinput: '',
      scr0:'../../../../static/image/carheadn-0.jpg',
      scr1:'../../../../static/image/carheadn-1.jpg',
      scr2:'../../../../static/image/carheadn-2.jpg',
      scr3:'../../../../static/image/carheadn-3.jpg',
      scr4:'../../../../static/image/carheadn-4.jpg',
      scr5:'../../../../static/image/carheadn-5.jpg',
      scr6:'../../../../static/image/carheadn-6.jpg',
      scr7:'../../../../static/image/carheadn-7.jpg',
      scr8:'../../../../static/image/carheadn-8.jpg',
    }
  },
  methods:{
                // 多条件查询
      searchLeftCarsMutipl(page, size, carType, carBrand,
  carPriceBegin, carPriceEnd, carSeatBegin, carSeatEnd, companyId){
                searchCarsMutipl(1,this.pageSize, this.searchword.cartype, this.searchword.carbrand,
        this.searchword.carminprice, this.searchword.carmaxprice, this.searchword.carSeatBegin, this.searchword.carSeatEnd, this.companyId)
                .then(response=>{
                    console.log(this.searchword.cartype)
                    console.log(this.searchword.carbrand)
                    console.log(this.searchword.carminprice)
                    console.log(this.searchword.carmaxprice)
                    console.log(this.searchword.carSeatBegin)
                    console.log(this.searchword.carSeatEnd)                    
                    console.log(response.data);
                    this.carListCount=response.data.list;
                    this.pageCode=response.data.pageNum // 当前页数
                    this.totalCount=response.data.total // 总记录数
             })
        },
     // 模糊查询
        getsearchCompanyCars(){
            console.log(this.words)
            searchCompanyCars(1,this.pageSize,this.companyId,this.words)
                .then(response=>{
                    console.log(this.words)
                    console.log('hhhhhhhhhh')
                    console.log(response.data)
                    this.carListCount=response.data.list;
                    console.log(response.data.list[0].generalImage[0].imgPath)
                    this.pageCode=response.data.pageNum // 当前页数
                    this.totalCount=response.data.total // 总记录数
                })
        },
        // 租金排序
        rentSort(){
            
            if(this.sortDirection==='1'){
                this.sortDirection='0';
            }else{
                this.sortDirection='1'
            }
            this.isSorted=true;
           

            // 短租自驾排序
            if(this.tabIndex==='0'){
                console.log(this.sortDirection)
                getShortRentCarInfo(1,this.pageSize,this.sortDirection,this.companyId)
                .then(response=>{
                this.carListCount=response.data.list;
            })
            }
            // 周租套餐排序
            if(this.tabIndex==='1'){
                getWeekRentCarInfo(1,this.pageSize,'0.9f',this.sortDirection,this.companyId)
                .then(response=>{
                    console.log(this.pageSize)
                this.carListCount=response.data.list;
            })
            }
            // 月租套餐排序
            if(this.tabIndex==='2'){
                getMonthRentCarInfo(1,this.pageSize,'0.8f',this.sortDirection,this.companyId)
                .then(response=>{
                this.carListCount=response.data.list;
            })
            }
            // 年租套餐排序
            if(this.tabIndex==='3'){
            getLongRentCarInfo(1,this.pageSize,this.sortDirection,this.companyId)
            .then(response=>{
            this.carListCount=response.data.list;
            })
            }
        },
      computedRentMoney(tab){
                this.isSearch=false;
                this.leftSearchFlag=false;
                this.sortDirection='0';
                let responseData={};
                this.carListCount=[];
                this.tabIndex=tab.index;
                this.isSorted=false;
                this.pageCode=1;
                       if(tab.index==='0'){
                            // 短租
                            // 查询所有车辆
                        getCompanyAllCarInfoByPage(1,this.pageSize,this.companyId)
                        .then(response=>{
                        this.carListCount=response.data.list;  
                        this.pageCode=response.data.pageNum // 当前页数
                        this.totalCount=response.data.total // 总记录数
                            })

                        }
                        if(tab.index==='1'){
                        // 周租
                        companyAllDiscountCarByPage(1,this.pageSize,'0.9f',this.companyId)
                       .then(response=>{
                        console.log('i99999')
                        console.log(response.data)
                        this.carListCount=response.data.list;
                        console.log(response.data)
                        this.pageCode=response.data.pageNum // 当前页数
                        this.totalCount=response.data.total // 总记录数
                    })
                        }
                        if(tab.index==='2'){
                            // 月租
                            companyAllDiscountCarByPage(1,this.pageSize,'0.8f',this.companyId)
                    .then(response=>{
                        this.carListCount=response.data.list;
                        this.pageCode=response.data.pageNum // 当前页数
                        this.totalCount=response.data.total // 总记录数
                        })
                        }

                        if(tab.index==='3'){
                            // 年租
                            companyAllDiscountCarByPage(1,this.pageSize,'0.7f',this.companyId)
                        .then(response=>{
                            this.carListCount=response.data.list;
                            this.pageCode=response.data.pageNum // 当前页数
                            this.totalCount=response.data.total // 总记录数
                            })
                        }

     },
     getAllCarsList(){
        // 查询所有车辆
        getCompanyAllCarInfoByPage(1,this.pageSize,this.companyId)
        .then(response=>{
            this.carListCount=response.data.list // 周租和月租数据
            this.pageCode=response.data.pageNum // 当前页数
            this.totalCount=response.data.total // 总记录数
            })
    },
     searchCarsByOption(searchwords){
        searchCars(1,this.pageSize,searchwords)
       .then(response=>{
            response.data;
       })
      },
    // 分页，后台
    changeIndex(val){
        this.carListCount=[];
        let responseData={};
        console.log(val)
         //模糊搜索分页
         if(this.isSearch){
             this.getsearchCompanyCars(val,this.pageSize,this.companyId,this.words);
            return;
         }
          if(this.leftSearchFlag){
             this.searchLeftCarsMutipl(val,this.pageSize,this.searchword.cartype,this.searchword.carbrand,
            this.searchword.carminprice,this.searchword.carmaxprice,this.searchword.carminseat,this.searchword.carmaxseat,this.companyId);
          return;
         }
        // 短租分页
        if(this.tabIndex==='0'){
            
            // 短租分页不排序
            if(!this.isSorted){
            getCompanyAllCarInfoByPage(val,this.pageSize,this.companyId)
            .then(response=>{
            this.carListCount=response.data.list
            this.pageCode=response.data.pageNum // 当前页数
            this.totalCount=response.data.total // 总记录数
        })
            }else{
            // 短租分页排序
            getShortRentCarInfo(val,this.pageSize,this.sortDirection,this.companyId)
            .then(response=>{
            this.carListCount=response.data.list;
            this.pageCode=response.data.pageNum // 当前页数
            this.totalCount=response.data.total // 总记录数
            })
            }
            return;
        }

        // 周租
        if(this.tabIndex==='1'){
           // 周租分页不排序
           if(!this.isSorted){
                companyAllDiscountCarByPage(val,this.pageSize,'0.9f',this.companyId)
                .then(response=>{
                    this.carListCount=response.data.list
                })
           }else{
               // 周租分页排序
               companyAllDiscountCarByPage(val,this.pageSize,'0.9f',this.companyId)
                .then(response=>{
                this.carListCount=response.data.list;
                })
           }
           return;
     }
        // 月租
        if(this.tabIndex==='2'){
            // 月租分页不排序
            if(!this.isSorted){
                console.log(val)
                 companyAllDiscountCarByPage(val,this.pageSize,'0.8f',this.companyId)
                .then(response=>{
                this.carListCount=response.data.list
                })
            }else{
                // 月租分页排序
                getMonthRentCarInfo(val,this.pageSize,this.sortDirection,this.companyId)
                .then(response=>{
                this.carListCount=response.data.list;
                })
            }  
            return;  
        }

        // 年租
        if(this.tabIndex==='3'){
             // 年租分页不排序
            if(!this.isSorted){
            companyAllDiscountCarByPage(val,this.pageSize,'0.8f',this.companyId)
            .then(response=>{
            this.carListCount=response.data.list
                            })
                }else{
                    // 年租分页排序
                    console.log(this.sortDirection)
                        getLongRentCarInfo(val,this.pageSize,this.sortDirection,this.companyId)
                        .then(response=>{
                        this.carListCount=response.data.list;
                            })
                    }
                return;
                        
                        } 
                    },

      showType (){
          if(this.showCarType ==false){
             this.showCarType = !this.showCarType
             this.more='<<'
             document.getElementById('more').className='moreclass1'
          }else{
               this.showCarType = !this.showCarType
               this.more='>>'
               document.getElementById('more').className='moreclass'
          }
      },
      choosecartype($event){
          
        if($event.currentTarget.style.color!='orange'){
             $event.currentTarget.style.color='orange'
             if(this.searchword.cartype==0){
                this.searchword.cartype=''  
             }
             this.searchword.cartype += $event.currentTarget.firstChild.className+','
        }else{
            $event.currentTarget.style.color='gray'
            this.searchword.cartype=(this.searchword.cartype).replace($event.currentTarget.firstChild.className+',','');
            }
      },
      chooseallcartype(e){
           var all=[];
           all = document.getElementsByClassName('pp1')
           for(var i=0;i<all.length;i++){
            all[i].style.color='gray'
             }
            this.searchword.cartype=0
            },

      changecolor(e){
         
          if(e.target.style.backgroundColor.toString()=='rgb(255, 143, 2)') {
              e.target.style.backgroundColor =  "#fff"
              this.searchword.carbrand=(this.searchword.carbrand).replace(e.target.innerText+',','');
              
          }else{
               e.target.style.backgroundColor = "#ff8f02"
               if(this.searchword.carbrand==0){
                  this.searchword.carbrand=''
              }
              this.searchword.carbrand+=e.target.innerText+','
              
          }
      },
      chooseallcarbrand($event){
            var all2=[];
           all2 = document.getElementsByClassName('carname')
           for(var i=0;i<all2.length;i++){
            all2[i].style.backgroundColor='#fff'
             }
            this.searchword.carbrand=0
            }  ,
      chooseprice0(e){
           var all3=[];
           all3 = document.getElementsByClassName('carname1')
           for(var i=0;i<all3.length;i++){
            all3[i].style.backgroundColor='#fff'
             }
            this.searchword.carminprice=0
            this.searchword.carmaxprice=1500    
       },
       chooseprice1(e){
             var all4=[];
             all4 = document.getElementsByClassName('carname1')
             for(var i=0;i<all4.length;i++){
             all4[i].style.backgroundColor='#fff'
             }
             e.target.style.backgroundColor = "#ff8f02"
             this.searchword.carminprice=0
             this.searchword.carmaxprice=100
       },
       chooseprice2(e){
           var all5=[];
           all5 = document.getElementsByClassName('carname1')
           for(var i=0;i<all5.length;i++){
            all5[i].style.backgroundColor='#fff'
             }
            e.target.style.backgroundColor = "#ff8f02"
            this.searchword.carminprice=100
            this.searchword.carmaxprice=200
       },
       chooseprice3(e){
           var all6=[];
           all6 = document.getElementsByClassName('carname1')
           for(var i=0;i<all6.length;i++){
            all6[i].style.backgroundColor='#fff'
             }
            e.target.style.backgroundColor = "#ff8f02"
            this.searchword.carminprice=200
            this.searchword.carmaxprice=300
       },
       chooseprice4(e){
           var all7=[];
           all7 = document.getElementsByClassName('carname1')
           for(var i=0;i<all7.length;i++){
            all7[i].style.backgroundColor='#fff'
             }
            e.target.style.backgroundColor = "#ff8f02"
            this.searchword.carminprice=300
            this.searchword.carmaxprice=1500
       },
  },
 
            watch:{
                // 深度监听实现多条件查询
                searchword:{
                handler(newVal,oldVal){
                    this.searchLeftCarsMutipl(1,this.pageSize,newVal.cartype,newVal.carbrand,
                    newVal.carminprice,newVal.carmaxprice,newVal.carminseat,newVal.carmaxseat,this.companyId);
                },
                deep:true
                }
            },
            mounted: function(){
                this.companyId= this.$route.query.id
                this.getAllCarsList();
            },
    
}

</script>
<style scoped>


.el-button{
    margin-bottom: 20px;
}

  a{
  text-decoration:none;
  font-size:14px;
  
   }
 .carname:hover{
   background-color: #ff8f02;
 }
 .carname1:hover{
   background-color: #ff8f02;
 }




.company_car_list{
  background-color: white;
  width: 100%;
  height: 1500px;
}

.w1{
  width: 1080px;
  height: 100%;
  border: 1px solid white;
  margin: 0 auto;
}

#headsearch{
  height: 3%;
  width: 50%;
  margin: 20px auto;
  border: 1px solid white;
}

.el-input{
  width: 100%;
}

.el-button{
  position:absolute;
  
  margin-left: 85.5%;
  margin-top: -41px;
  /* background-color:#ff8f02; */
}

#rentsorebutton{
     position:absolute;
      margin-top: -1px;
}

#type{
    position: absolute;
    margin-left: -26px;
    margin-top: 40px;
    font-size: 15px;
}
.pp1{
    width: 70;
    height: 80px;
}

.pp1 img{
    width: 60px;
    height: 40px;
    margin-top: 30px;
}

.pp1 span{
    position: absolute;
    margin-top: 5px;
    margin-left: 12px; 
}

#carhead0 span{
    margin-left: 12px;
} 

#carhead1 span{
    margin-left: -2px;
}

#carhead5 span{
   margin-left: 20px;  
}

#carhead6 span{
   margin-left: 1px;  
}



.fristline{
  height: 6.5%;
  width: 90%;
  border: 1px solid gray; 
  border-bottom:none;
  margin: 0 auto;
}
.fristline ul{
  height: 90%;
  border: 1px solid white;
  border-bottom: none;

}

.fristline li{
   list-style: none;
   float: left;
   margin-left: 20px;
}

.fristline .pp2{
    width: 70px;
    height: 80px;
    border: 1px solid gray
}
.pp2 img{
    width: 60px;
    height: 40px;
    margin-top: 30px;
}

.pp2 span{
    position: absolute;
    margin-top: 5px;
    margin-left: 12px;
}











.spanmsg{
  font-size: 15px;
}

.secomdline{
      height: auto;
      width: 90%;
      /* gai */
      border: 1px solid gray;
      border-bottom: 1px solid #fff;
      margin: 0 auto;
}

 .comcarlist{
  height: 90%;
  width: 90%;
  border: 1px solid white;
  margin-left: 7%;
  
}
 .comcarlist a{
   padding: 2px 12px 3px;
   margin: 10px 5px 0 0;
   display: inline-block;
 }
 


.allcar{
   font-size:14px;
   background-color: #ff8f02;
}
#s1{
  position: absolute;
  font-size: 15px;
  margin-left: 15px;
  margin-top: 10px;
}


#s2{
     font-size: 13px;
}

.moreclass{
  font-size: 15px;
  float:right;
  margin-right: -8px;
  margin-top: 12px;
}

.moreclass1{
  font-size: 15px;
  float:right;
  margin-top: -23px;
}





#thredline{
  height: 3%;
  width: 90%;
  /* gai  */
  border: 1px solid gray;
  border-top:none;
  margin: 0 auto;
}

#s3{
  position: absolute;
  font-size: 15px;
  margin-left: 14px;
  margin-top: 0.7%;
  
}
 

#thredline a{
   padding: 2px 12px 3px;
   margin: 10px 5px 0 0;
   display: inline-block;
   text-decoration:none;
 }

 #pricelist{
   height: 3%;
   width: 90%;
   margin-left: 7%;
 }














/* #carlist{
  height: 60%;
  width: 90%;
  border: 1px solid gold;
  margin: 0 auto;
} */

#carlist {
    background-color: white;
    height: 1000px;
    float: right; 
    width: 1062px;
    margin-right: -38px;
    margin-top: 30px;
    
}

.goods-type {
    clear: both;
}

.carList_tb {
    width: 100%;
}

.page{
    margin: 20px auto;
    padding-left: 230px;
    height: 50px;
    width: 100%;
}


.car_pic {
    padding: 25px 0 25px 60px;
    width: 200px;
    border-bottom: 1px solid #e4e6e9;
}

.car_info {
    width: 50%;
    padding-left: 20px;
    border-bottom: 1px solid #e4e6e9;
}

.car_name {
    font-size: 18px;
    color: #60606c;
    line-height: 26px;
}

.car_oth {
    font-size: 12px;
    line-height: 24px;
    color: gray;
}

.car_ord {
    width: 300px;
    padding: 30px 0 30px 0;
    border-bottom: 1px solid #e4e6e9;
}

.ord_price {
    float: left;
    width: 260px;
}


.car_price {
    height: 50px;
    width: 160px;
    float: left;
    position: relative;
    left: 15px;
}

.price {
    float: left;
    overflow: hidden;
}

.rmb {
    display: inline-block;
    font-size: 24px;
    color: #fabe00;
    font-style: normal;
    line-height: 30px;
}

.num {
        display: inline-block;
    font-size: 30px;
    color: #fabe00;
    font-style: normal;
    line-height: 30px;
}

.unit {
    display: inline-block;
    font-size: 12px;
    font-style: normal;
    margin-top: 12px;
}
.btn {

    float: right;
    position: relative;
    width: 100px;
    height: 45px;
    text-align: center;
}

.spe_ord.xian_o {
    background-color: #ff8650;
    /* margin-left: 20px; */
    width: 260px;
}

.spe_ord {
    float: right;
    width: 340px;
    height: 50px;
    line-height: 50px;
    border-radius: 3px;
    margin-bottom: 5px;
    cursor: pointer;
}

.tip_o.tiplh16 {
    line-height: 16px;
}

.tip_o {
    width: 20px;
    height: 49px;
    font-size: 11px;
    color: #fff;
    line-height: 12px;
    display: inline-block;
    text-align: center;
    padding-top: 1px;
}

 .spe_ord.xian_o .tip_inco {
    background-color: #fff9f6;
}

.tip_inco {
    width: 240px;
    height: 48px;
    margin-top: 1px;
    float: left;
    border-top-right-radius: 4px;
    border-bottom-right-radius: 4px;
}


.tl {
    float: left;
    height: 48px;
    margin-left: 15px;
}

 .spe_ord.xian_o .tl em {
    color: #ff8650;
}

.spe_ord span em {
    font-style: normal;
    vertical-align: middle;
}

.tr {
    float: right;
    height: 48px;
    margin-right: 15px;
}
.spe_ord .tr .all {
    font-size: 12px;
    color: #93939e;
    float: left;
    line-height: 48px;
}

.spe_ord .tr .num {
    font-size: 14px;
    color: #ff5050;
    float: left;
    line-height: 48px;
}

.spe_ord .tr .num span {
    display: inline-block;
    line-height: 48px;
    margin-top: -2px;
}

</style>