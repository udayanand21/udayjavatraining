<!DOCTYPE html>
<html>
<head>
    <title>MyBank</title>
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

<!-- DASHBOARD -->
<div class="container mt-5">
    <div class="card p-4 shadow text-center">
        <h3 class="mb-4 text-primary">Banking Dashboard</h3>

        <a href="createAccount.jsp" class="btn btn-success m-2">Create Account</a>
        <a href="view" class="btn btn-primary m-2">View Accounts</a>
        <a href="deposit.jsp" class="btn btn-warning m-2">Deposit</a>
        <a href="withdraw.jsp" class="btn btn-danger m-2">Withdraw</a>
    </div>
</div>

</body>
</html>