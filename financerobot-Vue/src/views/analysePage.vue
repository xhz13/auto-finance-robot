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
}

let myChart;
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
  interface cash {
    value: number
    year: string
  }
  let cashArray: cash[] =  [
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
  // console.log(responsedataArray);

  response.data.forEach((item: any) => {
      let cashItem: cash = {
      value: item.cash,
      year: item.year
    };
    if(item.year=='2018'){
      cashArray[0]=cashItem;
    }
    if(item.year=='2019'){
      cashArray[1]=cashItem;
    }
    if(item.year=='2020'){
      cashArray[2]=cashItem;
    }
    if(item.year=='2021'){
      cashArray[3]=cashItem;
    }
    if(item.year=='2022'){
      cashArray[4]=cashItem;
    }
  });


  myChart = echarts.init(document.getElementById('main'));
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
      name: '金额'  // 添加y轴名称
    }
    ],
    series: [
      {
        type: 'bar',
        data: [cashArray[0].value, cashArray[1].value, cashArray[2].value, cashArray[3].value, cashArray[4].value]
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
});


</script>

<template>
  <div>
  <searchBar/>
  <div id="main" style="width:1000px;height:400px"></div>
  <h1>企业情况</h1>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="year" label="年份" />
    <el-table-column prop="cash" label="货币资金" />
    <el-table-column prop="ebit" label="EBIT" />
    <el-table-column prop="eva" label="应得现金净流量" />
    <el-table-column prop="grossprofit" label="毛利润" />
    <el-table-column prop="intLiab" label="有息负债" />
    <el-table-column prop="invCap" label="投入资本" />
    <el-table-column prop="netProf" label="税后利润" />
    <el-table-column prop="nocfnote" label="经营活动产生的现金流量净额" />
    <el-table-column prop="opProf" label="营业利润" />
    <el-table-column prop="opRev" label="营业收入" />
    <el-table-column prop="totAss" label="总资产" />
    <el-table-column prop="totCurLia" label="流动负债" />
    <el-table-column prop="totNCurrAss" label="流动资产" />
    <el-table-column prop="totProf" label="税前利润" />
    <el-table-column prop="totShareEquit" label="所有者权益(权益资本)" />
  </el-table>
  </div>
</template>


<style scoped>
</style>
