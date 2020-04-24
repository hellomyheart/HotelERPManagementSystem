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

      <el-form-item label="流动类型">
        <el-select v-model="form.flowType" filterable clearable placeholder="请选择">
          <el-option v-for="item in statusInfo" :key="item.id" :label="item.name" :value="item.id"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="金额">
        <el-input type="number" v-model="form.money"/>
      </el-form-item>

      <el-form-item label="备注">
        <el-input  v-model="form.note"/>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { add } from '@/api/cash/flow'

export default {
  name: "CashFlowtAdd",
  data() {
    return {
      formLoading: true,
      form: {
        flowType: '',
        money: '',
        note: ''
      },
      statusInfo: [
        {
          id: 0,
          name: '出账'
        },
        {
          id: 1,
          name: '入账'
        }
      ]
    }
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      this.formLoading = false;
    },
    onSubmit() {
      this.formLoading = true;
      add(this.form)
        .then(response => {
          this.formLoading = false;
          this.$message({
            message: response.message,
            type: "success"
          });
        })
        .catch(() => {
          this.formLoading = false;
        });
    }
  }
};
</script>
<style scoped>
</style>
