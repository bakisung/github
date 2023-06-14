// 1
const saveName = "user";
localStorage.@@@@("saveName", saveName);
console.log(localStorage.@@@@("saveName")); // user

// 2 버튼1을 누르면 로그창에 "버튼클릭"
const btn1 = document.querySelector(".btn1");
const onClick = function () {
  console.log("버튼 클릭");
};
btn1.addEventListener("@@@@", onClick); // 버튼 클릭

// 3 마우스 올리면 백그라운드컬러 바뀜
const div1 = document.querySelector(".div1");
const onMouse = function () {
  div1.@@@@.@@@@ = "lightblue";
};
div1.addEventListener("@@@@", onMouse);

// 4 이름을 쓰고 엔터 또는 버튼클릭시 로그창에 "제출"
const @@@@ = @@@@@@@@@@@@@@@@   // submit 이벤트의 대상은 어떤 태그요소??
const onSubmit = function (e) {
  @@@@(); 
  console.log("제출");
};
@@@@.addEventListener("submit", onSubmit);

// 5 브라우저창크기를 변경하면 로그창에 "Resize"
const onSize = function () {
  console.log("Resize");
};
@@@@.addEventListener("@@@@", onSize);

// 6 삼항연산자
const x = 5;
const ans6 = x > 4 @@@@ "aaaa" @@@@ "bbbb";
console.log(ans6); // aaaa

// 7
const user = {
  name1: "John",
  age: 25,
  print: function () {
    return user.name1 + ", " + user.age;
  },
};
console.log(@@@@); // John, 25

// 8
const 학생 = {
  name: "Tom",
  age: 20,
  marks: {
    science: 70,
    math: 75,
  },
};
console.log(@@@@); // 75

// 9
const student = {
  firstName: "Allen", //키 : 밸류
  class: 10,
};
console.log(student[@@@@]); // 10

// 10
const fruits = ["apple", "banana", "mango"];
let toString = @@@@;  // 문자열의 초기화??
fruits.forEach(function (@@@@) {
  toString = toString + fruit + " ";
});
console.log(toString); // apple banana mango

// 11
fruits.forEach(function (@@@@, @@@@) {
  if (fruit === "mango") {
    console.log(`mango는 ${index}번 인덱스`);
  }
}); // mango는 2번 인덱스

// 12
let i = 0;
for (i; i < fruits.length; i++) {
  if (fruits[i] === "banana") {
    @@@@;
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
    @@@@;
  }
  str = str + fruits[i] + " ";
}
console.log(str); // apple banana

// 14 특정 클래스를 가지고 있는지 확인하려면??
const divs = document.@@@@(".div2");
divs.forEach(function (div) {
  if (div.classList.@@@@("2nd")) {
    div.style.color = "blue";
  }
});

// 15 태그 요소 만들기
const q15 = document.querySelector("#Q15");
const span = document.@@@@("span");
span.innerHTML = "새로운 span 태그";
q15.@@@@(span);

// 16 빈칸이 HTML파일에 있음
const onButton = function () {
  const btn2 = document.querySelector(".btn2");
  btn2.innerHTML = "성공";
};

// 17 태그요소를 안보이게 하는 방법
const spanHidden = document.querySelector(".hidden");
document.querySelector(".btn3").addEventListener("click", function () {
  spanHidden.@@@@.@@@@ = @@@@;
});

// 18
let strValue = "문자입니다";
strValue = @@@@(strValue, 10); // 숫자로 바꾸기
// strValue가 문자인지 숫자인지 여부를 확인하는 함수이름을 묻는 문제 !!
if (@@@@(strValue)) {
  console.log("문자"); // 문자
} else {
  console.log("숫자");
}

// 19 애로우함수 문제
const myFunc1 = () @@@@ {
  console.log("애로우 함수");
};
myFunc1();

// 20
// 애로우함수로 곱하기 함수를 완성하시오
const myFunc2 = @@@@ => @@@@;
const ans20 = myFunc2(4, 5);
console.log(ans20); // 20
