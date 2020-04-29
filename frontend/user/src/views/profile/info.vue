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
      <el-input type="hidden" v-model="form.id"/>
      <el-form-item label="头像">
        <img :src="form.icon" width="60" height="60">
      </el-form-item>
      <el-form-item label="账号">
        <el-input v-model="form.username" :disabled="true"/>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="form.email"/>
      </el-form-item>
      <el-form-item label="手机号">
        <el-input :disabled="true" v-model="form.phone"/>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="form.nickname"/>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-input v-model="form.creatTime" :disabled="true"/>
      </el-form-item>
      <el-form-item label="更新时间">
        <el-input v-model="form.updateTime" :disabled="true"/>
      </el-form-item>
      <el-form-item label="性别">
        <el-radio-group v-model="form.gender">
          <el-radio :label="0">保密</el-radio>
          <el-radio :label="1">男</el-radio>
          <el-radio :label="2">女</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
    import {info, update} from '@/api/profile'

    export default {
        name: 'ProfileInfo',
        data() {
            return {
                formLoading: true,
                form: {
                    id: '',
                    employeeId: '',
                    username: '',
                    nickname: '',
                    email: '',
                    phone: '',
                    createTime: '',
                    updateTime: '',
                    icon: '',
                    gender: ''
                }
            }
        },
        created() {
            this.fetchData()
        },
        methods: {
            fetchData() {
                info().then(response => {
                    this.form = response.data
                    this.formLoading = false
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
