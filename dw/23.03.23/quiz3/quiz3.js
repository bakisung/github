// 1 아래 태그를 만들어서 body태그에 appendChild 하세요.
// <div>Hello World</div>
const body = document.querySelector("body");
const div1 = document.createElement("div");
div1.innerHTML = "1번 문제 : Hello World";
body.appendChild(div1);

// 2 아래 태그를 만들어서 body태그에 appendChild 하세요.
// <button>click</button>
const button = document.createElement("button");
button.innerHTML = "2번 문제 : " + "Click";
body.appendChild(button);

// 3 2번에서 만든 버튼을 누르면 바탕화면 색이 바뀌게 하세요.
const backColor = document.querySelector("body");
const button함수 = function () {
  div1.style.backgroundColor = "red";
}
button.addEventListener("click", button함수);

// 4 아래 태그를 만들어서 body태그에 appendChild 하세요. For문과 cars배열을 이용하면 좋아요 ^^
// <ol>
//    <li>페라리</li>
//    <li>포르쉐</li>
//    <li>람보르기니</li>
// </ol>
const cars = ["페라리", "포르쉐", "람보르기니"];
const ol = document.createElement("ol");
ol.innerHTML = "4번 문제 : 나는 ol";
body.appendChild(ol);

for (let i = 0; i < cars.length; i++) {
  const li = document.createElement("li");
  li.innerHTML = cars[i];
  ol.appendChild(li);
};

// 5
const typefunc = function (x) {
  return typeof x;
};
console.log(typefunc("")); // string
console.log(typefunc(12)); // number
console.log(typefunc(true)); // boolean

// 6
const arr = [
  [1, 2, 3],
  ["a", "b", "c"],
];
console.log(arr[0]); // [1,2,3]
console.log(arr[1][0]); // a

// 7
let floatNum2 = 5.12;
floatNum2 = Math.floor(floatNum2);
console.log(floatNum2); // 5

// 8
let floatNum3 = 1.3;
floatNum3 = Math.ceil(floatNum3);
console.log(floatNum3); // 2

// 9
const myFunc1 = function (x) {
  return Math.round(x);
};
console.log(myFunc1(3.1)); // 3
console.log(myFunc1(3.5)); // 4

// 10
function Member(name, age, height) {
  this.name = name;
  this.age = age;
  this.height = height;
  this.print = function () {
    return this.name + ", " + this.age + ", " + this.height;
  };
}
const user1 = new Member("John", 30, 175);
const str = user1.print();
console.log(str); // John, 30, 175

// 11
const rangeFunc = function (x) {
  if ( x < 100) {
    console.log("100 미만");
  } else if ( x >= 100 && x < 200) {
    console.log("100 이상 200 미만");
  } else {
    console.log("200 이상");
  }
};
rangeFunc(90); // 100 미만
rangeFunc(100); // 100 이상 200 미만
rangeFunc(200); // 200 이상

// 12
const d1 = new Date();
console.log(d1); // 현재 시간

// 13
console.log(d1.getFullYear()); // 2023
console.log(d1.getMonth()+9); // 11
console.log(d1.getDate()); // 23

// 14 2023년 1월 1일의 날짜객체를 d3에 만드세요.
const d3 = new Date(2023, 0, 1); /* 포맷은 여러가지 다른 방법이 있다. */
console.log(d3.getTime()); // 1672498800000

// 15 배열내의 숫자를 모두 합하는 코드를 만드세요.
const arrays = [1, 2, 3, 4, 5, 6, 7];
let sum = 0;
arrays.forEach(function (a) {
  sum = sum + a;
});
console.log(sum); // 28

// 16 
const days = ["일", "월", "화", "수", "목", "금", "토"];
const 요일함수 = function (x) {
  days.forEach(function (d, i) {
    if (i === x) {
      console.log(d);
    }
  });
};
요일함수(d1.getDay(4)); // 목