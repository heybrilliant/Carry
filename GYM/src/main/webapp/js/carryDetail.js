$(document).ready(function(e) {
	
    $('#write_review_btn').click(function() {
		$('#review_write').removeClass('display_none');
	});
	
	
    // 사이드 윙 스크립트
    var default_h = $(".header").height() + $(".carry_image").height() - 50;

    $(window).scroll(function(){
        var scroll_Top = $(this).scrollTop();
        
        var bottom_Top = $('.footer').offset().top - 900;
        
        console.log('123 == ' + scroll_Top);
        console.log('456 == ' + bottom_Top);

        //main
        if (scroll_Top > default_h){
            $(".right_banner").stop().animate({"top":scroll_Top-default_h-80},600);
            
            if(scroll_Top >= bottom_Top) {
              $(".right_banner").stop().animate({"top":bottom_Top-default_h},600);
           }
        } else { 
            $(".right_banner").stop().animate({"top":0},600);
        } 
    });

    

}); //ready fnc
