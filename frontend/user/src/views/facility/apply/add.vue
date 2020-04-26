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

      <el-form-item label="标题">
        <el-input v-model="form.title" />
      </el-form-item>
      <el-form-item label="单价">
        <el-input v-model="form.price" type="number" />
      </el-form-item>
      <el-form-item label="单位">
        <el-input v-model="form.unit" />
      </el-form-item>

      <el-form-item label="数量">
        <el-input v-model="form.quantity" type="number" />
      </el-form-item>

      <el-form-item label="备注">
        <el-input v-model="form.note" />
      </el-form-item>

      <el-form-item label="选择申请人">
        <el-select v-model="form.applyId" filterable clearable placeholder="请选择">
          <el-option v-for="item in employeeInfo" :key="item.id" :label="item.employeeName" :value="item.id"/>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { add } from '@/api/facility/apply'
import { info } from '@/api/organization/employee'

export default {
  name: 'FacilityApplyAdd',
  data() {
    return {
      formLoading: true,
      form: {
        title: '',
        price: '',
        unit: '',
        quantity: '',
        note: '',
        applyId: ''
      },
      employeeInfo: ''
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      this.formLoading = false;
      info().then(response => {
        this.employeeInfo = response.data;
      })
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
