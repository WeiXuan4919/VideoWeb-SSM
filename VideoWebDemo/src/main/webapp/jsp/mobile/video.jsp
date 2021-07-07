<%--
  Created by IntelliJ IDEA.
  User: weixuan
  Date: 2021/7/3
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <title>${video.videoName}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/layer.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/zy.media.css" />
    <script src="${pageContext.request.contextPath }/js/jquery-3.5.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath }/js/layui.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath }/js/layer.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath }/js/zy.media.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="video-top">
    <div class="video-header">
        <div class="logo layui-container">
            <a href="${pageContext.request.contextPath }"><img src="${pageContext.request.contextPath }/images/logo.png" /></a>
            <h4>波波哈达</h4>
        </div>
    </div>
    <div class="video-play">
        <div class="zy_media">
            <video poster="" data-config='{"mediaTitle": "《${video.videoName}》"}'>
                <source src="${video.videoPath}" type="video/mp4">
                您的浏览器不支持HTML5视频
            </video>
        </div>
    </div>
</div>
<div class="video-nav">
    <button id="synopsis" class="button-active">简介</button>
    <button id="comment" class="video-button">评论&nbsp;${countComment}</button>
</div>
<div class="layui-container">
    <div class="video-content">
        <div class="video-title">
            <h2>${video.videoName}</h2>
            <p>${video.watchNub}次播放</p>
            <div class="video-icon">
                <a href="${video.videoPath}"><i class="layui-icon">&#xe601;</i></a>
                <i class="layui-icon heart">&#xe68c;</i>
            </div>
        </div>
        <div style="margin-top: 40px;">
            <hr />
        </div>
        <div class="recommend">
            <ul>
            </ul>
        </div>
    </div>
    <div class="video-comment" style="display: none;">
        <h4>热门评论</h4>
        <div class="comments">
            <ul>
                <c:forEach items="${commentList}" var="comment" varStatus="i">
                    <li>
                        <p><span class="span1">${i.count}楼:</span>&emsp;${comment.commenttext}</p>
                        <span><fmt:formatDate value="${comment.commentdate}" pattern="yyyy年MM月dd日 HH:mm"/></span>
                        <hr>
                    </li>
                </c:forEach>
                <c:if test="${empty commentList}">
                    <li>
                        <p class="notComment">快来评论一下吧~</p>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</div>
<div class="send-comment" style="display: none;">
    <div class="layui-container">
        <input type="text" id="content" name="content" class="layui-input" placeholder="请友善评论哦~">
        <input type="button" id="sendComment" vid="${video.id}" class="layui-btn layui-btn-normal" value="发布"/>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath }/js/main.js" type="text/javascript" charset="utf-8"></script>
<script>
    $(function(){
        zymedia('video');
        $.get('${pageContext.request.contextPath }/video/recommend', function(res){
            res = JSON.parse(res);
            var item = '';
            for (var i=0;i<res.length;i++){
                item+='<li><a href="${pageContext.request.contextPath }/video/'+res[i].id+'"><img src="'+res[i].coverPath+'" /><span>'+res[i].videoName+'</span><div class="watch"><i class="layui-icon">&#xe652;</i><span>' +
                    res[i].watchNub+'</span></div><div class="reply"><i class="layui-icon">&#xe611;</i><span>'+res[i].countComment+'</span></div></a></li>';
            }
            $(".recommend>ul").html(item);
        });
    });
    function refreshComment(vid){
        $.post('${pageContext.request.contextPath }/comment/'+vid,function(res){
            res = JSON.parse(res);
            var item='';
            for(var i=0; i<res.length;i++){
                var date = new Date(res[i].commentdate).format("yyyy年MM月dd日 hh:mm");
                item+='<li><p><span class="span1">'+(i+1)+'楼:</span>&emsp;'+res[i].commenttext+'</p><span>'+date+'</span><hr></li>';
            }
            $(".comments>ul").html(item);
        });
    }
    $("#sendComment").click(function () {
        var content = $("#content").val();
        var vid = $(this).attr("vid");
        if(content!=null&&content!==''){
            $.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath}/video/comment/'+vid,
                data: {"content":content},
                success: function(res){
                    res = JSON.parse(res);
                    if(res.flag===true){
                        refreshComment(vid);
                    }
                    layer.open({
                        content: res.message
                        ,skin: 'msg'
                        ,time: 2
                    });
                    $("#content").val('');
                },
                error:function(){
                    layer.open({
                        content: '发布失败!'
                        ,skin: 'msg'
                        ,time: 2
                    });
                }
            });
        }
    });
</script>
</html>

