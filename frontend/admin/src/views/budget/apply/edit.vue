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
        <el-input v-model="form.id" :disabled="true"/>
      </el-form-item>
      <el-form-item label="标题">
        <el-input v-model="form.title" />
      </el-form-item>
      <el-form-item label="资金">
        <el-input type="number" v-model="form.price" />
      </el-form-item>
      <el-form-item label="说明">
        <el-input v-model="form.note" />
      </el-form-item>
      <el-form-item label="申请人">
        <el-select v-model="form.applyId" filterable clearable placeholder="请选择">
          <el-option v-for="item in employeeInfo" :key="item.id" :label="item.employeeName" :value="item.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="申请状态">
        <el-select v-model="form.status" filterable clearable placeholder="请选择">
          <el-option
            v-for="item in statusInfo"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { update } from '@/api/budget/apply'
import { info } from '@/api/organization/employee'

export default {
  name: 'EmployeeEdit',
  data() {
    return {
      formLoading: true,
      form: {
        title: '',
        price: '',
        note: '',
        applyId: '',
        status: ''
      },
      employeeInfo: '',
      statusInfo: [
        {
          id: 0,
          name: '申请'
        },
        {
          id: 1,
          name: '通过'
        }
      ],
      selectGender: ''
    };
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.form = this.$route.params.data
      this.formLoading = false
      info().then(response => {
        this.employeeInfo = response.data;
      });   
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
