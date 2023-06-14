// 이벤트 등록 1단계
const loginForm = document.querySelector("#loginForm");
const input = document.querySelector("input");
const h1 = document.querySelector("#greeting");

// 이벤트 등록 2단계
const callback = function(e) {
    e.preventDefault();
    localStorage.setItem("userName", input.value);
    const savedName = localStorage.getItem("userName");
    console.log(savedName);
    h1.innerHTML = "Hello~ " + savedName;
    loginForm.classList.add("#hidden");
};
// 이벤트 등록 3단계
loginForm.addEventListener("submit", callback);

const savedName = localStorage.getItem("userName");
if (savedName != null) {
    h1.innerHTML = "Hello~ " + savedName;
    loginForm.classList.add("hidden");
} else {
    loginForm.classList.remove("hidden");
}

// *중요 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// 2번줄 부터 마지막 21번줄 까지 콤피타가 쭈욱 내려오면서 한번을 읽는다
// 그런데 7번째줄인 함수를 등록하였고 21번째줄에 함수를 클릭할때마다 이벤트가
// 진행되게끔 등록하였기 때문에 함수 내부에 적힌 코드는
// 내가 이벤트를 진행할때마다 반복 진행된다.