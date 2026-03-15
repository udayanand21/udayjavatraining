<%@ page import="java.util.*,com.bank.model.Account" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Accounts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<!-- NAVBAR -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <span class="navbar-brand">MyBank</span>
        <a href="logout" class="btn btn-outline-light">Logout</a>
    </div>
</nav>

<div class="container mt-5">
    <table class="table table-bordered table-hover shadow">
        <thead class="table-dark">
            <tr>
                <th>Acc</th>
                <th>Name</th>
                <th>Type</th>
                <th>Balance</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Account> list = (List<Account>) request.getAttribute("list");
                for(Account a : list){
            %>
            <tr>
                <td><%=a.getAccno()%></td>
                <td><%=a.getName()%></td>
                <td><%=a.getType()%></td>
                <td><%=a.getBalance()%></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</div>

</body>
</html>