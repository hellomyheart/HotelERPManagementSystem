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
      <el-form-item label="培训内容标题">
        <el-input v-model="form.title" />
      </el-form-item>
      <el-form-item label="简单介绍">
        <el-input v-model="form.note" />
      </el-form-item>
      <el-form-item label="培训时长">
        <el-input v-model="form.sumTime" />
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
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { update } from "@/api/trainingContent";
import { info } from "@/api/position";

export default {
  name: 'EmployeeEdit',
  data() {
    return {
      formLoading: true,
      form: {
        title: "",
        note: "",
        sumTime: "",
        positionId: ""
      },
      positionInfo: '',
      selectPosition: ''
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
        this.positionInfo = response.data;
      });
      this.selectGender=this.form.gender;
      this.selectPosition=this.form.positionId;     
    },
    onSubmit() {
      this.formLoading = true
      this.form.positionId=this.selectPosition;
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
