<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<body id="login">
    <div class="container">

      <form id="frmUserLogin" class="form-signin">
        <h2 class="form-signin-heading">请登录系统</h2>
        <input type="text" class="input-block-level" id="email"   name="email"  placeholder="电子邮件">
        <input type="password" class="input-block-level"  id="pwd" name="pwd" placeholder="密码">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> 记住我
        </label>
        <button class="btn btn-large btn-primary" id="btnUserLogin" type="button">登录</button>
      </form>

    </div> <!-- /container -->
    <script src="vendors/jquery-1.9.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    jQuery(function() {
    	
    	//添加用户
		$("#btnUserLogin").click(function (){
			//do some check
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
			var param = $("#frmUserLogin").serialize();
			$.ajax({
					type : 'post',
					url : '<%=path%>/login/userLogin.do',
					data : param,
					dataType : 'json',
					contentType : "application/x-www-form-urlencoded;charset=UTF-8",
					success : function(data) {
						if (data.success) {
							alert("恭喜你，登录系统成功！");
							location.href="<%=path%>/index.jsp";
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
    </script>
  </body>
</html>