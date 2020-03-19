<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<body>
<form action="sssServlet" method="post">
    <table  border="0" align="center">
        <tr>
            <td>原来这是用户名啊：</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td height="19">原来这是密码啊：</td>
            <td>这是用户名：</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td height="19">这是密码：</td>
            <td height="19"><input type="password" name="pwd"></td>
        </tr>
        <tr >
            <td colspan="2" align="center" >
                <input type="submit" name="Submit" value="登录">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
