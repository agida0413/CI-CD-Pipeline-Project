const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    baseUrl: 'http://localhost:3000', // Docker Compose의 nginx 서비스 이름
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
