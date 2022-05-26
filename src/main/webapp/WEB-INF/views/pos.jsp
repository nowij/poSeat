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
    <table id="customTable"></table>
    <!--
       자리
    -->
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="application/javascript">
$(document).ready(function() {
    // DB에서 테이블 수 조회
});

function setTable() {

}

function goPage() {
 let form = document.createElement('form');
 form.setAttribute('method','post');
 form.setAttribute('action','admin.do');
 document.body.appendChild(form);
 form.submit();
}

</script>
</html>