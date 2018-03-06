/**
 * Created by tingyu on 2017/4/3.
 */
$(function () {

    /** 刷新当前iframe页面 */
    $(".roll-right.refresh").click(function () {
        var id = $(".J_menuTab.active").data("id").trim();
        var iframe = $(".J_iframe[data-id='"+ id + "']")[0];
        iframe && iframe.contentWindow.location.reload();
    });
})
