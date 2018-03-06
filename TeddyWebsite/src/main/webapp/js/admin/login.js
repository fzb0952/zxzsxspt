/**
 * Created by tingyu on 2017/4/2.
 */

if (window.top !== window.self) {
    window.top.location = window.location;
}

$(function () {
    $("input#username").bsSuggest({
        data: {value:[]},
        getDataMethod : "data",
        clearable: true,                   //可清除已输入内容
        showBtn: false,                   //是否显示下拉按钮
        allowNoKeyword: false,            //是否允许无关键字时请求数据
        processData : function () {
            var dataList = {value : []};
            var val = $("input#username").val().trim().replace(/@.*/,"").replace(/ /g,"");
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

    // 表单验证
    contactForm = $('#login-form').validate({
        rules: {
            "username": {required: true, email: true},
            "password": "required"
        },
        errorClass: "hidden",
        validClass: ""
    });
});