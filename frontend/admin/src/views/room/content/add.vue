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
      <el-form-item label="房间号">
        <el-input v-model="form.id" />
      </el-form-item>
      <el-form-item label="位置">
        <el-input v-model="form.location" />
      </el-form-item>
      <el-form-item label="选择类型">
        <el-select v-model="form.typeId" filterable clearable placeholder="请选择">
          <el-option v-for="item in typeInfo" :key="item.id" :label="item.typeName" :value="item.id" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { add } from '@/api/room/content'
import { info } from '@/api/room/type'

export default {
  data() {
    return {

      formLoading: true,
      form: {
        id: '',
        location: '',
        typeId: ''
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
