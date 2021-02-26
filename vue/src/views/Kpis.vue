<template>
  <div class="kpis">
    <h1>KPIs</h1>

    <!-- TODO: replace with v-data-table; unknown if flat object format is strictly needed or paths would work -->
    <v-simple-table dense>
      <thead>
        <th class="text-left">Folder</th>
        <th class="text-left">Name</th>
      </thead>
      <tbody>
        <tr
          is="kpi-item"
          v-for="item in kpis"
          v-bind:kpi="item"
          v-bind:key="item.id"
        ></tr>
      </tbody>
    </v-simple-table>
  </div>
</template>

<script>
// @ is an alias to /src
import KpiItem from "@/components/KpiItem.vue";
import { authenticationService } from "../services/authentication.service";
import axios from "axios";

export default {
  name: "Kpis",
  components: {
    KpiItem
  },

  data: function() {
    return {
      kpis: [
        {
          id: 1,
          name: "KPI 1",
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
