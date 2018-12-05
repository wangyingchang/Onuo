// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui'
// import './styles/element-variables.scss'
import App from './App'
import router from './router'
import store from './store'
// import '@/icons' // icon
import '@/permission' // 权限
import 'babel-polyfill' //浏览器支持
import {
  default as request
} from './utils/request'
import {
  hasPermission
} from './utils/hasPermission'
import value from './utils/infos'
import lang from 'element-ui/lib/locale/lang/en'
import locale from 'element-ui/lib/locale'
// require styles 引入样式
import moment from 'moment'
// 设置语言
locale.use(lang)
Vue.use(ElementUI, {
  size: 'medium'
})
// 全局的常量
Vue.prototype.request = request
Vue.prototype.hasPermission = hasPermission
Vue.prototype.value = value
Vue.prototype.HOST='Alipay'
// 生产环境时自动设置为 false 以阻止 vue 在启动时生成生产提示。
Vue.config.productionTip = false

Vue.filter('dateformat', function (dataStr, pattern = 'YYYY-MM-DD HH:mm:ss') {
  return moment(dataStr).format(pattern)

})

import 'element-ui/lib/theme-default/index.css'

Vue.config.productionTip = false;
Vue.use(ElementUI);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
