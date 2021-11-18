<template>
  <el-menu
    class="categories"
    default-active="/index"
    router
    @select="handleSelect"
    active-text-color="red">
    <el-menu-item index="/index">
      <i class="el-icon-menu"></i>
      <span slot="title">上传文件</span>
    </el-menu-item>
    <el-menu-item index="/query">
      <i class="el-icon-menu"></i>
      <span slot="title">显示所有录入信息</span>
    </el-menu-item>
    <el-menu-item index="/linediagram">
      <i class="el-icon-menu"></i>
      <span slot="title">图表显示人流量信息</span>
    </el-menu-item>
    <el-menu-item index="/piediagram">
      <i class="el-icon-menu"></i>
      <span slot="title">各地访问量饼图</span>
    </el-menu-item>
    <el-menu-item index="4">
      <i class="el-icon-menu"></i>
      <span slot="title">function5</span>
    </el-menu-item>
    <el-menu-item index="5">
      <i class="el-icon-menu"></i>
      <span slot="title">function6</span>
    </el-menu-item>
    <el-menu-item index="6">
      <i class="el-icon-menu"></i>
      <span slot="title">function7</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: 'SideMenu'
}
</script>
