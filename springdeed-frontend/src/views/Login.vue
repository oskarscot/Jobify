<template>
  <h1 class="text-center text-4xl font-bold mb-8">Springdeed</h1>
  <h2 class="text-center text-2xl font-medium">Login to your account</h2>
  <p class="text-center text-sm font-medium mb-4">
    Or {{ " " }}
    <router-link :to="{ name: 'Register' }" class="text-green-600"
      >register for free</router-link
    >
  </p>
  <form class="mb-6">
    <input
      v-model="email"
      type="email"
      id="email"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-t-lg focus:ring-green-500 focus:border-green-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-green-500 dark:focus:border-green-500"
      placeholder="name@mail.com"
      required
    />
    <input
      v-model="password"
      type="password"
      id="password"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-b-lg focus:ring-bgreenlue-500 focus:border-green-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-green-500 dark:focus:border-green-500"
      placeholder="Password"
      required
    />
  </form>
  <button
    @click.prevent="submitForm"
    type="submit"
    class="text-white bg-green-500 hover:bg-green-800 focus:ring-4 focus:outline-none focus:ring-green-300 font-bold rounded-lg text-lg w-full py-4 px-5 text-center dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
  >
    Login
  </button>
</template>

<script>
export default {
  name: "Login",
};
</script>

<style scoped></style>
