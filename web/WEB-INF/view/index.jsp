<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>HuskyShare</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <!-- Javascript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <style>
        .ml-auto .dropdown-menu {
            left: auto !important;
            right: 0;
        }
    </style>
</head>

<body>
<!-- Navigation Bar -->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="index.html"><img src="img/Logos/icon.png" alt="logo" style="width:30px;"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div id="navbar-collapse1" class="collapse navbar-collapse">
        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="index.html">Homepage</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">About</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="about.html">Our Story</a>
                    <a class="dropdown-item" href="#">Contact Us</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop1" data-toggle="dropdown">I Need</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="items.html">Items</a>
                    <a class="dropdown-item" href="#">Tutors</a>
                    <a class="dropdown-item" href="#">Chicken Nuggets</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop2" data-toggle="dropdown">I Have</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Extra Items</a>
                    <a class="dropdown-item" href="#">Knowledge</a>
                    <a class="dropdown-item" href="#">Extra Chicken Nuggets</a>
                </div>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/login"/>">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/register"/>">Register</a>
            </li>
        </ul>
        <form class="form-inline ml-auto" action="#">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-danger my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
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
            <a class="nav-link dropdown-toggle" href="#" id="profileDropdown" data-toggle="dropdown">Profile</a>
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

<!-- Carousel -->
<div class="carousel slide" data-ride="carousel">
    <!-- indicators -->
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>
    <!-- Slideshow -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="<c:url value="/assets/img/Carousel/PlaceHolder1.png"/>" alt="PlaceHolder1" width="100%">
        </div>
        <div class="carousel-item">
            <img src="<c:url value="/assets/img/Carousel/PlaceHolder2.png"/>" alt="PlaceHolder2" width="100%">
        </div>
        <div class="carousel-item">
            <img src="<c:url value="/assets/img/Carousel/PlaceHolder3.png"/>" alt="PlaceHolder3" width="100%">
        </div>
    </div>
    <!-- Left and right controls -->
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
</div>

<div class="jumbotron">
    <h1 class="display-3">HuskyShare</h1>
    <p class="lead">一个基于位置优化冗余资源的校友资源共享平台</p>
    <hr class="my-4">
    <p>在共享资源的同时，获取一定的报酬。</p>
    <p class="lead">
        <a class="btn btn-primary btn-lg" href="about.html" role="button">Learn more</a> <!-- TODO about.html -->
    </p>
</div>

<!-- Main -->
<div class="container">
    <br>
    <p>General Progress</p>
    <div class="progress">
        <div class="progress-bar progress-bar-striped progress-bar-animated" style="width:6%">6%</div>
    </div>
    <br>
    <p>Energy</p>
    <div class="progress">
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="energy"></div>
    </div>
    <br>
    <button type="button" class="btn btn-danger btn-lg btn-block" id="boost" onclick="energy()">Boost</button>
</div>

<!-- footer -->
<footer>
    <p class="card-footer">&copy; 2018 HuskyShare</p>
</footer>
<script>
    function energy() {
        const elem = document.getElementById("energy");
        const width = 1;
        const id = setInterval(frame, 10);
        function frame() {
            if (width >= 100) {
                clearInterval(id)
            } else {
                width++;
                elem.style.width = width + '%';
                elem.innerHTML = width + '%';
            }
        }
    }
</script>

</body>
</html>
