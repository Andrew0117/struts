<%-- 
    Document   : user
    Created on : 2019-02-12, 17:00:05
    Author     : Andrey <Andrey at andrew.my@yahoo.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
        <script src="../js/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="../js/jquery-ui.custom.js" type="text/javascript"></script>
        <link href="../js/jquery-ui.css" type="text/css" rel="stylesheet" />
        <script src="js/datetimepicker/jquery.datetimepicker.full.js" type="text/javascript"></script>
        <link href="js/datetimepicker/jquery.datetimepicker.css" type="text/css" rel="stylesheet"/>
        <script src="js/script.js" type="text/javascript"></script>
    </head>
    <body>
        <a href="/userTableAction.do" >Users Table</a>
        <html:form action="/userAction">
            <table>
                <tr>
                    <td>name : </td>
                    <td><html:text property="user.name" /></td>
                    <td><html:errors property="name" /></td>
                </tr>
                <tr>
                    <td>surName : </td>
                    <td><html:text property="user.surName" /></td>
                    <td><html:errors property="surName" /></td>
                </tr>
                <tr>
                    <td>email : </td>
                    <td><html:text property="user.email" /></td>
                    <td><html:errors property="email" /></td>
                </tr>
                <tr>
                    <td>birthday : </td>
                    <td><html:text styleId="birthday" property="user.birthdayString"/></td>
                    <td><html:errors property="birthday" /></td>
                </tr>
                <tr>
                    <td>Gender : </td>
                    <td>
                        <html:select property="user.genderId">
                            <html:optionsCollection property="gendersList" value="id" label="gender"/>
                        </html:select>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <html:submit />
                    </td>
                </tr>
            </table>
        </html:form>
    </body>
</html>
