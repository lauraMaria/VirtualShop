<%--
  Created by IntelliJ IDEA.
  User: laura.petrosanu
  Date: 8/11/2015
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="references.jsp"/>

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

    <form method="post" action="/virtualShop/j_spring_security_check"
          class="form-horizontal form-width" autocomplete="off">
        <fieldset class="sigIn">
            <legend>Sign in</legend>
            <div class="form-group">
                <label class="col-lg-2 control-label">Username</label>

                <div class="col-lg-10">
                    <input type="text" autocomplete="off" class="form-control"
                           placeholder="Username" name="j_username"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-2 control-label">Password</label>

                <div class="col-lg-10">
                    <input type="password" autocomplete="off" class="form-control"
                           placeholder="Password" name="j_password"/>
                </div>
                <div class="col-lg-10 error">
                    <p>${error}</p>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <button type="submit" class="form-control btn-default">Sign
                        in
                    </button>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <p class="centered">
                        Don't have an account? <a class="text-underline"
                                                  href="/virtualShop/register.html">Create one</a>
                    </p>
                </div>
            </div>
        </fieldset>
    </form>
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