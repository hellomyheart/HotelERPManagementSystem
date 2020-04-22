import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import app from './modules/app'
import settings from './modules/settings'
import user from './modules/user'
import department from './modules/department'
import position from './modules/position'
import employee from './modules/employee'
import training from './modules/training'
import trainingContent from './modules/trainingContent'
Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    app,
    settings,
    user,
    department,
    position,
    employee,
    training,
    trainingContent
  },
  getters
})

export default store
