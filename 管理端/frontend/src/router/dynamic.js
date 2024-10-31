export const dynamicRoutes = [{
        path: '/',
        meta: {
            title: '首页',
            isParentView: false
        },
        component: ()=> import('@/views/home/index.vue'),
    }, {
        path: '/user_info',
        meta: {
            title: '用户管理',
            shownot: false
        },
        component: ()=> import('@/views/user_info/index.vue'),
    }, {
        path: '/bug_info',
        meta: {
            title: 'BUG管理',
            shownot: false
        },
        component: ()=> import('@/views/bug_info/index.vue'),
    }, {
        path: '/project_info',
        meta: {
            title: '项目信息管理',
            shownot: false
        },
        component: ()=> import('@/views/project_info/index.vue'),
    }, {
        path: '/bug_handle_status',
        meta: {
            title: 'BUG处理状态管理',
            shownot: false
        },
        component: ()=> import('@/views/bug_handle_status/index.vue'),
    }, {
        path: '/bug_priority_status',
        meta: {
            title: 'BUG优先级管理',
            shownot: false
        },
        component: ()=> import('@/views/bug_priority_status/index.vue'),
    }, {
        path: '/technical_direction_status',
        meta: {
            title: '技术方向枚举管理',
            shownot: false
        },
        component: ()=> import('@/views/technical_direction_status/index.vue'),
    }, {
        path: '/user_info/detail',
        meta: {
            title: '用户详情',
            shownot: true
        },
        component: ()=> import('@/views/user_info/detail/index.vue'),
    }, {
        path: '/bug_info/detail',
        meta: {
            title: 'BUG详情',
            shownot: true
        },
        component: ()=> import('@/views/bug_info/detail/index.vue'),
    }, {
        path: '/project_info/detail',
        meta: {
            title: '项目信息详情',
            shownot: true
        },
        component: ()=> import('@/views/project_info/detail/index.vue'),
    }, {
        path: '/bug_handle_status/detail',
        meta: {
            title: 'BUG处理状态详情',
            shownot: true
        },
        component: ()=> import('@/views/bug_handle_status/detail/index.vue'),
    }, {
        path: '/bug_priority_status/detail',
        meta: {
            title: 'BUG优先级详情',
            shownot: true
        },
        component: ()=> import('@/views/bug_priority_status/detail/index.vue'),
    }, {
        path: '/technical_direction_status/detail',
        meta: {
            title: '技术方向枚举详情',
            shownot: true
        },
        component: ()=> import('@/views/technical_direction_status/detail/index.vue'),
    }]