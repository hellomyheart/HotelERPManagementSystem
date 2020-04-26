import request from '@/utils/request'
var BaseURL = '/profile/'
// /**
//  * 获取个人信息
//  * @param username
//  * @returns {AxiosPromise}
//  */
export function info(username) {
  return request({
    url: BaseURL + 'info/' + username,
    method: 'get'
  })
}

// /**
//  * 更新个人信息
//  * @param username
//  * @returns {AxiosPromise}
//  */
export function update(data) {
  return request({
    url: BaseURL + 'update',
    method: 'post',
    data
  })
}

// /**
//  * 更新密码
//  * @param data
//  */
export function modifyPassword(data) {
  return request({
    url: BaseURL + 'modify/password',
    method: 'post',
    data
  })
}

// /**
//  * 更新头像
//  * @param data
//  */
export function modifyIcon(data) {
  return request({
    url: BaseURL + 'modify/icon',
    method: 'post',
    data
  })
}
