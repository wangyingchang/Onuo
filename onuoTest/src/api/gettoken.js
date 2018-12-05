import request from '@/utils/request'
export function gettoken(userForm) {
  return request({
    url: '/sys/user/token',
    method: 'post',
    data: userForm
  })
}
