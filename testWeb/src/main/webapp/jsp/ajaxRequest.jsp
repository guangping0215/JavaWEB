<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message</title>

<script type="text/javascript">
	var xmlHttpRequest = null;

	function ajaxRequest(obj){
		alert("IE");
		if(window.ActiveXObject){
			alert("IE");
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}else if(window.XMLHttpRequest){
			alert("not IE");
			xmlHttpRequest = new XMLHttpRequest();
		}
		if(null != xmlHttpRequest){
			xmlHttpRequest.open("POST","../firstServlet",true);
			xmlHttpRequest.onreadystatechange = ajaxcallback; 
			xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xmlHttpRequest.send("username="+document.getElementById("username").value+"&message="+document.getElementById("message").value);
		}
		
	}
	
	function ajaxcallback(){
		if(xmlHttpRequest.readyState == 4){
			if(xmlHttpRequest.status == 200){
				var responseTxt = xmlHttpRequest.responseText;
				document.getElementById("showname").innerHTML = responseTxt;
			}
		}
	}
	
</script>
</head>
<body>
	<form>
		userName : <input type="text" name="username" id="username"><br>
		Message : <textarea name="message" id="message"></textarea>
		<input type="button" value="sub" onclick="ajaxRequest();"/>
	</form>
	
	<div id="showname"></div>
</body>
</html>