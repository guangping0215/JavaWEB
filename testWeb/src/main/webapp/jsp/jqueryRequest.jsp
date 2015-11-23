<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JQuery request test</title>

<script type="text/javascript" src="../css/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#button").click(function(){
			$.ajax({
				type : "POST",
				url : "../imageSearchServlet",
				dataType : "json",
				data : {"name": $("#searchText").val()},
				success : function(returnData){
					var resultArr = returnData.responseData.results;
					var str = "<table>" ;
							for(var i=0;i<resultArr.length;i++){
								str +="<tr><img src="+resultArr[i].unescapedUrl+" height='100' width='100'></tr>"
							}
					$("#div1").append(str+"</table>");
				}
			})
		})
	});
</script>
</head>
<body>
	<form>
		search : <input type="text" id="searchText" >
		<input type="button" id="button" value="search">
		<div id="div1" ></div>
	</form>
</body>
</html>