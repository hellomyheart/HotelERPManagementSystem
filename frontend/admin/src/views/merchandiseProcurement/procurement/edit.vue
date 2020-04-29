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
      <el-form-item label="选择采购商">
        <el-select v-model="form.buyerId" filterable clearable placeholder="请选择">
          <el-option v-for="item in buyerInfo" :key="item.id" :label="item.buyerName" :value="item.id" />
        </el-select>
      </el-form-item>
      <el-form-item label="选择商品">
        <el-select v-model="form.goodsId" filterable clearable placeholder="请选择">
          <el-option v-for="item in goodsInfo" :key="item.id" :label="item.goodsName" :value="item.id" />
        </el-select>
      </el-form-item>

      <el-form-item label="单价">
        <el-input v-model="form.price" />
      </el-form-item>
      <el-form-item label="采购数目">
        <el-input v-model="form.procurementSum" />
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="form.note" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { update } from '@/api/merchandiseProcurement/procurement'
import { info as gInfo } from '@/api/merchandiseProcurement/goods'
import { info as bInfo } from '@/api/merchandiseProcurement/buyer'

export default {
  data() {
    return {
      formLoading: true,
      form: {
        buyerId: '',
        goodsId: '',
        price: '',
        procurementSum: '',
        note: ''
      },
      buyerInfo: '',
      goodsInfo: ''
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.form = this.$route.params.data
      bInfo().then(response => {
        this.buyerInfo = response.data
      })
      gInfo().then(response => {
        this.goodsInfo = response.data
      })
      this.formLoading = false
    },
    onSubmit() {
      this.formLoading = true
      update(this.form)
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
