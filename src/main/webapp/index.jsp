<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<form:form action="/poxclientweb/fooditem" method="post">
<p>Enter your Request in the below TextBox</p>
</br>
<input type="text" name="textb">
<input type="submit" value="Send Req">
</form:form>
</body>
</html>