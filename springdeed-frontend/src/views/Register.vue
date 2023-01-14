<template>
  <h1 class="text-center text-4xl font-bold mb-8">Springdeed</h1>
  <h2 class="text-center text-2xl font-medium">Register Your Account</h2>
  <p class="text-center text-m font-medium mb-4">
    Or
    <router-link :to="{ name: 'Login' }" class="text-green-600"
      >already have an account?</router-link
    >
  </p>
  <form class="mb-6">
    <input
      v-model="name"
      type="text"
      id="name"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-t-lg focus:ring-green-500 focus:border-green-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-green-500 dark:focus:border-green-500"
      placeholder="Full Name"
      required
    />
    <input
      v-model="email"
      type="email"
      id="email"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-none focus:ring-green-500 focus:border-green-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-green-500 dark:focus:border-green-500"
      placeholder="Email"
      required
    />
    <input
      v-model="password"
      type="password"
      id="password"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-none focus:ring-green-500 focus:border-green-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-green-500 dark:focus:border-green-500"
      placeholder="Password"
      required
    />
    <input
      v-model="password"
      type="password"
      id="password"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-b-lg focus:ring-green-500 focus:border-green-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-green-500 dark:focus:border-green-500"
      placeholder="Confirm Password"
      required
    />
  </form>
  <button
    @click.prevent="submitForm"
    type="submit"
    class="text-white bg-green-500 hover:bg-green-800 focus:ring-4 focus:outline-none focus:ring-green-300 font-bold rounded-lg text-lg w-full py-4 px-5 text-center dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
  >
    Register
  </button>
</template>

<script>
export default {
  name: "Register",
};
</script>

<style scoped></style>
