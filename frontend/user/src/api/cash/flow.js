import BaseRequest from '@/api/Base'

var BaseURL = 'cash/flow/'
var br = new BaseRequest(BaseURL)

// 资金流动管理
export function info() {
  return br.info()
}

export function deleteD(data) {
  return br.deleteD(data)
}

export function add(data) {
  return br.add(data)
}
