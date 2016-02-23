$(document).ready(function(){
	$("#logout").click(function(){
		$.ajax({
			url:"/logout",
			method:"post",
			success:function(result){
				if(result){
					window.location.href="index.html";
				}
				else{
					window.location.href="home.html";
				}
			},error:function(){
				alert("Error occured")
  			}	
		});
	});
});
