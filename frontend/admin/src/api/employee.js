import request from '@/utils/request'

// /**
//  * 获取职工信息
//  * @returns {AxiosPromise}
//  */
export function info() {
  return request({
    url: 'organization/employee/info',
    method: 'get'
  })
}

// /**
//  * 更新职工信息
//  * @returns {AxiosPromise}
//  */
export function update(data) {
  return request({
    url: 'organization/employee/update/',
    method: 'post',
    data
  })
}

// /**
//  * 删除职工信息
//  * @param data
//  */
export function deleteD(data) {
  return request({
    url: 'organization/employee/delete',
    method: 'post',
    data
  })
}

// /**
//  * 添加职工
//  * @param data
//  */
export function add(data) {
  return request({
    url: 'organization/employee/add',
    method: 'post',
    data
  })
}
