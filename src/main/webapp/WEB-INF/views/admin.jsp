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
                <td>테이블 수</td>
                <td>
                    <select id="tbleCnt">
                        <option>4</option>
                        <option>8</option>
                        <option>16</option>
                    </select>
                </td>
            </tr>
        </tbody>
    </table>
<button onclick="doChange();">변경</button>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="application/javascript">
const adminId = '${adminId}';
function doChange() {
    const cnt = $('#tbleCnt').val();
    $.ajax({
        url: '/tableSave.do',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            'id' : adminId,
            'tbCnt' : cnt
        }),
        success: function (data) {

        }
    });
}
</script>
</html>