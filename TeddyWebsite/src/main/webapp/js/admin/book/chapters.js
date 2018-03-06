/**
 * Created by tingyu on 2017/4/16.
 */

$(function () {
    $(".file-box").each(function () {
        animationHover(this, "pulse");
    });

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    UE.getEditor('chapter-content',{initialFrameHeight:300,autoHeightEnabled:false,maximumWords:20000});

    $("#chapter-info").validate({
        rules: {
            "chapter-volume": "required",
            "chapter-name": "required",
            "chapter-intro": "required"
        },
        errorClass: "hidden",
        validClass: "",
        debug:true
    });
});

var book = new TeddyVue({
    element : "#book",
    url : baseHref + "/admin/chapter/bookId/" + $("#book").data("id"),
    getDataMethod : "url",
    isByPage : false
});

var chapter = null;
var isEdit = false;
var chapters = new TeddyVue({
    element : "#chapters",
    url : baseHref + "/admin/chapter/chapters/" + $("#book").data("id"),
    getDataMethod : "url",
    methods : {
        addChapter : function () {
            showChapter();
            if(!UE.getEditor('chapter-content').getContent() && UE.getEditor('chapter-content').execCommand( "getlocaldata" )){
                UE.getEditor('chapter-content').setContent(UE.getEditor('chapter-content').execCommand( "getlocaldata" ));
            }
        },
        editChapter : function (chapterId) {
            showChapter();
            isEdit = true;
            if(!chapter){
                chapter = new TeddyVue({
                    element: "#chapter",
                    url: baseHref + "/admin/chapter/chapter/" + chapterId,
                    getDataMethod: "url",
                    isByPage: false
                });
            }else{
                chapter.reload({url : baseHref + "/admin/chapter/chapter/" + chapterId});
            }
            setTimeout(function () {
                UE.getEditor('chapter-content').setContent(chapter.getDataSource("chapter").cContent);
            },1000);
        }
    }
});


function showChapter() {
    $("#chapter").removeClass("hidden");
    $("#chapter").removeClass("animated fadeOutRightBig");
    $("#chapter").addClass("animated fadeInRightBig");
}

function hideChapter() {
    $("#chapter").removeClass("animated fadeInRightBig");
    $("#chapter").addClass("animated fadeOutRightBig");
    chapters.reload();
    if(isEdit){
        clearChapterInfo();
        isEdit = false;
    }
}

function clearChapterInfo(){
    $("#chapter-info")[0].reset();
    $("#chapter-intro").text("");
    UE.getEditor('chapter-content').setContent("");
}

function saveChapter(){
    if(!validatForm("chapter-info")){
        return;
    }
    var data = $("#chapter-info").formData();
    data[data.length - 1].name = "chapter.cContent";
    data.push({name:"chapter.nWordCount",value:UE.getEditor('chapter-content').getContentTxt().length});
    data.push({name:"chapter.cBookId",value:$("#book").data("id")});
    maskButton("saveButton");
    $("#publishButton").attr("disabled", "disabled");
    $.ajax({
        type : "POST",
        url : baseHref + "/admin/chapter/saveChapter",
        data : data,
        dataType : 'json',
        success : function (data) {
            if(data.success){
                layer.msg(data.success, {icon: Layer.ICON_SUCCESS,time: 2000},function () {
                    hideChapter();
                    $("#chapter-info")[0].reset();
                    unMaskButton("saveButton");
                    $("#publishButton").removeAttr("disabled");
                });
            }else{
                layer.msg(data.error, {icon: Layer.ICON_ERROR,time: 2000},function () {
                    unMaskButton("saveButton");
                    $("#publishButton").removeAttr("disabled");
                });
            }
        },
        error : function () {
            layer.msg("与服务器通信失败，请联系管理员！", {icon: Layer.ICON_ERROR,time: 2000},function () {
                unMaskButton("saveButton");
                $("#publishButton").removeAttr("disabled");
            });
        }
    });
}

function publishChapter() {
    if(!validatForm("chapter-info")){
        return;
    }
    var data = $("#chapter-info").formData();
    data[data.length - 1].name = "chapter.cContent";
    data.push({name:"chapter.nWordCount",value:UE.getEditor('chapter-content').getContentTxt().length});
    data.push({name:"chapter.cBookId",value:$("#book").data("id")});
    maskButton("publishButton");
    $("#saveButton").attr("disabled", "disabled");
    $.ajax({
        type: "POST",
        url: baseHref + "/admin/chapter/publishChapter",
        data: data,
        dataType: 'json',
        success: function (data) {
            if (data.success) {
                layer.msg(data.success, {icon: Layer.ICON_SUCCESS, time: 2000}, function () {
                    hideChapter();
                    clearChapterInfo();
                    unMaskButton("publishButton");
                    $("#saveButton").removeAttr("disabled");
                });
            } else {
                layer.msg(data.error, {icon: Layer.ICON_ERROR, time: 2000}, function () {
                    unMaskButton("publishButton");
                    $("#saveButton").removeAttr("disabled");
                });
            }
        },
        error: function () {
            layer.msg("与服务器通信失败，请联系管理员！", {icon: Layer.ICON_ERROR, time: 2000}, function () {
                unMaskButton("publishButton");
                $("#saveButton").removeAttr("disabled");
            });
        }
    });
}