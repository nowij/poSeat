<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@ include file="headers.jsp"%>
<body>
    <table>
        <tbody>
            <tr>
                <td>테이블 수</td>
                <td>
                    <select id="tbleCnt" class="easyui-combobox"style="width: 100px">
                        <option>4</option>
                        <option>8</option>
                        <option>16</option>
                    </select>
                </td>
            </tr>
        </tbody>
    </table>
<button onclick="doChange();" class="easyui-button">변경</button>
</body>
<script type="application/javascript">
const adminId = '${adminId}';

$(document).ready(function() {
    setTitle('ADMIN');
});

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