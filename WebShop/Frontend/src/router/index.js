import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '@/views/Login.vue'
import WebShop from '@/views/WebShop.vue'
import ChocolateUpdateView from '@/views/ChocolateView.vue'
<<<<<<< HEAD
import ChocolateAddView from '@/views/ChocolateAddView.vue'

=======
>>>>>>> Anastasija-features

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/webshop',
      name: 'webshop',
      component: WebShop
    },
    {
      path: '/chocolate:chocolateId',
      name: 'ChocolateUpdate',
      component: ChocolateUpdateView
    },
    {
<<<<<<< HEAD
      path: '/chocolateAdd',
      name: 'ChocolateAdd',
      component: ChocolateAddView
    },
    {
=======
>>>>>>> Anastasija-features
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    }
  ]
})

export default router
