var modal = document.getElementById('id01');
//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	if (event.target == modal) {
	   modal.style.display = "none";
	}
};

function validateLogin() {
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	//alert(userName+"--hello valitate here--"+password);
	
	if (userName==null || userName=="")
	{ 
		alert("userName can't be blank"); 
		return false;  
	} 
	else if(password==null || password=="")
	{
		alert("password can't be blank");
		return false;
	}
	else 
	{
		alert('else block');
		$.ajax({
            type: "GET",
            url:"login",
            data:{"userName":userName,"password":password},
            success: function (data) {
               if(data=='True'){
            	   alert('called signin.js');
             	  var successUrl = "/OnlineVotingSystem/jsp/admin.jsp"; 
             	  window.location.href = successUrl;
               }else{
                   alert('Something went wrong..!');
               }
            }
     });
	}
}