$(document).ready(function() {
	$(function() {
		$('span.signup').click(function(e) {
			var hiddenSection = $('section.hidden_signup');
			hiddenSection.fadeIn()
			// unhide section.hidden
			.css({
				'display' : 'block'
			})
			// set to full screen
			.css({
				width : $(window).width() + 'px',
				height : $(window).height() + 'px'
			}).css({
				top : ($(window).height() - hiddenSection.height()) / 2 + 'px',
				left : ($(window).width() - hiddenSection.width()) / 2 + 'px'
			})
			// greyed out background
			.css({
				'background-color' : 'rgba(0,0,0,0.5)'
			}).appendTo('body');
			// console.log($(window).width() + ' - ' + $(window).height());
			$('span.close').click(function() {
				$(hiddenSection).fadeOut();
			});
			$('#submit').click(function() {
				//alert("hjiiiii");
				var userName = $('#uname').val();
				var password = $('#pwd').val();
				var role = $('#role').val();
				var boolean = validate();
				//alert(userName+" "+password+" "+confirmPassword+" "+role);
				alert(boolean);
				if(userName!='' && password!='') {
					$.ajax({
			               type: "GET",
			               url:"register",
			               data:{"userName":userName,"password":password,"role":role},
			               success: function (data) {
			            	   alert(data+":::inside signupPop.js");
			                  if(data=='True'){
			                	  alert("pasjdsfj");
			                	  var successUrl = "/OnlineVotingSystem/jsp/admin.jsp"; 
				            	  window.location.href = successUrl;
			                  }else{
			                      alert('Something went wrong..!');
			                  }
			               }
			        });
				}
				else {
					alert("fail");
				}
			});
		});
	});
});
function validate()
{ 
	var userName = $('#uname').val();
	var password = $('#pwd').val();
	var confirmPassword = $('#cpwd').val();
	var role = $('#role').val();
	
if (userName==null || userName=="")
{ 
alert("Username can't be blank"); 
return false;  
} 
else if(password==null || password=="")
{
alert("password can't be blank");
return false;
}
else if(confirmPassword==null || confirmPassword=="")
{
alert("confirmPassword can't be blank");
return false;
}
else if (password!=confirmPassword)
{ 
alert("Confirm Password should match with the Password"); 
return false; 
} 
else if(role==null || role=="")
{
alert("role can't be blank");
return false;
}
else
{
return true;	
}
} 