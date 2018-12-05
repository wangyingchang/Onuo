import Vue from 'vue'
import Router from 'vue-router'
const _import = require('./_import_' + process.env.NODE_ENV)
Vue.use(Router)

import CarFirst from '@/components/page/car_first/carFirst' // 首页组件
import Test from '@/components/page/car_first/test' // 测试页面
import CarSearch from '@/components/page/car_type_search/carSearch' // 车型搜索
import CompanySearch from '@/components/page/company_search/companySearch'
import CompanyMap from '@/components/page/company_map/companyMap'
import CarPreferential from '@/components/page/car_preferential/carPreferential'
import CarDetail from '@/components/page/car_info/carDetail'
import CompanyCarList from '@/components/page/car_info/cmopanyCar'
import CompanyRentCar from '@/components/page/car_info/companyRentCar'
import CompanyDetail from '@/components/page/company_info/companyDetail'
import Login from '@/components/page/login'
import Regist from '@/components/page/regist'
import OrderFirst from '@/components/page/order/orderFirst'
import OrderTwo from '@/components/page/order/orderTwo'
import OrderThree from '@/components/page/order/orderThree'
import OrderInfo from '@/components/page/order/orderInfo'
import MyOrder from '@/components/page/order/myOrder'
import AboutUs from '@/components/page/aboutus/aboutus'
import OrderLast from '@/components/page/order/orderLast'


/**
 * icon : the icon show in the sidebar
 * hidden : if `hidden:true` will not show in the sidebar
 * redirect : if `redirect:noRedirect` will not redirect in the levelBar
 * noDropDown : if `noDropDown:true` will not has submenu in the sidebar
 * meta : `{ permission: ['a:xx'] }`  will control the page permission
 **/
export const constantRouterMap = [{
    path: '/login',
    component: _import('page/login'),
    // hidden: true
  },
  {
    path: '/',
    component: _import('page/car_first/carFirst'),
    // hidden: true
  }
]

export default new Router({
  scrollBehavior: () => ({
    y: 0
  }),
  routes:  [
    {path: '/',name: 'car_first',component: CarFirst},
    {
      path: '/car_search',
      name: 'car_search',
      component: CarSearch,
    },
    {
      path: '/company_search',
      name: 'company_search',
      component: CompanySearch,
    }, 
    {
      path: '/company_map',
      name: 'company_map',
      component: CompanyMap
    },
    {
      path: '/car_preferential',
      name: 'car_preferential',
      component: CarPreferential
    },
    {
      path: '/company/company_detail',
      name: 'company_detail',
      component: CompanyDetail
    },
    {
      path: '/car/car_detail',
      name: 'car_detail',
      component: CarDetail
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    { 
      path: '/car/company_carList',
      name: 'company_carList',
      component: CompanyCarList
    },
    {
      path:'/test',
      name:'test',
      component:Test
    },
    {
      path:'/car/company_rent_car',
      name:'company_rent_car',
      component:CompanyRentCar
    },
    {
      path: '/order/order_first',
      name: 'company_rent_car',
      component: OrderFirst
    },
    {
      path: '/order/order_two',
      name: 'company_rent_car',
      component: OrderTwo
    },
    {
      path: '/order/order_three',
      name: 'company_rent_car',
      component: OrderThree
    },
    {
      path: '/order/orderInfo',
      name: 'order_info',
      component:OrderInfo
    },
    {
      path: '/order/my_order',
      name: 'MyOrder',
      component: MyOrder
    },
    {
      path: '/regist',
      name: 'regist',
      component: Regist
    },
    {
      path:'/aboutus',
      name:'aboutus',
      component:AboutUs
    },
    {
      path: '/order/orderLast',
      name: 'order_last',
      component: OrderLast
    },

  ]

})
export const asyncRouterMap = [
  {
    path: '/order/order_first',
    component: OrderFirst,
    redirect: '/order/order_first',
    meta: {
      permission: ['ROLE_USER']
    },
    icon: 'statistical',
    name: '订单录入不走一',
    noDropDown: false,
  }
]