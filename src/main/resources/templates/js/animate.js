// 작성자 : MoonNight285
// 마지막 수정일 : 2022-12-12
// 로그인 실패시 small 태그의 움직임을 줘서 유저에게 알려주는 효과를 만들어주는 함수
// smallTag => small 태그의 아이디값을 넘겨주세요.
function runLoginFailAnimate(smallTag) {
    const userCheckResult = smallTag;
    
    userCheckResult.css("color", "red");
    userCheckResult.text("아이디 혹은 비밀번호가 틀렸습니다.");
    
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
