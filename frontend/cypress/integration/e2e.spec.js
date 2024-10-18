describe('API Testing with Cypress', () => {
    it('캡챠 획득 API', () => {
      // API 호출
      cy.request('GET', '/api/v1/captcha')
        .then((response) => {
          // 응답 확인
          expect(response.status).to.eq(200); // 상태 코드 확인
       
        });
    });
  });