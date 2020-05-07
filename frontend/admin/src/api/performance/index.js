import BaseRequest from '@/api/Base'
var BaseURL = 'performance/'

var br = new BaseRequest(BaseURL)

// /**
//  * 获取信息
//  * @returns {AxiosPromise}
//  */
export function info() {
  return br.info()
}

// /**
//  * 删除信息
//  * @param data
//  */
export function deleteD(data) {
  return br.deleteD(data)
}

// /**
//  * 添加
//  * @param data
//  */
export function add(data) {
  return br.add(data)
}
