<template>
<el-container>
  <el-header>
    <el-menu
    mode="horizontal">
      <el-menu-item>
        <div class="block">
          <el-date-picker
            v-model="inputdate"
            type="datetimerange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期">
          </el-date-picker>
        </div>
      </el-menu-item>
      <el-menu-item>
        <el-input
          placeholder="请输入姓名"
          v-model="inputname">
        </el-input>
      </el-menu-item>
      <el-menu-item>
        <el-input
          placeholder="请输入地点"
          v-model="inputaddress">
        </el-input>
      </el-menu-item>
      <el-menu-item>
        <el-input
          placeholder="请输入身份证"
          v-model="inputid">
        </el-input>
      </el-menu-item>
      <el-menu-item>
        <i class="el-icon-search"></i>
      </el-menu-item>
    </el-menu>
  </el-header>
  <el-main>
    <el-table
      :data="tableData"
      stripe
      style="width: 100%">
      <el-table-column
        prop="date"
        sortable
        label="日期"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址">
      </el-table-column>
      <el-table-column
        prop="id"
        label="身份证">
      </el-table-column>
    </el-table>
  </el-main>
</el-container>
</template>

<script>
export default {
  name: 'Query',
  data () {
    return {
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄',
        id: 16513216
      }],
      inputname: '',
      inputdate: [new Date(2000, 10, 10, 10, 10), new Date(2000, 10, 11, 10, 10)],
      inputaddress: '',
      inputid: ''
    }
  }
}
</script>

<style scoped>

</style>
