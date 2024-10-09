<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listado de Ventas</title>
    <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
    <h1>Ventas</h1>
    <table>
        <tr>
            <th>ID Pedido</th>
            <th>ID Cliente</th>
            <th>Fecha Pedido</th>
            <th>Fecha Entrega</th>
        </tr>
        <%
            java.sql.ResultSet rs = (java.sql.ResultSet) request.getAttribute("ventas");
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("idpedido") %></td>
            <td><%= rs.getString("idcliente") %></td>
            <td><%= rs.getDate("fechapedido") %></td>
            <td><%= rs.getDate("fechaentrega") %></td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="index.jsp" class="boton">Volver</a>
</body>
</html>
