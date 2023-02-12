<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    table {
      margin: 0 auto;
    }
    th, td {
      padding: 10px;
    }
  </style>
  <script src="jquery.min.js"></script>
  <script type="text/javascript">
$(document).ready(function() {
    $("#submitBtn").click(function() {
        var userId = $("#userId").val();
        var password = $("#password").val();
        if(userId == "" && password == "") {
        	alert("userId and password are required");
        	return false;
        }
        else if (userId == "") {
            alert("userId is required");
            return false;
        }
        else if (password == "") {
            alert("password is required");
            return false;
        }
        $("#form").submit();
    });
});
</script>
<meta charset="UTF-8">
<title>Java Test</title>
</head>
<body>
    <form action="loginServlet" method="post">
	    <table>
		    <tr>
		    	<td colspan="2" style="color: red">${message}</td>
		    </tr>
            <tr>
                <td>User ID</td>
                <td><input type="text" name="userId" id="userId"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" id="password"></td>
            </tr>
            <tr>
                <td></td>
                <td><input id="submitBtn" type="submit" value="Login"></td>
            </tr>
        </table>
    </form>
</body>
</html>