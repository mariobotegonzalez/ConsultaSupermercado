<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listado de Productos</title>
    <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
    <h1>Productos</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Stock</th>
        </tr>
        <%
            java.sql.ResultSet rs = (java.sql.ResultSet) request.getAttribute("productos");
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("idproducto") %></td>
            <td><%= rs.getString("nombre") %></td>
            <td><%= rs.getFloat("precio") %></td>
            <td><%= rs.getInt("stock") %></td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="index.jsp" class="boton">Volver</a>
</body>
</html>
