import { createStore } from "vuex";

const store = createStore({
  state: {
    user: {
      data: {
        name: "Skibidi Dop",
        email: "skibidi@dop.yes",
        imageUrl: "https://i1.sndcdn.com/artworks-jbfzYnBdTSeeh7EO-tkzRFw-t500x500.jpg",
      },
      token: 123,
    },
  },
  getters: {},
  actions: {},
  mutations: {
    logout: state => {
      state.user.data = {};
      state.user.token = null;
    }
  },
  modules: {},
});

export default store;
