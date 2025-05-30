<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Parking System - Authentication</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrapFiles/bootstrap.min.css" />
    <style>
        .form-toggle {
            cursor: pointer;
            color: #0d6efd;
            text-decoration: underline;
        }
    </style>
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card p-4 shadow">

                <!-- Sign In Form -->
                <div id="signInForm">
                    <h4 class="text-center mb-4">Sign In</h4>
                    <form action="loginServlet" method="post">
                        <div class="mb-3">
                            <label for="signinUsername" class="form-label">Username or Email</label>
                            <input type="text" class="form-control" id="signinUsername" name="username" required />
                        </div>
                        <div class="mb-3">
                            <label for="signinPassword" class="form-label">Password</label>
                            <input type="password" class="form-control" id="signinPassword" name="password" required />
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Login</button>
                    </form>
                    <p class="text-center mt-3">
                        Don't have an account? 
                        <span class="form-toggle" onclick="toggleForms()">Sign Up</span>
                    </p>
                </div>

                <!-- Sign Up Form (hidden by default) -->
                <div id="signUpForm" style="display:none;">
                    <h4 class="text-center mb-4">Sign Up</h4>
                    <form action="registerServlet" method="post">
                        <div class="mb-3">
                            <label for="signupFullname" class="form-label">Full Name</label>
                            <input type="text" class="form-control" id="signupFullname" name="fullname" required />
                        </div>
                        <div class="mb-3">
                            <label for="signupEmail" class="form-label">Email</label>
                            <input type="email" class="form-control" id="signupEmail" name="email" required />
                        </div>
                        <div class="mb-3">
                            <label for="signupRole" class="form-label">Role</label>
                            <select class="form-select" id="signupRole" name="role" required>
                                <option value="">Select Role</option>
                                <option value="Admin">Admin</option>
                                <option value="User">User</option>
                                <option value="Guard">Guard</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="signupPassword" class="form-label">Password</label>
                            <input type="password" class="form-control" id="signupPassword" name="password" required />
                        </div>
                        <button type="submit" class="btn btn-success w-100">Register</button>
                    </form>
                    <p class="text-center mt-3">
                        Already have an account? 
                        <span class="form-toggle" onclick="toggleForms()">Sign In</span>
                    </p>
                </div>

            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/bootstrapFiles/bootstrap.bundle.min.js"></script>
<script>
    function toggleForms() {
        const signInForm = document.getElementById('signInForm');
        const signUpForm = document.getElementById('signUpForm');

        if (signInForm.style.display === 'none') {
            signInForm.style.display = 'block';
            signUpForm.style.display = 'none';
        } else {
            signInForm.style.display = 'none';
            signUpForm.style.display = 'block';
        }
    }
</script>
</body>
</html>
