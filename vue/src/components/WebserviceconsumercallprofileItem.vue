<template>
  <tr v-bind:class="statusStyle(webserviceconsumercallprofile.status)">
    <td>{{ webserviceconsumercallprofile.folder.path }}</td>
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
      return status == "Valid" ? "table-success" : "table-danger";
    }
  }
};
</script>
