<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改信息</small>
                </h1>
            </div>
        </div>
    </div>

<%--    action : 表示返回到前端的URL--%>
    <form action="${pageContext.request.contextPath}/Course/updateCourse" method="post">
        <input type="hidden" name="CourseId" value="${course.getCourseId()}"/>
        <div class="form-group">
            <label>课程名称：</label>
            <input type="text" name="name" class="form-control" value="${course.getName()}" required>
        </div>
        <div class="form-group">
            <label>课程课时：</label>
            <input type="text" name="hours" class="form-control" value="${course.getHours()}" required>
        </div>
        <div class="form-group">
            <label>开课学院：</label>
            <input type="text" name="sid" class="form-control" value="${course.getSid()}" required>
        </div>
        <input type="submit" value="更新">
    </form>

</div>
</body>
</html>