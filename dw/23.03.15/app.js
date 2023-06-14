// 여러종류의 변수 선언 *중요 - 여기 있는 종류들은 자연스럽게 나올 수 있어야한다.
const num = 1; /* 숫자 */
const str = "Smith"; /* 문자 */
const bool = true; /* 불린(참 or 거짓) */
const 숫자배열 = [1, 2, 3, 4]; /* 배열 */
const 문자배열 = ["a","b","c"]; /* 배열 */
const 함수 = function() {};
const 객체 = { user : "Smith", age : 20};
const html요소1 = document.querySelector("#demo");
const html요소2 = document.querySelector(".style");
const html요소3 = document.querySelector("div");

let num2 = num * 10; /* num2 = 10 */
let str2 = str + "븅딱" /* str2 = "Smith븅딱" */
let bool2 = !bool; /* 느낌표 "!"는 not이라는 부정이다. 즉 bool2 = false이다. */
let 숫자배열2 = 숫자배열.slice(3); /* 숫자배열의 숫자 4를 잘라서 리턴해준다. */ 
let 문자배열2 = 문자배열.splice(0, 2); /* 스플라이스(몇번째부터, 몇개를 잘라서 자신에게 가져온다.) */
                                        console.log(문자배열2); console.log(문자배열);
html요소1.innerHTML = "DEMO";
html요소2.innerHTML = "STYLE";
html요소3.innerHTML = "TEXT";

const num함수 = function(x) {
    return x * 10;
};
let num3 = num함수(num); /* num3 = 10 */
console.log(num3)

const str함수 = function() {
    return str + "븅딱";
};
let str3 = str함수(str); /* str3 = "Smith븅딱" */

const bool함수 = function(bool) {
    return !bool;
};
let bool3 = bool함수(bool); /* bool3 = false */

// 이해 안됐음
const 숫자배열함수 = function(숫자배열, i) { /* 여기서 i 자리는 몇번째 자리를 지울건지 뜻한다 */
    return 숫자배열.slice(i);
};
let 숫자배열3 = 숫자배열함수(숫자배열, 3); /* 숫자배열3=[4] */

// 이해 안됐음
const 문자배열함수 = function(문자배열, x, y) {
    return 문자배열.splice(x, y);
};
let 문자배열3 = 문자배열함수(문자배열, 1, 2); /* 문자배열=["a"] 문자배열3=["b","c"] */

// for문 - 반복숙달
// 1. 하드코드의 예시이다. 좋지않은 코드이다.
// const divList = document.querySelectorAll("div");

// const html함수 = function(divList) {
//     for(let i=0; i<divList.length; i++){
//         if (i === 0) {
//             divList[i].innerHTML = "TEXT";
//         } else if (i === 1) {
//             divList[i].innerHTML = "DEMO";
//         } else if (i === 2) {    
//             divList[i].innerHTML = "STYLE";
//         }
//     }
// };
// html함수(divList);

// 2. 소프트코드의 예시이다. 좋은 코드이다.
const divList = document.querySelectorAll("div");
const text배열 = ["TEXT", "DEMO", "STYLE"]

const html함수 = function(divList, text배열) {
    for(let i=0; i<divList.length; i++){
        divList[i].innerHTML = text배열[i];
    };
};
html함수(divList, text배열);