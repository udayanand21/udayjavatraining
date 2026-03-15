<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Power Calculator</title>
    <!-- Bootstrap CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
</head>
<body class="bg-light">
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow-sm rounded-4">
                <div class="card-header bg-primary text-white rounded-top-4">
                    <h4 class="mb-0">Power Calculator (Math.pow)</h4>
                </div>
                <div class="card-body">

                    <%
                        String baseStr = request.getParameter("base");
                        String expStr  = request.getParameter("exp");

                        Double base = null;
                        Double exp  = null;
                        Double result = null;
                        String error = null;

                        if ("POST".equalsIgnoreCase(request.getMethod())) {
                            if (baseStr == null || baseStr.trim().isEmpty() ||
                                expStr == null  || expStr.trim().isEmpty()) {
                                error = "Both fields are required.";
                            } else {
                                try {
                                    base = Double.parseDouble(baseStr.trim());
                                    exp  = Double.parseDouble(expStr.trim());
                                    result = Math.pow(base, exp);
                                } catch (NumberFormatException e) {
                                    error = "Please enter valid numbers.";
                                }
                            }
                        }
                    %>

                    <form method="post" action="power.jsp" class="needs-validation" novalidate>
                        <div class="mb-3">
                            <label for="base" class="form-label">Base</label>
                            <input type="text"
                                   class="form-control"
                                   id="base"
                                   name="base"
                                   placeholder="e.g., 2.5"
                                   value="<%= (baseStr != null ? baseStr : "") %>">
                        </div>

                        <div class="mb-3">
                            <label for="exp" class="form-label">Exponent</label>
                            <input type="text"
                                   class="form-control"
                                   id="exp"
                                   name="exp"
                                   placeholder="e.g., 3"
                                   value="<%= (expStr != null ? expStr : "") %>">
                        </div>

                        <div class="d-flex gap-2">
                            <button type="submit" class="btn btn-primary">Calculate</button>
                            <a href="power.jsp" class="btn btn-outline-secondary">Reset</a>
                        </div>
                    </form>

                    <hr class="my-4"/>

                    <% if (error != null) { %>
                        <div class="alert alert-danger" role="alert">
                            <%= error %>
                        </div>
                    <% } else if (result != null) { %>
                        <div class="alert alert-success" role="alert">
                            <strong>Result:</strong>
                            <code><%= base %> ^ <%= exp %> = <%= result %></code>
                        </div>
                    <% } %>

                </div>
            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS (optional for basic form) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>