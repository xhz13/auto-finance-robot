import { createRouter, createWebHistory } from 'vue-router'
import homePage from '../views/homePage.vue'
import analysePage from '../views/analysePage.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'homePage',
      component: homePage
    },
    {
      path: '/analyse',
      name: 'analysePage',
      component: analysePage
    }
  ]
})

export default router
