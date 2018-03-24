<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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

<c:set var="months" value="${listMonths}"/>
<c:if test="${!empty months}">
    <c:set var="employees" value="${listEmployees}"/>
    <c:set var="nDays" value="${months.get(0).days.size()}"/> <%--TODO replace this hardcode--%>
    <c:if test="${!empty employees}">

        <form:form modelAttribute="workingday">
            <table border="1px">

                <tr>
                    <th width="300">
                        <spring:message text="Name"/>
                    </th>
                    <th width="150">
                        <spring:message text="Department"/>
                    </th>
                    <c:forEach var="i" begin="1" end="${nDays}">
                        <th>
                            <spring:message text="${i}"/>
                        </th>
                    </c:forEach>
                </tr>

                <c:forEach items="${employees}" var="employee">
                    <c:if test="${employee.months.size()> 1}"> <%--TODO replace this hardcode--%>
                        <tr>
                            <td>
                                <spring:message text="${employee.name}"/>
                            </td>
                            <td>
                                <spring:message text="${employee.department}"/>
                            </td>
                            <c:forEach var="day" items="${employee.months.get(0).days}" varStatus="idx">
                                <td>
                                    <input size="1" name="employee.months.get(0).days[${idx.index}].minutes"
                                           value="${day.minutes / 60}">
                                </td>

                            </c:forEach>
                        </tr>
                    </c:if>
                </c:forEach>

            </table>
        </form:form>

    </c:if>
</c:if>
</body>
</html>