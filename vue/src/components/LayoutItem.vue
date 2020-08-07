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
    <td>
      <v-form>
        <!-- <v-text-field
          v-model="email"
          :rules="emailRules"
          label="E-mail"
          required
        ></v-text-field> -->

        <v-file-input v-bind:ref="'file' + layout.id" label="Template file" v-model="layout.file" />
        <v-btn @click="onSubmit">Upload</v-btn>
      </v-form>
    </td>
  </tr>
</template>

<script>
export default {
  name: "LayoutItem",
  props: {
    layout: {}
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      console.log("Uploading layout id="+this.layout.id);
      console.log("Upload file:");
      console.log(this.layout.file);

      this.convertToBase64(this.layout.file, this.uploadLayout);
      
      // console.log(this.$refs.myText.value);
      // console.log(this.$refs.text.value);

      // console.log(this.$refs.text);

      // console.log(this.$refs['file'+layoutId]);
      // axios
      //   .post("http://localhost:8080/layouts/", { name: this.form.name })
      //   .then((response) => this.characters.push(response.data));
    },
    convertToBase64(file, callback) {
      console.log("Converting file to Base64...");

      const reader = new FileReader();
      reader.onload = (e) => {
        console.log("Read file as data URL.");
        this.layout.dataUrl = e.target.result;

        // use a regex to remove data url part
        this.layout.base64 = this.layout.dataUrl
            .replace('data:', '')
            .replace(/^.+,/, '');

        this.layout.dataUrl = null; // no need to hold the data URL in memory anymore

        console.log("Calling callback...");
        callback();
      };
      reader.readAsDataURL(file);
    },
    uploadLayout() {
      console.log("Uploading layout:");
      console.log(this.layout);
      //console.log(this.layout.base64);

      console.log("Building JSON to upload via REST...");
      let uploadObj = { id: this.layout.id, base64: this.layout.base64 };
      console.log(uploadObj);

      // axios
      //   .post('http://127.0.0.1:8081/upload', { image })
      //   .then((response) => {
      //     this.remoteUrl = response.data.url;
      //   })
      //   .catch((err) => {
      //     return new Error(err.message);
      //   })
    }
  },
};
</script>
