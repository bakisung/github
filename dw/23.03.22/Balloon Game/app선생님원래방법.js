let gallery = document.querySelector("#balloon-gallery"); /* 풍선들이 속한 박스 */
let message = document.querySelector("#yay-no-balloons"); /* 완료 알림 메세지 */
let popped = 0; /* 터진 풍선의 갯수를 0개로 맞춰놓는다 */
const balloons = document.querySelectorAll(".balloon"); /* 풍선들의 배열을 선언 */

balloons.forEach((b) => { /* 각 풍선들에 반복하여 모두 조건을 걸기위해 포이치 함수 */
// ㄴ "b"는 forEach를 등록하는 함수의 이름이다.
  b.addEventListener("mouseover", function (e) {
    // ㄴ "b" 함수로 등록한 각 풍선에 마우스오버를 하였을 경우 실행한 함수를 등록
    b.style.backgroundColor = "#ededed"; /* ededed 색상은 하얗게 하여 안보이게함 */
    b.textContent = "POP!"; /* textContent 는 innerText와 거의 동일하다. */
    if (!b.classList.contains("popped")) {
      // ㄴ마우스오버를 한 경우 클래스리스트 contains를 사용하여
      // 풍선이 터졌는데 "popped" 텍스트가 없는 경우 아래 true 값을 실행한다
      // 아래를 보면 트루값의 경우 "popped"를 카운트 해준다.
      popped++; /* 선언한 popped의 수치를 +1로 카운트해준다. */
    }
    b.classList.add("popped"); 
    // ㄴ위에서 popped를 +1 카운트 해준뒤 "popped" 클래스를 추가하여
    // 다음에 또 마우스 오버를 하였을 경우 위 if 트루값에서 popped를 +1 카운트하지
    // 않도록 해준다.
    checkAllPopped(); 
    // ㄴ위를 모두 실행 후 첵올팝드 펑션을 실행한다. 
    // 24개 풍선이 터졌는지 확인 후 이벤트를 실행하는 함수
  });
});

function checkAllPopped() {
  if (popped === 24) { 
    // ㄴpopped 텍스트가 24개라는건 풍선이 모두 터진것 이므로 이때 완료 알림을 실행한다.
    gallery.innerHTML = "";   
    // ㄴ풍선을 모두 터트리면 풍선이 들어있는 div 박스를 공백으로 만든다.
    message.style.display = "block";
    // ㄴ풍선을 모두 터트리면 알림 메시지에 디스플레이 블록을 입혀 보이게 만든다.
  }
}
