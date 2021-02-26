import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
    meta: {
      title: "Home",
    },
  },
  {
    path: "/scripts",
    name: "Scripts",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "scripts" */ "../views/Scripts.vue"),
    meta: {
      title: "Scripts",
    },
  },
  {
    path: "/layouts",
    name: "Layouts",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "layouts" */ "../views/Layouts.vue"),
    meta: {
      title: "Layouts",
    },
  },
  {
    path: "/kpis",
    name: "Kpis",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "layouts" */ "../views/Kpis.vue"),
    meta: {
      title: "KPIs",
    },
  },
  {
    path: "/autocalculations",
    name: "Autocalculations",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "layouts" */ "../views/Autocalculations.vue"),
    meta: {
      title: "AutoCalculations",
    },
  },
  {
    path: "/webserviceconsumercallprofiles",
    name: "WebServiceConsumerCall Profiles",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "webserviceconsumercallprofiles" */ "../views/WebServiceConsumerCallProfiles.vue"
      ),
    meta: {
      title: "WebServiceConsumerCallProfiles",
    },
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
    meta: {
      title: "About",
    },
  },
  {
    path: "/login",
    name: "Login",
    // route level code-splitting
    // this generates a separate chunk (login.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "login" */ "../views/Login.vue"),
    meta: {
      title: "Login",
    },
  },
];

const router = new VueRouter({
  routes,
});

export default router;
