<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

function validate()
{
	var newPassword = document.getElementById("newPass").value;
	var confPassword = document.getElementById("cnfPass").value;
	
	if (newPassword==null || newPassword=="")
	{ 
	alert("newPassword can't be blank"); 
	return false;  
	} 
	else if(confPassword==null || confPassword=="")
	{
	alert("confPassword can't be blank");
	return false;
	}
	else if (newPassword!=confPassword)
	{ 
	alert("Confirm Password should match with the Password"); 
	return false; 
	} 
}

</script>
</head>
<body>
<center>
<form action="<%=request.getContextPath()%>/resetPassword" method="GET">
	Email:<input type="email" id="email" name="email" value="surajcse33@gmail.com"/><br><br>
	New Password:<input type="password" id="newPass" name="newPass"/><br><br>
	Confirm Password:<input type="password" id="cnfPass" name="cnfPass"/><br><br>
	<input type="submit" value="Submit" onClick="return validate();">
	</form>
</center>
</body>
</html>