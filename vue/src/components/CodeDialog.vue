<template>
    <v-dialog v-model="dialog">
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="primary"
          v-bind="attrs"
          v-on="on"
        >
          Show code
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          <span class="headline">{{title}}</span>
        </v-card-title>
        <v-card-text><pre>{{code}}</pre></v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn text @click="dialog = false">Close</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
</template>

<script>
export default {
  name: "CodeDialog",
  props: {
    title: {},
    code: {}
  },
  data () {
      return {
        dialog: false,
      }
    },
};
</script>
