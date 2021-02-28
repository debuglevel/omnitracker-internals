<template>
  <div class="kpis">
    <h1>KPIs</h1>

    <v-data-table
      :headers="headers"
      :items="kpis"
      :items-per-page="-1"
    ></v-data-table>
  </div>
</template>

<script>
// @ is an alias to /src
import { authenticationService } from "../services/authentication.service";
import axios from "axios";

export default {
  name: "Kpis",
  components: {
  },

  data: function() {
    return {
      headers: [
        { text: 'Folder', value: 'folder.path' },
        { text: 'Name', value: 'name' },
      ],

      kpis: [
        {
          id: 1,
          name: "KPI 1",
          folder: { path: "\\Foo\\Bar" }
        },
        {
          id: 2,
          name: "KPI 2",
          folder: { path: "\\Foo\\Bar" }
        },
        {
          id: 3,
          name: "KPI 3",
          folder: { path: "\\Foo\\Bar" }
        }
      ]
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/kpis/", authenticationService.authConfig())
      .then(response => (this.kpis = response.data));
  }
};
</script>
