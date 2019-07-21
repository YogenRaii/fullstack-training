<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <form:form action="/students" method="post" modelAttribute="student">
        <c:choose>
            <c:when test="${student.id > 0}">
                <div class="form-group row">
                    <label for="id" class="col-sm-2 col-form-label">ID</label>
                    <div class="col-sm-10">
                        <form:input type="text" readonly="true" class="form-control" id="id" path="id"></form:input>
                    </div>
                </div>
            </c:when>
        </c:choose>

        <div class="form-group row">
            <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" id="firstName" path="firstName"></form:input>
            </div>
        </div>
        <div class="form-group row">
            <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" id="lastName" path="lastName"></form:input>
            </div>
        </div>
        <div class="form-group row">
            <label for="gpa" class="col-sm-2 col-form-label">GPA</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" id="gpa" path="gpa"></form:input>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-6">
                <button type="submit" class="btn btn-primary pull-right">Submit</button>
            </div>
            <div class="col-sm-6">
                <a class="btn btn-danger" href="<c:url value="/"/>">Cancel</a>
            </div>
        </div>
    </form:form>
</div>

<jsp:include page="footer.jsp"></jsp:include>