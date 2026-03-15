<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management - Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        }
        .login-container {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 450px;
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
        }
        .role-selection {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 15px;
            margin-bottom: 20px;
        }
        .role-btn {
            padding: 15px;
            border: 2px solid #ddd;
            border-radius: 8px;
            background: white;
            cursor: pointer;
            transition: all 0.3s ease;
            font-size: 16px;
            font-weight: 500;
        }
        .role-btn:hover {
            border-color: #667eea;
            background: #f0f4ff;
        }
        .role-btn.active {
            background: #667eea;
            color: white;
            border-color: #667eea;
        }
        .username-group {
            margin-bottom: 20px;
        }
        .username-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: 500;
            color: #333;
        }
        .username-group input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
        }
        .login-btn {
            width: 100%;
            padding: 12px;
            background: #667eea;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: background 0.3s ease;
            margin-top: 20px;
        }
        .login-btn:hover {
            background: #5568d3;
        }
        .login-btn:disabled {
            background: #ccc;
            cursor: not-allowed;
        }
        .error-message {
            color: #dc3545;
            font-size: 14px;
            margin-top: 10px;
            text-align: center;
        }
        .info-text {
            font-size: 12px;
            color: #999;
            text-align: center;
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>🏢 Employee Management</h2>
        
        <form method="POST" action="<%=request.getContextPath()%>/login">
            <div class="role-selection">
                <button type="button" class="role-btn active" onclick="selectRole('admin')">
                    👨‍💼 Admin
                </button>
                <button type="button" class="role-btn" onclick="selectRole('user')">
                    👤 User
                </button>
            </div>
            
            <input type="hidden" id="roleInput" name="role" value="admin">
            
            <div class="username-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" placeholder="Enter username" required>
            </div>
            
            <div class="username-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter password" required>
            </div>
            
            <button type="submit" class="login-btn">Login</button>
            
            <% 
                String error = request.getParameter("error");
                if (error != null) {
            %>
                <div class="error-message">
                    ⚠️ Invalid credentials. Please try again.
                </div>
            <% } %>
            
            <div class="info-text">
                <strong>Demo Credentials:</strong><br>
                Admin: admin / admin123<br>
                User: user / user123
            </div>
        </form>
    </div>

    <script>
        function selectRole(role) {
            document.getElementById('roleInput').value = role;
            
            const buttons = document.querySelectorAll('.role-btn');
            buttons.forEach(btn => btn.classList.remove('active'));
            
            event.target.classList.add('active');
        }
    </script>
</body>
</html>
