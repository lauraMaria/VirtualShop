<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%--
  Created by IntelliJ IDEA.
  User: laura.petrosanu
  Date: 8/11/2015
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form:form commandName="registerFrm" method="post"
               class="form-horizontal form-width" autocomplete="off">

        <fieldset class="addUserField">
            <legend>Register new user</legend>
            <div class="form-group">
                <label class="col-lg-2 control-label">First
                    name</label>

                <div class="col-lg-10">
                    <form:input type="text" class="form-control"
                                placeholder="First name" path="firstName"/>
                </div>
                <div class="col-lg-10 error">
                    <form:errors path="firstName"/>
                </div>
            </div>


            <div class="form-group">
                <label class="col-lg-2 control-label">Last
                    name</label>

                <div class="col-lg-10">
                    <form:input type="text" class="form-control"
                                placeholder="Last name" path="lastName"/>
                </div>
                <div class="col-lg-10 error">
                    <form:errors path="lastName"/>
                </div>
            </div>


            <div class="form-group">
                <label class="col-lg-2 control-label">Username</label>

                <div class="col-lg-10">
                    <form:input type="text" autocomplete="off" class="form-control"
                                placeholder="Username" path="username"/>
                </div>
                <div class="col-lg-10 error">
                    <form:errors path="username"/>
                </div>
                <div class="col-lg-10 error">
                    <p>${notAvailable }</p>
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-2 control-label">Password</label>

                <div class="col-lg-10">
                    <form:input type="password" autocomplete="off" class="form-control"
                                placeholder="Password" path="password"/>
                </div>
                <div class="col-lg-10 error">
                    <form:errors path="password"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-2 control-label">Confirm
                    password</label>

                <div class="col-lg-10">
                    <form:input type="password" class="form-control"
                                placeholder="Confirm password" path="confPassword"/>
                </div>
                <div class="col-lg-10 error">
                    <form:errors path="confPassword"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-2 control-label">Email
                    address</label>

                <div class="col-lg-10">
                    <form:input type="text" class="form-control"
                                placeholder="Email address" path="email"/>
                </div>
                <div class="col-lg-10 error">
                    <form:errors path="email"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-2 control-label">Confirm email
                    address</label>

                <div class="col-lg-10">
                    <form:input type="text" class="form-control"
                                placeholder="Confirm email address" path="confEmail"/>
                </div>
                <div class="col-lg-10 error">
                    <form:errors path="confEmail"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <a class="btn btn-default" href="/virtualShop/home.html">Cancel</a>
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </div>
        </fieldset>
    </form:form>
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
