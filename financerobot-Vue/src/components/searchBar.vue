<script setup lang="ts">
import { onMounted,ref } from 'vue'
import { Search } from '@element-plus/icons-vue'
import axios from 'axios'
import { useRouter } from 'vue-router';
const router = useRouter();
const javaResponse = ref('')
const input = ref('')
const state = ref('')
const links = ref<LinkItem[]>([])
const click = async () => {
    try {
        const response = await axios({
            method: 'post',
            url: '/api/searchStockclick',
            data: {
                stk: input.value,
            }
        });
        // console.log(response.data); // 处理响应数据
        javaResponse.value = response.data
    } catch (error) {
        // console.error(error); // 处理错误情况
    }
}
interface LinkItem {
  value: string
}
const loadAll = () => {
  return [
  ]
}
const querySearchAsync = (queryString: string, cb: (arg: any) => void) => {
  links.value = [];
  calculate(queryString);
  const results =  links.value
  cb(results)
}
async function calculate(newValue:String) {
    try {
        const response = await axios({
            method: 'post',
            url: '/api/searchStock',
            data: {
                stk: newValue, // 使用函数参数而不是直接访问input.value
            }
        });
        // console.log(response.data); // 处理响应数据
        javaResponse.value = response.data; // 假设javaResponse是一个响应式引用
        if (typeof javaResponse.value === 'object' && javaResponse.value !== null) {
            Object.entries(javaResponse.value).forEach(([company, code]) => {
                // 格式化字符串为 "公司名称 代码" 的格式
                const formattedString = `${company} ${code}`;
                // 将格式化后的字符串添加到 links.value 数组中
                links.value.push({ value: formattedString });
            });
        }
        else{
            // console.log("no data")
            links.value = []
        }
    } catch (error) {
        // console.error(error); // 处理错误情况
    }
}
const handleSelect = (item: Record<string, any>) => {
  // console.log(item)
  // 检查item.value的类型
  const itemValue = item.value.split(' ')[1];
  router.push({ path: '/analyse', query: itemValue }).then(() => {
    router.go(0);
  });
}
onMounted(() => {
  links.value = loadAll()
})
</script>

<template>
  <div class="home">
    <el-autocomplete
    v-model="state"
    :fetch-suggestions="querySearchAsync"
    placeholder="Please input"
    @select="handleSelect"
    style="width: 600px;"
    />
    <el-button type="primary" :icon="Search" @click="click" circle />
  </div>
</template>
<style scoped>
.home {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}
</style>
