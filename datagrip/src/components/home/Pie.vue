<template>
  <div class="pieChart">
    <div id="pie"></div>
  </div>
</template>

<script>
export default {
  name: 'Pie',
  methods: {
    drawChart () {
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
            data: [
              {value: 235, name: '工商银行'},
              {value: 274, name: '大悦城'},
              {value: 310, name: '汇丰银行'},
              {value: 335, name: '万达广场'}
            ].sort(function (a, b) {
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
    }
  },
  mounted () {
    this.drawChart()
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
</style>
