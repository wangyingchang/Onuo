import axios from 'axios'
import {
  Message,
  MessageBox
} from 'element-ui'
import store from '../store'
import {
  getToken
} from '@/utils/token'
// 创建axios实例
// https://www.kancloud.cn/yunye/axios/234845
const service = axios.create({
  baseURL: "http://127.0.0.1:8888/",
  // baseURL: "http://192.168.2.135:8888/",
  //baseURL: "http://58.155.47.108:88 88/", //process.env.BASE_API"https://www.easy-mock.com/mock/5b2fbc8dd99ea869eb4bdb51/"// api的base_url
  timeout: 30000, // 请求超时时间
  // 所有请求都以Json形式传送
  // 会有预检请求，服务端需要正常通过OPTIONS请求
  // http://www.ruanyifeng.com/blog/2016/04/cors
  headers: {
    'Content-type': 'application/json;charset=UTF-8',
    'Accept': 'application/json'
  }
})

// request拦截器
service.interceptors.request.use(config => {
  if (store.getters.token) {
    // 让每个请求携带自定义token 请根据实际情况自行修改
    config.headers['Authorization'] = getToken()

  }
  return config
}, error => {
  // Do something with request error
  console.log(error) // for debug
  Promise.reject(error)
})

// response拦截器
service.interceptors.response.use(
  response => {
    return response.data

  },
  error => {
    // 401:需要认证
    if (error.response.code === 401) {
      MessageBox.confirm('need login', 'logout', {
        confirmButtonText: 'login',
        cancelButtonText: 'cancel',
        type: 'warning'
      }).then(() => {
        store.dispatch('FedLogout').then(() => {
          location.reload() // 为了重新实例化vue-router对象 避免bug
        })
      })
    } else {
      Message({
        message: error.response.data.message,
        type: 'error',
        duration: 5 * 1000
      })
    }
    return Promise.reject(error)
  }
)
export default service
