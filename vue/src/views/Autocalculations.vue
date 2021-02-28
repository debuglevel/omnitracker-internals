<template>
  <div class="autocalculations">
    <h1>AutoCalculations</h1>

    <v-data-table
      :headers="headers"
      :items="autocalculations"
      :items-per-page="-1"
    ></v-data-table>
  </div>
</template>

<script>
// @ is an alias to /src
import { authenticationService } from "../services/authentication.service";
import axios from "axios";

export default {
  name: "Autocalculations",
  components: {
  },

  data: function() {
    return {
      headers: [
        { text: 'Folder', value: 'folder.path' },
        { text: 'Name', value: 'name' },
      ],

      autocalculations: [
        {
          id: 1,
          name: "AutoCalculation 1",
          folder: { path: "\\Foo\\Bar" }
        }
      ]
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/autocalculations/", authenticationService.authConfig())
      .then(response => (this.autocalculations = response.data));
  }
};
</script>
