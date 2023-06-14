// 1 아래 태그를 만들어서 body태그에 appendChild 하세요.
// <div>Hello World</div>

// 2 아래 태그를 만들어서 body태그에 appendChild 하세요.
// <button>click</button>

// 3 2번에서 만든 버튼을 누르면 바탕화면 색이 바뀌게 하세요.

// 4 아래 태그를 만들어서 body태그에 appendChild 하세요. For문과 cars배열을 이용하면 좋아요 ^^
// <ol>
//    <li>페라리</li>
//    <li>포르쉐</li>
//    <li>람보르기니</li>
// </ol>
const cars = ["페라리", "포르쉐", "람보르기니"];

// 5
const typefunc = function (x) {
  return typeof x;
};
console.log(typefunc(@@@@)); // string
console.log(typefunc(@@@@)); // number
console.log(typefunc(@@@@)); // boolean

// 6
const arr = [
  [1, 2, 3],
  ["a", "b", "c"],
];
console.log(@@@@); // [1,2,3]
console.log(@@@@); // a

// 7
let floatNum2 = 5.12;
floatNum2 = Math.@@@@(floatNum2);
console.log(floatNum2); // 5

// 8
let floatNum3 = 1.3;
floatNum3 = Math.@@@@(floatNum3);
console.log(floatNum3); // 2

// 9
const myFunc1 = function (x) {
  return Math.@@@@(x);
};
console.log(myFunc1(3.1)); // 3
console.log(myFunc1(3.5)); // 4

// 10
function Member(name, age, height) {
  this.name = name;
  this.age = age;
  this.height = height;
  this.print = function () {
    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  };
}
const user1 = new Member("John", 30, 175);
const str = user1.print();
console.log(str); // John, 30, 175

// 11
const rangeFunc = function (x) {
  if (@@@@) {
    console.log("100 미만");
  } else if (@@@@@@@@@@@@) {
    console.log("100 이상 200 미만");
  } else {
    console.log("200 이상");
  }
};
rangeFunc(90); // 100 미만
rangeFunc(100); // 100 이상 200 미만
rangeFunc(200); // 200 이상

// 12
const d1 = @@@@;
console.log(d1); // 현재 시간

// 13
console.log(d1.@@@@); // 2023
console.log(d1.@@@@); // 11
console.log(d1.@@@@); // 25

// 14 2023년 1월 1일의 날짜객체를 d3에 만드세요.
const d3 = @@@@
console.log(d3.@@@@); // 1672498800000

// 15 배열내의 숫자를 모두 합하는 코드를 만드세요.
const arrays = [1, 2, 3, 4, 5, 6, 7];
let sum = 0;
arrays.forEach(function (a) {
  @@@@@@@@@@@@@@@@
});
console.log(sum); // 28

// 16
const days = ["일", "월", "화", "수", "목", "금", "토"];
const 요일함수 = function (x) {
  days.forEach(function (d, i) {
    if (@@@@ === @@@@) {
      console.log(@@@@);
    }
  });
};
요일함수(d1.@@@@); // 목
