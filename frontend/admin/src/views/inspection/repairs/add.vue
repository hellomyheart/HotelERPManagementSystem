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
      <el-form-item label="选择客房">
        <el-select v-model="form.roomId" filterable clearable placeholder="请选择">
          <el-option v-for="item in roomInfo" :key="item.id" :label="item.id" :value="item.id" />
        </el-select>
      </el-form-item>
      
      <el-form-item label="备注">
        <el-input v-model="form.note" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { add } from '@/api/inspection/repairs'
import { info } from '@/api/room/content'

export default {
  data() {
    return {
      formLoading: true,
      form: {
        roomId: '',
        note: ''
      },
      roomInfo: ''
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.formLoading = false
      info().then(response => {
        this.roomInfo = response.data
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
