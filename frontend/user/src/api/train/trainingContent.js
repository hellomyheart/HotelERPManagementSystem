import BaseRequest from '@/api/Base'

var BaseURL = 'train/content/'
var br = new BaseRequest(BaseURL)

// 培训内容管理
export function info() {
  return br.info()
}

export function update(data) {
  return br.update(data)
}

export function deleteD(data) {
  return br.deleteD(data)
}

export function add(data) {
  return br.add(data)
}
