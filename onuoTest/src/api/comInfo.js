import request from '@/utils/request'

// 查询所有公司
export function getAllCompany(page, size) {
  return request({
    url: '/company/info?page=' + page + '&size=' + size,
    method: 'get',
  })
}
//根据公司名和城市查询公司
export function getCompanyByNameAndCity(page, size, companyName, city) {
  return request({
    url: '/company/info/nameAndCity?page=' + page + '&size=' + size + '&companyName=' + companyName + '&city=' + city,
    method: 'get',
  })
}
//查询公司详情
export function getCompanyDetail(companyId) {
  return request({
    url: '/company/info/' + companyId,
    method: 'get',
  })
}
//查询公司评价信息(分页)
export function getCompanyJudgeInfo(page, size, companyId) {
  return request({
    url: '/general/judge/info/id?page=' + page + '&size=' + size + '&id=' + companyId,
    method: 'get',
  })
}
//查询周围公司
export function getCompanyByCity(city) {
  return request({
    url: '/company/info/city?city=' + city,
    method: 'get',
  })
}
//查询城市区域
export function getAreaByCity(city) {
  return request({
    url: '/sys/area/getAreaByCity?city=' + city,
    method: 'get',
  })
}
//根据公司名查询
export function getCompanyByName(page,size,companyName) {
  return request({
    url: '/company/info/name?page='+page+'&size='+size+'&companyName=' + companyName,
    method: 'get',
  })
}

//根据公司id查看公司所有车辆

export function getCompanyAllCarInfo(companyId) {
  return request({
    url: '/car/info/companyAllCar/' + companyId,
    method: 'get',
  })
}

//查看公司车辆短租信息(分页,排序)
export function getShortRentCarInfo(page, size, flag, companyId) {
  return request({
    url: '/car/info/shortCompanyCarRent/sort?page=' + page + '&size=' + size + '&flag=' + flag + '&companyId=' + companyId,
    method: 'get',
  })
}

//查看公司车辆周租信息(分页,排序)
export function getWeekRentCarInfo(page, size, persent, flag, companyId) {
  return request({
    url: '/car/info/companyCarWeek?page=' + page + '&size=' + size + '&persent=' + persent + '&flag=' + flag + '&companyId=' + companyId,
    method: 'get',
  })
}

//查看公司车辆月租信息(分页,排序)
export function getMonthRentCarInfo(page, size, persent, flag, companyId) {
  return request({
    url: '/car/info/companyCarMonth?page=' + page + '&size=' + size + '&persent=' + persent + '&flag=' + flag + '&companyId=' + companyId,
    method: 'get',
  })
}

//查看公司车辆长租(年租)信息(分页,排序)
export function getLongRentCarInfo(page, size, flag, companyId) {
  return request({
    url: '/car/info/longCompanyCarRent/sort?page=' + page + '&size=' + size + '&flag=' + flag + '&companyId=' + companyId,
    method: 'get',
  })
}

// 多条件查询
export function searchCarsMutipl(page, size, carType, carBrand,
  carPriceBegin, carPriceEnd, carSeatBegin, carSeatEnd, companyId) {
  return request({
    url: '/car/info/searchCarsMutil?page=' + page + '&size=' + size +
      '&carType=' + carType + '&carBrand=' + carBrand + '&carPriceBegin=' + carPriceBegin +
      '&carPriceEnd=' + carPriceEnd + '&carSeatBegin=' + carSeatBegin + '&carSeatEnd=' +
      carSeatEnd + '&companyId=' + companyId,
    method: 'get'
  })
}


//查看公司所有车辆(分页)
export function getCompanyAllCarInfoByPage(page, size, companyId) {
  return request({
    url: '/car/info/companyAllCar?page=' + page + '&size=' + size + '&companyId=' + companyId,
    method: 'get',
  })
}

//查看公司所有折扣车辆(分页)
export function companyAllDiscountCarByPage(page, size, persent, companyId) {
  return request({
    url: '/car/info/companyAllDiacountCar?page=' + page + '&size=' + size + '&persent=' + persent + '&companyId=' + companyId,
    method: 'get',
  })
}

//模糊查看公司车辆(分页)
export function searchCompanyCars(page, size, companyId, searchWords) {
  return request({
    url: '/car/info/searchAllCompanyCars?page=' + page + '&size=' + size + '&companyId=' + companyId + '&searchWords=' + searchWords,
    method: 'get',
  })
}

