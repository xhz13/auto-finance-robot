<script setup lang="ts">


import * as echarts from 'echarts';
import { ref,onMounted, reactive } from 'vue';
import axios from 'axios';
import Papa from 'papaparse';


let myChart;
onMounted(() => {
  var chartDom = document.getElementById('main');
  myChart = echarts.init(chartDom);
  var option = {
  title: {
        text: '前十大股东占比图',
        subtext: '数据来源于东方财富网',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: function(params:any) {
            return params.name + '<br/>名字: ' + params.value + '<br/>股票类型: ' + params.data.otherProperty + '<br/>持股数量: ' + params.data.otherProperty2;
        }
    },
    legend: {
        orient: 'vertical',
        left: 'left'
    },
    series: [
        {
        name: '紫金矿业持股机构占比',
        type: 'pie',
        radius: '50%',
        center: ['70%', '50%'], // 将饼图向右移动
        data: [
            { value: 23.14, name: '闽西兴杭国有资产投资经营有限公司', otherProperty: 'A股',otherProperty2:'60.84亿' },
            { value: 21.76, name: '香港中央结算（代理人）有限公司', otherProperty: 'H股',otherProperty2:'57.22亿'},
            { value:  5.98, name: '香港中央结算有限公司 ',otherProperty:'A股' ,otherProperty2:'15.74亿'},
            { value:  2.63, name: '中国证券金融股份有限公司',otherProperty:'A股',otherProperty2:'6.91亿' },
            { value:  1.32, name: '上海高毅资产管理合伙企业（有限合伙）-高毅晓峰2号致信基金 ',otherProperty:'A股',otherProperty2:'3.46亿' },
            { value:  1.05, name: '中国工商银行-上证50交易型开放式指数证券投资基金  ',otherProperty:'A股',otherProperty2:'2.76亿' },
            { value:  1.01, name: '中国对外经济贸易信托有限公司-外贸信托-高毅晓峰鸿远集合资金信托计划 ',otherProperty:'A股',otherProperty2:'2.65亿' },
            { value:  0.68, name: '中国工商银行股份有限公司-华泰柏瑞沪深300交易型开放式指数证券投资基金  ',otherProperty:'A股',otherProperty2:'1.8亿' },
            { value:  0.55, name: '阿布达比投资局  ',otherProperty:'A股',otherProperty2:'1.45亿' },
            { value:  0.54, name: 'HHLR管理有限公司-中国价值基金（交易所） ',otherProperty:'A股',otherProperty2:'1.42亿' },
            { value: 41.34,name:  '其他',otherProperty:'A股',otherProperty2:'108.6亿'},
        ],
        itemStyle: {
            color: function(params:any) {
                // 定义一个颜色数组
                var colorList = ['#FF6347', '#FFA07A', '#FFD700', '#FF8C00', '#FF4500', '#1E90FF', '#00BFFF', '#87CEFA', '#40E0D0', '#48D1CC', '#8FBC8F', '#66CDAA', '#98FB98', '#2E8B57', '#3CB371', '#FFC0CB', '#FFB6C1', '#DB7093', '#FF69B4', '#FF1493'];
                // 返回对应索引的颜色
                return colorList[params.dataIndex % colorList.length];
            }
        },
        emphasis: {
            itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
        ]
    };

  myChart.setOption(option);
  
  var chartDom2 = document.getElementById('dayprice');
  var myChart2 = echarts.init(chartDom2);
  var option2 = {
  title: {
    text: '紫金矿业五年股价走势图'
  },
  xAxis: {
    type: 'category',
    data: ['2020/2/1', '2020/3/1', '2020/4/1', '2020/5/1', '2020/6/1', '2020/7/1', '2020/8/1', '2020/9/1', '2020/10/1', '2020/11/1', '2020/12/1', '2021/1/1', '2021/2/1', '2021/3/1', '2021/4/1', '2021/5/1', '2021/6/1', '2021/7/1', '2021/8/1', '2021/9/1', '2021/10/1', '2021/11/1', '2021/12/1', '2022/1/1', '2022/2/1', '2022/3/1', '2022/4/1', '2022/5/1', '2022/6/1', '2022/7/1', '2022/8/1', '2022/9/1', '2022/10/1', '2022/11/1', '2022/12/1', '2023/1/1', '2023/2/1', '2023/3/1', '2023/4/1', '2023/5/1', '2023/6/1', '2023/7/1', '2023/8/1', '2023/9/1', '2023/10/1', '2023/11/1', '2023/12/1', '2024/1/1', '2024/2/1', '2024/3/1', '2024/4/1', '2024/5/1']
  },
  yAxis: {
    type: 'value',
    name: '股价（元）'
  },
  series: [
    {
      label: {
        show: true,
        position: 'top'
      },
      data : [4.16, 3.69, 3.91, 3.78, 4.4, 5.85, 7.19, 6.15, 6.99, 9.29, 9.29, 9.6, 12.19, 9.62, 11.03, 11.23, 9.69, 10.25, 11.11, 10.09, 10.46, 10.15, 9.7, 9.76, 11.22, 11.34, 11.07, 10.06, 9.33, 8.93, 8.8, 7.84, 7.92, 9.83, 10, 11.79, 11.41, 12.39, 12.83, 10.69, 11.37, 13.01, 12.36, 12.13, 12.44, 12.18, 12.46, 12.04, 13.11, 16.82, 17.61, 18.05],
      type: 'line'
    }
  ]
};
myChart2.setOption(option2);


  var chartDom4 = document.getElementById('category');
  var myChart4 = echarts.init(chartDom4);
  var option4 = {
  title: {
        text: '紫金矿业公司毛利贡献结构图',
        subtext: '数据来源于东方财富网',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: function(params:any) {
            return params.name + '<br/>名字: ' + params.value + '<br/>股票类型: ' + params.data.otherProperty + '<br/>持股数量: ' + params.data.otherProperty2;
        }
    },
    legend: {
        orient: 'vertical',
        left: 'left'
    },
    series: [
        {
        name: 'Access From',
        type: 'pie',
        radius: '50%',
        center: ['70%', '50%'], // 将饼图向右移动
        data: [
            { value: 24.08, name: '白银铁矿等其他', otherProperty: '111.37' },
            { value: 3.38, name: '锌(铅)', otherProperty: '15.68'},
            { value:  25.35, name: '金 ',otherProperty:'117.62'},
            { value:  47.91, name: '铜',otherProperty:'222.30'},
        ],
        emphasis: {
        itemStyle: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: 'rgba(0, 0, 0, 0.5)'
        }
      }
        }
        ]
    };

  myChart4.setOption(option4);

// 数据
var data = [
  { year: '2017', value: 12310491333980 },
  { year: '2018', value: 13894907857925 },  
  { year: '2019', value: 14279968506242 },
  { year: '2020', value: 14687744162801 },
  { year: '2021', value: 17820459508852 },
  { year: '2022', value: 17963171479205 },
];

// 获取元素引用
var chartDom3 = document.getElementById('gdp');
// 初始化ECharts实例
var myChart3 = echarts.init(chartDom3);

// 配置对象
var option3 = {
  title: {
    text: '年度数据'
  },
  xAxis: {
    type: 'category',
    data: data.map(function (item) { return item.year; })
  },
  yAxis: {
    type: 'value'
  },
  series: [{
    data: data.map(function (item) { return item.value; }),
    type: 'line'
  }]
};

// 应用配置
myChart3.setOption(option3);
});

const state = reactive({
    text: `要分析紫金矿业在过去五年的财务状况，我们可以从多个方面来进行评估，包括流动性、盈利能力、杠杆水平和现金流。

1. 流动性分析
流动性指标评估公司短期偿债能力，常用的流动性指标包括流动比率和速动比率。

流动比率（Current Ratio） = 流动资产 / 流动负债
速动比率（Quick Ratio） = (流动资产 - 存货) / 流动负债
计算结果：
2022年: 流动比率 = 39,262,403,933 / 47,035,701,043 ≈ 0.83
2021年: 流动比率 = 47,064,293,441 / 50,302,460,681 ≈ 0.94
2020年: 流动比率 = 79,644,459,532 / 71,169,903,836 ≈ 1.12
2019年: 流动比率 = 28,594,396,116 / 33,362,656,029 ≈ 0.86
2018年: 流动比率 = 30,448,688,235 / 37,223,097,530 ≈ 0.82
从流动比率来看，2020年的流动比率最高，超过了1，表明公司在2020年的短期偿债能力较好，而其他年份都低于1，表明短期偿债压力较大。

2. 盈利能力分析
盈利能力分析通常包括以下几个指标：

毛利率（Gross Profit Margin） = (收入 - 成本) / 收入
净利率（Net Profit Margin） = 净利润 / 收入
总资产收益率（ROA, Return on Assets） = 净利润 / 总资产
净资产收益率（ROE, Return on Equity） = 净利润 / 净资产
计算结果：
2022年: 净利率 = 8,458,038,953 / 171,501,338,490 ≈ 4.93%
         ROA = 8,458,038,953 / 182,313,250,403 ≈ 4.64%
         ROE = 8,458,038,953 / 74,596,441,476 ≈ 11.34%

2021年: 净利率 = 19,599,638,352 / 225,102,488,592 ≈ 8.71%
         ROA = 19,599,638,352 / 208,594,678,123 ≈ 9.40%
         ROE = 19,599,638,352 / 92,897,170,544 ≈ 21.11%

2020年: 净利率 = 24,767,210,123 / 270,328,998,459 ≈ 9.16%
         ROA = 24,767,210,123 / 306,044,139,470 ≈ 8.09%
         ROE = 24,767,210,123 / 124,455,445,505 ≈ 19.90%

2019年: 净利率 = 5,060,904,684 / 136,097,978,018 ≈ 3.72%
         ROA = 5,060,904,684 / 123,830,947,219 ≈ 4.09%
         ROE = 5,060,904,684 / 57,079,598,064 ≈ 8.87%

2018年: 净利率 = 4,682,676,553 / 105,994,246,123 ≈ 4.42%
         ROA = 4,682,676,553 / 112,879,303,842 ≈ 4.15%
         ROE = 4,682,676,553 / 47,273,712,702 ≈ 9.91%
从净利率、ROA和ROE来看，2020年和2021年公司的盈利能力较强，尤其是2021年，净利率和ROE都达到了较高水平。

3. 杠杆水平分析
杠杆水平分析评估公司的债务压力，常用的指标包括资产负债率和利息覆盖率。

资产负债率（Debt to Asset Ratio） = 总负债 / 总资产
利息覆盖率（Interest Coverage Ratio） = 息税前利润（EBIT） / 利息费用
计算结果：
2022年: 资产负债率 = 107,716,808,927 / 182,313,250,403 ≈ 59.08%
2021年: 资产负债率 = 115,697,507,579 / 208,594,678,123 ≈ 55.45%
2020年: 资产负债率 = 181,588,693,965 / 306,044,139,470 ≈ 59.32%
2019年: 资产负债率 = 66,751,349,155 / 123,830,947,219 ≈ 53.92%
2018年: 资产负债率 = 65,605,591,140 / 112,879,303,842 ≈ 58.11%
从资产负债率来看，公司的杠杆水平在2020年和2022年较高，均接近60%。尽管如此，该公司的资产负债率总体保持在较稳定的水平，没有显著上升的趋势。

4. 现金流分析
现金流分析主要评估公司的现金流情况，关注经营活动现金流和净现金流。

计算结果：

2022年: 经营活动现金流 = 14,268,403,423
         净现金流 = 15,566,723,072

2021年: 经营活动现金流 = 26,072,237,601
         净现金流 = 27,408,664,576

2020年: 经营活动现金流 = 28,678,502,360
         净现金流 = 34,861,969,408

2019年: 经营活动现金流 = 10,665,557,013
         净现金流 = 10,883,657,728

2018年: 经营活动现金流 = 10,233,009,701
         净现金流 = 10,392,547,328
2020年和2021年的经营活动现金流和净现金流显著高于其他年份，表明公司在这两年的现金流状况非常良好。

总结
综合以上分析：

流动性：2020年的流动性较好，其他年份略显不足。
盈利能力：2020年和2021年的盈利能力较强，尤其是2021年表现突出。
杠杆水平：公司整体杠杆水平在可控范围内，但2020年和2022年较高。
现金流：2020年和2021年的现金流非常充裕，显著改善了公司的财务状况。
总体来看，紫金矿业在2020年和2021年的财务表现非常强劲，但2022年有一定的回落。公司在这些年中的盈利能力和现金流状况显示出其较强的经营实力，但需要注意保持良好的流动性和控制杠杆水平。营活动现金流: 经营活动产生的现金流量总体增加，从142亿增加到286亿（第三年），然后在第四年和第五年减少 。`,
    chars: []
  });


  const state2 = reactive({
    text:`从提供的信息来看，紫金矿业的新项目投产将可能带来以下几方面的收益：

增加产量带来的收入增长：根据提供的数据，公司在海外和国内有多个项目逐步投产，这些项目的年产能较大，比如塞尔维亚和刚果（金）等地的铜矿项目。这些项目的投产将有望增加公司的铜产量，进而增加销售收入。

改善产业地位和盈利能力：随着新项目的逐步投产，公司的产量将进一步增加，有望提升其在全球铜矿业的地位。同时，增加的产量可能有助于降低单位成本，提高盈利能力。

利用铜价上涨的有利时机：根据提供的信息，铜价处于高位，并且供给端存在扰动，这为公司增加产量带来了良好的市场环境。新项目投产后，公司有望从高铜价中受益，进一步提升收入。

提高公司在行业内的竞争力：公司拥有世界级的铜矿资源，新项目的投产将进一步巩固其在全球铜矿业中的地位。这有助于提高公司的品牌形象和市场份额，增强其在行业内的竞争力。

综合来看，紫金矿业的新项目投产有望带来收入增长、盈利能力提升以及在行业内的竞争力加强等多方面的收益。`,  
    chars: []
  });
const tableData = [
  {
    mineral: '铜矿',
    unit: '金属万吨',
    reserves: 719.52,
    resources: 2620.28,
    reserveChange: 3339.80,
    proven: 1143.78,
    probable: 4724.95,
    total: 5868.73,
    measured: 1586.92,
    indicated: 7455.65,
    grade: '45%',
    inferred: 7371.86,
    totalResources: '1%',
  },
  {
    mineral: '金矿小计',
    unit: '金属吨',
    reserves: 289.55,
    resources: 858.94,
    reserveChange: 1148.49,
    proven: 488.72,
    probable: 1483.64,
    total: 1972.36,
    measured: 1025.17,
    indicated: 2997.53,
    grade: '38%',
    inferred: 3117.39,
    totalResources: '-4%',
  },
  {
    mineral: '其中：金矿',
    unit: '金属吨',
    reserves: 220.28,
    resources: 633.79,
    reserveChange: 854.07,
    proven: 362.08,
    probable: 1037.93,
    total: 1400.01,
    measured: 874.57,
    indicated: 2274.58,
    grade: '38%',
    inferred: 2386.57,
    totalResources: '.5%',
  },
  {
    mineral: '伴生金矿',
    unit: '金属吨',
    reserves: 69.27,
    resources: 225.15,
    reserveChange: 294.42,
    proven: 126.64,
    probable: 445.71,
    total: 572.35,
    measured: 150.60,
    indicated: 722.95,
    grade: '41%',
    inferred: 730.82,
    totalResources: '-1%',
  },
  {
    mineral: 'LCE万',
    unit: '碳酸锂吨',
    reserves: 157.10,
    resources: 285.55,
    reserveChange: 442.65,
    proven: 281.43,
    probable: 716.49,
    total: 997.92,
    measured: 348.67,
    indicated: 1346.59,
    grade: '33%',
    inferred: 1215.21,
    totalResources: '11%',
  },
  {
    mineral: '银（含伴生)',
    unit: '金属吨',
    reserves: 640.24,
    resources: 1223.65,
    reserveChange: 1863.89,
    proven: 1764.88,
    probable: 2402.94,
    total: 4167.82,
    measured: 10571.47,
    indicated: 14739.29,
    grade: '13%',
    inferred: 14611.80,
    totalResources: '1%',
  },
  {
    mineral: '钼（含伴生）',
    unit: '金属万吨',
    reserves: 66.22,
    resources: 93.62,
    reserveChange: 159.84,
    proven: 74.88,
    probable: 105.71,
    total: 180.59,
    measured: 125.11,
    indicated: 305.70,
    grade: '52%',
    inferred: 302.00,
    totalResources: '1%',
  },
  {
    mineral: '锌矿',
    unit: '金属万吨',
    reserves: 178.22,
    resources: 232.22,
    reserveChange: 410.44,
    proven: 266.27,
    probable: 357.63,
    total: 623.90,
    measured: 315.37,
    indicated: 939.27,
    grade: '44%',
    inferred: 988.60,
    totalResources: '-5%',
  },
  {
    mineral: '铅矿',
    unit: '金属万吨',
    reserves: 29.55,
    resources: 29.93,
    reserveChange: 59.48,
    proven: 43.62,
    probable: 48.56,
    total: 92.18,
    measured: 36.31,
    indicated: 128.49,
    grade: '46%',
    inferred: 129.73,
    totalResources: '-1%',
  },
  {
    mineral: '钨矿',
    unit: 'WO3万吨',
    reserves: 0.73,
    resources: 2.74,
    reserveChange: 3.47,
    proven: 0.82,
    probable: 3.38,
    total: 4.20,
    measured: 6.35,
    indicated: 10.55,
    grade: '33%',
    inferred: 9.29,
    totalResources: '14%',
  },
  {
    mineral: '锡矿',
    unit: '金属万吨',
    reserves: 0.92,
    resources: 4.23,
    reserveChange: 5.15,
    proven: 1.31,
    probable: 5.33,
    total: 6.64,
    measured: 8.69,
    indicated: 15.33,
    grade: '34%',
    inferred: 15.02,
    totalResources: '2%',
  },
  {
    mineral: '铁矿',
    unit: '矿石亿吨',
    reserves: 0.34,
    resources: 1.14,
    reserveChange: 1.48,
    proven: 0.39,
    probable: 2.24,
    total: 2.63,
    measured: 2.31,
    indicated: 4.94,
    grade: '30%',
    inferred: 4.78,
    totalResources: '3%',
  },
  {
    mineral: '煤炭',
    unit: '亿吨',
    reserves: 0.00,
    resources: 0.00,
    reserveChange: 0.00,
    proven: 0.39,
    probable: 0.48,
    total: 0.87,
    measured: 1.57,
    indicated: 2.44,
    grade: '0%',
    inferred: 2.44,
    totalResources: '0%',
  },
  {
    mineral: '铂矿',
    unit: '金属吨',
    reserves: 0.00,
    resources: 21.58,
    reserveChange: 21.58,
    proven: 113.92,
    probable: 233.43,
    total: 347.35,
    measured: 293.52,
    indicated: 640.87,
    grade: '3%',
    inferred: 640.70,
    totalResources: '0%',
  },
  {
    mineral: '钯矿',
    unit: '金属吨',
    reserves: 0.00,
    resources: 22.14,
    reserveChange: 22.14,
    proven: 94.02,
    probable: 154.34,
    total: 248.36,
    measured: 241.99,
    indicated: 490.35,
    grade: '5%',
    inferred: 490.42,
    totalResources: '0%',
  },
];


const financialData = [
  {
    year:2022,
    cash: 11955339296,
    currentAssets: 39262403933,
    totalAssets: 182313250403,
    currentLiabilities: 47035701043,
    totalLiabilities: 107716808927,
    equity: 74596441476,
    revenue: 171501338490,
    operatingProfit: 11239742530,
    totalProfit: 10846027174,
    netProfit: 8458038953,
    cashFlowFromOperations: 14268403423,
    interestBearingDebt: 73887432704,
    investedCapital: 164927979520,
    ebitda: 12902571008,
    netCashFlow: 15566723072
  },
  {
    year:2021,
    cash: 14221780252,
    currentAssets: 47064293441,
    totalAssets: 208594678123,
    currentLiabilities: 50302460681,
    totalLiabilities: 115697507579,
    equity: 92897170544,
    revenue: 225102488592,
    operatingProfit: 25086505191,
    totalProfit: 24793810492,
    netProfit: 19599638352,
    cashFlowFromOperations: 26072237601,
    interestBearingDebt: 78073741312,
    investedCapital: 186386055168,
    ebitda: 26905763840,
    netCashFlow: 27408664576
  },
  {
    year:2020,
    cash: 20243737052,
    currentAssets: 79644459532,
    totalAssets: 306044139470,
    currentLiabilities: 71169903836,
    totalLiabilities: 181588693965,
    equity: 124455445505,
    revenue: 270328998459,
    operatingProfit: 30945606018,
    totalProfit: 29992850973,
    netProfit: 24767210123,
    cashFlowFromOperations: 28678502360,
    interestBearingDebt: 124001714176,
    investedCapital: 267921342464,
    ebitda: 33437667328,
    netCashFlow: 34861969408
  },
  {
    year:2019,
    cash: 6225144800,
    currentAssets: 28594396116,
    totalAssets: 123830947219,
    currentLiabilities: 33362656029,
    totalLiabilities: 66751349155,
    equity: 57079598064,
    revenue: 136097978018,
    operatingProfit: 7242074162,
    totalProfit: 6974278766,
    netProfit: 5060904684,
    cashFlowFromOperations: 10665557013,
    interestBearingDebt: 46002446336,
    investedCapital: 111098912768,
    ebitda: 8902095872,
    netCashFlow: 10883657728
  },
  {
    year:2018,
    cash: 10089890808,
    currentAssets: 30448688235,
    totalAssets: 112879303842,
    currentLiabilities: 37223097530,
    totalLiabilities: 65605591140,
    equity: 47273712702,
    revenue: 105994246123,
    operatingProfit: 6181371066,
    totalProfit: 6130179782,
    netProfit: 4682676553,
    cashFlowFromOperations: 10233009701,
    interestBearingDebt: 47121137664,
    investedCapital: 101140709376,
    ebitda: 7706404352,
    netCashFlow: 10392547328
  }
];
const gptfinancialData = () => {
  state.chars = state.text.split('');
};

const gptprojectData = () =>{
  state2.chars = state.text.split('');
}
const mineralData = [
  {
    mineral: '铜',
    unit: '万吨',
    reserves: 3340,
    resources: 7456,
    equityReservesRatio: '82%',
  },
  {
    mineral: '金',
    unit: '吨',
    reserves: 1148,
    resources: 2998,
    equityReservesRatio: '37%',
  },
  {
    mineral: '锌（铅）',
    unit: '万吨',
    reserves: 470,
    resources: 1068,
    equityReservesRatio: '7%',
  },
  {
    mineral: '碳酸锂',
    unit: '万吨',
    reserves: 443,
    resources: 1347,
    equityReservesRatio: '28%',
  },
  {
    mineral: '银',
    unit: '吨',
    reserves: 1864,
    resources: 14739,
    equityReservesRatio: '3%',
  },
  {
    mineral: '钼',
    unit: '万吨',
    reserves: 160,
    resources: 306,
    equityReservesRatio: '27%',
  },
];


const imageUrl = ref('../../public/铜价.png');
const imageUrl2 = ref('../../public/矿区.png');
const imageUrl3 = ref('../../public/金价.png');
const imageUrl4 = ref('../../public/美国国债.png');
const imageUrl5 = ref('../../public/金矿位置.png');
const imageUrl6 = ref('../../public/分析师预测2.png');
const imageUrl7 = ref('../../public/分析师预测1.png');
</script>
<template>
    <div class = "container">
        <h1>紫金矿业分析</h1>
        <table>
            <tr>
                <td width="13%">企业名称</td>
                <td width="13%">紫金矿业集团股份有限公司</td>
                <td width="13%">成立日期</td>
                <td width="13%">2000-09-06</td>
            </tr>
            <tr>
                <td>注册地址</td>
                <td>上杭县紫金大道1号</td>
                <td>注册地址</td>
                <td>福建省福州市仓山区金山工业区</td>
            </tr>
            <tr>
                <td>注册资本</td>
                <td>263281.7224万元人民币</td>
                <td>法定代表人</td>
                <td>邹来昌</td>
            </tr>
            <tr>
                <td>经营范围包括</td>
                <td colspan = "3">矿产资源勘查；金矿采选；金冶炼；铜矿采选；铜冶炼；信息系统集成服务；信息技术咨询服务；珠宝首饰、工艺美术品、矿产品、机械设备、化工产品（不含危险化学品及易制毒化学品）的销售；水力发电；对采矿业、酒店业、建筑业的投资；对外贸易；普通货物道路运输活动；危险货物道路运输活动。铜矿金矿露天开采、铜矿地下开采；矿山工程技术、矿山机械、冶金专用设备研发；矿山机械、冶金专用设备制造；旅游饭店（限分支机构经营）。（依法须经批准的项目，经相关部门批准后方可开展经营活动）</td>
            </tr> 
        </table>

        <el-table :data="financialData" border style="width: 100%">
          <el-table-column prop="year" label="年份"  />
          <el-table-column prop="cash" label="货币资金"  />
          <el-table-column prop="currentAssets" label="流动资产合计" />
          <el-table-column prop="totalAssets" label="资产总计" />
          <el-table-column prop="currentLiabilities" label="流动负债合计" />
          <el-table-column prop="totalLiabilities" label="负债合计" />
          <el-table-column prop="equity" label="所有者权益合计" />
          <el-table-column prop="revenue" label="营业收入" />
          <el-table-column prop="operatingProfit" label="营业利润" />
          <el-table-column prop="totalProfit" label="利润总额" />
          <el-table-column prop="netProfit" label="净利润" />
          <el-table-column prop="cashFlowFromOperations" label="经营活动产生的现金流量净额" />
          <el-table-column prop="interestBearingDebt" label="有息负债" />
          <el-table-column prop="investedCapital" label="投入资本" />
          <el-table-column prop="ebitda" label="息税前利润" />
          <el-table-column prop="netCashFlow" label="应得现金净流量" />
        </el-table>
        <el-button type="primary" style="display: block; margin-left: auto; margin-right: auto;"@click="gptfinancialData">gpt分析</el-button>
        <div>
        <span v-for="(char, index) in state.chars" :key="index" class="char-animation" :style="{ '--delay': index * 0.05 + 's' }" v-html="char"></span>
        </div>
      <div id="main" style="width: 1200px;height:400px;"></div>
      <div id="dayprice" style="width: 1200px;height:400px;"></div>
      <div id="category" style="width: 1200px;height:400px;"></div>

      <p>铜和金是公司主要的毛利贡献来源，2023年公司铜相关业务
        毛利占比达到 47.19%，金占比达到 25.35%，锌铅占比为 3.38%，
        白银铁矿等其他矿种占比 24.08%。2023 年，铜金价格保持高位，
        尽管由于人民币汇率贬值、入选品位下降、燃料、电力成本等价
        格上涨、运输距离增加，以及低品位矿山产量提升等原因拉高了
        生产成本，但是公司铜精矿毛利率达到59.52%，矿山产金毛利率
        达到45.07%，依旧保持了出色的盈利能力。</p>
      <div id="gdp" style="width: 1200px;height:400px;"></div>
      <p>年度增长率分析：
      2018年：GDP增长率为12.87%，这表明在2018年中国的经济增长较为强劲。
      2019年和2020年：增长率分别为2.77%和2.86%，相对平稳，显示出经济增速放缓的趋势。
      2021年：增长率达到21.33%，这是一个显著的跳升。可能的原因包括2020年受COVID-19疫情影响经济基数较低，而2021年经济快速复苏。
      2022年：增长率降至0.80%，显示出经济增速明显放缓，可能受到疫情持续影响和其他经济因素的制约。
      总体增长趋势：
      从总体来看，GDP总量在逐年增加，但年度增长率有明显波动。尤其是2021年出现了异常高的增长率，而2022年则大幅回落</p>


      <p>铜和金是公司主要的毛利贡献来源，2023年公司铜相关业务
        毛利占比达到 47.19%，金占比达到 25.35%，锌铅占比为 3.38%，
        白银铁矿等其他矿种占比 24.08%。2023 年，铜金价格保持高位，
        尽管由于人民币汇率贬值、入选品位下降、燃料、电力成本等价
        格上涨、运输距离增加，以及低品位矿山产量提升等原因拉高了
        生产成本，但是公司铜精矿毛利率达到59.52%，矿山产金毛利率
        达到45.07%，依旧保持了出色的盈利能力。</p>
      <el-table :data="tableData" border style="width: 600%">
        <el-table-column prop="mineral" label="矿种" width="180" />
        <el-table-column prop="unit" label="单位" width="180" />
        <el-table-column prop="reserves" label="证实" />
        <el-table-column prop="resources" label="可信" />
        <el-table-column prop="reserveChange" label="合计" />
        <el-table-column prop="proven" label="探明" />
        <el-table-column prop="probable" label="控制" />
        <el-table-column prop="total" label="控制+控明" />
        <el-table-column prop="measured" label="推断" />
        <el-table-column prop="indicated" label="合计" />
        <el-table-column prop="grade" label="储量/资源量" />
        <el-table-column prop="inferred" label="2022年资源量" />
        <el-table-column prop="totalResources" label="年变化率" />
      </el-table>

      <p>公司资源量和储量对我国矿产资源的自主性至关重要</p>
      <el-table :data="mineralData" border style="width: 600%">
        <el-table-column prop="mineral" label="矿种" width="180" />
        <el-table-column prop="unit" label="单位" width="180" />
        <el-table-column prop="reserves" label="储量" />
        <el-table-column prop="resources" label="资源量" />
        <el-table-column prop="equityReservesRatio" label="权益储量/中国储量" />
        <p>我们可以看到光铜一项其权益总量占比中国储量便是重中之重</p>
        <!-- <el-table-column prop="proven" label="探明" />
        <el-table-column prop="probable" label="控制" /> -->
      </el-table>
      <h1>铜板块</h1>
      <p> 铜价：供给扰动不断，铜价维持高位 
        铜供需结构逐渐好转提供上涨的良好基础。从23年末开始，
        铜供给端的扰动不断，首先是23年11月末，第一量子旗下的
        Cobre Panama开采合同被认为违宪，该矿年产量达35万吨，占
        全球铜产量的1.5%；同时英美资源将2024年的铜产量指引从91
        万—100万吨下调至73万—79万吨，其中智利和秘鲁铜矿指引分
        别下调约13万吨和6.5万吨；2024年3月，Codelco旗下的
        Radomiro Tomic 铜矿由于一名工人意外身亡而发生罢工事件
        （2023年Radomiro Tomic铜产量为31.5万吨）；2024年4月，
        赞比亚国家电力公司（Zesco）警告或将削减对一些矿业公司的电
        力供应，此举可能干扰这一非洲第二大铜生产国的生产。综上，
        2024年全球铜供给可能会收缩60万吨以上。我们认为由于供给
        收缩带来的供需结构好转给铜价上行打好了基本盘。 
        24 年降息确定性增强，金融环境逐步好转。北京时间2024
        年3月21日，美联储FOMC会议将联邦基金利率目标区间维持
        在5.25%至5.5%之间不变，符合市场预期。这是美联储自2023
        年9月以来连续第五次维持利率不变。在2024年的降息节奏上，
        3月FMOC发布的点阵图仍暗示今年降息3次，一致预期的利率
        区间为4.5-4.75%。且在对于经济增速的预测上给出了正向的预期
        引导，预计2024年的实际GDP增长率为2.0-2.4%，较大幅度的
        高于2023年12月FOMC给出的预测（1.2-1.7%），同时在通胀
        预期上，24年PCE数据预期为2.3-2.7%，高于2023年12月预
        计的2.2-2.5%。我们认为24年降息三次的确定性提升，在金融属
        性方面对铜的压力有所减缓。</p>
        <img :src="imageUrl" alt="铜价">
        <p>公司世界级项目逐渐投入生产</p>
        <p>世界级项目逐渐投产，公司产量增速可观 
          2023年，公司矿产铜实现历史性重大突破，成为中国及亚洲
          唯一矿产铜产量破百万吨大关矿企，位居全球前五。2023年，公
          司矿山产铜100.73万吨，同比增长11.13%(上年同期：90.64万
          吨)；冶炼产铜72.46万吨，同比增长4.88%(上年同期：69.08万
          吨)。根据中国有色金属工业协会数据，2023年中国实现矿山产铜
          161.9 万吨，公司矿山产铜相当于中国总量的62%左右。 
          公司铜板块旗舰矿山位于塞尔维亚、刚果（金）等海外国家，
          国内在西藏、福建、黑龙江等多地都有布局。 
          塞尔维亚：丘卡卢-佩吉铜金矿、博尔铜矿。 
          公司在塞尔维亚持有丘卡卢-佩吉铜金矿、博尔铜矿两宗世界
          级铜矿山，总资源量铜约3,083万吨、金827吨，2023年合计实
          现矿产铜23.89万吨，成为欧洲第二大矿山产铜企业；矿产金
          6.94 吨。2024年计划合计矿产铜26.7万吨、金7.1吨。丘卡卢
          佩吉下部矿带采用自然崩落法大规模开发已完成预可研设计，正
          加快证照办理；博尔铜矿JM矿填充法变更为崩落法采矿加快推进；
          至2025年，塞尔维亚两大铜矿将全面完成改扩建工程，届时铜矿
          产能有望达到30万吨/年。 
          刚果（金）：卡莫阿铜矿、科卢韦齐铜（钴）矿。 
          卡莫阿铜矿资源量约4,266万吨；2023年矿产铜39.4万吨
          （100%权益），2024年计划矿产铜50.7万吨（100%权益）；项
          目一、二期联合改扩能于2023年第一季度建成投产，年产能达到
          45万吨；三期采选工程预计于2024年第二季度建成投产，年矿
          石处理总量达到1,420万吨，届时产能将提升至60万吨铜以上；
          年产50万吨阳极铜冶炼厂计划于2024年第四季度建成投产；公
          司还在研究新的扩产建设计划。科卢韦齐铜（钴）矿资源量铜251
          万吨、钴3.80万吨，稳健运营多年，2023年矿产铜12.7万吨、
          钴2,306吨，2024年计划矿产铜12.8万吨、钴2,305吨。
        
          西藏：巨龙铜矿、朱诺铜矿、玉龙铜矿、谢通门铜金矿。 
          在中国西藏持有巨龙铜矿、朱诺铜矿、玉龙铜矿、谢通门铜
          金矿及紫隆矿业投资平台；西藏为公司在中国境内重要资源储备
          和投资发展区域。巨龙铜业（含巨龙铜矿及知不拉铜矿）拥有资
          源量铜1,927万吨、银1.06万吨、钼120万吨；2023年矿产铜
          15.44 万吨、钼5,596吨、金633千克、银105.7吨；2024年计
          划矿产铜16.6万吨；项目二期改扩建工程获有关部门核准，2024
          年将全面开工建设，计划2025年底建成投产，达产后整体年采选
          矿石量将超过1亿吨，年矿产铜将达30-35万吨，将成为国内采
          选规模最大、全球本世纪投产的采选规模最大的单体铜矿山；项
          目未来将进一步规划三期工程，若获得批准，最终可望实现年采
          选矿石量约2亿吨规模，成为全球采选规模最大品位最低、海拔
          最高的铜矿山。朱诺铜矿拥有资源量约铜294万吨；规划建成达
          产后形成年采选规模为2,400万吨、矿产铜9.9万吨铜矿山。玉龙
          铜矿为国内第二大单体铜矿，公司为该项目第二大股东，项目450
          万吨/年改扩建工程于2023年11月建成投产，矿产铜产量将提升
          至15万吨。谢通门铜金矿正加快推进前期工作。紫隆矿业持有并
          长期跟踪一批潜力项目。 
          早期骨干铜矿：紫金山铜矿、多宝山铜矿、阿舍勒铜矿。 
          紫金山铜矿、多宝山铜矿、阿舍勒铜矿仍是国内的骨干铜矿
          山，运营成熟，管理效率高，成本低；其中多宝山铜山铜矿Ⅱ号
          矿体采矿工程正加速推进，计划2024年二季度试生产；紫金山外
          围罗卜岭斑岩铜矿采矿研究正在推进，争取尽快立项开工建设，
          紫金山及外围正在开展新一轮地质找矿工作。
          </p>
          <img :src="imageUrl2" alt="项目"width="1000">
        <el-button type="primary" style="display: block; margin-left: auto; margin-right: auto;"@click="gptprojectData">gpt分析</el-button>
          <span v-for="(char, index) in state2.chars" :key="index" class="char-animation" :style="{ '--delay': index * 0.05 + 's' }" v-html="char"></span>

          <h1>金板块</h1>
          <p>金价：二次通胀与衰退预期交织，黄金大时代来临 
            我们认为，长期视角而言，赤字率根本上决定了黄金价格，
            黄金在央行眼中是一种特殊的资产，类似于非主权货币的存在。
            我们认为，美国政府的赤字率在未来或难有下降的趋势，赤字率
            影响一国货币的信用，从而使得央行更多地把黄金作为储备资产。 
            我们认为美国赤字率难以下降的原因如下：1、高利率环境下，
            美债发行的成本巨大。2、地缘政治的不稳定，可能会增加其军费
            支出。3、美国在高利率环境下经济软着陆的可能性不大，或二次
            通胀，或衰退。如果衰退，财政自然有托底经济压力，如果二次
            通胀，政府也必须进行相应的财政补偿。总之，我们认为美国未
            来赤字率的走势可能会加速上行，黄金未来可能进入长牛。</p>
            <img :src="imageUrl3" alt="黄金"width="1000">
            <img :src="imageUrl4" alt="国债"width="1000">
            <img :src="imageUrl5" alt="国债"width="1000">
            <p>大洋洲：巴新波格拉金矿、澳大利亚诺顿金田。 
              波格拉金矿为全球十大黄金矿山之一、巴新第二大金矿，拥
              有资源量金417吨；项目2020年4月因矿权到期停产，经谈判协
              商于2023年12月22日全面复产，根据项目最新规划，矿山剩余
              寿命超过20年，复产达产后平均年矿产金21吨，归属公司权益
              年矿产金约5吨。诺顿金田拥有近1000平方公里高潜力矿权区域，
              现有资源量金356吨；2023年实现矿产金6.7吨；2024年计划矿
              产金8.0吨。 
              中亚：塔吉克斯坦泽拉夫尚、吉尔吉斯斯坦奥同克。 
              泽拉夫尚为塔吉克斯坦最大的黄金生产企业，2023年末新建
              成500吨/日加压氧化项目；现有资源量金97吨，2023年实现矿
              产金5.9吨，2024年计划矿产金5.8吨。奥同克左岸金矿为吉尔
              吉斯斯坦第三大金矿，现有资源量金44吨，2023年实现矿产金
              4.1 吨，2024年计划矿产金3.7吨。</p>
              <h1>分析师预测</h1>
              <img :src="imageUrl6" alt="分析师预测2"width="1000">
              <img :src="imageUrl7" alt="分析师预测1"width="1000">

    </div>
</template>

<style scoped>
.container {
  padding: 120px 230px 0 230px;
}
table {
  border-collapse: collapse;
}

table td, table th {
  border: 1px solid black;
}
.char-animation {
  opacity: 0;
  animation: charFadeIn 0.5s forwards;
  animation-delay: var(--delay);
}

@keyframes charFadeIn {
  from {
    opacity: 0;
    transform: translateY(20);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

</style>