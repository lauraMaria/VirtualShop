<%--
  Created by IntelliJ IDEA.
  User: laura.petrosanu
  Date: 8/11/2015
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="references.jsp"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>VirtualShop Homepage</title>

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
                    <p class="outputUser">Welcome ${user}!</p>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/virtualShop/myCart.html">My cart</a></li>
                <li>
                    <a href="#">Previous orders</a>
                </li>
                <li><a href="<c:url value="/virtualShop/j_spring_security_logout"/>"> Sign out</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">
        <div class="col-md-12">

            <div class="row carousel-holder">

                <div class="col-md-12">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="slide-image" src="\images\img1.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="\images\img2.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="\images\img3.jpg" alt="">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                </div>

            </div>
            <div class="row">
                <c:forEach items="${list}" var="item">
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="${item.imageSrc}" alt="">
                            <input type="hidden" value="${item.idProduct}">

                            <div class="caption">
                                <h4 class="pull-right">${item.price} lei</h4>
                                <h4><a href="#">${item.shortName}</a>
                                </h4>

                                <p>${item.name}</p>
                            </div>
                            <div class="ratings">
                               <a href="/virtualShop/addToCart?id=${item.idProduct}" class="btn btn-default cartBtn">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>

    </div>

</div>

</div>
<!-- /.container -->

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

