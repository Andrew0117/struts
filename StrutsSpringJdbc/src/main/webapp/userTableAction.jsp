<%-- 
    Document   : userTableAction
    Created on : 2019-02-12, 17:00:15
    Author     : Andrey <Andrey at andrew.my@yahoo.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users Table</title>
    </head>
    <body>
        <a href="/userAction.do" >Add User</a><br/>
        <display:table id="data" name="sessionScope.UserTableForm.listUser" requestURI="/userTableAction.do" pagesize="10" >
            <display:column title="Delete">
                <a href="/userTableAction.do?a=<c:out value="${data.id}"/>" >delete</a>
            </display:column>
            <display:column property="name" title="name" sortable="true"   />
            <display:column property="surName" title="surName" sortable="true"  />
            <display:column property="email" title="email" sortable="true"  />
            <display:column property="age" title="age" sortable="true"  />
            <display:column property="gender.gender" title="gender" sortable="true"  />
        </display:table>
    </body>
</html>
