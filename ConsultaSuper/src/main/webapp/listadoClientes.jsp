<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listado de Clientes</title>
    <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
    <h1>Clientes</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Contacto</th>
        </tr>
        <%
            java.sql.ResultSet rs = (java.sql.ResultSet) request.getAttribute("clientes");
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getString("idcliente") %></td>
            <td><%= rs.getString("cia") %></td>
            <td><%= rs.getString("contacto") %></td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="index.jsp" class="boton">Volver</a>
</body>
</html>
