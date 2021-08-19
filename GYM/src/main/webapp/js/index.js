$(function(){

    // Header scroll and background
    $('.header').mouseenter(function(){
        $(this).addClass('on');
    });
    $('.header').mouseleave(function(){
        $(this).removeClass('on');
    })
    
    $(window).scroll(function(){
		var scroll = $(this).scrollTop();

        if(scroll == 0){
            $('.header').removeClass('scroll_on');
            $('.header').mouseenter(function(){
                $(this).addClass('on');
            });
            $('.header').mouseleave(function(){
                $(this).removeClass('on');
            });
        } else {
            $('.header').addClass('scroll_on');
        }
    });

});