import request from '@/utils/request'
import {
  get
} from 'https';
// 订单模块接口
// 添加用户身份证信息
export function addCardInfo(generalCardInfo) {
  return request({
    url: '/general/card/info/addCardInfo',
    method: 'post',
    data: generalCardInfo,
  })
}

// 添加用户驾驶证信息
export function addDrivenfo(carDiverInfo) {
  return request({
    url: '/car/diver/info/addDriverInfo',
    method: 'post',
    data: carDiverInfo,
  })
}

// 生成订单
export function addOrdernfo(orderInfo) {
  return request({
    url: '/order/info/add',
    method: 'post',
    data: orderInfo
  })
}


// order_two
// 查询目前订单信息
export function getOrderInfo(orderId) {
  return request({
    url: '/order/info/'+orderId,
    method:'get'
  })

  }

// 查询车辆订单信息
export function getCarInfo(carId) {
  return request({
    url: '/car/info/'+carId,
    method: 'get'
  })
  }

// 查询租车人身份证信息
export function getCustomerInfo(cardId) {
    return request({
      url: '/general/card/info/findById/'+cardId,
      method:'get'
    })
  }

// 查询租车人驾驶证信息
export function getDriverInfo(driverId){
  return request({
    url: '/car/diver/info/findByDriverId?diverId='+driverId,
    method:'get'
  })
}
// 更新订单信息
export function updateOrder(orderInfo) {
  return request({
    url: '/order/info',
    method:'put',
    data:orderInfo
  })
  }
// 身份证校验
export function identifyCard(cardInfo){
  return request({
    url: '/general/card/info/validate?cardId=' + cardInfo.cardId + "&name=" + cardInfo.cardName,
    method:'get'
  })
}
// 驾驶证校验
export function identifyDriver(driverInfo) {
  return request({
    url: '/general/card/info/validate?cardId=' + driverInfo.driverId + "&name=" + driverInfo.name,
    method: 'get'
  })
}
// 支付宝支付订单Id请求
export function getAliPayId(){
  return request({
    url: '/order/info/getAliPayId',
    method:'get'
  })
}
//确认订单是否支付成功
export function myOrderLast(outTradeNo, orderId) {
  return request({
    url: '/order/info/validateOrderResultInfo?outTradeNo='+outTradeNo +'&orderId='+orderId,
    method: 'get',
  })
}
//我的订单
export function myOrder(page, size, userId, status, startTime, endTime) {
  return request({
    url: '/order/info/myorder?page=' + page + '&size=' + size + '&userId=' + userId + '&status=' + status + '&startTime=' + startTime + '&endTime=' + endTime,
    method: 'get',
  })
}
//查询订单评价
export function queryOrderJudgeById(orderId) {
  return request({
    url: '/general/judge/info/orderId?orderId=' + orderId,
    method: 'get'
  })
}

//添加订单评价
export function addOrderJudge(generalJudgeInfo) {
  return request({
    url: '/general/judge/info/addJudgeInfo',
    method: 'post',
    data: generalJudgeInfo
  })
}

//查询车辆租定中订单时间
export function getOrderTime(carId,evaluateInfo) {
  return request({
    url: '/order/info/queryOrderTime?carId='+carId+'&evaluateInfo='+evaluateInfo,
    method: 'get',
  })
}