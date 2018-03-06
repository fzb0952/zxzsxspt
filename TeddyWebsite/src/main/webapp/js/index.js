/**
 * Created by tingyu on 2017/2/25.
 */
$(function () {
    refreshCopyright();
    var contentFrame = document.getElementById('content-frame')
    changeFrameHeight(contentFrame);
    $(window).resize(changeFrameHeight.bind(this, contentFrame));
    $("#content-frame").load(function () {
        changeFrameHeight(contentFrame);
        $(contentFrame.contentWindow || contentFrame.contentDocument.parentWindow).click(onHideNav);
        (contentFrame.contentWindow || contentFrame.contentDocument.parentWindow).addEventListener("touchstart",onHideNav,true);
    });

    /* 导航条切换 */
    $(".navbar-nav li").click(function () {
        $(this).addClass("active");
        $(this).siblings(".active").removeClass("active");

        !$("#nav-collapse").is(":hidden") && hideNav();
    });
    $(document).click(onHideNav);
    document.addEventListener("touchstart",onHideNav,true);
});
/**
 * 针对移动端的导航条自动隐藏
 * @param window
 */
function onHideNav(event) {
    if (!$("#nav-collapse").is(":hidden") && !$("#nav-collapse").hasClass("collapsed") && $(event.target).parents("#navbar").length == 0) {
        hideNav();
    }
}
function hideNav() {
    $('#nav-collapse').addClass("collapsed");
    $('#nav-collapse').attr("aria-expanded", false);
    $("#navbar-collapse").slideUp(500,function () {
        $("#navbar-collapse").removeClass("in");
        $("#navbar-collapse").attr("aria-expanded", false);
        $("#navbar-collapse").removeAttr('style');
    });
}