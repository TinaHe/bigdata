/**
 * 页面的公共事件
 **/

/**
 * 多个下拉框只显示一个，并且实现点击空白处隐藏下拉框
 **/
//停止冒泡
function cancelBubble(e) {
	var e = e || window.event;
	if (e.stopPropagation()) {
		e.stopPropagation();
	} else if (e.cancelBubble) {
		e.cancelBubble = true;
	} else {
		return false;
	}
}
//点击空白处隐藏下拉框
$(document).on("click", function (e) {
    var target = $(e.target);
    if (target.closest(".select-content").length == 0) {
        $(".select-content .selects").addClass("d_n");
    }
});
$(".select-content").on("click",function(){
	if($(this).find(".selects").hasClass("d_n")){
		$(this).find(".selects").removeClass("d_n");
		$(this).siblings(".select-content").find(".selects").addClass("d_n");
	}else{
		$(".select-content .selects").addClass("d_n");
	}
	$(".chose").addClass("d_n");
 	$(".inDate").addClass("d_n");
});
$(".selects p").on("click",function(){
	$(this).addClass("active").siblings().removeClass("active");
	$(this).parent().prev().find('.showP').html($(this).text()).attr("value",$(this).attr("value"));
	$(this).parents(".selects").addClass("d_n");
	search($(".textShow").attr("startDate"),$(".textShow").attr("endDate"));
	cancelBubble();
});
//时间插件高亮默认选项
$(".chose p").eq(0).addClass("active");
/**
 * 鼠标滑过标题显示提示文字
 **/
//鼠标hover事件
$(".tags-content").hover(function(){
	$(this).find(".prompt").stop().toggleClass("d_n");
});


/**
 * 搜索以及回车搜索
 * **/
$(".fond").bind("click", function () {
	search($(".textShow").attr("startDate"),$(".textShow").attr("endDate"));
});
$(document).keyup(function(event){  
	if(event.keyCode ==13){  
		$('.fond,.fond1').trigger("click");
	}
});
$('#keyword').bind('input propertychange', function() {
	if($("#keyword").val() != "请输入关键词"){
		$("#keyword").css("color","#8e969c");
	}
});
/**
 * 搜索结果中高亮搜索的关键词
 **/

