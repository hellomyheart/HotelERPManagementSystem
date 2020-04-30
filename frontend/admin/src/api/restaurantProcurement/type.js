import BaseRequest from '@/api/Base'

var BaseURL = 'restaurantProcurement/type/'
var br = new BaseRequest(BaseURL)

// /**
//  * 获取信息
//  * @returns {AxiosPromise}
//  */
export function info() {
  return br.info()
}

// /**
//  * 更新信息
//  * @param username
//  * @returns {AxiosPromise}
//  */
export function update(data) {
  return br.update(data)
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
