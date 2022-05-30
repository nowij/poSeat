<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pos</title>
</head>
<body>
    <button onclick="goPage();">관리자(${admin})</button>
    <div id="tbleMsg" style="display: none">테이블 수를 설정해주세요.</div>
    <table id="customTable"></table>
    <!--
       자리
    -->
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="application/javascript">
const adminId = '${admin}';
$(document).ready(function() {
   showTable();
});

function showTable() {
    $.ajax({
        url: '/show.do',
        method: 'POST',
        contentType: 'application/text',
        data: {
            'id' : adminId
        },
        success: function (data) {
            console.log(data);
            if (data == 0) {
                $('#tbleMsg').show();
            } else {
                $('#tbleMsg').hide();
            }
        }
    });
}

function goPage() {
 let form = document.createElement('form');
 let object;
 object = document.createElement('input');
 object.setAttribute('type', 'hidden');
 object.setAttribute('name', 'id');
 object.setAttribute('value', adminId);

 form.appendChild(object);
 form.setAttribute('method','post');
 form.setAttribute('action','admin.do');
 document.body.appendChild(form);
 form.submit();
}

</script>
</html>