import request from '@/utils/request'

export function list(params) {
  return request({
    url: 'vigilante/security/risk/police'+"?number="+params,
    method: 'get',
    params
  })
}

export function validatePassword(userForm) {
  return request({
    url: '/sys/password',
    method: 'post',
    data: userForm
  })
}

export function update(userForm) {
  return request({
    url: 'vigilante/security/risk/police'+"?id="+userForm.id+"&policeFeedback="+userForm.policeFeedback+"&police="+userForm.policeID,
    method: 'post',
    data: userForm
  })
}
// export function update(userForm) {
//   return request({
//     url: 'general/clue/report/detailByclient',
//     method: 'put',
//     data: userForm
//   })
// }
export function remove(userId) {
  return request({
    url: '/sys/' + userId,
    method: 'delete'
  })
}

export function register(userForm) {
  return request({
    url: '/sys',
    method: 'post',
    data: userForm
  })
}

export function login(userForm) {
  return request({
    url: '/sys/login',
    method: 'post',
    data: userForm
  })
}

export function info() {
  return request({
    url: '/sys/user/info',
    method: 'get'
  })
}

export function logout() {
  return request({
    url: '/sys/logout',
    method: 'get'
  })
}
