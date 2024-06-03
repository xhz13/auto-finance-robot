<script setup lang="ts">
import { onMounted, ref } from 'vue';
import searchBar from '../components/searchBar.vue';
import { useRoute } from 'vue-router';
import axios from 'axios';
import * as echarts from 'echarts';
interface TableDataItem {
  year: number;
  cash: number;
  ebit: number;
  eva: number;
  grossprofit: number;
  intLiab: number;
  invCap: number;
  netProf: number;
  nocfnote: number;
  opProf: number;
  opRev: number;
  totAss: number;
  totCurLia: number;
  totNCurrAss: number;
  totProf: number;
  totShareEquit: number;
  curRt: number;
  qckRt: number;
}
let myChart;
let newmyChart;
let myChart2;
let myChart3;
let myChart4;
let myChart5;
const tableData = ref<TableDataItem[]>([]);
const responsedataArray = ref(new Array(5).fill(0).map((_, index) => {
    return {
      cash: 0,
      ebit: 0,
      eva: 0,
      grossprofit: 0,
      intLiab: 0,
      invCap: 0,
      netProf: 0,
      nocfnote: 0,
      opProf: 0,
      opRev: 0,
      totAss: 0,
      totCurLia: 0,
      totNCurrAss: 0,
      totProf: 0,
      totShareEquit: 0,
      year: 2018 + index
    };
}));
onMounted(async () => {
  const route = useRoute();
  let itemValue = '';
  for (let i = 0; i <= 5; i++) {
    itemValue += route.query[i];
  }
  let response;
  try {
    response = await axios({
      method: 'post',
      url: '/api/InquireStock',
      data: {
        stk: itemValue,
      }
    });
    console.log(response.data); // 处理响应数据
  } catch (error) {
    console.error(error); // 处理错误情况
  }
  if (!response) {
    return;
  }
  interface totAss {
    value: number
    year: string
  }
  let totAssArray: totAss[] =  [
  { value: 0, year: '2018' },
  { value: 0, year: '2019' },
  { value: 0, year: '2020' },
  { value: 0, year: '2021' },
  { value: 0, year: '2022' }
];
  let opRevArray: totAss[] =  [
  { value: 0, year: '2018' },
  { value: 0, year: '2019' },
  { value: 0, year: '2020' },
  { value: 0, year: '2021' },
  { value: 0, year: '2022' }
];
let opProfArray: totAss[] =  [
  { value: 0, year: '2018' },
  { value: 0, year: '2019' },
  { value: 0, year: '2020' },
  { value: 0, year: '2021' },
  { value: 0, year: '2022' }
];
let totloadArray: totAss[] =  [
  { value: 0, year: '2018' },
  { value: 0, year: '2019' },
  { value: 0, year: '2020' },
  { value: 0, year: '2021' },
  { value: 0, year: '2022' }
];
response.data.forEach((item: any) => {
  let target = responsedataArray.value.find(data => data.year === item.year);
    if (target) {
      Object.assign(target, item);
    }
  });
  response.data.forEach((item: any) => {
      let totAssItem: totAss = {
      value: item.totAss,
      year: item.year
    };
    let opRevItem: totAss = {
      value: item.opRev,
      year: item.year
    };
    let opProfItem: totAss = {
      value: item.opProf,
      year: item.year
    };
    let totloadItem : totAss = {
      value: item.intLiab+item.totCurLia,
      year: item.year
    }
    if(item.year=='2018'){
      totAssArray[0]=totAssItem;
      opRevArray[0]=opRevItem;
      opProfArray[0]=opProfItem;
      totloadArray[0]=totloadItem;
    }
    if(item.year=='2019'){
      totAssArray[1]=totAssItem;
      opRevArray[1]=opRevItem;
      opProfArray[1]=opProfItem;
      totloadArray[1]=totloadItem;
    }
    if(item.year=='2020'){
      totAssArray[2]=totAssItem;
      opRevArray[2]=opRevItem;
      opProfArray[2]=opProfItem;
      totloadArray[2]=totloadItem;
    }
    if(item.year=='2021'){
      totAssArray[3]=totAssItem;
      opRevArray[3]=opRevItem;
      opProfArray[3]=opProfItem;
      totloadArray[3]=totloadItem;
    }
    if(item.year=='2022'){
      totAssArray[4]=totAssItem;
      opRevArray[4]=opRevItem;
      opProfArray[4]=opProfItem;
      totloadArray[4]=totloadItem;
    }
  });
  myChart = echarts.init(document.getElementById('totAsschart'),null,{width:300,height:160});
  myChart.setOption({
    tooltip: {
    trigger: 'axis',
    axisPointer: {
      type: 'shadow'
      }
    },
    grid: {
    left: '3%',
    right: '4%',
    bottom: '3%',
    containLabel: true
  },
    xAxis: {
      data: ['2018', '2019', '2020', '2021', '2022', ],
      name: '年份'  // 添加x轴名称
    },
    yAxis: [
    {
      type: 'value',
      name: '总资产'  // 添加y轴名称
    }
    ],
    series: [
      {
        type: 'bar',
        data: [totAssArray[0].value, totAssArray[1].value, totAssArray[2].value, totAssArray[3].value, totAssArray[4].value]
      }
    ]
  });


  newmyChart = echarts.init(document.getElementById('totAsschart2'),null,{width:300,height:160});
  newmyChart.setOption({
    tooltip: {
    trigger: 'axis',
    axisPointer: {
      type: 'shadow'
      }
    },
    grid: {
    left: '3%',
    right: '4%',
    bottom: '3%',
    containLabel: true
  },
    xAxis: {
      data: ['2018', '2019', '2020', '2021', '2022', ],
      name: '年份'  // 添加x轴名称
    },
    yAxis: [
    {
      type: 'value',
      name: '总资产'  // 添加y轴名称
    }
    ],
    series: [
      {
        type: 'bar',
        data: [totAssArray[0].value, totAssArray[1].value, totAssArray[2].value, totAssArray[3].value, totAssArray[4].value]
      }
    ]
  });


  myChart2 = echarts.init(document.getElementById('opRevchart'),null,{width:300,height:200});
  myChart2.setOption({
    tooltip: {
    trigger: 'axis',
    axisPointer: {
      type: 'shadow'
      }
    },
    grid: {
    left: '3%',
    right: '4%',
    bottom: '3%',
    containLabel: true
  },
    xAxis: {
      data: ['2018', '2019', '2020', '2021', '2022', ],
      name: '年份'  // 添加x轴名称
    },
    yAxis: [
    {
      type: 'value',
      name: '营业总收入'  // 添加y轴名称
    }
    ],
    series: [
      {
        type: 'bar',
        data: [opRevArray[0].value, opRevArray[1].value, opRevArray[2].value, opRevArray[3].value, opRevArray[4].value]
      }
    ]
  });


  myChart3 = echarts.init(document.getElementById('opProfchart'),null,{width:300,height:200});
  myChart3.setOption({
    tooltip: {
    trigger: 'axis',
    axisPointer: {
      type: 'shadow'
      }
    },
    grid: {
    left: '3%',
    right: '4%',
    bottom: '3%',
    containLabel: true
  },
    xAxis: {
      data: ['2018', '2019', '2020', '2021', '2022', ],
      name: '年份'  // 添加x轴名称
    },
    yAxis: [
    {
      type: 'value',
      name: '营业利润'  // 添加y轴名称
    }
    ],
    series: [
      {
        type: 'bar',
        data: [opProfArray[0].value, opProfArray[1].value, opProfArray[2].value, opProfArray[3].value, opProfArray[4].value]
      }
    ]
  });




    var data2 = [
    { year: '2017', value: 12310491333980 },
    { year: '2018', value: 13894907857925 },  
    { year: '2019', value: 14279968506242 },
    { year: '2020', value: 14687744162801 },
    { year: '2021', value: 17820459508852 },
    { year: '2022', value: 17963171479205 },
  ];

    myChart4 = echarts.init(document.getElementById('gdp'),null,{width:300,height:200});

    // 配置对象
    myChart4.setOption({
      title: {
        text: '年度数据'
      },
      xAxis: {
        type: 'category',
        data: data2.map(function (item) { return item.year; })
      },
      yAxis: {
        type: 'value',
        axisLabel: {
          rotate: 45
        }
      },
      grid: {
      left: '12%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
      series: [{
        data: data2.map(function (item) { return item.value; }),
        type: 'line'
      }]
    });


    myChart5 = echarts.init(document.getElementById('loadchart'),null,{width:300,height:160});
    myChart5.setOption({
      tooltip: {
      trigger: 'axis',
      axisPointer: {
        type: 'shadow'
        }
      },
      grid: {
      left: '3%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
      xAxis: {
        data: ['2018', '2019', '2020', '2021', '2022', ],
        name: '年份'  // 添加x轴名称
      },
      yAxis: [
      {
        type: 'value',
        name: '负债合计'  // 添加y轴名称
      }
      ],
      series: [
        {
          type: 'bar',
          data: [totloadArray[0].value, totloadArray[1].value, totloadArray[2].value, totloadArray[3].value, totloadArray[4].value]
        }
      ]
    });




  tableData.value = responsedataArray.value.map((item, index) => ({
        year: 2018 + index,
        cash: item.cash,
        ebit: item.ebit,
        eva: item.eva,
        grossprofit: item.grossprofit,
        intLiab: item.intLiab,
        invCap: item.invCap,
        netProf: item. netProf,
        nocfnote: item.nocfnote,
        opProf: item.opProf,
        opRev: item.opRev,
        totAss: item.totAss,
        totCurLia: item.totCurLia,
        totNCurrAss: item.totNCurrAss,
        totProf: item.totProf,
        totShareEquit: item.totShareEquit,
      }));
    /*
    *新的表
    */
      var app: any = {};
      type EChartsOption = echarts.EChartsOption;
      var macrochartDom = document.getElementById('macrochart')!;
      var macrochart = echarts.init(macrochartDom);
      var option: EChartsOption;
      const posList = [
        'left',
        'right',
        'top',
        'bottom',
        'inside',
        'insideTop',
        'insideLeft',
        'insideRight',
        'insideBottom',
        'insideTopLeft',
        'insideTopRight',
        'insideBottomLeft',
        'insideBottomRight'
      ] as const;
      app.configParameters = {
        rotate: {
          min: -90,
          max: 90
        },
        align: {
          options: {
            left: 'left',
            center: 'center',
            right: 'right'
          }
        },
        verticalAlign: {
          options: {
            top: 'top',
            middle: 'middle',
            bottom: 'bottom'
          }
        },
        position: {
          options: posList.reduce(function (map, pos) {
            map[pos] = pos;
            return map;
          }, {} as Record<string, string>)
        },
        distance: {
          min: 0,
          max: 100
        }
      };
      app.config = {
        rotate: 90,
        align: 'left',
        verticalAlign: 'middle',
        position: 'insideBottom',
        distance: 15,
        onChange: function () {
          const labelOption: BarLabelOption = {
            rotate: app.config.rotate as BarLabelOption['rotate'],
            align: app.config.align as BarLabelOption['align'],
            verticalAlign: app.config
              .verticalAlign as BarLabelOption['verticalAlign'],
            position: app.config.position as BarLabelOption['position'],
            distance: app.config.distance as BarLabelOption['distance']
          };
          macrochart.setOption<echarts.EChartsOption>({
            series: [
              {
                label: labelOption
              },
              {
                label: labelOption
              },
              {
                label: labelOption
              },
              {
                label: labelOption
              }
            ]
          });
        }
      };
      type BarLabelOption = NonNullable<echarts.BarSeriesOption['label']>;
      const labelOption: BarLabelOption = {
        show: true,
        position: app.config.position as BarLabelOption['position'],
        distance: app.config.distance as BarLabelOption['distance'],
        align: app.config.align as BarLabelOption['align'],
        verticalAlign: app.config.verticalAlign as BarLabelOption['verticalAlign'],
        rotate: app.config.rotate as BarLabelOption['rotate'],
        formatter: '{c}  {name|{a}}',
        fontSize: 16,
        rich: {
          name: {}
        }
      };
      option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {
          data: ['居民消费水平(元)', '农村居民消费水平(元)', '城镇居民消费水平(元)'],
        },
        toolbox: {
          show: true,
          orient: 'vertical',
          left: 'right',
          top: 'center',
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ['line', 'bar', 'stack'] },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        xAxis: [
          {
            type: 'category',
            axisTick: { show: false },
            data: ['2014', '2015', '2016', '2017', '2018','2019','2020','2021','2022']
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ],
        series: [
          {
            name: '居民消费水平(元)',
            type: 'bar',
            barGap: 0,
            label: labelOption,
            emphasis: {
              focus: 'series'
            },
            data:[17220, 18857, 20801, 22968, 25245, 27504, 27439, 31013, 31899]
          },
          {
            name: '农村居民消费水平(元)',
            type: 'bar',
            label: labelOption,
            emphasis: {
              focus: 'series'
            },
            data: [8365, 9409, 10609, 12145, 13985, 15382, 16046, 18434, 19520]
          },
          {
            name: '城镇居民消费水平(元)',
            type: 'bar',
            label: labelOption,
            emphasis: {
              focus: 'series'
            },
            data: [24430, 26119, 28154, 30323, 32483, 34900, 34043, 37995, 38574]
          },
        ]
      };
      option && macrochart.setOption(option);
});
</script>

<template>
  <div class = "contianer">
  <searchBar style="margin-top: 30px;"/>
  <div class="CompanySituation">
  <h2 style="margin-bottom: 0;">企业情况</h2>
    <el-table :data="tableData" 
              :row-style="{height: '10px'}"
              :cell-style="{padding: '0px'}"
              style="width: 80%;font-size: 10px;margin-top: 0;">
      <el-table-column prop="year" label="年份" />
      <el-table-column prop="cash" label="货币资金" />
      <el-table-column prop="ebit" label="EBIT" />
      <el-table-column prop="eva" label="应得现金" />
      <el-table-column prop="grossprofit" label="毛利润" />
      <el-table-column prop="intLiab" label="有息负债" />
      <el-table-column prop="invCap" label="投入资本" />
      <el-table-column prop="netProf" label="税后利润" />
      <el-table-column prop="nocfnote" label="经营产生现金" />
    </el-table>
  <el-table :data="tableData"
            :row-style="{height: '10px'}"
            :cell-style="{padding: '0px'}"
            style="width: 70%;font-size: 10px;margin-left: 130px;margin-top: 0;" >
    <el-table-column prop="opProf" label="营业利润" />
    <el-table-column prop="opRev" label="营业收入" />
    <el-table-column prop="totAss" label="总资产" />
    <el-table-column prop="totCurLia" label="流动负债" />
    <el-table-column prop="totNCurrAss" label="流动资产" />
    <el-table-column prop="totProf" label="税前利润" />
    <el-table-column prop="totShareEquit" label="所有者权益" />
  </el-table>
  </div>
  <div class = "chart-container">
    <div id="totAsschart" style="width:200px;height:250px;"></div>
    <div id="opRevchart" style="width:200px;height:250px;margin-left: 100px;"></div>
    <div id="opProfchart" style="width:200px;height:250px;margin-left: 100px;"></div>
  </div>
  <div class="MacroeconomicData">
    <h2 style="margin-bottom: 0;">宏观数据</h2>
    <!-- TODO:居民经济表格表格 -->
    <div id="macrochart" style="width:800px;height:350px;"></div>
    <h3 style="margin-top: 0;margin-bottom: 0;margin-top: 0;">宏观经济分析：</h3>
  </div>
  <div class="MacroeconomicDataAnalyse">
    <div id="gdp" style="width: 200px;height:200px;margin-left: 200px;"></div>
    <div style=" margin-left: 110px;   margin-top: 0;">
    <p>2018年：GDP增长率为12.87%，这表明在2018年中国的经济增长较为强劲。</p>
    <p>2019年和2020年：增长率分别为2.77%和2.86%，相对平稳，显示出经济增速放缓的趋势。</p>
    <p>2021年：增长率达到21.33%，这是一个显著的跳升。可能的原因包括2020年受COVID-19疫情影响经济基数较低，而2021年经济快速复苏。</p>
    <p>2022年：增长率降至0.80%，显示出经济增速明显放缓，可能受到疫情持续影响和其他经济因素的制约。</p>
    <p>从总体来看，GDP总量在逐年增加，但年度增长率有明显波动。尤其是2021年出现了异常高的增长率，而2022年则大幅回落</p>
  </div>
  </div>
  
  <!-- TODO:多维度财务分析 -->
  <div class="Multidimensional">
    <h1>多维财务分析</h1>
    <div class = "">
      <h3>1.	资产负债情况</h3>
      <div style="display: flex;">
      <div id="totAsschart2" style="width:200px;height:250px;"></div>
      <div id="loadchart" style="width:200px;height:250px;margin-left: 120px;"></div>
      </div>
    </div>
  </div>
  <!-- TODO:矿业数据表格 -->


  <!-- TODO:投入产出基本流量表 -->
  </div>
</template>

<style scoped>
/* 居中排列 */
.CompanySituation{
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;/*水平轴*/
  align-items: center;/*垂直轴*/
}

.contianer{
  padding-left: 150px;
  padding-right: 150px;
}
.chart-container {
  display: flex;
  justify-content: center;/*水平轴*/
  align-items: center;/*垂直轴*/
  width: 100%;
  height: 240px;
  display: flex;
}
.MacroeconomicData{
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;/*水平轴*/
  align-items: center;/*垂直轴*/
}
.MacroeconomicDataAnalyse{
  width: 100%;
  display: flex;
  justify-content: center;/*水平轴*/
  align-items: center;/*垂直轴*/
}
.Multidimensional{
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;/*水平轴*/
  align-items: center;/*垂直轴*/
}

</style>
