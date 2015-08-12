<%--
  Created by IntelliJ IDEA.
  User: laura.petrosanu
  Date: 8/11/2015
  Time: 1:40 PM
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
                <li id="myCart"><a href="/virtualShop/myCart.html" class="">My cart</a></li>
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
    <c:choose>
        <c:when test="${products.size() > 0}">

            <table class="table ordersTable">
                <thead>
                <tr>
                    <th class="hidden"></th>
                    <th>Ordered Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td class="hidden">${product.productDTO.idProduct}</td>
                        <td>${product.productDTO.shortName}</td>
                        <td><input value="${product.quantity}">
                            <a href="#" class="btn btn-default editBtn">Edit</a>
                        </td>
                        <td>${product.totalPrice}</td>
                        <td>
                            <button class="btn btn-default deleteBtn">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <form:form commandName="addOrder" method="post" id="addOrderFrm">
                <div>
                    <p class="fontBold" id="totalCost">Total cost : ${cost} lei</p>
                    <a href="#" id="sendOrder" class="btn btn-default sendOrderBtn">Send order</a>
                </div>
                <div id="orderedProducts"></div>
            </form:form>
        </c:when>
        <c:otherwise>
            <p class="fontLarge">There are no products added to cart!</p>
        </c:otherwise>
    </c:choose>
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
        $('#myCart').addClass('active');

        //handle edit quantity
        editQuantity();

        //handle send order
        sendOrder();

    });
    function editQuantity() {
        $('a.editBtn').click(function () {
            //disable all other edit buttons from the page
            $("a.editBtn").attr("disabled", true);

            //get the edited quantity
            var quantity = $(this).closest('tr').find('input:first').val();
            //get the price
            var price = $(this).closest('tr').find(':nth-child(4n)').text();

            //update the price per product
            var priceQuantity = parseFloat(quantity) * parseFloat(price);
            $(this).closest('tr').find(':nth-child(4n)').text(priceQuantity);
            //get total cost and update total cost of the order
            var total = parseFloat(0);
            $('.ordersTable tbody tr').each(function (i, row) {
                var rowPrice = parseFloat($(row).find(':nth-child(4n)').text())
                total += rowPrice;
            });
            $('#totalCost').text('Total cost: ' + total + ' lei');
            //enable the edit buttons
            $("a.editBtn").attr("disabled", false);
        });
    }

    function sendOrder() {
        $('#sendOrder').click(function () {
            var totalOrder = parseFloat(0);
            $('.ordersTable tbody tr').each(function (i, row) {
                //get the product id
                var productId = $(this).find('td:first').text();
                debugger;
                //get the edited quantity
                var quantity = $(this).closest('tr').find('input:first').val();
                //get the price
                var price = $(this).closest('tr').find(':nth-child(4n)').text();
                totalOrder += parseFloat(price);


                //append to the form
                $('#orderedProducts').append('<input type="hidden" name="cartProducts[' + i + '].productDTO.idProduct" value="' + productId + '"></input>');
                $('#orderedProducts').append('<input type="hidden" name="cartProducts[' + i + '].quantity" value="' + quantity + '"></input>');
                $('#orderedProducts').append('<input type="hidden" name="cartProducts[' + i + '].totalPrice" value="' + price + '"></input>');

            });
            $('#orderedProducts').append('<input type="hidden" name="totalOrder" value="' + totalOrder + '"></input>');

           $('#addOrderFrm').submit();

        });
    }
</script>