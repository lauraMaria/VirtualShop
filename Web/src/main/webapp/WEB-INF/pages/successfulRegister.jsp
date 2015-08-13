<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="references.jsp"/>
<%--
  Created by IntelliJ IDEA.
  User: laura.petrosanu
  Date: 8/11/2015
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <%--<a class="navbar-brand" href="#">Start Bootstrap</a>--%>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/virtualShop/home.html">Home</a>
                </li>
                <li>
                    <a href="/virtualShop/register.html">Register</a>
                </li>
                <li>
                    <a href="/virtualShop/signin.html">Sign in</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<div class="container">

    <h1 class="greeting">Registration completed successfully!</h1>

    <h2>Your information has been processed. Please choose one of the
        following actions:</h2>

    <div class="actions">
        <a id="signinBtn" href="/virtualShop/signin.html" class="btn btn-default">Sign
            in</a> <a id="homeBtn" href="/virtualShop/home.html" class="btn btn-default">Home</a>
    </div>
</div>
<!-- Footer -->
<div class="container">
    <hr>
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p class="centered">Copyright &copy; VirtualShop 2015</p>
            </div>
        </div>
    </footer>

</div>
</body>
</html>
