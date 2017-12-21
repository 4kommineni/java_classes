

$('#login').click(function() {
	var data={
			"emailid" : $("#emailid").val(),
			"pswd" : $('#pswd').val()
		};
	
	$.post("loginSubmit1", data , function(data1) {
		if (data1 === 'success') {
			window.location.href = "home";
		} else {
			$('#loginError').html('Invalid Credentials');
			window.location.href = "login";
		}
	});
});




$('#path').click(function(){
	$.get("getDetails/1/harsha", function(data){
		alert(data);
	});
});