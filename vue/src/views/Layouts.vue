<template>
  <div class="layouts">
    <h1>Layouts</h1>

    <table class="table table-sm table-hover">
      <thead class="thead-dark">
        <th>Folder</th>
        <th>Name</th>
        <th>File Type</th>
        <th>Output File Type</th>
      </thead>
      <tbody>
        <tr
          is="layout-item"
          v-for="item in layouts"
          v-bind:layout="item"
          v-bind:key="item.id"
        ></tr>
      </tbody>
    </table>
  </div>
</template>

<script>
// @ is an alias to /src
import LayoutItem from "@/components/LayoutItem.vue";
import axios from 'axios'

export default {
  name: "Layouts",
  components: {
    LayoutItem
  },

  data: function() {
    return {
      layouts: [
        { id: 1, name: 'Layout 1', outputType: 'PDF', mailmergeFiletype: 'Whatever', folder: { path: '\\Foo\\Bar' } },
      ],
    }
  },
  mounted() {
    axios
      .get("http://localhost:8080/layouts/")
      .then((response) => (this.layouts = response.data));
  }
};
</script>