<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado Validación</title>
</head>
<body>
<h2> <%= request.getAttribute("mensaje") %></h2>
    <% String nombre = (String) request.getAttribute("nombre");
       if (nombre != null && !nombre.isEmpty()) { %>
        <h2> Nombre completo: <%= nombre %></h2>
    <% } %>

    <% Integer rut = (Integer) request.getAttribute("rut");
       if (rut != null) { %>
        <h2> RUT: <%= rut %></h2>
    <% } %>

    <% String telefono = (String) request.getAttribute("telefono");
       if (telefono != null && !telefono.isEmpty()) { %>
        <h2> Telefono: <%= telefono %></h2>
    <% } %>
</body>
</html>