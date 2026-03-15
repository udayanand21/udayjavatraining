<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.coforge.models.Employee" %>
<%
  Employee emp = (Employee) request.getAttribute("emp");
  boolean editing = (emp != null);
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title><%= editing ? "Edit Employee" : "Add Employee" %></title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4">
  <h3 class="mb-3"><%= editing ? "Edit Employee" : "Add Employee" %></h3>

  <form method="POST" action="<%=request.getContextPath()%>/employee">
    <input type="hidden" name="action" value="<%= editing ? "update" : "add" %>">
    
    <% if (editing) { %>
    <div class="mb-3">
      <label class="form-label">EID</label>
      <input type="number" class="form-control" name="eid" value="<%= emp.getEid() %>" readonly>
    </div>
    <% } %>

    <div class="mb-3">
      <label class="form-label">Name</label>
      <input type="text" class="form-control" name="ename" value="<%= editing ? emp.getEename() : "" %>" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Salary</label>
      <input type="number" step="0.01" class="form-control" name="salary" value="<%= editing ? emp.getSalary() : "" %>" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Email</label>
      <input type="email" class="form-control" name="email" value="<%= editing ? emp.getEmail() : "" %>">
    </div>

    <div class="mb-3">
      <label class="form-label">Mobile</label>
      <input type="text" class="form-control" name="mobile" value="<%= editing ? emp.getMobile() : "" %>">
    </div>

    <div class="mb-3">
      <label class="form-label">Date of Joining (DOJ)</label>
      <input type="date" class="form-control" name="doj" value="<%= (editing && emp.getDoj()!=null) ? emp.getDoj() : "" %>">
    </div>

    <div class="mb-3">
      <label class="form-label">Date of Birth (DOB)</label>
      <input type="date" class="form-control" name="dob" value="<%= (editing && emp.getDob()!=null) ? emp.getDob() : "" %>">
    </div>

    <button type="submit" class="btn btn-success"><%= editing ? "Update" : "Add" %></button>
    <a class="btn btn-secondary" href="<%=request.getContextPath()%>/employee">Cancel</a>
  </form>
</div>
</body>
</html>