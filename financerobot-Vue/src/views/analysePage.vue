<script setup lang="ts">
import { ref } from 'vue';
import searchBar from '../components/searchBar.vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const itemValue = route.query
console.log(itemValue.value);
try {
    const response = await axios({
            method: 'post',
            url: '/api/searchStockclick',
            data: {
                stkcd: itemValue.value,
            }
        });
        console.log(response.data); // 处理响应数据
    } catch (error) {
        console.error(error); // 处理错误情况
    }
</script>

<template>
  <div>
    <searchBar/>
  </div>
</template>

<style scoped>
</style>
