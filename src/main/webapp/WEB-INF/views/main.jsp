<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@ include file="headers.jsp"%>
<body>
    <table id="lgnTb" style="width: 100px">
        <thead>
            <th colspan="2">Login</th>
        </thead>
        <tbody>
            <tr>
                <td>ID</td>
                <td><input class="easyui-textbox" id="lgnId" type="text"/></td>
            </tr>
            <tr>
                <td>PW</td>
                <td><input class="easyui-textbox" id="lgnPw" type="password"></td>
            </tr>
            <tr>
                <td colspan="2"><button class="easyui-linkbutton" id="lgnBtn" onclick="doLogin()">확인</button></td>
            </tr>
        </tbody>
    </table>
</body>
<script type="application/javascript">
    $(document).ready(function() {
        setTitle('LOGIN');
    });

    function doLogin() {
        const id = $('#lgnId').val();
        const pw = $('#lgnPw').val();
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
        const id = $('#lgnId').val();
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