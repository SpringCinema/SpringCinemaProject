// 로그아웃 처리를 위해 선언
$(document).ready(function() {
    const aHeaderLogout = $("#a-i-header-logout");
    const btnHeaderLogout = $("#btn-i-header-logout");

    aHeaderLogout.on("click", function() {
        btnHeaderLogout.click();
    });
})