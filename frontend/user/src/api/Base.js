import request from '@/utils/request'

export default class BaseRequest {
  constructor(BaseURL) {
    this.BaseURL = BaseURL
    // 获取内容
    this.info = function() {
      return request({
        url: BaseURL + 'info',
        method: 'get'
      })
    }
    // 更新内容
    this.update = function(data) {
      return request({
        url: BaseURL + 'update',
        method: 'post',
        data
      })
    }
    // 删除内容
    this.deleteD = function(data) {
      return request({
        url: BaseURL + 'delete',
        method: 'post',
        data
      })
    }
    this.add = function(data) {
      return request({
        url: BaseURL + 'add',
        method: 'post',
        data
      })
    }
  }
}