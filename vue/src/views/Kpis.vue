<template>
  <div class="kpis">
    <h1>KPIs</h1>

    <v-data-table
      :headers="headers"
      :items="kpis"
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
        },
        {
          id: 4,
          name: "KPI 4",
          folder: { path: "\\Foo\\Bar" }
        },
        {
          id: 5,
          name: "KPI 5",
          folder: { path: "\\Foo\\Bar" }
        },
        {
          id: 6,
          name: "KPI 6",
          folder: { path: "\\Foo\\Bar" }
        },
        {
          id: 7,
          name: "KPI 7",
          folder: { path: "\\Foo\\Bar" }
        },
        {
          id: 8,
          name: "KPI 8",
          folder: { path: "\\Foo\\Bar" }
        },
      ]
    };
  },
  async mounted() {
    axios
      .get("/kpis/", await axiosConfigurationService.getAxiosRequestConfig())
      .then(response => (this.kpis = response.data));
  }
};
</script>
