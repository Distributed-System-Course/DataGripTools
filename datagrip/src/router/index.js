import Vue from 'vue'
import Router from 'vue-router'
import AppIndex from '../components/home/AppIndex'
import Login from '../components/Login'
import Home from '../components/Home'
import Tutorial from '../components/home/Tutorial'
import Query from '../components/home/Query'
import ShowPlace from '../components/home/ShowPlace'
import Pie from '../components/home/Pie'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home,
      // home页面并不需要被访问
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/tutorial',
          name: 'Tutorial',
          component: Tutorial,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/query',
          name: 'Query',
          component: Query,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/linediagram',
          name: 'ShowPlace',
          component: ShowPlace,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/piediagram',
          name: 'Pie',
          component: Pie,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
