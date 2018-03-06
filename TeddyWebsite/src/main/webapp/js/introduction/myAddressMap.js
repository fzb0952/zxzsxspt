/**
 * Created by tingyu on 2017/3/15.
 */
$(function () {
    var map = createMap($("#my-address")[0]);

    $(window).resize(function () {
        map.reset();
    });
});

/**
 * 创建地图控件
 * @param domElement
 * @returns {BMap.Map}
 */
function createMap(domElement){
    // 百度地图API功能
    var map = new BMap.Map(domElement);
    var point = new BMap.Point(104.060345, 30.518767);
    map.centerAndZoom(point, 11);
    map.enableInertialDragging();           //启用地图惯性拖拽，默认禁用
    map.enableContinuousZoom();             //启用连续缩放效果，默认禁用
    map.enableScrollWheelZoom();            //启用滚轮放大缩小，默认禁用

    var marker = new BMap.Marker(point);  // 创建标注
    map.addOverlay(marker);               // 将标注添加到地图中
    marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画

    var content = '<div style="margin:0;line-height:20px;padding:2px;">地址：成都市双流县华新下街43号<br/></div>';

    //创建检索信息窗口对象
    var searchInfoWindow = null;
    searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
        title  : "我的位置",      //标题
        width  : 290,             //宽度
        height : 80,              //高度
        panel  : "panel",         //检索结果面板
        enableAutoPan : true,     //自动平移
        searchTypes   :[]
    });

    marker.addEventListener("click", function(e){
        searchInfoWindow.open(marker);
    });

    var myPositionCtrl = new MyPositionControl();
    map.addControl(myPositionCtrl);
    return map;
}

function MyPositionControl(){
    // 默认停靠位置和偏移量
    this.defaultAnchor = BMAP_ANCHOR_BOTTOM_RIGHT;
    this.defaultOffset = new BMap.Size(10, 10);
}
// 通过JavaScript的prototype属性继承于BMap.Control
MyPositionControl.prototype = new BMap.Control();

// 自定义控件必须实现自己的initialize方法,并且将控件的DOM元素返回
// 在本方法中创建个div元素作为控件的容器,并将其添加到地图容器中
MyPositionControl.prototype.initialize = function(map){
    // 创建一个DOM元素
    var btn = $("<button type='button' class='btn btn-primary btn-xs'><span class='glyphicon glyphicon-map-marker' style='font-size: 15px;'></span></button>");

    btn.click(function(){
        map.reset();
    });
    // 添加DOM元素到地图中
    map.getContainer().appendChild(btn[0]);
    // 将DOM元素返回
    return btn[0];
}

