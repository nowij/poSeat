<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@ include file="headers.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<c:forEach items="${restList}" var="restaurant">
    <div id="webLayout">
        <table id ="webGr">
            <thead>
                <th colspan="2">${restaurant.name}</th>
            </thead>
            <tbody>
                <tr>
                    <c:choose>
                        <c:when test="${restaurant.tbCnt eq null}">
                            <td colspan="2">서비스 미지원</td>
                        </c:when>

                        <c:otherwise>
                            <td>테이블</td>
                            <td>/${restaurant.tbCnt}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </tbody>
        </table>
    </div>
</c:forEach>
</body>
<script type="application/javascript">
    $(document).ready(function() {
        setTitle('WEB');
    });
</script>
</html>