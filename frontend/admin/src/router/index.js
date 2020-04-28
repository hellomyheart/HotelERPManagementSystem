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
  },

  {
    path: '/example',
    component: Layout,
    redirect: '/example/table',
    name: 'Example',
    meta: { title: 'Example', icon: 'example' },
    children: [
      {
        path: 'table',
        name: 'Table',
        component: () => import('@/views/table/index'),
        meta: { title: 'Table', icon: 'table' }
      },
      {
        path: 'tree',
        name: 'Tree',
        component: () => import('@/views/tree/index'),
        meta: { title: 'Tree', icon: 'tree' }
      }
    ]
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

  {
    path: '/train/content',
    component: Layout,
    redirect: '/train/content/info',
    name: 'TrainContent',
    meta: { title: '培训内容管理', icon: 'user' },
    children: [
      {
        path: 'info',
        name: 'TrainContentInfo',
        component: () => import('@/views/train/content/info'),
        meta: { title: '培训内容详情', icon: 'user' }
      },
      {
        path: 'edit',
        name: 'TrainContentEdit',
        hidden: true,
        component: () => import('@/views/train/content/edit'),
        meta: { title: '修改培训内容', icon: 'user' }
      },
      {
        path: 'add',
        name: 'TrainContentAdd',
        component: () => import('@/views/train/content/add'),
        meta: { title: '添加培训内容', icon: 'user' }
      }
    ]
  },

  {
    path: '/train/training',
    component: Layout,
    redirect: '/train/training/info',
    name: 'Training',
    meta: { title: '培训管理', icon: 'user' },
    children: [
      {
        path: 'info',
        name: 'Training',
        component: () => import('@/views/train/training/info'),
        meta: { title: '培训详情', icon: 'user' }
      },
      {
        path: 'add',
        name: 'TrainingAdd',
        component: () => import('@/views/train/training/add'),
        meta: { title: '添加培训', icon: 'user' }
      }
    ]
  },

  {
    path: '/shift/type',
    component: Layout,
    redirect: '/shift/type/info',
    name: 'ShiftType',
    meta: { title: '排班分类管理', icon: 'user' },
    children: [
      {
        path: 'info',
        name: 'ShiftTypeInfo',
        component: () => import('@/views/shift/type/info'),
        meta: { title: '排班分类详情', icon: 'user' }
      },
      {
        path: 'edit',
        name: 'ShiftTypeEdit',
        hidden: true,
        component: () => import('@/views/shift/type/edit'),
        meta: { title: '修改排班分类', icon: 'user' }
      },
      {
        path: 'add',
        name: 'ShiftTypeAdd',
        component: () => import('@/views/shift/type/add'),
        meta: { title: '添加排班分类', icon: 'user' }
      }
    ]
  },

  {
    path: '/shift/content',
    component: Layout,
    redirect: '/shift/content/info',
    name: 'ShiftContent',
    meta: { title: '排班内容管理', icon: 'user' },
    children: [
      {
        path: 'info',
        name: 'ShiftContentInfo',
        component: () => import('@/views/shift/content/info'),
        meta: { title: '排班内容详情', icon: 'user' }
      },
      {
        path: 'edit',
        name: 'ShiftContentEdit',
        hidden: true,
        component: () => import('@/views/shift/content/edit'),
        meta: { title: '修改排班内容', icon: 'user' }
      },
      {
        path: 'add',
        name: 'ShiftContentAdd',
        component: () => import('@/views/shift/content/add'),
        meta: { title: '添加排班内容', icon: 'user' }
      }
    ]
  },

  {
    path: '/shift/employee',
    component: Layout,
    redirect: '/shift/employee/info',
    name: 'ShiftEmployee',
    meta: { title: '职工排班管理', icon: 'user' },
    children: [
      {
        path: 'info',
        name: 'ShiftEmployeeInfo',
        component: () => import('@/views/shift/employee/info'),
        meta: { title: '职工排班详情', icon: 'user' }
      },
      {
        path: 'edit',
        name: 'ShiftEmployeeEdit',
        hidden: true,
        component: () => import('@/views/shift/employee/edit'),
        meta: { title: '修改职工排班', icon: 'user' }
      },
      {
        path: 'add',
        name: 'ShiftEmployeeAdd',
        component: () => import('@/views/shift/employee/add'),
        meta: { title: '添加职工排班', icon: 'user' }
      }
    ]
  },

  {
    path: '/cash/flow',
    component: Layout,
    redirect: '/cash/flow/info',
    name: 'CashFlow',
    meta: { title: '资金管理', icon: 'user' },
    children: [
      {
        path: 'info',
        name: 'CashFlowInfo',
        component: () => import('@/views/cash/flow/info'),
        meta: { title: '资金流动详情', icon: 'user' }
      },
      {
        path: 'add',
        name: 'CashFlowAdd',
        component: () => import('@/views/cash/flow/add'),
        meta: { title: '添加资金流动', icon: 'user' }
      }
    ]
  },

  {
    path: '/budget/apply',
    component: Layout,
    redirect: '/budget/apply/info',
    name: 'BudgetApply',
    meta: { title: '预算管理', icon: 'user' },
    children: [
      {
        path: 'info',
        name: 'BudgetApplyInfo',
        component: () => import('@/views/budget/apply/info'),
        meta: { title: '资金申请详情', icon: 'user' }
      },
      {
        path: 'edit',
        name: 'BudgetApplyEdit',
        hidden: true,
        component: () => import('@/views/budget/apply/edit'),
        meta: { title: '修改资金申请', icon: 'user' }
      },
      {
        path: 'add',
        name: 'BudgetApplyAdd',
        component: () => import('@/views/budget/apply/add'),
        meta: { title: '资金申请', icon: 'user' }
      }
    ]
  },

  {
    path: '/facility/apply',
    component: Layout,
    redirect: '/facility/apply/info',
    name: 'FacilityApply',
    meta: { title: '设备管理', icon: 'user' },
    children: [
      {
        path: 'info',
        name: 'FacilityApplyInfo',
        component: () => import('@/views/facility/apply/info'),
        meta: { title: '设备申请信息', icon: 'user' }
      },
      {
        path: 'add',
        name: 'FacilityApplyAdd',
        component: () => import('@/views/facility/apply/add'),
        meta: { title: '设备申请', icon: 'user' }
      }
    ]
  },

  {
    path: '/merchandise/inventory',
    component: Layout,
    redirect: '/merchandise/inventory/info',
    name: 'MerchandiseInventory',
    meta: { title: '商品库存管理', icon: 'user' },
    children: [
      {
        path: 'info',
        name: 'MerchandiseInventoryInfo',
        component: () => import('@/views/merchandise/inventory/info'),
        meta: { title: '商品库存信息', icon: 'user' }
      },
      {
        path: 'Edit',
        hidden: true,
        name: 'MerchandiseInventoryEdit',
        component: () => import('@/views/merchandise/inventory/edit'),
        meta: { title: '修改商品库存', icon: 'user' }
      }
    ]
  },

  {
    path: '/cleaning/inventory',
    component: Layout,
    redirect: '/cleaning/inventory/info',
    name: 'CleaningInventory',
    meta: { title: '保洁商品库存管理', icon: 'user' },
    children: [
      {
        path: 'info',
        name: 'CleaningInventoryInfo',
        component: () => import('@/views/cleaning/inventory/info'),
        meta: { title: '保洁商品库存信息', icon: 'user' }
      },
      {
        path: 'Edit',
        hidden: true,
        name: 'CleaningInventoryEdit',
        component: () => import('@/views/cleaning/inventory/edit'),
        meta: { title: '修改保洁商品库存', icon: 'user' }
      }
    ]
  },

  {
    path: '/restaurant/inventory',
    component: Layout,
    redirect: '/restaurant/inventory/info',
    name: 'RestaurantInventory',
    meta: { title: '酒店食材库存管理', icon: 'user' },
    children: [
      {
        path: 'info',
        name: 'RestaurantInventoryInfo',
        component: () => import('@/views/restaurant/inventory/info'),
        meta: { title: '酒店食材库存信息', icon: 'user' }
      },
      {
        path: 'Edit',
        hidden: true,
        name: 'RestaurantInventoryEdit',
        component: () => import('@/views/restaurant/inventory/edit'),
        meta: { title: '修改酒店食材库存', icon: 'user' }
      }
    ]
  },


  {
    path: '/example',
    component: Layout,
    redirect: '/example/table',
    name: 'Example',
    meta: { title: 'Example', icon: 'example' },
    children: [
      {
        path: 'table',
        name: 'Table',
        component: () => import('@/views/table/index'),
        meta: { title: 'Table', icon: 'table' }
      },
      {
        path: 'tree',
        name: 'Tree',
        component: () => import('@/views/tree/index'),
        meta: { title: 'Tree', icon: 'tree' }
      }
    ]
  },
  {
    path: '/form',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'Form',
        component: () => import('@/views/form/index'),
        meta: { title: 'Form', icon: 'form' }
      }
    ]
  },

  {
    path: '/nested',
    component: Layout,
    redirect: '/nested/menu1',
    name: 'Nested',
    meta: {
      title: 'Nested',
      icon: 'nested'
    },
    children: [
      {
        path: 'menu1',
        component: () => import('@/views/nested/menu1/index'), // Parent router-view
        name: 'Menu1',
        meta: { title: 'Menu1' },
        children: [
          {
            path: 'menu1-1',
            component: () => import('@/views/nested/menu1/menu1-1'),
            name: 'Menu1-1',
            meta: { title: 'Menu1-1' }
          },
          {
            path: 'menu1-2',
            component: () => import('@/views/nested/menu1/menu1-2'),
            name: 'Menu1-2',
            meta: { title: 'Menu1-2' },
            children: [
              {
                path: 'menu1-2-1',
                component: () => import('@/views/nested/menu1/menu1-2/menu1-2-1'),
                name: 'Menu1-2-1',
                meta: { title: 'Menu1-2-1' }
              },
              {
                path: 'menu1-2-2',
                component: () => import('@/views/nested/menu1/menu1-2/menu1-2-2'),
                name: 'Menu1-2-2',
                meta: { title: 'Menu1-2-2' }
              }
            ]
          },
          {
            path: 'menu1-3',
            component: () => import('@/views/nested/menu1/menu1-3'),
            name: 'Menu1-3',
            meta: { title: 'Menu1-3' }
          }
        ]
      },
      {
        path: 'menu2',
        component: () => import('@/views/nested/menu2/index'),
        meta: { title: 'menu2' }
      }
    ]
  },

  {
    path: 'external-link',
    component: Layout,
    children: [
      {
        path: 'https://panjiachen.github.io/vue-element-admin-site/#/',
        meta: { title: 'External Link', icon: 'link' }
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
