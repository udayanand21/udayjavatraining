<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String baseStr = request.getParameter("base");
String expStr  = request.getParameter("exp");
Double base = null;
Double exp  = null;
Double result = null;
String error = null;
base = Double.parseDouble(baseStr.trim());
exp  = Double.parseDouble(expStr.trim());
result = Math.pow(base, exp);
%>
<form>
<label>Base</label>
<input type="text" placeholder=" eg. 2.5" id="base">
<label>Power</label>
<input type="text" placeholder=" eg. 3" id="exp" >
<button>Calculate</button>
<p><strong>Result:</strong> <%= result %></p>
</form>

</body>
</html>