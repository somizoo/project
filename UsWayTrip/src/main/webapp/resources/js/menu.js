/**
 * 메뉴 관련 js
 */
 
 $(function(){
	var menu = $(".menuzord-menu");
	$(menu).children("li").on("click", function(){
		$(menu).children("li").each(function(){
			$(this).removeClass("active");
		});
		$(this).addClass("active");
	});
})
 