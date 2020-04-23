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
      <el-form-item label="分类名">
        <el-input v-model="form.typeName" />
      </el-form-item>

      <el-form-item label="选择部门">
        <el-select v-model="selectDepartment" filterable clearable placeholder="请选择">
          <el-option
            v-for="item in departmentInfo"
            :key="item.id"
            :label="item.departmentName"
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
import { update } from '@/api/shift/shiftType'
import { info } from '@/api/organization/department'

export default {
  name: 'ShiftTypeEdit',
  data() {
    return {
      formLoading: true,
      form: {
        id: '',
        typeName: '',
        departmentId: ''
      },
      departmentInfo: '',
      selectDepartment: ''
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
        this.departmentInfo = response.data;
      });
      this.selectDepartment = this.form.departmentId
    },
    onSubmit() {
      this.formLoading = true
      this.form.departmentId = this.selectDepartment
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
