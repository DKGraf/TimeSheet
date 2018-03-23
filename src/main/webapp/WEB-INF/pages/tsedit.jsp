<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Timesheet Editor</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Back to Main Page</a>
<br/>

<br/>
<h1>Timesheet Editor</h1>
<br/>

<c:set var="employees" value="${listEmployees}"/>
<c:set var="month" value="2"/>

<c:if test="${!empty employees}">
    <table>
        <tr>
            <td>Name</td>
            <td>Department</td>
            <c:forEach items="${listEmployees.get(0).months.get(2).days}" var="day">
                <td>day</td>
            </c:forEach>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.name}</td>
                <td>${employee.department}</td>
                <c:choose>
                    <c:when test="${employee.months.size()} > ${month}">
                        <c:forEach items="${employee.months.get(2).days}" var="day">
                            <td>${day.minutes/60}</td>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <td>0.0</td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>
