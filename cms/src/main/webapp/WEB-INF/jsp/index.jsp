<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello!</title>
</head>
<body>
<h2 class="hello-title">All Student</h2>
<c:forEach items="${students}" var="student">
    <p>${student.id}</p>
    <p>${student.firstName}</p>
    <p>${student.lastName}</p>
    <p>${student.gpa}</p>
</c:forEach>

</body>
</html>
