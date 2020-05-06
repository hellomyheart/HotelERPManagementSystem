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
      <el-form-item label="身份证号">
        <el-input v-model="form.userId" />
      </el-form-item>
      <el-form-item label="客房ID">
        <el-input v-model="form.roomId" :disabled="true" />
      </el-form-item>
      <el-form-item label="押金">
        <el-input v-model="form.depositPrice" :disabled="true" />
      </el-form-item>
      <el-form-item label="价格">
        <el-input v-model="priceCount" :disabled="true" />
      </el-form-item>
      <el-form-item label="天数">
        <el-input v-model="form.days" type="Number" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { add } from '@/api/room/order'

export default {
  data() {
    return {
      formLoading: true,
      form: {
        userId: '',
        roomId: '',
        depositStatus: '',
        depositPrice: '',
        orderStatus: '',
        price: '',
        checkIn: '',
        days: ''
      },
      typeInfo: ''
    }
  },
  computed: {
    priceCount: function() {
      return this.form.days * this.$route.params.data.price
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.form = this.$route.params.data
      this.form.roomId = this.$route.params.data.id
      this.form.depositPrice = this.$route.params.data.deposit
      this.formLoading = false
    },
    onSubmit() {
      this.formLoading = true
      this.form.price = this.form.days * this.$route.params.data.price
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
