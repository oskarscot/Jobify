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
      v-model="firstName"
      type="text"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-t-lg focus:ring-green-500 focus:border-green-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-green-500 dark:focus:border-green-500"
      placeholder="First Name"
      required
    />
    <input
        v-model="lastName"
        type="text"
        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-none focus:ring-green-500 focus:border-green-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-green-500 dark:focus:border-green-500"
        placeholder="Last Name"
        required
    />
    <input
      v-model="email"
      type="email"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-none focus:ring-green-500 focus:border-green-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-green-500 dark:focus:border-green-500"
      placeholder="Email"
      required
    />
    <input
      v-model="password"
      type="password"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-none focus:ring-green-500 focus:border-green-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-green-500 dark:focus:border-green-500"
      placeholder="Password"
      required
    />
    <input
      v-model="confirmPassword"
      type="password"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-b-lg focus:ring-green-500 focus:border-green-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-green-500 dark:focus:border-green-500"
      placeholder="Confirm Password"
      required
    />
  </form>
  <button
    @click="this.submitForm()"
    @click.prevent="submitForm"
    type="submit"
    class="text-white bg-green-500 hover:bg-green-800 focus:ring-4 focus:outline-none focus:ring-green-300 font-bold rounded-lg text-lg w-full py-4 px-5 text-center dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
  >
    Register
  </button>
</template>

<script>
import {useRouter} from "vue-router";
import axios from "axios";

export default {
  name: "Register",

  data() {
    return {
      firstName: "",
      lastName: "",
      email: "",
      password: "",
      confirmPassword: "",
    };
  },

  setup() {
    const router = useRouter();
    const emailRegex = new RegExp(
        "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"
    );
    const passwordRegex = new RegExp(
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})"
    );
    function submitForm() {
      if (
          this.firstName === "" ||
          this.lastName === "" ||
          this.email === "" ||
          this.password === "" ||
          this.confirmPassword === ""
      ) {
        this.$notify({
          title: "Error",
          text: "Please fill out all fields",
          type: "error",
        });
        return;
      }
      if (!emailRegex.test(this.email)) {
        this.$notify({
          title: "Error",
          text: "Invalid email format",
          type: "error",
        });
        return;
      }
      if (!passwordRegex.test(this.password)) {
        this.$notify({
          title: "Error",
          text:
              "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character",
          type: "error",
          duration: 10000,
        });
        return;
      }
      if (this.password !== this.confirmPassword) {
        this.$notify({
          title: "Error",
          text: "Passwords do not match",
          type: "error",
        });
        return;
      }
      axios
        .post("http://localhost:8080/api/v1/auth/register", {
          firstName: this.firstName,
          lastName: this.lastName,
          email: this.email,
          password: this.password,
        })
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          this.$notify({
            title: "Error",
            text: err,
            type: "error",
          });
        });
      router.push({ name: "Login" });
    }
    return {
      submitForm,
    };
  },
};
</script>

<style scoped>

</style>
