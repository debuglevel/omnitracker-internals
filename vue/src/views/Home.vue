<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png" /> -->
    <HelloWorld msg="OMNITRACKER Internals" />
    <v-card class="mx-auto" max-width="344">
      <v-card-text>Ensure to set your credentials before taking any actions.</v-card-text>
      <v-card-actions>
        <v-btn to="/login" text>Login</v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "Home",
  components: {
    HelloWorld
  }
};
</script>
