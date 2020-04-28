<template>
  <div>
    <el-table
      :data="tableData.filter(data => !search || data.foodName.toLowerCase().includes(search.toLowerCase())).slice((currentPage-1)*PageSize,currentPage*PageSize)"
      border
      stripe
      style="width: 100%"
      height= 500
    >
      <el-table-column label="ID" sortable prop="id"></el-table-column>
      <el-table-column label="食材名" prop="foodName"/>
      <el-table-column label="库存数量" prop="foodNumber"></el-table-column>
      <el-table-column label="备注" prop="note"></el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
        </template>
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
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
import { info } from '@/api/restaurant/inventory'
export default {
  data() {
    return {
      tableData: "",
      search: "",
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
    handleEdit(index, row) {
      this.$router.push({
        name: 'RestaurantInventoryEdit',
        params: {
          data: row
        }
      });
    },
    // 分页
    // 每页显示的条数
    handleSizeChange(val) {
      // 改变每页显示的条数
      this.PageSize = val;
      // 注意：在改变每页显示的条数时，要将页码显示到第一页
      this.currentPage = 1;
    },
    // 显示第几页
    handleCurrentChange(val) {
      // 改变默认的页数
      this.currentPage = val;
    }
  }
};
</script>