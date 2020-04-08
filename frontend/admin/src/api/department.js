import request from '@/utils/request'

// /**
//  * 获取部门信息
//  * @returns {AxiosPromise}
//  */
export function info() {
  return request({
    url: 'organization/department/info',
    method: 'get'
  })
}

// /**
//  * 更新部门信息
//  * @param username
//  * @returns {AxiosPromise}
//  */
export function update(data) {
  return request({
    url: 'organization/department/update/',
    method: 'post',
    data
  })
}

// /**
//  * 删除部门信息
//  * @param data
//  */
export function deleteD(data) {
  return request({
    url: 'organization/department/delete',
    method: 'post',
    data
  })
}

// /**
//  * 添加部门
//  * @param data
//  */
export function add(data) {
  return request({
    url: 'organization/department/add',
    method: 'post',
    data
  })
}
