<template>
  <div>
    <el-table
      :data="tableData.filter(data => !search || data.typeName.toLowerCase().includes(search.toLowerCase())).slice((currentPage-1)*PageSize,currentPage*PageSize)"
      border
      stripe
      style="width: 100%"
      :height="500"
    >
      <el-table-column label="ID" sortable prop="id" />
      <el-table-column label="位置" sortable prop="location" />
      <el-table-column label="客房类型" sortable prop="typeName" />
      <el-table-column label="描述" sortable prop="note" />
      <el-table-column label="价格" sortable prop="price" />
      <el-table-column label="押金" sortable prop="deposit" />
      <el-table-column label="床位数" sortable prop="bedCount" />

      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-select v-model="search" filterable clearable placeholder="选择客房类型">
            <el-option v-for="item in typeInfo" :key="item.typeName" :label="item.typeName" :value="item.typeName" />
          </el-select>
        </template>
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">订房</el-button>
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
      ></el-pagination>
    </div>
  </div>
</template>

<script>
import { info, deleteD } from '@/api/room/content'
import { info as gInfo } from '@/api/room/type'
export default {
  data() {
    return {
      typeInfo: '',
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
    this.fetchData()
  },
  methods: {
    fetchData() {
      info().then(response => {
        this.tableData = response.data
        // 将数据的长度赋值给totalCount
        this.totalCount = this.tableData.length
        gInfo().then(response => {
          this.typeInfo = response.data
        })
      })
    },
    handleEdit(index, row) {
      this.$router.push({
        name: 'RoomBookingEdit',
        params: {
          data: row
        }
      })
    },
    handleDelete(index, row) {
      deleteD(row)
        .then(response => {
          this.$message({
            message: response.message,
            type: 'success'
          })
        })
        .catch(() => {})
      this.$delete(this.tableData, index)
    },
    // 分页
    // 每页显示的条数
    handleSizeChange(val) {
      // 改变每页显示的条数
      this.PageSize = val
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
