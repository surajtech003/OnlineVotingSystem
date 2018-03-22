$(document).ready(function() {
	$(function() {
		$('span.login').click(function(e) {
			var hiddenSection = $('section.hidden');
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
			$('#login').click(function() {
				alert("hjiiiii");
				var userName = $('#userName').val();
				var password = $('#password').val();
				alert(userName+" "+password);
				if(userName!='' && password!='') {
					$.ajax({
			               type: "GET",
			               url:"login",
			               data:{"userName":userName,"password":password},
			               success: function (data) {
			            	   alert(data+":::inside popup.js");
			                  if(data=='True'){
			                    //$(location).attr('href','main.jsp');
			                	  //alert("pasjdsfj");
			                	  var successUrl = "/OnlineVotingSystem/jsp/admin.jsp"; 
				            	  window.location.href = successUrl;
			                  }else{
			                      alert('Please correct username or password..!');
			                  }
			               }
			        });
				}
				else {
					alert("fail");
				}
			});
			$('#forgetPassword').click(function() {
				alert("forgetPassword");
				var successUrl = "/OnlineVotingSystem/jsp/forgetPassword.jsp"; 
          	  window.location.href = successUrl;
			});
		});
	});
});