<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <script type = "text/javascript" >

        function del() {
            var msg = "确定要删除吗？";
            if (confirm(msg)==true){
                alert('确认删除');
                return true;
            }else{
                alert('取消删除');
                return false;
            }
        }

        function exit() {
            var msg = "确定要退出吗？";
            if (confirm(msg)==true){
                alert('确认退出');
                return true;
            }else{
                alert('取消退出');
                return false;
            }
        }

    </script>

</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column" >
            <div class="page-header" style="float: right">
                <h3>
                    用户：${email} ，
                    <a href="${pageContext.request.contextPath}" onclick="javascript:return del();">退出</a>
                </h3>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Course/toAddCourse">新增课程</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Course/allCourse">显示所有课程</a>
        </div>

        <div class="col-md-12 column">
            <form class = "form-inline" action="${pageContext.request.contextPath}/Course/queryCourse" method="post" style="float: right">
                <span style="color: red; font-weight: bold">${err}</span>
                <input type="text" name="queryCourseName" class="form-control" placeholder="请输入要查询的书籍名称">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>
    </div>

    <br>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                    <th>课程编号</th>
                    <th>封面</th>
                    <th>课程名字</th>
                    <th>课程时长</th>
                    <th>开课学院</th>
                    <th>操作</th>

                </thead>

                <tbody>
                <c:forEach var="course" items="${requestScope.get('list')}">
                    <tr>
                        <td>${course.getCourseId()}</td>
                        <td><img src="https://img1.baidu.com/it/u=3945511683,2177287662&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500" width="100"></td>
                        <td>${course.getName()}</td>
                        <td>${course.getHours()}</td>
                        <td>${course.getSid()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/Course/toUpdateCourse?id=${course.getCourseId()}">编辑</a> |
                            <a href="${pageContext.request.contextPath}/Course/delete/${course.getCourseId()}" onclick="javascript:return del();">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>

</div>