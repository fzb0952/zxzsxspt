/**
 * Created by tingyu on 2017/2/25.
 */

var ThreeText = function (text,options) {
    this.scene;
    /**
     * 粒子系统初始化
     * @param scene
     */
    this.init = function(scene){
        this.scene = scene;
        init();
    };

    /**
     * 粒子系统更新操作 由render自动调用
     */
    this.update = function(){
        if(!uniforms){
            return;
        }
        var time = Date.now() * 0.001;

        uniforms.amplitude.value = Math.sin( 0.5 * time );
        uniforms.color.value.offsetHSL( 0.0025, 0, 0 );

        var attributes = object.geometry.attributes;
        var array = attributes.displacement.array;

        for ( var i = 0, l = array.length; i < l; i += 3 ) {

            array[ i     ] += 0.3 * ( 0.5 - Math.random() );
            array[ i + 1 ] += 0.3 * ( 0.5 - Math.random() );
            array[ i + 2 ] += 0.3 * ( 0.5 - Math.random() );

        }

        attributes.displacement.needsUpdate = true;
    }
    var fontType = "STXingkai";
    var fontWeight = "Regular";

    var scope = this;
    var group, textMesh1, textGeo, material;
    var object, uniforms;
    var color = options.color != undefined ? options.color : getRandomColor();
    var position = options.position ? options.position : new Position(0,100,0);
    var _options = {
        size: options.size ? options.size : 30, //字号大小，一般为大写字母的高度
        height: options.height ? options.height : 10, //文字的厚度
        weight: 'normal', //值为'normal'或'bold'，表示是否加粗
        font: undefined, //字体，默认是'helvetiker'，需对应引用的字体文件
        style: 'normal', //值为'normal'或'italics'，表示是否斜体
        bevelThickness: 5, //倒角厚度
        bevelSize: 1.5, //倒角宽度
        curveSegments: 6,//弧线分段数，使得文字的曲线更加光滑
        bevelEnabled: true, //布尔值，是否使用倒角，意为在边缘处斜切
        bevelSegments: 6,
        steps: 10,

        material: 0,
        extrudeMaterial: 1
    };

    var font = undefined;

    function init() {
        // LIGHTS
        var dirLight = new THREE.DirectionalLight( 0xffffff, 0.125 );
        dirLight.position.set( 0, 0, 1 ).normalize();
        scope.scene.add( dirLight );

        var pointLight = new THREE.PointLight( color, 1.5 );
        pointLight.position.set( 0, 100, 200 );
        scope.scene.add( pointLight );

        group = new THREE.Group();
        group.position.set(position.x,position.y,position.z);
        scope.scene.add( group );

        loadFont();
    }

    function loadFont() {
        var basePath = $("#base").data("href");
        var loader = new THREE.FontLoader();
        loader.load( basePath + '/fonts/default.json', function ( response ) {
            _options.font = response;
            $.ajax({
                url : basePath + "/fonts/search.do",
                data : {
                    "font.fontType" : fontType,
                    "font.fontWeight" : fontWeight,
                    "font.fontSearchParams" : text
                },
                async : true, // 设置为异步
                success : function (data) {
                    data = JSON.parse(data);
                    if(data.error){
                        console.log("加载字体失败！")
                    }else{
                        _options.font.data.glyphs = data.success;
                        createText();
                    }
                }
            });
        } );
    }

    function createText() {
        textGeo = new THREE.TextGeometry( text,_options);

        textGeo.computeBoundingBox();
        textGeo.computeVertexNormals();

        textGeo.center();

        var centerOffset = -0.5 * ( textGeo.boundingBox.max.x - textGeo.boundingBox.min.x );

        material = new THREE.MultiMaterial( [
            new THREE.MeshPhongMaterial( { color: color, shading: THREE.FlatShading } ), // front
            new THREE.MeshPhongMaterial( { color: color, shading: THREE.SmoothShading } ) // side
        ] );

        textMesh1 = new THREE.Mesh( textGeo, material );
        group.add( textMesh1 );
        group.add(createLine(textGeo));
    }

    function createLine(textGeo){
        uniforms = {
            amplitude: { value: 5.0 },
            opacity:   { value: 0.3 },
            color:     { value: new THREE.Color( 0xff0000 ) }
        };

        var shaderMaterial = new THREE.ShaderMaterial({

            uniforms: uniforms,
            vertexShader: "uniform float amplitude;attribute vec3 displacement;attribute vec3 customColor;varying vec3 vColor;" +
                            "void main() {vec3 newPosition = position + amplitude * displacement;vColor = customColor;" +
                            "gl_Position = projectionMatrix * modelViewMatrix * vec4( newPosition, 1.0 );}",
            fragmentShader: "uniform vec3 color;uniform float opacity;varying vec3 vColor;void main()" +
                            " {gl_FragColor = vec4( vColor * color, opacity );}",
            blending: THREE.AdditiveBlending,
            depthTest: false,
            transparent: true

        });

        var vertices = textGeo.vertices;

        var buffergeometry = new THREE.BufferGeometry();

        var position = new THREE.Float32BufferAttribute( vertices.length * 3, 3 ).copyVector3sArray( vertices );
        buffergeometry.addAttribute( 'position', position );

        var displacement = new THREE.Float32BufferAttribute( vertices.length * 3, 3 );
        buffergeometry.addAttribute( 'displacement', displacement );

        var customColor = new THREE.Float32BufferAttribute( vertices.length * 3, 3 );
        buffergeometry.addAttribute( 'customColor', customColor );

        var color = new THREE.Color( 0xffffff );

        for( var i = 0, l = customColor.count; i < l; i ++ ) {

            color.setHSL( i / l, 0.5, 0.5 );
            color.toArray( customColor.array, i * customColor.itemSize );

        }

        object = new THREE.Line( buffergeometry, shaderMaterial );
        // object.rotation.x = 0.2;
        return object;
    }
};

var Position = function(x,y,z){
    this.x = x;
    this.y = y;
    this.z = z;

    this.set = function(x,y,z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

function getRandomColor(){
    var colorElements = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f";
    var colorArray = colorElements.split(",");
    var color ="#";
    for(var i =0;i<6;i++){
        color+=colorArray[Math.floor(Math.random()*16)];
    }
    return color;
}