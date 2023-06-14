// 4개의 div box에 3종류의 이벤트를 등록한다.
    // 1) dragover : 이미지를 드래그해서  1개의 div 위에 있을때 발생
    // 2) dragleave : dragover 이벤트가 발생한 div에서 마우스가 경계를 나가면 발생
    // 3) drop : 1개의 div 위에서 이미지를 드롭하면 발생

// 각 이벤트를 핸들링할 수 있는 코드 작성
    // dragover 이벤트 : 이벤트가 발생한 특정 div요소에 hovered 클래스 추가
    // dragleave 이벤트 : 이벤트가 발생한 특정 div요소에서 hovered 클래스 삭제
    // drop 이벤트 : 이벤트가 발생한 특정 div요소에 image 태그 요소를 붙인다(div에 appendChild)

// div[0].addEventListener("dragover", () => {});

// 1단계 대상 선언
const divList = document.querySelectorAll(".box");
const image = document.querySelector(".image");
console.log(divList);

// 2단계 함수 선언 : 익명함수를 사용하므로 건너뜀


// 3단계 대상에 이벤트 등록 (대상은 div 박스 4개 각각)
// divList[0].addEventListener("dragover", () => {});
// divList[0].addEventListener("dragleave", () => {});
// divList[0].addEventListener("drop", () => {});

// divList[1].addEventListener("dragover", () => {});
// divList[1].addEventListener("dragleave", () => {});
// divList[1].addEventListener("drop", () => {});

// divList[2].addEventListener("dragover", () => {});
// divList[2].addEventListener("dragleave", () => {});
// divList[2].addEventListener("drop", () => {});

// divList[3].addEventListener("dragover", () => {});
// divList[3].addEventListener("dragleave", () => {});
// divList[3].addEventListener("drop", () => {});

// 3단계를 for 문으로 묶으면
for (let i = 0; i < divList.length; i++) {
    // dragover 이벤트의 디폴트동작때문에 drop 이벤트가 발생하지 못함.
    divList[i].addEventListener("dragover", (e) => {
        e.preventDefault(); /* drop이벤트를 막고 있는 */
        divList[i].classList.add("hovered");
    });
    divList[i].addEventListener("dragleave", (ㄷ) => {
        divList[i].classList.remove("hovered");
    });
    divList[i].addEventListener("drop", (ㄷ) => {
        divList[i].appendChild(image);
    });
};