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
      <el-form-item label="选择职工">
        <el-select v-model="form.employeeId" filterable clearable placeholder="请选择">
          <el-option v-for="item in employeeInfo" :key="item.id" :label="item.employeeName" :value="item.id" />
        </el-select>
      </el-form-item>
      <el-form-item label="绩效打分">
        <el-input v-model="form.score" type="Number" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { add } from '@/api/performance/index'
import { info } from '@/api/organization/employee'
export default {
  data() {
    return {
      formLoading: true,
      form: {
        employeeId: '',
        score: ''
      },
      employeeInfo: ''
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.formLoading = false
      info().then(response => {
        this.employeeInfo = response.data
        console.log('5566')
      })
    },
    onSubmit() {
      this.formLoading = true
      add(this.form)
        .then(response => {
          this.formLoading = false
          this.$message({
            message: response.message,
            type: 'success'
          })
        })
        .catch(() => {
          this.formLoading = false
        })
    }
  }
}
</script>
<style scoped>
</style>
