const elem = document.querySelector("p").innerText;
console.log(elem, typeof elem);
// string method 문자열 메쏘드
console.log(elem.length);
document.querySelector("#demo").innerHTML = elem.length

// Slice
let text = "Apple, Banana, kiwi";
let part = text.slice(7, 13); /* slice 메쏘드가 텍스트를 잘라서 리턴한다. */
console.log(part);
console.log(text.slice(7));

// Replace
console.log(text.replace("Apple", "Orange"));

// UpperCase, LowerCase
console.log(text.toUpperCase())
console.log(text.toLowerCase())

// Concat
let text1 = "Hello";
let text2 = "World";
let text3 = text1.concat(" " + text2);
console.log(text3);