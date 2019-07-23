<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col col-md-6">
            <form class="form-inline" action="info">
                <input type="text" name="studentId" class="form-control mb-2 mr-sm-2 mb-sm-0" id="inlineFormInput" placeholder="Enter Student ID">
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
        <div class="col col-md-2">
            <a class="btn btn-primary pull-right" href="<c:url value="/students/add"/>">Add</a>
        </div>
    </div>

    <h2>All Students</h2>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>GPA</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.firstName} ${student.lastName}</td>
                <td>${student.gpa}</td>
                <td>
                    <a class="btn btn-primary" href="<c:url value="/students/${student.id}/edit"/>">Edit</a>
                    <a class="btn btn-danger" href="<c:url value="/students/${student.id}/delete"/>">Delete</a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="../footer.jsp"/>