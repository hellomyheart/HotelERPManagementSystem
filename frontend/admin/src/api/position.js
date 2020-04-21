import request from '@/utils/request'

// /**
//  * 获取职位信息
//  * @returns {AxiosPromise}
//  */
export function info() {
  return request({
    url: 'organization/position/info',
    method: 'get'
  })
}

// /**
//  * 更新职位信息
//  * @returns {AxiosPromise}
//  */
export function update(data) {
  return request({
    url: 'organization/position/update/',
    method: 'post',
    data
  })
}

// /**
//  * 删除职位信息
//  * @param data
//  */
export function deleteD(data) {
  return request({
    url: 'organization/position/delete',
    method: 'post',
    data
  })
}

// /**
//  * 添加职位
//  * @param data
//  */
export function add(data) {
  return request({
    url: 'organization/position/add',
    method: 'post',
    data
  })
}
