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
      <el-form-item label="职工姓名">
        <el-input v-model="form.employeeName" />
      </el-form-item>
      <el-form-item label="身份证号">
        <el-input v-model="form.identify" />
      </el-form-item>
      <el-form-item label="手机号">
        <el-input v-model="form.phone" />
      </el-form-item>
      <el-form-item label="选择性别">
        <el-select v-model="selectGender" filterable clearable placeholder="请选择">
          <el-option v-for="item in GenderInfo" :key="item.id" :label="item.name" :value="item.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="选择职位">
        <el-select v-model="selectPosition" filterable clearable placeholder="请选择">
          <el-option
            v-for="item in positionInfo"
            :key="item.id"
            :label="item.positionName"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="出生日期">
        <el-date-picker
          v-model="form.birthday"
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
import { add } from "@/api/employee";
import { info } from "@/api/position";

export default {
  name: "EmployeeAdd",
  data() {
    return {
      formLoading: true,
      form: {
        positionId: '',
        employeeName: '',
        identify: '',
        phone: '',
        gender: '',
        birthday: '',
      },
      positionInfo: '',
      selectPosition: '',
      GenderInfo: [
        {
          id: 0,
          name: '未知'
        },
        {
          id: 1,
          name: '男'
        },
        {
          id: 2,
          name: '女'
        }
      ],
      selectGender: ''
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      this.formLoading = false;
      info().then(response => {
        this.positionInfo = response.data;
      });
    },
    onSubmit() {
      this.formLoading = true;
      this.form.positionId=this.selectPosition;
      this.form.gender=this.selectGender;
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
