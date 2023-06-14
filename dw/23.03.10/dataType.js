// 8종류의 데이터타입
// String, Number, Bigint, Boolean, Undefined, Null, Symbol, Object

// String ** 문자열
const str1 = "smith";
const str2 = "1";
const str3 = "true";
console.log(str1, typeof str1)

// Number ** 숫자열
const num1 = 1;
const num2 = 11234;
const num3 = 1123541451245;
const counter = 0;
console.log(num1, typeof num1);

// Boolean ** 참,거짓
const bool1 = true;
const bool2 = false;
console.log(bool1, typeof bool1);

// Object **
const obj1 = [1,2,3,4,5,6,7,"Smith"]; /* 배열, Array */
const obj2 = {
    userName: "Smith",
    userAge: 25,
};
console.log(obj1, typeof obj1)

// Undefined
/* const undef1; <<-- 상수(const)는 반드시 값을 가져야한다. */
// let은 값을 지정하지 않아도 된다
let undef2;
console.log(undef2, typeof undef2);

// Null <<-- 아무것도 없다는 뜻
let nulValue = null;
let objectType = null; /* 오브젝트의 초기값으로 null을 사용할 수 있다. */
console.log(nulValue, typeof nulValue);