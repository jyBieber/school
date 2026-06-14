import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import errandsregister from '@/views/errandsregister'
import center from '@/views/center'

import users from '@/views/modules/users/list'
import dictionary from '@/views/modules/dictionary/list'
import orderreceiving from '@/views/modules/orderreceiving/list'
import news from '@/views/modules/news/list'
import task from '@/views/modules/task/list'
import complaint from '@/views/modules/complaint/list'
import yonghu from '@/views/modules/yonghu/list'
import errands from '@/views/modules/errands/list'
import dictionaryOrderreceivingStatus from '@/views/modules/dictionaryOrderreceivingStatus/list'
// import dictionaryNews from '@/views/modules/dictionaryNews/list'
// import dictionaryTask from '@/views/modules/dictionaryTask/list'
import dictionaryTaskStatus from '@/views/modules/dictionaryTaskStatus/list'
import dictionarySex from '@/views/modules/dictionarySex/list'
import dictionaryComplaint from '@/views/modules/dictionaryComplaint/list'
import dictionaryComplaintYesno from '@/views/modules/dictionaryComplaintYesno/list'





//2.配置路由 注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
// 这里不设置值，是把main作为默认页面
        path: '/',
        name: '首页',
        component: Home,
        meta: {icon:'', title:'center'}
    }, {
        path: '/updatePassword',
        name: '修改密码',
        component: UpdatePassword,
        meta: {icon:'', title:'updatePassword'}
    }, {
        path: '/pay',
        name: '支付',
        component: pay,
        meta: {icon:'', title:'pay'}
    }, {
        path: '/center',
        name: '个人信息',
        component: center,
        meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
    },{
            path: '/dictionaryOrderreceivingStatus',
            name: '订单状态',
            component: dictionaryOrderreceivingStatus
        }
// ,{
// path: '/dictionaryNews',
// name: '公告类型',
// component: dictionaryNews
// }
// ,{
// path: '/dictionaryTask',
// name: '任务类型',
// component: dictionaryTask
// }
        ,{
            path: '/dictionaryTaskStatus',
            name: '任务状态',
            component: dictionaryTaskStatus
        }
        ,{
            path: '/dictionarySex',
            name: '性别',
            component: dictionarySex
        }
        ,{
            path: '/dictionaryComplaint',
            name: '投诉类型',
            component: dictionaryComplaint
        }
        ,{
            path: '/dictionaryComplaintYesno',
            name: '投诉状态',
            component: dictionaryComplaintYesno
        }
        ,{
            path: '/dictionary',
            name: '字典表',
            component: dictionary
        }
        ,{
            path: '/orderreceiving',
            name: '订单信息',
            component: orderreceiving
        }
        ,{
            path: '/news',
            name: '公告信息',
            component: news
        }
        ,{
            path: '/task',
            name: '任务信息',
            component: task
        }
        ,{
            path: '/complaint',
            name: '投诉信息',
            component: complaint
        }
        ,{
            path: '/yonghu',
            name: '用户',
            component: yonghu
        }
        ,{
            path: '/errands',
            name: '跑腿',
            component: errands
        }
    ]
},
    {
        path: '/login',
        name: 'login',
        component: Login,
        meta: {icon:'', title:'login'}
    },
    {
        path: '/register',
        name: 'register',
        component: register,
        meta: {icon:'', title:'register'}
    },
    {
        path: '/errandsregister',
        name: 'errandsregister',
        component: errandsregister,
        meta: {icon:'', title:'errandsregister'}
    },
    {
        path: '/',
        name: '首页',
        redirect: '/index'
    }, /*默认跳转路由*/
    {
        path: '*',
        component: NotFound
    }
]
//3.实例化VueRouter 注意：名字
const router = new VueRouter({
    mode: 'hash',
    /*hash模式改为history*/
    routes // （缩写）相当于 routes: routes
})

export default router;
