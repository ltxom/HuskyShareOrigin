<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.huskyshare.backend.model.user.User" %>
<html lang="en">
<head>
    <title>Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <style>
        .ml-auto .dropdown-menu {
            left: auto !important;
            right: 0px;
        }
    </style>
</head>

<body>
<!-- Navigation Bar -->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="../../assets/html/index.html"><img src="/img/Logos/icon.png" alt="logo" style="width:30px;"></a>
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
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">About</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Our Story</a>
                    <a class="dropdown-item" href="#">Contact Us</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">I Need</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Items</a>
                    <a class="dropdown-item" href="#">Tutors</a>
                    <a class="dropdown-item" href="#">Chicken Nuggets</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">I Have</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Extra Items</a>
                    <a class="dropdown-item" href="#">Knowledge</a>
                    <a class="dropdown-item" href="#">Extra Chicken Nuggets</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Profile</a>
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

<div class="container" style="width:400px">
    <div class="row">
        <div class=".col-lg-2"></div>
        <div class=".col-lg-8">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">No.</th>
                    <th scope="col">User Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">First Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userList }" var="user">
                    <tr>
                        <td>${user.id }</td>
                        <td>${user.username }</td>
                        <td>${user.email }</td>
                        <td>${user.lastName }</td>
                        <td>${user.firstName }</td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class=".col-lg-2"></div>
    </div>
</div>

</body>
</html>