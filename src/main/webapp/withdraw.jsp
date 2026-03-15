<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>withdraw</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="logout" class="btn btn-outline-light">Logout</a>

<form action="withdraw" method="post">
  <input name="accno" class="form-control mb-2" placeholder="Account No">
  <input name="amount" class="form-control mb-2" placeholder="Amount">
  <button class="btn btn-danger w-100">Withdraw</button>
</form>
</body>
</html>