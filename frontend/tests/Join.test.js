import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import { createLocalVue, shallowMount } from '@vue/test-utils';
import Login from '../src/components/Login.vue'; // 상대 경로 사용

const mock = new MockAdapter(axios);

describe('Login.vue', () => {
  let wrapper;

  beforeEach(() => {
    const localVue = createLocalVue();
    wrapper = shallowMount(Login, {
      localVue,
    });
  });

  afterEach(() => {
    mock.reset();
  });

  it('should fetch captcha data successfully', async () => {
    const url = '/api/v1/captcha';

    // Mocking GET 요청
    mock.onGet(url).reply(200, {
      data: {
        captchaImage: 'base64string',
        captchaKey: 'key',
      },
    });

    const result = await wrapper.vm.getCaptcha(); // 인스턴스를 통해 메서드 호출

    // 결과 검증
    expect(result).toBeDefined(); // 결과가 undefined가 아님
    expect(wrapper.vm.captchaImage).toContain('data:image/png;base64,');
    expect(wrapper.vm.captchaKey).toBe('key');
  });
});
