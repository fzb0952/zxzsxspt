/**
 * Created by tingyu on 2017/3/4.
 */
var baseHref = $("#base").data('href').trim();
$(function () {
    $('[data-toggle="tooltip"]').tooltip();

    codeSuggest();
    codeShow();
});

/**
 * 自动更新Copyright的截止年份
 */
function refreshCopyright() {
    var year = new Date().getFullYear();
    if (year > 2017) {
        $("#copyright-year-end").removeClass('hidden').append("-" + year);
    }
}
/* 该方法不适用跨域情况下自适应 */
function changeFrameHeight(iframe) {
    if (iframe) {
        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
        if (iframeWin.document.body) {
            $(iframe).parent().height($(iframeWin.document.body).height());
        }
    }
};

/**
 * 获取window滚动距离
 * @param win
 * @returns {number}
 */
function getWindowScrollTop(win) {
    var scrollTop = 0;
    // 判断是否有父窗口
    win = win.parent.window || win;
    if (win.document.documentElement && win.document.documentElement.scrollTop) {
        scrollTop = win.document.documentElement.scrollTop;
    } else if (win.document.body) {
        scrollTop = win.document.body.scrollTop;
    }
    return scrollTop;
}
/**
 * 获取窗口高度
 * @param win
 * @returns {number}
 */
function getWindowHeight(win) {
    var clientHeight = 0;
    if (win.document.body.clientHeight && win.document.documentElement.clientHeight) {
        clientHeight = (win.document.body.clientHeight > win.document.documentElement.clientHeight) ?
            win.document.body.clientHeight : win.document.documentElement.clientHeight;
    }
    return clientHeight;
}

/**
 * 初始化表单中的 -- 单值代码
 * 必须要引入 bootstrap-suggest.min.js
 */
function codeSuggest() {
    try {
        $("input.code").each(function () {
            var self = this;
            if(!$(self).data("code")){
                console.log("请填写data-code属性",self);
                return;
            }
            var delayUntilKeyup = false;
            var id = $(self).data("id");
            if(undefined == id || id == ""){
                delayUntilKeyup = true;
            }
            $(this).bsSuggest({
                url: baseHref + "/util/code?codeType=" + $(self).data("code"),       //请求数据的 URL 地址
                delayUntilKeyup: delayUntilKeyup,                //获取数据方式为 firstByUrl 时，延迟到有输入/获取到焦点时请求
                idField: "nCode",                               //每组数据的哪个字段作为 data-id，优先级高于 indexId 设置（推荐）
                keyField: "cCodeName",                           //每组数据的哪个字段作为输入框内容，优先级高于 indexKey 设置（推荐）
                effectiveFields: ["nShowOrder","cCodeName"],     //有效显示于列表中的字段，非有效字段都会过滤，默认全部，对自定义getData方法无效
                effectiveFieldsAlias: {                          //有效字段的别名对象，用于 header 的显示
                    nShowOrder : "序号",
                    cCodeName : $(self).data("code-name").trim()
                },
                showHeader: false,                      //是否显示选择列表的 header，默认有效字段大于一列时显示，否则不显示
                searchFields: ["cSpellingCode"],         //有效搜索字段，从前端搜索过滤数据时使用。effectiveFields 配置字段也会用于搜索过滤
                getDataMethod : "firstByUrl",                  //firstByUrl：第一次从Url获取全部数据，之后从options.data获取
                showBtn: false,                          //是否显示下拉按钮
                allowNoKeyword: true                    //是否允许无关键字时请求数据
            }).on("onDataRequestSuccess", function (event, result) {
                for(var index in result.value){
                    if(result.value[index].nCode == id){
                        $(self).val(result.value[index].cCodeName);
                        break;
                    }
                }
            });
        });
    }catch (e){
        console.log("必须要引入 bootstrap-suggest.min.js,请检查!",e);
    }
}
/**
 * 初始化单值代码显示
 * 标签固定使用span，例如：<span class="code" data-code-type="10100001" data-code-value="1">codeName</span>
 */
function codeShow() {
    try{
        var codes = [];
        $("span.code").each(function () {
            var codeType = $(this).data("code-type");
            var codeValue = $(this).data("code-value");
            if(undefined == codeType || undefined == codeValue){
                throw "请完善单值代码控件，例如：<span class=\"code\" data-code-type=\"10100001\" data-code-value=\"1\">codeName</span>";
            }
            codes.push({
                codeType : codeType,
                codeValue : codeValue
            });
        });
        if(codes.length > 0){
            $.ajax({
                url : baseHref + "/util/codeValues",
                data : {codes : JSON.stringify(codes)},
                success : function (data) {
                    data = JSON.parse(data);
                    if(!data.error && $.isArray(data.codes)){
                        for(var i = 0 ; i < data.codes.length; i++){
                            $("span[data-code-type='" + data.codes[i]["codeType"] +
                                "'][data-code-value='" + data.codes[i]["codeValue"] +
                                "']").text(data.codes[i]["codeName"]);
                        }
                    }
                }
            })
        }
    }catch (e){
        console.log(e);
    }

}

/** 初始化表单验证 */
!!$.validator && $.validator.setDefaults({
    onfocusout: function(element) {
        $(element).valid();
    },
    highlight: function (e) {
        $(e).closest(".form-group").removeClass("has-success").addClass("has-error");
        $(e).siblings('.glyphicon').removeClass("glyphicon-ok").addClass("glyphicon-remove").removeClass('hidden');
    }, success: function (e) {
        e.closest(".form-group").removeClass("has-error").addClass("has-success");
        e.siblings('.glyphicon').removeClass("glyphicon-remove").addClass("glyphicon-ok").removeClass('hidden');
    }, errorElement: "span", errorPlacement: function (error, element) {
        error.appendTo(element.is(":radio") || element.is(":checkbox") ? element.parent().parent().parent() : element.parent());
    }, errorClass: "help-block m-b-none"
});
/**
 * 验证form是否符合规则，需要配合 jQuery.validator
 * @param formId
 * @returns boolean
 */
function validatForm(formId) {
    var form = $("#" + formId);
    if(!form.validate()){
        return false;
    }
    return form.validate().form();
}
/**
 * 扩展jQuery获取form 内容的方法
 */
jQuery.fn.extend({
    formData: function () {
        var rCRLF = /\r?\n/g,
            rsubmitterTypes = /^(?:submit|button|image|reset|file)$/i,
            rsubmittable = /^(?:input|select|textarea|keygen)/i;
        var rcheckableType = ( /^(?:checkbox|radio)$/i );

        return this.map(function () {

            // Can add propHook for "elements" to filter or add form elements
            var elements = jQuery.prop(this, "elements");
            return elements ? jQuery.makeArray(elements) : this;
        })
            .filter(function () {
                var type = this.type;

                // Use .is(":disabled") so that fieldset[disabled] works
                return this.name && !jQuery(this).is(":disabled") &&
                    rsubmittable.test(this.nodeName) && !rsubmitterTypes.test(type) &&
                    ( this.checked || !rcheckableType.test(type) );
            })
            .map(function (i, elem) {
                var val;
                // 下拉类型 单值代码获取值
                if (jQuery(this).hasClass("code")) {
                    val = elem.dataset.id;
                    val = val == undefined ? null : val.toString();
                } else {
                    val = jQuery(this).val();
                }

                return val == null ?
                    null :
                    jQuery.isArray(val) ?
                        jQuery.map(val, function (val) {
                            return {name: elem.dataset.submitName, value: val.replace(rCRLF, "\r\n")};
                        }) :
                        {name: elem.dataset.submitName, value: val.replace(rCRLF, "\r\n")};
            }).get();
    }
});

/**
 * 关闭layer弹窗
 */
function closeLayer(win) {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}

/**
 * disabled the button and show waiting
 * @param buttonId
 */
function maskButton(buttonId){
    $("#" + buttonId).find(".fa-spinner").removeClass("hidden");
    $("#" + buttonId).attr("disabled", "disabled");
}
/**
 * enabled the button and stop waiting
 * @param buttonId
 */
function unMaskButton(buttonId) {
    $("#" + buttonId).find(".fa-spinner").addClass("hidden");
    $("#" + buttonId).removeAttr("disabled");
}