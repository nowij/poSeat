<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@ include file="headers.jsp"%>
<body>
    <table id="dg" style="width: 100px">
        <thead>
            <th colspan="2">Login</th>
        </thead>
        <tbody>
            <tr>
                <td>ID</td>
                <td><input id="lginId" type="text" class="easyui-textbox"/></td>
            </tr>
            <tr>
                <td>PW</td>
                <td><input id="lginPw" type="password" class="easyui-textbox"></td>
            </tr>
            <tr>
                <td colspan="2"><button id="lginBtn" onclick="doLogin()" class="easyui-button">확인</button></td>
            </tr>
        </tbody>
    </table>
</body>
<script type="application/javascript">
    $(document).ready(function() {
        setTitle('LOGIN');
    });

    function doLogin() {
        const id = $('#lginId').val();
        const pw = $('#lginPw').val();
        $.ajax({
            url: '/login.do',
            contentType: 'application/json',
            dataType: 'json',
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