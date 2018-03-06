/**
 * Created by tingyu on 2017/2/25.
 */
/**
 * 粒子系统简单封装
 * @constructor
 */
var Particle = function(){
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
        TWEEN.update();
    }

    var scope = this;
    var particle;

    function init() {
        var material = new THREE.SpriteMaterial( {
            map: new THREE.CanvasTexture( generateSprite() ),
            blending: THREE.AdditiveBlending
        } );

        for ( var i = 0; i < 1000; i++ ) {

            particle = new THREE.Sprite( material );

            initParticle( particle, i * 10 );

            scope.scene.add( particle );
        }
    }

    function generateSprite() {

        var canvas = document.createElement( 'canvas' );
        canvas.width = 16;
        canvas.height = 16;

        var context = canvas.getContext( '2d' );
        var gradient = context.createRadialGradient( canvas.width / 2, canvas.height / 2, 0, canvas.width / 2, canvas.height / 2, canvas.width / 2 );
        gradient.addColorStop( 0, 'rgba(255,255,255,1)' );
        gradient.addColorStop( 0.2, 'rgba(0,255,255,1)' );
        gradient.addColorStop( 0.4, 'rgba(0,0,64,1)' );
        gradient.addColorStop( 1, 'rgba(0,0,0,1)' );

        context.fillStyle = gradient;
        context.fillRect( 0, 0, canvas.width, canvas.height );

        return canvas;

    }

    function initParticle( particle, delay ) {

        var particle = this instanceof THREE.Sprite ? this : particle;
        var delay = delay !== undefined ? delay : 0;

        particle.position.set( 0, 0, 0 );
        particle.scale.x = particle.scale.y = Math.random() * 32 + 16;

        new TWEEN.Tween( particle )
            .delay( delay )
            .to( {}, 10000 )
            .onComplete( initParticle )
            .start();

        new TWEEN.Tween( particle.position )
            .delay( delay )
            .to( { x: Math.random() * 4000 - 2000, y: Math.random() * 1000 - 500, z: Math.random() * 4000 - 2000 }, 10000 )
            .start();

        new TWEEN.Tween( particle.scale )
            .delay( delay )
            .to( { x: 0.01, y: 0.01 }, 10000 )
            .start();

    }
};