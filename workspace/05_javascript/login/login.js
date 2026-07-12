const loginForm = document.querySelector('.login-form');
loginForm.addEventListener('submit', function(event){
  console.log('로그인 요청');
  
  // 브라우저의 유효성 검증 결과를 확인(required, pattern 등)
  if(!loginForm.checkValidity()){
    event.preventDefault(); // 브라우저의 기본 동작 취소(submit 취소)
    return;
  }

});