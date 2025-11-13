<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet Demo</title>
</head>
<body>
    <h1>Hello from JSP! and using Annotations</h1>
    <form>
        <input type="text" value='${name}'>
        <input type="email" value='${email}'>
        <input type="password" value='${designation}'>
    </form>
    <p>Current time: <%= new java.util.Date() %></p>
</body>
</html>
