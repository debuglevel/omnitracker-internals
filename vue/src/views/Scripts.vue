<template>
  <div class="scripts">
    <h1>Scripts</h1>

    <v-data-table
      :headers="headers"
      :items="scripts"
      :items-per-page="-1"
      :hide-default-footer="true"
    >
      <template v-slot:item.folder.path="{ item }">
        {{ path(item) }}
      </template>

      <template v-slot:item.content="{ item }">
        <code-dialog v-bind:title="path(item)+': '+item.name" v-bind:code="item.content" />
      </template>
    </v-data-table>
  </div>
</template>

<script>
// @ is an alias to /src
import CodeDialog from "@/components/CodeDialog.vue";
import { axiosConfigurationService } from "../services/axiosConfiguration.service";
import axios from "axios";

export default {
  name: "Scripts",
  components: {
    CodeDialog
  },

  methods: {
    containsKey(obj, key) {
      return Object.keys(obj).includes(key);
    },
    path: function (script) {
      if (this.containsKey(script, 'folder') && this.containsKey(script.folder, 'path'))
      {
        return script.folder.path;
      }
      else
      {
        return "(no folder)";
      }
    }
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
          content: "x\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx\nx",
          folder: { path: "\\Foo\\Bar" }
        },
        {
          id: 2,
          name: "Script 2",
          type: "Whatever Type",
          content: "Do While True = True\n  ' I really like VBScript. Stable genius language.\nLoop",
          folder: { }
        },
        {
          id: 3,
          name: "Script 3",
          type: "Whatever Type",
          content: "function myFunction() {\n  document.getElementById(\"demo\").innerHTML = \"Paragraph changed.\";\n}",
        },
      ]
    };
  },
  async mounted() {
    axios
      .get("/scripts/", await axiosConfigurationService.getAxiosRequestConfig())
      .then(response => (this.scripts = response.data));
  }
};
</script>
