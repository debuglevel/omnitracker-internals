<template>
  <div class="autocalculations">
    <h1>AutoCalculations</h1>

    <!-- TODO: replace with v-data-table; unknown if flat object format is strictly needed or paths would work -->
    <v-simple-table dense>
      <thead>
        <th class="text-left">Folder</th>
        <th class="text-left">Name</th>
      </thead>
      <tbody>
        <tr
          is="autocalculation-item"
          v-for="item in autocalculations"
          v-bind:autocalculation="item"
          v-bind:key="item.id"
        ></tr>
      </tbody>
    </v-simple-table>
  </div>
</template>

<script>
// @ is an alias to /src
import AutocalculationItem from "@/components/AutocalculationItem.vue";
import { authenticationService } from "../services/authentication.service";
import axios from "axios";

export default {
  name: "Autocalculations",
  components: {
    AutocalculationItem
  },

  data: function() {
    return {
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
