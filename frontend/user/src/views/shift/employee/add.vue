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

      <el-form-item label="选择排班班次">
        <el-select v-model="form.shiftId" filterable clearable placeholder="请选择">
          <el-option
            v-for="item in shiftInfo"
            :key="item.id"
            :label="item.title"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="选择工作日期">
        <el-date-picker
          v-model="form.workDate"
          align="right"
          type="date"
          placeholder="选择日期"
          :picker-options="pickerOptions"
          value-format="yyyy-MM-dd"
        ></el-date-picker>
      </el-form-item>

      <el-form-item label="选择职工">
        <el-select v-model="form.employeeId" filterable clearable placeholder="请选择">
          <el-option
            v-for="item in employeeInfo"
            :key="item.id"
            :label="item.employeeName"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="考勤状态">
        <el-select v-model="form.attendanceStatus" filterable clearable placeholder="请选择">
          <el-option v-for="item in statusInfo" :key="item.id" :label="item.name" :value="item.id"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { add } from '@/api/shift/shiftEmployee'
import { info as eInfo } from '@/api/organization/employee'
import { info as sInfo } from '@/api/shift/shift'

export default {
  name: "TrainingContentAdd",
  data() {
    return {
      formLoading: true,
      form: {
        shiftId: '',
        workDate: '',
        employeeId: '',
        attendanceStatus: ''
      },
      statusInfo: [
        {
          id: 0,
          name: '正常'
        },
        {
          id: 1,
          name: '缺勤'
        },
        {
          id: 2,
          name: '迟到'
        }
      ],
      shiftInfo: '',
      employeeInfo: ''
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
      });
      sInfo().then(response => {
        this.shiftInfo = response.data;
      });
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
