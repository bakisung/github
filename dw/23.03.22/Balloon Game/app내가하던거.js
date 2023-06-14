const balloons = document.querySelectorAll(".balloon");
const clearDiv = document.querySelector("#yay-no-balloons");
const balloonsDiv = document.querySelector("#balloon-gallery");
console.log(balloons);
// 터진 풍선들을 갯수로 정의한다.
// 갯수가 24개가 되면 클리어 알림을 띄워주는 이벤트를 설정한다.
let balloonCount = 0;

// 24개의 풍선 모두 각각 마우스오버할 경우에 터지는 효과를 준다.
balloons.forEach(balloon => {
  function 마우스오버(e) {
    balloon.style.backgroundColor = "#ededed";
    balloon.innerHTML = "POP!";
    console.log(balloonCount);
    
    // 한번 터진 풍선은 더 이상 터지지 않는다.
    if (!balloon.classList.contains("popBalloon")) {
      balloonCount = balloonCount + 1;
      balloon.classList.add("popBalloon")
    }
    // 풍선 24개가 모두 터졌을때의 클리어 화면이다.
    if (balloonCount == 24) {
      clearDiv.style.display = "block";
      balloonsDiv.style.display = "none";
    }
  }
  balloon.addEventListener("mouseover", 마우스오버);
});