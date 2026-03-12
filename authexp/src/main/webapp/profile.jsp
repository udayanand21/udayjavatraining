<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <span class="navbar-brand">Auth Dashboard App</span>

        <ul class="navbar-nav me-auto">
            <li class="nav-item">
                <a class="nav-link" href="home">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="profile">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="dashboard">Dashboard</a>
            </li>
        </ul>

        <a href="logout" class="btn btn-danger btn-sm">Logout</a>
    </div>
</nav>

<div class="container mt-4">
    <div class="card shadow">
        <div class="card-body">
            <h4>User Profile</h4>
            <p><b>Username:</b> Uday Anand</p>
            <p>This page is also protected by Authentication Filter and created me .</p>
        </div>
    </div>
</div>

</body>
</html>