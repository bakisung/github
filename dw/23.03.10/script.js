const divElement = document.querySelector("#div"); /* assignment 뜻 : 선언한다. */
divElement.innerHTML = "yeah";
// divElement 같은 작명 방법을 CamelCase 라고 함
console.log("divElement".innerHTML);

document.querySelector("#div").innerHTML = "fuck1";
    document.querySelector("#div").style.color = "red";
    document.querySelector("#div").style.backgroundColor = "yellow";
    document.querySelector("#div").style.fontSize = "40px";

document.querySelector(".class").innerHTML = "fuck2";
document.querySelector("p").innerHTML = "fuck3";
document.querySelector("span").innerHTML = "fuck4";