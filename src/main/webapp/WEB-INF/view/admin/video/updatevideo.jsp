<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>编辑视频</title>
       <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">

  </head>
  <body>
    <div class="container">
    <div class="jumbotron">
    <h2>编辑视频</h2>
    </div>
    <form class="form-horizontal" action="${pageContext.request.contextPath }/admin/updatevideo.action" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">视频标题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="video_title" value="${video.video_title }" placeholder="视频标题">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">主讲人</label>
    <div class="col-sm-10">
<select class="form-control" name="speaker_id">
  <option value="">请选择主讲人</option>
  <c:forEach items="${speaker }" var="sp">
  <option value="${sp.id }" ${sp.id==video.speaker_id?'selected':''  }>${sp.speaker_name }</option>
  </c:forEach>
</select>
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">所属课程</label>
    <div class="col-sm-10">
<select class="form-control" name="course_id">
	<option value="">请选择课程</option>
	<c:forEach items="${course }" var="co">
  <option value="${co.id }" ${co.id==video.course_id?'selected':''  }>${co.course_name }</option>
  </c:forEach>
</select>
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">视频时长</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="video_length" value="${video.video_length }" placeholder="视频时长(秒)">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">封面图片</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="video_image_url" value="${video.video_image_url }" placeholder="视频封面图片地址，网络图片">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">视频播放地址</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="video_url" value="${video.video_url }" placeholder="视频播放地址，网络地址">
    </div>
  </div>
  
   <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">视频简介</label>
    <div class="col-sm-10">
<textarea class="form-control" rows="3" name="video_descr">${video.video_descr }</textarea> 
    </div>
  </div>
  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="hidden" name="id" value="${video.id }">
   <button type="submit" class="btn btn-primary">保存</button>
   <a class="btn btn-default" href="javascript:history.go(-1)">返回列表</a>
  </form>
    </div>
   
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
  </body>
</html>
