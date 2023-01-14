import { createStore } from "vuex";

const store = createStore({
  state: {
    user: {
      data: {
        name: "Dupa dupa",
      },
      token: 123,
    },
  },
  getters: {},
  actions: {},
  mutations: {},
  modules: {},
});

export default store;
