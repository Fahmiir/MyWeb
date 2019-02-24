<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/MyStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>
<div id="box">
      <table>
      <tr>
      <th id="signup" onclick="functionsignup()"><h1>Sign Up</h1></th>
      <th id="login" onclick="functionlogin()"><h1>Log In</h1></th>
      </tr>
      </table>
      
      <div id="one">
      <form id="form-id">
      <input type="text" name="username" id="username" placeholder="username">
      <br>
      <input type="text" name="email" id="email" placeholder="email">
      <br>
      <div class="inner-addon">
      <i onclick="password(this)" class="fa fa-eye">
      <span class="tooltiptext" id="tooltipOne">Show Password</span>
      </i>
      <input type="password" name="password" id="password" placeholder="password">
      </div>
      <div class="inner-addon">
      <i onclick="retypepassword(this)" class="fa fa-eye">
      <span class="tooltiptext" id="tooltipTwo">Show Password</span>
      </i>
      <input type="password" name="retypepassword" id=retypepassword placeholder="retype-password">
      </div>
      <input type="submit" value="daftar" id="daftar" onClick="myFunction()">
      </form>
      </div>
      
      <div id="two">
      <form action="Login" method="post">
      <input type="text" name="name" id="name" placeholder="username" >
      <br>
      <div class="inner-addon">
      <i onclick="userpassword(this)" class="fa fa-eye">
      <span class="tooltiptext" id="tooltipThree">Show Password</span>
      </i>
      <input type="password" name="userpassword" id="userpassword" placeholder="password">
      </div>
      <input type="submit" value="login" id="login">
      </form>
      </div>
</div>

<script>

function functionlogin() {
document.getElementById("two").style.display="block";
document.getElementById("one").style.display="none";
document.getElementById("login").style.backgroundColor="white";
document.getElementById("signup").style.backgroundColor="grey";
}

function functionsignup() {
document.getElementById("two").style.display="none";
document.getElementById("one").style.display="block";	
document.getElementById("login").style.backgroundColor="grey";
document.getElementById("signup").style.backgroundColor="white";
}

function password(y){
    y.classList.toggle("fa-eye-slash");
    var x = document.getElementById("password"); 
    if(x.type==="password"){
	    x.type = "text";
	    document.getElementById("tooltipOne").innerHTML="Hide Password";
    } else {
	    x.type= "password";
	    document.getElementById("tooltipOne").innerHTML="Show Password";
    }
  }

function retypepassword(y){
	y.classList.toggle("fa-eye-slash");
	var x = document.getElementById("retypepassword"); 
	if(x.type==="password"){
		x.type = "text";
		document.getElementById("tooltipTwo").innerHTML="Hide Password";
	} else {
		x.type= "password";
		document.getElementById("tooltipTwo").innerHTML="Show Password";
	}
  }	
	
function userpassword(y){
	y.classList.toggle("fa-eye-slash");
	var x = document.getElementById("userpassword"); 
	if(x.type==="password"){
		x.type = "text";
		document.getElementById("tooltipThree").innerHTML="Hide Password";
	} else {
		x.type= "password";
		document.getElementById("tooltipThree").innerHTML="Show Password";
	} 	
  }
  
function myFunction(){
	$.ajax({
		url:'Servlet',
	    data:{
	    	 username : $('#username').val(),
	         email : $('#email').val(),
	         password : $('#password').val()
	         },
	    type:'post',
	    cache:false,
	    /* success:function(){
	    	alert('sucsess');
	    },
	    error:function(){
	    	alert('error');
	    } */     
	});
}  
  
</script>

</body>
</html>