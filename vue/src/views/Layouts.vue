<template>
  <div class="layouts">
    <h1>Layouts</h1>

    <!-- TODO: replace with v-data-table; unknown if flat object format is strictly needed or paths would work -->
    <v-simple-table dense>
      <thead>
        <th class="text-left">Folder</th>
        <th class="text-left">Name</th>
        <th class="text-left">File Type</th>
        <th class="text-left">Output File Type</th>
      </thead>
      <tbody>
        <tr
          is="layout-item"
          v-for="item in layouts"
          v-bind:layout="item"
          v-bind:key="item.id"
        ></tr>
      </tbody>
    </v-simple-table>
  </div>
</template>

<script>
// @ is an alias to /src
import LayoutItem from "@/components/LayoutItem.vue";
import axios from "axios";

export default {
  name: "Layouts",
  components: {
    LayoutItem
  },

  data: function() {
    return {
      layouts: [
        {
          id: 1,
          name: "Layout 1",
          outputType: "PDF",
          mailmergeFiletype: "Whatever",
          folder: { path: "\\Foo\\Bar" }
        }
      ]
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/layouts/")
      .then(response => (this.layouts = response.data));
  }
};
</script>
