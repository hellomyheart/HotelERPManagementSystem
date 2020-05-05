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
      <el-form-item label="ID">
        <el-input v-model="form.id" :disabled="true"/>
      </el-form-item>
      <el-form-item label="分类名">
        <el-input v-model="form.typeName" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { update } from '@/api/restaurantProcurement/type'

    export default {
        name: 'DepartmentEdit',
        data() {
            return {
                formLoading: true,
                form: {
                    id: '',
                    typeName: ''
                }
            }
        },
        created() {
            this.fetchData()
        },
        methods: {
            fetchData() {
                    this.form = this.$route.params.data
                    this.formLoading = false
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
