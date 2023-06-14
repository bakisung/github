let gallery = document.querySelector("#balloon-gallery");
const balloons = document.querySelectorAll(".balloon");
let message = document.querySelector("#yay-no-balloons");
let counter = 0;

// For Loop
// 1. removeEventListener를 이용하는 방법
for (let i = 0; i < balloons.length; i++) {
  const callback = function () {
    balloons[i].style.backgroundColor = "#ededed";
    balloons[i].innerHTML = "POP";
    counter = counter + 1;
    balloons[i].removeEventListener("mouseenter", callback);
    if (counter === balloons.length) {
      message.style.display = "block";
      gallery.innerHTML = "";
    }
  };
  balloons[i].addEventListener("mouseenter", callback);
}

// 2. addEventListener의 3번째 파라미터를 이용하는 방법 - 이벤트 발생을 단 한번으로 제한시킴 {once : true}
// for (let i = 0; i < balloons.length; i++) {
//   balloons[i].addEventListener(
//     "mouseenter",
//     function () {
//       balloons[i].style.backgroundColor = "#ededed";
//       balloons[i].innerHTML = "POP";
//       counter = counter + 1;
//       if (counter === balloons.length) {
//         message.style.display = "block";
//         gallery.innerHTML = "";
//       }
//     },
//     { once: true }
//     // addEventListener("mouseenter", function, { once : true })
//     // mouseenter 이벤트가 대상에서 단 한번만 발생하도록 함
//   );
// }

// 3. counter를 사용하지 않는 방법
// for (let i = 0; i < balloons.length; i++) {
//   balloons[i].addEventListener("mouseenter", function () {
//     balloons[i].style.backgroundColor = "#ededed";
//     balloons[i].innerHTML = "POP";
//     checkBalloons();
//   });
// }
// function checkBalloons() {
//   for (let i = 0; i < balloons.length; i++) {
//     if (balloons[i].innerHTML != "POP") {
//       break;
//     }
//     if (i === balloons.length - 1) {
//       message.style.display = "block";
//       gallery.innerHTML = "";
//     }
//   }
// }
