<template>
  <el-container>
    <el-header>
      <div class="block">
        <span class="demonstration" style="font-size: 20px">各地</span>
        <el-date-picker
          v-model="pieyear"
          align="right"
          type="year"
          placeholder="选择年">
        </el-date-picker>
        <span class="demonstration" style="font-size: 20px">访问量饼图</span>
        <el-button class="el-icon-search"  v-on:click="query"></el-button>
      </div>
    </el-header>
    <el-main>
      <div class="pieChart">
        <div id="pie"></div>
      </div>
    </el-main>
  </el-container>

</template>

<script>
export default {
  name: 'PieYear',
  data () {
    return {
      pieyear: '',
      dataset: [
        {value: 235, name: '工商银行'},
        {value: 274, name: '大悦城'},
        {value: 310, name: '汇丰银行'},
        {value: 335, name: '万达广场'}
      ]
    }
  },
  methods: {
    drawChart (dataset) {
      let pieEchart = this.$echarts.init(document.getElementById('pie'))
      let pieoption = {
        tooltip: {
          trigger: 'item'
        },
        series: [
          {
            name: '访问来源',
            type: 'pie',
            radius: '55%',
            data: dataset.sort(function (a, b) {
              return a.value - b.value
            }),
            roseType: 'angle',
            itemStyle: {
              normal: {
                shadowBlur: 200,
                shadowColor: 'rgba(0, 0, 0, 0.5)',
                label: {
                  textStyle: {
                    fontSize: 25
                  }
                }
              }
            }
          }
        ]
      }
      pieEchart.setOption(pieoption)
    },
    query () {
      this.$axios
        .post('/piediagyear', this.pieyear).then(resp => {
          if (resp) {
            console.log(JSON.parse(JSON.stringify(resp.data)))
            this.dataset = JSON.parse(JSON.stringify(resp.data))
            this.drawChart(this.dataset)
          }
        })
    }
    // loadtoday () {
    //   let date = new Date()
    //   this.$axios
    //     .post('/piediagyear', date).then(resp => {
    //       if (resp) {
    //         this.dataset = resp.data
    //       }
    //     })
    // }
  },
  mounted () {
    // this.loadtoday()
    this.drawChart(this.dataset)
  }
}
</script>

<style scoped>
#pie {
  width: 700px;
  height: 700px;
}
.pieChart {
  display: flex;
  justify-content: center;
  flex-direction: row;
}
.block {
  display: flex;
  flex-direction: row;
  justify-content: center;
}
</style>
