<template>
  <div class="webserviceconsumercallprofiles">
    <h1>WebServiceConsumer Call Profiles</h1>

    <v-simple-table dense>
      <thead>
        <th class="text-left">Folder</th>
        <th class="text-left">WSCC name</th>
        <th class="text-left">Status</th>
      </thead>
      <tbody>
        <tr
          is="webserviceconsumercallprofile-item"
          v-for="item in webserviceconsumercallprofiles"
          v-bind:webserviceconsumercallprofile="item"
          v-bind:key="item.id"
        ></tr>
      </tbody>
    </v-simple-table>
  </div>
</template>

<script>
// @ is an alias to /src
import WebserviceconsumercallprofileItem from "@/components/WebserviceconsumercallprofileItem.vue";
import axios from "axios";

export default {
  name: "WebServiceConsumerCallProfiles",
  components: {
    WebserviceconsumercallprofileItem
  },

  data: function() {
    return {
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
      .get("http://localhost:8080/webserviceconsumercallprofiles/")
      .then(response => (this.webserviceconsumercallprofiles = response.data));
  }
};
</script>
