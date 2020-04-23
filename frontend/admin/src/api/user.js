import request from '@/utils/request'
var BaserURL = '/user/'
export function login(data) {
  return request({
    url: BaserURL + 'login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: BaserURL + 'info',
    method: 'get'
  })
}

export function logout(token) {
  return request({
    url: BaserURL + 'logout',
    method: 'post',
    params: { access_token: token }
  })
}
