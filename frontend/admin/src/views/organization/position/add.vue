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
      <el-form-item label="职位名称">
        <el-input v-model="form.positionName" />
      </el-form-item>
      <el-form-item label="基础工资">
        <el-input v-model="form.basesalary" />
      </el-form-item>
      <el-form-item label="基础工时">
        <el-input v-model="form.baseTime" />
      </el-form-item>
      <el-form-item label="选择部门">
        <el-select v-model="selectValue" filterable clearable placeholder="请选择">
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
import { add } from "@/api/position";
import { info } from "@/api/department";

export default {
  name: "PositionAdd",
  data() {
    return {
      formLoading: true,
      form: {
        positionName: '',
        basesalary: '',
        baseTime: '',
        departmentId: ''
      },
      departmentInfo: '',
      selectValue: ''
    };
  },
  created() {
    this.fetchData();
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
      this.form.departmentId=this.selectValue;
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
