import request from '@/utils/request'

export function gettoken(userForm) {
  return request({
    url: '/sys/password',
    method: 'post',
    data: userForm
  })
}
