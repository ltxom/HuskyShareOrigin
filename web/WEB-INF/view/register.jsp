<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Register | HuskyShare</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS and JS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <!-- Utilities JS -->
    <script src="./js/domUtils.js"></script>
    <script src="./js/validation.js"></script>
    <!-- Page-specific JS -->
    <script src="./js/register.js"></script>
    <!-- Page-specific CSS -->
    <link rel="stylesheet" href="css/auth.css">
    <!-- Common CSS -->
    <link rel="stylesheet" href="css/common.css">
</head>
<body class="bg-default">
<!-- Navigation Bar -->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="../../assets/html/index.html"><img src="img/Logos/icon.png" alt="logo" style="width:30px;"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div id="navbar-collapse" class="collapse navbar-collapse">
        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="../../assets/html/index.html">Homepage</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="aboutDropdown" data-toggle="dropdown">About</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Our Story</a>
                    <a class="dropdown-item" href="#">Contact Us</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="iNeedDropdown" data-toggle="dropdown">I Need</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Items</a>
                    <a class="dropdown-item" href="#">Tutors</a>
                    <a class="dropdown-item" href="#">Chicken Nuggets</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="iHaveDropdown" data-toggle="dropdown">I Have</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Extra Items</a>
                    <a class="dropdown-item" href="#">Knowledge</a>
                    <a class="dropdown-item" href="#">Extra Chicken Nuggets</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="profileDropdown" data-toggle="dropdown">Profile</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="user.jsp">View Profile</a>
                    <a class="dropdown-item" href="#">Edit Profile</a>
                    <a class="dropdown-item" href="#">Log out</a>
                </div>
            </li>
        </ul>
        <form class="form-inline ml-auto" action="#">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-danger my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="container-fluid">
    <main>
        <div class="form-container container bg-white mt-3">
            <form action="/submitReg.action" method="POST" id="registerForm">
                <div class="row">
                    <div class="col-lg-5 mr-5">
                        <h3 class="mb-4">Sign up for HuskyShare</h3>
                        <div class="form-group">
                            <input type="email" class="form-control fixed-width-input placeholder-strong"
                                   id="emailInput" name="email" placeholder="Your UW Email">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control fixed-width-input placeholder-strong"
                                   id="passwordInput" name="password" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control fixed-width-input placeholder-strong"
                                   id="confirmPasswordInput" placeholder="Confirm Password">
                        </div>
                        <br>
                        <div class="form-group">
                            <input type="text" class="form-control fixed-width-input placeholder-strong"
                                   id="usernameInput" name="username" placeholder="Username (public)">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control fixed-width-input placeholder-strong"
                                   id="firstNameInput" name="firstName" placeholder="First Name">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control fixed-width-input placeholder-strong"
                                   id="lastNameInput" name="lastName" placeholder="Last Name">
                        </div>
                    </div>
                    <div class="col-lg-6 error-div">
                        <div class="remind-errors alert alert-danger" style="display: none">
                            Please fix the following issues first.
                        </div>
                        <ul>
                            <li class="email-invalid input-invalid">You have entered an invalid email address.</li>
                            <li class="password-invalid input-invalid">Your password should be longer than 8 characters.
                            </li>
                            <li class="password-mismatch input-invalid">Your passwords do not match each other.</li>
                            <li class="username-invalid input-invalid">Please provide a username.</li>
                            <li class="first-name-invalid input-invalid">Please provide your first name.</li>
                            <li class="last-name-invalid input-invalid">Please provide your last name.</li>
                        </ul>
                    </div>
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">Sign up</button>
                </div>
                <div class="mt-3">
                    <small class="form-text text-muted mt-2">Your email and last name will only be visible to you.
                    </small>
                </div>
            </form>
        </div>
    </main>
</div>
</body>
</html>