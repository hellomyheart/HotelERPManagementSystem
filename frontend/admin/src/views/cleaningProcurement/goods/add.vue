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
      <el-form-item label="用品名">
        <el-input v-model="form.cleaningName" />
      </el-form-item>
      <el-form-item label="选择类型">
        <el-select v-model="form.typeId" filterable clearable placeholder="请选择">
          <el-option v-for="item in typeInfo" :key="item.id" :label="item.typeName" :value="item.id" />
        </el-select>
      </el-form-item>
      <el-form-item label="库存数量">
        <el-input v-model="form.cleaningNumber" />
      </el-form-item>
      <el-form-item label="说明">
        <el-input v-model="form.note" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { add } from '@/api/cleaningProcurement/goods'
import { info } from '@/api/cleaningProcurement/type'

export default {
  data() {
    return {
      formLoading: true,
      form: {
        cleaningName: '',
        cleaningNumber: '',
        typeId: '',
        note: ''
      },
      typeInfo: ''
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.formLoading = false
      info().then(response => {
        this.typeInfo = response.data
      })
    },
    onSubmit() {
      this.formLoading = true
      add(this.form)
        .then(response => {
          this.formLoading = false
          this.$message({
            message: response.message,
            tyspe: 'success'
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
