import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios' // 追加

import ElementUI from 'element-ui' // 追記
import locale from 'element-ui/lib/locale/lang/ja' // 追記
import 'element-ui/lib/theme-chalk/index.css' // 追記

Vue.config.productionTip = false

Vue.use(ElementUI, { locale }) // 追記
Vue.prototype.$axios = axios // 追加

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
