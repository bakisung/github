// 1
const userName = "Smith";
console.log(userName); // Smith

// // 2
const x = "Hello ";
const y = "world";
console.log(x + y); // Hello World

// // 3
const div = document.querySelector("#quiz3")           
console.log(div.innerHTML); // 나는 퀴즈3번입니다.

// // 4 
const divList = document.querySelectorAll("div")
console.log(divList[3].innerHTML); // 마지막 태그

// // 5
const cars = ["volvo", "jeep", "Mercedes"];
const car = cars.slice(0, 1);
console.log(car); // ['volvo']

// // 6 
const fruits = ["apple", "orange", "mango"];
const fruit = fruits.splice(2,1,"banana");
console.log(fruits); // ["apple", "orange", "banana"]

// // 7 /* 문제 의도와 어떻게 응용되는건지 모르겠음 수업때 하던 호출 형태와 다름 */
const 함수 = function () {
  console.log("Test");
};
함수(); // 여기에 함수호출을 적으시오  // Test

// // 8
const myFunc1 = function(x) {
  console.log(x);
};
myFunc1("함수 파라미터"); // 함수 파라미터

// // 9
const multiply = function ( x  , y  ) {
  console.log( x * y      );
};
multiply(2, 5); // 10

// // 10
const 리턴함수 = function (x) {
  const y = "Hello " + x;
return y; // 여기 코드 추가
};
const value = 리턴함수("Smith");
console.log(value); // Hello Smith
