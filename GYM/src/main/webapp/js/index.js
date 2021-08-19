$(function(){
    
    $(window).scroll(function(){
		var scroll = $(this).scrollTop();

        if(scroll == 0){
            $('.header').removeClass('on');
            $('.header').mouseenter(function(){
                $(this).addClass('on');
            });
            $('.header').mouseleave(function(){
                $(this).removeClass('on');
            });
        } else {
            $('.header').addClass('on');
        }
    });

});