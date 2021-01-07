import Vue from 'vue'
import Router from 'vue-router'
import Product from '@/components/Product'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'Product',
            component: Product
        },
    ]
})
