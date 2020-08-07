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
  }
];

const router = new VueRouter({
  routes
});

export default router;
