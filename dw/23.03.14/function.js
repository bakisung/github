// 함수의 기본형
// 함수의 선언
const func1 = function() {
    console.log("Hello~");
};

// 함수의 호출. 함수는 반드시 호출이 되어야 내부의 코드가 실행됨.
func1();

const func2 = function(x) {
    // 함수선언문의 ()안의 값(x)을 매개변수(Parameter)라고 한다.
    x = x * 2;
    return x;
};

let value2 = 2;
// 함수호출시 함수의 ()안에 넣어주는 값을 인수(Argument)라고 한다.
value2 = func2(value2);
console.log(value2);

let value3 = 3;
value3 = func2(value3); /* (value3)가 인수(argument). */
console.log(value3);

const greet = function(userName) {
    console.log("안녕하세요. " + userName + "님");
};

// 함수호출
greet("박희성");

const multiply = function(x, y) {
    return x * y;
};

const value4 = multiply(4, 5);
console.log(value4);
console.log(multiply(4, 5));

// 플러스 함수
const pls = function(x, y) {
    return x + y;
};
console.log(pls(2, 8));

// 3개 이상의 매개변수(parameter)
const average = function(w, x, y, z) {
    const sum = w + x + y + z
    return sum / 4;
    // return (w + x + y + z) / 4;
};
const 평균값 = average(3, 3, 3, 3)
console.log(평균값);

console.log(average(3, 3, 3, 3));

// 평균구하기 함수의 배열버전
const average2 = function (x) {
    let sum = 0;
    for (let i=0; i<x.length; i++){
        sum = sum + x[i];
    }
    return sum / x.length; /* 평균을 구하기 위해 총합을 배열의 길이로 나눈다 */
};
const arr = [3, 3, 3, 3];
console.log(average2(arr));

console.log(average2([3, 3, 3, 3]));

// 함수선언의 다른 방법
const display = function () {
    console.log("Display");
};
// function display() {
//     console.log("Display")
// }
display();



const greet3 = function(userName) {
    let returnValue = "Hello " + userName;
    return returnValue;
};
const userName = prompt("이름을 적어주세요 :");
const greet3Return = greet3(userName);
console.log(greet3Return);