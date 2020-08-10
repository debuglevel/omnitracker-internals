<template>
  <tr>
    <td>{{ path }}</td>
    <td>{{ script.name }}</td>
    <td>{{ script.type }}</td>
    <td>
      <code-dialog v-bind:title="path+': '+script.name" v-bind:code="script.content" />
    </td>
  </tr>
</template>

<script>
import CodeDialog from "@/components/CodeDialog.vue";

export default {
  name: "ScriptItem",
    components: {
    CodeDialog
  },
  props: {
    script: {}
  },
  methods: {
    containsKey(obj, key) {
      return Object.keys(obj).includes(key);
    },
  },
  computed: {
    path: function () {
      if (this.containsKey(this.script, 'folder') && this.containsKey(this.script.folder, 'path'))
      {
        return this.script.folder.path;
      }
      else
      {
        return "(None)";
      }
    }
  }
};
</script>
