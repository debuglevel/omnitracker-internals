<template>
    <div>
        <h1>Login</h1>
        <v-card>
            <v-card-text>
                This only stores the credentials in the Browser local storage.
                On each HTTP request, they are included as HTTP basic authentication.
                As the Browser local storage is insecure, <em>credentials should be unset when work is done</em>.
            </v-card-text>
        </v-card>
        <v-form>
            <v-text-field v-model="username" label="Username" required></v-text-field>
            <v-text-field v-model="password" label="Password" type="password" required></v-text-field>
            <v-btn @click="login">Set credentials</v-btn>
            <v-btn @click="logout">Unset credentials</v-btn>
        </v-form>
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
