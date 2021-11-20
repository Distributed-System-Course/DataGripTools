<template>
  <el-container>
    <el-header>
      <div class="block">
        <div class="block">
        <span class="demonstration" style="font-size: 20px">各地</span>
        <el-date-picker
          v-model="lineyear"
          align="right"
          type="year"
          placeholder="选择年">
        </el-date-picker>
        <span class="demonstration" style="font-size: 20px">访问量折线图</span>
          <button class="el-icon-search"  v-on:click="lineyear"></button>
      </div>
      </div>
    </el-header>
    <el-main>
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
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'LineDiagYear',
  data () {
    return {
      lineyear: '',
      huifengdata: [50, 60, 45, 30, 50, 60, 45, 30, 50, 60, 45, 30],
      dayuedata: [50, 60, 45, 30, 50, 60, 45, 30, 50, 60, 45, 30],
      wandadata: [50, 60, 45, 30, 50, 60, 45, 30, 50, 60, 45, 30],
      gongshangdata: [50, 60, 45, 30, 50, 60, 45, 30, 50, 60, 45, 30]
    }
  },
  methods: {
    drawChart (data1, data2, data3, data4) {
      let huifengEchart = this.$echarts.init(document.getElementById('huifeng'))
      let huifengoption = {
        title: {
          text: '汇丰银行'
        },
        tooltip: {},
        xAxis: {
          data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
        },
        yAxis: {},
        series: [{
          name: '人数',
          type: 'line',
          data: data1
        }],
        label: {
          show: true
        }
      }
      let dayuechengEchart = this.$echarts.init(document.getElementById('dayuecheng'))
      let dayuechengoption = {
        title: {
          text: '大悦城'
        },
        tooltip: {},
        xAxis: {
          data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
        },
        yAxis: {},
        series: [{
          name: '人数',
          type: 'line',
          data: data2
        }],
        label: {
          show: true
        }
      }
      let wandaEchart = this.$echarts.init(document.getElementById('wanda'))
      let wandaoption = {
        title: {
          text: '万达商场'
        },
        tooltip: {},
        xAxis: {
          data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
        },
        yAxis: {},
        series: [{
          name: '人数',
          type: 'line',
          data: data3
        }],
        label: {
          show: true
        }
      }
      let gongshangEchart = this.$echarts.init(document.getElementById('gongshang'))
      let gongshangoption = {
        title: {
          text: '工商银行'
        },
        tooltip: {},
        xAxis: {
          data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
        },
        yAxis: {},
        series: [{
          name: '人数',
          type: 'line',
          data: data4
        }],
        label: {
          show: true
        }
      }
      gongshangEchart.setOption(gongshangoption)
      wandaEchart.setOption(wandaoption)
      huifengEchart.setOption(huifengoption)
      dayuechengEchart.setOption(dayuechengoption)
    },
    query () {
      this.$axios
        .post('/linediagyear', this.lineyear).then(resp => {
          if (resp) {
            this.huifengdata = resp.huifengdata
            this.dayuedata = resp.dayuedata
            this.wandadata = resp.wandadata
            this.gongshangdata = resp.gongshangdata
          }
        })
    }
    // loadtoday () {
    //   let date = new Date()
    //   this.$axios
    //     .post('/linediagyear', date).then(resp => {
    //       if (resp) {
    //         this.huifengdata = resp.huifengdata
    //         this.dayuedata = resp.dayuedata
    //         this.wandadata = resp.wandadata
    //         this.gongshangdata = resp.gongshangdata
    //       }
    //     })
    // }
  },
  mounted () {
    // this.loadtoday()
    this.drawChart(this.huifengdata, this.dayuedata, this.wandadata, this.gongshangdata)
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
.block {
  display: flex;
  flex-direction: row;
  justify-content: center;
}
</style>
