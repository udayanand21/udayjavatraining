<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.coforge.models.Employee" %>
<%
  HttpSession sess = request.getSession(false);
  if (sess == null || !"user".equals(sess.getAttribute("role"))) {
    response.sendRedirect(request.getContextPath() + "/login.jsp");
    return;
  }
  String username = (String) sess.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>User View - Employee Management</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css" rel="stylesheet">
  <style>
    body {
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      min-height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
      padding: 20px;
    }
    .navbar-custom {
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      position: fixed;
      width: 100%;
      top: 0;
      z-index: 1000;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    .main-container {
      margin-top: 70px;
      width: 100%;
    }
    .card-container {
      max-width: 600px;
      margin: 0 auto;
      background: white;
      border-radius: 12px;
      box-shadow: 0 10px 30px rgba(0,0,0,0.2);
      overflow: hidden;
    }
    .card-header {
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      color: white;
      padding: 30px;
      text-align: center;
    }
    .card-header h2 {
      margin: 0;
      font-size: 28px;
    }
    .search-section {
      padding: 30px;
      border-bottom: 1px solid #eee;
    }
    .search-section h4 {
      color: #333;
      margin-bottom: 20px;
      font-weight: 600;
    }
    .result-section {
      padding: 30px;
    }
    .employee-info {
      background: #f8f9fa;
      border-radius: 8px;
      padding: 20px;
      margin-top: 15px;
    }
    .info-row {
      display: flex;
      justify-content: space-between;
      padding: 12px 0;
      border-bottom: 1px solid #e0e0e0;
    }
    .info-row:last-child {
      border-bottom: none;
    }
    .info-label {
      font-weight: 600;
      color: #555;
      min-width: 120px;
    }
    .info-value {
      color: #333;
      text-align: right;
    }
    .not-found {
      color: #dc3545;
      font-weight: 500;
      padding: 15px;
      background: #f8d7da;
      border: 1px solid #f5c6cb;
      border-radius: 5px;
    }
    .search-input {
      padding: 12px;
      font-size: 16px;
    }
    .search-btn {
      padding: 12px 24px;
      font-size: 16px;
    }
    .no-result-icon {
      font-size: 48px;
      color: #dc3545;
      margin-bottom: 15px;
    }
    .success-icon {
      font-size: 48px;
      color: #28a745;
      margin-bottom: 15px;
    }
  </style>
</head>
<body>
  <!-- Navbar -->
  <nav class="navbar navbar-dark navbar-custom">
    <div class="container-fluid">
      <a class="navbar-brand" href="<%=request.getContextPath()%>/user-view">
        <i class="bi bi-person"></i> User View
      </a>
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <span class="nav-link" style="cursor: default;">
            <i class="bi bi-person-circle"></i> <%= username %>
          </span>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/logout">
            <i class="bi bi-box-arrow-right"></i> Logout
          </a>
        </li>
      </ul>
    </div>
  </nav>

  <div class="main-container">
    <div class="card-container">
      <!-- Header -->
      <div class="card-header">
        <h2><i class="bi bi-search"></i> Search Employee</h2>
        <p class="mt-2 mb-0">Find employee information by name</p>
      </div>

      <!-- Search Section -->
      <div class="search-section">
        <h4><i class="bi bi-magnifying-glass"></i> Enter Employee Name</h4>
        <form method="GET" action="<%=request.getContextPath()%>/user-view">
          <input type="hidden" name="action" value="searchByName">
          <div class="input-group">
            <input type="text" class="form-control search-input" name="name" placeholder="e.g., John" required>
            <button class="btn btn-primary search-btn" type="submit">
              <i class="bi bi-search"></i> Search
            </button>
          </div>
        </form>
      </div>

      <!-- Result Section -->
      <div class="result-section">
        <%
          Boolean found = (Boolean) request.getAttribute("found");
          Employee emp = (Employee) request.getAttribute("employee");
          String searchedName = (String) request.getAttribute("searchedName");

          if (found != null && found) {
            // Employee found
        %>
          <div class="text-center mb-3">
            <div class="success-icon">
              <i class="bi bi-check-circle"></i>
            </div>
            <h5 style="color: #28a745;">Employee Found!</h5>
          </div>

          <div class="employee-info">
            <div class="info-row">
              <span class="info-label"><i class="bi bi-key"></i> Employee ID</span>
              <span class="info-value"><strong><%= emp.getEid() %></strong></span>
            </div>
            <div class="info-row">
              <span class="info-label"><i class="bi bi-person"></i> Name</span>
              <span class="info-value"><strong><%= emp.getEename() %></strong></span>
            </div>
            <div class="info-row">
              <span class="info-label"><i class="bi bi-envelope"></i> Email</span>
              <span class="info-value"><strong><%= emp.getEmail() != null ? emp.getEmail() : "-" %></strong></span>
            </div>
          </div>

          <div class="alert alert-info mt-4 mb-0">
            <i class="bi bi-info-circle"></i> 
            This information is visible to users. Sensitive details like phone number, salary, and dates are restricted.
          </div>

        <%
          } else if (found != null && !found) {
            // Not found
        %>
          <div class="text-center mb-3">
            <div class="no-result-icon">
              <i class="bi bi-exclamation-circle"></i>
            </div>
            <h5 style="color: #dc3545;">No Employee Found</h5>
            <p class="text-muted">
              Employee with name "<strong><%= searchedName %></strong>" not found in the system.
            </p>
          </div>

        <%
          } else {
            // Initial state - no search yet
        %>
          <div class="text-center text-muted py-4">
            <i class="bi bi-search" style="font-size: 48px; opacity: 0.5;"></i>
            <p class="mt-3">Enter an employee name to search and view non-sensitive information.</p>
          </div>

        <% } %>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
