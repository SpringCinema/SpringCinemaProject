// 작성자 : MoonNight285
// 마지막 수정일 : 2022-12-13
// 로그인 실패시 small 태그의 움직임을 줘서 유저에게 알려주는 효과를 만들어주는 함수
// smallTag => small 태그의 아이디값을 넘겨주세요.
// errorMsg => 표시할 에러 메세지 내용
function runUserCheckFailAnimate(smallTag, errorMsg) {
    const userCheckResult = smallTag;
    
    userCheckResult.css("color", "red");
    userCheckResult.text(errorMsg);
    
    userCheckResult.animate({
        marginTop : 10
    }, 150);
    userCheckResult.animate({
        marginTop : 0
    }, 150);
    userCheckResult.animate({
        marginTop : 5
    }, 150);
    userCheckResult.animate({
        marginTop : 0
    }, 150);
    userCheckResult.animate({
        marginTop : 3
    }, 150);
    userCheckResult.animate({
        marginTop : 0
    }, 150);
}

// 작성자 : MoonNight285
// 마지막 수정일 : 2022-12-13
// 로그인 성공시 small 태그의 색상을 변경해서 유저에게 알려주는 효과를 만들어주는 함수
// smallTag => small 태그의 아이디값을 넘겨주세요.
// successMsg => 성공시 출력할 메세지 값
function runUserCheckSuccessEffect(smallTag, successMsg) {
    const userCheckResult = smallTag;
    
    userCheckResult.css("color", "green");
    userCheckResult.text(successMsg);
}
