module.exports = {
    preset: '@vue/cli-plugin-unit-jest/presets/no-babel',
    testEnvironment: 'jsdom',
    transform: {
      '^.+\\.vue$': '@vue/vue3-jest',
      '^.+\\.js$': 'babel-jest',
      
    },
  };
  