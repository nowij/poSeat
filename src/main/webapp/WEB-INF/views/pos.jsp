<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pos</title>
</head>
<body>
    <button onclick="goPage();">관리자</button>
    <!--
       자리
    -->
</body>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="application/javascript">

function goPage() {
 let form = document.createElement('form');
 form.setAttribute('method','post');
 form.setAttribute('action','admin.do');
 document.body.appendChild(form);
 form.submit();
}

</script>
</html>