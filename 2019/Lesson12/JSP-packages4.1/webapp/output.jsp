<%@ page contentType="text/html; charset=Shift_JIS" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>Hello world</title>
</head>
<body>
<h1> ����ɂ��� </h1>
<%
  String name=request.getParameter("MYNAME");
%>
<h2>�悤�����I<%= name %>����A����ɂ��́I</h2>
</body>
</html>
