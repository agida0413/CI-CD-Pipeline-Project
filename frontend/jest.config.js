module.exports = {
    preset: '@vue/cli-plugin-unit-jest/presets/no-babel',
    testEnvironment: 'jsdom',
    transform: {
      '^.+\\.vue$': '@vue/vue3-jest',
      '^.+\\.js$': 'babel-jest',
    },
    testMatch: [
      '**/tests/unit/**/*.spec.[jt]s?(x)',       // 단위 테스트
      '**/tests/integration/**/*.spec.[jt]s?(x)', // 통합 테스트
    ],
    testPathIgnorePatterns: ['/node_modules/'],
  };
  