/**
 * Created by tingyu on 2017/3/7.
 */
var contactForm = null;
var iframePos = 0;
$(function () {
    var currWindowScrollTop = windowScroll();
    introductionScroll(currWindowScrollTop);
    var timer;
    var isScroll = true;
    $(window.parent.window).scroll(function () {
        if (!window) {
            return;
        }
        currWindowScrollTop = windowScroll();
        if (!isScroll) {
            return;
        }
        if (timer) {
            window.clearTimeout(timer);
        }
        // 默认500毫秒后停止滚动
        timer = setTimeout(function () {
            introductionScroll(currWindowScrollTop);
        }, 500);
    });

    if ($(window.parent.window.document).find("#content").offset()) {
        iframePos = $(window.parent.window.document).find("#content").offset().top;
    }

    $("#introduction-title .list-group-item").click(function () {
        isScroll = false;
        var position = $(this).data("position");
        _scroll(position);
        var topPos = iframePos - 50;
        if (window.top.location == self.location) {
            topPos = 0;
        }
        $(window.parent.window.document).find("body,html").animate({
            scrollTop: $(".nav-info[data-position='" + position + "']").offset().top + topPos // 顶部导航栏固定，占据50px
        }, 100, function () {
            setTimeout(function () {
                isScroll = true;
            }, 200);
        });
    });
    // 表单验证
    contactForm = $('#contact-form').validate({
        rules: {
            "contact-name": "required",
            "contact-email": {required: true, email: true},
            "contact-message": "required"
        },
        errorClass: "hidden",
        validClass: ""
    });

    $("input#contact-email").bsSuggest({
        data: {},
        getDataMethod : "data",
        showBtn: false,                   //是否显示下拉按钮
        allowNoKeyword: false,            //是否允许无关键字时请求数据
        processData : function () {
            var dataList = {value : []};
            var val = $("input#contact-email").val().trim().replace(/@.*/,"").replace(/ /g,"");
            dataList.value.push({1: val + "@163.com"});
            dataList.value.push({2: val + "@qq.com"});
            dataList.value.push({3: val + "@126.com"});
            dataList.value.push({4: val + "@mail.com"});
            dataList.value.push({5: val + "@hotmail.com"});
            dataList.value.push({6: val + "@yahoo.com"});
            dataList.value.push({7: val + "@gmail.com"});
            dataList.value.push({8: val + "@sina.com"});
            return dataList;
        },
        inputWarnColor: "rgba(0,0,0,0)",  //输入框内容不是下拉列表选择时的警告色
    });
});

/**
 * 窗口滚动时的需要执行的任务
 * @returns {number}
 */
function windowScroll() {
    var currWinToTop = iframePos == 0 ? 0 : iframePos - 50; // 顶部导航栏固定，占据50px

    var currWindowScrollTop = getWindowScrollTop(window) - currWinToTop > 0 ? getWindowScrollTop(window) - currWinToTop : 0;
    currWindowScrollTop += 10;
    if (window.top.location != self.location) {
        $("#content-right").css('top', currWindowScrollTop + 'px');
    }
    return currWindowScrollTop;
}

/**
 * 切换个人简介导航的位置
 * @param currWindowScrollTop  当前的位置
 */
function introductionScroll(currWindowScrollTop) {
    var currInfo, currInfoTop, currInfoHeight, nextInfo, nextInfoTop;
    $(".nav-info").each(function () {
        currInfo = $(this);
        currInfoTop = currInfo.offset().top;
        currInfoHeight = currInfo.outerHeight(true);
        nextInfo = $(this).next();
        nextInfoTop = nextInfo.length > 0 && nextInfo.offset().top;
        if (currInfoTop <= currWindowScrollTop && currWindowScrollTop <= currInfoTop + currInfoHeight) {
            if (nextInfo.length > 0 &&
                ((nextInfoTop - currWindowScrollTop) <= 30
                || (currInfoTop + currInfoHeight - currWindowScrollTop) < 160)) {
                _scroll(parseInt(nextInfo.data("position")));
            } else {
                _scroll(parseInt(currInfo.data("position")));
            }
        }
    });
}

function _scroll(position) {
    var pos = position;
    var currPosition = $("#introduction-nav .flag").data("position");
    if (position == currPosition) {
        return;
    }
    $("#introduction-nav .flag").stop(true, true);
    $("#introduction-nav .flag").data("position", position);
    $("#introduction-title .list-group-item[data-position='" + pos + "']").siblings(".active").removeClass("active");
    $("#introduction-title .list-group-item[data-position='" + pos + "']").addClass("active");
    $("#introduction-nav .flag").animate({"top": position + 3 + "%"}, 1000)
        .animate({"top": position - 3 + "%"}, 100)
        .animate({"top": position + "%"}, 300, function () {
            $("#introduction-nav .progress-bar").animate({"width": position + "%"}, 100);
        });
}

function contactMe() {
    if (!contactForm.form()) {
        return;
    }
    var message = "<html><body>" +
        "<h3>Name：" + $('#contact-name').val().trim() + "</h3>" +
        "<p>Address：" + $("#contact-email").val().trim() + "</p>" +
        "<p>Message: " + $("#contact-message").val().trim() + "</p>" +
        "</body></html>";
    $("#contact-btn .sk-spinner").removeClass('hidden');
    $("#contact-btn").attr("disabled", "disabled");
    $.ajax({
        url: baseHref + "/mail/contactMe",
        data: {
            "mailInfo.toAddress": "fzwtingyu@163.com",
            "contacterAddress": $("#contact-email").val().trim(),
            "mailInfo.subject": $("#contact-name").val().trim() + " 发来的消息，尽快回复哦！",
            "mailInfo.content": message
        },
        success: function (data) {
            $("#contact-btn .sk-spinner").addClass('hidden');
            $("#contact-btn").removeAttr("disabled");
            data = JSON.parse(data);
            if (data.success) {
                window.parent.sweetAlert({
                    title: data.success,
                    type: "success",
                    showCancelButton: false
                });
            } else {
                window.parent.sweetAlert({
                    title: data.error,
                    type: "error",
                    showCancelButton: false
                });
            }
        },
        error: function () {
            $("#contact-btn .sk-spinner").addClass('hidden');
            $("#contact-btn").removeAttr("disabled");
            window.parent.sweetAlert({
                title: "非常抱歉，邮件发送失败，我将尽快解决！",
                type: "error",
                showCancelButton: false
            });
        }
    });
}