import request from '@/utils/request'
import { get } from 'https';
// 根据Id查询车辆信息
export function getCarById(carId) {
  return request({
    url: '/car/info/' + carId,
    method: 'get',
  })
}
// 查询所有车辆
export function getAllCars(page , size) { 
  return request({
    url: '/car/info?page='+page+'&size='+size,
    method: 'get',
  })
 }
 // 查询短租车辆

 // 查询周租套餐车辆
export function getAllCarsWeek(page, size,persent) {
  return request({
    url: '/car/info/week?page=' + page + '&size=' + size+'&persent='+persent,
    method: 'get',
  })
}
 // 查询月租套餐车辆
export function getAllCarsMonth(page, size, persent) {
  return request({
    url: '/car/info/month?page=' + page + '&size=' + size + '&persent=' + persent,
    method: 'get',
  })
}
 // 查询年租套餐
export function getAllCarsYear(page, size) {
  return request({
    url: '/car/info/?page=' + page + '&size=' + size,
    method:'get',
  })
}

// 短租排序
export function rentShortSort(page, size,direction) {
  return request({
    url: '/car/info/shortRent/sort?page=' + page + '&size=' + size+'&flag='+direction,
    method: 'get',
  })
}
// 周租排序
export function weekSort(page, size, direction) {
  return request({
    url: '/car/info/week/sort?page=' + page + '&size=' + size + '&flag=' + direction+"&persent=0.9f",
    method: 'get',
  })
}

// 月租排序
export function monthSort(page, size, direction) {
  return request({
    url: '/car/info/month/sort?page=' + page + '&size=' + size + '&flag=' + direction + "&persent=0.8f",
    method: 'get',
  })
}

// 长租排序
export function rentLongSort(page, size, direction) {
  return request({
    url: '/car/info/longRent/sort?page=' + page + '&size=' + size + '&flag=' + direction,
    method: 'get',
  })
}

// 模糊查询
export function searchCars(page,size,searchWords){
  return request({
    url: '/car/info/searchCars?page=' + page + '&size=' + size + '&searchWords=' + searchWords,
    method:'get'
  })
}
// 多条件查询
export function searchCarsMutipl(page, size, carType, carBrand,
  carPriceBegin, carPriceEnd, carSeatBegin, carSeatEnd, companyId) {
    return request({
      url: '/car/info/searchCarsMutil?page=' + page + '&size=' + size +
      '&carType=' + carType + '&carBrand=' + carBrand + '&carPriceBegin=' + carPriceBegin+
      '&carPriceEnd=' + carPriceEnd + '&carSeatBegin=' + carSeatBegin + '&carSeatEnd=' +
      carSeatEnd + '&companyId=' + companyId,
      method:'get'
    })
  }
//查询车辆评价信息(分页)
export function getCarJudgeInfo(page, size, carId) {
  return request({
    url: '/general/judge/info/carId?page=' + page + '&size=' + size + '&carId=' + carId,
    method: 'get',
  })
}
// 查询车辆评分
export function getAvgScore(carId) {
  return request({
    url: 'car/info/averageJudge/' + carId,
    method: 'get',
  })
}