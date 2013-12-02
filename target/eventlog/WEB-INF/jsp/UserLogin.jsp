<%@ page language="java" contentType="text/html; charset=GB18030"
        pageEncoding="GB18030"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>UserLogin</title>
</head>

<body>
        <form:form modelAttribute="user">
                <table>
                        <tr>
                                <td style="color: red;"><form:errors path="*" element="div" /></td>
                        </tr>
                </table>
                <table>
                        <tr>
                                <td align="right">User Name:</td>
                                <td><form:input path="userName" type="text" size="30"
                                                maxlength="30" /></td>

                        </tr>
                        <tr style="width: 342px;">
                                <td align="right">Password</td>
                                <td><form:input path="password" type="text" size="30"
                                                maxlength="30" /></td>
                        </tr>
                        
                        <tr>
			              <td></td>
			              <td><input type="submit" value="Login" /></td>
		               </tr>
                </table>
        </form:form>
</body>
</html>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>