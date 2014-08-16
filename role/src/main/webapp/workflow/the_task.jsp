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
                                <div class="muted pull-left">我的代办任务</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                   <div class="table-toolbar">
                                      <div class="btn-group" style="padding-bottom: 20px;">
                                      </div>
                                      <div class="btn-group pull-right">
                                      </div>
                                   </div>
                                    
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example2">
                                        <thead>
                                            <tr>
                                            	
                                                <th>任务名称</th>
                                                <th>任务创建时间</th>
                                                <th>任务优先级</th>
                                                <th>所属流程</th>
                                                <th>当前处理人</th>
                                                <th>最晚处理时间</th>
                                                <th>申请人</th> 
                                                <th>申请人邮件</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                           <c:forEach items="${taskList }" var="ut">
                                           	 <tr class="odd gradeX">
                                           	 	<td>${ut.task.name }</td>
                                           	 	<td>
                                           	 		<fmt:formatDate value="${ut.task.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                                           	 	</td>
                                           	 	<td>
                                           	 		<span class="badge badge-info">${ut.task.priority }</span>
                                           	 		
                                           	 	</td>
                                           	 	<td>${ut.processDefinition.name }</td>
                                                <td>${ut.task.assignee }</td>
                                                <td>${ut.task.dueDate }</td>
<%--                                                 <td> ${pd.category }</td> --%>
												<td>${ut.applyUser.firstName }${ut.applyUser.lastName }</td>
                                                <td>${ut.applyUser.email }</td>
                                                <td>
                                                	<button class="btn btn-warning startProcess" data-key="${pd.key }">查看流程处理图</button>
                                                	<button class="btn btn-success taskClaim" data-key="${ut.task.id}">处理</button>
                                                	
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
     <script type="text/javascript">
	  jQuery(function() {
    	 
    	 //开始，处理任务
 		$(".taskClaim").click(function (){
 			
 			var taskId = $(this).data("key");
 			location.href="<%=path %>/workflow/task/taskClaim.do?taskId=" + taskId;
 		 });
     });
     </script>
</body>
</html>