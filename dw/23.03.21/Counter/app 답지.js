// 대상 선언
const span = document.querySelector("#value");
const decrease = document.querySelector(".btn.decrease")
const reset = document.querySelector(".btn.reset")
const increase = document.querySelector(".btn.increase")

// 함수 선언
const decrease함수 = function (e) {
    let count = document.querySelector("#value").innerHTML
    count = parseInt(count, 10);
    count = count - 1;
    span.innerHTML = count;
    console.log(e);
    color함수();
}

const reset함수 = function (e) {
    let count = document.querySelector("#value").innerHTML
    count = parseInt(count, 10);
    count = 0;
    span.innerHTML = count;
    console.log(e);
    color함수();
}

const increase함수 = function (e) {
    let count = document.querySelector("#value").innerHTML;
    count = parseInt(count, 10);
    count = count + 1;
    span.innerHTML = count;
    console.log(e);
    color함수();
}

const color함수 = function (e) {
    let numColorTag = document.querySelector("#value");
    numColor = parseInt(numColorTag.innerHTML, 10);

    if (numColor < 0) {
        numColorTag.style.color = "red";
    } else if(numColor > 0) {
        numColorTag.style.color = "blue";
    } else {
        numColorTag.style.color = "black";
    }
}

// 함수와 이벤트 등록
decrease.addEventListener("click", decrease함수);
reset.addEventListener("click", reset함수);
increase.addEventListener("click", increase함수);
