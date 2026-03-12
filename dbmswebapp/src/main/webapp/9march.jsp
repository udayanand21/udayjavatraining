<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL Demo</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 24px; }
        code { background:#f6f8fa; padding:2px 6px; border-radius:4px; }
    </style>
</head>
<body>
<h1>JSTL Core Demo</h1>

<c:set var="myname" value="Swapna" />
<p>Name: <c:out value="${myname}"/></p>

<c:set var="num1" value="125"/>
<c:set var="num2" value="105"/>
<c:set var="res"  value="${num1 + num2}"/>

<p>Sum (<code>${num1} + ${num2}</code>): <strong><c:out value="${res}"/></strong></p>

<c:set var="str" value="${res % 2 == 0 ? 'Even Number' : 'Odd Number'}"/>
<p>Result is: <strong><c:out value="${str}"/></strong></p>

<c:set var="num" value="3"/>
<c:if test="${num > 5}">Hai</c:if>
<c:if test="${num <= 5}">Hello</c:if>

</body>
</html>
``