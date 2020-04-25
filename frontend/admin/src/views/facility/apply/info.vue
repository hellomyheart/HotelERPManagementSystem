<template>
  <div>
    <el-table
      :data="tableData.filter(data => !search || data.title.toLowerCase().includes(search.toLowerCase())).slice((currentPage-1)*PageSize,currentPage*PageSize)"
      border
      stripe
      style="width: 100%"
      :height="500"
    >

      <el-table-column label="ID" sortable prop="id"/>
      <el-table-column label="标题" sortable prop="title"/>
      <el-table-column label="申请时间" sortable prop="createTime"/>
      <el-table-column label="单价" prop="price"/>
      <el-table-column label="单位" prop="unit"/>
      <el-table-column label="数量" sortable prop="quantity"/>
      <el-table-column label="总价" prop="totalPrice"/>
      <el-table-column label="备注" prop="note"/>
      <el-table-column label="申请人ID" sortable prop="applyId"/>
      <el-table-column label="申请人姓名" sortable prop="employeeName"/>
      <el-table-column label="状态" :formatter="formatS" sortable prop="status"/>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
        </template>
        <template slot-scope="scope">
          <el-button size="mini" type="danger" @click="handleEdit(scope.$index, scope.row)">通过</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="tabListPage">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="pageSizes"
        :page-size="PageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalCount"
      />
    </div>
  </div>
</template>

<script>
import { info, update, deleteD } from '@/api/facility/apply'
export default {
  data() {
    return {
      tableData: '',
      search: '',
      // 默认显示第几页
      currentPage: 1,
      // 总条数，根据接口获取数据长度(注意：这里不能为空)
      totalCount: 1,
      // 个数选择器（可修改）
      pageSizes: [5, 10, 20, 30],
      // 默认每页显示的条数（可修改）
      PageSize: 10
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      info().then(response => {
        this.tableData = response.data;
        // 将数据的长度赋值给totalCount
        this.totalCount = this.tableData.length;
      });
    },
    formatS: function(row, column, cellValue, index) {
      return row.status == 0 ? '申请' : '通过'
    },
    handleEdit(index, row) {
      update(row)
        .then(response => {
          this.$message({
            message: response.message,
            type: 'success'
          })
        })
        .catch(() => {})
      this.tableData[index].status = 1
    },
    handleDelete(index, row) {
      deleteD(row)
        .then(response => {
          this.$message({
            message: response.message,
            type: 'success'
          });
        })
        .catch(() => {});
      this.$delete(this.tableData, index);
    },
    // 分页
    // 每页显示的条数
    handleSizeChange(val) {
      // 改变每页显示的条数
      this.PageSize = val;
      // 注意：在改变每页显示的条数时，要将页码显示到第一页
      this.currentPage = 1
    },
    // 显示第几页
    handleCurrentChange(val) {
      // 改变默认的页数
      this.currentPage = val
    }
  }
}
</script>
