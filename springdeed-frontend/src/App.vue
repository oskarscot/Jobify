<script>
export default {
  data() {
    return {
      joke: "",
    };
  },
  methods: {
    getJoke() {
      this.axios.get("https://icanhazdadjoke.com/").then((response) => {
        this.joke = response.data.joke;
        console.log(response);
      });
    },
  },
  mounted() {
    this.getJoke();
  },
};
</script>

<template>
  <p>Joke: {{ joke }}</p>
  <br />
  <div @click="getJoke()">Click me for new joke</div>
</template>

<style scoped></style>
