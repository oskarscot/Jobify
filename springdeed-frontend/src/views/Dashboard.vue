<template>
  <div class="text-center">
    <h1 class="text-4xl mb-4">
      Hello, <span class="text-green-500 font-extrabold">{{ this.user.name }}</span>!
    </h1>
    <h1 class="test-2xl font-bold">Your latest application:</h1>
    <p>{"latestId": "0", "status": "UNDER_REVIEW"}</p>
  </div>
</template>

<script>
import { useStore } from "vuex";
import { computed } from "vue";


export default {
  name: "Dashboard",
  setup() {
    const store = useStore();

    return {
      user: computed(() => store.state.user.data),
    };
  },
}
</script>

<style scoped></style>
