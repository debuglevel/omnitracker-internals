<template>
  <tr>
    <td>{{ layout.folder.path }}</td>
    <td>
      <a v-bind:href="'http://localhost:8080/layouts/files/' + layout.id">{{
        layout.name
      }}</a>
    </td>
    <td>{{ layout.outputType }}</td>
    <td>{{ layout.mailmergeFiletype }}</td>
  </tr>
</template>

<script>
export default {
  name: "LayoutItem",
  props: {
    layout: {}
  }
};
</script>
