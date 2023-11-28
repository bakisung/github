$(document).ready(function(){

    // 23.03.16 첫번째 문제
        // 아이디 추가 버튼 클릭 이벤트
        $('#addBtn').on('click', function () {
            $('div#div').attr('class', 'style');
        });
        
        // 아이디 삭제 버튼 클릭 이벤트
        $('#removeBtn').on('click', function () {
            $('div#div').removeAttr('class', 'style');
        });
        
        // 아이디 토글 버튼 클릭 이벤트
        $('#toggleBtn').on('click', function () {
            $('div#div').toggleClass('style');
        });
    //

    // 23.03.16 두번째 문제
        // 마우스 올렸을 때 이벤트
        $('div#mouse').on('mouseenter', function () {
            $(this).css('background-color', 'red');
            $(this).css('color', 'white');
            $(this).css('font-size', '1.5em');
            $(this).html('Red !!');
        });
        
        // 마우스 치웠을 때 이벤트
        $('div#mouse').on('mouseleave', function () {
            $(this).css('background-color', 'blue');
            $(this).css('color', 'white');
            $(this).html('Blue !!');
        });
    //

    // 23.03.16 세번째 문제
        // 브라우저 사이즈 변경 이벤트
        function resizeFunc() {
            $('div#defaultText').html('resize 발생 !!');
        };
        // 마우스 우클릭 시 이벤트
        function rightclickFunc(e) {
            $('div#defaultText').html('마우스 우클릭 !!');
        };
        // 함수 실행
        $(window).on('resize', resizeFunc);
        $(document).on('contextmenu', rightclickFunc);
    //

    // 23.03.16 네번째 문제
        function changeColor(e) {
            const colors = ['red', 'blue', 'yellow', 'purple', 'green', 'orange'];
            const width = $(window).innerWidth();
            const height = $(window).innerHeight();

            if (width < 600) {
                $('div#resizeDiv').css('background-color', colors[0]);
                console.log('width : ' + width)
                console.log('height : ' + height)
            } else if (width >= 600 && width < 700) {
                console.log('width : ' + width)
                console.log('height : ' + height)
                $('div#resizeDiv').css('background-color', colors[1]);
            } else if (width >= 700 && width < 800) {
                console.log('width : ' + width)
                console.log('height : ' + height)
                $('div#resizeDiv').css('background-color', colors[2]);
            } else if (width >= 800 && width < 900) {
                console.log('width : ' + width)
                console.log('height : ' + height)
                $('div#resizeDiv').css('background-color', colors[3]);
            } else if (width >= 1000 && width < 1100) {
                console.log('width : ' + width)
                console.log('height : ' + height)
                $('div#resizeDiv').css('background-color', colors[4]);
            } else if (width >= 1100) {
                console.log('width : ' + width)
                console.log('height : ' + height)
                $('div#resizeDiv').css('background-color', colors[5]);             
            };
        };

        $(window).on('resize', changeColor);
    //

    // 23.03.17 첫번째 문제
        function verify() {
            const inputNumber = $('input#inputNumber').val();   // 사용자가 입력한 숫자
            const randumNumber = Math.ceil(Math.random() * 10); // 0 ~ 9를 올림한다.
            
            if (!isNaN(inputNumber) && inputNumber >= 0 && inputNumber < 11) {
                $('p#verifyNumber').html('<br>당신이 입력한 숫자는 " ' + inputNumber + ' " 입니다.<br>제가 선택한 숫자는 " ' + randumNumber + ' " 입니다.');
                if (inputNumber == randumNumber) {
                    $('p#answer').html('정답입니다 !!')
                } else {
                    $('p#answer').html('오답입니다 ㅠㅠ')
                }
            } else if(isNaN(inputNumber)) {
                $('p#verifyNumber').html('숫자만 입력하세요.');
            } else if (inputNumber < 0 || inputNumber > 10) {
                $('p#verifyNumber').html('허용 범위를 초과했습니다.');
            }
            $('input#inputNumber').val(''); // 기존에 입력한 숫자를 초기화
        };
        
        $('button#verifyBtn').on('click', verify);
    //

    // 23.03.17 두번째 문제
    function userName() {
        const inputName = $('input#inputName').val();
        $('h3#userName').html('환영합니다. "' + inputName + '" 님');
    }

    $('button#nameBtn').on('click', userName);

    // 23.03.20 셀렉트 문제
    function callback() {
        const selectOption = $('select#optionList option:selected').val();
        $('h3#selectOption').html('당신이 선택한 옵션은 "' + selectOption + '" 입니다.');
    }
    
    $('select#optionList').on('change', callback);

});