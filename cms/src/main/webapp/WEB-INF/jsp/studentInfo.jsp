<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Student Details</h2>
    <div class="form-group row">
        <label class="col-2 col-form-label">ID</label>
        <div class="col-10">
            ${student.id}
        </div>
    </div>

    <div class="form-group row">
        <label class="col-2 col-form-label">First Name</label>
        <div class="col-10">
            ${student.firstName}
        </div>
    </div>

    <div class="form-group row">
        <label class="col-2 col-form-label">Last Name</label>
        <div class="col-10">
            ${student.lastName}
        </div>
    </div>

    <div class="form-group row">
        <label class="col-2 col-form-label">GPA</label>
        <div class="col-10">
            ${student.gpa}
        </div>
    </div>

    <div class="form-group row">
        <a class="btn btn-default" href="<c:url value="/"/>">Main Page</a>
    </div>
</div>



</body>
</html>
