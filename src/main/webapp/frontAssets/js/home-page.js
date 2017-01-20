/**
 * Created by dushang on 2016/9/12.
 */
$(function () {
    var unslider=$('.my-slider').unslider({
        speed: 1000,               //  The speed to animate each slide (in milliseconds)
        delay: 3000,              //  The delay between slide animations (in milliseconds)
        fluid: false,             //  Support responsive design. May break non-responsive designs
        autoplay:true,
        arrows:false,
        infinite:true
    });
    /*手机端触屏*/
    $('.my-slider').on('swipeleft', function(e) {
        unslider.stop().prev();
    }).on('swiperight', function(e) {
        unslider.stop().next();
    });

});