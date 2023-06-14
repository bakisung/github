// 1
const saveName = "user";
localStorage.setItem("saveName", saveName);
console.log(localStorage.getItem("saveName")); // user

// 2 버튼1을 누르면 로그창에 "버튼클릭"
const btn1 = document.querySelector(".btn1");
const onClick = function () {
  console.log("버튼 클릭");
};
btn1.addEventListener("click", onClick); // 버튼 클릭

// 3 마우스 올리면 백그라운드컬러 바뀜
const div1 = document.querySelector(".div1");
const onMouse = function () {
  div1.style.backgroundColor = "lightblue";
};
div1.addEventListener("mouseenter", onMouse);

// 4 이름을 쓰고 엔터 또는 버튼클릭시 로그창에 "제출"
const form = document.querySelector(".form");   // submit 이벤트의 대상은 어떤 태그요소??
const onSubmit = function (e) {
  e.preventDefault(); 
  console.log("제출");
};
form.addEventListener("submit", onSubmit); /* 뭐를 / 어떻게 하면 / 이렇게 된다 */

// 5 브라우저창크기를 변경하면 로그창에 "Resize"
const onSize = function () {
  console.log("Resize");
};
window.addEventListener("resize", onSize);

// 6 삼항연산자
const x = 5;
const ans6 = x > 4 ? "aaaa" : "bbbb";
console.log(ans6); // aaaa

// 7
const user = {
  name1: "John",
  age: 25,
  print: function () {
    return user.name1 + ", " + user.age;
  },
};
console.log(user.print()); // John, 25

// 8
const 학생 = {
  name: "Tom",
  age: 20,
  marks: {
    science: 70,
    math: 75,
  },
};
console.log(학생.marks.math); // 75

// 9
const student = {
  firstName: "Allen", //키 : 밸류
  class: 10,
};
console.log(student["class"]); // 10

// 10
const fruits = ["apple", "banana", "mango"];
let toString = "";  // 문자열의 초기화??
fruits.forEach(function (fruit) {
  toString = toString + fruit + " ";
});
console.log(toString); // apple banana mango

// 11
fruits.forEach(function (fruit, index) {
  if (fruit === "mango") {
    console.log(`mango는 ${index}번 인덱스`);
  }
}); // mango는 2번 인덱스

// 12
let i = 0;
for (i; i < fruits.length; i++) {
  if (fruits[i] === "banana") {
    break;
  }
}
if (i === 1) {
  console.log("성공");
} else {
  console.log("실패");
}

// 13
let str = "";
for (let i = 0; i < fruits.length; i++) {
  if (i > 1) {
    continue;
  }
  str = str + fruits[i] + " ";
}
console.log(str); // apple banana

// 14 특정 클래스를 가지고 있는지 확인하려면??
const divs = document.querySelectorAll(".div2");
divs.forEach(function (div) {
  if (div.classList.contains("2nd")) {
    div.style.color = "blue";
  }
});

// 15 태그 요소 만들기
const q15 = document.querySelector("#Q15");
const span = document.createElement("span");
span.innerHTML = "새로운 span 태그";
q15.appendChild(span);

// 16 빈칸이 HTML파일에 있음
const onButton = function () {
  const btn2 = document.querySelector(".btn2");
  btn2.innerHTML = "성공";
};

// 17 태그요소를 안보이게 하는 방법
const spanHidden = document.querySelector(".hidden");
const btn3 = document.querySelector(".btn3");
const btnDel = function () {
    spanHidden.style.display = "none"; 
};
btn3.addEventListener("click", btnDel);

document.querySelector(".btn3").addEventListener("click", function () {
  spanHidden.style.display = "none";
});

// 18
let strValue = "문자입니다";
strValue = parseInt(strValue, 10); // 숫자로 바꾸기
// strValue가 문자인지 숫자인지 여부를 확인하는 함수이름을 묻는 문제 !!
if (isNaN(strValue)) {
  console.log("문자"); // 문자
} else {
  console.log("숫자");
}

// 19 애로우함수 문제
const myFunc1 = () => {
    console.log("애로우 함수");
};
myFunc1();

// 20
// 애로우함수로 곱하기 함수를 완성하시오
const myFunc2 = (x, y) => x * y;
const ans20 = myFunc2(4, 5);
console.log(ans20); // 20
