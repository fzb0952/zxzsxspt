/**
 * Created by tingyu on 2017/3/19.
 */
function main() {
    var container = $("#particel");
    var scale = 1170 / container.innerWidth() == 1 ? 1 : 1170 / container.innerWidth() * 0.5;
    var render = new Render(container[0], {
        distance_screen: 1000 * scale
    });
    render.addFeature(new Particle());
    render.addFeature(new ThreeText("Powered by 范中伟", {
        size: 300,
        height: 30,
        color: 0xFFFFFF,
        position: new Position(0, 0, 0)
    }));
    render.init();
}