import request from '@/utils/request'
// 查询热门车型
export function getHotCar() {
  return request({
    url: '/car/info/hotCar',
    method: 'get',
  })
}
