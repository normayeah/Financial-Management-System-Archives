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
        title: {
          text: "雷达图"
        },
        radar: [
          {
            indicator: [
              { text: "指标一" },
              { text: "指标二" },
              { text: "指标三" },
              { text: "指标四" },
              { text: "指标五" }
            ],
            center: ["25%", "50%"],
            radius: 120,
            startAngle: 90,
            splitNumber: 4,
            shape: "circle",
            name: {
              formatter: "【{value}】",
              textStyle: {
                color: "#72ACD1"
              }
            },
            splitArea: {
              areaStyle: {
                color: [
                  "rgba(114, 172, 209, 0.2)",
                  "rgba(114, 172, 209, 0.4)",
                  "rgba(114, 172, 209, 0.6)",
                  "rgba(114, 172, 209, 0.8)",
                  "rgba(114, 172, 209, 1)"
                ],
                shadowColor: "rgba(0, 0, 0, 0.3)",
                shadowBlur: 10
              }
            },
            axisLine: {
              lineStyle: {
                color: "rgba(255, 255, 255, 0.5)"
              }
            },
            splitLine: {
              lineStyle: {
                color: "rgba(255, 255, 255, 0.5)"
              }
            }
          },
          {
            indicator: [
              { text: "流量", max: 150 },
              { text: "访问", max: 150 },
              { text: "用户", max: 150 },
              { text: "频率", max: 120 },
            ],
            center: ["75%", "50%"],
            radius: 120
          }
        ],
        series: [
          {
            name: "雷达图",
            type: "radar",
            emphasis: {
              lineStyle: {
                width: 4
              }
            },
            data: [
              {
                value: [100, 8, 0.4, -80, 2000],
                name: "图一",
                symbol: "rect",
                symbolSize: 5,
                lineStyle: {
                  type: "dashed"
                }
              },
              {
                value: [60, 5, 0.3, -100, 1500],
                name: "图二",
                areaStyle: {
                  color: "rgba(255, 255, 255, 0.5)"
                }
              }
            ]
          },
          {
            name: "成绩单",
            type: "radar",
            radarIndex: 1,
            data: [
              {
                value: [120, 118, 130, 100, 99, 70],
                name: "1",
                label: {
                  show: true,
                  formatter: function(params) {
                    return params.value;
                  }
                }
              },
              {
                value: [90, 113, 140, 30, 70, 60],
                name: "2",
                areaStyle: {
                  opacity: 0.9,
                  color: new this.$echarts.graphic.RadialGradient(0.5, 0.5, 1, [
                    {
                      color: "#B8D3E4",
                      offset: 0
                    },
                    {
                      color: "#72ACD1",
                      offset: 1
                    }
                  ])
                }
              }
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
