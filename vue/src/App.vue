<template>
  <v-app>
    <!--<v-system-bar app></v-system-bar> -->

    <v-navigation-drawer app dark expand-on-hover>
      <v-list dense nav>
        <v-list-item
          v-for="item in navigationItems"
          :key="item.title"
          :to="item.link"
          link
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <!-- <v-app-bar app color="teal" dark>
      <v-toolbar-title>OMNITRACKER Internals</v-toolbar-title>
      <v-spacer></v-spacer>
    </v-app-bar> -->

    <!-- Sizes your content based upon application components -->
    <v-main>
      <!-- Provides the application the proper gutter -->
      <v-container fluid>
        <router-view />
      </v-container>
    </v-main>

    <v-footer app>
      Built with 💛👊😉
    </v-footer>
  </v-app>
</template>

<script>
export default {
  name: "App",

  components: {},

    watch: {
    $route(to) {
      this.title = "OT Internals: " + to.meta.title || "OMNITRACKER Internals";
      document.title = this.title;
    }
  },

  data: () => ({
    navigationItems: [
      { title: "Home", icon: "mdi-home", link: "/" },
      { title: "Scripts", icon: "mdi-script-text", link: "/scripts" },
      { title: "Layouts", icon: "mdi-file-document", link: "/layouts" },
      {
        title: "WSCC-Profiles",
        icon: "mdi-web",
        link: "/webserviceconsumercallprofiles"
      },
      { title: "About", icon: "mdi-information", link: "/about" }
    ]
  })
};
</script>
