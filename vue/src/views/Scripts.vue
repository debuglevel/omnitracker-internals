<template>
  <div class="scripts">
      <h1>Scripts</h1>

    <v-simple-table
      dense
      >
        <thead>
          <th class="text-left">Folder</th>
          <th class="text-left">Name</th>
          <th class="text-left">Type</th>
          <th class="text-left">Content</th>
        </thead>
        <tbody>
          <tr
            is="script-item"
            v-for="item in scripts"
            v-bind:script="item"
            v-bind:key="item.id"
          ></tr>
        </tbody>
      </v-simple-table>
  </div>
</template>

<script>
// @ is an alias to /src
import ScriptItem from "@/components/ScriptItem.vue";
import axios from 'axios'

export default {
  name: "Scripts",
  components: {
    ScriptItem
  },

  data: function() {
    return {
      scripts: [
        { id: 1, name: 'Script 1', type: 'Whatever Type', content: 'Whatever Content', folder: { path: '\\Foo\\Bar' } },
      ],
    }
  },
  mounted() {
    axios
      .get("http://localhost:8080/scripts/")
      .then((response) => (this.scripts = response.data));
  }
};
</script>