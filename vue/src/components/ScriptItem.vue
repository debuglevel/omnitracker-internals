<template>
  <tr>
    <td>{{ script.folder.path }}</td>
    <td>{{ script.name }}</td>
    <td>{{ script.type }}</td>
    <td>
      <code-dialog v-bind:title="script.folder.path+': '+script.name" v-bind:code="script.content" />
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
  }
};
</script>
