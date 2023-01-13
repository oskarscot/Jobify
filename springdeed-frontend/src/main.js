import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import axios from "axios";
import VueAxios from "vue-axios";

import "./assets/main.css";

const app = createApp(App);

axios.defaults.headers.get["Accept"] = "application/json";

app.use(router);
app.use(VueAxios, axios);

app.mount("#app");

app.config.globalProperties.axios = axios;
