<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Employees List</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Back to Main Page</a>
<br/>
<br/>
<h1>Employees List</h1>
<c:if test="${!empty listEmployees}">
    <table>
        <tr>
            <th width="80">ID</th>
            <th width="400">Name</th>
            <th width="80">Personal Number</th>
            <th width="200">Department</th>
            <th width="100">Sex</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>

        <c:forEach items="${listEmployees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.personalNumber}</td>
                <td>${employee.department}</td>
                <td>${employee.sex}</td>
                <td><a href="<c:url value="/edit/${employee.id}"/>">Edit</a></td>
                <td><a href="<c:url value="/remove/${employee.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>

    </table>
</c:if>
<br/>
<br/>

<h2>Add Employee</h2>

<c:url var="addAction" value="/admin/add"/>
<form:form action="${addAction}" modelAttribute="employee">
    <table>
        <c:if test="${!empty employee.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="personalNumber">
                    <spring:message text="Personal Number"/>
                </form:label>
            </td>
            <td>
                <form:input path="personalNumber"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="department">
                    <spring:message text="Department"/>
                </form:label>
            </td>
            <td>
                <form:input path="department"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="sex">
                    <spring:message text="Sex"/>
                </form:label>
            </td>
            <td>
                <form:input path="sex"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty employee.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Employee"/>"/>
                </c:if>
                <c:if test="${empty employee.name}">
                    <input type="submit"
                           value="<spring:message text="Add Employee"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
