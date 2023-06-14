





const fruits = ["apple", "orange", "Banana", "Pear", "Pineapple"] /* 1. 지정 */
// for (const fruit of fruits) {
//     console.log(fruit);
// }

// 전통적인 For loop 으로 값 구하기
for(let i=0; i<fruits.length; i++) {
    console.log(fruits[i]);
}

console.log("------------------")

// ForEach 으로 값 구하기
fruits.forEach(function(fruit) {
    console.log(fruit);
})

// 함수의 선언
const logging = function (log) {
    console.log(log);
}

// 함수의 호출
const str = "함수의 호출";
logging("src");