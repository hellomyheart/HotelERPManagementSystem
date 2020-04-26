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
import { add } from '@/api/shift/shiftType'
import { info } from '@/api/organization/department'

export default {
  name: "ShiftTypeAdd",
  data() {
    return {
      formLoading: true,
      form: {
        typeName: '',
        departmentId: ''
      },
      departmentInfo: '',
      selectDepartment: ''
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.formLoading = false;
      info().then(response => {
        this.departmentInfo = response.data;
      });
    },
    onSubmit() {
      this.formLoading = true;
      this.form.departmentId = this.selectDepartment
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
