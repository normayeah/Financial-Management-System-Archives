<template>
  <div class="home-progress">
    <div class="title">月访问量</div>
    <div class="tip">同上期增长</div>
    <el-progress
      class="progress"
      :text-inside="true"
      :stroke-width="24"
      :percentage="20"
      status="warning"
    ></el-progress>
    <div class="title">月用户量</div>
    <div class="tip">同上期增长</div>
    <el-progress
      class="progress"
      :text-inside="true"
      :stroke-width="24"
      :percentage="50"
      status="warning"
    ></el-progress>
    <div id="progress-chart" style="width:100%;height:200px;margin-top:10px;"></div>
  </div>
</template>
<script>
export default {
  mounted() {
    this.progressChart();
  },
  methods: {
    progressChart() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = this.$echarts.init(
        document.getElementById("progress-chart")
      );
      // 指定图表的配置项和数据
      var option = {
        title: {
          text: "数据统计",
          left: "center"
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
          // orient: 'vertical',
          // top: 'middle',
          bottom: 10,
          left: "center",
          data: ["用户", "访问"]
        },
        series: [
          {
            type: "pie",
            radius: "65%",
            center: ["50%", "50%"],
            selectedMode: "single",
            data: [{ value: 535, name: "用户" }, { value: 510, name: "访问" }],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)"
              }
            }
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
<style lang="scss">
.home-progress {
  background: #ffffff;
  height: 400px;
  padding: 20px;
  .title {
    color: #666666;
    font-weight: bold;
    font-size: 20px;
    margin-top: 10px;
  }
  .tip {
    color: #888888;
    font-size: 16px;
    margin-top: 10px;
  }
  .progress {
    margin-top: 10px;
  }
}
</style>
