<template>
  <div class="mainbox">
  <div class="box1">
    <div class="Echart1">
      <div id="huifeng"></div>
    </div>
    <div class="Echart2">
      <div id="dayuecheng"></div>
    </div>
  </div>
  <div class="box2">
    <div class="Echart3">
      <div id="wanda"></div>
    </div>
    <div class="Echart4">
      <div id="gongshang"></div>
    </div>
  </div>
  </div>
</template>

<script>
export default {
  name: 'ShowPlace',
  methods: {
    drawChart () {
      let huifengEchart = this.$echarts.init(document.getElementById('huifeng'))
      let huifengoption = {
        title: {
          text: '汇丰银行'
        },
        tooltip: {},
        legend: {
          data: ['人流量']
        },
        xAxis: {
          data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
        },
        yAxis: {},
        series: [{
          name: '人数',
          type: 'line',
          data: [50, 60, 45, 30, 50, 60, 45, 30, 50, 60, 45, 30]
        }]
      }
      let dayuechengEchart = this.$echarts.init(document.getElementById('dayuecheng'))
      let dayuechengoption = {
        title: {
          text: '大悦城'
        },
        tooltip: {},
        legend: {
          data: ['人流量']
        },
        xAxis: {
          data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
        },
        yAxis: {},
        series: [{
          name: '人数',
          type: 'line',
          data: [50, 60, 45, 30, 50, 60, 45, 30, 50, 60, 45, 30]
        }]
      }
      let wandaEchart = this.$echarts.init(document.getElementById('wanda'))
      let wandaoption = {
        title: {
          text: '万达商场'
        },
        tooltip: {},
        legend: {
          data: ['人流量']
        },
        xAxis: {
          data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
        },
        yAxis: {},
        series: [{
          name: '人数',
          type: 'line',
          data: [50, 60, 45, 30, 50, 60, 45, 30, 50, 60, 45, 30]
        }]
      }
      let gongshangEchart = this.$echarts.init(document.getElementById('gongshang'))
      let gongshangoption = {
        title: {
          text: '工商银行'
        },
        tooltip: {},
        legend: {
          data: ['人流量']
        },
        xAxis: {
          data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
        },
        yAxis: {},
        series: [{
          name: '人数',
          type: 'line',
          data: [50, 60, 45, 30, 50, 60, 45, 30, 50, 60, 45, 30]
        }]
      }
      gongshangEchart.setOption(gongshangoption)
      wandaEchart.setOption(wandaoption)
      huifengEchart.setOption(huifengoption)
      dayuechengEchart.setOption(dayuechengoption)
    }
  },
  mounted () {
    this.drawChart()
  }
}
</script>

<style scoped>
#huifeng {
  width: 600px;
  height:400px;
  margin: auto;
  margin-top: 10px;
  margin-bottom: 10px
}
#dayuecheng {
  width: 600px;
  height:400px;
  margin: auto;
  margin-top: 10px;
  margin-bottom: 10px
}
#wanda {
  width: 600px;
  height:400px;
  margin: auto;
  margin-top: 10px
}
#gongshang {
  width: 600px;
  height:400px;
  margin: auto;
  margin-top: 10px
}
.box1 {
  display: flex;
  justify-content: space-between;
}
.box2 {
  display: flex;
  justify-content: space-between;
}
.mainbox {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
</style>
