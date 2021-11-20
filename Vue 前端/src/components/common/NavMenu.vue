<template>
  <el-container>
    <el-header>
      <el-menu
        :default-active="'/index'"
        router
        mode="horizontal"
        background-color="white"
        text-color="#222"
        active-text-color="red"
        style="min-width: 1300px">
        <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
          {{ item.navItem }}
        </el-menu-item>
        <a href="login" style="color: #222;float: right;padding: 20px;" v-on:click="logout">注销</a>
        <span style="position: absolute;padding-top: 20px;right: 43%;font-size: 20px;font-weight: bold">Data Grip Tools</span>
      </el-menu>
    </el-header>
  </el-container>
</template>

<script>
export default {
  data () {
    return {
      navList: [
        {name: '/index', navItem: '首页'},
        {name: '/tutorial', navItem: '使用指南'}
      ]
    }
  },
  methods: {
    logout () {
      var _this = this
      console.log(this.$store.state)
      _this.$store.commit('logout')
    }
  }
}
</script>

<style scoped>
a{
  text-decoration: none;
}

span {
  pointer-events: none;
}
</style>
