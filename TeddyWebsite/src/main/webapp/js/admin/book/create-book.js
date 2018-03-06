/**
 * Created by tingyu on 2017/4/7.
 */
$(function () {
    $("#create-book").validate({
        rules: {
            "book-name": "required",
            "book-type": "required",
            "book-state": "required",
            "book-intro": "required"
        },
        errorClass: "hidden",
        validClass: "",
        debug:true
    });
});

/**
 * add book
 */
function addBook(button) {
    if(!validatForm("create-book")){
        return;
    }
    $(button).find(".fa-spinner").removeClass("hidden");
    $(button).attr("disabled", "disabled");
    $.ajax({
        url : baseHref + "/admin/book/add",
        data : $("#create-book").formData(),
        success : function (data) {
            data = JSON.parse(data);
            if(data.success){
                layer.msg(data.success, {icon: Layer.ICON_SUCCESS,time: 2000},function () {
                    closeLayer(window);
                    $(button).find(".fa-spinner").addClass("hidden");
                    $(button).removeAttr("disabled");
                });
            }else{
                layer.msg(data.error, {icon: Layer.ICON_ERROR,time: 2000},function () {
                    $(button).find(".fa-spinner").addClass("hidden");
                    $(button).removeAttr("disabled");
                });
            }
        },
        error : function () {
            layer.msg("与服务器通信失败，请联系管理员！", {icon: Layer.ICON_ERROR,time: 2000},function () {
                $(button).find(".fa-spinner").addClass("hidden");
                $(button).removeAttr("disabled");
            });
        }
    })
}

function editBook(button) {
    if(!validatForm("create-book")){
        return;
    }
    $(button).find(".fa-spinner").removeClass("hidden");
    $(button).attr("disabled", "disabled");
    $.ajax({
        url : baseHref + "/admin/book/update",
        data : $("#create-book").formData(),
        success : function (data) {
            data = JSON.parse(data);
            if(data.success){
                layer.msg(data.success, {icon: Layer.ICON_HAPPY,time: 2000},function () {
                    closeLayer(window);
                });
            }else{
                layer.msg(data.error, {icon: Layer.ICON_ERROR,time: 2000},function () {
                    $(button).find(".fa-spinner").addClass("hidden");
                    $(button).removeAttr("disabled");
                });
            }
        },
        error : function () {
            layer.msg("与服务器通信失败，请联系管理员！", {icon: Layer.ICON_ERROR,time: 2000},function () {
                $(button).find(".fa-spinner").addClass("hidden");
                $(button).removeAttr("disabled");
            });
        }
    })
}