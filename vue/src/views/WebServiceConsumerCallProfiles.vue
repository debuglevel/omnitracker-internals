<template>
  <div class="webserviceconsumercallprofiles">
    <h1>WebServiceConsumer Call Profiles</h1>

    <v-data-table
      :headers="headers"
      :items="webserviceconsumercallprofiles"
      :items-per-page="-1"
      :hide-default-footer="true"
      :item-class= "statusStyle"
    >
    </v-data-table>
  </div>
</template>

<script>
// @ is an alias to /src
import { axiosConfigurationService } from "../services/axiosConfiguration.service";
import axios from "axios";

export default {
  name: "WebServiceConsumerCallProfiles",
  components: {
  },

  methods: {
    statusStyle: function(item) {
      return item.status == "Valid" ? ["green","lighten-4"] : ["red","lighten-4"];
    }
  },

  data: function() {
    return {
      headers: [
        { text: 'Folder', value: 'folder.path' },
        { text: 'WSCC name', value: 'name' },
        { text: 'Status', value: 'status' },
      ],

      webserviceconsumercallprofiles: [
        {
          id: 1,
          name: "WebServiceConsumer Call Profile 1",
          status: "Valid",
          folder: { path: "\\Foo\\Bar" }
        },
        {
          id: 2,
          name: "WebServiceConsumer Call Profile 2",
          status: "NotSet",
          folder: { path: "\\Foo\\Bar" }
        }
      ]
    };
  },
  async mounted() {
    axios
      .get("/webserviceconsumercallprofiles/", await axiosConfigurationService.getAxiosRequestConfig())
      .then(response => (this.webserviceconsumercallprofiles = response.data));
  }
};
</script>
