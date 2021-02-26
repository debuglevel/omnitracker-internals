<template>
  <tr>
    <td>{{ path }}</td>
    <td>{{ kpi.name }}</td>
  </tr>
</template>

<script>
export default {
  name: "KpiItem",
  props: {
    kpi: {}
  },
  methods: {
    containsKey(obj, key) {
      return Object.keys(obj).includes(key);
    },
  },
  computed: {
    path: function () {
      if (this.containsKey(this.kpi, 'folder') && this.containsKey(this.kpi.folder, 'path'))
      {
        return this.kpi.folder.path;
      }
      else
      {
        return "(None)";
      }
    }
  }
};
</script>
