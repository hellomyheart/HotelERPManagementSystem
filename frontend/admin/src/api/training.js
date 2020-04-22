import request from '@/utils/request'

// /**
//  * 获取培训信息
//  * @returns {AxiosPromise}
//  */
export function info() {
  return request({
    url: 'train/training/info',
    method: 'get'
  })
}

// /**
//  * 删除培训信息
//  * @param data
//  */
export function deleteD(data) {
  return request({
    url: 'train/training/delete',
    method: 'post',
    data
  })
}

// /**
//  * 添加培训信息
//  * @param data
//  */
export function add(data) {
  return request({
    url: 'train/training/add',
    method: 'post',
    data
  })
}
