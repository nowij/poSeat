<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@ include file="headers.jsp"%>
<body>
    <button onclick="goPage();">관리자(${admin})</button>
    <div id="tbleMsg" style="display: none">테이블 수를 설정해주세요.</div>
    <table id="customTable"></table>
    <!--
       자리
    -->
    <div id="adDlg" class="easyui-dialog" data-options="closed:true" style="width: 400px;"></div>
</body>
<script type="application/javascript">
const adminId = '${admin}';

$(document).ready(function() {
    setTitle('POS');
    showTable();
});

function showTable() {
    $.ajax({
        url: '/show.do',
        method: 'POST',
        data: {
            'id' : adminId
        },
        dataType: 'text',
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
    $.ajax({
        url: '/admin.do',
        method: 'POST',
        data: {
            'id' : adminId
        },
        dataType: 'text',
        success: function (data) {
            $('#adDlg').dialog({
                title : '관리자 설정',
                width : 400,
                height : 200,
                closed : false,
                cache : false,
                href : 'admin.do',
                modal : true
            });
        }
    });

 // let form = document.createElement('form');
 // let object;
 // object = document.createElement('input');
 // object.setAttribute('type', 'hidden');
 // object.setAttribute('name', 'id');
 // object.setAttribute('value', adminId);
 //
 // form.appendChild(object);
 // form.setAttribute('method','post');
 // form.setAttribute('action','admin.do');
 // document.body.appendChild(form);
 // form.submit();
}

</script>
</html>