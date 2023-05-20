<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix" style="text-align: center">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增课程</small>
                </h1>
                <h3>
                    新增页
                </h3>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增内容</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/Course/addCourse" method="post">
        <div class="form-group">
            <label>课程名称：</label>
            <input type="text" name="name" class="form-control" required>
        </div>
        <div class="form-group">
            <label>课程课时：</label>
            <input type="text" name="hours" class="form-control" required>
        </div>
        <div class="form-group">
            <label>开课学院：</label>
            <input type="text" name="sid" class="form-control" required>
        </div>
        <input type="submit" value="添加">
    </form>


</div>
</body>
</html>