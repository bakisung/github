// 1. 인풋창에 1~10 숫자 입력하고 버튼 클릭
// 2. 창 밑에 1~10 랜덤하게 출력
function verify() {
    let input = document.querySelector("#guessed").value;
    input = parseInt(input, 10);
    const random = Math.floor(Math.random() * (11 - 1)) + 1;
    const div = document.querySelector("div");


    
// 3. 내가 입력한 숫자와 출력된 숫자가 같으면 "win"
// 4. 숫자가 다르면 "lose"
    if (input === random) {
        div.innerHTML = random + ": ㅊㅋ";
    } else {
        div.innerHTML = random + ": ㅂㅅ";
    }
};