/**
 * Created by tingyu on 2017/3/23.
 */
$(document).ready(function () {
    $("#lightVersion").click(function (event) {
        event.preventDefault();
        $("#ibox-content").removeClass("ibox-content");
        $("#vertical-timeline").removeClass("dark-timeline");
        $("#vertical-timeline").addClass("light-timeline")
    });
    $("#darkVersion").click(function (event) {
        event.preventDefault();
        $("#ibox-content").addClass("ibox-content");
        $("#vertical-timeline").removeClass("light-timeline");
        $("#vertical-timeline").addClass("dark-timeline")
    });
    $("#leftVersion").click(function (event) {
        event.preventDefault();
        $("#vertical-timeline").toggleClass("center-orientation")
    })
});