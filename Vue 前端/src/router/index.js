import Vue from 'vue'
import Router from 'vue-router'
import AppIndex from '../components/home/AppIndex'
import Login from '../components/Login'
import Home from '../components/Home'
import Tutorial from '../components/home/Tutorial'
import Query from '../components/home/Query'
import PieYear from '../components/home/PieDiag/PieYear'
import LineDiagYear from '../components/home/LineDiag/LineDiagYear'
import LineDiagMonth from '../components/home/LineDiag/LineDiagMonth'
import LineDiagDay from '../components/home/LineDiag/LineDiagDay'
import PieMouth from '../components/home/PieDiag/PieMouth'
import PieDay from '../components/home/PieDiag/PieDay'

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
          path: '/query',
          name: 'Query',
          component: Query,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/linediagyear',
          name: 'LineDiagYear',
          component: LineDiagYear,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/linediagmonth',
          name: 'LineDiagMonth',
          component: LineDiagMonth,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/linediagday',
          name: 'LineDiagDay',
          component: LineDiagDay,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/piediagyear',
          name: 'PieYear',
          component: PieYear,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/piediagmonth',
          name: 'PieMonth',
          component: PieMouth,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/piediagday',
          name: 'PieDay',
          component: PieDay,
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
    },
    {
      path: '/tutorial',
      name: 'Tutorial',
      component: Tutorial,
      meta: {
        requireAuth: true
      }
    }
  ]
})
