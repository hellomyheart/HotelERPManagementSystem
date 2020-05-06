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
      <el-form-item label="选择客房">
        <el-select v-model="form.roomId" filterable clearable placeholder="请选择" :disabled="true">
          <el-option v-for="item in roomInfo" :key="item.id" :label="item.id" :value="item.id" />
        </el-select>
      </el-form-item>

      <el-form-item label="备注">
        <el-input v-model="form.note" />
      </el-form-item>
      <el-form-item label="报修时间">
        <el-input v-model="form.repairsTime" :disabled="true" />
      </el-form-item>

      <el-form-item label="状态">
        <el-select v-model="form.status" filterable clearable placeholder="请选择">
          <el-option v-for="item in sInfo" :key="item.id" :label="item.name" :value="item.id" />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { update } from '@/api/inspection/repairs'
import { info } from '@/api/room/content'

export default {
  name: 'EmployeeEdit',
  data() {
    return {
      formLoading: true,
      form: {
        roomId: '',
        note: '',
      },
      roomInfo: '',
      sInfo: [
        {
          id: 0,
          name: '等待维修'
        },
        {
          id: 1,
          name: '维修完成'
        }
      ]
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.form = this.$route.params.data
      this.formLoading = false
      info().then(response => {
        this.roomInfo = response.data
      })
      console.log(this.$route.params.data)
    },
    onSubmit() {
      this.formLoading = true
      update(this.form).then(response => {
        this.formLoading = false
        this.$message({
          message: response.message,
          type: "success"
        });
      }).catch(() => {
        this.formLoading = false
      })
    }
  }
}
</script>
<style scoped>
</style>
