const navbar = document.getElementById("navbar");
const content = document.querySelector(".content");
const offset = navbar.offsetTop;



// 1. 대상을 만든다.
// 대상은 window 이므로 추가로 지정할 필요 없다. 

// 2. 함수를 만든다.
    const navHold = function(e) {
        console.log(window.scrollY, offset);
        if (window.scrollY >= offset) {
            navbar.classList.add("sticky");
            content.classList.add("topSpace");
        } else {
            navbar.classList.remove("sticky");
            content.classList.remove("topSpace");
        }
    };
    // classList 는 해당 요소에 클래시를 추가(add) 제거(remove) 전환등을 할 수 있게 해줍니다
    // sticky 클래스는 CSS에서 정의되어 있어, 해당 요소가 고정되는 스타일을 제공합니다.

// 3. 대상의 이벤트와 함수를 등록한다.
window.addEventListener("scroll", navHold);