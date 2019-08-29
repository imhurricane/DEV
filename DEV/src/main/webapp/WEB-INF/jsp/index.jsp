<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <script type="text/javascript" src="../static/js/jquery-3.3.1.min.js"></script>
 <script type="text/javascript" src="../static/js/jquery-form.js"></script>
<title>Welcome</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
} /*去掉页面样式*/
body {
	color: white;
}

.content {
	background-color: #CCFFFF;
	position: absolute; /*绝对定位*/
	width: 100%;
	height: 100%;
	overflow: hidden; /*隐藏滚动条*/
}

.main {
	text-align: center; /*文本居中*/
	max-width: 100%;
	height: 100%;
	padding: 250px 0px; /*上下80px,左右为0*/
	/*background:yellow;*/ /*验证div的位置*/
	margin: 0 auto; /*设置上右下左,居中显示*/
}

.main h1 {
	font-family: "楷体"; /*设置字体*/
	font-size: 70px; /*设置字体大小*/
	font-weight: 2px; /*调整字体粗细*/
}

form {
	padding: 20px 0;
}

form input {
	border: 1px solid white;
	display: block;
	margin: 0px auto 10px auto; /*上 右  下 左*/
	padding: 10px;
	width: 220px;
	border-radius: 30px; /*H5设置圆角边框*/
	font-size: 18px;
	font-weight: 300;
	text-align: center;
}

form input:hover {
	background-color: pink;
}

form button {
	background-color: yellow;
	border-radius: 10px;
	border: 0;
	height: 30px;
	width: 80px;
	padding: 5px 10px;
}

form button:hover {
	background-color: red;
}
</style>
</head>
<body>
	<div class="content">
		<div class="main">
			<h1>Welcome</h1>
			<form method="post" action="" name="loginform" id="loginform">
				<input type="text" name="yhm" id="yhm" placeholder="请输入账号" /> 
				<input type="passWord" name="passWord" id="passWord" placeholder="请输入密码">
				<button onclick="dengLu()" id="denglu">登&nbsp;&nbsp;录</button>
				<button  onclick="save()">注&nbsp;&nbsp;册</button>
			</form>
		</div>
	</div>
</body>
<script>
	document.onkeydown=function(){
		if (event.keyCode == 13) { 
			var btn = document.getElementById("denglu"); 
	        btn.focus(); 
	        btn.click(); 
	    } 
	}
	function dengLu(){
	  var userName = document.getElementById("yhm").value;
	  var passWord = document.getElementById("passWord").value;
	  if((userName==null || userName=="") && (passWord==null || passWord=="")){
	    alert("用户名和密码不能为空！");
	     document.getElementById("yhm").focus();
	     return;
	  }else if(userName==null || userName==""){
	    alert("用户名不能为空！");
		document.getElementById("yhm").focus();
		return;
	  }else if(passWord==null || passWord==""){
	    alert("密码不能为空！");
		document.getElementById("passWord").focus();
		return;
	  }else if(userName != "zhangs"){
		  alert("用户名错误！");
		  document.getElementById("yhm").focus();
		  return;
	  }else if(passWord != "111111"){
		  alert("密码错误！");
			document.getElementById("passWord").focus();
			return;
	  }
	  document.forms['loginform'].action="/userInfo/login";
	  document.forms['loginform'].submit();
	}
	
	
	
	function save(){
		
	}
	
</script>
</html>
