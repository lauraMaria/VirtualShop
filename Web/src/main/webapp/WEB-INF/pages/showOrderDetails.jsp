<%--
  Created by IntelliJ IDEA.
  User: laura.petrosanu
  Date: 8/13/2015
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <li><a href="/virtualShop/common.html">Home</a></li>
                <li id="myCart"><a href="/virtualShop/myCart.html" class="">My cart</a></li>
                <li id="showOrders">
                    <a href="/virtualShop/showOrders.html">Show orders</a>
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

    <h4 class="left5px">Order number: ${order.idOrder}</h4>
    <h4 class="left5px">Date: ${order.date}</h4>
    <h4 class="left5px">Total: ${order.amount} lei</h4>
    <h4 class="left5px">Products:</h4>
    <table class="table">
        <thead>
        <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.productDTO.shortName}</td>
                <td>$${product.quantity}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/virtualShop/showOrders.html" class="btn btn-default">Back</a>

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
<script type="text/javascript">
    $(document).ready(function () {
        $('#showOrders').addClass('active');
    })
</script>
