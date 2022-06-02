<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@ include file="headers.jsp"%>
<body>
    <div id="btnLayout">
        <button class="easyui-linkbutton" onclick="goPage();">설정(${sessionScope.admin})</button>
        <button class="easyui-linkbutton" onclick="doLogout();">로그아웃</button>
    </div>
    <div id="tbMsg" style="display: none">테이블 수를 설정해주세요.</div>
    <div id="tbLayout"></div>
    <div id="admLayout" style="display: none">
        <div id="admDlg" class="easyui-dialog" data-options="closed:true" style="width: 400px;"></div>
        <div id="admFooter">
            <button class="easyui-linkbutton" onclick="doChange();" >변경</button>
        </div>
    </div>
</body>
<script type="application/javascript">
    $(document).ready(function() {
        setTitle('POS');
        showTable();
    });

    function showTable() {
        $.ajax({
            url: '/show.do',
            method: 'POST',
            success: function (data) {
                if (data == 0) {
                    $('#tbMsg').show();
                } else {
                    $('#tbMsg').hide();
                    setTableLayout(data);
                }
            }
        });
    }
    function setTableLayout(tableCount) {
        const htmlHead = '<p style="background-color: #95B8E7">';
        const htmlTail = '</p>';

        for (let i = 1; i <= tableCount; i++) {
            $('#tbLayout').append(htmlHead + i + htmlTail);
            $('#tbLayout > p:nth-child(' + i +')').attr('id', 'tb'+i);
            $('#tbLayout > p:nth-child(' + i +')').attr('onclick', 'doInput(' + i +')');
        }
    }

    function doInput(tableNumber) {
        const id = '#tb'+tableNumber;
        $(id).text(''); // 입력시 변경
    }

    function goPage() {
        $.ajax({
            url: '/admin.do',
            method: 'POST',
            success: function (data) {
                $('#admDlg').dialog({
                    title : '관리자 설정',
                    width : 400,
                    height : 200,
                    closed : false,
                    cache : false,
                    href : 'admin.do',
                    modal : true,
                    buttons : '#admFooter'
                });
            }
        });
    }

    function doChange() {
        const cnt = $('#tbCnt').val();
        $.ajax({
            url: '/countSave.do',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                'tbCnt' : cnt
            }),
            success: function (data) {
                $('#admDlg').dialog('close');
                history.go(0);
            }
        });
    }

    function doLogout() {
        $.messager.confirm('로그아웃', '종료하시겠습니까?', function (result) {
            if (result) {
                let form = document.createElement('form');

                form.setAttribute('method','post');
                form.setAttribute('action','/');
                document.body.appendChild(form);
                form.submit();
            }
        })
    }
</script>
</html>