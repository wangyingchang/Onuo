<template>
    <div class="car_list">
        <div>
            <el-row>
                <!--商品展示-->
                <el-col :span="22">
    
                    <div class="goods-type">
    
                        <el-tabs class="bookmark"  type="card" @tab-click="computedRentMoney" style="font-weight:50">
                            <el-tab-pane label="短租自驾" style="font-weight:5">
                                <table class="carList_tb" cellpadding="0" cellspacing="0" border="0"  >
                                    <tbody class="carList">

                                        <tr v-for="(car,index) in carListCount" :key="index" class="carList_tr">
                                            
                                            <router-link :to="{path:'/car/car_detail',query:{carId: car.carId,car_price:car.carRentShort}}">
                                            <td class="car_pic">

                                                <a href="#"><img :src="car.generalImage[0].imgPath" width="230px" height="130px"></a>
                                            </td>
                                            </router-link>
                                            <td class="car_info">
                                                <p class="car_name">{{ car.carName }} / <span style="color:gold;">{{ toString(car.status)}}</span></p>
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
                                                      <el-button class="btn" type="primary">租车</el-button>
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
                                                <router-link :to="{path:'/car/car_detail',query:{carId: car.carId,car_price:car.carRentShort }}">
                                            <td class="car_pic">
                                                <a href="#"><img :src="car.generalImage[0].imgPath" width="230px" height="130px"></a>
                                            </td>
                                                </router-link>
                                            <td class="car_info">
                                                <p class="car_name">{{ car.carName }} / <span style="color:gold;">{{ toString(car.status)}}</span></p>
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
                                                      <el-button class="btn" type="primary">租车</el-button>
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
                                                <router-link :to="{path:'/car/car_detail',query:{carId: car.carId,car_price:car.carRentShort}}">
                                            <td class="car_pic">
                                                <a href="#"><img :src="car.generalImage[0].imgPath" width="230px" height="130px"></a>
                                            </td>
                                                </router-link>
                                            <td class="car_info">
                                                <p class="car_name">{{ car.carName }} / <span style="color:gold;">{{ toString(car.status)}}</span></p>
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
                                                      <el-button class="btn" type="primary">租车</el-button>
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
                                            <router-link :to="{path:'/car/car_detail',query:{carId: car.carId,car_price:car.carRentLong}}">
                                            <td class="car_pic">
                                                <a href="#"><img :src="car.generalImage[0].imgPath" width="230px" height="130px"></a>
                                            </td>
                                                </router-link>
                                            <td class="car_info">
                                                <p class="car_name">{{ car.carName }} / <span style="color:gold;">{{ toString(car.status)}}</span></p>
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
                                                            <el-button class="btn" type="primary">租车</el-button>
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
                        <el-button @click="rentSort" type="primary" size="small" style="position:absolute;right:100px;top:10px;">租金排序</el-button>
                    </div>
    
                </el-col>
                    <div class="page" style="clear:both;">
                    <el-pagination
                        background
                        @current-change="changeIndex"
                        :current-page.sync="pageCode"
                        :page-size="pageSize"  
                        :total="totalCount"
                        layout="total, prev, pager, next, jumper"
                        style="padding-top:9px;"
                    ></el-pagination>
                    </div>
            </el-row>
        </div>
    </div>
</template>

<script>
import {getAllCars,getAllCarsWeek,
getAllCarsMonth,getAllCarsYear,
rentShortSort,rentLongSort,
weekSort,monthSort,
searchCars,searchCarsMutipl} from '@/api/carinfo'
import { throws } from 'assert';
export default {
    name: 'CarList',
    data() {
        return {
            carTypeList:[],// 短租车辆
            carListCount:[],// 周租和月租
            pageSize:5,// 每页显示数
            totalCount:'',// 总记录数
            pageCode:1,// 默认当前页
            tabIndex:'0',
            isSorted:false,
            sortDirection:'0',
            isSearch:false,
            isSearchOptions:false,
            leftSearchFlag:false
        }
    },
    methods:{
        // 多条件查询
        searchLeftCarsMutipl(page, size, carType, carBrand,
  carPriceBegin, carPriceEnd, carSeatBegin, carSeatEnd, companyId){
            searchCarsMutipl(page, size, carType, carBrand,
  carPriceBegin, carPriceEnd, carSeatBegin, carSeatEnd, companyId)
        .then(response=>{
            console.log(response.data);
            this.carListCount=response.data.list;
            this.pageCode=response.data.pageNum // 当前页数
            this.totalCount=response.data.total // 总记录数
        })
        },
        // 模糊查询
        searchAllCars(page,size,words){
            searchCars(page,size,words)
                .then(response=>{
                    this.carListCount=response.data.list;
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
                
                rentShortSort(1,this.pageSize,this.sortDirection)
                .then(response=>{
                this.carListCount=response.data.list;
            })
            }
            // 周租套餐排序
            if(this.tabIndex==='1'){
                weekSort(1,this.pageSize,this.sortDirection)
                .then(response=>{
                this.carListCount=response.data.list;
            })
            }
            // 月租套餐排序
            if(this.tabIndex==='2'){
                monthSort(1,this.pageSize,this.sortDirection)
                .then(response=>{
                this.carListCount=response.data.list;
            })
            }
            // 年租套餐排序
            if(this.tabIndex==='3'){
            rentLongSort(1,this.pageSize,this.sortDirection)
            .then(response=>{
            this.carListCount=response.data.list;
            })
            }
        },
    computedRentMoney(tab, event){
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
        getAllCars(1,this.pageSize)
        .then(response=>{
          this.carListCount=response.data.list;  
          this.pageCode=response.data.pageNum // 当前页数
        this.totalCount=response.data.total // 总记录数
            })

        }
        if(tab.index==='1'){
           // 周租
           getAllCarsWeek(1,this.pageSize,'0.9f')
      .then(response=>{
        this.carListCount=response.data.list;
        this.pageCode=response.data.pageNum // 当前页数
        this.totalCount=response.data.total // 总记录数
      })
        }
        if(tab.index==='2'){
            // 月租
            getAllCarsMonth(1,this.pageSize,'0.8f')
      .then(response=>{
        this.carListCount=response.data.list;
        this.pageCode=response.data.pageNum // 当前页数
        this.totalCount=response.data.total // 总记录数
        })
        }

        if(tab.index==='3'){
            // 年租
            getAllCars(1,this.pageSize)
           .then(response=>{
            this.carListCount=response.data.list;
            this.pageCode=response.data.pageNum // 当前页数
            this.totalCount=response.data.total // 总记录数
            })
        }

    },
    getAllCarsList(){
        // 查询所有车辆
        // this.leftSearchFlag=false;
        let responseData={};
        getAllCars(1,this.pageSize)
        .then(response=>{
          responseData=response.data;
            this.carListCount=responseData.list // 周租和月租数据
            this.pageCode=responseData.pageNum // 当前页数
            this.totalCount=responseData.total // 总记录数
            })
    },
    searchCarsByOption(searchwords){
        searchCars(1,this.pageSize,searchwords)
        .then(response=>{
            response.data;
        })
    },
    // 分页，后台分页
    changeIndex(val){
        this.carListCount=[];
        let responseData={};
        // 模糊搜索分页
        if(this.isSearch){
            this.searchAllCars(val,this.pageSize,this.carSearchWords);
            return;
        }
        if(this.leftSearchFlag){
            this.searchLeftCarsMutipl(val,this.pageSize,this.carLeftWords.cartype,this.carLeftWords.carbrand,
            this.carLeftWords.carminprice,this.carLeftWords.carmaxprice,this.carLeftWords.carminseat,this.carLeftWords.carmaxseat,'0');
         return;
        }
        // 短租分页
        if(this.tabIndex==='0'){
            // 短租分页不排序
            if(!this.isSorted){
            getAllCars(val,this.pageSize)
            .then(response=>{
            this.carListCount=response.data.list
            this.pageCode=response.data.pageNum // 当前页数
            this.totalCount=response.data.total // 总记录数
            })
            }else{
            // 短租分页排序
            rentShortSort(val,this.pageSize,this.sortDirection)
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
                getAllCarsWeek(val,this.pageSize,'0.9f')
                .then(response=>{
                    this.carListCount=response.data.list
                })
           }else{
               // 周租分页排序
               weekSort(val,this.pageSize,this.sortDirection)
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
                 getAllCarsMonth(val,this.pageSize,'0.8f')
                .then(response=>{
                this.carListCount=response.data.list
                })
            }else{
                // 月租分页排序
                monthSort(val,this.pageSize,this.sortDirection)
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
            getAllCarsYear(val,this.pageSize)
            .then(response=>{
            this.carListCount=response.data.list
            })
            }else{
                // 年租分页排序
            rentLongSort(val,this.pageSize,this.sortDirection)
            .then(response=>{
            this.carListCount=response.data.list;
            })
        }
        return;
           
        }
        
    }
  },
  props:['carSearchWords','leftWords']
  ,computed: {
      carLeftWords(){
          this.leftSearchFlag=true;
          this.isSearchOptions=false;
          return this.leftWords;
      }
  },
watch:{
    // 深度监听实现左侧多条件查询
    carLeftWords:{
      handler(newVal,oldVal){
         this.searchLeftCarsMutipl(1,this.pageSize,newVal.cartype,newVal.carbrand,
         newVal.carminprice,newVal.carmaxprice,newVal.carminseat,newVal.carmaxseat,'0');
      },
    deep:true
    }
  },
  mounted: function(){
    this.getAllCarsList();
    // 模糊搜索
    this.$on('closeDialogchild',()=>{
            this.searchAllCars(1,this.pageSize,this.carSearchWords);
            this.isSearch=true;
            this.leftSearchFlag=false;
        })
  },
  computed:{
      toString(e){
          return function(e){
            return e=='0'?'租赁中':'闲置中';
          }
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.car_list {
    background-color: white;
    float: right;
    width: 70%;
    margin-right: 3%;
}

.goods-type {
    clear: both;
}

.carList_tb {
    width: 100%;
}

.page{
    margin:auto ;
    padding-left: 200px;
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
