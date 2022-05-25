<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>admin</title>
</head>
<style>
    table {
        border: 1px solid #444444;
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid #444444;
    }
</style>
<body>
    <table>
        <thead>
            <th colspan="2">설정</th>
        </thead>
        <tbody>
            <tr>
                <td>좌석 수</td>
                <td><input id="seatCount" type="text" readonly/></td>
            </tr>
        </tbody>
    </table>
<button onclick="doChange();">변경</button>
</body>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="application/javascript">
function doChange() {

}
</script>
</html>