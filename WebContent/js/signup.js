var modal = document.getElementById('id02');
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function validateRegisterForm() {
	var fname = document.getElementById("fname").value;
	var lname = document.getElementById("lname").value;
	var userName = document.getElementById("uname").value;
	var password = document.getElementById("pass").value;
	var cnfPassword = document.getElementById("cnfPass").value;
	var role = document.getElementById("role").value;
	var email = document.getElementById("email").value;
	//alert(userName+"--hello valitate here--"+password);
	
	if (fname==null || fname=="")
	{ 
		alert("fname can't be blank"); 
		return false;  
	} 
	else if (lname==null || lname=="")
	{ 
		alert("lname can't be blank"); 
		return false;  
	} 
	else if (userName==null || userName=="")
	{ 
		alert("userName can't be blank"); 
		return false;  
	} 
	else if(password==null || password=="")
	{
		alert("password can't be blank");
		return false;
	}
	else if(cnfPassword==null || cnfPassword=="")
	{
		alert("cnfPassword can't be blank");
		return false;
	}
	else if(password!=cnfPassword)
	{
		alert("Confirm Password should match with the Password");
		return false;
	}
	else if(role==null || role=="")
	{
		alert("role can't be blank");
		return false;
	}
	else if(email==null || email=="")
	{
		alert("email can't be blank");
		return false;
	}
	else 
	{
		$.ajax({
            type: "GET",
            url:"register",
            data:{"fname":fname,"lname":lname,"userName":userName,"password":password,"role":role,"email":email},
            success: function (data) {
            	alert("data-->"+data);
               if(data=='True'){
             	  var successUrl = "/OnlineVotingSystem/jsp/admin.jsp"; 
             	  window.location.href = successUrl;
               }else{
                   alert('Something went wrong..!');
               }
            }
     });
	}
}