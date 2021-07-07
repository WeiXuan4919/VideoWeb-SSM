/**
 * 轮播图
 */
var ins;
layui.use(['carousel', 'form'], function() {
	var carousel = layui.carousel;
	ins = carousel.render({
		elem: '#CarouselMap',
		width: '92%',
		height: '230px',
		interval: 5000,
		indicator: 'none',
		arrow: 'none' //始终不显示箭头
	});
});
$("#CarouselMap").on("touchstart", function(e) {
	var startX = e.originalEvent.targetTouches[0].pageX; //开始坐标X
	$(this).on('touchmove', function(e) {
		arguments[0].preventDefault(); //阻止手机浏览器默认事件
	});
	$(this).on('touchend', function(e) {
		var endX = e.originalEvent.changedTouches[0].pageX; //结束坐标X
		e.stopPropagation(); //停止DOM事件逐层往上传播
		if (endX - startX > 30) {
			ins.slide("sub");
		} else if (startX - endX > 30) {
			ins.slide("add");
		}
		$(this).off('touchmove touchend');
	});
});

$("#synopsis").click(function() {
	$("#synopsis").attr("class", "button-active");
	$("#comment").attr("class", "video-button");
	hideComment();
});
$("#comment").click(function() {
	$("#comment").attr("class", "button-active");
	$("#synopsis").attr("class", "video-button");
	showComment();
});

function showComment() {
	$(".video-content").hide();
	$(".video-comment").show();
	$(".send-comment").show();
}

function hideComment() {
	$(".video-content").show();
	$(".video-comment").hide();
	$(".send-comment").hide();
}
$(".heart").click(function() {
	$(this).html("&#xe68f;");
	$(this).css("color", "red");
});

Date.prototype.format = function(fmt){
	var o = {
		"M+" : this.getMonth()+1,                 //月份
		"d+" : this.getDate(),                    //日
		"h+" : this.getHours(),                   //小时
		"m+" : this.getMinutes(),                 //分
		"s+" : this.getSeconds(),                 //秒
		"q+" : Math.floor((this.getMonth()+3)/3), //季度
		"S"  : this.getMilliseconds()             //毫秒
	};

	if(/(y+)/.test(fmt)){
		fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
	}

	for(var k in o){
		if(new RegExp("("+ k +")").test(fmt)){
			fmt = fmt.replace(
				RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
		}
	}

	return fmt;
};