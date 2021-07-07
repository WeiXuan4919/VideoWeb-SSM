<%--
  Created by IntelliJ IDEA.
  User: weixuan
  Date: 2021/7/3
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>波波哈达</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/layui.css" />
    <script src="${pageContext.request.contextPath }/js/jquery-3.5.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath }/js/layui.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="header">
    <div class="layui-container">
        <div class="logo">
            <a href="${pageContext.request.contextPath }"><img src="${pageContext.request.contextPath }/images/logo.png" /></a>
            <h4>波波哈达</h4>
        </div>
        <div class="category">
            <ul id="nav">
                <li class="active" cid="0">
                    <div>首页</div>
                </li>
                <c:forEach items="${categoryList}" var="category">
                    <li cid="${category.id  }">
                        <div>${category.category}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<div class="carouse">
    <div class="layui-carousel" style="margin: 0 auto;" id="CarouselMap">
        <div carousel-item>
            <c:if test="${!empty videoList}">
                <c:forEach items="${videoList}" begin="0" end="${CarouselNub-1}" var="carouse" varStatus="i">
                    <div>
                        <a href="video/${carouse.id}">
                            <img src="${carouse.coverPath}">
                            <div class="title">
                                <span class="title_text">${carouse.videoName}</span>
                            </div>
                            <span class="img_page">${i.count}/${CarouselNub}</span>
                        </a>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
<div class="content">
    <div class="layui-container">
        <span class="content_title">所有视频</span>
        <div>
            <ul class="list-video" id="videos">
            </ul>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath }/js/main.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    $(function(){
        layui.use('flow', function(){
            var $ = layui.jquery;
            var flow = layui.flow;
            flow.load({
                elem: '#videos'
                ,done: function(page, next){
                    var lis = [];
                    $.get('${pageContext.request.contextPath }/video/page/0/'+page, function(res){
                        res=JSON.parse(res);
                        layui.each(res.data, function(index, item){
                            lis.push('<li><a href="${pageContext.request.contextPath }/video/'+item.id+'"><img src="'+item.coverPath+'" alt=""/><p>'+item.videoName+'</p></a></li>');
                        });
                        next(lis.join(''), page < res.pages);
                    });
                }
            });
        });
        $("#nav li").bind("click", function() {
            $("#nav li").removeClass("active");
            $(this).addClass("active");
            var cid = $(this).attr("cid");
            window.location.href = '${pageContext.request.contextPath }/video/category/'+cid;
        });
    });
</script>
</html>

