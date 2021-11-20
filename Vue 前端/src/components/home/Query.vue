<template>
<el-container>
  <el-header>
    <el-menu
    mode="horizontal">
      <el-menu-item>
        <div class="block">
          <el-date-picker
            size="small"
            v-model="queryForm.inputdate"
            type="daterange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期">
          </el-date-picker>
        </div>
      </el-menu-item>
      <el-menu-item>
        <el-input
          size="small"
          placeholder="请输入姓名"
          v-model="queryForm.inputname">
        </el-input>
      </el-menu-item>
      <el-menu-item>
        <el-select v-model="queryForm.inputaddress" size="small" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-menu-item>
      <el-menu-item>
        <el-input
          size="small"
          placeholder="请输入身份证"
          v-model="queryForm.inputid">
        </el-input>
      </el-menu-item>
      <el-menu-item>
        <button class="el-icon-search"  v-on:click="query"></button>
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
      options: [{
        value: '汇丰银行',
        label: '汇丰银行'
      }, {
        value: '万达商场',
        label: '万达商场'
      }, {
        value: '大悦城',
        label: '大悦城'
      }, {
        value: '中国工商银行',
        label: '中国工商银行'
      }],
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄',
        id: 16513216
      }],
      queryForm: {
        inputname: '',
        inputdate: ['', ''],
        inputaddress: '',
        inputid: ''
      }
    }
  },
  methods: {
    query () {
      this.$axios
        .post('/query', this.queryForm).then(resp => {
          if (resp) {
            this.tableData = resp.data
          }
        })
    }
  }
}
</script>

<style scoped>

</style>
