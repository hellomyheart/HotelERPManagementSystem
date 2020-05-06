<template>
  <div class="app-container">
    <el-form
      ref="form"
      v-loading="formLoading"
      :data="form"
      element-loading-text="加载中..."
      :model="form"
      label-width="120px"
    >
      <el-input type="hidden" v-model="form.id"/>
      <el-form-item label="ID">
        <el-input v-model="form.id" :disabled="true" />
      </el-form-item>
      <el-form-item label="分类名">
        <el-input v-model="form.typeName" />
      </el-form-item>
      <el-form-item label="图片">
        <div class="components-container">
          <pan-thumb :image="image" />
          <el-button type="primary" icon="upload" style="position: absolute;bottom: 15px;margin-left: 40px;" @click="toggleShow">
            上传图片
          </el-button>
          <image-cropper
            v-model="show"
            field="multipartFile"
            :width="300"
            :height="300"
            :url="url"
            :params="params"
            :headers="headers"
            img-format="png"
            @crop-success="cropSuccess"
            @crop-upload-success="cropUploadSuccess"
            @crop-upload-fail="cropUploadFail"
          />
        </div>
      </el-form-item>
      <el-form-item label="描述">
        <el-input v-model="form.note" />
      </el-form-item>
      <el-form-item label="价格">
        <el-input v-model="form.price" />
      </el-form-item>
      <el-form-item label="押金">
        <el-input v-model="form.deposit" />
      </el-form-item>
      <el-form-item label="床位数">
        <el-input v-model="form.bedCount" />
      </el-form-item>
      <el-form-item label="房间数">
        <el-input v-model="form.roomCount" :disabled="true" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { update } from '@/api/room/type'
import ImageCropper from 'vue-image-crop-upload'
import PanThumb from '@/components/PanThumb'
import { getToken } from '@/utils/auth'

export default {
  components: { ImageCropper, PanThumb },
  data() {
    return {
      url: process.env.VUE_APP_BASE_API + '/upload',
      show: false,
      params: {
        access_token: getToken()
      },
      headers: {
        smail: '*_~'
      },
      image: '',

      formLoading: true,
      form: {
        id: '',
        typeName: '',
        picture: '',
        note: '',
        price: '',
        deposit: '',
        bedCount: '',
        roomCount: ''
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    toggleShow() {
      this.show = !this.show
    },
    cropSuccess(image, field) {
      this.image = image
    },

    /**
     * 上传成功
     * @param jsonData 服务器返回数据，已进行 JSON 转码
     * @param field
     */
    cropUploadSuccess(jsonData, field) {
      // 获取图片地址
      // eslint-disable-next-line no-undef
      this.form.picture = jsonData.data.path
    },
    /**
     * 上传失败
     * @param status 服务器返回的失败状态码
     * @param field
     */
    cropUploadFail(status, field) {
      console.log('-------- upload fail --------')
      console.log(status)
      console.log('field: ' + field)
    },
    fetchData() {
      this.form = this.$route.params.data
      this.image = this.$route.params.data.picture
      this.formLoading = false
    },
    onSubmit() {
      this.formLoading = true
      update(this.form).then(response => {
        this.formLoading = false
        this.$message({
          message: response.message,
          type: 'success'
        })
      }).catch(() => {
        this.formLoading = false
      })
    }
  }
}
</script>
<style scoped>
</style>
