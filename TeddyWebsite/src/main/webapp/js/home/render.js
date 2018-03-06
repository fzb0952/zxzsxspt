/**
 * Created by tingyu on 2017/2/25.
 */
/**
 * Three.js render绘制函数入口
 * @param domElement
 * @constructor
 */
var Render = function(domElement,options){
    /**
     * 初始化
     */
    this.init = function(){
        // 初始化绘制所需的对象
        init();

        // 先初始化所有的feature
        for(var i in features){
            features[i].init(scene);
        }
        // 开启循环绘制
        animate();
    };

    /**
     * 添加特色场景内容
     * @param feature
     */
    this.addFeature = function (feature) {
        feature && features.push(feature);
    };

    var features = [];

    var container = domElement;
    var camera, scene, renderer;
    var mouseX = 0, mouseY = 0;

    var width = $(container).innerWidth();
    var height = $(container).innerHeight();

    var windowHalfX = width / 2;
    var windowHalfY = height / 2;

    // 场景到屏幕的距离
    var distance_screen = options.distance_screen ? options.distance_screen : 1000;
    /**
     * 初始化函数
     */
    function init() {
        camera = new THREE.PerspectiveCamera( 75, width / height, 1, 5000 );
        camera.position.z = distance_screen;

        scene = new THREE.Scene();

        renderer = new THREE.WebGLRenderer({antialias: true});
        renderer.setClearColor( 0x000000 , 0.5 );
        renderer.setPixelRatio( window.devicePixelRatio );
        renderer.setSize( width, height );
        container.appendChild( renderer.domElement );

        container.addEventListener( 'mousemove', onDocumentMouseMove, false );
        container.addEventListener( 'touchstart', onDocumentTouchStart, false );
        container.addEventListener( 'touchmove', onDocumentTouchMove, false );
        //
        window.addEventListener( 'resize', onWindowResize, false );
        window.addEventListener('deviceorientation',onDeviceorientation,false);
    }

    function onDeviceorientation(event){
        if(window.orientation==180||window.orientation==0){ //竖屏状态
            mouseX = windowHalfX * 2 / 180 * event.gamma * 10 ;//横向 X 轴 -180 ~ 180
            mouseY = windowHalfY * 2 / 180 * event.beta;//纵向 Y 轴 -90 ~ 90
        }
        if(window.orientation==90||window.orientation==-90){ //横屏状态
            mouseX = windowHalfX * 2 / 180 * event.beta * 10 ;//横向 X 轴 -180 ~ 180
            mouseY = windowHalfY * 2 / 180 * event.gamma;//纵向 Y 轴 -90 ~ 90
        }

    }

    function onWindowResize() {
        width = $(domElement).innerWidth();
        height = $(domElement).innerHeight();

        windowHalfX = width / 2;
        windowHalfY = height / 2;

        camera.aspect = width / height;
        camera.updateProjectionMatrix();

        renderer.setSize( width, height );
    }


    function onDocumentMouseMove( event ) {
        mouseX = event.clientX - windowHalfX;
        mouseY = event.clientY - windowHalfY;
    }

    function onDocumentTouchStart( event ) {
        if ( event.touches.length == 1 ) {
            event.preventDefault();

            mouseX = event.touches[ 0 ].pageX - windowHalfX;
            mouseY = event.touches[ 0 ].pageY - windowHalfY;
        }
    }

    function onDocumentTouchMove( event ) {
        if ( event.touches.length == 1 ) {
            event.preventDefault();

            mouseX = event.touches[ 0 ].pageX - windowHalfX;
            mouseY = event.touches[ 0 ].pageY - windowHalfY;
        }
    }

    /**
     * 循环函数 一秒60帧
     */
    function animate() {
        requestAnimationFrame( animate );

        render();
    }

    /**
     * 绘制函数
     */
    function render() {
        width = window.innerWidth;
        height = $(container).innerHeight();
        // 更新所有的feature
        for(var i in features){
            features[i].update();
        }

        camera.position.x += ( mouseX - camera.position.x ) * 0.05;
        camera.position.y += ( - mouseY - camera.position.y ) * 0.05;
        camera.lookAt( scene.position );

        renderer.render( scene, camera );
    }
};