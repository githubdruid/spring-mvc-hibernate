<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BORAJI.COM</title>
    <style type="text/css">
        fieldset {
            border: 1px solid #dedede;
        }

        legend {
            font-size: 20px;
            text-transform: uppercase;
        }

        .error {
            color: red;
        }
        .resltTable td, .resltTable th {
            border: 1px solid #565454;
        }
    </style>
</head>
<body>
<fieldset>
    <legend>User Input From</legend>
    <form:form action="editUser" method="post" modelAttribute="user">
        <form:hidden path="id" />
        <table>
            <tr>
                <th>Name</th>
                <td>
                    <form:input path="name" />
                    <form:errors path="name" cssClass="error" />
                </td>
                <th>Email</th>
                <td>
                    <form:input path="email" />
                    <form:errors path="email" cssClass="error" />
                </td>
                <td><button type="submit">Submit</button></td>
            </tr>
        </table>
    </form:form>
</fieldset>
</body>
</html>