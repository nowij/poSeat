<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
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
            <th colspan="2">Login</th>
        </thead>
        <tbody>
            <tr>
                <td>ID</td>
                <td><input id="lginId" type="text"/></td>
            </tr>
            <tr>
                <td>PW</td>
                <td><input id="lginPw" type="password"></td>
            </tr>
            <tr>
                <td colspan="2"><button id="lginBtn" onclick="doLogin()">확인</button></td>
            </tr>
        </tbody>
    </table>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="application/javascript">
    function doLogin() {
        var id = $('#lginId').val();
        var pw = $('#lginPw').val();
        $.ajax({
            url: '/login.do',
            contentType: 'application/json',
            data: JSON.stringify({
                'id' : id,
                'pw' : pw
            }),
            method: 'POST',
            success: function (data) {
                if (data == 1){
                    goPage();
                } else {
                    alert('아이디나 비밀번호가 틀렸습니다.');
                }
            }
        });
    }

    function goPage() {
        const id = $('#lginId').val();
        let form = document.createElement('form');
        let object;
        object = document.createElement('input');
        object.setAttribute('type', 'hidden');
        object.setAttribute('name', 'id');
        object.setAttribute('value', id);

        form.appendChild(object);
        form.setAttribute('method','post');
        form.setAttribute('action','pos.do');
        document.body.appendChild(form);
        form.submit();
    }
</script>
</html>