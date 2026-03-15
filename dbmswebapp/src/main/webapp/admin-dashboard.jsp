<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.coforge.models.Employee" %>
<%
  HttpSession sess = request.getSession(false);
  if (sess == null || !"admin".equals(sess.getAttribute("role"))) {
    response.sendRedirect(request.getContextPath() + "/login.jsp");
    return;
  }
  String username = (String) sess.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard - Employee Management</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css" rel="stylesheet">
  <style>
    body {
      background-color: #f5f5f5;
    }
    .navbar-custom {
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    .navbar-custom .navbar-brand {
      font-weight: 700;
      font-size: 20px;
    }
    .sidebar-actions {
      background: white;
      padding: 20px;
      border-radius: 8px;
      margin-bottom: 20px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.05);
    }
    .btn-group-vertical {
      gap: 10px;
      display: flex;
      flex-direction: column;
    }
    .table-container {
      background: white;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.05);
    }
    .search-modal-btn {
      font-size: 16px;
      font-weight: 600;
      padding: 12px 24px;
    }
    .employee-table {
      margin-top: 20px;
    }
    .modal-header {
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      color: white;
    }
    .modal-header .btn-close {
      filter: brightness(0) invert(1);
    }
  </style>
</head>
<body>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-dark navbar-custom">
    <div class="container-fluid">
      <a class="navbar-brand" href="<%=request.getContextPath()%>/admin-dashboard">
        <i class="bi bi-shield-lock"></i> Admin Dashboard
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
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
    </div>
  </nav>

  <div class="container-fluid py-4">
    <div class="row">
      <!-- Sidebar -->
      <div class="col-lg-2">
        <div class="sidebar-actions">
          <h5 class="mb-3"><i class="bi bi-sliders"></i> Actions</h5>
          <div class="btn-group-vertical">
            <a href="<%=request.getContextPath()%>/employee?action=addForm" class="btn btn-success">
              <i class="bi bi-plus-circle"></i> Add Employee
            </a>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#searchModal">
              <i class="bi bi-search"></i> Search
            </button>
            <a href="<%=request.getContextPath()%>/admin-dashboard" class="btn btn-info">
              <i class="bi bi-list"></i> View All
            </a>
          </div>
        </div>
      </div>

      <!-- Main Content -->
      <div class="col-lg-10">
        <div class="table-container">
          <h3 class="mb-4"><i class="bi bi-table"></i> Employee List</h3>
          
          <table class="table table-striped table-hover employee-table">
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
              if (employees != null && !employees.isEmpty()) {
                for (Employee e : employees) {
            %>
              <tr>
                <td><strong><%= e.getEid() %></strong></td>
                <td><%= e.getEename() %></td>
                <td>₹<%= String.format("%.2f", e.getSalary()) %></td>
                <td><%= e.getEmail() %></td>
                <td><%= e.getMobile() %></td>
                <td><%= e.getDoj() != null ? e.getDoj() : "-" %></td>
                <td><%= e.getDob() != null ? e.getDob() : "-" %></td>
                <td class="d-flex gap-2">
                  <a class="btn btn-sm btn-warning" href="<%=request.getContextPath()%>/employee?action=edit&eid=<%=e.getEid()%>" title="Edit">
                    <i class="bi bi-pencil"></i>
                  </a>
                  <a class="btn btn-sm btn-danger" href="<%=request.getContextPath()%>/employee?action=delete&eid=<%=e.getEid()%>" 
                     onclick="return confirm('Delete employee <%=e.getEid()%>?');" title="Delete">
                    <i class="bi bi-trash"></i>
                  </a>
                </td>
              </tr>
            <%
                }
              } else {
            %>
              <tr>
                <td colspan="8" class="text-center text-muted py-4">
                  No employees found
                </td>
              </tr>
            <% } %>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>

  <!-- Search Modal -->
  <div class="modal fade" id="searchModal" tabindex="-1">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title"><i class="bi bi-search"></i> Search Employees</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
        <div class="modal-body">
          <div class="d-grid gap-3">
            <!-- Search by Name -->
            <form method="GET" action="<%=request.getContextPath()%>/employee" class="search-form">
              <input type="hidden" name="action" value="searchByName">
              <div class="input-group">
                <input type="text" class="form-control" name="name" placeholder="Enter employee name" required>
                <button type="submit" class="btn btn-primary">Search by Name</button>
              </div>
            </form>

            <!-- Search by Mobile -->
            <form method="GET" action="<%=request.getContextPath()%>/employee" class="search-form">
              <input type="hidden" name="action" value="searchByMobile">
              <div class="input-group">
                <input type="text" class="form-control" name="mobile" placeholder="Enter mobile number" required>
                <button type="submit" class="btn btn-primary">Search by Mobile</button>
              </div>
            </form>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
