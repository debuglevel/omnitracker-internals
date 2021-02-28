<template>
  <div class="scripts">
    <h1>Scripts</h1>

    <v-data-table
      :headers="headers"
      :items="scripts"
      :items-per-page="-1"
    >
      <template v-slot:item.content="{ item }">
        <code-dialog v-bind:title="item.folder.path+': '+item.name" v-bind:code="item.content" />
      </template>
    </v-data-table>
  </div>
</template>

<script>
// @ is an alias to /src
import CodeDialog from "@/components/CodeDialog.vue";
import axios from "axios";
import { authenticationService } from "../services/authentication.service";

export default {
  name: "Scripts",
  components: {
    CodeDialog
  },

  data: function() {
    return {
      headers: [
        { text: 'Folder', value: 'folder.path' },
        { text: 'Name', value: 'name' },
        { text: 'Type', value: 'type' },
        { text: 'Content', value: 'content' },
      ],

      scripts: [
        {
          id: 1,
          name: "Script 1",
          type: "Whatever Type",
          content: "Whatever Content",
          folder: { path: "\\Foo\\Bar" }
        }
      ]
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/scripts/", authenticationService.authConfig())
      .then(response => (this.scripts = response.data));
  }
};
</script>
