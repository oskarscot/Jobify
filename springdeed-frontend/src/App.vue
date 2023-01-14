<script>
export default {
  data() {
    return {
      
    };
  },
  methods: {
    
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
