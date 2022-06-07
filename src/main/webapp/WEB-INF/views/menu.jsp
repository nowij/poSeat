<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@ include file="headers.jsp"%>
<body>
    <table id="menuGr" class="easyui-datagrid" style="width: 350px;"
           data-options="
            url:'/menuList.do',
            checkOnSelect:true,
            method:'post',
            fitColumns:true">
        <thead>
            <th data-options="field:'ck',checkbox:true,width:10"></th>
            <th data-options="field:'menuName', width:250">메뉴명</th>
        </thead>
    </table>
</body>
</html>