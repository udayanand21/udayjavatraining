<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.coforge.models.Employee" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Employees</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4">
  <div class="d-flex justify-content-between align-items-center mb-3">
    <h3 class="mb-0">Employee List</h3>
    <a class="btn btn-primary" href="<%=request.getContextPath()%>/employee?action=addForm">Add Employee</a>
  </div>

  <!-- Search Section -->
  <div class="card mb-4">
    <div class="card-body">
      <h5 class="card-title">Search Employees</h5>
      <div class="row g-3">
        <!-- Search by Mobile -->
        <div class="col-md-5">
          <form method="GET" action="<%=request.getContextPath()%>/employee" class="d-flex gap-2">
            <input type="hidden" name="action" value="searchByMobile">
            <input type="text" class="form-control" name="mobile" placeholder="Enter mobile number" 
                   value="<%= (request.getAttribute("searchType") != null && "mobile".equals(request.getAttribute("searchType"))) ? request.getAttribute("searchValue") : "" %>">
            <button type="submit" class="btn btn-info">Search by Mobile</button>
          </form>
        </div>
        
        <!-- Search by Name -->
        <div class="col-md-5">
          <form method="GET" action="<%=request.getContextPath()%>/employee" class="d-flex gap-2">
            <input type="hidden" name="action" value="searchByName">
            <input type="text" class="form-control" name="name" placeholder="Enter employee name" 
                   value="<%= (request.getAttribute("searchType") != null && "name".equals(request.getAttribute("searchType"))) ? request.getAttribute("searchValue") : "" %>">
            <button type="submit" class="btn btn-info">Search by Name</button>
          </form>
        </div>

        <!-- Clear Search -->
        <div class="col-md-2">
          <a class="btn btn-secondary w-100" href="<%=request.getContextPath()%>/employee">Clear Search</a>
        </div>
      </div>
      
      <!-- Search Result Message -->
      <% 
        String searchType = (String) request.getAttribute("searchType");
        String searchValue = (String) request.getAttribute("searchValue");
        if (searchType != null && searchValue != null) {
      %>
        <div class="alert alert-info mt-3 mb-0">
          Showing results for <strong><%= searchType.equals("mobile") ? "Mobile: " : "Name: " %><%= searchValue %></strong>
        </div>
      <% } %>
      
      <!-- Error Message -->
      <% 
        String searchError = (String) request.getAttribute("searchError");
        if (searchError != null) {
      %>
        <div class="alert alert-warning mt-3 mb-0">
          <%= searchError %>
        </div>
      <% } %>
    </div>
  </div>

  <table class="table table-striped table-hover">
    <thead class="table-dark">
      <tr>
        <th>EID</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>DOJ</th>
        <th>DOB</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    <%
      List<Employee> employees = (List<Employee>) request.getAttribute("employees");
      if (employees != null) {
        for (Employee e : employees) {
    %>
      <tr>
        <td><%= e.getEid() %></td>
        <td><%= e.getEename() %></td>
        <td><%= e.getSalary() %></td>
        <td><%= e.getEmail() %></td>
        <td><%= e.getMobile() %></td>
        <td><%= e.getDoj() != null ? e.getDoj() : "" %></td>
        <td><%= e.getDob() != null ? e.getDob() : "" %></td>
        <td class="d-flex gap-2">
          <a class="btn btn-sm btn-warning" href="<%=request.getContextPath()%>/employee?action=edit&eid=<%=e.getEid()%>">Edit</a>
          <a class="btn btn-sm btn-danger" href="<%=request.getContextPath()%>/employee?action=delete&eid=<%=e.getEid()%>"
             onclick="return confirm('Delete employee <%=e.getEid()%>?');">Delete</a>
        </td>
      </tr>
    <%
        }
      }
    %>
    </tbody>
  </table>
</div>
</body>
</html>