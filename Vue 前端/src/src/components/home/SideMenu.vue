<template>
  <el-menu
    class="categories"
    default-active="/index"
    router
    active-text-color="red">
    <el-menu-item index="/index">
      <span slot="title">上传文件</span>
    </el-menu-item>
    <el-menu-item index="/query">
      <span slot="title">显示所有录入信息</span>
    </el-menu-item>
    <el-submenu index="/linediagyear">
      <span slot="title">折线图显示人流量信息</span>
      <el-menu-item-group>
        <el-menu-item  index="/linediagyear">年流量</el-menu-item>
        <el-menu-item index="/linediagmonth">月流量</el-menu-item>
        <el-menu-item index="/linediagday">日流量</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
    <el-submenu index="/piediagyear">
      <span slot="title">各地访问量饼图</span>
      <el-menu-item-group>
        <el-menu-item  index="/piediagyear">年流量</el-menu-item>
        <el-menu-item index="/piediagmonth">月流量</el-menu-item>
        <el-menu-item index="/piediagday">日流量</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  name: 'SideMenu'
}
</script>
