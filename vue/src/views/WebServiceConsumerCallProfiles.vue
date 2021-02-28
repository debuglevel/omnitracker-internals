<template>
  <div class="webserviceconsumercallprofiles">
    <h1>WebServiceConsumer Call Profiles</h1>

    <v-data-table
      :headers="headers"
      :items="webserviceconsumercallprofiles"
      :items-per-page="-1"
      :item-class= "statusStyle"
    >
    </v-data-table>
  </div>
</template>

<script>
// @ is an alias to /src
import axios from "axios";
import { authenticationService } from "../services/authentication.service";

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
  mounted() {
    axios
      .get("http://localhost:8080/webserviceconsumercallprofiles/", authenticationService.authConfig())
      .then(response => (this.webserviceconsumercallprofiles = response.data));
  }
};
</script>
