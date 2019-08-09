<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
 <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" /> 
 <script type="text/javascript" src="../static/js/jquery-3.3.1.min.js"></script>
 <script type="text/javascript" src="../static/js/jquery-form.js"></script>
     <title>我的首页</title>
     <style type="text/css">
         *{
             margin:0px; 
             padding:0px; /*设置距顶点的距离设置为0*/
         }
         .header{
             background-color:#E8E8E8;
             height:50px;
             width:100%;
             font-size:40px;
             font-family:"楷体";
             
         }
         ad{
             height:740px;
             width:100%;
             margin:0 0 0 auto;
             //background-image: url(../static/picture/bg.jpg);
         }
         .ad1{
             width:10%;
             height:760px;
             margin:0 auto auto auto;
             background-color:#F0FFF0;
             float:left;
             font-size:60px;
         }
         .main1{
             margin:0 auto 0 auto;
             background-color:#FFFFE0;
             width:80%;
             height:760px;
             float:left;
         }
         .ad2{
             width:10%;
             height:760px;
             margin:0 auto;
             background-color:#F0FFF0;
             float:right;
             font-size:26px;
             line-height: 24px;  
             writing-mode: vertical-lr;/*从左向右 从右向左是 writing-mode: vertical-rl;*/  
    		 writing-mode: tb-lr;/*IE浏览器的从左向右 从右向左是 writing-mode: tb-rl；*/  
             
         }
        .foot{
             background-color:#E8E8E8;
             width:100%;
             height:85px;
             margin:760 auto 0 auto;
             text-align:center;
             font-size:18px;
          }
          .inp{
          	border-bottom: black 1px solid;
			border-top-style: none;
			border-right-style: none;
			border-left-style: none;
			background-color: #FFFFFF;
			margin-left:20px;
			width:900px;
			font-size:24px;
          }
     </style>
 </head>
 
<script>
	
	function start() {
        $('#loginform').ajaxSubmit( {
            url : "/main/action",
            success: function(data) {
                if(data==1){
                    alert("启动成功");
                }else if(data==2){
                    alert("任务正在进行中...");
                }else{
                	alert("启动失败");
                }
            },
        });
        return false;
	}
	
	function save() { 
		$('#loginform').ajaxSubmit( {
            url : "/main/save",
            success: function(data) {
                if(data==1){
                    alert("保存成功");
                }else{
                    alert("保存失败");
                }
            },
        });
        return false;
	}
	//停止
	function stop() {
		document.forms['loginform'].action="/main/action?type=stop";
		document.forms['loginform'].submit();
        return false; //解决IE兼容性问题，不加这句的话，IE下表单会被提交两次。
	};

</script>
 
 <body>    
     <div>
         <div class="header">
         	<span style="padding-left:20px;">Welcome to Applications</span>
         </div>
         <div class="ad">
             <div class="ad1">
                 
             </div>        
             <div class="main1">
             
	             <p style="padding-top:20px;padding-left:20px;font-size:34px;">
	             	<span >配置信息：</span>
	             </p>
             	
             	<form action="" method="post" name="loginform" id="loginform">
                 	<table style="font-size:30px;border-collapse:separate; border-spacing:40px 30px;margin-top:70px;">
	                 	<tr>
	                 		<td align="right" colspan="2">网址：<input class="inp" name="url" value=${ url}></input></td>
	                 	</tr>
	                 	<tr>
	                 		<td align="right" colspan="2">起始页：<input class="inp" name="startPage" value=${ startPage}></input></td>
	                 	</tr>
	                 	<tr>
	                 		<td align="right" colspan="2">结束页：<input class="inp" name="endPage" value=${ endPage}></input></td>
	                 	</tr>
	                 	<tr>
	                 		<td align="right" colspan="2">文件位置：<input class="inp" name="mirk" value=${ mirk}></input></td>
	                 	</tr>
	                 	<tr>
	                 		<td align="right" colspan="2">备注：<input class="inp" name="remark" value=${ remark}></input></td>
	                 	</tr>
	                 	<tr>
	                 		<td align="right"><input value="保存" type="button" onclick="save()" style="height: 50px;width: 80px;"></input></td>
	                 		<td align="left"><input value="开始" type="button" onclick="start()"  style="height: 50px;width: 80px;"></input></td>
	                 	</tr> 
                	 </table>
                 </form>
             </div>
             <div class="ad2">    
                 	
             </div>
         </div>    
         <div class="foot">
             	<p style="padding-top: 15px;">版权所有 © 2019-2020 hurricane</p>
			<p>建议浏览器版本为IE8及以上版本</p>
         </div> 
     </div>
    <%--  <%@ include file="nav.jsp" %> --%>
 </body>
