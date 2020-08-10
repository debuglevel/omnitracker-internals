<template>
    <div>

        <!-- Source: https://vuetifyjs.com/en/examples/layouts/centered/ -->
        <v-container class="fill-height" fluid>
          <v-row align="center" justify="center">
            <v-col cols="12" sm="8" md="4">
              <v-card class="elevation-12">
              <v-card-title>Login</v-card-title>
                <v-card-subtitle>
                  This only stores the credentials in the Browser local storage.
                  On each HTTP request, they are included as HTTP basic authentication.
                  As the Browser local storage is insecure, <strong>credentials should be unset when work is done</strong>.
                </v-card-subtitle>
                <v-card-text>
                  <v-form>
                    <v-text-field v-model="username" label="Login" prepend-icon="mdi-account" type="text" required />
                    <v-text-field v-model="password" label="Password" prepend-icon="mdi-lock" type="password" required />
                  </v-form>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn @click="login" color="primary">Set credentials</v-btn>
                  <v-btn @click="logout">Unset credentials</v-btn>
                </v-card-actions>
              </v-card>
            </v-col>
          </v-row>
        </v-container>

    </div>
</template>

<script>
import { authenticationService } from "../services/authentication.service";

export default {
  data() {
    return {
      username: "",
      password: "",
    };
  },

  methods: {
    login() {
      authenticationService.login(this.username, this.password);
    },
    logout() {
      authenticationService.logout();
    }
  }
};
</script>
