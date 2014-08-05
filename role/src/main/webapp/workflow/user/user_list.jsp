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
</head>
<body>
      <jsp:include page="/common/head.jsp" />
	  <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">用户列表</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                   <div class="table-toolbar">
                                      <div class="btn-group" style="padding-bottom: 20px;">
                                         <a href="<%=path %>/workflow/user/workflow_user_add.jsp"><button class="btn btn-success">添加用户 <i class="icon-plus icon-white"></i></button></a>
                                      </div>
                                      <div class="btn-group pull-right">
                                      </div>
                                   </div>
                                    
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example2">
                                        <thead>
                                            <tr>
                                                <th>用户ID</th>
                                                <th>姓名</th>
                                                <th>电子邮件</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                           <c:forEach items="${userList }" var="user">
                                           	 <tr class="odd gradeX">
                                                <td>${user.id }</td>
                                                <td>${user.firstName }•${user.lastName }</td>
                                                <td>${user.email }</td>
                                                <td>
                                                	<button class="btn btn-success" data-key="${user.id }">删除</button>
                                                </td>
                                            </tr>
                                           </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
                </div>
     </div>
     
     <script src="<%=path %>/vendors/jquery-1.9.1.min.js"></script>
     <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
     <script src="<%=path %>/vendors/easypiechart/jquery.easy-pie-chart.js"></script>
     <script src="<%=path %>/assets/scripts.js"></script>
     <script src="<%=path %>/vendors/datatables/js/jquery.dataTables.min.js"></script>
     
</body>
</html>