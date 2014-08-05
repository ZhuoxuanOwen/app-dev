<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="<%=path %>/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="<%=path %>/vendors/easypiechart/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
<link href="<%=path %>/assets/styles.css" rel="stylesheet" media="screen">
<link href="<%=path %>/vendors/datepicker.css" rel="stylesheet" media="screen">

</head>
<body>
	  <jsp:include page="/common/head.jsp" />
	  <div class="row-fluid">
             <!-- block -->
             <div class="block">
                 <div class="navbar navbar-inner block-header">
                     <div class="muted pull-left">添加一个系统用户</div>
                 </div>
                 <div class="block-content collapse in">
                     <div class="span12">
                          <form id="frmUserAdd" class="form-horizontal" enctype="multipart/form-data" method="post">
                           <fieldset>
                             <div class="control-group">
                               <label class="control-label" for="focusedInput">姓名</label>
                               <div class="controls">
                                 <input type="text" class="span3" id="firstName" name="firstName"  placeholder="姓" >
                                 <input type="text" class="span3" id="lastName" name="lastName"  placeholder="名">
                               </div>
                             </div>
                             <div class="control-group">
                               <label class="control-label" for="focusedInput">电子邮件</label>
                               <div class="controls">
                                 <input type="text" class="span6" id="email" name="email"  >
                               </div>
                             </div>
                               <div class="control-group">
                               <label class="control-label" for="focusedInput">登录密码</label>
                               <div class="controls">
                                 <input type="password" class="span6" id="pwd" name="pwd"  >
                               </div>
                             </div>
                             <div class="form-actions">
                               <button id="btnUserAdd" type="button" class="btn btn-primary">保存用户信息</button>
                               <button type="reset" class="btn">取消</button>
                             </div>
                           </fieldset>
                         </form>
                     </div>
                 </div>
             </div>
             <!-- /block -->
        </div>
        <script src="<%=path %>/vendors/jquery-1.9.1.min.js"></script>
        <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=path %>/vendors/easypiechart/jquery.easy-pie-chart.js"></script>
        <script src="<%=path %>/assets/scripts.js"></script>
        <script src="<%=path %>/vendors/bootstrap-datepicker.js"></script>
        <script type="text/javascript">
        
        jQuery(function() {
        	
        	//添加用户
			$("#btnUserAdd").click(function (){
				//do some check
				var firstName = $("#firstName").val();
				var lastName = $("#lastName").val();
				if(firstName == "" || lastName == ""){
					alert("姓名不能为空。");
					return;
				}
				var email = $("#email").val();
				if(email == ""){
					alert("请输入电子邮件。");
					return;
				}
				var pwd = $("#pwd").val();
				if(pwd == ""){
					alert("密码不能为空");
					return;
				}
				
				//send ajax request to save testcase
				alert("要保存了");
				var param = $("#frmUserAdd").serialize();
				$.ajax({
						type : 'post',
						url : '<%=path%>/user/saveWorkFlowUser.do',
						data : param,
						dataType : 'json',
						contentType : "application/x-www-form-urlencoded;charset=UTF-8",
						success : function(data) {
							if (data.success) {
								alert("添加用户信息成功！");
								location.href="<%=path%>/user/userQuery.do?cpage=1";
							} else {
								alert(data.errorMsg);
							}
						},
						error : function(XMLHttpRequest,textStatus, errorThrown) {
							alert(textStatus);
						}
					});
				 });
        	
	    });
        	
        </script>
</body>
</html>