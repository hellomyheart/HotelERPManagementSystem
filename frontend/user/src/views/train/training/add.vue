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
      <el-form-item label="选择职工">
        <el-select v-model="selectEmployee" filterable clearable placeholder="请选择">
          <el-option
            v-for="item in employeeInfo"
            :key="item.id"
            :label="item.employeeName"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="选择培训内容">
        <el-select v-model="selectContent" filterable clearable placeholder="请选择">
          <el-option
            v-for="item in contentInfo"
            :key="item.id"
            :label="item.title"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="培训开始时间">
        <el-date-picker
          v-model="form.createTime"
          align="right"
          type="date"
          placeholder="选择日期"
          :picker-options="pickerOptions"
          value-format="yyyy-MM-dd HH:mm:ss"
        ></el-date-picker>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { add } from "@/api/train/training";
import { info as eInfo } from '@/api/organization/employee'
import { info as cInfo } from '@/api/train/trainingContent'

export default {
  name: "trainingAdd",
  data() {
    return {
      formLoading: true,
      form: {
        employeeId: "",
        trainingContentId: "",
        createTime: ""
      },
      contentInfo: "",
      selectContent: "",
      employeeInfo: "",
      selectEmployee: ""
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      this.formLoading = false;
      eInfo().then(response => {
        this.employeeInfo = response.data;
      })
      cInfo().then(response => {
        this.contentInfo = response.data;
      })
    },
    onSubmit() {
      this.formLoading = true;
      this.form.employeeId = this.selectEmployee;
      this.form.trainingContentId = this.selectContent;
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