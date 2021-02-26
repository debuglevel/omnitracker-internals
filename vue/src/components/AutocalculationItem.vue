<template>
  <tr>
    <td>{{ path }}</td>
    <td>{{ autocalculation.name }}</td>
  </tr>
</template>

<script>
export default {
  name: "AutocalculationItem",
  props: {
    autocalculation: {}
  },
  methods: {
    containsKey(obj, key) {
      return Object.keys(obj).includes(key);
    },
  },
  computed: {
    path: function () {
      if (this.containsKey(this.autocalculation, 'folder') && this.containsKey(this.autocalculation.folder, 'path'))
      {
        return this.autocalculation.folder.path;
      }
      else
      {
        return "(None)";
      }
    }
  }
};
</script>
