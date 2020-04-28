import request from '@/utils/request'
var BaserURL = '/reg/'
export function send(data) {
  return request({
    url: BaserURL + 'send',
    method: 'post',
    data
  })
}

export function getuser(data) {
  return request({
    url: BaserURL + 'user',
    method: 'post',
    data
  })
}