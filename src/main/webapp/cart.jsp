<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <link rel="stylesheet" href="styles/style.css">
</head>
<body>

    <h3>Your cart</h3>

    <table>
        <tr>
            <th>Quantity</th>
            <th>Description</th>
            <th>Price</th>
            <th>Amount</th>
            <th></th>
        </tr>

        <c:forEach var="item" items="${cart.items}">
            <tr>
                <td>
                    <form action="cart" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="description" value="${item.description}">
                        <input type="number" name="quantity" value="${item.quantity}" min="1">
                        <button type="submit">Update</button>
                    </form>
                </td>
                <td>${item.description}</td>
                <td>${item.price}</td>
                <td>${item.total}</td>
                <td>
                    <form action="cart" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="remove">
                        <input type="hidden" name="description" value="${item.description}">
                        <button type="submit">Remove Item</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p>
        <strong>To change the quantity</strong>, enter the new quantity and click on the Update button.
    </p>

    <form action="index.html" method="get" style="display:inline;">
        <button type="submit">Continue Shopping</button>
    </form>
    <br><br>
    <button type="button">Checkout</button>

</body>
</html>
