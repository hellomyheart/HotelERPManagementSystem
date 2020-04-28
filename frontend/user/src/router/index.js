import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/reg',
    component: () => import('@/views/reg/index'),
    // hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: 'Dashboard', icon: 'dashboard' }
    }]
  }
]

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [

  {
    path: '/profile',
    component: Layout,
    redirect: '/profile/info',
    name: 'Profile',
    meta: { title: '个人信息', icon: 'user', roles: ['USER'] },
    children: [
      {
        path: 'info',
        name: 'ProfileInfo',
        component: () => import('@/views/profile/info'),
        meta: { title: '修改信息', icon: 'user' }
      },
      {
        path: 'password',
        name: 'ProfilePassword',
        component: () => import('@/views/profile/password'),
        meta: { title: '修改密码', icon: 'user' }
      },
      {
        path: 'icon',
        name: 'ProfileIcon',
        component: () => import('@/views/profile/icon'),
        meta: { title: '修改头像', icon: 'user' }
      }
    ]
  },

  {
    path: '/organization/department',
    component: Layout,
    redirect: '/organization/department/info',
    name: 'department',
    meta: { title: '部门管理', icon: 'user', roles: ['Department'] },
    children: [
      {
        path: 'info',
        name: 'DepartmentInfo',
        component: () => import('@/views/organization/department/info'),
        meta: { title: '部门详情', icon: 'user' }
      },
      {
        path: 'edit',
        name: 'DepartmentEdit',
        hidden: true,
        component: () => import('@/views/organization/department/edit'),
        meta: { title: '修改部门', icon: 'user' }
      },
      {
        path: 'add',
        name: 'DepartmentAdd',
        component: () => import('@/views/organization/department/add'),
        meta: { title: '添加部门', icon: 'user' }
      }
    ]
  },

  {
    path: '/organization/position',
    component: Layout,
    redirect: '/organization/position/info',
    name: 'Position',
    meta: { title: '职位管理', icon: 'user', roles: ['Position'] },
    children: [
      {
        path: 'info',
        name: 'PositionInfo',
        component: () => import('@/views/organization/position/info'),
        meta: { title: '职位详情', icon: 'user' }
      },
      {
        path: 'edit',
        name: 'PositionEdit',
        hidden: true,
        component: () => import('@/views/organization/position/edit'),
        meta: { title: '修改职位', icon: 'user' }
      },
      {
        path: 'add',
        name: 'PositionAdd',
        component: () => import('@/views/organization/position/add'),
        meta: { title: '添加职位', icon: 'user' }
      }
    ]
  },

  {
    path: '/organization/employee',
    component: Layout,
    redirect: '/organization/employee/info',
    name: 'Employee',
    meta: { title: '职工管理', icon: 'user' },
    children: [
      {
        path: 'info',
        name: 'EmployeeInfo',
        component: () => import('@/views/organization/employee/info'),
        meta: { title: '职工详情', icon: 'user' }
      },
      {
        path: 'edit',
        name: 'EmployeeEdit',
        hidden: true,
        component: () => import('@/views/organization/employee/edit'),
        meta: { title: '修改职工', icon: 'user' }
      },
      {
        path: 'add',
        name: 'EmployeeAdd',
        component: () => import('@/views/organization/employee/add'),
        meta: { title: '添加职工', icon: 'user' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
