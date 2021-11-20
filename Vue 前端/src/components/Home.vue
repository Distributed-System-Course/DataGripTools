<template>
  <div>
    <nav-menu></nav-menu>
    <el-container>
      <el-aside style="width: 200px; margin-top: 20px">
        <switch></switch>
        <SideMenu></SideMenu>
      </el-aside>
      <el-main>
        <router-view/>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import SideMenu from './home/SideMenu'
import NavMenu from './common/NavMenu'
export default {
  name: 'Home',
  components: {NavMenu, SideMenu}
}
</script>

<style scoped>

</style>
