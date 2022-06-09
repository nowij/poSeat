<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@ include file="headers.jsp"%>
<body>
    <div id="posLayout">
        <div id="btnLayout">
            <button class="easyui-linkbutton" onclick="openAdminDlg();">설정(${sessionScope.admin})</button>
            <button class="easyui-linkbutton" onclick="doLogout();">로그아웃</button>
        </div>
        <div id="tbMsg" style="display: none">테이블 수를 설정해주세요.</div>
        <div id="tbLayout" style="display: none"></div>
    </div>
    <div id="admLayout" style="display: none">
        <div id="admDlg" class="easyui-dialog" data-options="closed:true" style="width: 400px;"></div>
        <div id="admFooter">
            <button class="easyui-linkbutton" onclick="doChange();" >변경</button>
        </div>
    </div>
    <div id="menuLayout" style="display: none">
        <div id="menuDlg" class="easyui-dialog" data-options="closed:true" style="width: 400px"></div>
        <div id="menuFooter">
            <button class="easyui-linkbutton" onclick="doOrder()">주문</button>
            <button class="easyui-linkbutton" onclick="doPay()">결제</button>
            <button class="easyui-linkbutton" onclick="closeDlg('menuDlg')">닫기</button>
        </div>
    </div>
</body>
<script type="application/javascript">
    let orderTable = '';

    $(document).ready(function() {
        setTitle('POS');
        setTable();
    });

    function setTable() {
        $.ajax({
            url: '/show/table.do',
            method: 'POST',
            success: function (data) {
                if (data == 0) {
                    $('#tbMsg').show();
                    $('#tbLayout').hide();
                } else {
                    $('#tbLayout').show();
                    $('#tbMsg').hide();
                    setTableLayout(data);
                }
            }
        });
    }
    function setTableLayout(tableCount) {
        const htmlHead = '<div style="background-color: #95B8E7;">';
        const htmlTail = '</div>';

        for (let i = 1; i <= tableCount; i++) {
            $('#tbLayout').append(htmlHead + i + htmlTail);
            $('#tbLayout > div:nth-child(' + i +')').attr('id', 'tb'+i);
            $('#tbLayout > div:nth-child(' + i +')').attr('onclick', 'openMenuDlg(' + i +')');
        }
    }

    function openMenuDlg(tableNumber) {
        orderTable = '#tb'+tableNumber;

        $('#menuDlg').dialog({
            title: '메뉴 선택',
            href: '/menu.do',
            width: 400,
            height: 200,
            closed: false,
            cache: false,
            modal: true,
            buttons: '#menuFooter'
        });
    }

    // kafka 보냄 : 테이블번호랑 oper (json)
    function doOrder() {
        const selectMenu = $('#menuGr').datagrid('getChecked');
        let menuList = '';
        for (const m of selectMenu) {
            menuList = menuList + m.menuName + ' ';
        }
        toKafka('C');
        $(orderTable).text(menuList);
        closeDlg('menuDlg');
    }

    // kafka 보냄 : 테이블 번호랑 oper (json)
    function doPay() {
        toKafka('D');
    }

    function toKafka(operation) {
        $.ajax({
            url: 'kafka.do',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                'id' : '${admin}',
                'oper' : operation,
                'num' : orderTable.substr(3)
            }),
            error: function (data) {
                console.log(data);
            }
        });
    }

    function openAdminDlg() {
        $('#admDlg').dialog({
            title: '관리자 설정',
            href: '/admin.do',
            width: 400,
            height: 200,
            closed: false,
            cache: false,
            modal: true,
            method: 'post',
            buttons: '#admFooter'
        });
    }

    function doChange() {
        const cnt = $('#tbCnt').val();
        $.ajax({
            url: '/seatSave.do',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                'id' : '${admin}',
                'tbCnt' : cnt
            }),
            success: function (data) {
                closeDlg('admDlg');
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