<template>
  <el-table
    :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    style="width: 100%">
    <el-table-column
      label= "ID"
      prop= "id">
    </el-table-column>
    <el-table-column
      label= "部门名称"
      prop= "departmentName">
    </el-table-column>
    <el-table-column
      label= "部门介绍"
      prop= "note">
    </el-table-column>
    <el-table-column
      align="right">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
    import {info,deleteD} from '@/api/department'
  export default {
    data() {
      return {
        tableData: '',
        search: ''
      }
    },
    created() {
            this.fetchData()
        },
    methods: {
      fetchData() {
                info().then(response => {
                    this.tableData= response.data
                   
                })
            },
      handleEdit(index, row) {
        this.$router.push({
          name: "DepartmentEdit",
          params: {
            data: row
          }
        })
      },
      handleDelete(index, row) {
        deleteD(row).then(response => {
          this.$message({
            message: response.message,
            type: "success"
           
          });
        }).catch(() => {
        })

         this.$router.go(0)
      }
    }
  }
</script>

        // update(row).then(response => {
        //   this.$message({
        //     message: response.message,
        //     type: "success"
        //   });
        // }).catch(() => {
        // })