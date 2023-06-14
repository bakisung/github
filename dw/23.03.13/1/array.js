// Array 어레이, 배열
const cars = ['jeep', 'volvo', 'bmw'];
console.log(cars);
console.log(cars.length);
console.log(cars[0]);

// Array methods 배열의 메쏘드
// push 가장 뒤에 추가
cars.push("Hyundai");
console.log(cars)

// pop 마지막 아이템 삭제
cars.pop(cars);
console.log(cars);

// slice 잘라내기
const a = cars.slice(1);
console.log(a);
console.log(cars);

const b = cars.slice(0, 2);
console.log(b);
console.log(cars);

const c = cars.slice(0);
console.log(c);
console.log(cars);

// 배열의 복사
// const copy = cars;
const copy = cars.slice(0)
console.log(copy);

copy[0] = "Hyunday";
console.log(copy);

// 문제점 등장 - 값 복사와 참조복사의 차이로 발생함
// slice(0)을 이용하여 강제로 값복사를 실행시키면 문제를 해결할 수 있다.
console.log(cars);

// splice
const spliceValue = cars.splice(1,2); /* 1번 인덱스로 부터, 1개를 뺀다 */
console.log(spliceValue);
console.log(cars);

// 1번부터 0개를 빼고 현대 르노 기아를 넣는다
cars.splice(1,0,"hyundai","rno","kia");
console.log(cars)

// 상수로서의 배열
const 과일들 = ["사과", "배", "귤", "복숭아"];
과일들[0] = "오렌지";
// 과일들 = ["Banana"]; 이렇게 하면 에러가 발생한다, 상수 변경 시도이기 때문
console.log(과일들);