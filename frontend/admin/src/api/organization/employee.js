import BaseRequest from '@/api/Base'
var BaseURL = 'organization/employee/'

var br = new BaseRequest(BaseURL)

// /**
//  * 获取职工信息
//  * @returns {AxiosPromise}
//  */
export function info() {
  return br.info()
}

// /**
//  * 更新职工信息
//  * @returns {AxiosPromise}
//  */
export function update(data) {
  return br.update(data)
}

// /**
//  * 删除职工信息
//  * @param data
//  */
export function deleteD(data) {
  return br.deleteD(data)
}

// /**
//  * 添加职工
//  * @param data
//  */
export function add(data) {
  return br.add(data)
}
