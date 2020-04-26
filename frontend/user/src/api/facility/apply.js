import BaseRequest from '@/api/Base'
var BaseURL = 'facility/apply/'

var br = new BaseRequest(BaseURL)

// /**
//  * 获取
//  * @returns {AxiosPromise}
//  */
export function info() {
  return br.info()
}

// /**
//  * 更新
//  * @returns {AxiosPromise}
//  */
export function update(data) {
  return br.update(data)
}

// /**
//  * 删除
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
