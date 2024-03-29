<template>
  <div id="home-chart" style="width:100%;height:400px;"></div>
</template>
<script>
export default {
  mounted() {
    this.homeChart();
  },
  methods: {
    homeChart() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = this.$echarts.init(document.getElementById("home-chart"));
      // 指定图表的配置项和数据
      var option = (option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
            crossStyle: {
              color: "#999"
            }
          }
        },
        toolbox: {
          feature: {
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ["line", "bar"] },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        legend: {
          data: ["用户", "访问"]
        },
        xAxis: [
          {
            type: "category",
            data: [
              "1月",
              "2月",
              "3月",
              "4月",
              "5月",
              "6月",
              "7月",
              "8月",
              "9月",
              "10月",
              "11月",
              "12月"
            ],
            axisPointer: {
              type: "shadow"
            }
          }
        ],
        yAxis: [
          {
            type: "value",
            name: "用户",
            min: 0,
            max: 250,
            interval: 50,
            axisLabel: {
              formatter: "{value}"
            }
          },
          {
            type: "value",
            name: "访问",
            min: 0,
            max: 25,
            interval: 5,
            axisLabel: {
              formatter: "{value}"
            }
          }
        ],
        series: [
          {
            name: "用户",
            type: "bar",
            data: [
              2.0,
              4.9,
              7.0,
              23.2,
              25.6,
              76.7,
              135.6,
              162.2,
              32.6,
              20.0,
              6.4,
              3.3
            ]
          },
          {
            name: "访问",
            type: "bar",
            data: [
              2.6,
              5.9,
              9.0,
              26.4,
              28.7,
              70.7,
              175.6,
              182.2,
              48.7,
              18.8,
              6.0,
              2.3
            ]
          }
        ]
      });

      // // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
      //根据窗口的大小变动图表
      window.onresize = function() {
        myChart.resize();
      };
    }
  }
};
</script>
<style lang="scss" scoped>
#home-chart {
  background: #ffffff;
  padding: 20px 0;
}
</style>
