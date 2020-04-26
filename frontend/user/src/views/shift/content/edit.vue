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
      <el-form-item label="选择班次分类">
        <el-select v-model="form.typeId" filterable clearable placeholder="请选择">
          <el-option
            v-for="item in typeInfo"
            :key="item.id"
            :label="item.typeName"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="班次标题">
        <el-input v-model="form.title" />
      </el-form-item>
      <el-form-item label="开始时间">
         <el-time-picker
          v-model="form.startTime"
          :picker-options="{
            selectableRange: '00:00:00 - 23:59:59'
          }"
          value-format="HH:mm:ss"
          placeholder="选择时间">
         </el-time-picker>
      </el-form-item>

      <el-form-item label="结束时间">
         <el-time-picker
          v-model="form.endTime"
          :picker-options="{
            selectableRange: '00:00:00 - 23:59:59'
          }"
          value-format="HH:mm:ss"
          placeholder="选择时间">
         </el-time-picker>
      </el-form-item>
      <el-form-item label="工时">
        <el-input v-model="form.times" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { update } from '@/api/shift/shift'
import { info } from '@/api/shift/shiftType'

export default {
  name: 'EmployeeEdit',
  data() {
    return {
      formLoading: true,
      form: {
        id: '',
        typeId: '',
        title: '',
        startTime: '',
        endTime: '',
        times: ''
      },
      typeInfo: ''
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
        this.typeInfo = response.data;
      })    
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
