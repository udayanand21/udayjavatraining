<!DOCTYPE html>
<html>
<head>
    <title>Deposit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5 col-md-4">
    <div class="card shadow p-4">
        <h3 class="text-center text-success mb-3">Deposit Amount</h3>

        <form action="deposit" method="post">
            <input type="text" name="accno" class="form-control mb-3"
                   placeholder="Account Number" required>

            <input type="text" name="amount" class="form-control mb-3"
                   placeholder="Amount" required>

            <button type="submit" class="btn btn-success w-100">
                Deposit
            </button>
        </form>
    </div>
</div>

</body>
</html>