import request from '@/utils/request'

// /**
//  * 获取培训内容信息
//  * @returns {AxiosPromise}
//  */
export function info() {
  return request({
    url: 'train/content/info',
    method: 'get'
  })
}

// /**
//  * 更新培训内容
//  * @returns {AxiosPromise}
//  */
export function update(data) {
  return request({
    url: 'train/content/update/',
    method: 'post',
    data
  })
}

// /**
//  * 删除培训内容
//  * @param data
//  */
export function deleteD(data) {
  return request({
    url: 'train/content/delete',
    method: 'post',
    data
  })
}

// /**
//  * 添加培训内容
//  * @param data
//  */
export function add(data) {
  return request({
    url: 'train/content/add',
    method: 'post',
    data
  })
}
