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
                <li>
                    <div><a href="${pageContext.request.contextPath }">首页</a></div>
                </li>
                <c:forEach items="${categoryList}" var="c">
                    <c:if test="${c.id == category.id}">
                        <li class="active" cid="${c.id  }">
                            <div>${c.category}</div>
                        </li>
                    </c:if>
                    <c:if test="${c.id != cid}">
                        <li cid="${c.id  }">
                            <div>${c.category}</div>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<div class="content">
    <div class="layui-container">
        <span class="content_title">${category.category}</span>
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
        $(".content").css("margin-top","100px");
        layui.use('flow', function(){
            var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
            var flow = layui.flow;
            flow.load({
                elem: '#videos' //指定列表容器
                ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
                    var lis = [];
                    //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                    $.get('${pageContext.request.contextPath }/video/page/${category.id}/'+page, function(res){
                        res=JSON.parse(res);
                        //假设你的列表返回在data集合中
                        layui.each(res.data, function(index, item){
                            lis.push('<li><a href="${pageContext.request.contextPath }/video/'+item.id+'"><img src="'+item.coverPath+'" alt=""/><p>'+item.videoName+'</p></a></li>');
                        });

                        //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                        //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                        next(lis.join(''), page < res.pages);
                    });
                }
            });
        });
    });
    $("#nav li").bind("click", function() {
        $("#nav li").removeClass("active");
        $(this).addClass("active");
        var cid = $(this).attr("cid");
        window.location.href = '${pageContext.request.contextPath }/video/category/'+cid;
    });
</script>
</html>

