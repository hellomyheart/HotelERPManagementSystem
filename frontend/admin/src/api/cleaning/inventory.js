import BaseRequest from '@/api/Base'

var BaseURL = 'cleaning/inventory/'
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
