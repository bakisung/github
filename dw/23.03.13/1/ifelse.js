let hour = 12;
let greeting = "";

if (hour < 12) { /* 항상 가장 앞에 존재 if */
    greeting = "Good Morning";
}
else if (hour < 18) { /* 가운데 사이에 존재 else if */
    greeting = "Good Day";
}
else { /* 항상 가장 마지막에 존재 else */
    greeting = "good Evening";
}
console.log(greeting);

// 같으면(==), 데이터 타입까지 같으면(===), 
// 다르면(!=),데이터 타입까지 다르면(!==)
// 크거나 같으면(>=)
// let login = true;
// if (login) {
//     alert("Welcome~ user!!");
// } else {
//     alert("Please login..")
// }

const str = "1";
const num = 1;
if (str === num) {
    console.log("같다");
} else {
    console.log("다르다")
}

// 논리연산자 &&(and), ::(or), !(not)

//  && (and)
const x = 6;
const y = 3;
// if (x > 5 && y < 5) {
//     alert("Window popup");
// } else {
//     alert("뷁");
// }

// || (or)
// if (x > 5 || y < 5) {
//     alert("Window popup");
// }

// ! (not)
const isLoginUser = true;
if (!isLoginUser) {
    alert("Please Log in");
} else {
    alert("Welcome");
}

// 삼항연산자
// if~else의 한줄 버전
const age = 20;
// let votable = (age < 18) ? "Too young" : "Old enough";
console.log((age < 18) ? "Too young" : "Old enough");