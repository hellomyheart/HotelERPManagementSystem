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
      <el-form-item label="ID">
        <el-input v-model="form.id" :disabled="true" />
      </el-form-item>
      <el-form-item label="采购商名">
        <el-input v-model="form.buyerName" />
      </el-form-item>
      <el-form-item label="公司名">
        <el-input v-model="form.company" />
      </el-form-item>
      <el-form-item label="公司地址">
        <el-input v-model="form.companyAdd" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { update } from '@/api/merchandiseProcurement/buyer'

export default {
  data() {
    return {
      formLoading: true,
      form: {
        id: '',
        buyerName: '',
        company: '',
        companyAdd: ''
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.form = this.$route.params.data
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
