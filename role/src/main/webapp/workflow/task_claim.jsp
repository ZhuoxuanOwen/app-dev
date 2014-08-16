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
<style type="text/css">
	input{
		height: 35px;
	}
</style>
</head>
<body>
	  <jsp:include page="/common/head.jsp" />
	  <div class="row-fluid">
             <!-- block -->
             <div class="block">
                 <div class="navbar navbar-inner block-header">
                     <div class="muted pull-left">流程任务处理</div>
                 </div>
                 <div class="block-content collapse in">
                     <div class="span12">
                          <form id="frmProcessApply" class="form-horizontal" enctype="multipart/form-data" method="post" action="<%=path%>/workflow/processDef/deployeProcessByUpload.do">
                           <fieldset>
                             <div class="control-group">
                               <label class="control-label" for="focusedInput">流程信息</label>
                               <div class="controls">
                                  ${ut.processDefinition.category }•${ut.processDefinition.name }
                               </div>
                             </div>
                             <div class="control-group">
                               <label class="control-label" for="focusedInput">任务名称</label>
                               <div class="controls">
                                 ${ut.task.name }
                                 <input type="hidden" name="taskId" value="${ut.task.id }">
                               </div>
                             </div>
                             <div class="control-group">
                               <label class="control-label" for="focusedInput">任务描述</label>
                               <div class="controls">
                                 ${ut.task.description }
                               </div>
                             </div>
                             <div class="control-group">
                               <label class="control-label" for="focusedInput">任务提交人</label>
                               <div class="controls">
                                 ${ut.applyUser.firstName }${ut.applyUser.lastName } •  ${ut.applyUser.email }
                               </div>
                             </div>
                             <div class="control-group">
                               <label class="control-label" for="focusedInput">任务优先级</label>
                               <div class="controls">
                                 ${ut.task.priority }
                               </div>
                             </div>
                             <div class="control-group">
                               <label class="control-label" for="focusedInput">任务最晚处理时间</label>
                               <div class="controls">
                                 <fmt:formatDate value="${ut.task.dueDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
                               </div>
                             </div>
                             <div class="control-group">
                               <label class="control-label" for="focusedInput">任务创建时间</label>
                               <div class="controls">
                                	<fmt:formatDate value="${ut.task.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                               </div>
                             </div>
                             
                             
                             <c:forEach items="${formProperties }" var="column">
                             	<div class="control-group">
	                             	<label class="control-label" style="padding-top:0px;" for="focusedInput" >${column.name }</label>
		                            <div class="controls">
		                            	<input type="text" name="${column.id }" placeholder="${column.name }" value="${column.value }">
		                            </div>
		                         </div>
                             </c:forEach>
                             
                             <div class="form-actions">
                               <button id="btnProcessApply" type="button" class="btn btn-primary">提交</button>
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
	        	//提交流程数据，表单数据
	        	$("#btnProcessApply").click(function (){
	        		
	        		if(!confirm("确定要提交申请吗？")){
	        			return;
	        		}
	        		
	        		var param = $("#frmProcessApply").serialize();
	    			$.ajax({
	    					type : 'post',
	    					url : '<%=path%>/workflow/runtime/startProcess.do',
	    					data : param,
	    					dataType : 'json',
	    					contentType : "application/x-www-form-urlencoded;charset=UTF-8",
	    					success : function(data) {
	    						if (data.success) {
	    							alert("流程提交成功！");
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
</body>
</html>