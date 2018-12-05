import request from '@/utils/request'
import {
  get
} from 'https';
// 查询优惠活动
export function allActivityCar() {
  return request({
    url: '/car/discount/activity/allActivityCar',
    method: 'get',
  })
}
// 根据优惠活动开始和结束时间查询优惠活动
export function allActivityCarWithTime(beginTime,endTime) {
  return request({
    url: '/car/discount/activity/allActivityCar/withTime?beginTime='+beginTime+"&endTime="+endTime,
    method: 'get',
  })
}