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
      <el-form-item label="身份证号">
        <el-input v-model="form.userId" :disabled="true" />
      </el-form-item>
      <el-form-item label="客房ID">
        <el-input v-model="form.roomId" :disabled="true" />
      </el-form-item>
      <el-form-item label="押金">
        <el-input v-model="form.depositPrice" :disabled="true" />
      </el-form-item>
      <el-form-item label="押金状态">
        <el-select v-model="form.depositStatus" filterable clearable placeholder="请选择">
          <el-option v-for="item in sInfo" :key="item.id" :label="item.name" :value="item.id" />
        </el-select>
      </el-form-item>
      <el-form-item label="价格">
        <el-input v-model="form.price" :disabled="true" />
      </el-form-item>
      <el-form-item label="入住时间">
        <el-input v-model="form.checkIn" :disabled="true" />
      </el-form-item>

      <el-form-item label="天数">
        <el-input v-model="form.days" :disabled="true" type="Number" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { update } from '@/api/room/order'

export default {
  data() {
    return {
      formLoading: true,
      form: {
        id: '',
        userId: '',
        roomId: '',
        depositStatus: '',
        depositPrice: '',
        orderStatus: '',
        price: '',
        checkIn: '',
        days: ''
      },
      sInfo: [
        {
          id: 1,
          name: '已付'
        },
        {
          id: 2,
          name: '已退'
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
