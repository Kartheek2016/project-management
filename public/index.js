var atPos = 0;
var dotPos = 0;

$(document).ready(function() {

	$("#signInForm").submit(function(e) {

		var emailId = $("#userId").val();
		var password = $("#password").val();
		var passwordLength = $("#password").length;

		atPos = emailId.indexOf("@");
		var afterAt = emailId.split("@");
		dotPos = afterAt[1].lastIndexOf(".");
		dotPos = (++dotPos) + atPos;
		if (atPos === 0 || dotPos === ++atPos || dotPos < atPos) {
			alert("Please, Enter a valid email ID (abcdef@xyz.com)");
		}

		if (passwordLength <= 5 && passwordLength >= 15) {
			alert("Please enter the password (Min 5 & max 15 Charaters)");
		}

		$.ajax({
			url: "/SignIn", 
			data: {
				userId: emailId,
				Password: password        
			},
			method: "post",
			success: function(curUser) {
				if(curUser === 0){
					alert("Invalid User ID or Password!!");
				}
				else{
					window.location.href = "home.html";
				}
			}, error:function() {
				alert("Error!!!")
			}
		});

		e.preventDefault();

	});

	var password = $("#SignUpPswd").val();
	var confirmPassword = $("#confirmPassword").val();
	$("#confirmPassword").keydown(function(){
		var compare = password.localeCompare(confirmPassword);
		if (compare === 0){
			$("span").addClass("glyphicons glyphicons-ok form-control-feedback");
		}
	});

	$("#signUpForm").submit(function(e) {

		var fullName = $("#fullName").val();
		var emailId = $("#emailId").val();
		password = $("#SignUpPswd").val();

		atPos = emailId.indexOf("@");
		var afterAt = emailId.split("@");
		dotPos = afterAt[1].lastIndexOf(".");
		dotPos = (++dotPos) + atPos;
		if (atPos === 0 || dotPos === ++atPos || dotPos < atPos) {
			alert("Please, Enter a valid email ID (abcdef@xyz.com)");
		}
		
		$.ajax({
			url: "/SignUp", 
			data: {
				fName: fullName,
				email: emailId,
				pswd: password        
			},
			method: "post",
			success: function(CurrentUser) {
				if(CurrentUser === 0){
					alert("Invalid Details");
				}
				else{
					window.location.href = "home.html";
				}
			}, error:function() {
				alert("Error!!!")
			}
		});

		e.preventDefault();

	});

});
