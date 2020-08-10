<template>
  <tr v-bind:class="statusStyle(webserviceconsumercallprofile.status)">
    <td>{{ path }}</td>
    <td>{{ webserviceconsumercallprofile.name }}</td>
    <td>{{ webserviceconsumercallprofile.status }}</td>
  </tr>
</template>

<script>
export default {
  name: "WebserviceconsumercallprofileItem",
  props: {
    webserviceconsumercallprofile: {}
  },
  methods: {
    statusStyle: function(status) {
      return status == "Valid" ? "green lighten-4" : "red lighten-4";
    },
    containsKey(obj, key) {
      return Object.keys(obj).includes(key);
    },
  },
  computed: {
    path: function () {
      if (this.containsKey(this.webserviceconsumercallprofile, 'folder') && this.containsKey(this.webserviceconsumercallprofile.folder, 'path'))
      {
        return this.webserviceconsumercallprofile.folder.path;
      }
      else
      {
        return "(None)";
      }
    }
  }
};
</script>
