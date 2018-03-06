/**
 * Created by tingyu on 2017/4/3.
 */
$(function () {
    $(".file-box").each(function () {
        animationHover(this, "pulse");
    });
});

var bookVue = new TeddyVue({
    element: "#books",
    url: baseHref + "/admin/book/books",
    methods : {
        editBook : function (bookId) {
            //iframe窗
            layer.open({
                type: Layer.LAYER_IFRAME,
                area: ['70%', '85%'],
                title: '修改书籍信息',
                shade: 0.6,                 //遮罩透明度
                maxmin: true,               //允许全屏最小化
                anim: 0,                    //0-6的动画形式，-1不开启
                content: [baseHref + "/admin/book/bookId/" + bookId, 'yes'], //iframe的url，no代表不显示滚动条
                end : function () {
                    bookVue.reload();
                }
            });
        },
    }
});

function createBook() {
    //iframe窗
    layer.open({
        type: Layer.LAYER_IFRAME,
        area: ['70%', '85%'],
        title: '新增书籍',
        shade: 0.6,                 //遮罩透明度
        maxmin: true,               //允许全屏最小化
        anim: 0,                    //0-6的动画形式，-1不开启
        content: [baseHref + "/admin/create-book", 'yes'], //iframe的url，no代表不显示滚动条
        end : function () {
            bookVue.reload();
        }
    });
}