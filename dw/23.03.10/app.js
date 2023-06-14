// 변수를 공부해 보자!
// 변수를 선언하는 3가지 방법
// var = 지금은 쓰이지 않는것 (중복된걸 오류로 표시해주지 않음)
var value = 1;
value = 2;
value = 'Smith';
value = 5;
value = value + 1;
var value = 1000;
console.log(value);




// let
let counter = 1;
// let counter = 2 이중선언 에러 + 값을 바꿀 수 있다
counter = counter + 1;
console.log(counter);

// const
const url = "www.naver.com";
// const url = 2; 이중선언 에러
// url = 2; 상수는 값을 바꿀 수 없다
console.log(url)