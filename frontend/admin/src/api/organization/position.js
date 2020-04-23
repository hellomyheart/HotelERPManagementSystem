import BaseRequest from '@/api/Base'
var BaseURL = 'organization/position/'

var br = new BaseRequest(BaseURL)


// /**
//  * 获取职位信息
//  * @returns {AxiosPromise}
//  */
export function info() {
  return br.info()
}

// /**
//  * 更新职位信息
//  * @returns {AxiosPromise}
//  */
export function update(data) {
  return br.update(data)
}

// /**
//  * 删除职位信息
//  * @param data
//  */
export function deleteD(data) {
  return br.deleteD(data)
}

// /**
//  * 添加职位
//  * @param data
//  */
export function add(data) {
  return br.add(data)
}
