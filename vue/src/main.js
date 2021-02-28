import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import vuetify from "./plugins/vuetify";
import VueCodeHighlight from "vue-code-highlight";

Vue.config.productionTip = false;

Vue.use(VueCodeHighlight); //registers the v-highlight directive

new Vue({
  router,
  vuetify,
  render: (h) => h(App),
}).$mount("#app");
