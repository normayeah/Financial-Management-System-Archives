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
      var option = {
        title: {
          text: "数据展示"
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
            label: {
              backgroundColor: "#6a7985"
            }
          }
        },
        legend: {
          data: ["访问量", "用户量"]
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true
        },
        xAxis: [
          {
            type: "category",
            boundaryGap: false,
            data: ["周一", "周二", "周三", "周四", "周五", "周六", "周日"]
          }
        ],
        yAxis: [
          {
            type: "value"
          }
        ],
        series: [
          {
            name: "访问量",
            type: "line",
            stack: "总量",
            areaStyle: {},
            data: [120, 132, 101, 134, 90, 230, 210]
          },
          {
            name: "用户量",
            type: "line",
            stack: "总量",
            areaStyle: {},
            data: [220, 182, 191, 234, 290, 330, 310]
          }
        ]
      };
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
