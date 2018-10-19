<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Login | HuskyShare</title>
    <meta charset="GBK">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS and JS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <!-- Page-specific CSS -->
    <link rel="stylesheet" href="css/auth.css">
    <!-- Common CSS -->
    <link rel="stylesheet" href="css/common.css">
</head>
<body class="bg-default">
<!-- Navigation Bar -->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="index.html"><img src="/img/Logos/icon.png" alt="logo" style="width:30px;"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div id="navbar-collapse" class="collapse navbar-collapse">
        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="index.html">Homepage</a>
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
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Profile</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="profile.html">View Profile</a>
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
            <%
            if(request.getAttribute("msg")!=null&&request.getAttribute("msg").equals("REGISTER_SUCCESS")){
		        out.println("<div class=\"form-container container bg-white mt-3\">\n" +
                  "\t\t<div id=\"myAlert\" class=\"alert alert-success\">\n" +
                "\t\t\t<strong>注册成功！</strong>向您的"+request.getAttribute("email")+"<strong></strong>发送了一封确认邮件，请在登陆前确认。\n" +
                "\t\t</div>");
        }
		%>
        <h2 class="mb-4">Log in to HuskyShare</h2>
        <!-- TODO fix login url -->
        <form action="/login" method="post">
            <div class="form-group">
                <input type="email" class="form-control fixed-width-input" id="emailInput" name="email"
                       aria-describedby="emailHelp" placeholder="email">
            </div>
            <div class="form-group">
                <input type="password" class="form-control fixed-width-input d-inline-block" id="passwordInput"
                       name="password" placeholder="Password">
                <a href="/forgot-password" class="ml-3">Forgot?</a>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Log in</button>
            <div class="form-check d-inline-block ml-3">
                <input type="checkbox" class="form-check-input" id="rememberMeInput" name="remember_me">
                <label class="form-check-label" for="rememberMeInput">Remember me</label>
            </div>
            <!-- TODO implement csrf token -->
            <input type="hidden" name="csrf_token">
        </form>
</div>
<div class="container sub-form-container">
    New to HuskyShare? <a href="/signup">Sign up now -></a>
</div>
</main>
</div>
</body>
</html>