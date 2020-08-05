<template>
  <tr>
    <td>{{ script.folder.path }}</td>
    <td>{{ script.name }}</td>
    <td>{{ script.type }}</td>
    <td>
      <pre>{{ script.content }}</pre>
    </td>
  </tr>
</template>

<script>
export default {
  name: "ScriptItem",
  props: {
    script: {}
  }
};
</script>
