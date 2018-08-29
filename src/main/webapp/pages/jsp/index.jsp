<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div id="gloobal">
        <h4>登录成功，当前页面为首页</h4>
        <p>
        <h5>登录用户：</h5>
        	姓名：${sessionScope.user.name}
        </p>
    </div>
</body>
</html>