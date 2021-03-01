<template>
  <div class="autocalculations">
    <h1>AutoCalculations</h1>

    <v-data-table
      :headers="headers"
      :items="autocalculations"
      :items-per-page="-1"
      :hide-default-footer="true"
    ></v-data-table>
  </div>
</template>

<script>
// @ is an alias to /src
import { axiosConfigurationService } from "../services/axiosConfiguration.service";
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
  async mounted() {
    axios
      .get("/autocalculations/", await axiosConfigurationService.getAxiosRequestConfig())
      .then(response => (this.autocalculations = response.data));
  }
};
</script>
